package com.ce.krf.biz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.ClickLogVO;
import com.ce.krf.biz.model.ResultVO;
import com.ce.krf.biz.service.CommonService;

@RestController
@RequestMapping("/common")
public class CommonController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);
	
	@Autowired
	public CommonService commonService;
	
	
	@PostMapping(value = "/clickSession", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultVO clickSession(@RequestBody ClickLogVO clickLogVO) {
		
		clickLogVO.setIp(request.getRemoteAddr());
		
		ResultVO result = new ResultVO();
		int cnt = commonService.clickSession(clickLogVO);
		
		result.setMgs(cnt +"건 저장됨");
		result.setCode(1);
		
		return result;
	}
}
