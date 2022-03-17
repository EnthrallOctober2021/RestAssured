package com.reqres.qa.apis;

import com.reqres.qa.utils.ReadConfig;
import io.restassured.RestAssured;

public class DeleteUserAPI {

	public String deleteUserCall() {
		return RestAssured
				.given()
				.baseUri(ReadConfig.getInstance().getBaseUri())
				.log().all()
				.when()
				.delete(ReadConfig.getInstance().getUpdateApi())
				.asPrettyString();
	}
	
	public int deleteUserCallStatusCode() {
		return RestAssured
				.given()
				.baseUri(ReadConfig.getInstance().getBaseUri())
				.log().all()
				.when()
				.delete(ReadConfig.getInstance().getUpdateApi())
				.getStatusCode();
	}
}
