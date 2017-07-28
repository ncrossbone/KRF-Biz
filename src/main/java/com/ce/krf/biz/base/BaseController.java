package com.ce.krf.biz.base;

import java.util.ArrayList;
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
				if(!(srcMap.get(key) instanceof String)) {
					continue;
				}
				String v = String.valueOf(srcMap.get(key));
				// 차트 문자열일때
				if(((String) key).startsWith("CHART") &&  v.startsWith("[[") && v.endsWith("]]")) {
					try {
						// 문자열을 List로 형변환
						List vv = om.readValue(v, List.class);
						if(vv != null) {
							boolean nullFlag = false;
							List desList = new ArrayList();
							
							// 리스트의 값을 확인하여 값이 있는 항목만 새로운 리스트로 만듬
							for(int j=0; j<vv.size(); j++) {
								List cData = (List)vv.get(j);
								if(cData != null || cData.size() == 2) {
									Object value = cData.get(1);
									if(value != null && !"".equals(value) && !"null".equals(value)) {
										desList.add(cData);
									}else {
										if(vv.size() <=5) {
											cData = cData.subList(0, 1);
											cData.add(null);
											desList.add(cData);
										}
									}
								}
							}
							// 차트 리스트가 5건 이상일때 뒤부터 5개만 자름
							if(desList.size()>5) {
								desList = desList.subList((desList.size()-5), desList.size());
							}
							srcMap.put(key, desList);
						}
					}catch(Exception e) {
					}
				}
			}
		}
	}
	public String getEuckrString(HashMap src, boolean encFlag) throws Exception {
		if(encFlag) {
			for(Object key : src.keySet()) {
				Object v = src.get(key);
				if(v instanceof List) {
					convertStringForMap((List)v);
				}
			}
		}
		String res = om.writeValueAsString(src);
		
		return res; //new String(res.getBytes(), "EUC-KR");
	}

	public String getEuckrString(String src) throws Exception {
		return src; //new String(src.getBytes(), "EUC-KR");
	}
}
