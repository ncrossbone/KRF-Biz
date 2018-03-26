package com.ce.krf.biz.model;

import java.io.Serializable;

public class PollutionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3525947815694766420L;
	
	private String catDid = null;
	private String[] catDids = null;
	private String year = null;
	public String getCatDid() {
		return catDid;
	}
	public void setCatDid(String catDid) {
		this.catDid = catDid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String[] getCatDids() {
		return catDids;
	}
	public void setCatDids(String[] catDids) {
		this.catDids = catDids;
	}
	
	
}
