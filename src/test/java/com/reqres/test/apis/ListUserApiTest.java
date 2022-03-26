package com.reqres.test.apis;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.reqres.qa.apis.ListUserAPI;
import com.reqres.qa.utils.JsonPathClass;

public class ListUserApiTest {

	ListUserAPI listUserApi;
	JsonPathClass jPath;
	
	@BeforeMethod
	public void initClasses() {
		listUserApi = new ListUserAPI();
	}
	
	@Test
	public void testListUserApi() {
		String responseString = listUserApi.getListUser();
		System.out.println(responseString);
		
	}
}
