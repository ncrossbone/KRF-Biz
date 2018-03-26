package com.ce.krf.biz.model;

import java.io.Serializable;

public class ImageVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1677490227358545887L;
	
	private String resultParam;
	private String svgParam;
	private String pngParam;
	
	public String getResultParam() {
		return resultParam;
	}
	public void setResultParam(String resultParam) {
		this.resultParam = resultParam;
	}
	public String getSvgParam() {
		return svgParam;
	}
	public void setSvgParam(String svgParam) {
		this.svgParam = svgParam;
	}
	public String getPngParam() {
		return pngParam;
	}
	public void setPngParam(String pngParam) {
		this.pngParam = pngParam;
	}
	
	
	
}
