package com.reqres.test.apis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.reqres.qa.apis.UpdateAPI;
import com.reqres.qa.utils.JsonPathClass;
import com.reqres.qa.utils.ReadConfig;

public class UpdateApiTest {

	JsonPathClass jPath;
	UpdateAPI updateAPI;
	
	@Before
	public void initClasses() {
		updateAPI = new UpdateAPI();
	}
	
	@Test
	public void testUpdateApi() {
		updateAPI.putUpdateCall(ReadConfig.getInstance().getJsonFilePath());
		//String responseString = updateAPI.putUpdateCall(ReadConfig.getInstance().getJsonFilePath());
		String responseString = updateAPI.responseString;
		System.out.println(responseString);
		
		jPath = new JsonPathClass(responseString);
		System.out.println(jPath.getJsonPath().get("updatedAt"));
		String jobString = jPath.getJsonPath().get("job");
		System.out.println(jobString);
		Assert.assertEquals("sdet", jobString);
		System.out.println(jobString);
	}
}
