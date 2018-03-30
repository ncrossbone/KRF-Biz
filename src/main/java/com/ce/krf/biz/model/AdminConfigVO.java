package com.ce.krf.biz.model;

public class AdminConfigVO {

	private String userId;
	private String regUserId;
	
	private int layerSetId;
	private String layerSetName;
	private String layerSetIds;
	
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getLayerSetId() {
		return layerSetId;
	}
	public void setLayerSetId(int layerSetId) {
		this.layerSetId = layerSetId;
	}
	public String getLayerSetName() {
		return layerSetName;
	}
	public void setLayerSetName(String layerSetName) {
		this.layerSetName = layerSetName;
	}
	public String getLayerSetIds() {
		return layerSetIds;
	}
	public void setLayerSetIds(String layerSetIds) {
		this.layerSetIds = layerSetIds;
	}
	
	

}
