package com.ce.krf.biz.service;

import java.io.Serializable;
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
		result.put("data", adminConfigMapper.selectLayerSetAll(param));
		return result;
	}

	public HashMap selectLayerSetForUser(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		
		result.put("data", adminConfigMapper.selectLayerSetForUser(param));
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
