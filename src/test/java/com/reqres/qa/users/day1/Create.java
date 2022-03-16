package com.reqres.qa.users.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("./inputFiles/user.json"));
		String string = null;
		StringBuilder builder = new StringBuilder();
		while((string = bufferedReader.readLine()) != null) {
			builder.append(string);
		}
		System.out.println(builder);
		
		Response response = RestAssured.given().baseUri("https://reqres.in").body(builder.toString()).contentType(ContentType.JSON)
				.when().post("/api/users").andReturn();
		response.prettyPrint();
	}
}
