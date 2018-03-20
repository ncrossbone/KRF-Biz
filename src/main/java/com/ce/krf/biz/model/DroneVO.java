package com.ce.krf.biz.model;

import java.io.Serializable;

public class DroneVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3206414062504522467L;
	
	private String[] siteCodes = null;
	private String measureDate = null;
	private String layerDate = null;
	
	private String ptNo = null;
	
	public String[] getSiteCodes() {
		return siteCodes;
	}
	public void setSiteCodes(String[] siteCodes) {
		if (siteCodes != null && siteCodes.length > 0) {
			for (int i = 0; i < siteCodes.length; i++) {
				siteCodes[i] = siteCodes[i].replaceAll("'", "").trim();
			}
		}
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
