package com.ce.krf.biz.service;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ce.krf.biz.mapper.AdminConfigMapper;
import com.ce.krf.biz.model.AdminConfigVO;



@Component
public class AdminConfigService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5081969025734530435L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public AdminConfigMapper adminConfigMapper;
	
	
	

	public HashMap selectLayerSetAll(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		List dataList = adminConfigMapper.selectLayerSetAll(param);
		/*
		 * if(dataList == null || dataList.size() <= 0) { dataList = new ArrayList();
		 * HashMap data = new HashMap(); data.put("layerSetId", 1);
		 * data.put("layerSetIds",
		 * "[\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"12\",\"13\",\"14\",\"35\",\"36\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"48\",\"49\",\"15\",\"16\",\"17\",\"18\",\"19\",\"20\",\"21\",\"22\",\"23\",\"24\",\"25\",\"P0\",\"P1\",\"26\",\"27\",\"28\",\"29\",\"30\",\"31\",\"32\",\"33\",\"34\",\"52\",\"53\",\"55\",\"56\",\"57\",\"58\",\"59\",\"S\",\"S0\",\"S1\",\"S2\",\"60\",\"61\",\"62\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"70\",\"71\",\"72\",\"90\",\"91\",\"D0\",\"D1\",\"D2\",\"D3\",\"D4\"]"
		 * ); data.put("layerSetName", "기본"); dataList.add(data); }
		 */
		result.put("data", dataList);
		return result;
	}

	public HashMap selectLayerSetForUser(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		List dataList = adminConfigMapper.selectLayerSetForUser(param);
		if(dataList == null || dataList.size() <= 0) {
			dataList = new ArrayList();
			HashMap data = new HashMap();
			data.put("layerSetId", 1);
			data.put("layerSetIds", "[\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"10\",\"11\" ,\"12\",\"13\",\"14\",\"35\",\"36\",\"37\",\"38\",\"39\",\"40\",\"41\",\"42\",\"48\",\"49\",\"15\",\"16\",\"17\",\"18\",\"19\",\"20\",\"21\",\"22\",\"23\",\"24\",\"25\",\"P0\",\"P1\",\"26\",\"27\",\"28\",\"29\",\"30\",\"31\",\"32\",\"33\",\"34\",\"52\",\"53\",\"55\",\"56\",\"57\",\"58\",\"59\",\"S\",\"S0\",\"S1\",\"S2\",\"60\",\"61\",\"62\",\"64\",\"65\",\"66\",\"67\",\"68\",\"69\",\"70\",\"71\",\"72\",\"90\",\"91\",\"D0\",\"D1\",\"D2\",\"D3\",\"D4\"]");
			data.put("layerSetName", "기본");
			dataList.add(data);
		}
		result.put("data", dataList);
		return result;
	}

	public HashMap selectUsers(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("data", adminConfigMapper.selectUsers(param));
		return result;
	}
	
	public HashMap loginSession(AdminConfigVO param) throws Exception {
		HashMap result = new HashMap();
		
		List sessionresult = adminConfigMapper.selectSessionId(param);
		if(sessionresult.size() >= 1) {
			result.put("data", sessionresult);
		}else {
			result.put("data", "");
		}
		
		return result;
	}
	
	public HashMap selectIdPass(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		
		String encodingPass = encryptPassword(param.getUserPass(),param.getUserId());
		param.setUserPass(encodingPass);
		List loginUser = adminConfigMapper.selectIdPass(param);
		if(loginUser.size() >= 1) {
			result.put("data", loginUser);
		}else {
			result.put("error", "아이디 패스워드가 틀립니다");
		}
		
		return result;
	}
	
	/**
	  * <pre>
	  * 내용 : 비밀번호 암호화
	  * </pre>
	  * @Method Name : encryptPassword
	  * @param password 비밀번호
	  * @param id 아이디
	  * @return
	  * @throws NoSuchAlgorithmException
	  */
	 public static String encryptPassword(String password, String id) throws NoSuchAlgorithmException
	 {
	  if (password == null)
	  {
	   return "";
	  }

		/*
		 * MessageDigest sh = MessageDigest.getInstance("SHA-256");
		 * sh.update(password.getBytes()); byte byteData[] = sh.digest(); StringBuffer
		 * sb = new StringBuffer();
		 * 
		 * for (int i = 0; i < byteData.length; i++) {
		 * sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); }
		 * return sb.toString();
		 */
		
	  
	  byte[] hashValue = null; // 해쉬값

	  MessageDigest md = MessageDigest.getInstance("SHA-256");

	  md.reset();
	  md.update(id.getBytes());

	  hashValue = md.digest(password.getBytes());

	  return new String(Base64.encodeBase64(hashValue));
	 }
	
	public HashMap getUserLayerInfo(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		//adminConfigMapper.setUserLayerInfo(param);
		int dataList = adminConfigMapper.setUserLayerInfo(param);
		
		if(dataList == 1) {
			result.put("result", adminConfigMapper.getUserLayerInfo(param));	
		}
		return result;
	}

	public HashMap insertLayerSet(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.insertLayerSet(param));
		return result;
	}

	public HashMap insertLayerSetByUser(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		adminConfigMapper.deleteLayerSetByUser(param);
		
		result.put("result", adminConfigMapper.insertLayerSetByUser(param));
		return result;
	}

	public HashMap updateLayerSet(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.updateLayerSet(param));
		return result;
	}

	//권한별 레이어 목록가져오기 2019-04-15
	public HashMap deleteLayerSet(AdminConfigVO param) throws Exception {
		
		
		
		HashMap result = new HashMap();
		adminConfigMapper.deleteLayerSetByLayerSetId(param);
		
		result.put("result", adminConfigMapper.deleteLayerSet(param));
		return result;
	}

	public HashMap deleteLayerSetByUser(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.deleteLayerSetByUser(param));
		return result;
	}
	
	
	public HashMap selectDroneLayer(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("data", adminConfigMapper.selectDroneLayer(param));
		return result;
	}
	
	public HashMap deleteDroneLayer(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("data", adminConfigMapper.deleteDroneLayer(param));
		return result;
		
	}
	
	public HashMap insertDroneLayer(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.insertDroneLayer(param));
		return result;
		
	}
	
	public HashMap testDroneLayer(AdminConfigVO param) throws Exception {

		HashMap result = new HashMap();
		
		return result;
		
	}

	public HashMap getBoInfo(AdminConfigVO param) {
		// TODO Auto-generated method stub
		
		HashMap result = new HashMap();
		result.put("result", adminConfigMapper.selectBoInfo(param));
		
		return result;
	}
	
}
