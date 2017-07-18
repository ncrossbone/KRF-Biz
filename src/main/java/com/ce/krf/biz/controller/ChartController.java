package com.ce.krf.biz.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.service.ChartService;

@RestController
@RequestMapping("/chart")
public class ChartController extends BaseController{
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);
	
	@Autowired
	public ChartService chartService;
	
	
	@GetMapping(value = "/getRWMDT/{siteCd}", produces = MediaType.APPLICATION_JSON_VALUE ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getRWMDT(@PathVariable String siteCd) {
		return chartService.getRWMDT(siteCd);
	}
}
