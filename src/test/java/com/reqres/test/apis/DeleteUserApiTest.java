package com.reqres.test.apis;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.reqres.qa.apis.DeleteUserAPI;
import com.reqres.qa.utils.JsonPathClass;

public class DeleteUserApiTest {

	DeleteUserAPI deleteUserAPI;
	JsonPathClass jPath;
	
	@BeforeMethod
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
