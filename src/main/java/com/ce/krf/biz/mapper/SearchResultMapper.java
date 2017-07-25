package com.ce.krf.biz.mapper;

import java.util.List;
import java.util.Map;

import com.ce.krf.biz.model.SearchResultVO;

public interface SearchResultMapper {
	
	//수질측정지점
	public List searchResult_A(SearchResultVO param);
	
	//수질자동측정지점 - 사업장TMS
	public List searchResult_B(SearchResultVO param);
	
	//수질자동측정지점 - 사업장TMS 최근날짜
	public List searchResult_B_getDate(SearchResultVO param);
	
	//수질자동측정지점 - 사업장TMS
	public List searchResult_B001(SearchResultVO param);
	
	//수질자동측정지점 - 사업장TMS
	public List searchResult_B001_Fix(SearchResultVO param);
	
	//퇴적물 - 사업장TMS
	public List searchResult_C_getDate(SearchResultVO param);
	
	//퇴적물 - 사업장TMS
	public List searchResult_C(SearchResultVO param);
	
	
	//기타측정지점 - 최근데이터
	public List searchResult_D_getDate(SearchResultVO param);
	
	//기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	public List searchResult_D_1(SearchResultVO param);
	
	//기타측정지점 - 우량관측소 GROUT CODE : D / LAYER CODE : D002
	public List searchResult_D_2(SearchResultVO param);
	
	//기타측정지점 - 유량관측소 GROUT CODE : D / LAYER CODE : D003
	public List searchResult_D_3(SearchResultVO param);
	
	//기타측정지점 - 댐관측소 GROUT CODE : D / LAYER CODE : D004
	public List searchResult_D_4(SearchResultVO param);
	
	//기타측정지점 - AWS기상관측소 GROUT CODE : D / LAYER CODE : D005
	public List searchResult_D_5(SearchResultVO param);
	
	//기타측정지점 - 지상기상관측소 GROUT CODE : D / LAYER CODE : D006
	public List searchResult_D_6(SearchResultVO param);
	
	//기타측정지점 - 보관측소 GROUT CODE : D / LAYER CODE : D007
	public List searchResult_D_7(SearchResultVO param);
	
	
	//환경기초시설 - 최근날짜
	public List searchResult_F_getDate(SearchResultVO param);
	
	//환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	public List searchResult_F_1(SearchResultVO param);
	
	//환경기초시설 - 직접이송량 GROUT CODE : F / LAYER CODE : F002
	public List searchResult_F_2(SearchResultVO param);
	
	//환경기초시설 - 총유입량 GROUT CODE : F / LAYER CODE : F003
	public List searchResult_F_3(SearchResultVO param);
	
	//환경기초시설 - 관거이송량 GROUT CODE : F / LAYER CODE : F004
	public List searchResult_F_4(SearchResultVO param);
	
	
	//부하량 - 총괄표
	public List searchResult_PollLoad_Total(SearchResultVO param);
	
	//부하량 - 표준유역단위
	public List searchResult_PollLoad_Standard(SearchResultVO param);
	
	//부하량 - 집수구역단위
	public List searchResult_PollLoad_Cat(SearchResultVO param);
	
	//부하량 - 집수구역단위_상세
	public List searchResult_PollLoad_Cat_Detail(SearchResultVO param);
	
	public List searchResult_A_getDate(SearchResultVO param);

}
