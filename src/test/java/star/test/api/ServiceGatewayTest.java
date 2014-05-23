package star.test.api;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.test.methods.Params;

public class ServiceGatewayTest {
	public static final String  DOMAIN=Params.DOMAIN; //  sohutest.apps.sohuno.com
	//public static final String  DOMAIN="http://sohutest.apps.sohuno.com";
	//public static final String  DOMAIN="http://openapi-test.apps.sohuno.com";
	public static final String  ACCESS_TOKEN=Params.ACCESS_TOKEN;//测试
	//public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//线上
	public static final String APPID=Params.APPID;
		private static final String SERV_INSTANCEID="93f18885-67fe-4a57-92c5-5b9d5d676693";
	public ServiceGatewayTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getServInstancesBystatus() {//查询某个（所有）状态的服务实例 pendding | running | stopped | deleted
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/services/instances?access_token="+ACCESS_TOKEN+"&status=running");
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getServInstancesById() {//查询某个id的服务实例
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/services/instances/"+SERV_INSTANCEID+"?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getTokenOfInstance() {//查询某个服务实例的认证token－目前仅限于mysql
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/services/instances/"+SERV_INSTANCEID+"/token?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getTokenOfMySQL() {//查询某个服务实例的认证token－目前仅限于mysql
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/db/service_instance/1cf52b89-00b9-483e-af5c-8718029b90db/token?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getServProviders() {//获取所有service providers
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/services?access_token="+ACCESS_TOKEN);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getServProviderByID() {//获取所有service providers
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/services/1?access_token="+ACCESS_TOKEN);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void getBindInstancesByAppid() {//获取某个appid的绑定服务实例信息
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/services/instances/binds/"+APPID+"?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	
	@Test
	public void getBindOfAppidAndInstance() {//获取某个appid与某个服务实例的绑定信息
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/services/instances/binds/"+APPID+"/"+SERV_INSTANCEID+"?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void addBindOfAppidAndInstance() {//添加某个appid与某个服务实例的绑定信息
		try {
			String response= HttpClientUtil
					.doPost(DOMAIN+"/services/instances/binds/"+APPID+"/"+SERV_INSTANCEID+"?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	
	@Test
	public void delBindOfAppidAndInstance() {//获取某个appid与某个服务实例的绑定信息
		try {
			String response= HttpClientUtil
					.doDelete(DOMAIN+"/services/instances/binds/"+APPID+"/"+SERV_INSTANCEID+"?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void addServInstance() {//增加服务实例
		try {
			
			//System.out.println(RandomStringUtils.random(6));
			String response= HttpClientUtil.doPut(DOMAIN+"/services/instances?access_token="+ACCESS_TOKEN+"&service_id=4");
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public void addServProvider() {//发布系统服务provider
		try {
			Map<String,String> data =new HashMap<String ,String>();
			//data.put("access_token", ACCESS_TOKEN);
			data.put("name","testm");
			data.put("type","mysql-dba");
			data.put("owner","starlifht");
			data.put("endpoint","/db/service_instance/nodes");		
			data.put("description","justtest");
			//System.out.println(RandomStringUtils.random(6));
			String response= HttpClientUtil.doPut(DOMAIN+"/services?access_token="+ACCESS_TOKEN,data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public void deleteServInstance() {//删除服务实例
		try {
//			Map<String,String> data =new HashMap<String ,String>();
//			data.put("service_id","1");
			//System.out.println(RandomStringUtils.random(6));
			String response= HttpClientUtil.doDelete(DOMAIN+"/services/instances/c1b2c5f5-aab2-451e-96f6-f8f169ba78b7?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public void deleteServProvider() {//删除服务实例
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("service_id","1");
			//System.out.println(RandomStringUtils.random(6));
			String response= HttpClientUtil.doDelete(DOMAIN+"/services/"+"1567"+"?access_token="+ACCESS_TOKEN,data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("10404")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public void deleteBindOfAppidAndInstance() {//删除某个appid与某个服务实例的绑定信息
		try {
//			Map<String,String> data =new HashMap<String ,String>();
//			data.put("service_id","1");
			//System.out.println(RandomStringUtils.random(6));
			String response= HttpClientUtil.doDelete(DOMAIN+"/services/instances/binds/"+APPID+"/"+SERV_INSTANCEID+"?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("10404")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
