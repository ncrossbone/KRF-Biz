package com.ce.krf.biz.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.SampleVO;
import com.ce.krf.biz.model.SearchResultVO;
import com.ce.krf.biz.service.SearchResultService;

@RestController
@RequestMapping("/searchResult")
public class SearchResultController extends BaseController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8694821545355394048L;

	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public SearchResultService searchResultService;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
//	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
//	public String searchSstg(@ModelAttribute SearchResultVO param) {
//		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//		def.setName("example-ranscation");
//		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		
//		TransactionStatus status = transactionManager.getTransaction(def);
//		try {
//			HashMap result = searchResultService.searchSstg(param);
//			transactionManager.commit(status);
//			return getEuckrString(result, false);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			transactionManager.rollback(status);
//			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//			return "error";
//		}
//	}

	@RequestMapping(value = "/searchSstg", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchSstg(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchSstg(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 수질측정지점 LAYER CODE : A
	@RequestMapping(value = "/searchResult_A", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_A(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_A(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	// 상세검색 query
	@RequestMapping(value = "/detialSearchResult", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String detialSearchResult(@ModelAttribute SearchResultVO param) {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			HashMap result = searchResultService.detailSearchResult(param);
			transactionManager.commit(status);
			return getEuckrString(result, false);
		} catch (Exception e) {
			transactionManager.rollback(status);
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 수질측정지점 LAYER CODE : A
	@RequestMapping(value = "/searchResult_A2018", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_A2018(@ModelAttribute SearchResultVO param) {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			HashMap result = searchResultService.searchResult_A2018(param);
			transactionManager.commit(status);
			return getEuckrString(result, false);
		} catch (Exception e) {
			transactionManager.rollback(status);
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	
	@RequestMapping(value = "/searchResult_Z{index}_2018", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_Z_2018(@ModelAttribute SearchResultVO param, @PathVariable String index) {

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			HashMap result = searchResultService.searchResult_Z_2018(param,index);
			transactionManager.commit(status);
			return getEuckrString(result, false);
		} catch (Exception e) {
			transactionManager.rollback(status);
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	@RequestMapping(value = "/searchResultWindow_Z_{index}", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResultWindow_Z(@ModelAttribute SearchResultVO param, @PathVariable String index) {

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			HashMap result = searchResultService.searchResultWindow_Z(param,index);
			transactionManager.commit(status);
			return getEuckrString(result, false);
		} catch (Exception e) {
			transactionManager.rollback(status);
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 수질자동측정지점 - 사업장TMS GROUP CODE : B
	@RequestMapping(value = "/searchResult_B", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_B(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = (searchResultService.searchResult_B(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 수질자동측정지점 - 사업장TMS GROUP CODE : B
	@RequestMapping(value = "/searchResult_B2018", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_B2018(@ModelAttribute SearchResultVO param) {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			HashMap result = (searchResultService.searchResult_B2018(param));
			transactionManager.commit(status);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transactionManager.rollback(status);
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 수질자동측정지점 - 수질자동측정지점 미확정 GROUP CODE : B
	@RequestMapping(value = "/searchResult_B001", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_B001(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = (searchResultService.searchResult_B001(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 수질자동측정지점 - 수질자동측정지점 확정 GROUP CODE : B
	@RequestMapping(value = "/searchResult_B001_Fix", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_B001_Fix(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = (searchResultService.searchResult_B001_Fix(param));
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 퇴적물 LAYER CODE : C
	@RequestMapping(value = "/searchResult_C", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_C(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_C(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	@RequestMapping(value = "/searchResult_D_{gubun}", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_D_1(@PathVariable String gubun, @ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_D(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	@RequestMapping(value = "/searchResult_F_{gubun}", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_F_1(@PathVariable String gubun, @ModelAttribute SearchResultVO param) {

		try {
			HashMap result = searchResultService.searchResult_F(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 조류모니터링 GROUP CODE : I
	@RequestMapping(value = "/searchResult_I_{gubun}", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_I(@PathVariable String gubun, @ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_I(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 부하량 - 총괄표
	@RequestMapping(value = "/searchResult_PollLoad_{gubun}", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_PollLoad_Total(@PathVariable String gubun, SearchResultVO param) {

		try {
			HashMap result = searchResultService.searchResult_PollLoad(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 부하량 - 총괄표
	@RequestMapping(value = "/searchMeasuredValue", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String searchMeasuredValue(@QueryParam("type") String type) {

		try {
			HashMap result = searchResultService.searchMeasuredValue(type);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	// 부하량 - 총괄표
	@RequestMapping(value = "/Esstg{gubun}", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchSstg(@PathVariable String gubun, SearchResultVO param) {

		try {
			HashMap result = searchResultService.searchSstg(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// HSPF GROUP CODE : H
	@RequestMapping(value = "/searchResult_H", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_H(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_H(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			return "error";
		}
	}
		
	// 취정수장 GROUP CODE : E
	@RequestMapping(value = "/searchResult_J{gubun}", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_J(@PathVariable String gubun, @ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_J(gubun, param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	@RequestMapping(value = "/searchResult_M", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_M(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_M(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/searchResult_Q", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_Q(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_Q(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			return "error";
		}
	}
	
	// 한기조 GROUP_CODE : L
	@RequestMapping(value = "/searchResult_L2018", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_L2018(@ModelAttribute SearchResultVO param) {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			HashMap result = searchResultService.searchResult_L2018(param);
			transactionManager.commit(status);
			return getEuckrString(result, true);
		} catch (Exception e) {
			transactionManager.rollback(status);
			return "error";
		}
	}
	
	// 한기조 GROUP_CODE : L
	@RequestMapping(value = "/searchResult_K2018", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_K2018(@ModelAttribute SearchResultVO param) {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			HashMap result = searchResultService.searchResult_K2018(param);
			transactionManager.commit(status);
			return getEuckrString(result, true);
		} catch (Exception e) {
			transactionManager.rollback(status);
			return "error";
		}
	}
	
	
	// 보고서 : 보고서
	@RequestMapping(value = "/searchResult_File", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_File(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_File(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}
	
	// 경관
	@RequestMapping(value = "/searchResult_View", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String searchResult_View(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.searchResult_View(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error";
		}
	}

	@RequestMapping(value = "/getSedimentItemValue", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String getSedimentItemValue(@ModelAttribute SearchResultVO param) {
		try {
			HashMap result = searchResultService.getSedimentItemValue(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			return "error";
		}
	}

}
