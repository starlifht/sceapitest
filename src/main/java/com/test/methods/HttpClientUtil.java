package com.test.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	private final static String DEFAULT_CHARSET = "UTF-8";

	public static String doGet(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
		return sendRequest(httpGet);
	}

	 public static String doPost(String url, Map<String, String[]> data)
	 throws Exception {
	 List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	
	 for (Entry<String, String[]> entry : data.entrySet()) {
	 for (String value : entry.getValue()) {
	 if ("".equals(value)) {
	 continue;
	 }
	 formparams.add(new BasicNameValuePair(entry.getKey(), value));
	 }
	 }
	
	 UrlEncodedFormEntity requestEntity = null;
	
	 requestEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
	
	 // System.out.println(requestEntity.toString());
	 HttpPost httpPost = new HttpPost(url);
	 httpPost.setEntity(requestEntity);
	 httpPost.addHeader("Content-Type",
	 "application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
	
	 return sendRequest(httpPost);
	 }
	public static String doPost(String url) throws Exception {
		HttpPost HttpPost = new HttpPost(url);
		HttpPost.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
		return sendRequest(HttpPost);

	}

//	public static String doPost(String url, Map<String, String> data)
//			throws Exception {
//		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//
//		for (Entry<String, String> entry : data.entrySet()) {
//
//			if ("".equals(entry.getValue())) {
//				continue;
//			}
//			//System.out.println(entry.getKey() + entry.getValue());
//			formparams.add(new BasicNameValuePair(entry.getKey(), entry
//					.getValue()));
//
//		}
//
//		UrlEncodedFormEntity requestEntity = null;
//
//		requestEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//
//		// System.out.println(requestEntity.toString());
//		HttpPost httpPost = new HttpPost(url);
//		httpPost.setEntity(requestEntity);
//		httpPost.addHeader("Content-Type",
//				"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
//
//		return sendRequest(httpPost);
//	}

	public static String sendRequest(HttpUriRequest httpUriRequest)
			throws Exception {

		HttpClient client = new DefaultHttpClient();

		client.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
		// wrapClient(client);
		HttpResponse response = null;
		System.out.println(httpUriRequest.getRequestLine());
		response = client.execute(httpUriRequest);
		client.getConnectionManager().shutdown();
		String responseContent = "";
		String status =response.getStatusLine().toString();
		System.out.println(status);
		// if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			responseContent = EntityUtils.toString(responseEntity,
					DEFAULT_CHARSET);
			EntityUtils.consume(responseEntity);
			return responseContent;
		} else {
			return "responseEntity is NULL";
		}
	}

	public static void main(String[] args) {
		try {
			String s = HttpClientUtil
					.doPost("http://open_api.scetest.sohuno.com/apps/93686/restart?access_token=97043a103dfa54b2344b741300459a8e");
			System.out.print(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
