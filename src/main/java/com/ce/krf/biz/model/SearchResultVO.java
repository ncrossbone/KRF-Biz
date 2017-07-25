package com.ce.krf.biz.model;

public class SearchResultVO {
	
	
	private String catDid = "";
	private String[] catDids = null;
	private String year = "";
	
	//수질자동측정지점 미확정 / 확정 날짜
	private String startFull = "";
	private String endFull = "";
	
	private String gubun = "";
	
	private String siteId = "";
	private String[] siteIds = null;
	private String start = "";
	private String end = "";
	
	private String startYear = "";
	private String startMonth = "";
	private String endYear = "";
	private String endMonth = "";
	
	
	private String firstSearch = "";
	
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
