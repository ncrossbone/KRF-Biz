package com.ce.krf.biz.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {
	
	@Autowired
	public HttpServletRequest request;
	
	@Autowired
	public HttpServletResponse response;
	
	public ObjectMapper om = new ObjectMapper();
	
}
