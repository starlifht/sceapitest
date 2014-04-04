package star.test.openapi;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;

public class UserTest {
	public static final String  DOMAIN="http://openapi-test.apps.sohuno.com";
	//public static final String  DOMAIN="http://localhost/SCE_openAPI";
	//public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//测试
	public static final String  ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//线上
	public UserTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void prelogin() {//获取某个appid的绑定服务实例信息
		try {
			String response= HttpClientUtil
					.doGet(DOMAIN+"/user/prelogin?userid=188105559606513&user_type=2");
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	@Test
	public void userlogin() {//获取某个appid的绑定服务实例信息
		try {
			String userid="18810606513";
			String pwd="asd123";
					
			String response= HttpClientUtil
					.doGet(DOMAIN+"/user/login?userid="+userid+"&user_type=2&password="+pwd);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
