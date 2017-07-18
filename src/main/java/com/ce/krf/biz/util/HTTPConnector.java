package com.ce.krf.biz.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class HTTPConnector {

	public static final String USER_AGENT = "Mozilla/5.0";

	// HTTP GET request
	public int sendGet(String url, HashMap<String, Object> params, String contextType, StringBuffer response)
			throws Exception {

		if (url == null || "".equals(url)) {
			return 0;
		}
		String parameter = "";
		if (params != null) {
			for (String key : params.keySet()) {
				parameter += key + "=" + params.get(key) + "&";
			}
			parameter = parameter.substring(0, parameter.length() - 1);
		}
		if (!"".equals(parameter)) {
			url += "?" + parameter;
		}
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Context-Type", contextType);

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return responseCode;
	}

	// HTTP POST request
	public int sendPost(String url, HashMap<String, Object> params, String contextType, StringBuffer response)
			throws Exception {
		if (url == null || "".equals(url)) {
			return 0;
		}
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Context-Type", contextType);
		String parameter = "";
		for (String key : params.keySet()) {
			parameter += key + "=" + params.get(key) + "&";
		}
		parameter = parameter.substring(0, parameter.length() - 1);
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(parameter);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return responseCode;
	}

}
