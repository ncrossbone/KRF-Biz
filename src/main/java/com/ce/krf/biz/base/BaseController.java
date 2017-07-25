package com.ce.krf.biz.base;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {

	@Autowired
	public HttpServletRequest request;

	@Autowired
	public HttpServletResponse response;

	public ObjectMapper om = new ObjectMapper();

	// 응답 데이터중 차트리스트가 있으면 String -> LIST 형으로 변경
	public void convertStringForMap(List src) {
		if(src == null) {
			return;
		}
		for(int i=0; i<src.size(); i++) {
			HashMap srcMap = (HashMap)src.get(i);
			if(srcMap == null) {
				continue;
			}
			for(Object key : srcMap.keySet()) {
				String v = String.valueOf(srcMap.get(key));
				if(((String) key).startsWith("CHART") &&  v.startsWith("[[") && v.endsWith("]]")) {
					try {
						List vv = om.readValue(v, List.class);
						if(vv != null) {
							srcMap.put(key, vv);
						}
					}catch(Exception e) {
						
					}
				}
			}
		}
	}
	public String getEuckrString(HashMap src) throws Exception {
		for(Object key : src.keySet()) {
			Object v = src.get(key);
			if(v instanceof List) {
				convertStringForMap((List)v);
			}
		}
		String res = om.writeValueAsString(src);
		
		return res; //new String(res.getBytes(), "EUC-KR");
	}

	public String getEuckrString(String src) throws Exception {
		return src; //new String(src.getBytes(), "EUC-KR");
	}
}
