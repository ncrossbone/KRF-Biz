package com.ce.krf.biz.mapper;

import java.util.List;
import java.util.Map;

import com.ce.krf.biz.model.ChartVO;

public interface ChartMapper {
	public List<Map<String, Object>> getRWMDT(String siteCd);
	
	public List getRWMDTSelectA(ChartVO param);
	public List getRWMDTSelectB(ChartVO param);
	public List getRWMDTSelectC(ChartVO param);
	
	public List getRWMDTSelectD001(ChartVO param);
	public List getRWMDTSelectD002(ChartVO param);
	public List getRWMDTSelectD003(ChartVO param);
	public List getRWMDTSelectD004(ChartVO param);
}
