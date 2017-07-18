package com.ce.krf.biz.service;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.CommonMapper;
import com.ce.krf.biz.model.ClickLogVO;
import com.ce.krf.biz.model.ExcelDownloadVO;
import com.ce.krf.biz.util.HTTPConnector;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommonService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public CommonMapper commonMapper;
	
	@Value("${print.img.path}")
	public String imgPath;

	/**
	 * Desc :
	 * 
	 * @Method Name : excelDown
	 * @param excelVo
	 * @param servletOutputStream
	 * @throws Exception
	 */
	public void excelDown(ExcelDownloadVO excelVo, ServletOutputStream servletOutputStream) throws Exception {
		ObjectMapper om = new ObjectMapper();

		ArrayList<String> headNameList = om.readValue(excelVo.getHeadName(), ArrayList.class);
		ArrayList<String> headList = om.readValue(excelVo.getHeader(), ArrayList.class);
		ArrayList<HashMap<String, Object>> dataList = om.readValue(excelVo.getDatas(), ArrayList.class);
		String url = excelVo.getUrl();
		String param = excelVo.getParam();

		if (url != null && !"".equals(url)) {

			StringTokenizer token = new StringTokenizer(url, "?");
			if (token.countTokens() > 0) {
				token.nextToken();
			}
			url = token.nextToken();

			HTTPConnector con = new HTTPConnector();
			StringBuffer response = new StringBuffer();

			int responeCode = con.sendPost(url + "?" + URLEncoder.encode(param, "UTF-8") + "&_excel_=1", null,
					"application/x-www-form-urlencoded", response);
			if (responeCode == 200) {
				dataList = om.readValue(response.toString(), ArrayList.class);
			}
		}

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("검색결과");

		HSSFRow hRow = sheet.createRow(0);
		for (int i = 0; i < headNameList.size(); i++) {
			String headName = (String) headNameList.get(i);
			hRow.createCell(i).setCellValue(headName);
		}

		int dataSize = dataList.size();

		for (int i = 0; i < dataSize; i++) {
			HashMap<String, Object> dataSet = (HashMap<String, Object>) dataList.get(i);
			HSSFRow row = sheet.createRow(i + 1);
			for (int k = 0; k < headList.size(); k++) {
				String head = (String) headList.get(k);
				if (dataSet.get(head) == null && !(dataSet.get(head) instanceof java.lang.String)) {
					row.createCell(k).setCellValue("");
				} else {
					row.createCell(k).setCellValue(dataSet.get(head) + "");
				}
			}
		}
		workbook.write(servletOutputStream);
		servletOutputStream.flush();
	}

	/**
	 * Desc : 비밀번호 암호화 데이터
	 * 
	 * @Method Name : sha256
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public String sha256(String pwd) throws Exception {
		MessageDigest sh = MessageDigest.getInstance("SHA-256");
		sh.update(pwd.getBytes());
		byte byteData[] = sh.digest();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
	public int clickSession(ClickLogVO clickLogVO) {
		// TODO Auto-generated method stub
		return commonMapper.clickSession(clickLogVO);
	}
	
	public Map<String,Object> getLabelLayerAdmin(){
		
		HashMap result = new HashMap();
		result.put("bodDatas", commonMapper.getLabelLayerAdmin("ITEM_BOD"));
		result.put("codDatas", commonMapper.getLabelLayerAdmin("ITEM_COD"));
		result.put("docDatas", commonMapper.getLabelLayerAdmin("ITEM_DOC"));
		result.put("tnDatas", commonMapper.getLabelLayerAdmin("ITEM_TN"));
		result.put("tpDatas", commonMapper.getLabelLayerAdmin("ITEM_TP"));
		result.put("tempDatas", commonMapper.getLabelLayerAdmin("ITEM_TEMP"));
		
		return null;
	}
}
