package com.reqres.qa.users.day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ListUsers {

	public static void main(String[] args) {
	//	RestAssured.given().baseUri("https://reqres.in").log().all().
		//	when().get("/api/users?page=2").then().log().all();
		
		//RestAssured.basePath  = "https://reqres.in";
		String responseStr = RestAssured.given().baseUri("https://reqres.in").get("/api/users?page=2").asPrettyString();
		System.out.println(responseStr);
		
		System.out.println("-------------------");
		
		JsonPath path = JsonPath.from(responseStr);
		
		int pagNum = path.getInt("page");
		System.out.println(pagNum);
		
		String email1 = path.getString("data[1].email");
		System.out.println(email1);
		
		System.out.println(path.get("total"));
		
		int total_pages = path.get("total_pages");
		System.out.println(total_pages);
		
		int per_page_val = path.getInt("per_page");
		
		List<String> emailList = new ArrayList<String>();
		for(int i = 0; i < per_page_val; i++) {
			String emailString = path.getString("data["+i+"].email");
			emailList.add(emailString);
		}
		System.out.println(emailList);
		
		List<Integer> ids = new ArrayList<Integer>();
		for(int i = 0; i < per_page_val; i++) {
			int id = path.getInt("data["+i+"].id");
			ids.add(id);
		}
		System.out.println(ids);
	}
}
