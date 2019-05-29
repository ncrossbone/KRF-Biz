package com.ce.krf.biz.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ce.krf.biz.model.ChartVO;

public interface ChartMapper {
	public List<Map<String, Object>> getRWMDT(@Param("recordId") String recordId ,@Param("parentId") String parentId);
	
	
	public int insertChartPram(ChartVO param);
	
	public List getRWMDTSelectA(ChartVO param);
	public List getRWMDTSelect2018A(ChartVO param);
	public List getRWMDTSelect2018B(ChartVO param);
	
	
	public List getRWMDTSelectB(ChartVO param);
	public List getRWMDTSelectC(ChartVO param);
	
	public List getRWMDTSelectD001(ChartVO param);
	public List getRWMDTSelectD002(ChartVO param);
	public List getRWMDTSelectD003(ChartVO param);
	public List getRWMDTSelectD004(ChartVO param);
	public List getRWMDTSelectD005(ChartVO param);
	public List getRWMDTSelectD006(ChartVO param);
	public List getRWMDTSelectD007(ChartVO param);
	
	public List getRWMDTSelectF_1(ChartVO param);
	public List getRWMDTSelectF_2(ChartVO param);
	public List getRWMDTSelectF_3(ChartVO param);
	public List getRWMDTSelectF_4(ChartVO param);
	
	public List getRWMDTSelectI(ChartVO param);
	
	public List getRWMDTSelectH(ChartVO param);
	public List getRWMDTSelectHDate(ChartVO param);
	
	public List getRWMDTSelectM001(ChartVO param);
	public List getRWMDTSelectM002(ChartVO param);
	
	public List getRWMDTSelect2018L(ChartVO param);
	
}
