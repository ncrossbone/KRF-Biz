package com.ce.krf.biz.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.service.SampleService;

@Controller
public class SamplePageController extends BaseController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4703328721991633740L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public SampleService sampleService;
	
	@RequestMapping("/index")
	public String navigate(Model model) {
		model.addAttribute("Test", "테스트");
		return "index";
	} 
	
}
