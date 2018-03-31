package com.ce.krf.biz.model;

import java.io.Serializable;

public class ChartVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5273705657731656135L;

	private String recordId;
	
	private String parentId;
	
	private String hMaxDate;
	
	private String recordYear;
	private String recordYear2;
	private String recordMonth;
	private String recordMonth2;
	
	private String defaultChart;
	private String selectItem;
	
	private String nextFullDate;
	private String preFullDate;
	
	public String getRecordYear() {
		return recordYear;
	}
	public void setRecordYear(String recordYear) {
		this.recordYear = recordYear;
	}
	public String getRecordYear2() {
		return recordYear2;
	}
	public void setRecordYear2(String recordYear2) {
		this.recordYear2 = recordYear2;
	}
	public String getRecordMonth() {
		return recordMonth;
	}
	public void setRecordMonth(String recordMonth) {
		this.recordMonth = recordMonth;
	}
	public String getRecordMonth2() {
		return recordMonth2;
	}
	public void setRecordMonth2(String recordMonth2) {
		this.recordMonth2 = recordMonth2;
	}
	
	
	public String getPreFullDate() {
		return preFullDate;
	}
	public void setPreFullDate(String preFullDate) {
		this.preFullDate = preFullDate;
	}
	public String getNextFullDate() {
		return nextFullDate;
	}
	public void setNextFullDate(String nextFullDate) {
		this.nextFullDate = nextFullDate;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getDefaultChart() {
		return defaultChart;
	}
	public void setDefaultChart(String defaultChart) {
		this.defaultChart = defaultChart;
	}
	public String getSelectItem() {
		return selectItem;
	}
	public void setSelectItem(String selectItem) {
		this.selectItem = selectItem;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String gethMaxDate() {
		return hMaxDate;
	}
	public void sethMaxDate(String hMaxDate) {
		this.hMaxDate = hMaxDate;
	}
	
	
	
}
