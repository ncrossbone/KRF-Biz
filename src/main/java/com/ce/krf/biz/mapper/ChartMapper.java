package com.ce.krf.biz.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ce.krf.biz.model.ChartVO;

public interface ChartMapper {
	public List<Map<String, Object>> getRWMDT(@Param("recordId") String recordId ,@Param("parentId") String parentId);
	
	
	public int insertChartPram(ChartVO param);
	public int insertChartPramK(ChartVO param);
	
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
	
	public List getRWMDTSelectQ(ChartVO param);
	
	public List getRWMDTSelect2018L(ChartVO param);
	
	public List getRWMDTSelect2018K(ChartVO param);
	
	public List getInfo_L(ChartVO param);
	public List getInfo_Q(ChartVO param);
	public List getInfo_Z(ChartVO param);
	
	public List getRWMDTSelect2018Z001(ChartVO param);
	public List getRWMDTSelect2018Z002(ChartVO param);
	public List getRWMDTSelect2018Z003(ChartVO param);
	public List getRWMDTSelect2018Z004(ChartVO param);
	public List getRWMDTSelect2018Z005(ChartVO param);
	public List getRWMDTSelect2018Z006(ChartVO param);
	
	public List getRWMDTSelect2018D001(ChartVO param);
	public List getRWMDTSelect2018D002(ChartVO param);
	public List getRWMDTSelect2018D003(ChartVO param);
	public List getRWMDTSelect2018D004(ChartVO param);
	public List getRWMDTSelect2018D005(ChartVO param);
	public List getRWMDTSelect2018D006(ChartVO param);
	public List getRWMDTSelect2018D007(ChartVO param);
	
	public List getRWMDTSelect2018I(ChartVO param);
	
	public List getRWMDTSelect2018F_1(ChartVO param);
	public List getRWMDTSelect2018F_3(ChartVO param);
	
	public List getRWMDTSelect2018C(ChartVO param);
	
	public List getRWMDTSelect2018E003(ChartVO param);
	public List getRWMDTSelect2018E004(ChartVO param);
	
	public List getSstgInfo(ChartVO param);
	public List getSstgInfoD(ChartVO param);
	
	
	public int insertSstgInfo(ChartVO param);
}
