package star.api.methods;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	private final static String DEFAULT_CHARSET = "UTF-8";
	public static final String  DOMAIN="http://open_api.scetest.sohuno.com"; 
	public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";
	public static final String APPID="93695";
	public static String doGet(String url) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		
		
		httpGet.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
		return sendRequest(httpGet);
	}
	public static String doGet(String url,Map<String,String> paramMap) throws Exception {
		
		 String paramStr = prepareParam(paramMap);
		 HttpGet httpGet;
		 if(url.indexOf("?")!=-1){
		 httpGet = new HttpGet(url+"&"+paramStr);
		 }else{
			 httpGet = new HttpGet(url+"?"+paramStr);	 
		 }
		httpGet.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
		return sendRequest(httpGet);
	}


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
//	HttpPost.addHeader("timestamp",
//			String.valueOf(System.currentTimeMillis()));
//	HttpPost.addHeader("access_token","38e455dd16940b39b6aef91536de2554");
//	HttpPost.addHeader("source","console");
//	HttpPost.addHeader("client-ip","8.8.8.8");
	HttpPost.addHeader("Content-Type",
			"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
	return sendRequest(HttpPost);

}
public static String doPut(String url) throws Exception {
	HttpPut HttpPut = new HttpPut(url);

	HttpPut.addHeader("Content-Type",
			"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
	return sendRequest(HttpPut);

}

public static String doDelete(String url) throws Exception {
	HttpDelete HttpDelete = new HttpDelete(url);
	
	
	HttpDelete.addHeader("Content-Type",
			"application/x-www-form-urlencoded; charset=" + DEFAULT_CHARSET);
	return sendRequest(HttpDelete);

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
        conn.addRequestProperty("timestamp", String.valueOf(System.currentTimeMillis()));
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
	public static String createXMLURLConnection(String str_url,String filepath) throws Exception {
	     
        URL url = new URL(str_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();	   
        con.setDoOutput(true);
        con.setReadTimeout(5000);
        con.setConnectTimeout(5000);
       con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
        con.setRequestProperty("timestamp", String.valueOf(System.currentTimeMillis()));
        con.setRequestProperty("source", "sonsole");
       con.setRequestProperty("client-ip", "8.8.8.8");
//        con.setRequestProperty("Cache-Control", "no-cache");
//        con.setRequestProperty("Content-Type", "text/xml;charset=GBK");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(filepath));
        BufferedOutputStream  out = new BufferedOutputStream (con.getOutputStream()); 
      //  byte[] bs = new byte[1024];
        int len=(int) new File(filepath).length();
        byte[] bs = new byte[len];
        in.read(bs, 0, len);
        out.write(bs);
//        while ((len = in.read(bs)) != -1) {
//        	out.write(bs,0,len);
//        	}
      
        out.flush();
        out.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
        String line = "";
        String response="";
        for (line = br.readLine(); line != null; line = br.readLine()) {
          response=response+line;
        } 
		return response;

 
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


	public static String doPostFile(String url,String filePath) throws Exception{
		 HttpClient httpclient = new DefaultHttpClient();  
	        //请求处理页面  
	        HttpPost httppost = new HttpPost(  
	                url);  
	        //创建待处理的文件  
	       // FileBody file = new FileBody(new File("d:/22.rar"));  
	      // httppost.addHeader("Content-Type","application/octet-stream; charset=" + DEFAULT_CHARSET);
	        httppost.addHeader("client-ip","8.8.8.8");
	        httppost.addHeader("timestamp",String.valueOf(System.currentTimeMillis()));
	        httppost.addHeader("source","console");
	        FileBody file = new FileBody(new File(filePath));  
	        //创建待处理的表单域内容文本  
	        StringBody version = new StringBody("star888");  	  
	        //对请求的表单域进行填充  
	        MultipartEntity reqEntity = new MultipartEntity();  
	        reqEntity.addPart("file", file);  
	        reqEntity.addPart("object_name", version);  
	        //设置请求  
	        httppost.setEntity(reqEntity); 
	    
	        //执行  
	        HttpResponse response = httpclient.execute(httppost);  
	        //HttpEntity resEntity = response.getEntity();  
	        //System.out.println(response.getStatusLine());  
	       // if(HttpStatus.SC_OK==response.getStatusLine().getStatusCode()){  
			String status =response.getStatusLine().toString();
			System.out.println(status);
	            HttpEntity entity = response.getEntity();  
	            //显示内容  
	            String result=null;
	            if (entity != null) {  
	            	result=EntityUtils.toString(entity);
	            	return result; 
	            } else{
	            	return "entity is null";
	            }
	        
	     //   }  
	        
	}
	public static String sendRequest(HttpUriRequest httpUriRequest)
			throws Exception {

		HttpClient client = new DefaultHttpClient();
		httpUriRequest.addHeader("client-ip","8.8.8.8");
		httpUriRequest.addHeader("source","console");
		//httpUriRequest.addHeader("access_token","38e455dd16940b39b6aef91536de2554");
		httpUriRequest.addHeader("timestamp",String.valueOf(System.currentTimeMillis()));
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
			Map<String,String> data =new HashMap<String ,String>();
			data.put("version", "3");
			//System.out.println(RandomStringUtils.random(6));
			//String response= HttpClientUtil.doPut(DOMAIN+"/apps/"+APPID+"/versions?access_token="+ACCESS_TOKEN,data);
//			  Class clazz = this.getClass(); 
			URL url = HttpClientUtil.class.getResource("1.png");
			System.out.print("");
			String response=HttpClientUtil.doPostFile("http://localhost:8080/star/test_upFile_doUpLoad",HttpClientUtil.class.getResource("/1.png").getPath());
			System.out.print(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
