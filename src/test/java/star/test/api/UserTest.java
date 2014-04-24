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

public class UserTest {
	public static final String DOMAIN = Params.DOMAIN;
	// public static final String DOMAIN="http://127.0.0.1/sce-openapi-server";
	// public static final String
	// ACCESS_TOKEN="97043a103dfa54b2344b741300459a8e";//测试
	public static final String ACCESS_TOKEN = Params.ACCESS_TOKEN;// 线上

	public UserTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void prelogin() {// 获取某个appid的绑定服务实例信息
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starlifht");
			data.put("user_type", "1");
			
			String response = HttpClientUtil.doGet(DOMAIN + "/user/prelogin",
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
	public void userlogin() {// 获取某个appid的绑定服务实例信息
		try {

			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starlifht");
			data.put("password", "asd123");
			data.put("dp_password", "false");
			data.put("user_type", "1");
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/login", data);

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
	public void userIsExist() {// 用户是否存在
		try {
			String userid = "sdfsf33dd";

			String response = HttpClientUtil.doGet(Params.DOMAIN + "/user/"
					+ userid + "/is_exist");

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
	public void getDynamicPassword() {// 获取用户动态口令信息

		try {

			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starlifht");
			// data.put("mobile", "18810606513");
			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/user/dynamic_password?access_token=" + ACCESS_TOKEN,
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
	public void setDynamicPassword() {// 绑定、更新动态口令

		try {

			Map<String, String> data = new HashMap<String, String>();
			data.put("key", "dfg2354svf");
			data.put("qr_format", "18810606513");

			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user/dynamic_password?access_token=" + ACCESS_TOKEN,
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
	public void modiftyUserInfo() {// 修改用户信息

		try {

			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starlifht");
			data.put("name", "测试的啊");

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

			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/sshkeys?access_token=" + ACCESS_TOKEN);

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
	public void getSSHkeysBytitle() {// 获取 某一SSH key

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("title", "test");

			// data.put("key", "testusers");
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/sshkeys?access_token=" + ACCESS_TOKEN, data);

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
			data.put("title", "test");

			// data.put("key", "testusers");
			String response = HttpClientUtil.doDelete(Params.DOMAIN
					+ "/user/sshkeys?access_token=" + ACCESS_TOKEN, data);

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
	public void addSSHkeys() {// 添加SSH key

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("title", "testusers");

			data.put("key", "testuserssdfsfdsfssfasdfdfsfdsfds");
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/sshkeys?access_token=" + ACCESS_TOKEN, data);

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
	public void modiftyUserPwd() {// 修改用户密码

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starlifht");

			data.put("password", "testusers");
			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user/change_password?access_token=" + ACCESS_TOKEN,
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
			data.put("userid", "km_moon22");
			// 1.owner（表示该app转移了创建人） 2.admin 3.user
			data.put("role", "3");
			String response = HttpClientUtil.doPost(Params.DOMAIN + "/user/"
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
			data.put("userid", "km_moon232");
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
	public void setReminderConfig() {// 配置用户安全提醒设置

		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("login_error", "testusers");
			// data.put("role", "3");
			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user/reminder_config?access_token=" + ACCESS_TOKEN,
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
	public void userRegister() {// 注册用户
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "tde34stusers");
			data.put("password", "asd123");
			data.put("mobile", "18810608888");
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/register", data);

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
	public void sendCaptcha() {// 发验证码
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("type", "mobile"); //web|email|mobile
			data.put("dest", "18810606513");
			
			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/captcha?access_token=" + ACCESS_TOKEN, data);

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
	public void verifyCaptcha() {// 发验证码
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("type", "mobile"); //web|email|mobile
			data.put("dest", "18810606513");
			data.put("captcha", "029271");

			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/user/captcha?access_token=" + ACCESS_TOKEN, data);

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
	public void userLoginConfirm() {// 动态口令二次验证接口，该方法只在用户绑定了动态口令时需要二次验证使用。
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("userid", "starlifht");
			data.put("secret_key", "asd1dsfs23sdf23");

			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/user/login_confirm", data);

			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}
			System.out.print(response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
