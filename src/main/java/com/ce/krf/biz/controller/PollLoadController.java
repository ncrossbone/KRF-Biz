package com.ce.krf.biz.controller;

import java.io.Serializable;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.PollutionVO;
import com.ce.krf.biz.model.SearchResultVO;
import com.ce.krf.biz.service.PollLoadService;

@RestController
@RequestMapping("/pollLoad")
public class PollLoadController extends BaseController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7693478211410243179L;

	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);
	
	@Autowired
	public PollLoadService pollLoadService;
	
	@RequestMapping(value = "/pollLoadSelect", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchSstg(@ModelAttribute PollutionVO param) {
		try {
			HashMap result = pollLoadService.pollLoadSelect(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
}
