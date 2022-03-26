package com.reqres.test.apis;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.reqres.qa.apis.UpdateAPI;
import com.reqres.qa.utils.CreateJson;
import com.reqres.qa.utils.JsonPathClass;
import com.reqres.qa.utils.ReadConfig;
import com.reqres.qa.utils.ReadExcel;

public class DataProviderTest {

	CreateJson createJson;
	JsonPathClass jPath;
	UpdateAPI updateAPI;
	ReadExcel readExcel;
	
	@BeforeMethod
	public void initClasses() {
		updateAPI = new UpdateAPI();
		createJson = new CreateJson();
		readExcel = new ReadExcel();
	}
	
	@DataProvider(name = "userData")
	public String[][] dataTable(){
		readExcel = new ReadExcel();
		String filePath = ReadConfig.getInstance().getExcelFilePath();
		String [][] data = readExcel.dataTable(filePath);
		return data;
	}
	
	@Test(dataProvider = "userData")
	public void dataProviderTest(String user, String job) {
		String responseString = updateAPI.returnPutUpdateCall(createJson.jsonMap(user,job));
		System.out.println(responseString);
	}
}
