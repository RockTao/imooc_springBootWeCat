package com.imooc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.entry.Area;

public interface AreaDao {
	/**
	 * 列出区域列表
	 * @return
	 */
	List<Area> queryArea();
	/**
	 * 根据id列出具体区域
	 * @param areaId
	 * @return
	 */
	Area queryAreaById(@Param("areaId")Integer areaId);
	/**
	 * 插入区域信息
	 * @param area
	 * @return
	 */
	int insertArea(Area area);
	/**
	 * 跟新区域信息
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	/**
	 * 删除区域信息
	 * @param areaId
	 * @return
	 */
	int deleteArea(@Param("areaId")Integer areaId);
	
}
