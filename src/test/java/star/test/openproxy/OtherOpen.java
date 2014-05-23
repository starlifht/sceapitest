package star.test.openproxy;

import static org.junit.Assert.fail;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;

import star.api.methods.Tools;

public class OtherOpen {
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
		String ser_instatnceid="";
		String ruleid="33";
		String orderid="CI140509926081";
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
		public void deposit() {
			String uri = "/cs/account/deposit";
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
		public void getDeposit() {
			try {
			String uri = "/cs/account/deposit";
			data.put("order_type",new String[] { "cash_in"});//system_in  cash_in  cash_out
			data.put("begin_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
			data.put("cur_page", new String[] {"1"});
			data.put("page_size", new String[] {"5"});
	

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
		public void getAccount() {
			try {
			String uri = "/cs/account";
//			data.put("order_type",new String[] { "cash_in"});//system_in  cash_in  cash_out
//			data.put("begin_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
//			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
//			data.put("cur_page", new String[] {"1"});
//			data.put("page_size", new String[] {"5"});
	

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
		public void checkOrder() {
			try {
			String uri = "/cs/account/"+orderid+"/check";
//			data.put("order_type",new String[] { "cash_in"});//system_in  cash_in  cash_out
//			data.put("begin_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
//			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
//			data.put("cur_page", new String[] {"1"});
//			data.put("page_size", new String[] {"5"});
	

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
		public void setReminder() {
			try {
			String uri = "/cs/account/reminder";
//			data.put("order_type",new String[] { "cash_in"});//system_in  cash_in  cash_out
//			data.put("begin_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
//			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
		data.put("min_quota", new String[] {"88"});
			data.put("status", new String[] {"open"});
	

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
		public void addReceipt() {
			try {
			String uri = "/cs/receipt";
//			data.put("order_type",new String[] { "cash_in"});//system_in  cash_in  cash_out
//			data.put("begin_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
//			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")});
		data.put("min_quota", new String[] {"88"});
			data.put("status", new String[] {"open"});
	

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
		//========================================LOG===================================================================
		@Test
		public void getApplog() {
			try {String uri = "/cs/logs/apps/"+appid;
			data.put("appid", new String[] { appid});
			data.put("begin_time", new String[] { URLEncoder.encode("2014-04-23 19:55:02","utf-8") });
			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")  });
			data.put("key_words", new String[] { "test" });
			data.put("cur_page", new String[] {"2"  });
			data.put("page_size", new String[] {  "33"});
			data.put("log_type", new String[] {  "app"});
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
			}
		}
		@Test
		public void getSystemlog() {
			try {String uri = "/cs/logs/system";
			//data.put("appid", new String[] { appid});
			data.put("begin_time", new String[] { URLEncoder.encode("2014-04-23 19:55:02","utf-8") });
			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")  });
			data.put("key_words", new String[] { "test" });
			data.put("cur_page", new String[] {"2"  });
			data.put("page_size", new String[] {  "33"});
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
	//===================================storage=============================================================	
		@Test
		public void getStorage() {
			try {String uri = "/cs/storage";
		
			data.put("object_name", new String[] {  "33"});
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
		public void checkStorage() {
			try {String uri = "/cs/storage/check";
		
			data.put("object_name", new String[] {  "33"});
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
//=================================Rule========================================================
		@Test
		public void addRule() {
			try {String uri = "/cs/rules/"+appid;
		
			data.put("name", new String[] {  "33"});
			data.put("rule", new String[] {  "33"});
			data.put("context", new String[] {  "33"});
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
		public void getRules() {
			try {String uri = "/cs/rules/"+appid;
		
//			data.put("name", new String[] {  "33"});
//			data.put("rule", new String[] {  "33"});
//			data.put("context", new String[] {  "33"});
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
			}
		}
		@Test
		public void enableRules() {
			try {String uri = "/cs/rules/enable/"+appid+"/"+ruleid;
		
//			data.put("name", new String[] {  "33"});
//			data.put("rule", new String[] {  "33"});
//			data.put("context", new String[] {  "33"});
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
			}
		}	
		@Test
		public void disableRules() {
			try {String uri = "/cs/rules/disable/"+appid+"/"+ruleid;
		
//			data.put("name", new String[] {  "33"});
//			data.put("rule", new String[] {  "33"});
//			data.put("context", new String[] {  "33"});
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
			}
		}
		@Test
		public void updateRules() {
			try {String uri = "/cs/rules/update/"+appid+"/"+ruleid;
		
//			data.put("name", new String[] {  "33"});
			data.put("rule", new String[] {  "33"});
			data.put("context", new String[] {  "33"});
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
		public void getFacts() {
			try {String uri = "/cs/rules/facts";
		
//			data.put("name", new String[] {  "33"});
			data.put("rule", new String[] {  "33"});
			data.put("context", new String[] {  "33"});
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
			}
		}
		@Test
		public void getActions() {
			try {String uri = "/cs/rules/actions";
		
//			data.put("name", new String[] {  "33"});
			data.put("rule", new String[] {  "33"});
			data.put("context", new String[] {  "33"});
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
			}
		}
		@Test
		public void deleteRule() {
			try {String uri = "/cs/rules/"+appid+"/"+ruleid;
		
			data.put("name", new String[] {  "33"});
			data.put("rule", new String[] {  "33"});
			data.put("context", new String[] {  "33"});
				String sigature = SignatureUtils.signatureForSce(data, secret, "DELETE", uri, signatureMethod);
				data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

				System.out.println(data);
				String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
				System.out.println("=========================");
				System.out.println(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		/////////////////////==================================monitor
		@Test
		public void getMonitor() {
			try {String uri = "/cs/monitor/"+appid;
		
//			data.put("name", new String[] {  "33"});
			data.put("time_range", new String[] {  "hour"});
			data.put("http_type", new String[] {  "all"});
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
			}
		}
		//====================Bills=====================================
		@Test
		public void getBills() {
			try {String uri = "/cs/bills/price";
		
//			data.put("name", new String[] {  "33"});
			data.put("resource_type", new String[] {  "all"});
			//data.put("http_type", new String[] {  "all"});
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
			}
		}
		@Test
		public void getBills_amount() {
			try {String uri = "/cs/bills/resources/amount";
		
//			data.put("name", new String[] {  "33"});
			data.put("resource_type", new String[] {  "all"});
			data.put("begin_time", new String[] { URLEncoder.encode("2014-04-23 19:55:02","utf-8") });
			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")  });
			//data.put("http_type", new String[] {  "all"});
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
			}
		}
		@Test
		public void getBills_resources() {
			try {String uri = "/cs/bills/resources";
		
//			data.put("name", new String[] {  "33"});
			data.put("resource_type", new String[] {  "app"});
			data.put("begin_time", new String[] { URLEncoder.encode("2014-04-23 19:55:02","utf-8") });
			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")  });
			//data.put("http_type", new String[] {  "all"});
			data.put("cur_page", new String[] {"2"  });
			data.put("page_size", new String[] {  "33"});
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
			}
		}
		@Test
		public void getBills_detal() {
			try {String uri = "/cs/bills/resources/details";
		
//			data.put("name", new String[] {  "33"});
			data.put("resource_type", new String[] {  "app"});
			data.put("begin_time", new String[] { URLEncoder.encode("2014-04-23 19:55:02","utf-8") });
			data.put("end_time", new String[] {URLEncoder.encode("2014-04-23 19:55:02","utf-8")  });
			data.put("instance_id", new String[] {  instanceid});
			data.put("cur_page", new String[] {"2"  });
			data.put("page_size", new String[] {  "33"});
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
			}
		}
		@Test
		public void checkInvation() {
			try {String uri = "/cs/invitation/check";
		
//			data.put("name", new String[] {  "33"});
		
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
}
