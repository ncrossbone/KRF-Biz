package com.ce.krf.biz.controller;

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
import com.ce.krf.biz.model.SearchResultVO;
import com.ce.krf.biz.service.SearchResultService;

@RestController
@RequestMapping("/searchResult")
public class SearchResultController extends BaseController{
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);
	
	@Autowired
	public SearchResultService searchResultService;
	
	// 수질측정지점 LAYER CODE : A
	@RequestMapping(value = "/searchResult_A", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_A(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_A(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 수질자동측정지점 - 사업장TMS GROUP CODE : B
	@RequestMapping(value = "/searchResult_B", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_B(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = (searchResultService.searchResult_B(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	
	// 수질자동측정지점 - 수질자동측정지점 미확정 GROUP CODE : B
	@RequestMapping(value = "/searchResult_B001", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_B001(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_B001(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
		
	// 수질자동측정지점 - 수질자동측정지점 확정 GROUP CODE : B
	@RequestMapping(value = "/searchResult_B001_Fix", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_B001_Fix(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_B001_Fix(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 퇴적물 LAYER CODE : C
	@RequestMapping(value = "/searchResult_C", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_C(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_C(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	@RequestMapping(value = "/searchResult_D_{gubun}", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_1(@PathVariable String gubun ,@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_D(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	@RequestMapping(value = "/searchResult_F_{gubun}", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_F_1(@PathVariable String gubun, @ModelAttribute SearchResultVO param) {
		
		try {
			HashMap result = searchResultService.searchResult_F(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 부하량 - 총괄표
	@RequestMapping(value = "/searchResult_PollLoad_Total", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Total(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Total(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 부하량 - 표준유역단위
	@RequestMapping(value = "/searchResult_PollLoad_Standard", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Standard(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Standard(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 부하량 - 집수구역단위
	@RequestMapping(value = "/searchResult_PollLoad_Cat", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Cat(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Cat(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 부하량 - 집수구역단위_상세
	@RequestMapping(value = "/searchResult_PollLoad_Cat_Detail", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Cat_Detail(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Cat_Detail(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
		
}
