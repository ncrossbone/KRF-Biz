package com.ce.krf.biz.model;

import java.io.Serializable;
import java.util.List;

public class AdminConfigVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522913074271097058L;
	private String userId;
	private String userPass;
	private String regUserId;
	
	private int layerSetId;
	private String layerSetName;
	private String layerSetIds;
	
	private String river;
	private String droneLayerId;
	private String droneDate;
	private String measureDate;
	private String chlaLayerId;
	private String chlaDate;
	private String phyLayerId;
	private String phyDate;
	private String blueLayerId;
	private String blueDate;
	private String etc;
	
	private List<AdminConfigVO> data;
	
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
	public String getRiver() {
		return river;
	}
	public void setRiver(String river) {
		this.river = river;
	}
	public String getDroneLayerId() {
		return droneLayerId;
	}
	public void setDroneLayerId(String droneLayerId) {
		this.droneLayerId = droneLayerId;
	}
	public String getDroneDate() {
		return droneDate;
	}
	public void setDroneDate(String droneDate) {
		this.droneDate = droneDate;
	}
	public String getMeasureDate() {
		return measureDate;
	}
	public void setMeasureDate(String measureDate) {
		this.measureDate = measureDate;
	}
	public String getChlaLayerId() {
		return chlaLayerId;
	}
	public void setChlaLayerId(String chlaLayerId) {
		this.chlaLayerId = chlaLayerId;
	}
	public String getChlaDate() {
		return chlaDate;
	}
	public void setChlaDate(String chlaDate) {
		this.chlaDate = chlaDate;
	}
	public String getPhyLayerId() {
		return phyLayerId;
	}
	public void setPhyLayerId(String phyLayerId) {
		this.phyLayerId = phyLayerId;
	}
	public String getPhyDate() {
		return phyDate;
	}
	public void setPhyDate(String phyDate) {
		this.phyDate = phyDate;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public List<AdminConfigVO> getData() {
		return data;
	}
	public void setData(List<AdminConfigVO> data) {
		this.data = data;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getBlueLayerId() {
		return blueLayerId;
	}
	public void setBlueLayerId(String blueLayerId) {
		this.blueLayerId = blueLayerId;
	}
	public String getBlueDate() {
		return blueDate;
	}
	public void setBlueDate(String blueDate) {
		this.blueDate = blueDate;
	}
	
	

}
