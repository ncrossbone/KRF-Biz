package com.ce.krf.biz.service;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import com.ce.krf.biz.mapper.ChartMapper;
import com.ce.krf.biz.model.ChartVO;

@Component
public class ChartService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5808553354195495995L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public ChartMapper chartMapper;
	
	public HashMap getRWMDT(String recordId,String parentId) {
		HashMap res = new HashMap<String, Object>();
		res.put("data", chartMapper.getRWMDT(recordId ,parentId));
		return res;
	}
	
	public HashMap getInfo(String index,ChartVO param) throws Exception {
		Method method = chartMapper.getClass().getMethod("getInfo_" + index,ChartVO.class);
		List result = (List) method.invoke(chartMapper,param);
		HashMap reMap = new HashMap();
		reMap.put("data",result);
		return reMap;
	}
	
	public HashMap getRWMDTSelect(String index,ChartVO param) throws Exception {
		
		if(param.getDefaultChart()!=null && param.getDefaultChart().equals("0")) {
			param.setPreFullDate(param.getRecordYear() + param.getRecordMonth());
			param.setNextFullDate(param.getRecordYear2() + param.getRecordMonth2());
		}
		
		if("M".equals(index)) {
			String [] splitParam = param.getRecordId().split("_");
			index = splitParam[0];
			param.setRecordId(splitParam[1]);
		}
		
		Method method = chartMapper.getClass().getMethod("getRWMDTSelect" + index,ChartVO.class);
		List result = (List) method.invoke(chartMapper,param);
		HashMap reMap = new HashMap();
		reMap.put("data", (result.size()>1)? result.subList(0, result.size()-1) : new ArrayList());
		reMap.put("maxdata", result.subList(result.size()-1, result.size()));
		return reMap;
	}
	
	public HashMap getRWMDTSelect2018(String index,ChartVO param) throws Exception {
		
		param.setPreFullDate(param.getRecordYear() + param.getRecordMonth());
		param.setNextFullDate(param.getRecordYear2() + param.getRecordMonth2());
		
		if("M".equals(index)) {
			String [] splitParam = param.getRecordId().split("_");
			index = splitParam[0];
			param.setRecordId(splitParam[1]);
		}
		
		int chartParam = chartMapper.insertChartPram(param);
		
		Method method = chartMapper.getClass().getMethod("getRWMDTSelect2018" + index,ChartVO.class);
		List result = (List) method.invoke(chartMapper,param);
		HashMap reMap = new HashMap();
		reMap.put("data", (result.size()>1)? result.subList(0, result.size()-1) : new ArrayList());
		reMap.put("maxdata", result.subList(result.size()-1, result.size()));
		
		return reMap;
	}
	
}
