package com.example.consumerDemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerDemo.service.MonitorDataService;

@RestController
@RequestMapping("/monitorData")
public class MonitorDataController {

	@Autowired
	private MonitorDataService monitorDataService;
	
	@GetMapping("getMonitorData")
	public Map<String,Object> findById(@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) {
			return monitorDataService.getMonitorData(id);
	}
	
	@DeleteMapping("deleteMonitoData")
	public void deleteById(@RequestParam("id")String id,HttpServletRequest request,HttpServletResponse response) {
		monitorDataService.deleteMonitorData(id);
	}
	
	@PostMapping("saveOrupdate")
	public Integer saveOrUpdateMonitorDatas(@RequestBody Map<String,Object>  datas,HttpServletRequest request,HttpServletResponse response) {
		return monitorDataService.saveorupdateMonitorData(datas);
		
	}
	/*@RequestMapping("/getUserList")
    public List<String> getUserList() {
        return monitorDataService.getOrderByUserList();
    }*/
   

}
