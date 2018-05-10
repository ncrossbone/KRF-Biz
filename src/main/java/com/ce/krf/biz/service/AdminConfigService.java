package com.ce.krf.biz.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.AdminConfigMapper;
import com.ce.krf.biz.model.AdminConfigVO;

@Component
public class AdminConfigService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5081969025734530435L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public AdminConfigMapper adminConfigMapper;

	public HashMap selectLayerSetAll(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		List dataList = adminConfigMapper.selectLayerSetAll(param);
		if(dataList == null || dataList.size() <= 0) {
			dataList = new ArrayList();
			HashMap data = new HashMap();
			data.put("layerSetId", 1);
			data.put("layerSetIds", "[\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"12\",\"13\",\"14\",\"35\",\"36\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"48\",\"49\",\"15\",\"16\",\"17\",\"18\",\"19\",\"20\",\"21\",\"22\",\"23\",\"24\",\"25\",\"P0\",\"P1\",\"26\",\"27\",\"28\",\"29\",\"30\",\"31\",\"32\",\"33\",\"34\",\"52\",\"53\",\"55\",\"56\",\"57\",\"58\",\"59\",\"S\",\"S0\",\"S1\",\"S2\",\"60\",\"61\",\"62\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"70\",\"71\",\"72\",\"90\",\"91\",\"D0\",\"D1\",\"D2\",\"D3\",\"D4\"]");
			data.put("layerSetName", "기본");
			dataList.add(data);
		}
		result.put("data", dataList);
		return result;
	}

	public HashMap selectLayerSetForUser(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		List dataList = adminConfigMapper.selectLayerSetForUser(param);
		if(dataList == null || dataList.size() <= 0) {
			dataList = new ArrayList();
			HashMap data = new HashMap();
			data.put("layerSetId", 1);
			data.put("layerSetIds", "[\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"12\",\"13\",\"14\",\"35\",\"36\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"48\",\"49\",\"15\",\"16\",\"17\",\"18\",\"19\",\"20\",\"21\",\"22\",\"23\",\"24\",\"25\",\"P0\",\"P1\",\"26\",\"27\",\"28\",\"29\",\"30\",\"31\",\"32\",\"33\",\"34\",\"52\",\"53\",\"55\",\"56\",\"57\",\"58\",\"59\",\"S\",\"S0\",\"S1\",\"S2\",\"60\",\"61\",\"62\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"70\",\"71\",\"72\",\"90\",\"91\",\"D0\",\"D1\",\"D2\",\"D3\",\"D4\"]");
			data.put("layerSetName", "기본");
			dataList.add(data);
		}
		result.put("data", dataList);
		return result;
	}

	public HashMap selectUsers(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("data", adminConfigMapper.selectUsers(param));
		return result;
	}

	public HashMap insertLayerSet(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.insertLayerSet(param));
		return result;
	}

	public HashMap insertLayerSetByUser(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		adminConfigMapper.deleteLayerSetByUser(param);
		
		result.put("result", adminConfigMapper.insertLayerSetByUser(param));
		return result;
	}

	public HashMap updateLayerSet(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.updateLayerSet(param));
		return result;
	}

	public HashMap deleteLayerSet(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		adminConfigMapper.deleteLayerSetByLayerSetId(param);
		
		result.put("result", adminConfigMapper.deleteLayerSet(param));
		return result;
	}

	public HashMap deleteLayerSetByUser(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.deleteLayerSetByUser(param));
		return result;
	}
}
