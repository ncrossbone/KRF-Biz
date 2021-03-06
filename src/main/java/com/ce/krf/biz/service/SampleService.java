package com.ce.krf.biz.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.SampleMapper;
import com.ce.krf.biz.model.ClickLogVO;
import com.ce.krf.biz.model.ExcelDownloadVO;
import com.ce.krf.biz.model.SampleVO;

// @Component 어노테이션 해야 Autowired 를 하여 사용 할 수 있다.
@Component
public class SampleService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3275049531597082776L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public SampleMapper sampleMapper;
	
	public Map<String, Object> getLabelLayerAdmin(String ptNo) {
		HashMap res = new HashMap<String, Object>();
		res.put("datas", sampleMapper.getLabelLayerAdmin(ptNo));
		return res;
	}
	
	public Map<String, Object> getLabelLayerAdminForPost(SampleVO param) {
		HashMap res = new HashMap<String, Object>();
		res.put("datas", sampleMapper.getLabelLayerAdminForPost(param));
		return res;
	}
	
	public HashMap<String, String> putSessionIp(String id) {
		int cnt = sampleMapper.putSessionIp(id);
		HashMap<String, String> res = new HashMap<>();
		res.put("code", cnt+"");
		
		return res; 
	}
	public List<Map<String, Object>> getRWMDT(String recordId){
		return sampleMapper.getRWMDT(recordId);
	}
	public String putClickLog(ClickLogVO logInfo) {
		// TODO Auto-generated method stub
		return sampleMapper.putClickLog(logInfo)+"";
	}
	public String putClickLogs(SampleVO logInfo, String ipaddr) {
		// TODO Auto-generated method stub
		if(logInfo.getLogList() != null) {
			for(int i=0; i<logInfo.getLogList().size(); i++) {
				logInfo.getLogList().get(i).setIp(ipaddr);
			}
		}
		return sampleMapper.putClickLogs(logInfo)+"";
	}
	public void excelSample(ExcelDownloadVO excelVo, ServletOutputStream servletOutputStream) {
	}
	
	public void httpSample() throws IOException {
		URL url = new URL("");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Context-Type", "application/x-www-form-urlencoded");
		int status = conn.getResponseCode();
		// 성공
		if(status == 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		}
	}
}
