package com.reqres.qa.apis;

import com.reqres.qa.utils.ReadConfig;
import io.restassured.RestAssured;

public class ListUserAPI {

	public String getListUser() {
		return RestAssured
				.given().baseUri(ReadConfig.getInstance().getBaseUri())
				.when()
				.get(ReadConfig.getInstance().getListUserApi())
				.asPrettyString();
	}
}
