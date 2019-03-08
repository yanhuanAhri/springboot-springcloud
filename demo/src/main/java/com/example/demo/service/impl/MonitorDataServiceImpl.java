package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.MonitorData;
import com.example.demo.mapper.MonitorDataMapper;
import com.example.demo.service.MonitorDataService;
import com.example.demo.util.MapUitls;
import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

@Component
public class MonitorDataServiceImpl implements MonitorDataService {


	
	@Autowired
	private MonitorDataMapper monitorDataMapper;
	

	@Override
	public Map<String,Object> findById(String id) {
		// TODO Auto-generated method stub
		MonitorData data=monitorDataMapper.findById(id);
		
		Map<String, Object> map = new HashMap<>();
		try {
			//monitorData对象转为Map对象
			map = (Map<String, Object>) MapUitls.objectToMap(data);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Integer deleteById(String id) {
		// TODO Auto-generated method stub
		int i = monitorDataMapper.deleteById(id);
		System.out.println("删除的行数为-------------------------------i："+i);
		return i;
	}

	@Override
	public Integer saveMonitorData(Map<String,Object> datas) {
		System.out.println(datas);
		int i=0;
		if(datas==null) {
			return i;
		}
		try {
			 JSONObject json = JSONObject.fromObject(datas);
			 MonitorData monitorData=(MonitorData)JSONObject.toBean(json, MonitorData.class);
			if(monitorData.getId()==null || monitorData.getId().equals("null")) {
				i=monitorDataMapper.saveMonitorData(monitorData);
			}else {
				i=monitorDataMapper.updateMonitorData(monitorData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
