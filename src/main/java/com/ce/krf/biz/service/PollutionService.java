package com.ce.krf.biz.service;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.PollutionMapper;
import com.ce.krf.biz.model.PollutionVO;

@Component
public class PollutionService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public PollutionMapper pollutionMapper;

	public List pollutionSelect(String index, PollutionVO param) throws Exception {
		param.setCatDids(param.getCatDid().split(","));
		Method method = pollutionMapper.getClass().getMethod("pollutionSelect" + index, PollutionVO.class);
		List result = (List) method.invoke(pollutionMapper, param);
		return result;
	}
}
