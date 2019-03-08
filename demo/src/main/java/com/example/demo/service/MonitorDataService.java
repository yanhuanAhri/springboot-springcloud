package com.example.demo.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MonitorData;

@Service
public interface MonitorDataService {
	
	
	Map<String,Object> findById(String id);
    
    Integer deleteById(String id);
    
    Integer saveMonitorData(@Param("monitorData")Map<String,Object> datas);
    
  //  Integer updateMonitorData(@Param("monitorData")MonitorData monitorData);
}
