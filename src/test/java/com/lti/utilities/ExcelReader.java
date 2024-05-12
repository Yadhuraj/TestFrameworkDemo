package com.lti.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static FileInputStream ip;
	public static Workbook wb;
	public static Sheet sheetpage;

	public ExcelReader(String file) throws IOException {
		// TODO Auto-generated constructor stub
		ip = new FileInputStream(file);
		wb = WorkbookFactory.create(ip);

	}

	public int countrow(String sheetname) {

		sheetpage = wb.getSheet(sheetname);
		return sheetpage.getLastRowNum();

	}

	public int countcol(String sheetname) {
		sheetpage = wb.getSheet(sheetname);
		return sheetpage.getRow(0).getLastCellNum();

	}

	public String readCell(int row, int column, String sheetname) {
		try {
			sheetpage = wb.getSheet(sheetname);
			int rowsize = sheetpage.getLastRowNum();
			int columnsize = sheetpage.getRow(0).getLastCellNum();
			if (row > rowsize || column > columnsize) {
				throw new Exception("cell index is out of range");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (sheetpage.getRow(row).getCell(column).getStringCellValue());

	}
	
	public double readCellNum(int row, int column, String sheetname) {
		try {
			sheetpage = wb.getSheet(sheetname);
			int rowsize = sheetpage.getLastRowNum();
			int columnsize = sheetpage.getRow(0).getLastCellNum();
			if (row > rowsize || column > columnsize) {
				throw new Exception("cell index is out of range");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (sheetpage.getRow(row).getCell(column).getNumericCellValue());

	}

	public String readCell(int row, int column, int sheetindex) {
		try {
			sheetpage = wb.getSheetAt(sheetindex);
			int rowsize = sheetpage.getLastRowNum();
			int columnsize = sheetpage.getRow(0).getLastCellNum();
			if (row > rowsize || column > columnsize) {
				throw new Exception("cell index is out of range");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (sheetpage.getRow(row).getCell(column).getStringCellValue());

	}
	
//	public static void main(String[] args) throws IOException {
//		ExcelReader e = new ExcelReader("./TestData/TestInfo.xlsx");
//		System.out.println("countrow: "+e.countrow("LoginData"));
//	
//		for (int i = 1; i <= e.countrow("LoginData"); i++) {
//			for (int j = 0; j<e.countcol("LoginData"); j++) {
//				System.out.println("data: "+ e.readCell(i, j, "LoginData"));
//			}
//		}
//	}
	
}
