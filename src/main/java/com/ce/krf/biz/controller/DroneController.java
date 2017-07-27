package com.ce.krf.biz.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.service.DroneService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/drone")
public class DroneController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public DroneService droneService;

	@RequestMapping(value = "/getRWMDT", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String getRWMDT(@RequestParam String siteCodes, @RequestParam String measureDate, String layerDate) {
		HashMap result = new HashMap();
		result.put("data", droneService.getRWMDT(siteCodes, measureDate, layerDate));
		try {
			return om.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
}
