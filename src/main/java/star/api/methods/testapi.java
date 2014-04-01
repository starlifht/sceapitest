package star.api.methods;


import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class testapi {
	@Test
	//新建app
	public void createAppTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		   // 目标地址   
	     HttpPost httppost = new HttpPost("http://open_api.scetest.sohuno.com/apps/93667/restart?access_token=47dd89c79df4e10fb66dbfb9918f6dc1");   
	     System.out.println("请求: " + httppost.getRequestLine());
	     System.out.println("----------------------------------------");  

        try {
            // 发送请求，返回响应
            HttpResponse response = httpClient.execute(httppost);
 
            // 打印响应信息
            System.out.println(response.getStatusLine());
       //     HttpResponse response1 = httpclient.executeMethod(response1);
            String cont = EntityUtils.toString(response.getEntity());
            System.out.println(cont);
        } catch (ClientProtocolException e) {
            // 协议错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络异常
            e.printStackTrace();
        }
		
	}
	@Test
	public void dfsdf(){
//		Map<String ,String[]> data=new HashMap<String, String[]>() ;
//		data.put("access_token",  new String[]{"47dd89c79df4e10fb66dbfb9918f6dc1"});
//		try {
//			String s =HttpClientUtil.doPost("http://open_api.scetest.sohuno.com/apps/93667/restart");
//			System.out.print(s);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
