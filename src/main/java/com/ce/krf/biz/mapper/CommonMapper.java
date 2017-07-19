package com.ce.krf.biz.mapper;

import java.util.List;
import java.util.Map;

import com.ce.krf.biz.model.ClickLogVO;

public interface CommonMapper {

	public int clickSession(ClickLogVO clickLogVO);
	public List<Map<String, Object>> getLabelLayerAdmin(String gubun);
}
