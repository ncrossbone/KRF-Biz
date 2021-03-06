package com.ce.krf.biz.model;

import java.io.Serializable;

public class SearchResultVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5947786358108450238L;

	private String year = "";
	
	//수질자동측정지점 미확정 / 확정 날짜
	private String startFull = "";
	private String endFull = "";
	
	private String con = "";
	
	private String catDid = "";
	private String[] catDids = null;
	
	private String gubun = "";
	
	private String siteId = "";
	private String[] siteIds = null;
	private String[] siteIdsChar = null;
	private String siteId2 = "";
	
	private String parentSiteIds = "";
	
	private String[] detailSiteIds = null;
	private String detailSiteIds2 = "";
	private String groupCode = "";
	
	private String startYear = "";
	private String startMonth = "";
	private String startDay = "";
	private String endYear = "";
	private String endMonth = "";
	private String endDay = "";
	
	private String comboValue = "";
	
	private String boCode = "";
	private String spotCode = "";
	private String brrerCode = "";
	
	private String fileGubun = "";
	private String textField = "";
	
	
	private String item = "";
	
	private String firstSearch = "";
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getCatDid() {
		return catDid;
	}
	public void setCatDid(String catDid) {
		this.catDid = catDid;
	}
	public String[] getCatDids() {
		return catDids;
	}
	public void setCatDids(String[] catDids) {
		this.catDids = catDids;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getComboValue() {
		return comboValue;
	}
	public void setComboValue(String comboValue) {
		this.comboValue = comboValue;
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
		setSiteIds();
	}
	
	public String getStartFull() {
		return startFull;
	}
	public void setStartFull(String startFull) {
		this.startFull = startFull;
		this.startFull = getRPad(startFull, 42, ' ');
	}
	public String getEndFull() {
		return endFull;
	}
	public void setEndFull(String endFull) {
		this.endFull = endFull;
		this.endFull = getRPad(endFull, 42, ' ');
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

	public void setSiteIds () {
		if (siteIds != null && siteIds.length > 0) {
			for (int i = 0; i < siteIds.length; i++) {
				siteIds[i] = siteIds[i].replaceAll("'", "");
			}
		}
	}
	
	
	public void setSiteIdsChar () {
		if (siteIdsChar != null && siteIdsChar.length > 0) {
			for (int i = 0; i < siteIdsChar.length; i++) {
				siteIdsChar[i] = siteIdsChar[i].replaceAll("'", "");
				
				siteIdsChar[i] = getRPad(siteIdsChar[i], 18, ' ');
				
			}
		}
	}
	
	public static String getRPad(String str, int size, char c) {
        for(int i = (str.getBytes()).length; i < size; i++) {
            str += c;
        }
        return str;
    }
	
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getBoCode() {
		return boCode;
	}
	public void setBoCode(String boCode) {
		this.boCode = boCode;
	}
	public String getSpotCode() {
		return spotCode;
	}
	public void setSpotCode(String spotCode) {
		this.spotCode = spotCode;
	}
	public String getBrrerCode() {
		return brrerCode;
	}
	public void setBrrerCode(String brrerCode) {
		this.brrerCode = brrerCode;
	}
	public String getFileGubun() {
		return fileGubun;
	}
	public void setFileGubun(String fileGubun) {
		this.fileGubun = fileGubun;
	}
	public String getTextField() {
		return textField;
	}
	public void setTextField(String textField) {
		this.textField = textField;
	}
	public String getSiteId2() {
		return siteId2;
	}
	public void setSiteId2(String siteId2) {
		this.siteId2 = siteId2;
	}
	
	public String getDetailSiteIds2() {
		return detailSiteIds2;
	}
	public void setDetailSiteIds2(String detailSiteIds2) {
		this.detailSiteIds2 = detailSiteIds2;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String[] getDetailSiteIds() {
		return detailSiteIds;
	}
	public void setDetailSiteIds(String[] detailSiteIds) {
		this.detailSiteIds = detailSiteIds;
	}
	public String getParentSiteIds() {
		return parentSiteIds;
	}
	public void setParentSiteIds(String parentSiteIds) {
		this.parentSiteIds = parentSiteIds;
	}
	public String[] getSiteIdsChar() {
		return siteIdsChar;
	}
	public void setSiteIdsChar(String[] siteIdsChar) {
		this.siteIdsChar = siteIdsChar;
		setSiteIdsChar();
	}
	
	
	
	
}
