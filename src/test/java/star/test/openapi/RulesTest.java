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

public class RulesTest {

	public RulesTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addRule() {// 创建规则
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("name", "star");
			data.put("rule", "tewr");
			data.put("context", "dfsd");
			// System.out.println(RandomStringUtils.random(6));
			String response = HttpClientUtil.doPost(Params.DOMAIN + "/rules/"
					+ Params.APPID + "?access_token=" + Params.ACCESS_TOKEN,
					data);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void delRule() {// 删除规则
		try {
			// Map<String,String> data =new HashMap<String ,String>();
			// data.put("name", "star");
			// data.put("rule", "tewr");
			// data.put("context", "dfsd");
			// System.out.println(RandomStringUtils.random(6));
			String response = HttpClientUtil.doDelete(Params.DOMAIN + "/rules/"
					+ Params.APPID + "/" + Params.RULE_ID);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAllRules() {// 获取app下 的所有规则定义
		try {
			// Map<String,String> data =new HashMap<String ,String>();
			// data.put("name", "star");
			// data.put("rule", "tewr");
			// data.put("context", "dfsd");
			// System.out.println(RandomStringUtils.random(6));
			String response = HttpClientUtil.doGet(Params.DOMAIN + "/rules/"
					+ Params.APPID);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void disableRule() {// 禁用规则
		try {

			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/rules/disable/" + Params.APPID + "/" + Params.RULE_ID);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void enableRule() {// 启用规则
		try {

			String response = HttpClientUtil.doPut(Params.DOMAIN
					+ "/rules/enable/" + Params.APPID + "/" + Params.RULE_ID);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateRule() {// 更新规则
		try {

			String response = HttpClientUtil.doPost(Params.DOMAIN
					+ "/rules/update/" + Params.APPID + "/" + Params.RULE_ID);
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getFactsOfRules() {// 更新规则
		try {

			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/rules/facts");
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getActionsOfRules() {// 更新规则
		try {

			String response = HttpClientUtil.doGet(Params.DOMAIN
					+ "/rules/actions");
			System.out.print(response);
			if (!JSONObject.fromObject(response).getString("code")
					.equals("1000")) {
				fail(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
