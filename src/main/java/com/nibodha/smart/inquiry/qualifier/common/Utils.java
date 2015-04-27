/**
 * 
 */
package com.nibodha.ear.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author Suresh Kumar S
 *
 */
public class EARUtils {
	public static final String BASE_URL = "http://api.guesswork.co/v1/customer/fitment";
	
	public static String formUrl(String productURL, String email){
		if(isNullOrBlank(productURL) || isNullOrBlank(email)) return null;
		StringBuilder requestUrl = new StringBuilder();
		try {
			requestUrl.append(BASE_URL);
			requestUrl.append("?token=" + URLEncoder.encode(EARConstants.TOKEN, "UTF-8"));
			requestUrl.append("&url=" + productURL);
			requestUrl.append("&email=" + email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestUrl.toString();
	}
	
	public static boolean isNullOrBlank(String param) { 
		return param == null || param.isEmpty();
	}
	
	public static StringReader getResponse(String urlString) {
		HttpURLConnection connection = null;
		StringReader reader = null;
		try {
			URL url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();
			// add request header
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			connection.connect();

			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringWriter writer = new StringWriter();
			String line = "";
			while ((line = rd.readLine()) != null) {
				writer.write(line);
			}
			reader = new StringReader(writer.toString());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (null != connection) {
				connection.disconnect();
			}
		}
		return reader;
	}
}
