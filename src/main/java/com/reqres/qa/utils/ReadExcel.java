package com.reqres.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	/*
	 * public static void main(String[] args) { ReadExcel excel = new ReadExcel();
	 * String [][] data =
	 * excel.dataTable(ReadConfig.getInstance().getExcelFilePath()); for(String[]
	 * array : data) { for(String s: array) { System.out.print(s + " "); }
	 * System.out.println(); } }
	 */
	
	public String[][] dataTable(String fileString){
		String[][] data = null;
		FileInputStream fileInputStream = null;
		Workbook workbook = null;
		Sheet sheet = null;
		try {
			fileInputStream = new FileInputStream(fileString);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int initialRows = sheet.getLastRowNum();
		int actualRows = 0;
		for(int i = 0; i < initialRows; i++) {
			if(sheet.getRow(i).getCell(0).getCellType() != CellType.BLANK) {
				actualRows++;
			}
		}
		int cols = sheet.getRow(0).getLastCellNum();
		data = new String[actualRows][cols];
		for(int row = 0; row < actualRows; row++) {
			for(int cell = 0; cell < cols; cell++) {
				String valueString = sheet.getRow(row+1).getCell(cell).getStringCellValue();
				data[row][cell] = valueString;
			}
		}
		try {
			workbook.close();
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
