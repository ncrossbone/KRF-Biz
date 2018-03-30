package com.ce.krf.biz.controller;

import java.io.Serializable;
import java.util.HashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.AdminConfigVO;
import com.ce.krf.biz.service.AdminConfigService;

@RestController
@RequestMapping("/config")
public class AdminConfigController extends BaseController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8694821545355394058L;

	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public AdminConfigService adminConfigService;

	@RequestMapping(value = "/getLayerSetAll", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String getLayerSetAll(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.selectLayerSetAll(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/getLayerSetForUser", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String getLayerSetForUser(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.selectLayerSetForUser(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String getUsers(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.selectUsers(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/putLayerSet", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String putLayerSet(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.insertLayerSet(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}

	
	@RequestMapping(value = "/putLayerSetByUser", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String putLayerSetByUser(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.insertLayerSetByUser(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/updateLayerSet", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String updateLayerSet(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.updateLayerSet(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}

	@RequestMapping(value = "/delLayerSet", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String delLayerSet(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.deleteLayerSet(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
}
