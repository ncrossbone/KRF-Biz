package com.ce.krf.biz.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.ChartMapper;

@Component
public class ChartService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public ChartMapper chartMapper;
	
	
	public Map<String, Object> getRWMDT(String siteCd) {
		HashMap res = new HashMap<String, Object>();
		res.put("datas", chartMapper.getRWMDT(siteCd));
		return res;
	}
}
