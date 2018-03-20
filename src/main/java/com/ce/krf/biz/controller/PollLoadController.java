package com.ce.krf.biz.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
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
}
