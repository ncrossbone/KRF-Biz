package com.ce.krf.biz.model;

import java.io.Serializable;

public class ClickLogVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7356550740333992167L;
	
	private String ip = null;
	private String type = null;
	private String node = null;
	private String parentId = null;
	private String data = null;
	private String id = null;
	private String system = null;
	private String userId = null;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
