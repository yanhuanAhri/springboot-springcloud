package com.example.consumerDemo.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



@Service
public class MonitorDataService {
	
	  @Autowired
	  RestTemplate restTemplate;
	  
	  @Value("${host.url}")
	  private String hostUrl;
		

	  public Map<String,Object> getMonitorData(String id) {
		 String url=hostUrl+"/monitorData/{id}";
		 Map<String,Object> result=restTemplate.getForObject(url, Map.class,id);
		return result;
	  }
	  
	  public void deleteMonitorData(String id) {
		  String url=hostUrl+"/monitorData/{id}";
		  restTemplate.delete(url,id);
	  }
	  
	  public Integer saveorupdateMonitorData(Map<String,Object> datas) {
		  String url=hostUrl+"/monitorData/save";
		  HttpEntity<Map<String,Object>> entity=new HttpEntity<>(datas);
		  int i=  restTemplate.postForEntity(url, entity, Integer.class).getBody();
		  return i;
	  }
	  
}
