package com.ce.krf.biz.mapper;

import java.util.List;

import com.ce.krf.biz.model.DroneVO;

public interface DroneMapper {

	public List getRWMDT(DroneVO param);
	public List getSubRWMDT(DroneVO param);
	
}
