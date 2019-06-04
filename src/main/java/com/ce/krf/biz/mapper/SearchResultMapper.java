package com.ce.krf.biz.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ce.krf.biz.model.SearchResultVO;

public interface SearchResultMapper {
	
	//view param
	public int searchResult_setParam_2018(SearchResultVO param);
	
	//상세검색 set param
	public int detailSearchSetParam(SearchResultVO param);
	public List detailSearchResult(SearchResultVO param);
	
	//수질측정지점
	public List searchResult_A_getDate(SearchResultVO param);
	public List searchResult_A(SearchResultVO param);
	
	public List searchResult_A_getDate2018(SearchResultVO param);
	public int searchResult_A2018_setParam(SearchResultVO param);
	public List searchResult_A_RESULT_2018(SearchResultVO param);
	
	
	//수질자동측정지점 - 사업장TMS 최근날짜
	public List searchResult_B(SearchResultVO param);
	public List searchResult_B_getDate(SearchResultVO param);
	
	public List searchResult_B_getDate2018(SearchResultVO param);
	public int searchResult_B2018_setParam(SearchResultVO param);
	public List searchResult_B_RESULT_2018(SearchResultVO param);
	
	
	public List searchResult_B001_getDate(SearchResultVO param);
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
	
	//조류모니터링 - 최근날짜
	public List searchResult_I_getDate(SearchResultVO param);
	
	//조류모니터링
	public List searchResult_I_1(SearchResultVO param);
	
	public List searchResult_I_2(SearchResultVO param);
	
	
	
	public List searchResult_J001(SearchResultVO param);
	public List searchResult_J002(SearchResultVO param);
	
	
	//부하량 - 총괄표
	public List searchResult_PollLoad_Total(SearchResultVO param);
	
	//부하량 - 표준유역단위
	public List searchResult_PollLoad_Standard(SearchResultVO param);
	
	//부하량 - 집수구역단위
	public List searchResult_PollLoad_Cat(SearchResultVO param);
	
	//부하량 - 집수구역단위_상세
	public List searchResult_PollLoad_Cat_Detail(SearchResultVO param);
	
		
	public List sstg(SearchResultVO param);
	
	
	
	public List searchSstg_getDate(SearchResultVO param);
	
	//수생태계 하구
	public List searchSstgHgAtalSe(SearchResultVO param); // 돌착말류
	public List searchSstgHgBemaSe(SearchResultVO param); // 저서성대형무척추동물
	public List searchSstgHgFishSe(SearchResultVO param); // 어류
	public List searchSstgHgVtnSe(SearchResultVO param); // 식생
	
	//수생태계 하천
	public List searchSstgHcAtalSe(SearchResultVO param); // 돌착말류
	public List searchSstgHcBemaSe(SearchResultVO param); // 저서성대형무척추동물
	public List searchSstgHcFishSe(SearchResultVO param); // 어류
	public List searchSstgHcQltwtrSe(SearchResultVO param); // 서식 및 수변환경
	public List searchSstgHcInhaSe(SearchResultVO param); // 수질
	public List searchSstgHcVtnSe(SearchResultVO param); // 수변 식생
	

	public List searchMeasuredValue(String type);
	
	public List searchResult_H_getDate(SearchResultVO param);
	public List searchResult_H(SearchResultVO param);
	
	public List searchResult_M001_getDate(SearchResultVO param);
	public List searchResult_M001(SearchResultVO param);
	public List searchResult_M002_getDate(SearchResultVO param);
	public List searchResult_M002(SearchResultVO param);
	
	public List searchResult_Q_getDate(SearchResultVO param);
	public List searchResult_Q(SearchResultVO param);
	
	//한기조
	public List searchResult_L_getDate2018(SearchResultVO param);
	public int searchResult_L2018_setParam(SearchResultVO param);
	public List searchResult_L_RESULT_2018(SearchResultVO param);
	
	
	public int searchResult_File_Param(SearchResultVO param);
	public List searchResult_File(SearchResultVO param);
	public List searchResult_View(SearchResultVO param);
	
	public List getSedimentItemValue(SearchResultVO param);
	
	public List searchResult_Z006_2018_getDate(SearchResultVO param);
	public int searchResult_Z006_2018_setParam(SearchResultVO param);
	public List searchResult_Z006_2018_result(SearchResultVO param);
	
	public List searchResult_Z004_2018_getDate(SearchResultVO param);
	public int searchResult_Z004_2018_setParam(SearchResultVO param);
	public List searchResult_Z004_2018_result(SearchResultVO param);
	
	public List searchResult_Z005_2018_getDate(SearchResultVO param);
	public int searchResult_Z005_2018_setParam(SearchResultVO param);
	public List searchResult_Z005_2018_result(SearchResultVO param);
	
	public List searchResult_Z002_2018_getDate(SearchResultVO param);
	public int searchResult_Z002_2018_setParam(SearchResultVO param);
	public List searchResult_Z002_2018_result(SearchResultVO param);
	
	public List searchResult_Z001_2018_getDate(SearchResultVO param);
	public int searchResult_Z001_2018_setParam(SearchResultVO param);
	public List searchResult_Z001_2018_result(SearchResultVO param);
}
