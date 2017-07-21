package com.ce.krf.biz.service;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.SearchResultMapper;
import com.ce.krf.biz.model.SearchResultVO;

@Component
public class SearchResultService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public SearchResultMapper searchResultMapper;
	
	//수질측정지점 LAYER CODE : A
	public List searchResult_A(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		if("noDate".equals(param.getFirstSearch())) {
			return searchResultMapper.searchResult_A_getDate(param);
		}else {
			return searchResultMapper.searchResult_A(param);
		}
	}
	
	
	
	//수질측정지점 LAYER CODE : B
	public List searchResult_B(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		if("noDate".equals(param.getFirstSearch())) {
			return searchResultMapper.searchResult_B_getDate(param);
		}else {
			return searchResultMapper.searchResult_B(param);
		}
	}
	
	//수질자동측정지점 - 수질자동측정지점 미확정 GROUP CODE : B
	public List searchResult_B001(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_B001(param);
		return result;
	}
	
	//수질자동측정지점 - 수질자동측정지점 확정 GROUP CODE : B
	public List searchResult_B001_Fix(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_B001_Fix(param);
		return result;
	}
	
	
	//퇴적물 LAYER CODE : C
	public List searchResult_C(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_C(param);
		return result;
	}
	
	
	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	public List searchResult_D_getDate(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		List result = searchResultMapper.searchResult_D_getDate(param);
		return result;
	}
	
	
	public List searchResult_D(String gubun, SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		if("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			return searchResultMapper.searchResult_D_getDate(param);
		}else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_D_" + gubun, SearchResultVO.class);
			return (List) method.invoke(searchResultMapper, param);
		}
	}
	//환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	public List searchResult_F(String gubun, SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		if("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			return searchResultMapper.searchResult_F_getDate(param);
		}else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_F_" + gubun, SearchResultVO.class);
			return (List) method.invoke(searchResultMapper, param);
		}
	}

	//부하량 - 총괄표
	public List searchResult_PollLoad_Total(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_PollLoad_Total(param);
		return result;
	}
	
	//부하량 - 표준유역단위
	public List searchResult_PollLoad_Standard(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_PollLoad_Standard(param);
		return result;
	}
	
	//부하량 - 집수구역단위
	public List searchResult_PollLoad_Cat(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_PollLoad_Cat(param);
		return result;
	}
	
	//부하량 - 집수구역단위_상세
	public List searchResult_PollLoad_Cat_Detail(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_PollLoad_Cat_Detail(param);
		return result;
	}
	
		
}
