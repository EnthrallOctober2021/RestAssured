package com.reqres.qa.utils;

import io.restassured.path.json.JsonPath;

public class JsonPathClass {

	private static JsonPath jsonPath;
	
	public JsonPathClass(String response) {
		jsonPath = JsonPath.from(response);
	}
	
	public JsonPath getJsonPath() {
		return jsonPath;
	}
}
