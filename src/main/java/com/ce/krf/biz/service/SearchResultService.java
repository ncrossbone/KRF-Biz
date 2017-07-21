package com.ce.krf.biz.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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
	public List searchResult_A_getDate(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_A_getDate(param);
		return result;
	}
	
	//수질측정지점 LAYER CODE : A
	public List searchResult_A(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_A(param);
		return result;
	}
	
	
	
	//수질측정지점 LAYER CODE : B
	public List searchResult_B(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_B(param);
		return result;
	}
	
	//수질측정지점 LAYER CODE : B 최근날짜
	public List searchResult_B_getDate(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		List result = searchResultMapper.searchResult_B_getDate(param);
		return result;
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
	
	
	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	public List searchResult_D_1(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_D_1(param);
		return result;
	}
	
	// 기타측정지점 - 우량관측소 GROUT CODE : D / LAYER CODE : D002
	public List searchResult_D_2(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_D_2(param);
		return result;
	}
	
	// 기타측정지점 - 유량관측소 GROUT CODE : D / LAYER CODE : D003
	public List searchResult_D_3(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_D_3(param);
		return result;
	}
	
	//기타측정지점 - 댐관측소 GROUT CODE : D / LAYER CODE : D004
	public List searchResult_D_4(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_D_4(param);
		return result;
	}
	
	//기타측정지점 - AWS기상관측소 GROUT CODE : D / LAYER CODE : D005
	public List searchResult_D_5(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_D_5(param);
		return result;
	}
	
	
	//기타측정지점 - 지상기상관측소 GROUT CODE : D / LAYER CODE : D006
	public List searchResult_D_6(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_D_6(param);
		return result;
	}
	
	
	//기타측정지점 - 보관측소 GROUT CODE : D / LAYER CODE : D007
	public List searchResult_D_7(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_D_7(param);
		return result;
	}
	
	//searchResult_F_getDate
	
	//환경기초시설 - 최근날짜
	public List searchResult_F_getDate(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_F_getDate(param);
		return result;
	}
	
	//환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	public List searchResult_F_1(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_F_1(param);
		return result;
	}
	
	//환경기초시설 - 직접이송량 GROUT CODE : F / LAYER CODE : F002
	public List searchResult_F_2(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_F_2(param);
		return result;
	}
	
	//환경기초시설 - 총유입량 GROUT CODE : F / LAYER CODE : F003
	public List searchResult_F_3(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_F_3(param);
		return result;
	}
	
	//환경기초시설 - 관거이송량 GROUT CODE : F / LAYER CODE : F004
	public List searchResult_F_4(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'","").split(","));
		
		List result = searchResultMapper.searchResult_F_4(param);
		return result;
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
