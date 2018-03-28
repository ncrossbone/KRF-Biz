package com.ce.krf.biz.mapper;

import java.util.List;

import com.ce.krf.biz.model.AdminConfigVO;

public interface AdminConfigMapper {
	
	public List selectLayerSetAll(AdminConfigVO param);
	public List selectLayerSetForUser(AdminConfigVO param);
	public List selectUsers(AdminConfigVO param);
	
	public int insertLayerSet(AdminConfigVO param);
	public int insertLayerSetByUser(AdminConfigVO param);
	
	public int updateLayerSet(AdminConfigVO param);
	
	public int deleteLayerSet(AdminConfigVO param);
	public int deleteLayerSetByUser(AdminConfigVO param);
	public int deleteLayerSetByLayerSetId(AdminConfigVO param);
	
	
}
