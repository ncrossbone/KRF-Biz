package com.ce.krf.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.ce.krf.biz.model.SampleVO;
import com.ce.krf.biz.model.SearchResultVO;
import com.ce.krf.biz.service.SearchResultService;

@RestController
@RequestMapping("/searchResult")
public class SearchResultController extends BaseController{
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);
	
	@Autowired
	public SearchResultService searchResultService;
	
	
	// 수질측정지점최근날짜 LAYER CODE : A
	@RequestMapping(value = "/searchResult_A_getDate", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_A_getDate(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_A_getDate(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 수질측정지점 LAYER CODE : A
	@RequestMapping(value = "/searchResult_A", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_A(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_A(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	
	// 수질자동측정지점 - 사업장TMS GROUP CODE : B
	@RequestMapping(value = "/searchResult_B_getDate", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_B_getDate(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_B_getDate(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 수질자동측정지점 - 사업장TMS GROUP CODE : B
	@RequestMapping(value = "/searchResult_B", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_B(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_B(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	
	// 수질자동측정지점 - 수질자동측정지점 미확정 GROUP CODE : B
	@RequestMapping(value = "/searchResult_B001", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_B001(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_B001(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
		
	// 수질자동측정지점 - 수질자동측정지점 확정 GROUP CODE : B
	@RequestMapping(value = "/searchResult_B001_Fix", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_B001_Fix(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_B001_Fix(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 퇴적물 LAYER CODE : C
	@RequestMapping(value = "/searchResult_C", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_C(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_C(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	@RequestMapping(value = "/searchResult_D_1", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_1(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_D_1(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	@RequestMapping(value = "/searchResult_D_getDate", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_getDate(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		try {
			result.put("data", searchResultService.searchResult_D_getDate(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 기타측정지점 - 우량관측소 GROUT CODE : D / LAYER CODE : D002
	@RequestMapping(value = "/searchResult_D_2", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_2(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_D_2(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 기타측정지점 - 유량관측소 GROUT CODE : D / LAYER CODE : D003
	@RequestMapping(value = "/searchResult_D_3", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_3(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_D_3(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 기타측정지점 - 댐관측소 GROUT CODE : D / LAYER CODE : D004
	@RequestMapping(value = "/searchResult_D_4", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_4(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_D_4(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 기타측정지점 - AWS기상관측소 GROUT CODE : D / LAYER CODE : D005
	@RequestMapping(value = "/searchResult_D_5", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_5(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_D_5(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 기타측정지점 - 지상기상관측소 GROUT CODE : D / LAYER CODE : D006
	@RequestMapping(value = "/searchResult_D_6", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_6(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_D_6(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 기타측정지점 - 보관측소 GROUT CODE : D / LAYER CODE : D007
	@RequestMapping(value = "/searchResult_D_7", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_D_7(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_D_7(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 환경기초시설 - 최근날짜
	@RequestMapping(value = "/searchResult_F_getDate", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_F_getDate(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_F_getDate(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	@RequestMapping(value = "/searchResult_F_1", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_F_1(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_F_1(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 환경기초시설 - 직접이송량 GROUT CODE : F / LAYER CODE : F002
	@RequestMapping(value = "/searchResult_F_2", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_F_2(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_F_2(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 환경기초시설 - 총유입량 GROUT CODE : F / LAYER CODE : F003
	@RequestMapping(value = "/searchResult_F_3", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_F_3(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_F_3(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 환경기초시설 - 관거이송량 GROUT CODE : F / LAYER CODE : F004
	@RequestMapping(value = "/searchResult_F_4", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_F_4(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_F_4(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	
	// 부하량 - 총괄표
	@RequestMapping(value = "/searchResult_PollLoad_Total", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Total(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Total(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 부하량 - 표준유역단위
	@RequestMapping(value = "/searchResult_PollLoad_Standard", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Standard(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Standard(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 부하량 - 집수구역단위
	@RequestMapping(value = "/searchResult_PollLoad_Cat", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Cat(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Cat(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 부하량 - 집수구역단위_상세
	@RequestMapping(value = "/searchResult_PollLoad_Cat_Detail", method = RequestMethod.POST, produces = "text/html; charset=euc-kr")
	public String searchResult_PollLoad_Cat_Detail(@ModelAttribute SearchResultVO param) {
		HashMap result = new HashMap();
		
		try {
			result.put("data", searchResultService.searchResult_PollLoad_Cat_Detail(param));
			return getEuckrString(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
		
		
		
}
