package com.ce.krf.biz.model;

public class SearchResultVO {
	
	
	private String catDid = null;
	private String[] catDids = null;
	private String year = null;
	
	//수질자동측정지점 미확정 / 확정 날짜
	private String startFull = null;
	private String endFull = null;
	
	private String gubun = null;
	
	private String siteId = null;
	private String[] siteIds = null;
	private String start = null;
	private String end = null;
	
	private String startYear = null;
	private String startMonth = null;
	private String endYear = null;
	private String endMonth = null;
	
	
	private String firstSearch = null;
	
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
	
	
	
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String[] getSiteIds() {
		return siteIds;
	}
	public void setSiteIds(String[] siteIds) {
		this.siteIds = siteIds;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getStartFull() {
		return startFull;
	}
	public void setStartFull(String startFull) {
		this.startFull = startFull;
	}
	public String getEndFull() {
		return endFull;
	}
	public void setEndFull(String endFull) {
		this.endFull = endFull;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getFirstSearch() {
		return firstSearch;
	}
	public void setFirstSearch(String firstSearch) {
		this.firstSearch = firstSearch;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	
	
}
