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

public class AccountTest {

	public AccountTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void dePosit() {//充值
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

}
