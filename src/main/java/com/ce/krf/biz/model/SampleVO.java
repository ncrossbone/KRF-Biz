package com.ce.krf.biz.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7467050765108665513L;

	private String gubun = null;
	
	// 샘플이라 대문자로 함 카멜표기법으로 하는걸 권장함
	private String PT_NO = null;
	
	private String VAL = null;
	
	// 리스트로 파라메터를 받고싶을때
	private List<ClickLogVO> logList = null;
	
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	@JsonProperty("PT_NO")
	public String getPT_NO() {
		return PT_NO;
	}
	public void setPT_NO(String pt_no) {
		PT_NO = pt_no;
	}
	public String getVAL() {
		return VAL;
	}
	public void setVAL(String val) {
		VAL = val;
	}
	public List<ClickLogVO> getLogList() {
		return logList;
	}
	public void setLogList(List<ClickLogVO> logList) {
		this.logList = logList;
	}
	
}
