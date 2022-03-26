package com.reqres.qa.utils;

import java.util.HashMap;
import java.util.Map;

public class CreateJson {

	/*
	 * public static void main(String[] args) { CreateJson createJson = new
	 * CreateJson(); System.out.println(createJson.jsonMap("somebody", "dev")); }
	 */
	
	public Map<String, String> jsonMap(String name, String job) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("job", job);
		return map;
	}
}
