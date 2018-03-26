package com.ce.krf.biz.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.DroneMapper;
import com.ce.krf.biz.model.DroneVO;

@Component
public class DroneService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4413378284002359669L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public DroneMapper droneMapper;
	
	public List getRWMDT(String siteCodes, String measureDate, String layerDate) {
		DroneVO param = new DroneVO();
		
		param.setSiteCodes(siteCodes.split(","));
		param.setMeasureDate(measureDate);
		param.setLayerDate(layerDate);
		List<HashMap> rwmdtList = droneMapper.getRWMDT(param);
		List<HashMap> rwmdtDes = new ArrayList<HashMap>();
		
		for(int i=0; i<rwmdtList.size(); i++) {
			HashMap rwmdt = rwmdtList.get(i);
			if("-".equals(rwmdt.get("WMCYMD"))) {
				param.setPtNo((String)rwmdt.get("PT_NO"));
				List<HashMap> rwmdtSubList = droneMapper.getSubRWMDT(param);
				if(rwmdtSubList.size()>0) {
					rwmdtDes.add(rwmdtSubList.get(rwmdtSubList.size()-1));
				}else {
					rwmdtDes.add(rwmdt);
				}
			}else {
				rwmdtDes.add(rwmdt);
			}
		}
		return rwmdtDes;
	}
}
