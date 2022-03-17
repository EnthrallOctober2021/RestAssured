package com.reqres.test.apis;

import org.junit.Before;
import org.junit.Test;

import com.reqres.qa.apis.DeleteUserAPI;
import com.reqres.qa.utils.JsonPathClass;

public class DeleteUserApiTest {

	DeleteUserAPI deleteUserAPI;
	JsonPathClass jPath;
	
	@Before
	public void initClass() {
		deleteUserAPI = new DeleteUserAPI();
	}
	
	@Test
	public void deleteUserTest() {
		//String responseString = deleteUserAPI.deleteUserCall();
		int responseString = deleteUserAPI.deleteUserCallStatusCode();
		System.out.println("Status Code : "+ responseString);
	}
}
