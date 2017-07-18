package com.ce.krf.biz.model;

public class ResultVO {

	// 1 = 성공, 0 = 실패
	private int code = 0;
	private String mgs = null;
	
	private Object datas = null;

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

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}
	
}
