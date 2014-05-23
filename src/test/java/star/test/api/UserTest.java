package star.test.api;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.test.methods.Params;

public class UserTest {
	public static final String DOMAIN = Params.DOMAIN;
	// public static final String DOMAIN="http://127.0.0.1/sce-openapi-server";
	// public static final String
	// ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//测试
	public static final String ACCESS_TOKEN = Params.ACCESS_TOKEN;// 线上
	public static final String userID="kevin1986";
	public static final String captcha="682376";
	public UserTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void prelogin() {// 获取某个appid的绑定服务实例信息
//		try {
//			Map<String, String> data = new HashMap<String, String>();
//			data.put("userid", "starlifht");
//			data.put("user_type", "1");
//			
//			String response = HttpClientUtil.doGet(DOMAIN + "/user/prelogin",
//					data);
//
//			if (!JSONObject.fromObject(response).getString("code")
//					.equals("1000")) {
//				fail(response);
//			}
//			System.out.print(response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Test
	public void userlogin() {// 获取某个appid的绑定服务实例信息
		try {

			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "18810606513");
			data.put("password", "asd123");
//			data.put("dp_password", "false");
//			data.put("user_type", "1");
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/login", data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void userIsExist() {// 用户是否存在
		try {
			String userid = "starlifht";

			String response = HttpClientUtil.doGet(Params.DOMAIN + "/user/"
					+ userid + "/is_exist");
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getUserInfo() {// 获取用户信息
		try {
			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/user?access_token=" + ACCESS_TOKEN);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void verifyBindOfUser() {// 验证用户名和手机或邮箱的绑定关系
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starlifht");
			data.put("mobile", "18810606513");
			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/user/verify", data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@Test
	public void modiftyUserInfo() {// 修改用户信息

		try {

			Map<String, String> data = new HashMap<String, String>();
		//	data.put("userid", "km_moon33");
			data.put("name", "测试的啊");
			data.put("qq", String.valueOf(new Random().nextInt(999999)));
		//	data.put("email", "107607195@qq.com");
			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user?access_token=" + ACCESS_TOKEN, data);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSSHkeys() {// 获取 SSH key

		try {

			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/user/sshkeys?access_token=" + ACCESS_TOKEN);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSSHkeysBytitle() {// 获取 某一SSH key

		try {
			
			String title ="test44";
			// data.put("key", "testusers");
			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/user/sshkeys/"+title+"?access_token=" + ACCESS_TOKEN);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void delSSHkeysBytitle() {// 删除 某一SSH key

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("title", "test44");

			// data.put("key", "testusers");
			String response = HttpClientUtil.doDelete(Params.DOMAIN
					+ "/user/sshkeys?access_token=" + ACCESS_TOKEN, data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("40003")) {
				fail(response);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addSSHkeys() {// 添加SSH key

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("title", "teswerers");
			data.put("keys", "testuserssdfsfdsfssfasdfdfsfdsfds");
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/sshkeys?access_token=" + ACCESS_TOKEN, data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void modiftyUserPwd() {// 修改用户密码

		try {
			String userid="";
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starwang1");
			data.put("password", "asd123");
			data.put("dest", "");
			data.put("captcha", "");
			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user/"+userid+"change_password?",
					data);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addUserToApp() {// 授权app给某用户

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starwang88");
			// 1.owner（表示该app转移了创建人） 2.admin 3.user
			data.put("role", "3");
			String response = HttpClientUtil.doPost(Params.DOMAIN + "/user/"
					+ Params.APPID + "?access_token=" + ACCESS_TOKEN, data);
			System.out.print(response);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("10658")) {
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void switchRole() {// 授权app给某用户

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "km_moon22");
			// 1.owner（表示该app转移了创建人） 2.admin 3.user
			data.put("role", "3");
			String response = HttpClientUtil.doPut(Params.DOMAIN + "/user/"
					+ Params.APPID + "?access_token=" + ACCESS_TOKEN, data);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAllUsersFromApp() {// 获取 某个app的全部用户

		try {

			String response = HttpClientUtil.doGet(Params.DOMAIN + "/user/"
					+ Params.APPID + "?access_token=" + ACCESS_TOKEN);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void delUserFromAPP() {// 删除授权用户

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "chongyang");
			// 1.owner（表示该app转移了创建人） 2.admin 3.user
			// data.put("role", "3");
			String response = HttpClientUtil.doDelete(Params.DOMAIN + "/user/"
					+ Params.APPID + "?access_token=" + ACCESS_TOKEN, data);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getReminderConfig() {// 获取用户安全提醒设置

		try {

			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/user/reminder_config?access_token=" + ACCESS_TOKEN);
			System.out.print(response);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getSecretkey() {// 获取用户安全提醒设置

		try {
			String password="asd123";
			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/user/secret_key?access_token=" + ACCESS_TOKEN+"&password="+password);
			System.out.print(response);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void creatSecretkey() {// 重新生成secretkey
		Map<String, String> data = new HashMap<String, String>();
		data.put("password", "asd123");
		try {
		
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/secret_key?access_token=" + ACCESS_TOKEN,data);
			System.out.print(response);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void setReminderConfig() {// 配置用户安全提醒设置

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("login_error", "testusers");
			// data.put("role", "3");
			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user/reminder_config?access_token=" + ACCESS_TOKEN,
					data);
			System.out.print(response);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void userRegister() {// 注册用户
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "10z0661");
			data.put("password", "asd");
			data.put("mobile", "13911720830");
		//	data.put("client-ip", "8.8.8.8");
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/register", data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void sendCaptcha() {// 发验证码101	注册	 
		/**102	登录	 
		103	绑定手机	 
		104	找回密码	 
		105	修改密码	 
		106	第一次设置动态口令	 
		107	关闭动态口令	 
		108	开启动态口令	 
		109	查看动态口令密钥	 
		110	删除app确认	 
		111	停止app确认	 	 	 	 
		201	绑定邮箱	 
		202	邮箱找回密码**/
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("type", "mobile"); //web|email|mobile
			data.put("dest", "17910606519");
			data.put("template", "101");
			String dest="18811606513";
			String template="101";
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/captcha/"+dest+"/"+template+"?access_token=" + ACCESS_TOKEN, data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void verifyCaptcha() {// 发验证码
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("type", "mobile"); //web|email|mobile
			data.put("dest", "18810606544");
			data.put("captcha", "620140");
			data.put("template", "102");
			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user/captcha?access_token=" + ACCESS_TOKEN, data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void userLoginConfirm() {// 动态口令二次验证接口，该方法只在用户绑定了动态口令时需要二次验证使用。
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starwang1");
			data.put("captcha", "445723");
			
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/login_confirm", data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void preDynamicpassword() {// 预创建动态口令。
		try {
			

			String response = HttpClientUtil.doPost(Params.DOMAIN
					+  "/user/"+userID+"/dynamic_password/"+captcha+"?access_token=" + ACCESS_TOKEN);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void creatDynamicpassword() {// 创建动态口令。
		try {
		
			String googleCaptcha="886646";
			String response = HttpClientUtil.doPut(Params.DOMAIN
					+  "/user/"+userID+"/dynamic_password/"+googleCaptcha+"?access_token=" + ACCESS_TOKEN);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("10662")) {
				fail(response);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void getDynamicpassword() {// 获取动态口令。
		try {
			

			String response = HttpClientUtil.doGet(Params.DOMAIN
					+  "/user/"+userID+"/dynamic_password/"+captcha+"?access_token=" + ACCESS_TOKEN);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void modifyDynamicpassword() {// 修改动态口令状态。
		try {
			String captcha="793328";
			String status="2";//0:设置成初始化状态；2.解绑
			String response = HttpClientUtil.doDelete(Params.DOMAIN
					+  "/user/"+userID+"/dynamic_password/"+captcha+"?access_token=" + ACCESS_TOKEN+"&status="+status);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("10661")) {
				fail(response);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void deleteDynamicpassword() {// 解绑动态口令。
		try {
			String userid="km_moon33";
			String mobileCaptcha="384332";
			String response = HttpClientUtil.doDelete(Params.DOMAIN
					+ "/user/"+userid+"/dynamic_password/"+mobileCaptcha+"?access_token=" + ACCESS_TOKEN);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
