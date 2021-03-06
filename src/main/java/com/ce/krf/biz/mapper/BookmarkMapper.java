package com.ce.krf.biz.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;



public interface BookmarkMapper {
	public List<Map<String, Object>> getBookmark(String userId);
	public int putBookmark(HashMap<String, Object> param);
	public int deleteBookmark(@Param("userId") String userId,@Param("sn") String sn);
	
}
