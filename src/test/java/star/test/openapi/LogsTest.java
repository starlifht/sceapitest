package star.test.openapi;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import star.api.methods.HttpClientUtil;
import star.test.methods.Params;

public class LogsTest extends TestCase{
	 public LogsTest (String name){
		  super(name);
		 }//注意这里添加了这个构造函数，因为要调用父类的构造函数，用于下面Suite添加该类的测试方法
	public LogsTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getLogs() {//充值
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
					.doGet(Params.DOMAIN+"/logs/apps/"+Params.APPID+"?appid=93695&log_type=audit&begin_time=2014-01-13 08:22:45&end_time=2014-01-13 08:22:45&key_words=sdf&cur_page=1&page_size=8");
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
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
	 @Test
		public void testlll(){
			junit.textui.TestRunner.run(AllTests.suite());
		}
}
