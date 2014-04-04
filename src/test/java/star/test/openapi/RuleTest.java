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

public class RuleTest {

	public RuleTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addAppVersion() {//增加APP的版本
		try {
			Map<String,String> data =new HashMap<String ,String>();
			data.put("name", "star");
			data.put("rule", "tewr");
			data.put("context", "dfsd");
			//System.out.println(RandomStringUtils.random(6));
			String response= HttpClientUtil
					.doPost(Params.DOMAIN+"/rules/"+Params.APPID+"?access_token="+Params.ACCESS_TOKEN,data);
			System.out.print(response);
			if(!JSONObject.fromObject(response).getString("code").equals("1000")){
				fail(response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}

}
