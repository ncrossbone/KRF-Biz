package com.ce.krf.biz.model;

public class DroneVO {

	private String[] siteCodes = null;
	private String measureDate = null;
	private String layerDate = null;
	
	private String ptNo = null;
	
	public String[] getSiteCodes() {
		return siteCodes;
	}
	public void setSiteCodes(String[] siteCodes) {
		this.siteCodes = siteCodes;
	}
	public String getMeasureDate() {
		return measureDate;
	}
	public void setMeasureDate(String measureDate) {
		this.measureDate = measureDate;
	}
	public String getLayerDate() {
		return layerDate;
	}
	public void setLayerDate(String layerDate) {
		this.layerDate = layerDate;
	}
	public String getPtNo() {
		return ptNo;
	}
	public void setPtNo(String ptNo) {
		this.ptNo = ptNo;
	}
	
}
