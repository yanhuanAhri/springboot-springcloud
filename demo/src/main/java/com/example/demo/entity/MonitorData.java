package com.example.demo.entity;

import java.util.Date;


public class MonitorData {
	private String id;
	private String monitorId;
	private String datas;
	private String templateId;
	private Date createtm;
	private Date proctm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}
	public String getDatas() {
		return datas;
	}
	public void setDatas(String datas) {
		this.datas = datas;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public Date getCreatetm() {
		return createtm;
	}
	public void setCreatetm(Date createtm) {
		this.createtm = createtm;
	}
	public Date getProctm() {
		return proctm;
	}
	public void setProctm(Date proctm) {
		this.proctm = proctm;
	}
	
	

}
