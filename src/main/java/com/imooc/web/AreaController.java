package com.imooc.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.entry.Area;
import com.imooc.service.AreaService;

@RestController
@RequestMapping("/superAdmin")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	
	@RequestMapping(value="/listArea",method=RequestMethod.GET)
	private Map<String,Object> listArea(){
		Map<String,Object> modelMap= new HashMap<>();
		List<Area> list = areaService.getAreaList();
		modelMap.put("areaList", list);
		return modelMap;
	}
	
	@RequestMapping(value="/getAreaId",method=RequestMethod.GET)
	private Map<String,Object> listArea(Integer areaId){
		Map<String,Object> modelMap= new HashMap<>();
		Area area=areaService.getAreaById(areaId);
		modelMap.put("area", area);
		return modelMap;
	}
	@RequestMapping(value = "/addarea", method = RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody Area area)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", areaService.addArea(area));
		return modelMap;
	}
	@RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody Area area)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", areaService.modifyArea(area));
		return modelMap;
	}

	@RequestMapping(value = "/removearea", method = RequestMethod.GET)
	private Map<String, Object> removeArea(Integer areaId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", areaService.deleteArea(areaId));
		return modelMap;
	}
}
