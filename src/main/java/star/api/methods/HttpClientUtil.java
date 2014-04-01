package star.api.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	private final static String DEFAULT_CHARSET = "UTF-8";

	public static String doGet(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		
		httpGet.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
		return sendRequest(httpGet);
	}

//	 public static String doPost(String url, Map<String, String[]> data)
//	 throws Exception {
//	 List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//	
//	 for (Entry<String, String[]> entry : data.entrySet()) {
//	 for (String value : entry.getValue()) {
//	 if ("".equals(value)) {
//	 continue;
//	 }
//	 formparams.add(new BasicNameValuePair(entry.getKey(), value));
//	 }
//	 }
//	
//	 UrlEncodedFormEntity requestEntity = null;
//	
//	 requestEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//	
//	 // System.out.println(requestEntity.toString());
//	 HttpPost httpPost = new HttpPost(url);
//	 httpPost.setEntity(requestEntity);
//	 httpPost.addHeader("Content-Type",
//	 "application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
//	
//	 return sendRequest(httpPost);
//	 }

	public static String doPut(String url, Map<String, String> data)
			throws Exception {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		for (Entry<String, String> entry : data.entrySet()) {

			if ("".equals(entry.getValue())) {
				continue;
			}
			//System.out.println(entry.getKey() + entry.getValue());
			formparams.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));

		}

		UrlEncodedFormEntity requestEntity = null;

		requestEntity = new UrlEncodedFormEntity(formparams, "UTF-8");

		// System.out.println(requestEntity.toString());
		HttpPut HttpPut = new HttpPut(url);
		
		HttpPut.setEntity(requestEntity);
		HttpPut.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);

		return sendRequest(HttpPut);
	}
public static String doPost(String url) throws Exception {
	HttpPost HttpPost = new HttpPost(url);
	HttpPost.addHeader("Content-Type",
			"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
	return sendRequest(HttpPost);

}
	private static String prepareParam(Map<String,String> paramMap){
        StringBuffer sb = new StringBuffer();
        if(paramMap.isEmpty()){
            return "" ;
        }else{
            for(String key: paramMap.keySet()){
                String value = (String)paramMap.get(key);
                if(sb.length()<1){
                    sb.append(key).append("=").append(value);
                }else{
                    sb.append("&").append(key).append("=").append(value);
                }
            }
            return sb.toString();
        }
    }
	public static String  doDelete(String urlStr,Map<String,String> paramMap) throws Exception{
        String paramStr = prepareParam(paramMap);
        if(paramStr == null || paramStr.trim().length()<1){
            
        }else{
            urlStr +="&"+paramStr;
        }   
       // System.out.println(urlStr);
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("DELETE");
        System.out.println(conn.getResponseCode()+conn.getResponseMessage());
        BufferedReader reader = new BufferedReader(new InputStreamReader(
        		conn.getInputStream()));
        
        String lines=null;
        StringBuffer result=new StringBuffer();
        while ((lines = reader.readLine()) != null) {
          result.append(lines);
        }
        reader.close();
        // 断开连接
        conn.disconnect();
          
        
      
		return result.toString();
    }
	public static String doPost(String url, Map<String, String> data)
			throws Exception {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		for (Entry<String, String> entry : data.entrySet()) {

			if ("".equals(entry.getValue())) {
				continue;
			}
			//System.out.println(entry.getKey() + entry.getValue());
			formparams.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));

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
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
