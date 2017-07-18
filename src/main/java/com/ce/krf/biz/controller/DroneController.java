package com.ce.krf.biz.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.service.DroneService;

@RestController
@RequestMapping("/drone")
public class DroneController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);
	
	@Autowired
	public DroneService droneService;
	
	@RequestMapping("/getRWMDT")
	public HashMap<String, Object> getRWMDT(@RequestParam String siteCodes, @RequestParam String measureDate, String layerDate) {
		
//		return droneService.getRWMDT(siteCodes, measureDate, layerDate);
		return null;
	}
}
