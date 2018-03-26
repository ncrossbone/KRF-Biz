package com.ce.krf.biz.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.ClickLogVO;
import com.ce.krf.biz.model.ExcelDownloadVO;
import com.ce.krf.biz.model.SampleVO;
import com.ce.krf.biz.service.SampleService;
/**
 *
 * @File    : com.ce.krf.biz.controller.SampleRestController.java
 * @Author  : CE Tech C.PARK
 * @Version : 1.0
 *
 * == Modification Infomation ==
 * 
 * DATA           AUTHOR     NOTE
 *-----------------------------------------
 * 2017. 7. 17.   C.PARK     최초작성
 *
 *
 */
@RestController
@RequestMapping("/biz")
public class SampleRestController extends BaseController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3277995675859719821L;

	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public SampleService sampleService;
	@RequestMapping(value = "/labellayeradmin/{gubun}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> sampleForPathVar(@PathVariable String gubun) {
		return sampleService.getLabelLayerAdmin(gubun);
	}

	@RequestMapping(value = "/labellayeradmin", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> sampleForUrlParam(@RequestParam String gubun) {
		return sampleService.getLabelLayerAdmin(gubun);
	}

	@PostMapping(value = "/labellayeradmin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> sampleForRequestBody(@RequestBody SampleVO param) {
		return sampleService.getLabelLayerAdminForPost(param);
	}

	@GetMapping(value = "/rwmdt/{recordId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getRWMDT(@PathVariable String recordId) {
		return sampleService.getRWMDT(recordId);
	}

	@GetMapping(value = "/rwmdt", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Map<String, Object>> getRWMDTWithReqParam(@RequestParam String recordId) {
		return sampleService.getRWMDT(recordId);
	}

	@RequestMapping(value = "/clicklog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String clicklog(@RequestBody ClickLogVO logInfo) {
		logInfo.setIp(request.getRemoteAddr());
		return sampleService.putClickLog(logInfo);
	}

	@RequestMapping(value = "/clicklogs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String putClickLogs(@RequestBody SampleVO logInfo) {
		return sampleService.putClickLogs(logInfo, request.getRemoteAddr());
	}

	@GetMapping(value = "/helloGet", produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloGet() {

		logger.debug("hello GET");
		logger.info("hello GET");
		logger.warn("hello GET");
		logger.error("hello GET");

		return "helloGet";
	}

	@PostMapping(value = "/helloPost", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloPost() {
		return "helloPost";
	}

	@PostMapping(value = "/putSessionIp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, String> putSessionIp() {
		String ipAddr = request.getRemoteAddr();
		return sampleService.putSessionIp(ipAddr);
	}
}