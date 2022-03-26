package com.reqres.qa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import oracle.jdbc.OracleDriver;

public class JDBCConnect {

	public static void main(String[] args) {
		String user = "";
		String pass = "";
		
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new OracleDriver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
