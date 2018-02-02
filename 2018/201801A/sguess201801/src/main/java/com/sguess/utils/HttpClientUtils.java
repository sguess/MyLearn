package com.sguess.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpClientUtils {
	public static String getApiData(String urlStr, String charSet) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		StringBuffer rstSb = new StringBuffer();
		try {
			URI url = new URI(urlStr);
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStream in = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, charSet));
			String lineStr = "";
			while ((lineStr = reader.readLine()) != null) {
				rstSb.append(lineStr);
			}
			response.close();
		} catch (URISyntaxException e) {
			return "";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rstSb.toString();
	}

	public static void main(String[] args) {
		String urlStr = "http://localhost:9080/tmp/api/zh";
		urlStr = "http://www.baidu.com";
		String rst = HttpClientUtils.getApiData(urlStr, "UFT-8");
		System.out.println(rst);
	}
}
