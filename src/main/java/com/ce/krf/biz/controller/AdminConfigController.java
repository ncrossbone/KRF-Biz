package com.ce.krf.biz.controller;

import java.awt.Menu;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.AdminConfigVO;
import com.ce.krf.biz.service.AdminConfigService;

@RestController
@RequestMapping("/config")
public class AdminConfigController extends BaseController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8694821545355394058L;

	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Autowired
	public AdminConfigService adminConfigService;

	@RequestMapping(value = "/getLayerSetAll", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String getLayerSetAll(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.selectLayerSetAll(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value="/getBoInfo", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String getBoInfo(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.getBoInfo(param);
			return getEuckrString(result, false);
		}catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/getLayerSetForUser", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String getLayerSetForUser(@ModelAttribute AdminConfigVO param) {		
		try {
			HashMap result = adminConfigService.selectLayerSetForUser(param);
			
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String getUsers(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.selectUsers(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/loginSession", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String loginSession(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.loginSession(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String selectIdPass(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.selectIdPass(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/getUserLayerInfo", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String getUserLayerInfo(@ModelAttribute AdminConfigVO param) {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-ranscation");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			HashMap result = adminConfigService.getUserLayerInfo(param);
			transactionManager.commit(status);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transactionManager.rollback(status);
			return "error";
		}
	}
	
	@RequestMapping(value = "/putLayerSet", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String putLayerSet(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.insertLayerSet(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}

	
	@RequestMapping(value = "/putLayerSetByUser", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String putLayerSetByUser(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.insertLayerSetByUser(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/updateLayerSet", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String updateLayerSet(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.updateLayerSet(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}

	@RequestMapping(value = "/delLayerSet", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String delLayerSet(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.deleteLayerSet(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/getDroneLayer", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String getDroneLayer(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.selectDroneLayer(param);
			return getEuckrString(result, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/deleteDroneLayer", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String deleteDroneLayer(@ModelAttribute AdminConfigVO param) {
		try {
			HashMap result = adminConfigService.deleteDroneLayer(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
	}
	
	@RequestMapping(value = "/insertDroneLayer", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String insertDroneLayer(@ModelAttribute AdminConfigVO param) {
		
		try {
			HashMap result = adminConfigService.insertDroneLayer(param);
			return getEuckrString(result, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
		

	}
	
	@RequestMapping(value = "/testDroneLayer", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String test(String result, @RequestBody AdminConfigVO param) throws Exception {

		for(AdminConfigVO str : param.getData()) {
	
		System.out.println("name-------------->"+str.getRiver()); 
	 
	
		}
		return null;

	}



	
	
}
