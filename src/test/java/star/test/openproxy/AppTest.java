package star.test.openproxy;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.api.methods.Tools;
import star.test.methods.Params;

public class AppTest {
	/*********
	 * API  proxy
	 */
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
			public void creatApp() {
				String uri = "/cs/apps";
				data.put("name", new String[] { Tools.getRandomString(7) });
				data.put("description", new String[] { "radomdfsdcreat" });
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
			public void getAppDetail() {//获取app的详细信息
				try {
					String uri = "/cs/apps/"+appid;
					String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
					data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
					String response=  HTTPUtils.doGet(domain + uri, data, charset, null);
					System.out.print(response);
					if(!JSONObject.fromObject(response).getString("code").equals("1000")){
						fail(response);
					}
					
				} catch (Exception e) {fail(e.toString());
					e.printStackTrace();
				}
		}
			@Test
			public void getDomains() {

				String uri = "/cs/apps/" + appid + "/domains";
				try {
					String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
					data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

					String response = HTTPUtils.doGet(domain + uri, data, charset, null);
					System.out.println("=========================");
					System.out.println(response);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			@Test
			public void addDomain() {

				String uri = "/cs/apps/" + appid + "/domains";

				data.put("domain", new String[] { "hly1.csapps.sohuno.com" });
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
	public void getAppList() {
		String uri = "/cs/apps";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void modifyAppInfo() {
		String uri = "/cs/apps/"+appid;
		data.put("name", new String[] { Tools.getRandomString(7)});
		//for(int i = 0;i<=1;i++){
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
		}//}
	}
	@Test
	public void getDumstack() {
		String uri = "/cs/apps/"+appid+"/dumpstack";
		data.put("name", new String[] { Tools.getRandomString(7)});
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void uploadFile() {
		String uri = "/cs/apps/"+appid+"/1";
		data.put("name", new String[] { Tools.getRandomString(7)});
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11500")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void getFile() {
		String uri = "/cs/apps/"+appid+"/1";
		data.put("name", new String[] { Tools.getRandomString(7)});
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11500")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void checkFile() {
		String uri = "/cs/apps/"+appid+"/1/check";
		//data.put("appid", new String[] { Tools.getRandomString(7)});
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void deleteFile() {
		String uri = "/cs/apps/"+appid+"/1";
		//data.put("appid", new String[] { Tools.getRandomString(7)});
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void deleteApp() {
		String uri = "/cs/apps/"+appid;
		data.put("name", new String[] { Tools.getRandomString(7)});
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11465")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void getSecurity() {
		String uri = "/cs/apps/"+appid+"/security";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void addSecurity() {
		String uri = "/cs/apps/"+appid+"/security";
		data.put("rate", new String[] { "9898" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void delSecurity_rate() {
		String uri = "/cs/apps/"+appid+"/security/rate";
		//data.put("rate", new String[] { "9898" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "DELETTE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void getVersions() {
		String uri = "/cs/apps/"+appid+"/versions";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void addVersion() {
		String uri = "/cs/apps/"+appid+"/versions";
		data.put("dscription", new String[] { "sdfstest" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void modifyVersionInfo() {
		String uri = "/cs/apps/"+appid+"/versions/1";
		data.put("description", new String[] { "sdfffstest" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPut(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void setVersion() {
		String uri = "/cs/apps/"+appid+"/versions/1";
		data.put("version", new String[] { "1" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void getABtest() {
		String uri = "/cs/apps/"+appid+"/versions/abtest";
		data.put("version", new String[] { "1" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void setABtest() {
		String uri = "/cs/apps/"+appid+"/versions/abtest";
		data.put("version", new String[] { "1" });
		data.put("is_abtest", new String[] { "false" });
		//for(int i = 0;i<=1;i++){
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//}
	}
	@Test
	public void restartApp() {

		String uri = "/cs/apps/" + appid + "/restart";

	
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void stopApp() {

		String uri = "/cs/apps/" + appid + "/stop";

	
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getConfig() {
		String uri = "/cs/apps/" + appid + "/config";
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAppInstances() {
		String uri = "/cs/apps/"+appid+"/instances";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void restartInstances() {
		String uri = "/cs/instances/"+instanceid+"/restart";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void stopInstances() {
		String uri = "/cs/instances/"+instanceid+"/stop";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void deleteInstances() {
		String uri = "/cs/instances/"+"aad95d24-df35-11e3-931d-00163e2e835c";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getSSH() {
		String uri = "/cs/instances/"+instanceid+"/ssh";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void openSSH() {
		String uri = "/cs/instances/"+instanceid+"/ssh/open";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPut(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void closeSSH() {
		String uri = "/cs/instances/"+instanceid+"/ssh/close";
		//data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signatureForSce(data, secret, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPut(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
			if(!JSONObject.fromObject(response).getString("code").equals("11464")){
				fail(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void cleanDomain() {
		String uri = "/cs/apps/" + appid + "/domains/clean";
		data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
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
	public void deleteDomain() {
		String uri = "/cs/apps/" + appid + "/domains";
		data.put("domain", new String[] { "hly1.csapps.sohuno.com" });
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
	public void deleteAPP() {
		String uri = "/cs/apps/296490937";
		data.put("name", new String[] { "aTwuvQh" });
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
}
