package com.testweb.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		File src = new File("./TestData/data.xlsx");
		try {
			FileInputStream fs = new FileInputStream(src);
			wb = new XSSFWorkbook(fs);
		} catch (Exception e) {
			System.out.println("Unable to read Excel file "+e.getMessage());
		} 
		
	}
	
	public String getData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}

}
