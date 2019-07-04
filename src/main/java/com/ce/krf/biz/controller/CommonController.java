package com.ce.krf.biz.controller;

import java.io.Serializable;
import java.net.Inet4Address;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//github.com/ncrossbone/KRF-Biz.git
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.ClickLogVO;
import com.ce.krf.biz.model.ExcelDownloadVO;
import com.ce.krf.biz.model.ImageVO;
import com.ce.krf.biz.service.CommonService;

/**
 *
 * @File : com.ce.krf.biz.controller.CommonController.java
 * @Author : CE Tech C.PARK
 * @Version : 1.0
 *
 *          == Modification Infomation ==
 * 
 *          DATA AUTHOR NOTE ----------------------------------------- 2017. 7.
 *          18. C.PARK 최초작성
 *
 *
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2560335239075758368L;

	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public CommonService commonService;

	/**
	 * Desc : 엑셀 다운로드	
	 * 
	 * @Method Name : excelDownload
	 * @param excelVo
	 */
	@RequestMapping(value="excelDown", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void excelDownload(@RequestBody ExcelDownloadVO excelVo) {
		try {
			commonService.excelDown(excelVo, response.getOutputStream());
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * Desc : 비밀번호 암호
	 * @Method Name : sha256
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value="sha256", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String sha256(@RequestParam String pwd) {
		try {
			return commonService.sha256(pwd);
		} catch (Exception e) {
			logger.error(e.getMessage());
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return "";
	}
	
	
	@PostMapping(value = "/clickSession",  produces = "text/html; charset=utf-8")
	public String clickSession(@ModelAttribute ClickLogVO clickLogVO) {
		
		
		//clickLogVO.setIp(request.getRemoteAddr());
		clickLogVO.setIp(request.getRemoteAddr());
		
		int cnt = commonService.clickSession(clickLogVO);
		
		return cnt +"건 저장됨";
	}
	
	@PostMapping(value="/imageDelete",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void imageDelete(@RequestBody ImageVO imageVO) {
		
		String[] imgArr = {imageVO.getResultParam(),
								imageVO.getSvgParam(),
								imageVO.getPngParam()};
		
		try {
			commonService.imageDelete(imgArr);
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
