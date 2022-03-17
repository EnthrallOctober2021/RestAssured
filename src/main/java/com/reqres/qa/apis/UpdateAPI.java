package com.reqres.qa.apis;

import java.io.File;
import com.reqres.qa.utils.ReadConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateAPI {

	public String responseString = null;
	
	public void putUpdateCall(String filePath) {
		responseString =  RestAssured
				.given()
				.baseUri(ReadConfig.getInstance().getBaseUri())
				.body(new File(filePath)).contentType(ContentType.JSON)
				.when()
				.put(ReadConfig.getInstance().getUpdateApi())
				.asPrettyString();
	}
	
	public String returnPutUpdateCall(String filePath) {
		return RestAssured
				.given()
				.baseUri(ReadConfig.getInstance().getBaseUri())
				.body(new File(filePath)).contentType(ContentType.JSON)
				.when()
				.put(ReadConfig.getInstance().getUpdateApi())
				.asPrettyString();
	}
}
