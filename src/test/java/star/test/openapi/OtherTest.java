package star.test.openapi;



import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.test.methods.Params;

public class OtherTest extends TestCase{
	 public OtherTest (String name){
		  super(name);
		 }//注意这里添加了这个构造函数，因为要调用父类的构造函数，用于下面Suite添加该类的测试方法
	public OtherTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
//===================================LOG=======================================
	@Test
	public void getAppLogs() {//充值
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("appid", Params.APPID);
			data.put("begin_time", "2014-01-13 08:22:45");
			data.put("end_time	", "2014-01-13 08:22:45");
			data.put("key_words", "test");
			data.put("cur_page", "2");
			data.put("page_size", "33");
			data.put("log_type", "app");//audit|app|access
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/logs/apps/"+Params.APPID);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public void getSystemLogs() {//充值
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("key_words", "test");
			data.put("cur_page", "2");
			data.put("page_size", "33");
			data.put("order_type ", "asc");//asc | desc   default desc 
			data.put("begin_time", "2014-01-13 08:22:45");
			data.put("end_time	", "2014-01-13 08:22:45");
			String response= HttpClientUtil
					.doGet(Params.DOMAIN+"/logs/system",data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	//===================================Storge=============================================
	@Test
	public void Storage() {//修改APP信息
		try {
		String filePath=HttpClientUtil.class.getResource("/1.png").getPath();
			String response= HttpClientUtil.doPostFile(Params.DOMAIN+"/storage??access_token="+Params.ACCESS_TOKEN,filePath);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	//================================monitor========================================================
	 @Test
		public void getMonitorInfo(){
		 try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("time_range", "houor");//hour|day|week
				data.put("http_type	", "http");//http|https|all
				
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/monitor/"+Params.APPID,data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 //=======================================Bills=========================================================
	 @Test
		public void geAllPrice(){
		 try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("resource_type", "all");//memcache|redis|s3|mysql|app|all
							
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/bills/price");
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 @Test
		public void getAmountOfResource(){//获取一种或多种资源在一段时间内的总金额
		 try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("resource_type", "all");//memcache|redis|s3|mysql|app|all
				data.put("begin_time", "2014-01-13 08:22:45");
				data.put("end_time	", "2014-01-13 08:22:45");
				//data.put("appid", "all");
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/bills/resources/amount",data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 @Test
		public void getBillOfResource(){//获取一种或多种资源在一段时间内的消费账单，分页
		 try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("resource_type", "all");//memcache|redis|s3|mysql|app|all
				data.put("begin_time", "2014-01-13 08:22:45");
				data.put("end_time", "2014-01-13 08:22:45");
				data.put("cur_page", "2");
				data.put("page_size", "5");
				//data.put("appid", "all");
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/bills/resources",data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 @Test
		public void getDetailBillOfResource(){//获取一种或多种资源在一段时间内的消费账单，分页
		 try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("resource_type", "all");//memcache|redis|s3|mysql|app|all
				data.put("begin_time", "2014-01-13 08:22:45");
				data.put("end_time", "2014-01-13 08:22:45");
				data.put("cur_page", "2");
				data.put("page_size", "5");
				data.put("instance_id", Params.INSTANCEID);
				String response= HttpClientUtil
						.doGet(Params.DOMAIN+"/bills/resources/details",data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 //==========================================Account================================
	 @Test
		public void dePositToUser() {//充值
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("userid", "18810606513");
				data.put("orderid", "18810606513");
				data.put("order_type", "system_in");//system_in  cash_in  cash_out
				data.put("money", "188");
				data.put("order_user", "1881060513");
				data.put("bank", "1881");
				data.put("status", "success");
				//System.out.println(RandomStringUtils.random(6));
				String response= HttpClientUtil
						.doPost(Params.DOMAIN+"/account/deposit",data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	 @Test
		public void getDePositInfo() {//充值
			try {
				Map<String,String> data =new HashMap<String ,String>();
				data.put("userid", "18810606513");
			
				data.put("order_type", "system_in");//system_in  cash_in  cash_out
				data.put("begin_time", "2014-01-13 08:22:45");
				data.put("end_time", "2014-01-13 08:22:45");
				data.put("cur_page", "2");
				data.put("page_size", "5");
				String response= HttpClientUtil
						.doPost(Params.DOMAIN+"/account/deposit",data);
				System.out.print(response);
				if(!JSONObject.fromObject(response).getString("code").equals("1000")){
					fail(response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
