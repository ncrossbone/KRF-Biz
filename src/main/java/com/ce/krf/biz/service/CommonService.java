package com.ce.krf.biz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.CommonMapper;
import com.ce.krf.biz.model.ClickLogVO;

@Component
public class CommonService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public CommonMapper commonMapper;
	
	public int clickSession(ClickLogVO clickLogVO) {
		// TODO Auto-generated method stub
		return commonMapper.clickSession(clickLogVO);
	}
}
