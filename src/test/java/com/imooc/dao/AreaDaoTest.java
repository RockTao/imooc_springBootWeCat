package com.imooc.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.entry.Area;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
	
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testQueryArea() {
		
		List<Area> list=	areaDao.queryArea();
		assertEquals(2, list.size());
	}

	@Test
	public void testQueryAreaById() {
		Area area=areaDao.queryAreaById(5);
//		assertEquals("北苑", area.getAreaName());
		System.out.println(area);
	}

	@Test
	public void testInsertArea() {
		Area area = new Area();
		area.setAreaName("南苑");
		area.setPriority(1);
		int effectNum= areaDao.insertArea(area);
		assertEquals(1, effectNum);
	}

	@Test
	public void testUpdateArea() {
		Area area = new Area();
		area.setAreaName("西苑");
		area.setAreaId(3);
		area.setLastEditTime(new Date());
		int effectNum= areaDao.updateArea(area);
		assertEquals(1, effectNum);
	}

	@Test
	public void testDeleteArea() {
		int effectNum=	areaDao.deleteArea(3);
		assertEquals(1, effectNum);
	}

}
