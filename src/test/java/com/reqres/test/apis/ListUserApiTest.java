package com.reqres.test.apis;

import org.junit.Before;
import org.junit.Test;
import com.reqres.qa.apis.ListUserAPI;
import com.reqres.qa.utils.JsonPathClass;

public class ListUserApiTest {

	ListUserAPI listUserApi;
	JsonPathClass jPath;
	
	@Before
	public void initClasses() {
		listUserApi = new ListUserAPI();
	}
	
	@Test
	public void testListUserApi() {
		String responseString = listUserApi.getListUser();
		System.out.println(responseString);
		
	}
}
