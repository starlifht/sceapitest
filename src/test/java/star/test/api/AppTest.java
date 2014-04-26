package star.test.api;

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
	public static final String  DOMAIN=Params.DOMAIN; //  sohutest.apps.sohuno.com
	//public static final String  DOMAIN="http://sohutest.apps.sohuno.com";
	//public static final String  DOMAIN="http://openapi-test.apps.sohuno.com";
	public static final String  ACCESS_TOKEN=Params.ACCESS_TOKEN;//测试
	//public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//线上
	public static final String APPID=Params.APPID;
	public static final String INSTANCEID=Params.INSTANCEID;//93677
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
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {fail(e.toString());
			e.printStackTrace();
		}}
		@Test
		public void getAppDetail() {//获取app的详细信息
			try {
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/apps/"+Params.APPID+"?access_token="+Params.ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void getAppDomains() {//获取app的详细信息
			try {
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/apps/"+Params.APPID+"/domains?access_token="+Params.ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void getAppAbtestStatus() {//获取app的灰度发布状态
			try {
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/apps/"+Params.APPID+"/versions/abtest?access_token="+Params.ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void getAppVersions() {//获取app的详细信息
			try {
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/apps/"+Params.APPID+"/versions?access_token="+Params.ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void getAppInstances() {//出我所管理的APP的实例列表
			try {
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/apps/"+Params.APPID+"/instances?access_token="+Params.ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void getAppDumpstack() {//出我所管理的APP的实例列表
			try {
				String response= HttpClientUtil
						.doPost(Params.DOMAIN+"/apps/"+Params.APPID+"/dumpstack?access_token="+Params.ACCESS_TOKEN);
				
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				System.out.print(response);
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void creatApp() {//创建APP
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("name", Tools.getRandomString(7));
				data.put("description", "random app creating");
				String response= HttpClientUtil
						.doPost(Params.DOMAIN+"/apps?access_token="+Params.ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void deployApp() {//修改APP信息
			try {
			String filePath=HttpClientUtil.class.getResource("/10207.zip").getPath();
				String response= HttpClientUtil.doPostFile(DOMAIN+"/apps/"+APPID+"/deploy?access_token="+ACCESS_TOKEN,filePath);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				fail(e.toString());
				e.printStackTrace();
			}
	}
		
		@Test
		public void modifyAppVersionInfo() {//修改APP版本信息
			try {
				Map<String,String> data =new HashMap<String,String>();
				data.put("version","2");
				data.put("description","test测s试");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPut(DOMAIN+"/apps/"+APPID+"/versions?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {fail(e.toString());
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
				if(!JSONObject.fromObject(response).getString("code").equals("10011")){
					fail(response);
				}
				
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void setCurrent_version() {//修改当前版本
			try {
				Map<String,String> data =new HashMap<String,String>();
				data.put("version","2");
				//data.put("description","test测试");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPut(DOMAIN+"/apps/"+APPID+"/current_version?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
		}
		
		@Test
		public void deleteAppDomain() {//删除域名
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("domain", "www.test.sta2r.com");
		//	System.out.println(Tools.getRandomString(7));
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/apps/"+APPID+"/domains?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
	}
		@Test
		public void deleteAppVersion() {//删除app的版本
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("version", "4");
			
				String response= HttpClientUtil
						.doDelete(DOMAIN+"/apps/"+APPID+"/versions?access_token="+ACCESS_TOKEN,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
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
				
			} catch (Exception e) {fail(e.toString());
				e.printStackTrace();
			}
		}
		
}
