package com.ce.krf.biz.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.ChartMapper;
import com.ce.krf.biz.model.ChartVO;

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
	
	public List getRWMDTSelect(String index,ChartVO param) throws Exception {
		
		if(param.getDefaultChart()!=null && param.getDefaultChart().equals("0")) {
			param.setPreFullDate(param.getSelectYear() + param.getSelectMonth());
			param.setNextFullDate(param.getSelectYear2() + param.getSelectMonth2());
		}
		
		Method method = chartMapper.getClass().getMethod("getRWMDTSelect" + index,ChartVO.class);
		List result = (List) method.invoke(chartMapper,param);
		return result;
	}
}
