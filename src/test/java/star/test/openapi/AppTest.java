package star.test.openapi;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.api.methods.Tools;

public class AppTest {
	public static final String  DOMAIN="http://open_api.scetest.sohuno.com"; 
	public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";
	public static final String APPID="93695";
	public AppTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getAppList() {//获取app全部信息
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/apps?access_token="+ACCESS_TOKEN);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}}
		@Test
		public void getAppDetail() {//获取app的详细信息
			try {
				String response= HttpClientUtil
						.doGet(DOMAIN+"/apps/"+APPID+"?access_token="+ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void getAppDomains() {//获取app的详细信息
			try {
				String response= HttpClientUtil
						.doGet(DOMAIN+"/apps/"+APPID+"/domains?access_token="+ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void getAppInstances() {//出我所管理的APP的实例列表
			try {
				String response= HttpClientUtil
						.doGet(DOMAIN+"/apps/"+APPID+"/instances?access_token="+ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void getAppDumpstack() {//出我所管理的APP的实例列表
			try {
				String response= HttpClientUtil
						.doPost(DOMAIN+"/apps/"+APPID+"/dumpstack?access_token="+ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void creatApp() {//创建APP
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("name", Tools.getRandomString(7));
				String response= HttpClientUtil
						.doPost(DOMAIN+"/apps?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void modifyAppInfo() {//修改APP信息
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("name", Tools.getRandomString(7));
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPut(DOMAIN+"/apps/"+APPID+"?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void addAppDomain() {//增加新的域名
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("domain", "www.test.star.com");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPost(DOMAIN+"/apps/"+APPID+"/domains?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void deleteAppDomain() {//删除域名
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("domain", "www.test.star.com");
			System.out.println(Tools.getRandomString(7));
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/apps/"+APPID+"/domains?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void deleteApp() {//修改APP信息
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("name", "TfEXdRl");
			System.out.println(Tools.getRandomString(7));
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/apps/93693"+"?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
