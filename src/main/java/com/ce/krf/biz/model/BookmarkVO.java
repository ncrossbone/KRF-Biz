package com.ce.krf.biz.model;

import java.io.Serializable;

public class BookmarkVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257095621276351792L;
	private String userId;
	private String data;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
