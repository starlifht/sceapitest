package star.test.openapi;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.api.methods.Tools;
import star.test.methods.Params;


public class AppTest {
	//public static final String  DOMAIN="http://open_api.scetest.sohuno.com"; //  sohutest.apps.sohuno.com
	public static final String  DOMAIN="http://sohutest.apps.sohuno.com";
	//public static final String  DOMAIN="http://openapi-test.apps.sohuno.com";
	public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//测试
	//public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//线上
	public static final String APPID="93695";
	public static final String INSTANCEID="bdc803ba-bada-11e3-ac15-00163e662aba";//93677
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
					.doGet(Params.DOMAIN+"/apps?access_token="+Params.ACCESS_TOKEN);
			
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
		public void getAppAbtestStatus() {//获取app的灰度发布状态
			try {
				String response= HttpClientUtil
						.doGet(DOMAIN+"/apps/"+APPID+"/versions/abtest?access_token="+ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void getAppVersions() {//获取app的详细信息
			try {
				String response= HttpClientUtil
						.doGet(DOMAIN+"/apps/"+APPID+"/versions?access_token="+ACCESS_TOKEN);
				
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
		public void deployApp() {//修改APP信息
			try {
			String filePath=HttpClientUtil.class.getResource("/1.png").getPath();
				String response= HttpClientUtil.doPostFile(DOMAIN+"/apps/"+APPID+"/deploy?access_token="+ACCESS_TOKEN,filePath);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
		@Test
		public void modifyAppVersionInfo() {//修改APP信息
			try {
				Map<String,String> data =new HashMap<String,String>();
				data.put("version","5");
				data.put("description","test测试");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPut(DOMAIN+"/apps/"+APPID+"/versions?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void modifyAppAbtestStatus() {//修改APP灰度发布状态   true  false
			try {
				Map<String,String> data =new HashMap<String,String>();
				data.put("is_abtest","false");
				//data.put("description","test测试");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPut(DOMAIN+"/apps/"+APPID+"/versions/abtest?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void setCurrent_version() {//修改当前版本
			try {
				Map<String,String> data =new HashMap<String,String>();
				data.put("version","1");
				data.put("description","test测试");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPut(DOMAIN+"/apps/"+APPID+"/current_version?access_token="+ACCESS_TOKEN,data);
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
				data.put("domain", "www.test.sta2r.com");
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
		public void addAppVersion() {//增加APP的版本
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("description", "测试版本dfsd");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPost(DOMAIN+"/apps/"+APPID+"/versions?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void restartApp() {//增加APP的版本
			try {
//				Map<String,String> data =new HashMap<String ,String>();
//				data.put("description", "测试版本dfsd");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPost(DOMAIN+"/apps/"+APPID+"/restart?access_token="+ACCESS_TOKEN);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Test
		public void restartInstance() {//重启实例
			try {
//				Map<String,String> data =new HashMap<String ,String>();
//				data.put("description", "测试版本dfsd");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPost(DOMAIN+"/instances/"+INSTANCEID+"/restart?access_token="+ACCESS_TOKEN);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Test
		public void stopInstance() {//停止实例
			try {
//				Map<String,String> data =new HashMap<String ,String>();
//				data.put("description", "测试版本dfsd");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPost(DOMAIN+"/instances/"+INSTANCEID+"/stop?access_token="+ACCESS_TOKEN);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Test
		public void stopApp() {//停止app
			try {
//				Map<String,String> data =new HashMap<String ,String>();
//				data.put("description", "测试版本dfsd");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPost(DOMAIN+"/apps/"+APPID+"/stop?access_token="+ACCESS_TOKEN);
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
		//	System.out.println(Tools.getRandomString(7));
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
		public void deleteAppVersion() {//删除app的版本
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("version", Integer.toString(2));
			
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/apps/"+APPID+"/versions?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void deleteInstance() {//删除实例
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("version", Integer.toString(2));
			
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/instances/"+INSTANCEID+"?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		@Test
		public void cleanAppDomains() {//删除域名
			try {
			
			System.out.println(Tools.getRandomString(7));
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/apps/"+APPID+"/domains/clean?access_token="+ACCESS_TOKEN);
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
				data.put("name", "UiSDwFJ");
			System.out.println(Tools.getRandomString(7));
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/apps/93706"+"?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
