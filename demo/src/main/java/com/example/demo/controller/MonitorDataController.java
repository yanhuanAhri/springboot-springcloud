package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MonitorDataService;

@RestController
@RequestMapping("/monitorData")
public class MonitorDataController {
	
	@Autowired
	private MonitorDataService monitorDataService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Map<String,Object> findById(@PathVariable String id) {
	//	String id="7C2992B215054C1EE055000000000001";
		return monitorDataService.findById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Integer deleteById(@PathVariable String id) {
		return monitorDataService.deleteById(id);
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public Integer saveMonitorData(@RequestBody Map<String,Object> datas) {
		return monitorDataService.saveMonitorData(datas);
	}

}
