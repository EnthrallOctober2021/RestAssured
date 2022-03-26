package com.reqres.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	private String baseUri;
	private String updateApi;
	private String listUserAPI;
	private String excelPath;
	
	private String jsonFilePath;
	private String path = "./configuration/config.properties";
	
	public static ReadConfig readConfig;
	
	private ReadConfig() {
	}
	
	public static ReadConfig getInstance() {
		if(readConfig == null) {
			readConfig = new ReadConfig();
			readConfig.loadProperties();
		}
		return readConfig;
	}
	
	private void loadProperties() {
		Properties properties = new Properties();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
			properties.load(inputStream);
			baseUri = properties.getProperty("baseUri");
			updateApi = properties.getProperty("updateApi");
			jsonFilePath = properties.getProperty("jsonFilePath");
			listUserAPI = properties.getProperty("listUserAPI");
			excelPath = properties.getProperty("excelFilePath");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseUri() {
		return baseUri;
	}
	
	public String getUpdateApi() {
		return updateApi;
	}
	
	public String getListUserApi() {
		return listUserAPI;
	}
	
	public String getJsonFilePath() {
		return jsonFilePath;
	}
	
	public String getExcelFilePath() {
		return excelPath;
	}
}
