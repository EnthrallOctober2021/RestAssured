package com.reqres.test.apis;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.reqres.qa.apis.UpdateAPI;
import com.reqres.qa.utils.CreateJson;
import com.reqres.qa.utils.JsonPathClass;
import com.reqres.qa.utils.ReadConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateApiTest {

	CreateJson createJson;
	JsonPathClass jPath;
	UpdateAPI updateAPI;

	@BeforeMethod
	public void initClasses() {
		updateAPI = new UpdateAPI();
		createJson = new CreateJson();
	}

	// @Test
	public void testUpdateApiVoid() {
		// updateAPI.putUpdateCall(ReadConfig.getInstance().getJsonFilePath());
		String responseString = updateAPI.putUpdateCall(ReadConfig.getInstance().getJsonFilePath());
		// String responseString = updateAPI.responseString;
		System.out.println(responseString);

		jPath = new JsonPathClass(responseString);
		System.out.println(jPath.getJsonPath().get("updatedAt"));
		String jobString = jPath.getJsonPath().get("job");
		System.out.println(jobString);
		Assert.assertEquals("sdet", jobString);
		System.out.println(jobString);
	}

	// @Test
	public void testUpdateApiMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "myname");
		map.put("job", "qa");

		String response = RestAssured.given().baseUri(ReadConfig.getInstance().getBaseUri()).body(map).log().all()
				.contentType(ContentType.JSON).when().put(ReadConfig.getInstance().getUpdateApi()).asPrettyString();

		System.out.println(response);
	}

	// @Test
	public void testUpdateApiwithMapMethod() {
		String responString = updateAPI.returnPutUpdateCall(createJson.jsonMap("Anik", "QA"));
		System.out.println(responString);
		responString = updateAPI.returnPutUpdateCall(createJson.jsonMap("Kanta", "SDET"));
		System.out.println(responString);
		responString = updateAPI.returnPutUpdateCall(createJson.jsonMap("Sana", "Dev"));
		System.out.println(responString);
	}

}
