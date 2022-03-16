package com.reqres.qa.users.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListUsers {

	public static void main(String[] args) {
	//	RestAssured.given().baseUri("https://reqres.in").log().all().
		//	when().get("/api/users?page=2").then().log().all();
		
		//RestAssured.basePath  = "https://reqres.in";
		Response response = RestAssured.given().baseUri("https://reqres.in").get("/api/users?page=2").andReturn();
		response.prettyPrint();
	}
}
