package com.ce.krf.biz.mapper;

import java.util.List;
import java.util.Map;

import com.ce.krf.biz.model.ClickLogVO;
import com.ce.krf.biz.model.SampleVO;


public interface SampleMapper {
	public List<Map<String, Object>> getLabelLayerAdmin(String gubun);
	public List<Map<String, Object>> getLabelLayerAdminForPost(SampleVO param);
	
	public int putSessionIp(String param);
	public int putClickLog(ClickLogVO param);
	public int putClickLogs(SampleVO param);
	
	public List<Map<String, Object>> getRWMDT(String recordId);
}
