package com.ce.krf.biz.service;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import com.ce.krf.biz.mapper.SearchResultMapper;
import com.ce.krf.biz.model.ChartVO;
import com.ce.krf.biz.model.SearchResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SearchResultService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5081907690257345305L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public SearchResultMapper searchResultMapper;

	
	public HashMap searchSstg(SearchResultVO param) throws Exception{
		
		HashMap result = new HashMap();
		List resultList = null;
		resultList = searchResultMapper.sstg(param);
		result.put("data", resultList);
		return result;
	}
	
	
	
	public HashMap searchSstg_2018(SearchResultVO param) throws Exception{
		
		HashMap result = new HashMap();
		List resultList = null;
		
		for(int i = 0 ; i < param.getSiteIds().length; i++) {
			param.setSiteId2(param.getSiteIds()[i]);
			int dataList = searchResultMapper.searchResult_sstg_2018_setParam(param);				
		}
		
		// 수질측정지점 표준화 검색 쿼리
		resultList = searchResultMapper.sstg2018(param);
		
		result.put("data", resultList);
		return result;
	}
	
	public HashMap searchSstgText(SearchResultVO param) throws Exception{
		
		HashMap result = new HashMap();
		List resultList = null;
		resultList = searchResultMapper.sstgText(param);
		result.put("data", resultList);
		return result;
	}
	
	// 수질측정지점 LAYER CODE : A
	public HashMap searchResult_A(SearchResultVO param) throws Exception {

		//// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_A_getDate(param);
		} else {
//			resultList = searchResultMapper.searchResult_A(param);
			resultList = new ArrayList();
			List searchResult = searchResultMapper.searchResult_A(param);
			if (searchResult.size() > 1) {
				String PT_NO = "";
				String PT_NM = "";
				String WMCYMD = "";
				String WMYR = "";
				String WMOD = "";
				String WMWK = "";
				String WMDEP = "";
				String CURR_BOD = "";
				ArrayList CHART_BOD = new ArrayList();
				ArrayList Chart_Data_tmp = new ArrayList();
				String CURR_DO = "";
				ArrayList CHART_DO = new ArrayList();
				String CURR_COD = "";
				ArrayList CHART_COD = new ArrayList();
				String CURR_TN = "";
				ArrayList CHART_TN = new ArrayList();
				String CURR_TP = "";
				ArrayList CHART_TP = new ArrayList();
				String CURR_TEMP = "";
				ArrayList CHART_TEMP = new ArrayList();
				String CURR_PH = "";
				ArrayList CHART_PH = new ArrayList();
				String CURR_SS = "";
				String CURR_SS_NEW = "";
				ArrayList CHART_SS = new ArrayList();
				String CURR_CLOA = "";
				ArrayList CHART_CLOA = new ArrayList();
				String CURR_TOC = "";
				ArrayList CHART_TOC = new ArrayList();

				String CURR_AMNT = "";
				String CURR_DTN = "";
				String CURR_NO3N = "";
				String CURR_NH3N = "";
				String CURR_DTP = "";
				String CURR_POP = "";
				String CURR_TRANS = "";
				String CURR_ALGOL = "";
				String CURR_TCOLI = "";
				String CURR_ECOLI = "";
				String CURR_ANTIMON = "";
				String CURR_PHENOL = "";
				String CURR_COL = "";
				String CURR_NHEX = "";
				String CURR_MN = "";
				String CURR_FE = "";
				String CURR_CD = "";
				String CURR_CN = "";
				String CURR_PB = "";
				String CURR_CR6 = "";
				String CURR_CR = "";
				String CURR_AS = "";
				String CURR_HG = "";
				String CURR_CU = "";
				String CURR_ZN = "";
				String CURR_FL = "";
				String CURR_ABS = "";
				String CURR_CL = "";
				String CURR_TCE = "";
				String CURR_PCE = "";
				String CURR_CCL4 = "";
				String CURR_DCETH = "";
				String CURR_DCM = "";
				String CURR_BENZENE = "";
				String CURR_CHCL3 = "";
				String CURR_OP = "";
				String CURR_PCB = "";
				String CURR_DEHP = "";
				String CURR_DIOX = "";
				String CURR_HCHO = "";
				String CURR_HCB = "";

				ArrayList CHART_AMNT = new ArrayList();
				ArrayList CHART_DTN = new ArrayList();
				ArrayList CHART_NO3N = new ArrayList();
				ArrayList CHART_NH3N = new ArrayList();
				ArrayList CHART_DTP = new ArrayList();
				ArrayList CHART_POP = new ArrayList();
				ArrayList CHART_TRANS = new ArrayList();
				ArrayList CHART_ALGOL = new ArrayList();
				ArrayList CHART_TCOLI = new ArrayList();
				ArrayList CHART_ECOLI = new ArrayList();
				ArrayList CHART_ANTIMON = new ArrayList();
				ArrayList CHART_PHENOL = new ArrayList();
				ArrayList CHART_COL = new ArrayList();
				ArrayList CHART_NHEX = new ArrayList();
				ArrayList CHART_MN = new ArrayList();
				ArrayList CHART_FE = new ArrayList();
				ArrayList CHART_CD = new ArrayList();
				ArrayList CHART_CN = new ArrayList();
				ArrayList CHART_PB = new ArrayList();
				ArrayList CHART_CR6 = new ArrayList();
				ArrayList CHART_CR = new ArrayList();
				ArrayList CHART_AS = new ArrayList();
				ArrayList CHART_HG = new ArrayList();
				ArrayList CHART_CU = new ArrayList();
				ArrayList CHART_ZN = new ArrayList();
				ArrayList CHART_FL = new ArrayList();
				ArrayList CHART_ABS = new ArrayList();
				ArrayList CHART_CL = new ArrayList();
				ArrayList CHART_TCE = new ArrayList();
				ArrayList CHART_PCE = new ArrayList();
				ArrayList CHART_CCL4 = new ArrayList();
				ArrayList CHART_DCETH = new ArrayList();
				ArrayList CHART_DCM = new ArrayList();
				ArrayList CHART_BENZENE = new ArrayList();
				ArrayList CHART_CHCL3 = new ArrayList();
				ArrayList CHART_OP = new ArrayList();
				ArrayList CHART_PCB = new ArrayList();
				ArrayList CHART_DEHP = new ArrayList(); //
				ArrayList CHART_DIOX = new ArrayList();
				ArrayList CHART_HCHO = new ArrayList();
				ArrayList CHART_HCB = new ArrayList();

				String preSeq = "";

				int cnt = 0;

				for (int i = 0; i < searchResult.size(); i++) {
					cnt++;

					if (!preSeq.equals("")
							&& !preSeq.equals(String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("RN")))
							|| !PT_NO.equals("") && !PT_NO.equals(((HashMap) searchResult.get(i)).get("PT_NO"))) {

						cnt = 1;

						HashMap jsonRecord = new HashMap();

						jsonRecord.put("PT_NO", PT_NO);
						jsonRecord.put("PT_NM", PT_NM);
						jsonRecord.put("WMCYMD", WMCYMD);
						jsonRecord.put("WMYR", WMYR);
						jsonRecord.put("WMOD", WMOD);
						jsonRecord.put("WMWK", WMWK);
						jsonRecord.put("WMDEP", WMDEP);
						jsonRecord.put("CURR_BOD", CURR_BOD);
						jsonRecord.put("CHART_BOD", CHART_BOD);
						jsonRecord.put("CURR_DO", CURR_DO);
						jsonRecord.put("CHART_DO", CHART_DO);
						jsonRecord.put("CURR_COD", CURR_COD);
						jsonRecord.put("CHART_COD", CHART_COD);
						jsonRecord.put("CURR_TN", CURR_TN);
						jsonRecord.put("CHART_TN", CHART_TN);
						jsonRecord.put("CURR_TP", CURR_TP);
						jsonRecord.put("CHART_TP", CHART_TP);
						jsonRecord.put("CURR_TEMP", CURR_TEMP);
						jsonRecord.put("CHART_TEMP", CHART_TEMP);
						jsonRecord.put("CURR_PH", CURR_PH);
						jsonRecord.put("CHART_PH", CHART_PH);
						jsonRecord.put("CURR_SS", CURR_SS);
						jsonRecord.put("CURR_SS_NEW", CURR_SS_NEW);
						jsonRecord.put("CHART_SS", CHART_SS);
						jsonRecord.put("CURR_CLOA", CURR_CLOA);
						jsonRecord.put("CHART_CLOA", CHART_CLOA);
						jsonRecord.put("CURR_TOC", CURR_TOC);
						jsonRecord.put("CHART_TOC", CHART_TOC);
						jsonRecord.put("CURR_AMNT", CURR_AMNT);
						jsonRecord.put("CURR_DTN", CURR_DTN);
						jsonRecord.put("CURR_NO3N", CURR_NO3N);
						jsonRecord.put("CURR_NH3N", CURR_NH3N);
						jsonRecord.put("CURR_DTP", CURR_DTP);
						jsonRecord.put("CURR_POP", CURR_POP);
						jsonRecord.put("CURR_TRANS", CURR_TRANS);
						jsonRecord.put("CURR_ALGOL", CURR_ALGOL);
						jsonRecord.put("CURR_TCOLI", CURR_TCOLI);
						jsonRecord.put("CURR_ECOLI", CURR_ECOLI);
						jsonRecord.put("CURR_ANTIMON", CURR_ANTIMON);
						jsonRecord.put("CURR_PHENOL", CURR_PHENOL);
						jsonRecord.put("CURR_COL", CURR_COL);
						jsonRecord.put("CURR_NHEX", CURR_NHEX);
						jsonRecord.put("CURR_MN", CURR_MN);
						jsonRecord.put("CURR_FE", CURR_FE);
						jsonRecord.put("CURR_CD", CURR_CD);
						jsonRecord.put("CURR_CN", CURR_CN);
						jsonRecord.put("CURR_PB", CURR_PB);
						jsonRecord.put("CURR_CR6", CURR_CR6);
						jsonRecord.put("CURR_CR", CURR_CR);
						jsonRecord.put("CURR_AS", CURR_AS);
						jsonRecord.put("CURR_HG", CURR_HG);
						jsonRecord.put("CURR_CU", CURR_CU);
						jsonRecord.put("CURR_ZN", CURR_ZN);
						jsonRecord.put("CURR_FL", CURR_FL);
						jsonRecord.put("CURR_ABS", CURR_ABS);
						jsonRecord.put("CURR_CL", CURR_CL);
						jsonRecord.put("CURR_TCE", CURR_TCE);
						jsonRecord.put("CURR_PCE", CURR_PCE);
						jsonRecord.put("CURR_CCL4", CURR_CCL4);
						jsonRecord.put("CURR_DCETH", CURR_DCETH);
						jsonRecord.put("CURR_DCM", CURR_DCM);
						jsonRecord.put("CURR_BENZENE", CURR_BENZENE);
						jsonRecord.put("CURR_CHCL3", CURR_CHCL3);
						jsonRecord.put("CURR_OP", CURR_OP);
						jsonRecord.put("CURR_PCB", CURR_PCB);
						jsonRecord.put("CURR_DEHP", CURR_DEHP);
						jsonRecord.put("CURR_DIOX", CURR_DIOX);
						jsonRecord.put("CURR_HCHO", CURR_HCHO);
						jsonRecord.put("CURR_HCB", CURR_HCB);
						jsonRecord.put("CHART_AMNT", CHART_AMNT);
						jsonRecord.put("CHART_DTN", CHART_DTN);
						jsonRecord.put("CHART_NO3N", CHART_NO3N);
						jsonRecord.put("CHART_NH3N", CHART_NH3N);
						jsonRecord.put("CHART_DTP", CHART_DTP);
						jsonRecord.put("CHART_POP", CHART_POP);
						jsonRecord.put("CHART_TRANS", CHART_TRANS);
						jsonRecord.put("CHART_ALGOL", CHART_ALGOL);
						jsonRecord.put("CHART_TCOLI", CHART_TCOLI);
						jsonRecord.put("CHART_ECOLI", CHART_ECOLI);
						jsonRecord.put("CHART_ANTIMON", CHART_ANTIMON);
						jsonRecord.put("CHART_PHENOL", CHART_PHENOL);
						jsonRecord.put("CHART_COL", CHART_COL);
						jsonRecord.put("CHART_NHEX", CHART_NHEX);
						jsonRecord.put("CHART_MN", CHART_MN);
						jsonRecord.put("CHART_FE", CHART_FE);
						jsonRecord.put("CHART_CD", CHART_CD);
						jsonRecord.put("CHART_CN", CHART_CN);
						jsonRecord.put("CHART_PB", CHART_PB);
						jsonRecord.put("CHART_CR6", CHART_CR6);
						jsonRecord.put("CHART_CR", CHART_CR);
						jsonRecord.put("CHART_AS", CHART_AS);
						jsonRecord.put("CHART_HG", CHART_HG);
						jsonRecord.put("CHART_CU", CHART_CU);
						jsonRecord.put("CHART_ZN", CHART_ZN);
						jsonRecord.put("CHART_FL", CHART_FL);
						jsonRecord.put("CHART_ABS", CHART_ABS);
						jsonRecord.put("CHART_CL", CHART_CL);
						jsonRecord.put("CHART_TCE", CHART_TCE);
						jsonRecord.put("CHART_PCE", CHART_PCE);
						jsonRecord.put("CHART_CCL4", CHART_CCL4);
						jsonRecord.put("CHART_DCETH", CHART_DCETH);
						jsonRecord.put("CHART_DCM", CHART_DCM);
						jsonRecord.put("CHART_BENZENE", CHART_BENZENE);
						jsonRecord.put("CHART_CHCL3", CHART_CHCL3);
						jsonRecord.put("CHART_OP", CHART_OP);
						jsonRecord.put("CHART_PCB", CHART_PCB);
						jsonRecord.put("CHART_DEHP", CHART_DEHP);
						jsonRecord.put("CHART_DIOX", CHART_DIOX);
						jsonRecord.put("CHART_HCHO", CHART_HCHO);
						jsonRecord.put("CHART_HCB", CHART_HCB);

						resultList.add(jsonRecord);

						CHART_BOD = new ArrayList();
						CHART_DO = new ArrayList();
						CHART_COD = new ArrayList();
						CHART_TN = new ArrayList();
						CHART_TP = new ArrayList();
						CHART_TEMP = new ArrayList();
						CHART_PH = new ArrayList();
						CHART_SS = new ArrayList();
						CHART_CLOA = new ArrayList();
						CHART_TOC = new ArrayList();

						CHART_AMNT = new ArrayList();
						CHART_DTN = new ArrayList();
						CHART_NO3N = new ArrayList();
						CHART_NH3N = new ArrayList();
						CHART_DTP = new ArrayList();
						CHART_POP = new ArrayList();
						CHART_TRANS = new ArrayList();
						CHART_ALGOL = new ArrayList();
						CHART_TCOLI = new ArrayList();
						CHART_ECOLI = new ArrayList();
						CHART_ANTIMON = new ArrayList();
						CHART_PHENOL = new ArrayList();
						CHART_COL = new ArrayList();
						CHART_NHEX = new ArrayList();
						CHART_MN = new ArrayList();
						CHART_FE = new ArrayList();
						CHART_CD = new ArrayList();
						CHART_CN = new ArrayList();
						CHART_PB = new ArrayList();
						CHART_CR6 = new ArrayList();
						CHART_CR = new ArrayList();
						CHART_AS = new ArrayList();
						CHART_HG = new ArrayList();
						CHART_CU = new ArrayList();
						CHART_ZN = new ArrayList();
						CHART_FL = new ArrayList();
						CHART_ABS = new ArrayList();
						CHART_CL = new ArrayList();
						CHART_TCE = new ArrayList();
						CHART_PCE = new ArrayList();
						CHART_CCL4 = new ArrayList();
						CHART_DCETH = new ArrayList();
						CHART_DCM = new ArrayList();
						CHART_BENZENE = new ArrayList();
						CHART_CHCL3 = new ArrayList();
						CHART_OP = new ArrayList();
						CHART_PCB = new ArrayList();
						CHART_DEHP = new ArrayList();
						CHART_DIOX = new ArrayList();
						CHART_HCHO = new ArrayList();
						CHART_HCB = new ArrayList();

					}

					PT_NO = ((HashMap<String, String>) searchResult.get(i)).get("PT_NO");
					PT_NM = ((HashMap<String, String>) searchResult.get(i)).get("PT_NM");
					WMCYMD = ((HashMap<String, String>) searchResult.get(i)).get("WMCYMD");
					WMYR = ((HashMap<String, String>) searchResult.get(i)).get("WMYR");
					WMOD = ((HashMap<String, String>) searchResult.get(i)).get("WMOD");
					WMWK = ((HashMap<String, String>) searchResult.get(i)).get("WMWK");
					WMDEP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("WMDEP"));
					if(WMDEP == null || "null".equals(WMDEP)) {
						WMDEP = "";
					}
					CURR_BOD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BOD"));
					Chart_Data_tmp = new ArrayList();

					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BOD"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BOD") != null) {
						CHART_BOD.add(Chart_Data_tmp);
					}

					CURR_DO = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DO"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DO"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DO") != null) {
						CHART_DO.add(Chart_Data_tmp);
					}

					CURR_COD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_COD"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_COD"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_COD") != null) {
						CHART_COD.add(Chart_Data_tmp);
					}

					CURR_TN = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TN"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TN"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TN") != null) {
						CHART_TN.add(Chart_Data_tmp);
					}

					CURR_TP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TP"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TP"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TP") != null) {
						CHART_TP.add(Chart_Data_tmp);
					}

					CURR_TEMP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TEMP"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TEMP"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TEMP") != null) {
						CHART_TEMP.add(Chart_Data_tmp);
					}
					CURR_PH = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PH"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PH"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PH") != null) {
						CHART_PH.add(Chart_Data_tmp);
					}

					CURR_SS = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_SS"));
					CURR_SS_NEW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_SS_NEW"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_SS"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_SS") != null) {
						CHART_SS.add(Chart_Data_tmp);
					}

					CURR_CLOA = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CLOA"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CLOA"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CLOA") != null) {
						CHART_CLOA.add(Chart_Data_tmp);
					}

					CURR_TOC = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TOC"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TOC"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TOC") != null) {
						CHART_TOC.add(Chart_Data_tmp);
					}

					CURR_AMNT = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_AMNT"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_AMNT"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_AMNT") != null) {
						CHART_AMNT.add(Chart_Data_tmp);
					}

					CURR_DTN = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DTN"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DTN"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DTN") != null) {
						CHART_DTN.add(Chart_Data_tmp);
					}

					CURR_NO3N = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_NO3N"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_NO3N"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_NO3N") != null) {
						CHART_NO3N.add(Chart_Data_tmp);
					}

					CURR_NH3N = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_NH3N"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_NH3N"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_NH3N") != null) {
						CHART_NH3N.add(Chart_Data_tmp);
					}

					CURR_DTP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DTP"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DTP"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DTP") != null) {
						CHART_DTP.add(Chart_Data_tmp);
					}

					CURR_POP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_POP"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_POP"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_POP") != null) {
						CHART_POP.add(Chart_Data_tmp);
					}

					CURR_TRANS = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TRANS"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TRANS"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TRANS") != null) {
						CHART_TRANS.add(Chart_Data_tmp);
					}

					CURR_ALGOL = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ALGOL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ALGOL"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ALGOL") != null) {
						CHART_ALGOL.add(Chart_Data_tmp);
					}

					CURR_TCOLI = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TCOLI"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TCOLI"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TCOLI") != null) {
						CHART_TCOLI.add(Chart_Data_tmp);
					}

					CURR_ECOLI = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ECOLI"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ECOLI"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ECOLI") != null) {
						CHART_ECOLI.add(Chart_Data_tmp);
					}

					CURR_ANTIMON = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ANTIMON"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ANTIMON"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ANTIMON") != null) {
						CHART_ANTIMON.add(Chart_Data_tmp);
					}

					CURR_PHENOL = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PHENOL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PHENOL"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PHENOL") != null) {
						CHART_PHENOL.add(Chart_Data_tmp);
					}

					CURR_COL = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_COL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_COL"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_COL") != null) {
						CHART_COL.add(Chart_Data_tmp);
					}

					CURR_NHEX = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_NHEX"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_NHEX"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_NHEX") != null) {
						CHART_NHEX.add(Chart_Data_tmp);
					}

					CURR_MN = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_MN"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_MN"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_MN") != null) {
						CHART_MN.add(Chart_Data_tmp);
					}

					CURR_FE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FE"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FE"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_FE") != null) {
						CHART_FE.add(Chart_Data_tmp);
					}

					CURR_CD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CD"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CD"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CD") != null) {
						CHART_CD.add(Chart_Data_tmp);
					}

					CURR_CN = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CN"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CN"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CN") != null) {
						CHART_CN.add(Chart_Data_tmp);
					}

					CURR_PB = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PB"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PB"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PB") != null) {
						CHART_PB.add(Chart_Data_tmp);
					}

					CURR_CR6 = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CR6"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CR6"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CR6") != null) {
						CHART_CR6.add(Chart_Data_tmp);
					}

					CURR_CR = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CR"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CR"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CR") != null) {
						CHART_CR.add(Chart_Data_tmp);
					}

					CURR_AS = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_AS"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_AS"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_AS") != null) {
						CHART_AS.add(Chart_Data_tmp);
					}

					CURR_HG = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_HG"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_HG"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_HG") != null) {
						CHART_HG.add(Chart_Data_tmp);
					}

					CURR_CU = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CU"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CU"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CU") != null) {
						CHART_CU.add(Chart_Data_tmp);
					}

					CURR_ZN = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ZN"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ZN"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ZN") != null) {
						CHART_ZN.add(Chart_Data_tmp);
					}

					CURR_FL = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FL"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_FL") != null) {
						CHART_FL.add(Chart_Data_tmp);
					}

					CURR_ABS = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ABS"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ABS"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ABS") != null) {
						CHART_ABS.add(Chart_Data_tmp);
					}

					CURR_CL = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CL"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CL") != null) {
						CHART_CL.add(Chart_Data_tmp);
					}

					CURR_TCE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TCE"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TCE"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TCE") != null) {
						CHART_TCE.add(Chart_Data_tmp);
					}

					CURR_PCE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PCE"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PCE"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PCE") != null) {
						CHART_PCE.add(Chart_Data_tmp);
					}

					CURR_CCL4 = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CCL4"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CCL4"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CCL4") != null) {
						CHART_CCL4.add(Chart_Data_tmp);
					}

					CURR_DCETH = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DCETH"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DCETH"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DCETH") != null) {
						CHART_DCETH.add(Chart_Data_tmp);
					}

					CURR_DCM = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DCM"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DCM"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DCM") != null) {
						CHART_DCM.add(Chart_Data_tmp);
					}

					CURR_BENZENE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BENZENE"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZENE"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZENE") != null) {
						CHART_BENZENE.add(Chart_Data_tmp);
					}

					CURR_CHCL3 = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CHCL3"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CHCL3"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CHCL3") != null) {
						CHART_CHCL3.add(Chart_Data_tmp);
					}

					CURR_OP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_OP"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_OP"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_OP") != null) {
						CHART_OP.add(Chart_Data_tmp);
					}

					CURR_PCB = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PCB"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PCB"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PCB") != null) {
						CHART_PCB.add(Chart_Data_tmp);
					}

					CURR_DEHP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DEHP"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DEHP"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DEHP") != null) {
						CHART_DEHP.add(Chart_Data_tmp);
					}

					CURR_DIOX = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DIOX"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DIOX"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DIOX") != null) {
						CHART_DIOX.add(Chart_Data_tmp);
					}

					CURR_HCHO = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_HCHO"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_HCHO"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_HCHO") != null) {
						CHART_HCHO.add(Chart_Data_tmp);
					}

					CURR_HCB = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_HCB"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(
							cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
					Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_HCB"));
					if (((HashMap<String, String>) searchResult.get(i)).get("CHART_HCB") != null) {
						CHART_HCB.add(Chart_Data_tmp);
					}

					if (!preSeq.equals(((HashMap<String, String>) searchResult.get(i)).get("RN"))) {
						preSeq = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("RN"));
					}

				}

				HashMap jsonRecord = new HashMap();

				if (cnt > 0) {
					jsonRecord.put("PT_NO", PT_NO);
					jsonRecord.put("PT_NM", PT_NM);
					jsonRecord.put("WMCYMD", WMCYMD);
					jsonRecord.put("WMYR", WMYR);
					jsonRecord.put("WMOD", WMOD);
					jsonRecord.put("WMWK", WMWK);
					jsonRecord.put("WMDEP", WMDEP);
					jsonRecord.put("CURR_BOD", CURR_BOD);
					jsonRecord.put("CHART_BOD", CHART_BOD);
					jsonRecord.put("CURR_DO", CURR_DO);
					jsonRecord.put("CHART_DO", CHART_DO);
					jsonRecord.put("CURR_COD", CURR_COD);
					jsonRecord.put("CHART_COD", CHART_COD);
					jsonRecord.put("CURR_TN", CURR_TN);
					jsonRecord.put("CHART_TN", CHART_TN);
					jsonRecord.put("CURR_TP", CURR_TP);
					jsonRecord.put("CHART_TP", CHART_TP);
					jsonRecord.put("CURR_TEMP", CURR_TEMP);
					jsonRecord.put("CHART_TEMP", CHART_TEMP);
					jsonRecord.put("CURR_PH", CURR_PH);
					jsonRecord.put("CHART_PH", CHART_PH);
					jsonRecord.put("CURR_SS", CURR_SS);
					jsonRecord.put("CURR_SS_NEW", CURR_SS_NEW);
					jsonRecord.put("CHART_SS", CHART_SS);
					jsonRecord.put("CURR_CLOA", CURR_CLOA);
					jsonRecord.put("CHART_CLOA", CHART_CLOA);
					jsonRecord.put("CURR_TOC", CURR_TOC);
					jsonRecord.put("CHART_TOC", CHART_TOC);
					jsonRecord.put("CURR_AMNT", CURR_AMNT);
					jsonRecord.put("CURR_DTN", CURR_DTN);
					jsonRecord.put("CURR_NO3N", CURR_NO3N);
					jsonRecord.put("CURR_NH3N", CURR_NH3N);
					jsonRecord.put("CURR_DTP", CURR_DTP);
					jsonRecord.put("CURR_POP", CURR_POP);
					jsonRecord.put("CURR_TRANS", CURR_TRANS);
					jsonRecord.put("CURR_ALGOL", CURR_ALGOL);
					jsonRecord.put("CURR_TCOLI", CURR_TCOLI);
					jsonRecord.put("CURR_ECOLI", CURR_ECOLI);
					jsonRecord.put("CURR_ANTIMON", CURR_ANTIMON);
					jsonRecord.put("CURR_PHENOL", CURR_PHENOL);
					jsonRecord.put("CURR_COL", CURR_COL);
					jsonRecord.put("CURR_NHEX", CURR_NHEX);
					jsonRecord.put("CURR_MN", CURR_MN);
					jsonRecord.put("CURR_FE", CURR_FE);
					jsonRecord.put("CURR_CD", CURR_CD);
					jsonRecord.put("CURR_CN", CURR_CN);
					jsonRecord.put("CURR_PB", CURR_PB);
					jsonRecord.put("CURR_CR6", CURR_CR6);
					jsonRecord.put("CURR_CR", CURR_CR);
					jsonRecord.put("CURR_AS", CURR_AS);
					jsonRecord.put("CURR_HG", CURR_HG);
					jsonRecord.put("CURR_CU", CURR_CU);
					jsonRecord.put("CURR_ZN", CURR_ZN);
					jsonRecord.put("CURR_FL", CURR_FL);
					jsonRecord.put("CURR_ABS", CURR_ABS);
					jsonRecord.put("CURR_CL", CURR_CL);
					jsonRecord.put("CURR_TCE", CURR_TCE);
					jsonRecord.put("CURR_PCE", CURR_PCE);
					jsonRecord.put("CURR_CCL4", CURR_CCL4);
					jsonRecord.put("CURR_DCETH", CURR_DCETH);
					jsonRecord.put("CURR_DCM", CURR_DCM);
					jsonRecord.put("CURR_BENZENE", CURR_BENZENE);
					jsonRecord.put("CURR_CHCL3", CURR_CHCL3);
					jsonRecord.put("CURR_OP", CURR_OP);
					jsonRecord.put("CURR_PCB", CURR_PCB);
					jsonRecord.put("CURR_DEHP", CURR_DEHP);
					jsonRecord.put("CURR_DIOX", CURR_DIOX);
					jsonRecord.put("CURR_HCHO", CURR_HCHO);
					jsonRecord.put("CURR_HCB", CURR_HCB);
					jsonRecord.put("CHART_AMNT", CHART_AMNT);
					jsonRecord.put("CHART_DTN", CHART_DTN);
					jsonRecord.put("CHART_NO3N", CHART_NO3N);
					jsonRecord.put("CHART_NH3N", CHART_NH3N);
					jsonRecord.put("CHART_DTP", CHART_DTP);
					jsonRecord.put("CHART_POP", CHART_POP);
					jsonRecord.put("CHART_TRANS", CHART_TRANS);
					jsonRecord.put("CHART_ALGOL", CHART_ALGOL);
					jsonRecord.put("CHART_TCOLI", CHART_TCOLI);
					jsonRecord.put("CHART_ECOLI", CHART_ECOLI);
					jsonRecord.put("CHART_ANTIMON", CHART_ANTIMON);
					jsonRecord.put("CHART_PHENOL", CHART_PHENOL);
					jsonRecord.put("CHART_COL", CHART_COL);
					jsonRecord.put("CHART_NHEX", CHART_NHEX);
					jsonRecord.put("CHART_MN", CHART_MN);
					jsonRecord.put("CHART_FE", CHART_FE);
					jsonRecord.put("CHART_CD", CHART_CD);
					jsonRecord.put("CHART_CN", CHART_CN);
					jsonRecord.put("CHART_PB", CHART_PB);
					jsonRecord.put("CHART_CR6", CHART_CR6);
					jsonRecord.put("CHART_CR", CHART_CR);
					jsonRecord.put("CHART_AS", CHART_AS);
					jsonRecord.put("CHART_HG", CHART_HG);
					jsonRecord.put("CHART_CU", CHART_CU);
					jsonRecord.put("CHART_ZN", CHART_ZN);
					jsonRecord.put("CHART_FL", CHART_FL);
					jsonRecord.put("CHART_ABS", CHART_ABS);
					jsonRecord.put("CHART_CL", CHART_CL);
					jsonRecord.put("CHART_TCE", CHART_TCE);
					jsonRecord.put("CHART_PCE", CHART_PCE);
					jsonRecord.put("CHART_CCL4", CHART_CCL4);
					jsonRecord.put("CHART_DCETH", CHART_DCETH);
					jsonRecord.put("CHART_DCM", CHART_DCM);
					jsonRecord.put("CHART_BENZENE", CHART_BENZENE);
					jsonRecord.put("CHART_CHCL3", CHART_CHCL3);
					jsonRecord.put("CHART_OP", CHART_OP);
					jsonRecord.put("CHART_PCB", CHART_PCB);
					jsonRecord.put("CHART_DEHP", CHART_DEHP);
					jsonRecord.put("CHART_DIOX", CHART_DIOX);
					jsonRecord.put("CHART_HCHO", CHART_HCHO);
					jsonRecord.put("CHART_HCB", CHART_HCB);
				}
				resultList.add(jsonRecord);
			}

			
			//
		}
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	
	//detialSearchResult
	public HashMap detailSearchResult(SearchResultVO param) throws Exception {
		//getDetailSiteIds
		// param.setSiteIds();
		// getGroupCode()
		HashMap result = new HashMap();
		List resultList = null;
		
		for(int i = 0 ; i < param.getDetailSiteIds().length; i++) {
			
			String[] detailValue = param.getDetailSiteIds()[i].split("_");
			param.setGroupCode(detailValue[0]);
			param.setDetailSiteIds2(detailValue[1]);
			int dataList = searchResultMapper.detailSearchSetParam(param);				
		}

		resultList = searchResultMapper.detailSearchResult(param);
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	
	// 수질측정지점 LAYER CODE : A _ 2018 ( 표준화테이블 )
	public HashMap searchResult_A2018(SearchResultVO param) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {
			//resultList = searchResultMapper.searchResult_A_getDate(param);
			resultList = searchResultMapper.searchResult_A_getDate2018(param);
		} else {
			
			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);
				int dataList = searchResultMapper.searchResult_A2018_setParam(param);				
			}
			
			// 수질측정지점 표준화 검색 쿼리
			resultList = searchResultMapper.searchResult_A_RESULT_2018(param);
			          
		}
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	public HashMap searchResult_Z_2018(SearchResultVO param, String index) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {

			Method method = searchResultMapper.getClass().getMethod("searchResult_Z" + index + "_2018_getDate",SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper,param);
		} else {

			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);

				Method method = searchResultMapper.getClass().getMethod("searchResult_Z" + index + "_2018_setParam",SearchResultVO.class);
				int dataList = (int) method.invoke(searchResultMapper,param);
			}

			Method method = searchResultMapper.getClass().getMethod("searchResult_Z" + index + "_2018_result",SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper,param);

		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	public HashMap searchResultWindow_Z(SearchResultVO param, String index) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;


		// 지점코드 하나씩 insert 하기 (검색조건)
		for(int i = 0 ; i < param.getSiteIds().length; i++) {
			param.setSiteId2(param.getSiteIds()[i]);

			Method method = searchResultMapper.getClass().getMethod("searchResultWindow_Z_setParam",SearchResultVO.class);
			int dataList = (int) method.invoke(searchResultMapper,param);
		}

		Method method = searchResultMapper.getClass().getMethod("searchResultWindow_Z_" + index + "_result",SearchResultVO.class);
		resultList = (List) method.invoke(searchResultMapper,param);


		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}

	// 수질측정지점 LAYER CODE : B
	public HashMap searchResult_B(SearchResultVO param) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_B_getDate(param);
		} else {
			resultList = searchResultMapper.searchResult_B(param);
		}
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	// 수질측정지점 LAYER CODE : B
	public HashMap searchResult_B2018(SearchResultVO param) throws Exception {

		// param.setSiteIds();
				HashMap result = new HashMap();
				List resultList = null;

				if ("noDate".equals(param.getFirstSearch())) {
					//resultList = searchResultMapper.searchResult_A_getDate(param);
					resultList = searchResultMapper.searchResult_B_getDate2018(param);
				} else {
					
					// 지점코드 하나씩 insert 하기 (검색조건)
					for(int i = 0 ; i < param.getSiteIds().length; i++) {
						param.setSiteId2(param.getSiteIds()[i]);
						int dataList = searchResultMapper.searchResult_B2018_setParam(param);				
					}
					
					// 수질측정지점 표준화 검색 쿼리
					resultList = searchResultMapper.searchResult_B_RESULT_2018(param);
					          
				}
				
				if (checkNull(resultList)) {
					HashMap nullMgs = new HashMap();
					nullMgs.put("msg", "데이터가 존재하지 않습니다.");
					resultList = new ArrayList();
					resultList.add(nullMgs);
				}
				result.put("data", resultList);
				return result;

	}

	// 수질자동측정지점 - 수질자동측정지점 미확정 GROUP CODE : B
	public HashMap searchResult_B001(SearchResultVO param) throws Exception {
		HashMap result = new HashMap();
		List resultList = null;
		
		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_B001_getDate(param);
//			ObjectMapper om = new ObjectMapper(); 
//			String arrStr = om.writeValueAsString(resultList);
//			
//			logger.info(arrStr);
		}else {
			resultList = searchResultMapper.searchResult_B001(param);
		}
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		
		return result;
	}

	// 수질자동측정지점 - 수질자동측정지점 확정 GROUP CODE : B
	public HashMap searchResult_B001_Fix(SearchResultVO param) throws Exception {
		HashMap result = new HashMap();
		List resultList = null;
		
		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_B001_getDate(param);
//			ObjectMapper om = new ObjectMapper(); 
//			String arrStr = om.writeValueAsString(resultList);
//			
//			logger.info(arrStr);
		}else {
			resultList = searchResultMapper.searchResult_B001_Fix(param);
		}
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		
		return result;
	}
	
	// 퇴적물 LAYER CODE : C
	public HashMap searchResult_C2018(SearchResultVO param) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;
		
		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_C_getDate2018(param);
		} else {
			
			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);
				int dataList = searchResultMapper.searchResult_C2018_setParam(param);				
			}
			
			// 수질측정지점 표준화 검색 쿼리
			resultList = searchResultMapper.searchResult_C_RESULT_2018(param);
			          
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	// 퇴적물 LAYER CODE : C
	public HashMap searchResult_C(SearchResultVO param) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_C_getDate(param);
		} else {
			resultList = searchResultMapper.searchResult_C(param);
		}
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}

	public HashMap searchResult_D(String gubun, SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		// param.setSiteIds();

		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			resultList = searchResultMapper.searchResult_D_getDate(param);
		} else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_D_" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	public HashMap searchResult_D_2018(String gubun, SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		// param.setSiteIds();
		
		

		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			resultList = searchResultMapper.searchResult_D_2018_getDate(param);
		} else {
			
			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);
				if(param.getGubun().equals('7')) {
					int dataList = searchResultMapper.searchResult_D2018_setParam_7(param);
				}else {
					int dataList = searchResultMapper.searchResult_D2018_setParam(param);
				}
								
			}
			
			Method method = searchResultMapper.getClass().getMethod("searchResult_D_2018_" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	// 환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	public HashMap searchResult_F_2018(String gubun, SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		// param.setSiteIds();
		
		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			resultList = searchResultMapper.searchResult_F_2018_getDate(param);
		} else {
			
			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);
				int dataList = searchResultMapper.searchResult_F2018_setParam(param);				
			}
			
			Method method = searchResultMapper.getClass().getMethod("searchResult_F_2018_" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
		}


		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}

	// 환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	public HashMap searchResult_F(String gubun, SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		// param.setSiteIds();

		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			resultList = searchResultMapper.searchResult_F_getDate(param);
		} else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_F_" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	// 조류모니터링 GROUP CODE : I
	public HashMap searchResult_I2018(String gubun, SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		// param.setSiteIds();

		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			resultList = searchResultMapper.searchResult_I_2018_getDate(param);
		} else {
			
			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);
				int dataList = searchResultMapper.searchResult_I2018_setParam(param);				
			}
			
			Method method = searchResultMapper.getClass().getMethod("searchResult_I_2018_" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	// 조류모니터링 GROUP CODE : I
	public HashMap searchResult_I(String gubun, SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		// param.setSiteIds();

		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			resultList = searchResultMapper.searchResult_I_getDate(param);
		} else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_I_" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	// 취정수장 GROUP CODE : J
	public HashMap searchResult_J(String gubun, SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		Method method = searchResultMapper.getClass().getMethod("searchResult_J" + gubun, SearchResultVO.class);
		resultList = (List) method.invoke(searchResultMapper, param);

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}

	// 부하량 - 총괄표
	public HashMap searchResult_PollLoad(String gubun, SearchResultVO param) throws Exception {
		HashMap result = new HashMap();
		
		param.setCatDids(param.getCatDid().replaceAll("'", "").split(","));
		
		List resultList = null;
		Method method = searchResultMapper.getClass().getMethod("searchResult_PollLoad_" + gubun, SearchResultVO.class);
		resultList = (List) method.invoke(searchResultMapper, param);
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}

	
	// 수생태계
	public HashMap searchSstg(String gubun, SearchResultVO param) throws Exception {
		HashMap result = new HashMap();
		List resultList = null;
		
		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			resultList = searchResultMapper.searchSstg_getDate(param);
			ObjectMapper om = new ObjectMapper(); 
			String arrStr = om.writeValueAsString(resultList);
			
			logger.info(arrStr);
		}else {
			Method method = searchResultMapper.getClass().getMethod("searchSstg" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
			//resultList = searchResultMapper.searchSstgHgAtalSe(param);
		}
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		
		return result;
	}
	
	// 수생태계 2018
	public HashMap searchSstg2018(String gubun, SearchResultVO param) throws Exception {
		HashMap result = new HashMap();
		List resultList = null;
		
		
		if ("noDate".equals(param.getFirstSearch())) {
			
			resultList = searchResultMapper.searchSstg_2018_getDate(param);
			
		} else {
			
			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);
				int dataList = searchResultMapper.searchResult_Esstg_2018_setParam(param);				
			}
			
			// 수질측정지점 표준화 검색 쿼리
			Method method = searchResultMapper.getClass().getMethod("searchSstg_2018_" + gubun, SearchResultVO.class);
			resultList = (List) method.invoke(searchResultMapper, param);
			          
		}
		
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		
		return result;
	}
	
	
	
	public HashMap searchMeasuredValue(String type) throws Exception {
		HashMap result = new HashMap();
		
		List resultList = searchResultMapper.searchMeasuredValue(type);
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		
		return result;
	}
	
	// 조류모니터링 GROUP CODE : H
	public HashMap searchResult_H(SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		// param.setSiteIds();

		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_H_getDate(param);
		} else {
			resultList = searchResultMapper.searchResult_H(param);
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	public HashMap searchResult_M(SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;
		
		String[] siteId = param.getSiteIds();
		String[] split = siteId[0].split("_");
		
		for(int i = 0; i < siteId.length; i++) {
			siteId[i] = siteId[i].split("_")[1];
		}
		
		param.setSiteIds(siteId);
		
		if ("noDate".equals(param.getFirstSearch())) {
			if("M001".equals(split[0])) {
				resultList = searchResultMapper.searchResult_M001_getDate(param);
			}else {
				resultList = searchResultMapper.searchResult_M002_getDate(param);
			}
		} else {
			if("M001".equals(split[0])) {
				resultList = searchResultMapper.searchResult_M001(param);
			}else {
				resultList = searchResultMapper.searchResult_M002(param);
			}
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	public HashMap searchResult_Q(SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_Q_getDate(param);
		} else {
			resultList = searchResultMapper.searchResult_Q(param);
		}

		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	
	// 한기조  LAYER CODE : L _ 2018 ( 표준화테이블 )
	public HashMap searchResult_L2018(SearchResultVO param) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_L_getDate2018(param);
		} else {
			
			// 지점코드 하나씩 insert 하기 (검색조건)
			for(int i = 0 ; i < param.getSiteIds().length; i++) {
				param.setSiteId2(param.getSiteIds()[i]);
				int dataList = searchResultMapper.searchResult_L2018_setParam(param);				
			}
			
			// 수질측정지점 표준화 검색 쿼리
			resultList = searchResultMapper.searchResult_L_RESULT_2018(param);
			          
		}
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	// 한기조  LAYER CODE : L _ 2018 ( 표준화테이블 ) 보고서 데이터
		public HashMap searchResult_L2018_Window(SearchResultVO param) throws Exception {

			// param.setSiteIds();
			HashMap result = new HashMap();
			List resultList = null;

			resultList = searchResultMapper.searchResult_L_RESULT_2018_Window(param);
			
			if (checkNull(resultList)) {
				HashMap nullMgs = new HashMap();
				nullMgs.put("msg", "데이터가 존재하지 않습니다.");
				resultList = new ArrayList();
				resultList.add(nullMgs);
			}
			result.put("data", resultList);
			return result;

		}
	
	// 통합환경허가  LAYER CODE : K _ 2018 ( 표준화테이블 )
	public HashMap searchResult_K2018(SearchResultVO param) throws Exception {

		// param.setSiteIds();
		HashMap result = new HashMap();
		List resultList = null;

		if ("noDate".equals(param.getFirstSearch())) {
			resultList = searchResultMapper.searchResult_K_getDate2018(param);
		} else {
			
			// 수질측정지점 표준화 검색 쿼리
			resultList = searchResultMapper.searchResult_K_RESULT_2018(param);
			          
		}
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;

	}
	
	// 보고서
	public HashMap searchResult_File(SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;
		
		resultList = searchResultMapper.searchResult_File(param);
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	// 경관
	public HashMap searchResult_View(SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;
		
		resultList = searchResultMapper.searchResult_View(param);
		
		if (checkNull(resultList)) {
			HashMap nullMgs = new HashMap();
			nullMgs.put("msg", "데이터가 존재하지 않습니다.");
			resultList = new ArrayList();
			resultList.add(nullMgs);
		}
		result.put("data", resultList);
		return result;
	}
	
	/*// 부하량 - 표준유역단위
	public List searchResult_PollLoad_Standard(SearchResultVO param) throws Exception {
		param.setCatDids(param.getCatDid().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_PollLoad_Standard(param);
		return result;
	}

	// 부하량 - 집수구역단위
	public List searchResult_PollLoad_Cat(SearchResultVO param) throws Exception {
		param.setCatDids(param.getCatDid().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_PollLoad_Cat(param);
		return result;
	}

	// 부하량 - 집수구역단위_상세
	public List searchResult_PollLoad_Cat_Detail(SearchResultVO param) throws Exception {
		param.setCatDids(param.getCatDid().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_PollLoad_Cat_Detail(param);
		return result;
	}*/

	private boolean checkNull(List resultList) {
		if (resultList == null || resultList.size() <= 0 || (resultList.size() > 0 && resultList.get(0) == null)) {
			return true;
		}
		//((HashMap<String, String>) resultList.get(0)).get("NO") == null
		return false;
	}
	
	public HashMap getSedimentItemValue(SearchResultVO param) throws Exception {

		HashMap result = new HashMap();
		List resultList = null;

		resultList = searchResultMapper.getSedimentItemValue(param);
		result.put("data", resultList);
		return result;
	}
}
