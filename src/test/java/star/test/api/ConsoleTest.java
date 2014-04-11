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

public class ConsoleTest {

	public ConsoleTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void creatApp() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("name", Tools.getRandomString(7));
			data.put("app_type", "web");//web|worker
			data.put("test_flag", "1");
			data.put("description", "test");
			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/create",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void updateConfig() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");
			
			data.put("session_flag", "1");
			data.put("container_type", "test");
			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/config/set",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getConfig() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/config",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getDomains() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/domains",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getVersions() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/versions",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getInstances() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/instances",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getSecurity() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/security",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getRulesFacts() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/rules/facts",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addDomains() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");
			data.put("domain", "www.test.com");
			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/domains/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}

	@Test
	public void delDomains() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");
			data.put("domain", "www.test.com");
			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/domains/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getRules() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/rules",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getRulesActions() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/rules/actions",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getDetailConfig() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/config/details",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void closeRules() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			data.put("ruleid","");
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/rules/close",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void openRules() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			data.put("ruleid","");
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/rules/open",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delRules() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");

			data.put("ruleid","");
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/rules/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addRules() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");
			data.put("name","");
			data.put("clazz","");
			data.put("conditions","");
			data.put("ops","");
			data.put("action","");
			data.put("target","");
			data.put("description","");
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/rules/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void updateRules() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");
			data.put("ruleid","");
			data.put("name","");
			data.put("clazz","");
			data.put("conditions","");
			data.put("ops","");
			data.put("action","");
			data.put("target","");
			data.put("description","");
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/rules/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delApp() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
			data.put("name","");
			;
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void deployApp() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
		
			;
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/deploy",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void restartApp() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
		
			;
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/restart",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void stopApp() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
		
			;
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/stop",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void restartInstances() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("ins_name", "555");			
		
			;
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/instances/restart",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void undeployInstances() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("ins_name", "555");			
		
			;
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/instances/undeploy",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void exportStack() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
		
			;
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/stack/export",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void openABtest() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
		
			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/abtest/open",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void closeABtest() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
			data.put("version", "5");	
			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/abtest/close",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getABVersions() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
			//data.put("version", "5");	
			
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/appctl/ab/versions",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void setCurrentVersion() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
			data.put("version", "5");				
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/versions/set",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void uploadApp() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
			data.put("version", "5");
			data.put("file_id", "5");	
			data.put("body", "5");	
			data.put("desc", "5");	
			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/versions/upload_swf",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void checkVersions() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", "555");			
			data.put("version", "5");					
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/apps/versions/check",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getAuditLogs() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("begin_time", "2014-01-13 08:22:45");
			data.put("end_time	", "2014-01-13 08:22:45");
			data.put("key_words", "test");
			data.put("cur_page", "2");
			data.put("page_size", "33");
			data.put("order_type", "app");//asc|desc					
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/logs/audit",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getAppAccessLogs() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("begin_time", "2014-01-13 08:22:45");
			data.put("end_time	", "2014-01-13 08:22:45");
			data.put("key_words", "test");
			data.put("cur_page", "2");
			data.put("page_size", "33");
			data.put("order_type", "app");//asc|desc					
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/logs/access",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getAppLogs() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("begin_time", "2014-01-13 08:22:45");
			data.put("end_time	", "2014-01-13 08:22:45");
			data.put("key_words", "test");
			data.put("cur_page", "2");
			data.put("page_size", "33");
			data.put("order_type", "app");//asc|desc					
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/logs/app",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getSystemLogs() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("begin_time", "2014-01-13 08:22:45");
			data.put("end_time	", "2014-01-13 08:22:45");
			data.put("key_words", "test");
			data.put("cur_page", "2");
			data.put("page_size", "33");
			data.put("order_type", "app");//asc|desc					
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/logs/user",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getSecurityInfo() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
							
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/security/info",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addUA() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("regex", "");					
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/security/ua/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void deleteUA() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("regex", "");				
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/security/ua/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addIPlist() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("ip", "");	
			data.put("type", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/security/iplist/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void deleteIPlist() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("ip", "");	
			data.put("type", "");			
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/security/iplist/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addRateLimit() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("rate", "");	
			data.put("time_unit", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/security/rate/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delRateLimit() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
//			data.put("rate", "");	
//			data.put("time_unit", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/security/rate/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getAllAuthUsers() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
//			data.put("rate", "");	
//			data.put("time_unit", "");	
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/auth/info",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void switchOwner() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("userid", "");	
//			data.put("time_unit", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/owner/switch",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addRole() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("userid", "");	
			data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/role/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void switchRole() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("userid", "");	
			data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/role/switch",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void deleteRole() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("userid", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/role/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getBindServiceInfo() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			//data.put("userid", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/apps/service/info",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addBindService() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("service_names", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/service/binds/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delBindService() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("service_names", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/appctl/service/binds/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void getMemcacheInfo() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("service_names", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/services/system/memcache");
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addMemcache() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/memcache/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void setMemcache() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/memcache/set",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delMemcache() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
//			data.put("quota", "");
//			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/memcache/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getRedisInfo() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("service_names", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/services/system/redis");
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addRedis() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/redis/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void setRedis() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/redis/set",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delRedis() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
//			data.put("quota", "");
//			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/redis/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getDBInfo() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("service_names", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/services/system/db");
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addDB() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/db/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void setDB() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/db/set",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delDB() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
//			data.put("quota", "");
//			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/db/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getStorgeInfo() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("service_names", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/services/system/storage");
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void addStorge() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			//data.put("role", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/storage/add",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void setStorge() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("quota", "");
			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/storage/set",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	}
	@Test
	public void delStorge() {
		try {
			Map<String,String> data =new HashMap<String ,String>();
//			data.put("quota", "");
//			data.put("info", "");	
			data.put("instance_id", "");	
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/services_op/system/storage/delete",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("status").equals("1200")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
}
