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

public class some {
	public static final String  DOMAIN=Params.DOMAIN;
	//public static final String  DOMAIN="http://localhost";
	//public static final String  DOMAIN="http://openapi-test.apps.sohuno.com";
	public static final String  ACCESS_TOKEN="fe21549eb2659916f8a3f3cd72aa2781";//测试
	//public static final String  ACCESS_TOKEN="bb4028f1240acd48938ce8967a77c134";//线上
	public static final String APPID="10207";
	public static final String RULE_ID="93695";
	public static final String INSTANCEID="9a8a90cd-caaf-11e3-8b55-00163e482fd9";//93677
	public some() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void stopApp() {//停止app
		try {
//			Map<String,String> data =new HashMap<String ,String>();
//			data.put("description", "测试版本dfsd");
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
	public void deleteApp() {//删除app
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("name", "zoD4pXs");
		System.out.println(Tools.getRandomString(7));
			String response= HttpClientUtil
					.doDelete(DOMAIN+"/apps/10241"+"?access_token="+ACCESS_TOKEN,data);
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
					.doDelete(DOMAIN+"/instances/"+INSTANCEID+"?access_token="+ACCESS_TOKEN);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}

}
