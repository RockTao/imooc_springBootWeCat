package com.imooc.service.impl;

import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.dao.AreaDao;
import com.imooc.entry.Area;
import com.imooc.service.AreaService;
@Service
public class AreaServiceImpl  implements AreaService{
	@Autowired
	private AreaDao areaDao;
	

	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

	@Override
	public Area getAreaById(Integer areaId) {
		return areaDao.queryAreaById(areaId);
	}
	@Transactional //(rollbackFor=Exception.class)
	@Override
	public boolean addArea(Area area) {
		System.out.println("area=" + area.toString());
		if (area.getAreaName() != null && !"".equals(area.getAreaName())) {		
			area.setCreateTime(new Date());
		
			area.setLastEditTime(new Date());
			try {
				int effectNum= areaDao.insertArea(area);
				if(effectNum > 0  ) {
					return true;
				}else {
					throw new RuntimeException("插入信息失败！！！");
				}
			}catch (Exception e) {
				throw new RuntimeException("插入信息失败！！！" + e.getMessage());
			}
		}else {
			throw new RuntimeException("区域信息不能为空！！！");
		}
	}

	@Override
	public boolean modifyArea(Area area) {
		if(area.getAreaId() !=null && area.getAreaId() > 0) {
			area.setLastEditTime(new Date());
			try {
				int effectNum= areaDao.updateArea(area);
				if(effectNum > 0  ) {
					return true;
				}else {
					throw new RuntimeException("跟新区域信息失败！！！");
				}
			}catch (Exception e) {
				throw new RuntimeException("跟新区域信息失败！！！" + e.getMessage());
			}
		}else {
			throw new RuntimeException("跟新区域信息失败！！！");
		}
	}

	public boolean deleteArea(Integer areaId) {
		if (areaId > 0) {
			try {
				// 删除区域信息
				int effectedNum = areaDao.deleteArea(areaId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除区域信息失败!");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除区域信息失败:" + e.toString());
			}
		} else {
			throw new RuntimeException("区域Id不能为空！");
		}
	}
	
	

}
