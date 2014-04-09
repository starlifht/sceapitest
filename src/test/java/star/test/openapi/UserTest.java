package star.test.openapi;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.test.methods.Params;

public class UserTest {
	//public static final String  DOMAIN="http://openapi-test.apps.sohuno.com";
	public static final String  DOMAIN="http://sohutest.apps.sohuno.com";
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
			Map<String,String> data =new HashMap<String ,String>();
			data.put("userid", "188105559606513");
			data.put("user_type", "2");
		
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/user/prelogin",data);
			
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
	@Test
	public void userIsExist() {//用户是否存在
		try {
			String userid="sdfsfdd";
			
					
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/user/is_exist?userid="+userid);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	@Test
	public void getUserInfo() {//获取用户信息

		try {
			String userid="sdfsfdd";
			
					
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/user?userid="+userid);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	@Test
	public void modiftyUserInfo() {//修改用户信息

		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("userid", "testusers");
			
					
			String response= HttpClientUtil
					.doPut(Params.DOMAIN+"/user",data);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	@Test
	public void modiftyUserPwd() {//修改用户密码

		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("userid", "18810606544");
			
			data.put("password", "testusers");		
			String response= HttpClientUtil
					.doPut(Params.DOMAIN+"/user/change_password",data);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	@Test
	public void userRegister() {//注册用户
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("userid", "testusers");
			data.put("password", "asd123");
			data.put("mobile", "18810608888");
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/user/register",data);
			
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

@Test
public void userLoginConfirm() {//动态口令二次验证接口，该方法只在用户绑定了动态口令时需要二次验证使用。
try {
	Map<String,String> data =new HashMap<String ,String>();
	data.put("userid", "testusers");
	data.put("secret_key", "asd1dsfs23sdf23");
	
	String response= HttpClientUtil
			.doPost(Params.DOMAIN+"/user/login_confirm",data);
	
	if(!JSONObject.fromObject(response).getString("code").equals("1000")){
		fail(response);
	}
	System.out.print(response);
} catch (Exception e) {
	e.printStackTrace();
}

}
}
