package com.ce.krf.biz.model;

import java.util.HashMap;

public class ResultVO {

	// 1 = 성공, 0 = 실패
	private int code = 0;
	private String mgs = null;
	
	private HashMap<String, Object> datas = null;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMgs() {
		return mgs;
	}

	public void setMgs(String mgs) {
		this.mgs = mgs;
	}

	public HashMap<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(HashMap<String, Object> datas) {
		this.datas = datas;
	}
	
}
