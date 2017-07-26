package com.ce.krf.biz.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
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

	// 수질측정지점 LAYER CODE : A
	public HashMap searchResult_A(SearchResultVO param) throws Exception {
		param.setSiteIds();
		HashMap result = new HashMap();
		List searchResult = null;

		if ("noDate".equals(param.getFirstSearch())) {
			
			searchResult = searchResultMapper.searchResult_A_getDate(param);
			
			if (checkNull(searchResult)) {
				HashMap nullMgs = new HashMap();
				nullMgs.put("msg", "데이터가 존재하지 않습니다.");
				searchResult = new ArrayList();
				searchResult.add(nullMgs);
			}

			result.put("data", searchResult);
			
		} else {
			searchResult = searchResultMapper.searchResult_A(param);

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

			List jsonArr = new ArrayList();

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

					jsonArr.add(jsonRecord);

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

				CURR_BOD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BOD"));
				Chart_Data_tmp = new ArrayList();

				Chart_Data_tmp.add(
						cnt+ ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
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
			jsonArr.add(jsonRecord);
			
			if (checkNull(jsonArr)) {
				HashMap nullMgs = new HashMap();
				nullMgs.put("msg", "데이터가 존재하지 않습니다.");
				jsonArr = new ArrayList();
				jsonArr.add(nullMgs);
			}

			result.put("data", jsonArr);

		}
		return result;
	}

	// 수질측정지점 LAYER CODE : B
	public HashMap searchResult_B(SearchResultVO param) throws Exception {

		param.setSiteIds();

		HashMap result = new HashMap();
		List searchResult = null;

		if ("noDate".equals(param.getFirstSearch())) {

			result.put("data", searchResultMapper.searchResult_B_getDate(param));

		} else {
			searchResult = searchResultMapper.searchResult_B(param);

			ArrayList jsonArr = new ArrayList();

			String preSeq = "";
			String WS_NM = "";
			String AM_NM = "";
			String AS_NM = "";
			String PT_NO = "";
			String PT_NM = "";
			String WAST_NO = "";
			String FACT_KIND_NAME = "";
			String FACT_CAPACITY = "";
			String WMCYMD = "";
			String CHART_DATE = "";
			String CURR_BOD = "";

			ArrayList CHART_BOD = new ArrayList();
			ArrayList Chart_Data_tmp = new ArrayList();

			String CURR_COD = "";
			ArrayList CHART_COD = new ArrayList();

			String CURR_SS = "";
			ArrayList CHART_SS = new ArrayList();

			String CURR_TN = "";
			ArrayList CHART_TN = new ArrayList();

			String CURR_TP = "";
			ArrayList CHART_TP = new ArrayList();

			String CURR_PH = "";
			ArrayList CHART_PH = new ArrayList();

			String CURR_FLW = "";
			ArrayList CHART_FLW = new ArrayList();

			String CURR_TOC = "";
			ArrayList CHART_TOC = new ArrayList();

			String DO_NM = "";
			String CTY_NM = "";
			String DONG_NM = "";
			String RI_NM = "";

			int cnt = 0;

			for (int i = 0; i < searchResult.size(); i++) {
				cnt++;
				if (!preSeq.equals("")
						&& !preSeq.equals(String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("RN")))
						|| !PT_NO.equals("") && !PT_NO.equals(((HashMap) searchResult.get(i)).get("PT_NO"))) {

					cnt = 1;

					HashMap jsonRecord = new HashMap();

					jsonRecord.put("WS_NM", WS_NM);
					jsonRecord.put("AM_NM", AM_NM);
					jsonRecord.put("AS_NM", AS_NM);
					jsonRecord.put("PT_NO", PT_NO);
					jsonRecord.put("PT_NM", PT_NM);
					jsonRecord.put("WAST_NO", WAST_NO);
					jsonRecord.put("FACT_KIND_NAME", FACT_KIND_NAME);
					jsonRecord.put("FACT_CAPACITY", FACT_CAPACITY);
					jsonRecord.put("WMCYMD", WMCYMD);
					jsonRecord.put("CHART_DATE", CHART_DATE);
					jsonRecord.put("CURR_BOD", CURR_BOD);
					jsonRecord.put("CHART_BOD", CHART_BOD);
					jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);
					jsonRecord.put("CURR_COD", CURR_COD);
					jsonRecord.put("CHART_COD", CHART_COD);
					jsonRecord.put("CURR_SS", CURR_SS);
					jsonRecord.put("CHART_SS", CHART_SS);
					jsonRecord.put("CURR_TN", CURR_TN);
					jsonRecord.put("CHART_TN", CHART_TN);
					jsonRecord.put("CURR_TP", CURR_TP);
					jsonRecord.put("CHART_TP", CHART_TP);
					jsonRecord.put("CURR_PH", CURR_PH);
					jsonRecord.put("CHART_PH", CHART_PH);
					jsonRecord.put("CURR_FLW", CURR_FLW);
					jsonRecord.put("CHART_FLW", CHART_FLW);
					jsonRecord.put("CURR_TOC", CURR_TOC);
					jsonRecord.put("CHART_TOC", CHART_TOC);
					jsonRecord.put("DO_NM", DO_NM);
					jsonRecord.put("CTY_NM", CTY_NM);
					jsonRecord.put("DONG_NM", DONG_NM);
					jsonRecord.put("RI_NM", RI_NM);

					jsonArr.add(jsonRecord);

					CHART_BOD = new ArrayList();
					CHART_COD = new ArrayList();
					CHART_SS = new ArrayList();
					CHART_TN = new ArrayList();
					CHART_TP = new ArrayList();
					CHART_PH = new ArrayList();
					CHART_FLW = new ArrayList();
					CHART_TOC = new ArrayList();

				}

				WS_NM = ((HashMap<String, String>) searchResult.get(i)).get("WS_NM");
				AM_NM = ((HashMap<String, String>) searchResult.get(i)).get("AM_NM");
				AS_NM = ((HashMap<String, String>) searchResult.get(i)).get("AS_NM");
				PT_NO = ((HashMap<String, String>) searchResult.get(i)).get("PT_NO");
				PT_NM = ((HashMap<String, String>) searchResult.get(i)).get("PT_NM");
				WAST_NO = ((HashMap<String, String>) searchResult.get(i)).get("WAST_NO");
				FACT_KIND_NAME = ((HashMap<String, String>) searchResult.get(i)).get("FACT_KIND_NAME");
				FACT_CAPACITY = ((HashMap<String, String>) searchResult.get(i)).get("FACT_CAPACITY");
				WMCYMD = ((HashMap<String, String>) searchResult.get(i)).get("WMCYMD");

				CURR_BOD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BOD"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BOD"));
				CHART_BOD.add(Chart_Data_tmp);

				CURR_COD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_COD"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_COD"));
				CHART_COD.add(Chart_Data_tmp);

				CURR_SS = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_SS"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_SS"));
				CHART_SS.add(Chart_Data_tmp);

				CURR_TN = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TN"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TN"));
				CHART_TN.add(Chart_Data_tmp);

				CURR_TP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TP"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TP"));
				CHART_TP.add(Chart_Data_tmp);

				CURR_PH = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PH"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PH"));
				CHART_PH.add(Chart_Data_tmp);

				CURR_FLW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FLW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FLW"));
				CHART_FLW.add(Chart_Data_tmp);

				CURR_TOC = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TOC"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TOC"));
				CHART_TOC.add(Chart_Data_tmp);

				if (!preSeq.equals(((HashMap<String, String>) searchResult.get(i)).get("RN"))) {
					preSeq = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("RN"));
				}

			}

			HashMap jsonRecord = new HashMap();

			if (cnt > 0) {
				jsonRecord.put("WS_NM", WS_NM);
				jsonRecord.put("AM_NM", AM_NM);
				jsonRecord.put("AS_NM", AS_NM);
				jsonRecord.put("PT_NO", PT_NO);
				jsonRecord.put("PT_NM", PT_NM);
				jsonRecord.put("WAST_NO", WAST_NO);
				jsonRecord.put("FACT_KIND_NAME", FACT_KIND_NAME);
				jsonRecord.put("FACT_CAPACITY", FACT_CAPACITY);
				jsonRecord.put("WMCYMD", WMCYMD);
				jsonRecord.put("CURR_BOD", CURR_BOD);
				jsonRecord.put("CHART_BOD", CHART_BOD);
				jsonRecord.put("CURR_COD", CURR_COD);
				jsonRecord.put("CHART_COD", CHART_COD);
				jsonRecord.put("CURR_SS", CURR_SS);
				jsonRecord.put("CHART_SS", CHART_SS);
				jsonRecord.put("CURR_TN", CURR_TN);
				jsonRecord.put("CHART_TN", CHART_TN);
				jsonRecord.put("CURR_TP", CURR_TP);
				jsonRecord.put("CHART_TP", CHART_TP);
				jsonRecord.put("CURR_PH", CURR_PH);
				jsonRecord.put("CHART_PH", CHART_PH);
				jsonRecord.put("CURR_FLW", CURR_FLW);
				jsonRecord.put("CHART_FLW", CHART_FLW);
				jsonRecord.put("CURR_TOC", CURR_TOC);
				jsonRecord.put("CHART_TOC", CHART_TOC);
				jsonRecord.put("DO_NM", DO_NM);
				jsonRecord.put("CTY_NM", CTY_NM);
				jsonRecord.put("DONG_NM", DONG_NM);
				jsonRecord.put("RI_NM", RI_NM);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}

			jsonArr.add(jsonRecord);

			result.put("data", jsonArr);

		}

		return result;
	}

	// 수질자동측정지점 - 수질자동측정지점 미확정 GROUP CODE : B
	public List searchResult_B001(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_B001(param);
		return result;
	}

	// 수질자동측정지점 - 수질자동측정지점 확정 GROUP CODE : B
	public List searchResult_B001_Fix(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_B001_Fix(param);
		return result;
	}

	// 퇴적물 LAYER CODE : C
	public HashMap searchResult_C(SearchResultVO param) throws Exception {

		param.setSiteIds();
		HashMap result = new HashMap();
		List searchResult = null;

		if ("noDate".equals(param.getFirstSearch())) {
			searchResult = searchResultMapper.searchResult_C_getDate(param);

			if (checkNull(searchResult)) {
				HashMap nullMgs = new HashMap();
				nullMgs.put("msg", "데이터가 존재하지 않습니다.");
				searchResult = new ArrayList();
				searchResult.add(nullMgs);
			}

			result.put("data", searchResult);

		} else {

			searchResult = searchResultMapper.searchResult_C(param);

			String PT_NM = "";
			String WMYR = "";
			String WMW = "";
			String WMOM = "";
			String WMOD = "";
			String WMCTM = "";
			String POLL_STEP = "";

			String CURR_DOW = "";
			String CURR_DOW_SURF = "";
			String CURR_TEMP_SURF = "";
			String CURR_DO_SURF = "";
			String CURR_PH_SURF = "";
			String CURR_EC_SURF = "";
			String CURR_DOW_LOW = "";
			String CURR_TEMP_LOW = "";
			String CURR_DO_LOW = "";
			String CURR_PH_LOW = "";
			String CURR_EC_LOW = "";
			String CURR_TRANSPARENCY = "";
			String CURR_FSD = "";
			String CURR_FST = "";
			String CURR_FCL = "";
			String CURR_WTC = "";
			String CURR_PCA = "";
			String CURR_COD = "";
			String CURR_TOC = "";
			String CURR_TN = "";
			String CURR_TP = "";
			String CURR_SRP = "";
			String CURR_PB = "";
			String CURR_ZN = "";
			String CURR_CU = "";
			String CURR_CR = "";
			String CURR_NI = "";
			String CURR_AS = "";
			String CURR_CD = "";
			String CURR_HG = "";
			String CURR_AL = "";
			String CURR_LI = "";
			String CURR_CL_2_PHENYL = "";
			String CURR_2_CL_2_PHENYL = "";
			String CURR_3_CL_2_PHENYL = "";
			String CURR_4_CL_2_PHENYL = "";
			String CURR_5_CL_2_PHENYL = "";
			String CURR_6_CL_2_PHENYL = "";
			String CURR_7_CL_2_PHENYL = "";
			String CURR_8_CL_2_PHENYL = "";
			String CURR_9_CL_2_PHENYL = "";
			String CURR_10_CL_2_PHENYL = "";
			String CURR_TOT_PCBS = "";
			String CURR_NAPTHALENE = "";
			String CURR_ACENAPTHALENE = "";
			String CURR_ACENAPTHENE = "";
			String CURR_FLUORENE = "";
			String CURR_PHENANTHRENE = "";
			String CURR_ANTHRACENE = "";
			String CURR_FLUORANTHENE = "";
			String CURR_PYRENE = "";
			String CURR_BENZO_A_ANTHRACENE = "";
			String CURR_CRYSENE = "";
			String CURR_BENZO_B_FLUORANTHENE = "";
			String CURR_BENZO_F_FLUORANTHENE = "";
			String CURR_BENZO_A_PYRENE = "";
			String CURR_INDENO_1_2_3_CD_PYRENE = "";
			String CURR_DIBENZO_A_H_ANTHRACENE = "";
			String CURR_BENZO_G_H_I_PERYLENE = "";
			String CURR_TOTAL_PAHS = "";
			String CURR_O_P_DDE = "";
			String CURR_P_P_DDE = "";
			String CURR_O_P_DDD = "";
			String CURR_P_P_DDD = "";
			String CURR_O_P_DDT = "";
			String CURR_P_P_DDT = "";
			String CURR_TOTAL_DDT = "";
			String CURR_1_1_1_TRICHLOROETHANE = "";
			String CURR_1_2_DICHLOROETHANE = "";
			String CURR_BENZENE = "";
			String CURR_CARBON_TETRA_CHLORIDE = "";
			String CURR_CHLOROFORM = "";
			String CURR_ETHYL_BENZENE = "";
			String CURR_METHYL_CHLORIDE = "";
			String CURR_TETRA_CHLORO_ETHYLENE = "";
			String CURR_TRI_CHLORO_ETHYLENE = "";
			String CURR_TOLUENE = "";
			String CURR_M_P_XYLENE = "";
			String CURR_O_XYLENE = "";

			ArrayList Chart_Data_tmp = new ArrayList();

			ArrayList CHART_DOW = new ArrayList();
			ArrayList CHART_DOW_SURF = new ArrayList();
			ArrayList CHART_TEMP_SURF = new ArrayList();
			ArrayList CHART_DO_SURF = new ArrayList();
			ArrayList CHART_PH_SURF = new ArrayList();
			ArrayList CHART_EC_SURF = new ArrayList();
			ArrayList CHART_DOW_LOW = new ArrayList();
			ArrayList CHART_TEMP_LOW = new ArrayList();
			ArrayList CHART_DO_LOW = new ArrayList();
			ArrayList CHART_PH_LOW = new ArrayList();
			ArrayList CHART_EC_LOW = new ArrayList();
			ArrayList CHART_TRANSPARENCY = new ArrayList();
			ArrayList CHART_FSD = new ArrayList();
			ArrayList CHART_FST = new ArrayList();
			ArrayList CHART_FCL = new ArrayList();
			ArrayList CHART_WTC = new ArrayList();
			ArrayList CHART_PCA = new ArrayList();
			ArrayList CHART_COD = new ArrayList();
			ArrayList CHART_TOC = new ArrayList();
			ArrayList CHART_TN = new ArrayList();
			ArrayList CHART_TP = new ArrayList();
			ArrayList CHART_SRP = new ArrayList();
			ArrayList CHART_PB = new ArrayList();
			ArrayList CHART_ZN = new ArrayList();
			ArrayList CHART_CU = new ArrayList();
			ArrayList CHART_CR = new ArrayList();
			ArrayList CHART_NI = new ArrayList();
			ArrayList CHART_AS = new ArrayList();
			ArrayList CHART_CD = new ArrayList();
			ArrayList CHART_HG = new ArrayList();
			ArrayList CHART_AL = new ArrayList();
			ArrayList CHART_LI = new ArrayList();
			ArrayList CHART_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_2_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_3_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_4_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_5_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_6_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_7_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_8_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_9_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_10_CL_2_PHENYL = new ArrayList();
			ArrayList CHART_TOT_PCBS = new ArrayList();
			ArrayList CHART_NAPTHALENE = new ArrayList();
			ArrayList CHART_ACENAPTHALENE = new ArrayList();
			ArrayList CHART_ACENAPTHENE = new ArrayList();
			ArrayList CHART_FLUORENE = new ArrayList();
			ArrayList CHART_PHENANTHRENE = new ArrayList();
			ArrayList CHART_ANTHRACENE = new ArrayList();
			ArrayList CHART_FLUORANTHENE = new ArrayList();
			ArrayList CHART_PYRENE = new ArrayList();
			ArrayList CHART_BENZO_A_ANTHRACENE = new ArrayList();
			ArrayList CHART_CRYSENE = new ArrayList();
			ArrayList CHART_BENZO_B_FLUORANTHENE = new ArrayList();
			ArrayList CHART_BENZO_F_FLUORANTHENE = new ArrayList();
			ArrayList CHART_BENZO_A_PYRENE = new ArrayList();
			ArrayList CHART_INDENO_1_2_3_CD_PYRENE = new ArrayList();
			ArrayList CHART_DIBENZO_A_H_ANTHRACENE = new ArrayList();
			ArrayList CHART_BENZO_G_H_I_PERYLENE = new ArrayList();
			ArrayList CHART_TOTAL_PAHS = new ArrayList();
			ArrayList CHART_O_P_DDE = new ArrayList();
			ArrayList CHART_P_P_DDE = new ArrayList();
			ArrayList CHART_O_P_DDD = new ArrayList();
			ArrayList CHART_P_P_DDD = new ArrayList();
			ArrayList CHART_O_P_DDT = new ArrayList();
			ArrayList CHART_P_P_DDT = new ArrayList();
			ArrayList CHART_TOTAL_DDT = new ArrayList();
			ArrayList CHART_1_1_1_TRICHLOROETHANE = new ArrayList();
			ArrayList CHART_1_2_DICHLOROETHANE = new ArrayList();
			ArrayList CHART_BENZENE = new ArrayList();
			ArrayList CHART_CARBON_TETRA_CHLORIDE = new ArrayList();
			ArrayList CHART_CHLOROFORM = new ArrayList();
			ArrayList CHART_ETHYL_BENZENE = new ArrayList();
			ArrayList CHART_METHYL_CHLORIDE = new ArrayList();
			ArrayList CHART_TETRA_CHLORO_ETHYLENE = new ArrayList();
			ArrayList CHART_TRI_CHLORO_ETHYLENE = new ArrayList();
			ArrayList CHART_TOLUENE = new ArrayList();
			ArrayList CHART_M_P_XYLENE = new ArrayList();
			ArrayList CHART_O_XYLENE = new ArrayList();

			String preSeq = "";

			List jsonArr = new ArrayList();

			int cnt = 0;

			for (int i = 0; i < searchResult.size(); i++) {

				cnt++;

				if (!preSeq.equals("")
						&& !preSeq.equals(String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("RN")))) {

					cnt = 1;

					HashMap jsonRecord = new HashMap();

					jsonRecord.put("PT_NM", PT_NM);
					jsonRecord.put("WMYR", WMYR);
					jsonRecord.put("WMW", WMW);
					jsonRecord.put("WMOM", WMOM);
					jsonRecord.put("WMOD", WMOD);
					jsonRecord.put("WMCTM", WMCTM);
					jsonRecord.put("POLL_STEP", POLL_STEP);
					jsonRecord.put("CURR_DOW", CURR_DOW);
					jsonRecord.put("CURR_DOW_SURF", CURR_DOW_SURF);
					jsonRecord.put("CURR_TEMP_SURF", CURR_TEMP_SURF);
					jsonRecord.put("CURR_DO_SURF", CURR_DO_SURF);
					jsonRecord.put("CURR_PH_SURF", CURR_PH_SURF);
					jsonRecord.put("CURR_EC_SURF", CURR_EC_SURF);
					jsonRecord.put("CURR_DOW_LOW", CURR_DOW_LOW);
					jsonRecord.put("CURR_TEMP_LOW", CURR_TEMP_LOW);
					jsonRecord.put("CURR_DO_LOW", CURR_DO_LOW);
					jsonRecord.put("CURR_PH_LOW", CURR_PH_LOW);
					jsonRecord.put("CURR_EC_LOW", CURR_EC_LOW);
					jsonRecord.put("CURR_TRANSPARENCY", CURR_TRANSPARENCY);
					jsonRecord.put("CURR_FSD", CURR_FSD);
					jsonRecord.put("CURR_FST", CURR_FST);
					jsonRecord.put("CURR_FCL", CURR_FCL);
					jsonRecord.put("CURR_WTC", CURR_WTC);
					jsonRecord.put("CURR_PCA", CURR_PCA);
					jsonRecord.put("CURR_COD", CURR_COD);
					jsonRecord.put("CURR_TOC", CURR_TOC);
					jsonRecord.put("CURR_TN", CURR_TN);
					jsonRecord.put("CURR_TP", CURR_TP);
					jsonRecord.put("CURR_SRP", CURR_SRP);
					jsonRecord.put("CURR_PB", CURR_PB);
					jsonRecord.put("CURR_ZN", CURR_ZN);
					jsonRecord.put("CURR_CU", CURR_CU);
					jsonRecord.put("CURR_CR", CURR_CR);
					jsonRecord.put("CURR_NI", CURR_NI);
					jsonRecord.put("CURR_AS", CURR_AS);
					jsonRecord.put("CURR_CD", CURR_CD);
					jsonRecord.put("CURR_HG", CURR_HG);
					jsonRecord.put("CURR_AL", CURR_AL);
					jsonRecord.put("CURR_LI", CURR_LI);
					jsonRecord.put("CURR_CL_2_PHENYL", CURR_CL_2_PHENYL);
					jsonRecord.put("CURR_2_CL_2_PHENYL", CURR_2_CL_2_PHENYL);
					jsonRecord.put("CURR_3_CL_2_PHENYL", CURR_3_CL_2_PHENYL);
					jsonRecord.put("CURR_4_CL_2_PHENYL", CURR_4_CL_2_PHENYL);
					jsonRecord.put("CURR_5_CL_2_PHENYL", CURR_5_CL_2_PHENYL);
					jsonRecord.put("CURR_6_CL_2_PHENYL", CURR_6_CL_2_PHENYL);
					jsonRecord.put("CURR_7_CL_2_PHENYL", CURR_7_CL_2_PHENYL);
					jsonRecord.put("CURR_8_CL_2_PHENYL", CURR_8_CL_2_PHENYL);
					jsonRecord.put("CURR_9_CL_2_PHENYL", CURR_9_CL_2_PHENYL);
					jsonRecord.put("CURR_10_CL_2_PHENYL", CURR_10_CL_2_PHENYL);
					jsonRecord.put("CURR_TOT_PCBS", CURR_TOT_PCBS);
					jsonRecord.put("CURR_NAPTHALENE", CURR_NAPTHALENE);
					jsonRecord.put("CURR_ACENAPTHALENE", CURR_ACENAPTHALENE);
					jsonRecord.put("CURR_ACENAPTHENE", CURR_ACENAPTHENE);
					jsonRecord.put("CURR_FLUORENE", CURR_FLUORENE);
					jsonRecord.put("CURR_PHENANTHRENE", CURR_PHENANTHRENE);
					jsonRecord.put("CURR_ANTHRACENE", CURR_ANTHRACENE);
					jsonRecord.put("CURR_FLUORANTHENE", CURR_FLUORANTHENE);
					jsonRecord.put("CURR_PYRENE", CURR_PYRENE);
					jsonRecord.put("CURR_BENZO_A_ANTHRACENE", CURR_BENZO_A_ANTHRACENE);
					jsonRecord.put("CURR_CRYSENE", CURR_CRYSENE);
					jsonRecord.put("CURR_BENZO_B_FLUORANTHENE", CURR_BENZO_B_FLUORANTHENE);
					jsonRecord.put("CURR_BENZO_F_FLUORANTHENE", CURR_BENZO_F_FLUORANTHENE);
					jsonRecord.put("CURR_BENZO_A_PYRENE", CURR_BENZO_A_PYRENE);
					jsonRecord.put("CURR_INDENO_1_2_3_CD_PYRENE", CURR_INDENO_1_2_3_CD_PYRENE);
					jsonRecord.put("CURR_DIBENZO_A_H_ANTHRACENE", CURR_DIBENZO_A_H_ANTHRACENE);
					jsonRecord.put("CURR_BENZO_G_H_I_PERYLENE", CURR_BENZO_G_H_I_PERYLENE);
					jsonRecord.put("CURR_TOTAL_PAHS", CURR_TOTAL_PAHS);
					jsonRecord.put("CURR_O_P_DDE", CURR_O_P_DDE);
					jsonRecord.put("CURR_P_P_DDE", CURR_P_P_DDE);
					jsonRecord.put("CURR_O_P_DDD", CURR_O_P_DDD);
					jsonRecord.put("CURR_P_P_DDD", CURR_P_P_DDD);
					jsonRecord.put("CURR_O_P_DDT", CURR_O_P_DDT);
					jsonRecord.put("CURR_P_P_DDT", CURR_P_P_DDT);
					jsonRecord.put("CURR_TOTAL_DDT", CURR_TOTAL_DDT);
					jsonRecord.put("CURR_1_1_1_TRICHLOROETHANE", CURR_1_1_1_TRICHLOROETHANE);
					jsonRecord.put("CURR_1_2_DICHLOROETHANE", CURR_1_2_DICHLOROETHANE);
					jsonRecord.put("CURR_BENZENE", CURR_BENZENE);
					jsonRecord.put("CURR_CARBON_TETRA_CHLORIDE", CURR_CARBON_TETRA_CHLORIDE);
					jsonRecord.put("CURR_CHLOROFORM", CURR_CHLOROFORM);
					jsonRecord.put("CURR_ETHYL_BENZENE", CURR_ETHYL_BENZENE);
					jsonRecord.put("CURR_METHYL_CHLORIDE", CURR_METHYL_CHLORIDE);
					jsonRecord.put("CURR_TETRA_CHLORO_ETHYLENE", CURR_TETRA_CHLORO_ETHYLENE);
					jsonRecord.put("CURR_TRI_CHLORO_ETHYLENE", CURR_TRI_CHLORO_ETHYLENE);
					jsonRecord.put("CURR_TOLUENE", CURR_TOLUENE);
					jsonRecord.put("CURR_M_P_XYLENE", CURR_M_P_XYLENE);
					jsonRecord.put("CURR_O_XYLENE", CURR_O_XYLENE);
					jsonRecord.put("CHART_DOW", CHART_DOW);
					jsonRecord.put("CHART_DOW_SURF", CHART_DOW_SURF);
					jsonRecord.put("CHART_TEMP_SURF", CHART_TEMP_SURF);
					jsonRecord.put("CHART_DO_SURF", CHART_DO_SURF);
					jsonRecord.put("CHART_PH_SURF", CHART_PH_SURF);
					jsonRecord.put("CHART_EC_SURF", CHART_EC_SURF);
					jsonRecord.put("CHART_DOW_LOW", CHART_DOW_LOW);
					jsonRecord.put("CHART_TEMP_LOW", CHART_TEMP_LOW);
					jsonRecord.put("CHART_DO_LOW", CHART_DO_LOW);
					jsonRecord.put("CHART_PH_LOW", CHART_PH_LOW);
					jsonRecord.put("CHART_EC_LOW", CHART_EC_LOW);
					jsonRecord.put("CHART_TRANSPARENCY", CHART_TRANSPARENCY);
					jsonRecord.put("CHART_FSD", CHART_FSD);
					jsonRecord.put("CHART_FST", CHART_FST);
					jsonRecord.put("CHART_FCL", CHART_FCL);
					jsonRecord.put("CHART_WTC", CHART_WTC);
					jsonRecord.put("CHART_PCA", CHART_PCA);
					jsonRecord.put("CHART_COD", CHART_COD);
					jsonRecord.put("CHART_TOC", CHART_TOC);
					jsonRecord.put("CHART_TN", CHART_TN);
					jsonRecord.put("CHART_TP", CHART_TP);
					jsonRecord.put("CHART_SRP", CHART_SRP);
					jsonRecord.put("CHART_PB", CHART_PB);
					jsonRecord.put("CHART_ZN", CHART_ZN);
					jsonRecord.put("CHART_CU", CHART_CU);
					jsonRecord.put("CHART_CR", CHART_CR);
					jsonRecord.put("CHART_NI", CHART_NI);
					jsonRecord.put("CHART_AS", CHART_AS);
					jsonRecord.put("CHART_CD", CHART_CD);
					jsonRecord.put("CHART_HG", CHART_HG);
					jsonRecord.put("CHART_AL", CHART_AL);
					jsonRecord.put("CHART_LI", CHART_LI);
					jsonRecord.put("CHART_CL_2_PHENYL", CHART_CL_2_PHENYL);
					jsonRecord.put("CHART_2_CL_2_PHENYL", CHART_2_CL_2_PHENYL);
					jsonRecord.put("CHART_3_CL_2_PHENYL", CHART_3_CL_2_PHENYL);
					jsonRecord.put("CHART_4_CL_2_PHENYL", CHART_4_CL_2_PHENYL);
					jsonRecord.put("CHART_5_CL_2_PHENYL", CHART_5_CL_2_PHENYL);
					jsonRecord.put("CHART_6_CL_2_PHENYL", CHART_6_CL_2_PHENYL);
					jsonRecord.put("CHART_7_CL_2_PHENYL", CHART_7_CL_2_PHENYL);
					jsonRecord.put("CHART_8_CL_2_PHENYL", CHART_8_CL_2_PHENYL);
					jsonRecord.put("CHART_9_CL_2_PHENYL", CHART_9_CL_2_PHENYL);
					jsonRecord.put("CHART_10_CL_2_PHENYL", CHART_10_CL_2_PHENYL);
					jsonRecord.put("CHART_TOT_PCBS", CHART_TOT_PCBS);
					jsonRecord.put("CHART_NAPTHALENE", CHART_NAPTHALENE);
					jsonRecord.put("CHART_ACENAPTHALENE", CHART_ACENAPTHALENE);
					jsonRecord.put("CHART_ACENAPTHENE", CHART_ACENAPTHENE);
					jsonRecord.put("CHART_FLUORENE", CHART_FLUORENE);
					jsonRecord.put("CHART_PHENANTHRENE", CHART_PHENANTHRENE);
					jsonRecord.put("CHART_ANTHRACENE", CHART_ANTHRACENE);
					jsonRecord.put("CHART_FLUORANTHENE", CHART_FLUORANTHENE);
					jsonRecord.put("CHART_PYRENE", CHART_PYRENE);
					jsonRecord.put("CHART_BENZO_A_ANTHRACENE", CHART_BENZO_A_ANTHRACENE);
					jsonRecord.put("CHART_CRYSENE", CHART_CRYSENE);
					jsonRecord.put("CHART_BENZO_B_FLUORANTHENE", CHART_BENZO_B_FLUORANTHENE);
					jsonRecord.put("CHART_BENZO_F_FLUORANTHENE", CHART_BENZO_F_FLUORANTHENE);
					jsonRecord.put("CHART_BENZO_A_PYRENE", CHART_BENZO_A_PYRENE);
					jsonRecord.put("CHART_INDENO_1_2_3_CD_PYRENE", CHART_INDENO_1_2_3_CD_PYRENE);
					jsonRecord.put("CHART_DIBENZO_A_H_ANTHRACENE", CHART_DIBENZO_A_H_ANTHRACENE);
					jsonRecord.put("CHART_BENZO_G_H_I_PERYLENE", CHART_BENZO_G_H_I_PERYLENE);
					jsonRecord.put("CHART_TOTAL_PAHS", CHART_TOTAL_PAHS);
					jsonRecord.put("CHART_O_P_DDE", CHART_O_P_DDE);
					jsonRecord.put("CHART_P_P_DDE", CHART_P_P_DDE);
					jsonRecord.put("CHART_O_P_DDD", CHART_O_P_DDD);
					jsonRecord.put("CHART_P_P_DDD", CHART_P_P_DDD);
					jsonRecord.put("CHART_O_P_DDT", CHART_O_P_DDT);
					jsonRecord.put("CHART_P_P_DDT", CHART_P_P_DDT);
					jsonRecord.put("CHART_TOTAL_DDT", CHART_TOTAL_DDT);
					jsonRecord.put("CHART_1_1_1_TRICHLOROETHANE", CHART_1_1_1_TRICHLOROETHANE);
					jsonRecord.put("CHART_1_2_DICHLOROETHANE", CHART_1_2_DICHLOROETHANE);
					jsonRecord.put("CHART_BENZENE", CHART_BENZENE);
					jsonRecord.put("CHART_CARBON_TETRA_CHLORIDE", CHART_CARBON_TETRA_CHLORIDE);
					jsonRecord.put("CHART_CHLOROFORM", CHART_CHLOROFORM);
					jsonRecord.put("CHART_ETHYL_BENZENE", CHART_ETHYL_BENZENE);
					jsonRecord.put("CHART_METHYL_CHLORIDE", CHART_METHYL_CHLORIDE);
					jsonRecord.put("CHART_TETRA_CHLORO_ETHYLENE", CHART_TETRA_CHLORO_ETHYLENE);
					jsonRecord.put("CHART_TRI_CHLORO_ETHYLENE", CHART_TRI_CHLORO_ETHYLENE);
					jsonRecord.put("CHART_TOLUENE", CHART_TOLUENE);
					jsonRecord.put("CHART_M_P_XYLENE", CHART_M_P_XYLENE);
					jsonRecord.put("CHART_O_XYLENE", CHART_O_XYLENE);

					jsonArr.add(jsonRecord);

					CHART_DOW = new ArrayList();
					CHART_DOW_SURF = new ArrayList();
					CHART_TEMP_SURF = new ArrayList();
					CHART_DO_SURF = new ArrayList();
					CHART_PH_SURF = new ArrayList();
					CHART_EC_SURF = new ArrayList();
					CHART_DOW_LOW = new ArrayList();
					CHART_TEMP_LOW = new ArrayList();
					CHART_DO_LOW = new ArrayList();
					CHART_PH_LOW = new ArrayList();
					CHART_EC_LOW = new ArrayList();
					CHART_TRANSPARENCY = new ArrayList();
					CHART_FSD = new ArrayList();
					CHART_FST = new ArrayList();
					CHART_FCL = new ArrayList();
					CHART_WTC = new ArrayList();
					CHART_PCA = new ArrayList();
					CHART_COD = new ArrayList();
					CHART_TOC = new ArrayList();
					CHART_TN = new ArrayList();
					CHART_TP = new ArrayList();
					CHART_SRP = new ArrayList();
					CHART_PB = new ArrayList();
					CHART_ZN = new ArrayList();
					CHART_CU = new ArrayList();
					CHART_CR = new ArrayList();
					CHART_NI = new ArrayList();
					CHART_AS = new ArrayList();
					CHART_CD = new ArrayList();
					CHART_HG = new ArrayList();
					CHART_AL = new ArrayList();
					CHART_LI = new ArrayList();
					CHART_CL_2_PHENYL = new ArrayList();
					CHART_2_CL_2_PHENYL = new ArrayList();
					CHART_3_CL_2_PHENYL = new ArrayList();
					CHART_4_CL_2_PHENYL = new ArrayList();
					CHART_5_CL_2_PHENYL = new ArrayList();
					CHART_6_CL_2_PHENYL = new ArrayList();
					CHART_7_CL_2_PHENYL = new ArrayList();
					CHART_8_CL_2_PHENYL = new ArrayList();
					CHART_9_CL_2_PHENYL = new ArrayList();
					CHART_10_CL_2_PHENYL = new ArrayList();
					CHART_TOT_PCBS = new ArrayList();
					CHART_NAPTHALENE = new ArrayList();
					CHART_ACENAPTHALENE = new ArrayList();
					CHART_ACENAPTHENE = new ArrayList();
					CHART_FLUORENE = new ArrayList();
					CHART_PHENANTHRENE = new ArrayList();
					CHART_ANTHRACENE = new ArrayList();
					CHART_FLUORANTHENE = new ArrayList();
					CHART_PYRENE = new ArrayList();
					CHART_BENZO_A_ANTHRACENE = new ArrayList();
					CHART_CRYSENE = new ArrayList();
					CHART_BENZO_B_FLUORANTHENE = new ArrayList();
					CHART_BENZO_F_FLUORANTHENE = new ArrayList();
					CHART_BENZO_A_PYRENE = new ArrayList();
					CHART_INDENO_1_2_3_CD_PYRENE = new ArrayList();
					CHART_DIBENZO_A_H_ANTHRACENE = new ArrayList();
					CHART_BENZO_G_H_I_PERYLENE = new ArrayList();
					CHART_TOTAL_PAHS = new ArrayList();
					CHART_O_P_DDE = new ArrayList();
					CHART_P_P_DDE = new ArrayList();
					CHART_O_P_DDD = new ArrayList();
					CHART_P_P_DDD = new ArrayList();
					CHART_O_P_DDT = new ArrayList();
					CHART_P_P_DDT = new ArrayList();
					CHART_TOTAL_DDT = new ArrayList();
					CHART_1_1_1_TRICHLOROETHANE = new ArrayList();
					CHART_1_2_DICHLOROETHANE = new ArrayList();
					CHART_BENZENE = new ArrayList();
					CHART_CARBON_TETRA_CHLORIDE = new ArrayList();
					CHART_CHLOROFORM = new ArrayList();
					CHART_ETHYL_BENZENE = new ArrayList();
					CHART_METHYL_CHLORIDE = new ArrayList();
					CHART_TETRA_CHLORO_ETHYLENE = new ArrayList();
					CHART_TRI_CHLORO_ETHYLENE = new ArrayList();
					CHART_TOLUENE = new ArrayList();
					CHART_M_P_XYLENE = new ArrayList();
					CHART_O_XYLENE = new ArrayList();

				}

				PT_NM = ((HashMap<String, String>) searchResult.get(i)).get("PT_NM");
				WMYR = ((HashMap<String, String>) searchResult.get(i)).get("WMYR");
				WMW = ((HashMap<String, String>) searchResult.get(i)).get("WMW");
				WMOM = ((HashMap<String, String>) searchResult.get(i)).get("WMOM");
				WMOD = ((HashMap<String, String>) searchResult.get(i)).get("WMOD");
				WMCTM = ((HashMap<String, String>) searchResult.get(i)).get("WMCTM");
				POLL_STEP = ((HashMap<String, String>) searchResult.get(i)).get("POLL_STEP");

				CURR_DOW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DOW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap) searchResult.get(i)).get("CHART_DOW"));
				if (((HashMap) searchResult.get(i)).get("CHART_DOW") != null) {
					CHART_DOW.add(Chart_Data_tmp);
				}

				CURR_DOW_SURF = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DOW_SURF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DOW_SURF"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DOW_SURF") != null) {
					CHART_DOW_SURF.add(Chart_Data_tmp);
				}

				CURR_TEMP_SURF = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TEMP_SURF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TEMP_SURF"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TEMP_SURF") != null) {
					CHART_TEMP_SURF.add(Chart_Data_tmp);
				}

				CURR_DO_SURF = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DO_SURF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DO_SURF"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DO_SURF") != null) {
					CHART_DO_SURF.add(Chart_Data_tmp);
				}

				CURR_PH_SURF = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PH_SURF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PH_SURF"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PH_SURF") != null) {
					CHART_PH_SURF.add(Chart_Data_tmp);
				}

				CURR_EC_SURF = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_EC_SURF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_EC_SURF"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_EC_SURF") != null) {
					CHART_EC_SURF.add(Chart_Data_tmp);
				}

				CURR_DOW_LOW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DOW_LOW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DOW_LOW"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DOW_LOW") != null) {
					CHART_DOW_LOW.add(Chart_Data_tmp);
				}

				CURR_TEMP_LOW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TEMP_LOW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TEMP_LOW"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TEMP_LOW") != null) {
					CHART_TEMP_LOW.add(Chart_Data_tmp);
				}

				CURR_DO_LOW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DO_LOW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DO_LOW"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DO_LOW") != null) {
					CHART_DO_LOW.add(Chart_Data_tmp);
				}

				CURR_PH_LOW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PH_LOW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PH_LOW"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PH_LOW") != null) {
					CHART_PH_LOW.add(Chart_Data_tmp);
				}

				CURR_EC_LOW = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_EC_LOW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_EC_LOW"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_EC_LOW") != null) {
					CHART_EC_LOW.add(Chart_Data_tmp);
				}

				CURR_TRANSPARENCY = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TRANSPARENCY"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TRANSPARENCY"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TRANSPARENCY") != null) {
					CHART_TRANSPARENCY.add(Chart_Data_tmp);
				}

				CURR_FSD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FSD"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FSD"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_FSD") != null) {
					CHART_FSD.add(Chart_Data_tmp);
				}

				CURR_FST = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FST"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FST"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_FST") != null) {
					CHART_FST.add(Chart_Data_tmp);
				}

				CURR_FCL = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FCL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FCL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_FCL") != null) {
					CHART_FCL.add(Chart_Data_tmp);
				}

				CURR_WTC = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_WTC"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_WTC"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_WTC") != null) {
					CHART_WTC.add(Chart_Data_tmp);
				}

				CURR_PCA = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PCA"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PCA"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PCA") != null) {
					CHART_PCA.add(Chart_Data_tmp);
				}

				CURR_COD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_COD"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_COD"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_COD") != null) {
					CHART_COD.add(Chart_Data_tmp);
				}

				CURR_TOC = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TOC"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TOC"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TOC") != null) {
					CHART_TOC.add(Chart_Data_tmp);
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

				CURR_SRP = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_SRP"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_SRP"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_SRP") != null) {
					CHART_SRP.add(Chart_Data_tmp);
				}

				CURR_PB = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PB"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PB"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PB") != null) {
					CHART_PB.add(Chart_Data_tmp);
				}

				CURR_ZN = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ZN"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ZN"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ZN") != null) {
					CHART_ZN.add(Chart_Data_tmp);
				}

				CURR_CU = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CU"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CU"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CU") != null) {
					CHART_CU.add(Chart_Data_tmp);
				}

				CURR_CR = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CR"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CR"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CR") != null) {
					CHART_CR.add(Chart_Data_tmp);
				}

				CURR_NI = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_NI"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_NI"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_NI") != null) {
					CHART_NI.add(Chart_Data_tmp);
				}

				CURR_AS = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_AS"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_AS"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_AS") != null) {
					CHART_AS.add(Chart_Data_tmp);
				}

				CURR_CD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CD"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CD"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CD") != null) {
					CHART_CD.add(Chart_Data_tmp);
				}

				CURR_HG = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_HG"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_HG"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_HG") != null) {
					CHART_HG.add(Chart_Data_tmp);
				}

				CURR_AL = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_AL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_AL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_AL") != null) {
					CHART_AL.add(Chart_Data_tmp);
				}

				CURR_LI = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_LI"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_LI"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_LI") != null) {
					CHART_LI.add(Chart_Data_tmp);
				}

				CURR_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CL_2_PHENYL") != null) {
					CHART_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_2_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_2_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_2_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_2_CL_2_PHENYL") != null) {
					CHART_2_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_3_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_3_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_3_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_3_CL_2_PHENYL") != null) {
					CHART_3_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_4_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_4_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_4_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_4_CL_2_PHENYL") != null) {
					CHART_4_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_5_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_5_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_5_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_5_CL_2_PHENYL") != null) {
					CHART_5_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_6_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_6_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_6_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_6_CL_2_PHENYL") != null) {
					CHART_6_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_7_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_7_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_7_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_7_CL_2_PHENYL") != null) {
					CHART_7_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_8_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_8_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_8_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_8_CL_2_PHENYL") != null) {
					CHART_8_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_9_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_9_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_9_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_9_CL_2_PHENYL") != null) {
					CHART_9_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_10_CL_2_PHENYL = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_10_CL_2_PHENYL"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_10_CL_2_PHENYL"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_10_CL_2_PHENYL") != null) {
					CHART_10_CL_2_PHENYL.add(Chart_Data_tmp);
				}

				CURR_TOT_PCBS = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TOT_PCBS"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TOT_PCBS"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TOT_PCBS") != null) {
					CHART_TOT_PCBS.add(Chart_Data_tmp);
				}

				CURR_NAPTHALENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_NAPTHALENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_NAPTHALENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_NAPTHALENE") != null) {
					CHART_NAPTHALENE.add(Chart_Data_tmp);
				}

				CURR_ACENAPTHALENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ACENAPTHALENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ACENAPTHALENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ACENAPTHALENE") != null) {
					CHART_ACENAPTHALENE.add(Chart_Data_tmp);
				}

				CURR_ACENAPTHENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ACENAPTHENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ACENAPTHENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ACENAPTHENE") != null) {
					CHART_ACENAPTHENE.add(Chart_Data_tmp);
				}

				CURR_FLUORENE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FLUORENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FLUORENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_FLUORENE") != null) {
					CHART_FLUORENE.add(Chart_Data_tmp);
				}

				CURR_PHENANTHRENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PHENANTHRENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PHENANTHRENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PHENANTHRENE") != null) {
					CHART_PHENANTHRENE.add(Chart_Data_tmp);
				}

				CURR_ANTHRACENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ANTHRACENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ANTHRACENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ANTHRACENE") != null) {
					CHART_ANTHRACENE.add(Chart_Data_tmp);
				}

				CURR_FLUORANTHENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_FLUORANTHENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_FLUORANTHENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_FLUORANTHENE") != null) {
					CHART_FLUORANTHENE.add(Chart_Data_tmp);
				}

				CURR_PYRENE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_PYRENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_PYRENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_PYRENE") != null) {
					CHART_PYRENE.add(Chart_Data_tmp);
				}

				CURR_BENZO_A_ANTHRACENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BENZO_A_ANTHRACENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_A_ANTHRACENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_A_ANTHRACENE") != null) {
					CHART_BENZO_A_ANTHRACENE.add(Chart_Data_tmp);
				}

				CURR_CRYSENE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CRYSENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CRYSENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CRYSENE") != null) {
					CHART_CRYSENE.add(Chart_Data_tmp);
				}

				CURR_BENZO_B_FLUORANTHENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BENZO_B_FLUORANTHENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_B_FLUORANTHENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_B_FLUORANTHENE") != null) {
					CHART_BENZO_B_FLUORANTHENE.add(Chart_Data_tmp);
				}

				CURR_BENZO_F_FLUORANTHENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BENZO_F_FLUORANTHENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_F_FLUORANTHENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_F_FLUORANTHENE") != null) {
					CHART_BENZO_F_FLUORANTHENE.add(Chart_Data_tmp);
				}

				CURR_BENZO_A_PYRENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BENZO_A_PYRENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_A_PYRENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_A_PYRENE") != null) {
					CHART_BENZO_A_PYRENE.add(Chart_Data_tmp);
				}

				CURR_INDENO_1_2_3_CD_PYRENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_INDENO_1_2_3_CD_PYRENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_INDENO_1_2_3_CD_PYRENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_INDENO_1_2_3_CD_PYRENE") != null) {
					CHART_INDENO_1_2_3_CD_PYRENE.add(Chart_Data_tmp);
				}

				CURR_DIBENZO_A_H_ANTHRACENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_DIBENZO_A_H_ANTHRACENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_DIBENZO_A_H_ANTHRACENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_DIBENZO_A_H_ANTHRACENE") != null) {
					CHART_DIBENZO_A_H_ANTHRACENE.add(Chart_Data_tmp);
				}

				CURR_BENZO_G_H_I_PERYLENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BENZO_G_H_I_PERYLENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_G_H_I_PERYLENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZO_G_H_I_PERYLENE") != null) {
					CHART_BENZO_G_H_I_PERYLENE.add(Chart_Data_tmp);
				}

				CURR_TOTAL_PAHS = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TOTAL_PAHS"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TOTAL_PAHS"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TOTAL_PAHS") != null) {
					CHART_TOTAL_PAHS.add(Chart_Data_tmp);
				}

				CURR_O_P_DDE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_O_P_DDE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_O_P_DDE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_O_P_DDE") != null) {
					CHART_O_P_DDE.add(Chart_Data_tmp);
				}

				CURR_P_P_DDE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_P_P_DDE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_P_P_DDE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_P_P_DDE") != null) {
					CHART_P_P_DDE.add(Chart_Data_tmp);
				}

				CURR_O_P_DDD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_O_P_DDD"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_O_P_DDD"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_O_P_DDD") != null) {
					CHART_O_P_DDD.add(Chart_Data_tmp);
				}

				CURR_P_P_DDD = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_P_P_DDD"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_P_P_DDD"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_P_P_DDD") != null) {
					CHART_P_P_DDD.add(Chart_Data_tmp);
				}

				CURR_O_P_DDT = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_O_P_DDT"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_O_P_DDT"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_O_P_DDT") != null) {
					CHART_O_P_DDT.add(Chart_Data_tmp);
				}

				CURR_P_P_DDT = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_P_P_DDT"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_P_P_DDT"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_P_P_DDT") != null) {
					CHART_P_P_DDT.add(Chart_Data_tmp);
				}

				CURR_TOTAL_DDT = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TOTAL_DDT"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TOTAL_DDT"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TOTAL_DDT") != null) {
					CHART_TOTAL_DDT.add(Chart_Data_tmp);
				}

				CURR_1_1_1_TRICHLOROETHANE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_1_1_1_TRICHLOROETHANE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_1_1_1_TRICHLOROETHANE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_1_1_1_TRICHLOROETHANE") != null) {
					CHART_1_1_1_TRICHLOROETHANE.add(Chart_Data_tmp);
				}

				CURR_1_2_DICHLOROETHANE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_1_2_DICHLOROETHANE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_1_2_DICHLOROETHANE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_1_2_DICHLOROETHANE") != null) {
					CHART_1_2_DICHLOROETHANE.add(Chart_Data_tmp);
				}

				CURR_BENZENE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_BENZENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_BENZENE") != null) {
					CHART_BENZENE.add(Chart_Data_tmp);
				}

				CURR_CARBON_TETRA_CHLORIDE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CARBON_TETRA_CHLORIDE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CARBON_TETRA_CHLORIDE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CARBON_TETRA_CHLORIDE") != null) {
					CHART_CARBON_TETRA_CHLORIDE.add(Chart_Data_tmp);
				}

				CURR_CHLOROFORM = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_CHLOROFORM"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_CHLOROFORM"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_CHLOROFORM") != null) {
					CHART_CHLOROFORM.add(Chart_Data_tmp);
				}

				CURR_ETHYL_BENZENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_ETHYL_BENZENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_ETHYL_BENZENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_ETHYL_BENZENE") != null) {
					CHART_ETHYL_BENZENE.add(Chart_Data_tmp);
				}

				CURR_METHYL_CHLORIDE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_METHYL_CHLORIDE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_METHYL_CHLORIDE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_METHYL_CHLORIDE") != null) {
					CHART_METHYL_CHLORIDE.add(Chart_Data_tmp);
				}

				CURR_TETRA_CHLORO_ETHYLENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TETRA_CHLORO_ETHYLENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TETRA_CHLORO_ETHYLENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TETRA_CHLORO_ETHYLENE") != null) {
					CHART_TETRA_CHLORO_ETHYLENE.add(Chart_Data_tmp);
				}

				CURR_TRI_CHLORO_ETHYLENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TRI_CHLORO_ETHYLENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TRI_CHLORO_ETHYLENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TRI_CHLORO_ETHYLENE") != null) {
					CHART_TRI_CHLORO_ETHYLENE.add(Chart_Data_tmp);
				}

				CURR_TOLUENE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_TOLUENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_TOLUENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_TOLUENE") != null) {
					CHART_TOLUENE.add(Chart_Data_tmp);
				}

				CURR_M_P_XYLENE = String
						.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_M_P_XYLENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_M_P_XYLENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_M_P_XYLENE") != null) {
					CHART_M_P_XYLENE.add(Chart_Data_tmp);
				}

				CURR_O_XYLENE = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("CURR_O_XYLENE"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(
						cnt + ((HashMap<String, String>) searchResult.get(i)).get("CHART_DATE").replaceAll("\\.", ""));
				Chart_Data_tmp.add(((HashMap<String, String>) searchResult.get(i)).get("CHART_O_XYLENE"));
				if (((HashMap<String, String>) searchResult.get(i)).get("CHART_O_XYLENE") != null) {
					CHART_O_XYLENE.add(Chart_Data_tmp);
				}

				if (!preSeq.equals(((HashMap<String, String>) searchResult.get(i)).get("RN"))) {
					preSeq = String.valueOf(((HashMap<String, String>) searchResult.get(i)).get("RN"));
				}

			}

			HashMap jsonRecord = new HashMap();

			if (cnt > 0) {

				jsonRecord.put("PT_NM", PT_NM);
				jsonRecord.put("WMYR", WMYR);
				jsonRecord.put("WMW", WMW);
				jsonRecord.put("WMOM", WMOM);
				jsonRecord.put("WMOD", WMOD);
				jsonRecord.put("WMCTM", WMCTM);
				jsonRecord.put("POLL_STEP", POLL_STEP);
				jsonRecord.put("CURR_DOW", CURR_DOW);
				jsonRecord.put("CURR_DOW_SURF", CURR_DOW_SURF);
				jsonRecord.put("CURR_TEMP_SURF", CURR_TEMP_SURF);
				jsonRecord.put("CURR_DO_SURF", CURR_DO_SURF);
				jsonRecord.put("CURR_PH_SURF", CURR_PH_SURF);
				jsonRecord.put("CURR_EC_SURF", CURR_EC_SURF);
				jsonRecord.put("CURR_DOW_LOW", CURR_DOW_LOW);
				jsonRecord.put("CURR_TEMP_LOW", CURR_TEMP_LOW);
				jsonRecord.put("CURR_DO_LOW", CURR_DO_LOW);
				jsonRecord.put("CURR_PH_LOW", CURR_PH_LOW);
				jsonRecord.put("CURR_EC_LOW", CURR_EC_LOW);
				jsonRecord.put("CURR_TRANSPARENCY", CURR_TRANSPARENCY);
				jsonRecord.put("CURR_FSD", CURR_FSD);
				jsonRecord.put("CURR_FST", CURR_FST);
				jsonRecord.put("CURR_FCL", CURR_FCL);
				jsonRecord.put("CURR_WTC", CURR_WTC);
				jsonRecord.put("CURR_PCA", CURR_PCA);
				jsonRecord.put("CURR_COD", CURR_COD);
				jsonRecord.put("CURR_TOC", CURR_TOC);
				jsonRecord.put("CURR_TN", CURR_TN);
				jsonRecord.put("CURR_TP", CURR_TP);
				jsonRecord.put("CURR_SRP", CURR_SRP);
				jsonRecord.put("CURR_PB", CURR_PB);
				jsonRecord.put("CURR_ZN", CURR_ZN);
				jsonRecord.put("CURR_CU", CURR_CU);
				jsonRecord.put("CURR_CR", CURR_CR);
				jsonRecord.put("CURR_NI", CURR_NI);
				jsonRecord.put("CURR_AS", CURR_AS);
				jsonRecord.put("CURR_CD", CURR_CD);
				jsonRecord.put("CURR_HG", CURR_HG);
				jsonRecord.put("CURR_AL", CURR_AL);
				jsonRecord.put("CURR_LI", CURR_LI);
				jsonRecord.put("CURR_CL_2_PHENYL", CURR_CL_2_PHENYL);
				jsonRecord.put("CURR_2_CL_2_PHENYL", CURR_2_CL_2_PHENYL);
				jsonRecord.put("CURR_3_CL_2_PHENYL", CURR_3_CL_2_PHENYL);
				jsonRecord.put("CURR_4_CL_2_PHENYL", CURR_4_CL_2_PHENYL);
				jsonRecord.put("CURR_5_CL_2_PHENYL", CURR_5_CL_2_PHENYL);
				jsonRecord.put("CURR_6_CL_2_PHENYL", CURR_6_CL_2_PHENYL);
				jsonRecord.put("CURR_7_CL_2_PHENYL", CURR_7_CL_2_PHENYL);
				jsonRecord.put("CURR_8_CL_2_PHENYL", CURR_8_CL_2_PHENYL);
				jsonRecord.put("CURR_9_CL_2_PHENYL", CURR_9_CL_2_PHENYL);
				jsonRecord.put("CURR_10_CL_2_PHENYL", CURR_10_CL_2_PHENYL);
				jsonRecord.put("CURR_TOT_PCBS", CURR_TOT_PCBS);
				jsonRecord.put("CURR_NAPTHALENE", CURR_NAPTHALENE);
				jsonRecord.put("CURR_ACENAPTHALENE", CURR_ACENAPTHALENE);
				jsonRecord.put("CURR_ACENAPTHENE", CURR_ACENAPTHENE);
				jsonRecord.put("CURR_FLUORENE", CURR_FLUORENE);
				jsonRecord.put("CURR_PHENANTHRENE", CURR_PHENANTHRENE);
				jsonRecord.put("CURR_ANTHRACENE", CURR_ANTHRACENE);
				jsonRecord.put("CURR_FLUORANTHENE", CURR_FLUORANTHENE);
				jsonRecord.put("CURR_PYRENE", CURR_PYRENE);
				jsonRecord.put("CURR_BENZO_A_ANTHRACENE", CURR_BENZO_A_ANTHRACENE);
				jsonRecord.put("CURR_CRYSENE", CURR_CRYSENE);
				jsonRecord.put("CURR_BENZO_B_FLUORANTHENE", CURR_BENZO_B_FLUORANTHENE);
				jsonRecord.put("CURR_BENZO_F_FLUORANTHENE", CURR_BENZO_F_FLUORANTHENE);
				jsonRecord.put("CURR_BENZO_A_PYRENE", CURR_BENZO_A_PYRENE);
				jsonRecord.put("CURR_INDENO_1_2_3_CD_PYRENE", CURR_INDENO_1_2_3_CD_PYRENE);
				jsonRecord.put("CURR_DIBENZO_A_H_ANTHRACENE", CURR_DIBENZO_A_H_ANTHRACENE);
				jsonRecord.put("CURR_BENZO_G_H_I_PERYLENE", CURR_BENZO_G_H_I_PERYLENE);
				jsonRecord.put("CURR_TOTAL_PAHS", CURR_TOTAL_PAHS);
				jsonRecord.put("CURR_O_P_DDE", CURR_O_P_DDE);
				jsonRecord.put("CURR_P_P_DDE", CURR_P_P_DDE);
				jsonRecord.put("CURR_O_P_DDD", CURR_O_P_DDD);
				jsonRecord.put("CURR_P_P_DDD", CURR_P_P_DDD);
				jsonRecord.put("CURR_O_P_DDT", CURR_O_P_DDT);
				jsonRecord.put("CURR_P_P_DDT", CURR_P_P_DDT);
				jsonRecord.put("CURR_TOTAL_DDT", CURR_TOTAL_DDT);
				jsonRecord.put("CURR_1_1_1_TRICHLOROETHANE", CURR_1_1_1_TRICHLOROETHANE);
				jsonRecord.put("CURR_1_2_DICHLOROETHANE", CURR_1_2_DICHLOROETHANE);
				jsonRecord.put("CURR_BENZENE", CURR_BENZENE);
				jsonRecord.put("CURR_CARBON_TETRA_CHLORIDE", CURR_CARBON_TETRA_CHLORIDE);
				jsonRecord.put("CURR_CHLOROFORM", CURR_CHLOROFORM);
				jsonRecord.put("CURR_ETHYL_BENZENE", CURR_ETHYL_BENZENE);
				jsonRecord.put("CURR_METHYL_CHLORIDE", CURR_METHYL_CHLORIDE);
				jsonRecord.put("CURR_TETRA_CHLORO_ETHYLENE", CURR_TETRA_CHLORO_ETHYLENE);
				jsonRecord.put("CURR_TRI_CHLORO_ETHYLENE", CURR_TRI_CHLORO_ETHYLENE);
				jsonRecord.put("CURR_TOLUENE", CURR_TOLUENE);
				jsonRecord.put("CURR_M_P_XYLENE", CURR_M_P_XYLENE);
				jsonRecord.put("CURR_O_XYLENE", CURR_O_XYLENE);
				jsonRecord.put("CHART_DOW", CHART_DOW);
				jsonRecord.put("CHART_DOW_SURF", CHART_DOW_SURF);
				jsonRecord.put("CHART_TEMP_SURF", CHART_TEMP_SURF);
				jsonRecord.put("CHART_DO_SURF", CHART_DO_SURF);
				jsonRecord.put("CHART_PH_SURF", CHART_PH_SURF);
				jsonRecord.put("CHART_EC_SURF", CHART_EC_SURF);
				jsonRecord.put("CHART_DOW_LOW", CHART_DOW_LOW);
				jsonRecord.put("CHART_TEMP_LOW", CHART_TEMP_LOW);
				jsonRecord.put("CHART_DO_LOW", CHART_DO_LOW);
				jsonRecord.put("CHART_PH_LOW", CHART_PH_LOW);
				jsonRecord.put("CHART_EC_LOW", CHART_EC_LOW);
				jsonRecord.put("CHART_TRANSPARENCY", CHART_TRANSPARENCY);
				jsonRecord.put("CHART_FSD", CHART_FSD);
				jsonRecord.put("CHART_FST", CHART_FST);
				jsonRecord.put("CHART_FCL", CHART_FCL);
				jsonRecord.put("CHART_WTC", CHART_WTC);
				jsonRecord.put("CHART_PCA", CHART_PCA);
				jsonRecord.put("CHART_COD", CHART_COD);
				jsonRecord.put("CHART_TOC", CHART_TOC);
				jsonRecord.put("CHART_TN", CHART_TN);
				jsonRecord.put("CHART_TP", CHART_TP);
				jsonRecord.put("CHART_SRP", CHART_SRP);
				jsonRecord.put("CHART_PB", CHART_PB);
				jsonRecord.put("CHART_ZN", CHART_ZN);
				jsonRecord.put("CHART_CU", CHART_CU);
				jsonRecord.put("CHART_CR", CHART_CR);
				jsonRecord.put("CHART_NI", CHART_NI);
				jsonRecord.put("CHART_AS", CHART_AS);
				jsonRecord.put("CHART_CD", CHART_CD);
				jsonRecord.put("CHART_HG", CHART_HG);
				jsonRecord.put("CHART_AL", CHART_AL);
				jsonRecord.put("CHART_LI", CHART_LI);
				jsonRecord.put("CHART_CL_2_PHENYL", CHART_CL_2_PHENYL);
				jsonRecord.put("CHART_2_CL_2_PHENYL", CHART_2_CL_2_PHENYL);
				jsonRecord.put("CHART_3_CL_2_PHENYL", CHART_3_CL_2_PHENYL);
				jsonRecord.put("CHART_4_CL_2_PHENYL", CHART_4_CL_2_PHENYL);
				jsonRecord.put("CHART_5_CL_2_PHENYL", CHART_5_CL_2_PHENYL);
				jsonRecord.put("CHART_6_CL_2_PHENYL", CHART_6_CL_2_PHENYL);
				jsonRecord.put("CHART_7_CL_2_PHENYL", CHART_7_CL_2_PHENYL);
				jsonRecord.put("CHART_8_CL_2_PHENYL", CHART_8_CL_2_PHENYL);
				jsonRecord.put("CHART_9_CL_2_PHENYL", CHART_9_CL_2_PHENYL);
				jsonRecord.put("CHART_10_CL_2_PHENYL", CHART_10_CL_2_PHENYL);
				jsonRecord.put("CHART_TOT_PCBS", CHART_TOT_PCBS);
				jsonRecord.put("CHART_NAPTHALENE", CHART_NAPTHALENE);
				jsonRecord.put("CHART_ACENAPTHALENE", CHART_ACENAPTHALENE);
				jsonRecord.put("CHART_ACENAPTHENE", CHART_ACENAPTHENE);
				jsonRecord.put("CHART_FLUORENE", CHART_FLUORENE);
				jsonRecord.put("CHART_PHENANTHRENE", CHART_PHENANTHRENE);
				jsonRecord.put("CHART_ANTHRACENE", CHART_ANTHRACENE);
				jsonRecord.put("CHART_FLUORANTHENE", CHART_FLUORANTHENE);
				jsonRecord.put("CHART_PYRENE", CHART_PYRENE);
				jsonRecord.put("CHART_BENZO_A_ANTHRACENE", CHART_BENZO_A_ANTHRACENE);
				jsonRecord.put("CHART_CRYSENE", CHART_CRYSENE);
				jsonRecord.put("CHART_BENZO_B_FLUORANTHENE", CHART_BENZO_B_FLUORANTHENE);
				jsonRecord.put("CHART_BENZO_F_FLUORANTHENE", CHART_BENZO_F_FLUORANTHENE);
				jsonRecord.put("CHART_BENZO_A_PYRENE", CHART_BENZO_A_PYRENE);
				jsonRecord.put("CHART_INDENO_1_2_3_CD_PYRENE", CHART_INDENO_1_2_3_CD_PYRENE);
				jsonRecord.put("CHART_DIBENZO_A_H_ANTHRACENE", CHART_DIBENZO_A_H_ANTHRACENE);
				jsonRecord.put("CHART_BENZO_G_H_I_PERYLENE", CHART_BENZO_G_H_I_PERYLENE);
				jsonRecord.put("CHART_TOTAL_PAHS", CHART_TOTAL_PAHS);
				jsonRecord.put("CHART_O_P_DDE", CHART_O_P_DDE);
				jsonRecord.put("CHART_P_P_DDE", CHART_P_P_DDE);
				jsonRecord.put("CHART_O_P_DDD", CHART_O_P_DDD);
				jsonRecord.put("CHART_P_P_DDD", CHART_P_P_DDD);
				jsonRecord.put("CHART_O_P_DDT", CHART_O_P_DDT);
				jsonRecord.put("CHART_P_P_DDT", CHART_P_P_DDT);
				jsonRecord.put("CHART_TOTAL_DDT", CHART_TOTAL_DDT);
				jsonRecord.put("CHART_1_1_1_TRICHLOROETHANE", CHART_1_1_1_TRICHLOROETHANE);
				jsonRecord.put("CHART_1_2_DICHLOROETHANE", CHART_1_2_DICHLOROETHANE);
				jsonRecord.put("CHART_BENZENE", CHART_BENZENE);
				jsonRecord.put("CHART_CARBON_TETRA_CHLORIDE", CHART_CARBON_TETRA_CHLORIDE);
				jsonRecord.put("CHART_CHLOROFORM", CHART_CHLOROFORM);
				jsonRecord.put("CHART_ETHYL_BENZENE", CHART_ETHYL_BENZENE);
				jsonRecord.put("CHART_METHYL_CHLORIDE", CHART_METHYL_CHLORIDE);
				jsonRecord.put("CHART_TETRA_CHLORO_ETHYLENE", CHART_TETRA_CHLORO_ETHYLENE);
				jsonRecord.put("CHART_TRI_CHLORO_ETHYLENE", CHART_TRI_CHLORO_ETHYLENE);
				jsonRecord.put("CHART_TOLUENE", CHART_TOLUENE);
				jsonRecord.put("CHART_M_P_XYLENE", CHART_M_P_XYLENE);
				jsonRecord.put("CHART_O_XYLENE", CHART_O_XYLENE);

			}

			jsonArr.add(jsonRecord);

			if (checkNull(jsonArr)) {
				HashMap nullMgs = new HashMap();
				nullMgs.put("msg", "데이터가 존재하지 않습니다.");
				jsonArr = new ArrayList();
				jsonArr.add(nullMgs);
			}

			result.put("data", jsonArr);

		}

		return result;

	}

	public HashMap searchResult_D(String gubun, SearchResultVO param) throws Exception {
		HashMap result = new HashMap();
		List resultList = null;

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

	// 환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	public HashMap searchResult_F(String gubun, SearchResultVO param) throws Exception {
		HashMap result = new HashMap();
		List srcList = null;
		List jsonArr = new ArrayList();

		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);

			srcList = searchResultMapper.searchResult_F_getDate(param);
			if (checkNull(srcList)) {
				HashMap nullMgs = new HashMap();
				nullMgs.put("msg", "데이터가 존재하지 않습니다.");
				srcList = new ArrayList();
				srcList.add(nullMgs);
			}
			result.put("data", srcList);

		} else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_F_" + gubun, SearchResultVO.class);

			srcList = (List) method.invoke(searchResultMapper, param);

			HashMap jsonRecord = null;

			if ("1".equals(gubun)) {

				int cnt = 0;
				String preSeq = "";
				String FACI_CD = "";
				String FACI_NM = "";
				String WORK_DT_VAL = "";
				ArrayList WORK_DT_GRAPH = new ArrayList();

				String DISCHARGE_NUM = "";

				String DISCHARGE_AMT_PHYS_VAL = "";
				ArrayList DISCHARGE_AMT_PHYS_GRAPH = new ArrayList();
				ArrayList Chart_Data_tmp = new ArrayList();

				String DISCHARGE_AMT_BIO_VAL = "";
				ArrayList DISCHARGE_AMT_BIO_GRAPH = new ArrayList();

				String DISCHARGE_AMT_HIGHTEC_VAL = "";
				ArrayList DISCHARGE_AMT_HIGHTEC_GRAPH = new ArrayList();

				String BOD_VAL = "";
				ArrayList BOD_GRAPH = new ArrayList();

				String COD_VAL = "";
				ArrayList COD_GRAPH = new ArrayList();

				String SS_VAL = "";
				ArrayList SS_GRAPH = new ArrayList();

				String TN_VAL = "";
				ArrayList TN_GRAPH = new ArrayList();

				String TP_VAL = "";
				ArrayList TP_GRAPH = new ArrayList();

				String COLI_VAL = "";
				ArrayList COLI_GRAPH = new ArrayList();

				String DISCHARGE_DISINFECT = "";
				String DISCHARGE_FACI_NM = "";

				for (int i = 0; i < srcList.size(); i++) {

					HashMap rs = (HashMap) srcList.get(i);
					cnt++;

					if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("NO")))) {

						cnt = 1;
						jsonRecord = new HashMap();

						jsonRecord.put("FACI_CD", FACI_CD);
						jsonRecord.put("FACI_NM", FACI_NM);
						jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
						jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
						jsonRecord.put("DISCHARGE_NUM", DISCHARGE_NUM);
						jsonRecord.put("DISCHARGE_AMT_PHYS_VAL", DISCHARGE_AMT_PHYS_VAL);
						jsonRecord.put("DISCHARGE_AMT_PHYS_GRAPH", DISCHARGE_AMT_PHYS_GRAPH);
						jsonRecord.put("DISCHARGE_AMT_BIO_VAL", DISCHARGE_AMT_BIO_VAL);
						jsonRecord.put("DISCHARGE_AMT_BIO_GRAPH", DISCHARGE_AMT_BIO_GRAPH);
						jsonRecord.put("DISCHARGE_AMT_HIGHTEC_VAL", DISCHARGE_AMT_HIGHTEC_VAL);
						jsonRecord.put("DISCHARGE_AMT_HIGHTEC_GRAPH", DISCHARGE_AMT_HIGHTEC_GRAPH);
						jsonRecord.put("BOD_VAL", BOD_VAL);
						jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
						jsonRecord.put("COD_VAL", COD_VAL);
						jsonRecord.put("COD_GRAPH", COD_GRAPH);
						jsonRecord.put("SS_VAL", SS_VAL);
						jsonRecord.put("SS_GRAPH", SS_GRAPH);
						jsonRecord.put("TN_VAL", TN_VAL);
						jsonRecord.put("TN_GRAPH", TN_GRAPH);
						jsonRecord.put("TP_VAL", TP_VAL);
						jsonRecord.put("TP_GRAPH", TP_GRAPH);
						jsonRecord.put("COLI_VAL", COLI_VAL);
						jsonRecord.put("COLI_GRAPH", COLI_GRAPH);
						jsonRecord.put("DISCHARGE_DISINFECT", DISCHARGE_DISINFECT);
						jsonRecord.put("DISCHARGE_FACI_NM", DISCHARGE_FACI_NM);

						jsonArr.add(jsonRecord);

						WORK_DT_GRAPH = new ArrayList();
						DISCHARGE_AMT_PHYS_GRAPH = new ArrayList();
						DISCHARGE_AMT_BIO_GRAPH = new ArrayList();
						DISCHARGE_AMT_HIGHTEC_GRAPH = new ArrayList();
						BOD_GRAPH = new ArrayList();
						COD_GRAPH = new ArrayList();
						SS_GRAPH = new ArrayList();
						TN_GRAPH = new ArrayList();
						TP_GRAPH = new ArrayList();
						COLI_GRAPH = new ArrayList();

					}

					FACI_CD = String.valueOf(rs.get("FACI_CD"));
					FACI_NM = String.valueOf(rs.get("FACI_NM"));
					DISCHARGE_DISINFECT = String.valueOf(rs.get("DISCHARGE_DISINFECT"));
					DISCHARGE_FACI_NM = String.valueOf(rs.get("DISCHARGE_FACI_NM"));
					DISCHARGE_NUM = String.valueOf(rs.get("DISCHARGE_NUM"));
					WORK_DT_VAL = String.valueOf(rs.get("WORK_DT_VAL"));

					DISCHARGE_AMT_PHYS_VAL = String.valueOf(rs.get("DISCHARGE_AMT_PHYS_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("DISCHARGE_AMT_PHYS_GRAPH"));
					if (String.valueOf(rs.get("DISCHARGE_AMT_PHYS_GRAPH")) != null) {
						DISCHARGE_AMT_PHYS_GRAPH.add(Chart_Data_tmp);
					}

					DISCHARGE_AMT_BIO_VAL = String.valueOf(rs.get("DISCHARGE_AMT_BIO_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("DISCHARGE_AMT_BIO_GRAPH"));
					if (String.valueOf(rs.get("DISCHARGE_AMT_BIO_GRAPH")) != null) {
						DISCHARGE_AMT_BIO_GRAPH.add(Chart_Data_tmp);
					}

					DISCHARGE_AMT_HIGHTEC_VAL = String.valueOf(rs.get("DISCHARGE_AMT_HIGHTEC_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("DISCHARGE_AMT_HIGHTEC_GRAPH"));
					if (String.valueOf(rs.get("DISCHARGE_AMT_HIGHTEC_GRAPH")) != null) {
						DISCHARGE_AMT_HIGHTEC_GRAPH.add(Chart_Data_tmp);
					}

					BOD_VAL = String.valueOf(rs.get("BOD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("BOD_GRAPH"));
					if (String.valueOf(rs.get("BOD_GRAPH")) != null) {
						BOD_GRAPH.add(Chart_Data_tmp);
					}

					COD_VAL = String.valueOf(rs.get("COD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("COD_GRAPH"));
					if (String.valueOf(rs.get("COD_GRAPH")) != null) {
						COD_GRAPH.add(Chart_Data_tmp);
					}

					SS_VAL = String.valueOf(rs.get("SS_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("SS_GRAPH"));
					if (String.valueOf(rs.get("SS_GRAPH")) != null) {
						SS_GRAPH.add(Chart_Data_tmp);
					}

					TN_VAL = String.valueOf(rs.get("TN_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TN_GRAPH"));
					if (String.valueOf(rs.get("TN_GRAPH")) != null) {
						TN_GRAPH.add(Chart_Data_tmp);
					}

					TP_VAL = String.valueOf(rs.get("TP_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TP_GRAPH"));
					if (String.valueOf(rs.get("TP_GRAPH")) != null) {
						TP_GRAPH.add(Chart_Data_tmp);
					}

					if (!preSeq.equals(String.valueOf(rs.get("NO")))) {
						preSeq = String.valueOf(rs.get("NO"));
					}

				}

				jsonRecord = new HashMap();
				if (cnt > 0) {
					jsonRecord.put("FACI_CD", FACI_CD);
					jsonRecord.put("FACI_NM", FACI_NM);
					jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
					jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
					jsonRecord.put("DISCHARGE_NUM", DISCHARGE_NUM);
					jsonRecord.put("DISCHARGE_AMT_PHYS_VAL", DISCHARGE_AMT_PHYS_VAL);
					jsonRecord.put("DISCHARGE_AMT_PHYS_GRAPH", DISCHARGE_AMT_PHYS_GRAPH);
					jsonRecord.put("DISCHARGE_AMT_BIO_VAL", DISCHARGE_AMT_BIO_VAL);
					jsonRecord.put("DISCHARGE_AMT_BIO_GRAPH", DISCHARGE_AMT_BIO_GRAPH);
					jsonRecord.put("DISCHARGE_AMT_HIGHTEC_VAL", DISCHARGE_AMT_HIGHTEC_VAL);
					jsonRecord.put("DISCHARGE_AMT_HIGHTEC_GRAPH", DISCHARGE_AMT_HIGHTEC_GRAPH);
					jsonRecord.put("BOD_VAL", BOD_VAL);
					jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
					jsonRecord.put("COD_VAL", COD_VAL);
					jsonRecord.put("COD_GRAPH", COD_GRAPH);
					jsonRecord.put("SS_VAL", SS_VAL);
					jsonRecord.put("SS_GRAPH", SS_GRAPH);
					jsonRecord.put("TN_VAL", TN_VAL);
					jsonRecord.put("TN_GRAPH", TN_GRAPH);
					jsonRecord.put("TP_VAL", TP_VAL);
					jsonRecord.put("TP_GRAPH", TP_GRAPH);
					jsonRecord.put("COLI_VAL", COLI_VAL);
					jsonRecord.put("COLI_GRAPH", COLI_GRAPH);
					jsonRecord.put("DISCHARGE_DISINFECT", DISCHARGE_DISINFECT);
					jsonRecord.put("DISCHARGE_FACI_NM", DISCHARGE_FACI_NM);
				}

			} else if ("2".equals(gubun)) {

				int cnt = 0;
				String preSeq = "";
				String FACI_CD = "";
				String FACI_NM = "";

				String WORK_DT_VAL = "";
				ArrayList WORK_DT_GRAPH = new ArrayList();
				ArrayList Chart_Data_tmp = new ArrayList();

				String IN_PL_TYPE = "";

				String AMT_VAL = "";
				ArrayList AMT_GRAPH = new ArrayList();

				String BOD_VAL = "";
				ArrayList BOD_GRAPH = new ArrayList();

				String COD_VAL = "";
				ArrayList COD_GRAPH = new ArrayList();

				String SS_VAL = "";
				ArrayList SS_GRAPH = new ArrayList();

				String TN_VAL = "";
				ArrayList TN_GRAPH = new ArrayList();

				String TP_VAL = "";
				ArrayList TP_GRAPH = new ArrayList();

				String COLI_VAL = "";
				ArrayList COLI_GRAPH = new ArrayList();

				for (int i = 0; i < srcList.size(); i++) {

					HashMap rs = (HashMap) srcList.get(i);
					cnt++;

					if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("NO")))) {

						cnt = 1;
						jsonRecord = new HashMap();

						jsonRecord.put("FACI_CD", FACI_CD);
						jsonRecord.put("FACI_NM", FACI_NM);
						jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
						jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
						jsonRecord.put("IN_PL_TYPE", IN_PL_TYPE);
						jsonRecord.put("AMT_VAL", AMT_VAL);
						jsonRecord.put("AMT_GRAPH", AMT_GRAPH);
						jsonRecord.put("BOD_VAL", BOD_VAL);
						jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
						jsonRecord.put("COD_VAL", COD_VAL);
						jsonRecord.put("COD_GRAPH", COD_GRAPH);
						jsonRecord.put("SS_VAL", SS_VAL);
						jsonRecord.put("SS_GRAPH", SS_GRAPH);
						jsonRecord.put("TN_VAL", TN_VAL);
						jsonRecord.put("TN_GRAPH", TN_GRAPH);
						jsonRecord.put("TP_VAL", TP_VAL);
						jsonRecord.put("TP_GRAPH", TP_GRAPH);
						jsonRecord.put("COLI_VAL", COLI_VAL);
						jsonRecord.put("COLI_GRAPH", COLI_GRAPH);

						jsonArr.add(jsonRecord);

						WORK_DT_GRAPH = new ArrayList();
						AMT_GRAPH = new ArrayList();
						BOD_GRAPH = new ArrayList();
						COD_GRAPH = new ArrayList();
						SS_GRAPH = new ArrayList();
						TN_GRAPH = new ArrayList();
						TP_GRAPH = new ArrayList();
						COLI_GRAPH = new ArrayList();

					}

					FACI_CD = String.valueOf(rs.get("FACI_CD"));
					FACI_NM = String.valueOf(rs.get("FACI_NM"));
					IN_PL_TYPE = String.valueOf(rs.get("IN_PL_TYPE"));
					WORK_DT_VAL = String.valueOf(rs.get("WORK_DT_VAL"));

					AMT_VAL = String.valueOf(rs.get("AMT_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("AMT_GRAPH"));
					if (String.valueOf(rs.get("AMT_GRAPH")) != null) {
						AMT_GRAPH.add(Chart_Data_tmp);
					}

					BOD_VAL = String.valueOf(rs.get("BOD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("BOD_GRAPH"));
					if (String.valueOf(rs.get("BOD_GRAPH")) != null) {
						BOD_GRAPH.add(Chart_Data_tmp);
					}

					COD_VAL = String.valueOf(rs.get("COD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("COD_GRAPH"));
					if (String.valueOf(rs.get("COD_GRAPH")) != null) {
						COD_GRAPH.add(Chart_Data_tmp);
					}

					SS_VAL = String.valueOf(rs.get("SS_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("SS_GRAPH"));
					if (String.valueOf(rs.get("SS_GRAPH")) != null) {
						SS_GRAPH.add(Chart_Data_tmp);
					}

					TN_VAL = String.valueOf(rs.get("TN_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TN_GRAPH"));
					if (String.valueOf(rs.get("TN_GRAPH")) != null) {
						TN_GRAPH.add(Chart_Data_tmp);
					}

					TP_VAL = String.valueOf(rs.get("TP_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TP_GRAPH"));
					if (String.valueOf(rs.get("TP_GRAPH")) != null) {
						TP_GRAPH.add(Chart_Data_tmp);
					}

					COLI_VAL = String.valueOf(rs.get("COLI_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("COLI_GRAPH"));
					if (String.valueOf(rs.get("COLI_GRAPH")) != null) {
						COLI_GRAPH.add(Chart_Data_tmp);
					}

					if (!preSeq.equals(String.valueOf(rs.get("NO")))) {
						preSeq = String.valueOf(rs.get("NO"));
					}

				}

				jsonRecord = new HashMap();
				if (cnt > 0) {
					jsonRecord.put("FACI_CD", FACI_CD);
					jsonRecord.put("FACI_NM", FACI_NM);
					jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
					jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
					jsonRecord.put("IN_PL_TYPE", IN_PL_TYPE);
					jsonRecord.put("AMT_VAL", AMT_VAL);
					jsonRecord.put("AMT_GRAPH", AMT_GRAPH);
					jsonRecord.put("BOD_VAL", BOD_VAL);
					jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
					jsonRecord.put("COD_VAL", COD_VAL);
					jsonRecord.put("COD_GRAPH", COD_GRAPH);
					jsonRecord.put("SS_VAL", SS_VAL);
					jsonRecord.put("SS_GRAPH", SS_GRAPH);
					jsonRecord.put("TN_VAL", TN_VAL);
					jsonRecord.put("TN_GRAPH", TN_GRAPH);
					jsonRecord.put("TP_VAL", TP_VAL);
					jsonRecord.put("TP_GRAPH", TP_GRAPH);
					jsonRecord.put("COLI_VAL", COLI_VAL);
					jsonRecord.put("COLI_GRAPH", COLI_GRAPH);
				}

			} else if ("3".equals(gubun)) {

				int cnt = 0;
				String preSeq = "";
				String FACI_CD = "";
				String FACI_NM = "";

				String WORK_DT_VAL = "";
				ArrayList WORK_DT_GRAPH = new ArrayList();
				ArrayList Chart_Data_tmp = new ArrayList();

				String PIPE_NUM = "";

				String AMT_VAL = "";
				ArrayList AMT_GRAPH = new ArrayList();

				String BOD_VAL = "";
				ArrayList BOD_GRAPH = new ArrayList();

				String COD_VAL = "";
				ArrayList COD_GRAPH = new ArrayList();

				String SS_VAL = "";
				ArrayList SS_GRAPH = new ArrayList();

				String TN_VAL = "";
				ArrayList TN_GRAPH = new ArrayList();

				String TP_VAL = "";
				ArrayList TP_GRAPH = new ArrayList();

				String COLI_VAL = "";
				ArrayList COLI_GRAPH = new ArrayList();

				for (int i = 0; i < srcList.size(); i++) {

					HashMap rs = (HashMap) srcList.get(i);
					cnt++;

					if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("NO")))) {

						cnt = 1;
						jsonRecord = new HashMap();

						jsonRecord.put("FACI_CD", FACI_CD);
						jsonRecord.put("FACI_NM", FACI_NM);
						jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
						jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
						jsonRecord.put("PIPE_NUM", PIPE_NUM);
						jsonRecord.put("AMT_VAL", AMT_VAL);
						jsonRecord.put("AMT_GRAPH", AMT_GRAPH);
						jsonRecord.put("BOD_VAL", BOD_VAL);
						jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
						jsonRecord.put("COD_VAL", COD_VAL);
						jsonRecord.put("COD_GRAPH", COD_GRAPH);
						jsonRecord.put("SS_VAL", SS_VAL);
						jsonRecord.put("SS_GRAPH", SS_GRAPH);
						jsonRecord.put("TN_VAL", TN_VAL);
						jsonRecord.put("TN_GRAPH", TN_GRAPH);
						jsonRecord.put("TP_VAL", TP_VAL);
						jsonRecord.put("TP_GRAPH", TP_GRAPH);
						jsonRecord.put("COLI_VAL", COLI_VAL);
						jsonRecord.put("COLI_GRAPH", COLI_GRAPH);

						jsonArr.add(jsonRecord);

						WORK_DT_GRAPH = new ArrayList();
						AMT_GRAPH = new ArrayList();
						BOD_GRAPH = new ArrayList();
						COD_GRAPH = new ArrayList();
						SS_GRAPH = new ArrayList();
						TN_GRAPH = new ArrayList();
						TP_GRAPH = new ArrayList();
						COLI_GRAPH = new ArrayList();
					}

					FACI_CD = String.valueOf(rs.get("FACI_CD"));
					FACI_NM = String.valueOf(rs.get("FACI_NM"));
					PIPE_NUM = String.valueOf(rs.get("PIPE_NUM"));
					WORK_DT_VAL = String.valueOf(rs.get("WORK_DT_VAL"));

					AMT_VAL = String.valueOf(rs.get("AMT_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("AMT_GRAPH"));
					if (String.valueOf(rs.get("AMT_GRAPH")) != null) {
						AMT_GRAPH.add(Chart_Data_tmp);
					}

					BOD_VAL = String.valueOf(rs.get("BOD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("BOD_GRAPH"));
					if (String.valueOf(rs.get("BOD_GRAPH")) != null) {
						BOD_GRAPH.add(Chart_Data_tmp);
					}

					COD_VAL = String.valueOf(rs.get("COD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("COD_GRAPH"));
					if (String.valueOf(rs.get("COD_GRAPH")) != null) {
						COD_GRAPH.add(Chart_Data_tmp);
					}

					SS_VAL = String.valueOf(rs.get("SS_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("SS_GRAPH"));
					if (String.valueOf(rs.get("SS_GRAPH")) != null) {
						SS_GRAPH.add(Chart_Data_tmp);
					}

					TN_VAL = String.valueOf(rs.get("TN_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TN_GRAPH"));
					if (String.valueOf(rs.get("TN_GRAPH")) != null) {
						TN_GRAPH.add(Chart_Data_tmp);
					}

					TP_VAL = String.valueOf(rs.get("TP_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TP_GRAPH"));
					if (String.valueOf(rs.get("TP_GRAPH")) != null) {
						TP_GRAPH.add(Chart_Data_tmp);
					}

					COLI_VAL = String.valueOf(rs.get("COLI_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("COLI_GRAPH"));
					if (String.valueOf(rs.get("COLI_GRAPH")) != null) {
						COLI_GRAPH.add(Chart_Data_tmp);
					}

					if (!preSeq.equals(String.valueOf(rs.get("NO")))) {
						preSeq = String.valueOf(rs.get("NO"));
					}

				}

				jsonRecord = new HashMap();
				if (cnt > 0) {
					// jsonRecord.put("parentId", parentId);
					jsonRecord.put("FACI_CD", FACI_CD);
					jsonRecord.put("FACI_NM", FACI_NM);
					jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
					jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
					jsonRecord.put("PIPE_NUM", PIPE_NUM);
					jsonRecord.put("AMT_VAL", AMT_VAL);
					jsonRecord.put("AMT_GRAPH", AMT_GRAPH);
					jsonRecord.put("BOD_VAL", BOD_VAL);
					jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
					jsonRecord.put("COD_VAL", COD_VAL);
					jsonRecord.put("COD_GRAPH", COD_GRAPH);
					jsonRecord.put("SS_VAL", SS_VAL);
					jsonRecord.put("SS_GRAPH", SS_GRAPH);
					jsonRecord.put("TN_VAL", TN_VAL);
					jsonRecord.put("TN_GRAPH", TN_GRAPH);
					jsonRecord.put("TP_VAL", TP_VAL);
					jsonRecord.put("TP_GRAPH", TP_GRAPH);
					jsonRecord.put("COLI_VAL", COLI_VAL);
					jsonRecord.put("COLI_GRAPH", COLI_GRAPH);
				}

			} else if ("4".equals(gubun)) {

				int cnt = 0;
				String preSeq = "";
				String FACI_CD = "";
				String FACI_NM = "";

				String WORK_DT_VAL = "";
				ArrayList WORK_DT_GRAPH = new ArrayList();

				String PIPE_NUM = "";
				String PIPE_TYPE = "";

				String AMT_VAL = "";
				ArrayList AMT_GRAPH = new ArrayList();
				ArrayList Chart_Data_tmp = new ArrayList();

				String BOD_VAL = "";
				ArrayList BOD_GRAPH = new ArrayList();

				String COD_VAL = "";
				ArrayList COD_GRAPH = new ArrayList();

				String SS_VAL = "";
				ArrayList SS_GRAPH = new ArrayList();

				String TN_VAL = "";
				ArrayList TN_GRAPH = new ArrayList();

				String TP_VAL = "";
				ArrayList TP_GRAPH = new ArrayList();

				String COLI_VAL = "";
				ArrayList COLI_GRAPH = new ArrayList();

				String BYPASS_AMT_VAL = "";
				ArrayList BYPASS_AMT_GRAPH = new ArrayList();

				String CONNECT_FACI_NM = "";

				for (int i = 0; i < srcList.size(); i++) {
					HashMap rs = (HashMap) srcList.get(i);
					cnt++;

					if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("NO")))) {

						cnt = 1;

						jsonRecord = new HashMap();

						jsonRecord.put("FACI_CD", FACI_CD);
						jsonRecord.put("FACI_NM", FACI_NM);
						jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
						jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
						jsonRecord.put("PIPE_NUM", PIPE_NUM);
						jsonRecord.put("PIPE_TYPE", PIPE_TYPE);
						jsonRecord.put("AMT_VAL", AMT_VAL);
						jsonRecord.put("AMT_GRAPH", AMT_GRAPH);
						jsonRecord.put("BOD_VAL", BOD_VAL);
						jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
						jsonRecord.put("COD_VAL", COD_VAL);
						jsonRecord.put("COD_GRAPH", COD_GRAPH);
						jsonRecord.put("SS_VAL", SS_VAL);
						jsonRecord.put("SS_GRAPH", SS_GRAPH);
						jsonRecord.put("TN_VAL", TN_VAL);
						jsonRecord.put("TN_GRAPH", TN_GRAPH);
						jsonRecord.put("TP_VAL", TP_VAL);
						jsonRecord.put("TP_GRAPH", TP_GRAPH);
						jsonRecord.put("COLI_VAL", COLI_VAL);
						jsonRecord.put("COLI_GRAPH", COLI_GRAPH);
						jsonRecord.put("BYPASS_AMT_VAL", BYPASS_AMT_VAL);
						jsonRecord.put("BYPASS_AMT_GRAPH", BYPASS_AMT_GRAPH);
						jsonRecord.put("CONNECT_FACI_NM", CONNECT_FACI_NM);

						jsonArr.add(jsonRecord);

						WORK_DT_GRAPH = new ArrayList();
						AMT_GRAPH = new ArrayList();
						BOD_GRAPH = new ArrayList();
						COD_GRAPH = new ArrayList();
						SS_GRAPH = new ArrayList();
						TN_GRAPH = new ArrayList();
						TP_GRAPH = new ArrayList();
						COLI_GRAPH = new ArrayList();
						BYPASS_AMT_GRAPH = new ArrayList();

					}

					FACI_CD = String.valueOf(rs.get("FACI_CD"));
					FACI_NM = String.valueOf(rs.get("FACI_NM"));
					PIPE_NUM = String.valueOf(rs.get("PIPE_NUM"));
					PIPE_TYPE = String.valueOf(rs.get("PIPE_TYPE"));
					CONNECT_FACI_NM = String.valueOf(rs.get("CONNECT_FACI_NM"));

					WORK_DT_VAL = String.valueOf(rs.get("WORK_DT_VAL"));

					AMT_VAL = String.valueOf(rs.get("AMT_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("AMT_GRAPH"));
					if (String.valueOf(rs.get("AMT_GRAPH")) != null) {
						AMT_GRAPH.add(Chart_Data_tmp);
					}

					BOD_VAL = String.valueOf(rs.get("BOD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("BOD_GRAPH"));
					if (String.valueOf(rs.get("BOD_GRAPH")) != null) {
						BOD_GRAPH.add(Chart_Data_tmp);
					}

					COD_VAL = String.valueOf(rs.get("COD_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("COD_GRAPH"));
					if (String.valueOf(rs.get("COD_GRAPH")) != null) {
						COD_GRAPH.add(Chart_Data_tmp);
					}

					SS_VAL = String.valueOf(rs.get("SS_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("SS_GRAPH"));
					if (String.valueOf(rs.get("SS_GRAPH")) != null) {
						SS_GRAPH.add(Chart_Data_tmp);
					}

					// CHART_TN.add(rs.get("CHART_TN"));

					TN_VAL = String.valueOf(rs.get("TN_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TN_GRAPH"));
					if (String.valueOf(rs.get("TN_GRAPH")) != null) {
						TN_GRAPH.add(Chart_Data_tmp);
					}

					// CHART_TP.add(rs.get("CHART_TP"));

					TP_VAL = String.valueOf(rs.get("TP_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("TP_GRAPH"));
					if (String.valueOf(rs.get("TP_GRAPH")) != null) {
						TP_GRAPH.add(Chart_Data_tmp);
					}

					// CHART_TEMP.add(rs.get("CHART_TEMP"));

					COLI_VAL = String.valueOf(rs.get("COLI_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("COLI_GRAPH"));
					if (String.valueOf(rs.get("COLI_GRAPH")) != null) {
						COLI_GRAPH.add(Chart_Data_tmp);
					}

					// CHART_PH.add(rs.get("CHART_PH"));

					BYPASS_AMT_VAL = String.valueOf(rs.get("BYPASS_AMT_VAL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("WORK_DT_GRAPH")).replace("-", ""));
					Chart_Data_tmp.add(rs.get("BYPASS_AMT_GRAPH"));
					if (String.valueOf(rs.get("BYPASS_AMT_GRAPH")) != null) {
						BYPASS_AMT_GRAPH.add(Chart_Data_tmp);
					}

					if (!preSeq.equals(String.valueOf(rs.get("NO")))) {
						preSeq = String.valueOf(rs.get("NO"));
					}

				}

				jsonRecord = new HashMap();
				if (cnt > 0) {
					jsonRecord.put("FACI_CD", FACI_CD);
					jsonRecord.put("FACI_NM", FACI_NM);
					jsonRecord.put("WORK_DT_VAL", WORK_DT_VAL);
					jsonRecord.put("WORK_DT_GRAPH", WORK_DT_GRAPH);
					jsonRecord.put("PIPE_NUM", PIPE_NUM);
					jsonRecord.put("PIPE_TYPE", PIPE_TYPE);
					jsonRecord.put("AMT_VAL", AMT_VAL);
					jsonRecord.put("AMT_GRAPH", AMT_GRAPH);
					jsonRecord.put("BOD_VAL", BOD_VAL);
					jsonRecord.put("BOD_GRAPH", BOD_GRAPH);
					jsonRecord.put("COD_VAL", COD_VAL);
					jsonRecord.put("COD_GRAPH", COD_GRAPH);
					jsonRecord.put("SS_VAL", SS_VAL);
					jsonRecord.put("SS_GRAPH", SS_GRAPH);
					jsonRecord.put("TN_VAL", TN_VAL);
					jsonRecord.put("TN_GRAPH", TN_GRAPH);
					jsonRecord.put("TP_VAL", TP_VAL);
					jsonRecord.put("TP_GRAPH", TP_GRAPH);
					jsonRecord.put("COLI_VAL", COLI_VAL);
					jsonRecord.put("COLI_GRAPH", COLI_GRAPH);
					jsonRecord.put("BYPASS_AMT_VAL", BYPASS_AMT_VAL);
					jsonRecord.put("BYPASS_AMT_GRAPH", BYPASS_AMT_GRAPH);
					jsonRecord.put("CONNECT_FACI_NM", CONNECT_FACI_NM);
				}

			}

			jsonArr.add(jsonRecord);

			if (checkNull(jsonArr)) {
				HashMap nullMgs = new HashMap();
				nullMgs.put("msg", "데이터가 존재하지 않습니다.");
				jsonArr = new ArrayList();
				jsonArr.add(nullMgs);
			}

			result.put("data", jsonArr);
		}

		return result;
	}

	// 부하량 - 총괄표
	public List searchResult_PollLoad_Total(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_PollLoad_Total(param);
		return result;
	}

	// 부하량 - 표준유역단위
	public List searchResult_PollLoad_Standard(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_PollLoad_Standard(param);
		return result;
	}

	// 부하량 - 집수구역단위
	public List searchResult_PollLoad_Cat(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_PollLoad_Cat(param);
		return result;
	}

	// 부하량 - 집수구역단위_상세
	public List searchResult_PollLoad_Cat_Detail(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_PollLoad_Cat_Detail(param);
		return result;
	}

	private boolean checkNull(List resultList) {
		if (resultList == null || resultList.size() <= 0 || (resultList.size() > 0 && resultList.get(0) == null)) {
			return true;
		}
		return false;
	}

	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	private void setResultData(List srcList, String gubun, HashMap result) {
		ArrayList jsonArr = new ArrayList();
		HashMap jsonRecord = null;
		String preSeq = "";
		String preSeq2 = "9999";
		String check = "";
		String WS_NM = "";
		String AM_NM = "";
		String AS_NM = "";
		String PT_NO = "";
		String PT_NM = "";
		String WMCYMD = "";
		String CHART_DATE = "";
		String CURR_WL = "";
		ArrayList CHART_WL = new ArrayList();
		ArrayList Chart_Data_tmp = new ArrayList();

		String CURR_MXWL = "";
		ArrayList CHART_MXWL = new ArrayList();

		String CURR_MNWL = "";
		ArrayList CHART_MNWL = new ArrayList();

		String CURR_RF = "";
		ArrayList CHART_RF = new ArrayList();

		String CURR_FW = "";
		ArrayList CHART_FW = new ArrayList();
		String CURR_SWL = "";
		ArrayList CHART_SWL = new ArrayList();

		String CURR_INF = "";
		ArrayList CHART_INF = new ArrayList();

		String CURR_OTF = "";
		ArrayList CHART_OTF = new ArrayList();

		String CURR_SFW = "";
		ArrayList CHART_SFW = new ArrayList();

		String CURR_ECPC = "";
		ArrayList CHART_ECPC = new ArrayList();
		String CURR_WD = "";
		ArrayList CHART_WD = new ArrayList();

		String CURR_WS = "";
		ArrayList CHART_WS = new ArrayList();

		String CURR_TA = "";
		ArrayList CHART_TA = new ArrayList();

		String CURR_HM = "";
		ArrayList CHART_HM = new ArrayList();

		String CURR_PA = "";
		ArrayList CHART_PA = new ArrayList();

		String CURR_PS = "";
		ArrayList CHART_PS = new ArrayList();

		String CURR_RNYN = "";
		ArrayList CHART_RNYN = new ArrayList();

		String CURR_RN1HR = "";
		ArrayList CHART_RN1HR = new ArrayList();

		String CURR_RNDAY = "";
		ArrayList CHART_RNDAY = new ArrayList();

		String CURR_RND = "";
		ArrayList CHART_RND = new ArrayList();

		String CURR_SIDAY = "";
		ArrayList CHART_SIDAY = new ArrayList();

		String CURR_OWL = "";
		ArrayList CHART_OWL = new ArrayList();

		String CURR_TNF = "";
		ArrayList CHART_TNF = new ArrayList();

		String CURR_TOTOTF = "";
		ArrayList CHART_TOTOTF = new ArrayList();

		String CURR_EGOTF = "";
		ArrayList CHART_EGOTF = new ArrayList();

		String CURR_GTOTF = "";
		ArrayList CHART_GTOTF = new ArrayList();

		String CURR_CBOTF = "";
		ArrayList CHART_CBOTF = new ArrayList();

		String CURR_FWOTF = "";
		ArrayList CHART_FWOTF = new ArrayList();

		String CURR_ETCOTF = "";
		ArrayList CHART_ETCOTF = new ArrayList();

		int cnt = 0;

		if ("1".equals(gubun)) {

			result.put("data", srcList);
			return;
		} else if ("2".equals(gubun)) {
			result.put("data", srcList);
			return;
		} else if ("3".equals(gubun)) {

			result.put("data", srcList);
			return;
		} else if ("4".equals(gubun)) {
			result.put("data", srcList);
			return;
		} else if ("5".equals(gubun)) {
			result.put("data", srcList);
			return;
		} else if ("6".equals(gubun)) {
			for (int i = 0; i < srcList.size(); i++) {
				HashMap rs = (HashMap) srcList.get(i);
				cnt++;
				if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("RN")))) {

					cnt = 1;

					jsonRecord = new HashMap();

					jsonRecord.put("WS_NM", WS_NM);
					jsonRecord.put("AM_NM", AM_NM);
					jsonRecord.put("AS_NM", AS_NM);
					jsonRecord.put("PT_NO", PT_NO);
					jsonRecord.put("PT_NM", PT_NM);
					jsonRecord.put("WMCYMD", WMCYMD);
					jsonRecord.put("CHART_DATE", CHART_DATE);
					jsonRecord.put("CURR_RND", CURR_RND);
					jsonRecord.put("CHART_RND", CHART_RND);
					jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);
					jsonRecord.put("CURR_TA", CURR_TA);
					jsonRecord.put("CHART_TA", CHART_TA);
					jsonRecord.put("CURR_SIDAY", CURR_SIDAY);
					jsonRecord.put("CHART_SIDAY", CHART_SIDAY);

					jsonArr.add(jsonRecord);

					CHART_RND = new ArrayList();
					CHART_TA = new ArrayList();
					CHART_SIDAY = new ArrayList();

				}
				WS_NM = String.valueOf(rs.get("WS_NM"));
				AM_NM = String.valueOf(rs.get("AM_NM"));
				AS_NM = String.valueOf(rs.get("AS_NM"));
				PT_NO = String.valueOf(rs.get("PT_NO"));
				PT_NM = String.valueOf(rs.get("PT_NM"));
				WMCYMD = String.valueOf(rs.get("WMCYMD"));

				CURR_RND = String.valueOf(rs.get("CURR_RND"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_RND")).trim());
				CHART_RND.add(Chart_Data_tmp);

				CURR_TA = String.valueOf(rs.get("CURR_TA"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_TA")).trim());
				CHART_TA.add(Chart_Data_tmp);

				CURR_SIDAY = String.valueOf(rs.get("CURR_SIDAY"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SIDAY")).trim());
				CHART_SIDAY.add(Chart_Data_tmp);

				if (!preSeq.equals(String.valueOf(rs.get("RN"))))
					preSeq = String.valueOf(rs.get("RN"));

			}

			jsonRecord = new HashMap();

			if (cnt > 0) {
				jsonRecord.put("WS_NM", WS_NM);
				jsonRecord.put("AM_NM", AM_NM);
				jsonRecord.put("AS_NM", AS_NM);
				jsonRecord.put("PT_NO", PT_NO);
				jsonRecord.put("PT_NM", PT_NM);
				jsonRecord.put("WMCYMD", WMCYMD);
				jsonRecord.put("CURR_RND", CURR_RND);
				jsonRecord.put("CHART_RND", CHART_RND);
				jsonRecord.put("CURR_TA", CURR_TA);
				jsonRecord.put("CHART_TA", CHART_TA);
				jsonRecord.put("CURR_SIDAY", CURR_SIDAY);
				jsonRecord.put("CHART_SIDAY", CHART_SIDAY);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		} else if ("7".equals(gubun)) {
			for (int i = 0; i < srcList.size(); i++) {
				HashMap rs = (HashMap) srcList.get(i);

				if (!preSeq2.equals(String.valueOf(rs.get("RN")))) {
					cnt++;
					if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("RN")))) {

						cnt = 1;

						jsonRecord = new HashMap();

						jsonRecord.put("WS_NM", WS_NM);
						jsonRecord.put("AM_NM", AM_NM);
						jsonRecord.put("AS_NM", AS_NM);
						jsonRecord.put("PT_NO", PT_NO);
						jsonRecord.put("PT_NM", PT_NM);
						jsonRecord.put("WMCYMD", WMCYMD);
						jsonRecord.put("CHART_DATE", CHART_DATE);
						jsonRecord.put("CURR_SWL", CURR_SWL);
						jsonRecord.put("CHART_SWL", CHART_SWL);
						jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);
						jsonRecord.put("CURR_OWL", CURR_OWL);
						jsonRecord.put("CHART_OWL", CHART_OWL);
						jsonRecord.put("CURR_SFW", CURR_SFW);
						jsonRecord.put("CHART_SFW", CHART_SFW);
						jsonRecord.put("CURR_ECPC", CURR_ECPC);
						jsonRecord.put("CHART_ECPC", CHART_ECPC);
						jsonRecord.put("CURR_INF", CURR_INF);
						jsonRecord.put("CHART_INF", CHART_INF);
						jsonRecord.put("CURR_TOTOTF", CURR_TOTOTF);
						jsonRecord.put("CHART_TOTOTF", CHART_TOTOTF);
						jsonRecord.put("CURR_EGOTF", CURR_EGOTF);
						jsonRecord.put("CHART_EGOTF", CHART_EGOTF);
						jsonRecord.put("CURR_GTOTF", CURR_GTOTF);
						jsonRecord.put("CHART_GTOTF", CHART_GTOTF);
						jsonRecord.put("CURR_CBOTF", CURR_CBOTF);
						jsonRecord.put("CHART_CBOTF", CHART_CBOTF);
						jsonRecord.put("CURR_FWOTF", CURR_FWOTF);
						jsonRecord.put("CHART_FWOTF", CHART_FWOTF);
						jsonRecord.put("CURR_ETCOTF", CURR_ETCOTF);
						jsonRecord.put("CHART_ETCOTF", CHART_ETCOTF);

						jsonArr.add(jsonRecord);

						CHART_SWL = new ArrayList();
						CHART_OWL = new ArrayList();
						CHART_SFW = new ArrayList();
						CHART_ECPC = new ArrayList();
						CHART_INF = new ArrayList();
						CHART_TOTOTF = new ArrayList();
						CHART_EGOTF = new ArrayList();
						CHART_GTOTF = new ArrayList();
						CHART_CBOTF = new ArrayList();
						CHART_FWOTF = new ArrayList();
						CHART_ETCOTF = new ArrayList();

					}
					WS_NM = String.valueOf(rs.get("WS_NM"));
					AM_NM = String.valueOf(rs.get("AM_NM"));
					AS_NM = String.valueOf(rs.get("AS_NM"));
					PT_NO = String.valueOf(rs.get("PT_NO"));
					PT_NM = String.valueOf(rs.get("PT_NM"));
					WMCYMD = String.valueOf(rs.get("WMCYMD"));

					CURR_SWL = String.valueOf(rs.get("CURR_SWL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SWL")).trim());
					CHART_SWL.add(Chart_Data_tmp);

					CURR_OWL = String.valueOf(rs.get("CURR_OWL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_OWL")).trim());
					CHART_OWL.add(Chart_Data_tmp);

					CURR_SFW = String.valueOf(rs.get("CURR_SFW"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SFW")).trim());
					CHART_SFW.add(Chart_Data_tmp);

					CURR_ECPC = String.valueOf(rs.get("CURR_ECPC"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_ECPC")).trim());
					CHART_ECPC.add(Chart_Data_tmp);

					CURR_INF = String.valueOf(rs.get("CURR_INF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_INF")).trim());
					CHART_INF.add(Chart_Data_tmp);

					CURR_TOTOTF = String.valueOf(rs.get("CURR_TOTOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_TOTOTF")).trim());
					CHART_TOTOTF.add(Chart_Data_tmp);

					CURR_EGOTF = String.valueOf(rs.get("CURR_EGOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_EGOTF")).trim());
					CHART_EGOTF.add(Chart_Data_tmp);

					CURR_GTOTF = String.valueOf(rs.get("CURR_GTOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_GTOTF")).trim());
					CHART_GTOTF.add(Chart_Data_tmp);

					CURR_CBOTF = String.valueOf(rs.get("CURR_CBOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_CBOTF")).trim());
					CHART_CBOTF.add(Chart_Data_tmp);

					CURR_FWOTF = String.valueOf(rs.get("CURR_FWOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_FWOTF")).trim());
					CHART_FWOTF.add(Chart_Data_tmp);

					CURR_ETCOTF = String.valueOf(rs.get("CURR_ETCOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_ETCOTF")).trim());
					CHART_ETCOTF.add(Chart_Data_tmp);

					if (!preSeq.equals(String.valueOf(rs.get("RN")))) {
						preSeq = String.valueOf(rs.get("RN"));
					}

				} else {
					check = preSeq2;
					WMCYMD = String.valueOf(rs.get("WMCYMD"));
				}
			}

			jsonRecord = new HashMap();

			if (cnt > 0) {
				jsonRecord.put("WS_NM", WS_NM);
				jsonRecord.put("AM_NM", AM_NM);
				jsonRecord.put("AS_NM", AS_NM);
				jsonRecord.put("PT_NO", PT_NO);
				jsonRecord.put("PT_NM", PT_NM);
				jsonRecord.put("WMCYMD", WMCYMD);
				jsonRecord.put("CURR_SWL", CURR_SWL);
				jsonRecord.put("CHART_SWL", CHART_SWL);
				jsonRecord.put("CURR_OWL", CURR_OWL);
				jsonRecord.put("CHART_OWL", CHART_OWL);
				jsonRecord.put("CURR_SFW", CURR_SFW);
				jsonRecord.put("CHART_SFW", CHART_SFW);
				jsonRecord.put("CURR_ECPC", CURR_ECPC);
				jsonRecord.put("CHART_ECPC", CHART_ECPC);
				jsonRecord.put("CURR_INF", CURR_INF);
				jsonRecord.put("CHART_INF", CHART_INF);
				jsonRecord.put("CURR_TOTOTF", CURR_TOTOTF);
				jsonRecord.put("CHART_TOTOTF", CHART_TOTOTF);
				jsonRecord.put("CURR_EGOTF", CURR_EGOTF);
				jsonRecord.put("CHART_EGOTF", CHART_EGOTF);
				jsonRecord.put("CURR_GTOTF", CURR_GTOTF);
				jsonRecord.put("CHART_GTOTF", CHART_GTOTF);
				jsonRecord.put("CURR_CBOTF", CURR_CBOTF);
				jsonRecord.put("CHART_CBOTF", CHART_CBOTF);
				jsonRecord.put("CURR_FWOTF", CURR_FWOTF);
				jsonRecord.put("CHART_FWOTF", CHART_FWOTF);
				jsonRecord.put("CURR_ETCOTF", CURR_ETCOTF);
				jsonRecord.put("CHART_ETCOTF", CHART_ETCOTF);
			} else if (cnt == 0 && "9999".equals(check)) {
				jsonRecord.put("WMCYMD", WMCYMD);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		}

		jsonArr.add(jsonRecord);

		result.put("data", jsonArr);
	}

}
