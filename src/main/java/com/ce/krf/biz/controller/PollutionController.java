package com.ce.krf.biz.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.PollutionVO;
import com.ce.krf.biz.service.PollutionService;

@RestController
@RequestMapping("/pollution")
public class PollutionController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public PollutionService pollutionService;

	@RequestMapping(value = "/pollutionSelect_{index}", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String pollutionSelect(@PathVariable String index, @ModelAttribute PollutionVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", pollutionService.pollutionSelect(index, param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return e.getMessage();
		}
	}
}
