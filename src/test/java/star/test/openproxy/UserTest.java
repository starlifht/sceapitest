package star.test.openproxy;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	String domain =SceOpenApiConstant.domain;
//String domain ="http://10.121.41.106:8080";
	String signatureMethod = SceOpenApiConstant.signatureMethod;
	String charset = SceOpenApiConstant.charset;
	String appid = SceOpenApiConstant.appid;
	String instanceid=SceOpenApiConstant.instanceid;
	//String accessKey = "1qaz";
	String accessKey = SceOpenApiConstant.accessKey;//a9c661486f1e7ef2fd245021b72050ec
	//String secret = "2wsx";
	String secret = SceOpenApiConstant.secret;
	Map<String, String[]> data = new HashMap<String, String[]>();
	@Before
	public void setUp() {
		data.put(SceOpenApiConstant.ACCESS_KEY, new String[] { accessKey });
		long timestamp = System.currentTimeMillis();
		data.put(SceOpenApiConstant.TIMESTAMP, new String[] { String.valueOf(timestamp) });
		data.put(SceOpenApiConstant.SIGNATURE_METHOD, new String[] { signatureMethod });
		data.put(SceOpenApiConstant.SIGNATURE_VERSION, new String[] { "1.0" });
		data.put(SceOpenApiConstant.VERSION, new String[] { "1.0" });
	}
	@Test
	public void preLogin() {
		//String userid = "starlifht";
		String uri = "/cs/user/prelogin";
		data.put("userid", new String[] { "starwang" });
		data.put("user_type", new String[] { "1" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void userLogin() {
		//String userid = "starlifht";
		String uri = "/cs/user/login";
		data.put("userid", new String[] { "starwang" });
		data.put("user_type", new String[] { "1" });
		data.put("password", new String[] { "1" });
		//data.put("password", new String[] { "1" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void userLogin_confirm() {
		//String userid = "starlifht";
		String uri = "/cs/user/login_confirm";
		data.put("userid", new String[] { "starwang" });
		data.put("user_type", new String[] { "1" });
		data.put("secret_key", new String[] { "1" });
		//data.put("password", new String[] { "1" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void userRegister() {
		//String userid = "starlifht";
		String uri = "/cs/user/register ";
		data.put("userid", new String[] { "starwang" });
		data.put("password", new String[] { "asd123" });
		data.put("mobile", new String[] { "19810606513" });
		data.put("captcha", new String[] { "154634" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void changePasswd() {
		//String userid = "starlifht";
		String uri = "/cs/user/register ";
		data.put("userid", new String[] { "starwang" });
		data.put("password", new String[] { "asd123" });
		data.put("dest", new String[] { "mobile" });
		data.put("captcha", new String[] { "154634" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPut(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getUserInfo() {
		//String userid = "starlifht";
		String uri = "/cs/user";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });

		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void modiftyUserPwd() {
		String uri = "/cs/user/change_password";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		data.put("password", new String[] {"asd123"});
		//data.put("qq", new String[] {"8888888"});
//		data.put("dp_password",new String[] { "false"});
//		data.put("user_type", new String[] {"1"});
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			System.out.println(data);
			String response = HTTPUtils.doPut(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void modiftyUserInfo() {
		String uri = "/cs/user";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		data.put("name", new String[] {"测试吧"});
		data.put("qq", new String[] {"8888888"});
//		data.put("dp_password",new String[] { "false"});
//		data.put("user_type", new String[] {"1"});
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPut(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
