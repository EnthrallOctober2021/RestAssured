package com.reqres.qa.apis;

import java.io.File;
import java.util.Map;

import com.reqres.qa.utils.ReadConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateAPI {

	public String responseString = null;
	
	public String putUpdateCall(String filePath) {
		responseString =  RestAssured
				.given()
				.baseUri(ReadConfig.getInstance().getBaseUri())
				.body(new File(filePath)).contentType(ContentType.JSON).log().all()
				.when()
				.put(ReadConfig.getInstance().getUpdateApi())
				.asPrettyString();
		return responseString;
	}
	
	public String returnPutUpdateCall(Map<String, String> map) {
		return RestAssured
				.given()
				.baseUri(ReadConfig.getInstance().getBaseUri())
				.body(map).contentType(ContentType.JSON).log().all()
				.when()
				.put(ReadConfig.getInstance().getUpdateApi())
				.asPrettyString();
	}
}
