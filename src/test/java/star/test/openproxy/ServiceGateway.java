package star.test.openproxy;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;

import star.api.methods.Tools;

public class ServiceGateway {
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
		String ser_instatnceid="93f18885-67fe-4a57-92c5-5b9d5d676693";
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
		public void getInstances() {
			
			String uri = "/cs/services/instances";
			data.put("status", new String[] { "running"});
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
		public void getTokenOfMySQL() {
			
			String uri = "/cs/services/instances";
			data.put("status", new String[] { "running"});
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
		public void getServices() {
			
			String uri = "/cs/services";
			//data.put("status", new String[] { "running"});
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
		public void getServicesByID() {
			
			String uri = "/cs/services/1";
			//data.put("status", new String[] { "running"});
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
		public void addServices() {
			
			String uri = "/cs/services";
			data.put("status", new String[] { "running"});
			//for(int i = 0;i<=1;i++){
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
			}//}
		}
		@Test
		public void deleteServices() {
			
			String uri = "/cs/services/1";
			data.put("status", new String[] { "running"});
			//for(int i = 0;i<=1;i++){
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
			}//}
		}
		@Test
		public void getInstancesByID() {
			String uri = "/cs/services/instances/"+ser_instatnceid;
			//data.put("status", new String[] { "pending"});
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
		public void addInstances() {
			String uri = "/cs/services/instances";
			data.put("service_id", new String[] { "1"});
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
			}
		}
		@Test
		public void getToken() {
			String uri = "/cs/services/instances/"+ser_instatnceid+"/token";
			//data.put("service_id", new String[] { "1"});
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
			}
		}
		@Test
		public void getBindsByAppid() {
			String uri = "/cs/services/instances/binds/"+appid;
			//data.put("service_id", new String[] { "1"});
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
			}
		}
		@Test
		public void addBinds() {
			String uri = "/cs/services/instances/binds/"+appid+"/"+ ser_instatnceid;
			//data.put("service_id", new String[] { "1"});
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
			}
		}
		@Test
		public void getBinds() {
			String uri = "/cs/services/instances/binds/"+appid+"/"+ ser_instatnceid;
			//data.put("service_id", new String[] { "1"});
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
			}
		}
		@Test
		public void deleteBinds() {
			String uri = "/cs/services/instances/binds/"+appid+"/"+ ser_instatnceid;
			//data.put("service_id", new String[] { "1"});
			//for(int i = 0;i<=1;i++){
			try {

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
		@Test
		public void deleteInstances() {
			String uri = "/cs/services/instances/"+ser_instatnceid;
			//data.put("service_id", new String[] { "1"});
			//for(int i = 0;i<=1;i++){
			try {

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
}
