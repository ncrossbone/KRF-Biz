package com.ce.krf.biz.base;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {

	@Autowired
	public HttpServletRequest request;

	@Autowired
	public HttpServletResponse response;

	public ObjectMapper om = new ObjectMapper();

	public String getEuckrString(HashMap src) throws Exception {
		String res = om.writeValueAsString(src);
		return new String(res.getBytes(), "EUC-KR");
	}

	public String getEuckrString(String src) throws Exception {
		return new String(src.getBytes(), "EUC-KR");
	}
}
