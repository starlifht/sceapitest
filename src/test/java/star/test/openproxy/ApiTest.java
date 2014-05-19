package star.test.openproxy;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import star.api.methods.Tools;



public class ApiTest {
	 String domain = "http://api.sce.sohu.com";
//String domain ="http://10.121.41.106:8080";
		String signatureMethod = "HmacSHA1";
		String charset = "UTF-8";
		String appid = "146954184";
		String instanceid="fe426ebc-dcb2-4318-8d62-d7e17b5f6ec7";
		//String accessKey = "1qaz";
		String accessKey = "91068dd79f2f99f84d956fe11a17ee1a";//a9c661486f1e7ef2fd245021b72050ec
		//String secret = "2wsx";
		String secret = "e3b5187e5739f9c7e371efdf2f5a8395";
		Map<String, String[]> data = new HashMap<String, String[]>();
	@Test
	public void testAuth() {
		String client_id = "d142ec65623a4a0081c9560cb522f1e6";
		String redirect_uri = "http://www.test.com";
		String response_type = "code";
		String url = "https://api.sohu.com/oauth2/authorize?client_id=" + client_id + "&redirect_uri=" + redirect_uri
				+ "&response_type=" + response_type;

		try {
			String result = HTTPUtils.doGet(url);
			System.out.println(url);
			System.out.println(result);

		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void test() {
		try {
			URLEncoder.encode("", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	

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
	public void getServInstancesBystatus() {
		String uri = "/cs/services/instances";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void addBindOfAppidAndInstance() {
		String uri = "/cs/services/instances/binds/"+appid+"/"+instanceid;
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void delBindOfAppidAndInstance() {
		String uri = "/cs/services/instances/binds/"+appid+"/"+instanceid;
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void userlogin() {
		String uri = "/cs/user/login";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		data.put("userid", new String[] {"starwang1"});
		data.put("password", new String[] {"asd123"});
		data.put("dp_password",new String[] { "false"});
		data.put("user_type", new String[] {"1"});
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void userRegister() {
		String uri = "/cs/user/register";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		data.put("userid", new String[] {"starwang11"});
		data.put("password", new String[] {"asd123"});
		data.put("mobile",new String[] { "false"});
		//data.put("user_type", new String[] {"1"});
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@Test
	public void userIsExist() {
		String userid = "starlifht";
		String uri = "/cs/user/"+ userid + "/is_exist";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });

		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSystemLogs() throws UnsupportedEncodingException {
		//String userid = "starlifht";
		String uri = "/cs/logs/system";
		data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		data.put("key_words",  new String[] {"test"});
		data.put("cur_page",  new String[] {"2"});
		data.put("page_size",  new String[] {"33"});
		data.put("order_type",  new String[] {"asc"});//asc | desc   default desc 
		data.put("begin_time", new String[] { URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
		data.put("end_time", new String[] { URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void dePositToUser() {
		String uri = "/cs/account/deposit";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
//		data.put("name", new String[] {"测试吧"});
//		data.put("qq", new String[] {"8888888"});
		data.put("userid", new String[] {"starwang1"});
		data.put("orderid", new String[] {String.valueOf(System.currentTimeMillis())});
		data.put("order_type", new String[] {"cash_in"});//system_in  cash_in  cash_out
		data.put("money", new String[] {"7999"});
		data.put("order_user", new String[] {"1881060513"});
		data.put("bank", new String[] {"8888"});
		data.put("status", new String[] {"success"});
//		data.put("dp_password",new String[] { "false"});
//		data.put("user_type", new String[] {"1"});
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void asddUserToApp() {
		String uri = "/cs/user/"+appid;
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		data.put("userid", new String[] {"starwang"});
		data.put("role", new String[] {"3"});
//		data.put("dp_password",new String[] { "false"});
//		data.put("user_type", new String[] {"1"});
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void setConfig() {

		String uri = "/cs/apps/" + appid + "/config";

		data.put("is_schedule", new String[] { "true" });
		data.put("min_ins", new String[] { "3" });
		data.put("max_ins", new String[] { "3" });
		data.put("is_session", new String[] { "true" });
		data.put("container_type", new String[] { "C3" });
		data.put("requests", new String[] { "7000" });
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

	// https://api.sohu.com/oauth2/authorize?client_id=d142ec65623a4a0081c9560cb522f1e6&redirect_uri=http://www.test.com&response_type=code
	// http://www.test.com/?code=4d0fc88f9a32cfaa222d4c9f89911587

	// https://api.sohu.com/oauth2/token?client_id=d142ec65623a4a0081c9560cb522f1e6&code=4d0fc88f9a32cfaa222d4c9f89911587&client_secret=9d6662a7f8d8ca600d456fbfdfdf721d&redirect_uri=http://www.test.com&grant_type=authorization_code
	// {"access_token":"1.1f6aa2cc3886470s-465672bc1f2b497b61747ad17bde94d3.2592000000.1397376780005|1398","expires_in":"2592000","refresh_token":"2.1f6aa2cc3886470s-f60a30b365df5ad8e905f5702d8649e1|1398","uuid":"1f6aa2cc3886470s","open_id":"1f6aa2cc3886470s"}

}
