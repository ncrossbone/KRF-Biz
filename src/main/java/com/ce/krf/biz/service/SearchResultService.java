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
	public List searchResult_A(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		if ("noDate".equals(param.getFirstSearch())) {
			return searchResultMapper.searchResult_A_getDate(param);
		} else {
			return searchResultMapper.searchResult_A(param);
		}
	}

	// 수질측정지점 LAYER CODE : B
	public List searchResult_B(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));
		if ("noDate".equals(param.getFirstSearch())) {
			return searchResultMapper.searchResult_B_getDate(param);
		} else {
			return searchResultMapper.searchResult_B(param);
		}
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
	public List searchResult_C(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));

		List result = searchResultMapper.searchResult_C(param);
		return result;
	}

	// 기타측정지점 - 수위관측소 GROUT CODE : D / LAYER CODE : D001
	public List searchResult_D_getDate(SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));
		List result = searchResultMapper.searchResult_D_getDate(param);
		return result;
	}

	public HashMap searchResult_D(String gubun, SearchResultVO param) throws Exception {
//		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));
		String[] siteIds = param.getSiteIds();
		if(siteIds != null && siteIds.length>0) {
			for(int i=0; i<siteIds.length; i++) {
				siteIds[i] = siteIds[i].replaceAll("'", "");
			}
		}
		
		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			HashMap result = new HashMap();
			result.put("data", searchResultMapper.searchResult_D_getDate(param));
			return result;
		} else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_D_" + gubun, SearchResultVO.class);
			List srcList = (List) method.invoke(searchResultMapper, param);

			HashMap result = new HashMap();

			setResultData(srcList, gubun, result);

			return result;
		}
	}

	// 환경기초시설 - 방류유량 GROUT CODE : F / LAYER CODE : F001
	public List searchResult_F(String gubun, SearchResultVO param) throws Exception {
		param.setSiteIds(param.getSiteId().replaceAll("'", "").split(","));
		if ("noDate".equals(param.getFirstSearch())) {
			param.setGubun(gubun);
			return searchResultMapper.searchResult_F_getDate(param);
		} else {
			Method method = searchResultMapper.getClass().getMethod("searchResult_F_" + gubun, SearchResultVO.class);
			return (List) method.invoke(searchResultMapper, param);
		}
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
						jsonRecord.put("CURR_WL", CURR_WL);
						jsonRecord.put("CHART_WL", CHART_WL);
						jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);
						jsonRecord.put("CURR_MXWL", CURR_MXWL);
						jsonRecord.put("CHART_MXWL", CHART_MXWL);
						jsonRecord.put("CURR_MNWL", CURR_MNWL);
						jsonRecord.put("CHART_MNWL", CHART_MNWL);

						jsonArr.add(jsonRecord);

						CHART_WL = new ArrayList();
						CHART_MXWL = new ArrayList();
						CHART_MNWL = new ArrayList();

					}

					WS_NM = String.valueOf(rs.get("WS_NM"));
					AM_NM = String.valueOf(rs.get("AM_NM"));
					AS_NM = String.valueOf(rs.get("AS_NM"));
					PT_NO = String.valueOf(rs.get("PT_NO"));
					PT_NM = String.valueOf(rs.get("PT_NM"));
					WMCYMD = String.valueOf(rs.get("WMCYMD"));

					CURR_WL = String.valueOf(rs.get("CURR_WL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_WL")));
					CHART_WL.add(Chart_Data_tmp);

					CURR_MXWL = String.valueOf(rs.get("CURR_MXWL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_MXWL")));
					CHART_MXWL.add(Chart_Data_tmp);

					CURR_MNWL = String.valueOf(rs.get("CURR_MNWL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_MNWL")));
					CHART_MNWL.add(Chart_Data_tmp);

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
				jsonRecord.put("CURR_WL", CURR_WL);
				jsonRecord.put("CHART_WL", CHART_WL);
				jsonRecord.put("CURR_MXWL", CURR_MXWL);
				jsonRecord.put("CHART_MXWL", CHART_MXWL);
				jsonRecord.put("CURR_MNWL", CURR_MNWL);
				jsonRecord.put("CHART_MNWL", CHART_MNWL);
			} else if (cnt == 0 && check == "9999") {
				jsonRecord.put("WMCYMD", WMCYMD);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		} else if ("2".equals(gubun)) {
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
					jsonRecord.put("CURR_RF", CURR_RF);
					jsonRecord.put("CHART_RF", CHART_RF);
					jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);

					jsonArr.add(jsonRecord);

					CHART_RF = new ArrayList();

				}
				WS_NM = String.valueOf(rs.get("WS_NM"));
				AM_NM = String.valueOf(rs.get("AM_NM"));
				AS_NM = String.valueOf(rs.get("AS_NM"));
				PT_NO = String.valueOf(rs.get("PT_NO"));
				PT_NM = String.valueOf(rs.get("PT_NM"));
				WMCYMD = String.valueOf(rs.get("WMCYMD"));

				CURR_RF = String.valueOf(rs.get("CURR_RF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_RF")));
				CHART_RF.add(Chart_Data_tmp);

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
				jsonRecord.put("CURR_RF", CURR_RF);
				jsonRecord.put("CHART_RF", CHART_RF);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		} else if ("3".equals(gubun)) {

			for (int i = 0; i < srcList.size(); i++) {
				HashMap rs = (HashMap) srcList.get(i);
				cnt++;
				if (!"".equals(preSeq) && !preSeq.equals(rs.get("RN"))) {
					cnt = 1;
					jsonRecord = new HashMap();
					jsonRecord.put("WS_NM", WS_NM);
					jsonRecord.put("AM_NM", AM_NM);
					jsonRecord.put("AS_NM", AS_NM);
					jsonRecord.put("PT_NO", PT_NO);
					jsonRecord.put("PT_NM", PT_NM);
					jsonRecord.put("WMCYMD", WMCYMD);
					jsonRecord.put("CHART_DATE", CHART_DATE);
					jsonRecord.put("CURR_FW", CURR_FW);
					jsonRecord.put("CHART_FW", CHART_FW);
					jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);
					jsonArr.add(jsonRecord);
					CHART_FW = new ArrayList();
				}
				WS_NM = String.valueOf(rs.get("WS_NM"));
				AM_NM = String.valueOf(rs.get("AM_NM"));
				AS_NM = String.valueOf(rs.get("AS_NM"));
				PT_NO = String.valueOf(rs.get("PT_NO"));
				PT_NM = String.valueOf(rs.get("PT_NM"));
				WMCYMD = String.valueOf(rs.get("WMCYMD"));

				CURR_FW = String.valueOf(rs.get("CURR_FW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_FW")));
				CHART_FW.add(Chart_Data_tmp);

				if (!preSeq.equals(rs.get("RN")))
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
				jsonRecord.put("CURR_FW", CURR_FW);
				jsonRecord.put("CHART_FW", CHART_FW);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		} else if ("4".equals(gubun)) {
			for (int i = 0; i < srcList.size(); i++) {
				HashMap rs = (HashMap) srcList.get(i);
				cnt++;
				if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("RN")))) {

					cnt = 1;

					// System.out.println(preSite + preDate);
					jsonRecord = new HashMap();

					// jsonRecord.put("parentId", parentId);
					jsonRecord.put("WS_NM", WS_NM);
					jsonRecord.put("AM_NM", AM_NM);
					jsonRecord.put("AS_NM", AS_NM);
					jsonRecord.put("PT_NO", PT_NO);
					jsonRecord.put("PT_NM", PT_NM);
					jsonRecord.put("WMCYMD", WMCYMD);
					jsonRecord.put("CHART_DATE", CHART_DATE);
					jsonRecord.put("CURR_SWL", CURR_SWL);
					jsonRecord.put("CHART_SWL", CHART_SWL);
					jsonRecord.put("CURR_INF", CURR_INF);
					jsonRecord.put("CHART_INF", CHART_INF);
					jsonRecord.put("CURR_OTF", CURR_OTF);
					jsonRecord.put("CHART_OTF", CHART_OTF);
					jsonRecord.put("CURR_SFW", CURR_SFW);
					jsonRecord.put("CHART_SFW", CHART_SFW);
					jsonRecord.put("CURR_ECPC", CURR_ECPC);
					jsonRecord.put("CHART_ECPC", CHART_ECPC);
					jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);

					jsonArr.add(jsonRecord);

					CHART_SWL = new ArrayList();
					CHART_INF = new ArrayList();
					CHART_OTF = new ArrayList();
					CHART_SFW = new ArrayList();
					CHART_ECPC = new ArrayList();

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
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SWL")));
				CHART_SWL.add(Chart_Data_tmp);

				CURR_INF = String.valueOf(rs.get("CURR_INF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_INF")));
				CHART_INF.add(Chart_Data_tmp);

				CURR_OTF = String.valueOf(rs.get("CURR_OTF"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_OTF")));
				CHART_OTF.add(Chart_Data_tmp);

				CURR_SFW = String.valueOf(rs.get("CURR_SFW"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SFW")));
				CHART_SFW.add(Chart_Data_tmp);

				CURR_ECPC = String.valueOf(rs.get("CURR_ECPC"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_ECPC")));
				CHART_ECPC.add(Chart_Data_tmp);

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
				jsonRecord.put("CURR_SWL", CURR_SWL);
				jsonRecord.put("CHART_SWL", CHART_SWL);
				jsonRecord.put("CURR_INF", CURR_INF);
				jsonRecord.put("CHART_INF", CHART_INF);
				jsonRecord.put("CURR_OTF", CURR_OTF);
				jsonRecord.put("CHART_OTF", CHART_OTF);
				jsonRecord.put("CURR_SFW", CURR_SFW);
				jsonRecord.put("CHART_SFW", CHART_SFW);
				jsonRecord.put("CURR_ECPC", CURR_ECPC);
				jsonRecord.put("CHART_ECPC", CHART_ECPC);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		} else if ("5".equals(gubun)) {
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
						jsonRecord.put("CURR_WD", CURR_WD);
						jsonRecord.put("CHART_WD", CHART_WD);
						jsonRecord.put("Chart_Data_tmp", Chart_Data_tmp);
						jsonRecord.put("CURR_WS", CURR_WS);
						jsonRecord.put("CHART_WS", CHART_WS);
						jsonRecord.put("CURR_TA", CURR_TA);
						jsonRecord.put("CHART_TA", CHART_TA);
						jsonRecord.put("CURR_HM", CURR_HM);
						jsonRecord.put("CHART_HM", CHART_HM);
						jsonRecord.put("CURR_PA", CURR_PA);
						jsonRecord.put("CHART_PA", CHART_PA);
						jsonRecord.put("CURR_PS", CURR_PS);
						jsonRecord.put("CHART_PS", CHART_PS);
						jsonRecord.put("CURR_RNYN", CURR_RNYN);
						jsonRecord.put("CHART_RNYN", CHART_RNYN);
						jsonRecord.put("CURR_RN1HR", CURR_RN1HR);
						jsonRecord.put("CHART_RN1HR", CHART_RN1HR);
						jsonRecord.put("CURR_RNDAY", CURR_RNDAY);
						jsonRecord.put("CHART_RNDAY", CHART_RNDAY);

						jsonArr.add(jsonRecord);

						CHART_WD = new ArrayList();
						CHART_WS = new ArrayList();
						CHART_TA = new ArrayList();
						CHART_HM = new ArrayList();
						CHART_PA = new ArrayList();
						CHART_PS = new ArrayList();
						CHART_RNYN = new ArrayList();
						CHART_RN1HR = new ArrayList();
						CHART_RNDAY = new ArrayList();

					}

					WS_NM = String.valueOf(rs.get("WS_NM"));
					AM_NM = String.valueOf(rs.get("AM_NM"));
					AS_NM = String.valueOf(rs.get("AS_NM"));
					PT_NO = String.valueOf(rs.get("PT_NO"));
					PT_NM = String.valueOf(rs.get("PT_NM"));
					WMCYMD = String.valueOf(rs.get("WMCYMD"));

					CURR_WD = String.valueOf(rs.get("CURR_WD"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_WD")));
					CHART_WD.add(Chart_Data_tmp);

					CURR_WS = String.valueOf(rs.get("CURR_WS"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_WS")));
					CHART_WS.add(Chart_Data_tmp);

					CURR_TA = String.valueOf(rs.get("CURR_TA"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_TA")));
					CHART_TA.add(Chart_Data_tmp);

					CURR_HM = String.valueOf(rs.get("CURR_HM"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_HM")));
					CHART_HM.add(Chart_Data_tmp);

					CURR_PA = String.valueOf(rs.get("CURR_PA"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_PA")));
					CHART_PA.add(Chart_Data_tmp);

					CURR_PS = String.valueOf(rs.get("CURR_PS"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_PS")));
					CHART_PS.add(Chart_Data_tmp);

					CURR_RNYN = String.valueOf(rs.get("CURR_RNYN"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_RNYN")));
					CHART_RNYN.add(Chart_Data_tmp);

					CURR_RN1HR = String.valueOf(rs.get("CURR_RN1HR"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_RN1HR")));
					CHART_RN1HR.add(Chart_Data_tmp);

					CURR_RNDAY = String.valueOf(rs.get("CURR_RNDAY"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_RNDAY")));
					CHART_RNDAY.add(Chart_Data_tmp);

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
				jsonRecord.put("CURR_WD", CURR_WD);
				jsonRecord.put("CHART_WD", CHART_WD);
				jsonRecord.put("CURR_WS", CURR_WS);
				jsonRecord.put("CHART_WS", CHART_WS);
				jsonRecord.put("CURR_TA", CURR_TA);
				jsonRecord.put("CHART_TA", CHART_TA);
				jsonRecord.put("CURR_PS", CURR_PS);
				jsonRecord.put("CHART_PS", CHART_PS);
				jsonRecord.put("CURR_HM", CURR_HM);
				jsonRecord.put("CHART_HM", CHART_HM);
				jsonRecord.put("CURR_PA", CURR_PA);
				jsonRecord.put("CHART_PA", CHART_PA);
				jsonRecord.put("CURR_PS", CURR_PS);
				jsonRecord.put("CHART_PS", CHART_PS);
				jsonRecord.put("CURR_RNYN", CURR_RNYN);
				jsonRecord.put("CHART_RNYN", CHART_RNYN);
				jsonRecord.put("CURR_RN1HR", CURR_RN1HR);
				jsonRecord.put("CHART_RN1HR", CHART_RN1HR);
				jsonRecord.put("CURR_RNDAY", CURR_RNDAY);
				jsonRecord.put("CHART_RNDAY", CHART_RNDAY);
			} else if (cnt == 0 && check == "9999") {
				jsonRecord.put("WMCYMD", WMCYMD);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		} else if ("6".equals(gubun)) {
			for (int i = 0; i < srcList.size(); i++) {
				HashMap rs = (HashMap) srcList.get(i);
				cnt++;
				if (!preSeq.equals("") && !preSeq.equals(String.valueOf(rs.get("RN")))) {

					cnt = 1;

					// System.out.println(preSite + preDate);
					jsonRecord = new HashMap();

					// jsonRecord.put("parentId", parentId);
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
				// else{
				WS_NM = String.valueOf(rs.get("WS_NM"));
				AM_NM = String.valueOf(rs.get("AM_NM"));
				AS_NM = String.valueOf(rs.get("AS_NM"));
				PT_NO = String.valueOf(rs.get("PT_NO"));
				PT_NM = String.valueOf(rs.get("PT_NM"));
				WMCYMD = String.valueOf(rs.get("WMCYMD"));

				CURR_RND = String.valueOf(rs.get("CURR_RND"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_RND")));
				CHART_RND.add(Chart_Data_tmp);

				CURR_TA = String.valueOf(rs.get("CURR_TA"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_TA")));
				CHART_TA.add(Chart_Data_tmp);

				CURR_SIDAY = String.valueOf(rs.get("CURR_SIDAY"));
				Chart_Data_tmp = new ArrayList();
				Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
				Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SIDAY")));
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
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SWL")));
					CHART_SWL.add(Chart_Data_tmp);

					CURR_OWL = String.valueOf(rs.get("CURR_OWL"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_OWL")));
					CHART_OWL.add(Chart_Data_tmp);

					CURR_SFW = String.valueOf(rs.get("CURR_SFW"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_SFW")));
					CHART_SFW.add(Chart_Data_tmp);

					CURR_ECPC = String.valueOf(rs.get("CURR_ECPC"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_ECPC")));
					CHART_ECPC.add(Chart_Data_tmp);

					CURR_INF = String.valueOf(rs.get("CURR_INF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_INF")));
					CHART_INF.add(Chart_Data_tmp);

					CURR_TOTOTF = String.valueOf(rs.get("CURR_TOTOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_TOTOTF")));
					CHART_TOTOTF.add(Chart_Data_tmp);

					CURR_EGOTF = String.valueOf(rs.get("CURR_EGOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_EGOTF")));
					CHART_EGOTF.add(Chart_Data_tmp);

					CURR_GTOTF = String.valueOf(rs.get("CURR_GTOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_GTOTF")));
					CHART_GTOTF.add(Chart_Data_tmp);

					CURR_CBOTF = String.valueOf(rs.get("CURR_CBOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_CBOTF")));
					CHART_CBOTF.add(Chart_Data_tmp);

					CURR_FWOTF = String.valueOf(rs.get("CURR_FWOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_FWOTF")));
					CHART_FWOTF.add(Chart_Data_tmp);

					CURR_ETCOTF = String.valueOf(rs.get("CURR_ETCOTF"));
					Chart_Data_tmp = new ArrayList();
					Chart_Data_tmp.add(cnt + String.valueOf(rs.get("CHART_DATE")).replace(".", ""));
					Chart_Data_tmp.add(String.valueOf(rs.get("CHART_ETCOTF")));
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
			} else if (cnt == 0 && check == "9999") {
				jsonRecord.put("WMCYMD", WMCYMD);
			} else {
				jsonRecord.put("msg", "데이터가 존재하지 않습니다.");
			}
		}
		
		jsonArr.add(jsonRecord);

		result.put("data", jsonArr);
	}

}
