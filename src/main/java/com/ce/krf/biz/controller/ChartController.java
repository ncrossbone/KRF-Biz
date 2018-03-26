package com.ce.krf.biz.controller;

import java.io.Serializable;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.ChartVO;
import com.ce.krf.biz.service.ChartService;

@RestController
@RequestMapping("/chart")
public class ChartController extends BaseController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1194929585305909920L;

	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public ChartService chartService;
	
	
	@RequestMapping(value = "/getRWMDT", produces = "text/html; charset=euc-kr")
	public String getRWMDT(@ModelAttribute ChartVO param) {
		try {
			return getEuckrString((HashMap) chartService.getRWMDT(param.getRecordId() , param.getParentId()), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("[CHART]----------"+e.getStackTrace());
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/getRWMDT_{index}", produces = "text/html; charset=euc-kr")
	public String pollutionSelect(@PathVariable String index, @ModelAttribute ChartVO param) {
		HashMap result = new HashMap();
		try {
			return getEuckrString(chartService.getRWMDTSelect(index, param), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("[CHART]----------"+e.getStackTrace());
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return e.getMessage();
		}
	}
}
