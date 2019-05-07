package com.ce.krf.biz.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.PollLoadMapper;
import com.ce.krf.biz.model.PollutionVO;

@Component
public class PollLoadService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5422222045914876097L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public PollLoadMapper pollLoadMapper;
	
	
	public HashMap pollLoadSelect(PollutionVO param) throws Exception{
		
		HashMap result = new HashMap();
		List resultList = null;
		param.setCatDids(param.getCatDid().split(","));
		resultList = pollLoadMapper.PollLoadSelect(param);
		result.put("data", resultList);
		return result;
	}
}
