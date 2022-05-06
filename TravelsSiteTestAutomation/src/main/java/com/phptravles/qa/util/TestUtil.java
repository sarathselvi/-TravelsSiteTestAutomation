package com.phptravles.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICITLY_WAIT = 50;

	public static String TESTDATA_SHEET_PATH = "D:\\Sarath\\PracticePOM\\"
			+ "TravelsSiteTestAutomation\\src\\main\\java\\com\\phptravels\\qa\\testdata\\PHPTravelsAdminTestDate.xlsx";

	public static Object[][] getTestData(String Sheetname) {

		FileInputStream file = null;
		Workbook workbook = null;
		Sheet sheet = null;
		String fileExtensionName = TESTDATA_SHEET_PATH.substring(TESTDATA_SHEET_PATH.indexOf("."));

		// Create Input Stream
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		// Create WorkBook
		try {
			if (fileExtensionName.equals(".xlsx")) {

				workbook = new XSSFWorkbook(file);

			} else if (fileExtensionName.equals(".xls")) {
				workbook = new HSSFWorkbook(file);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		sheet = workbook.getSheet(Sheetname);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		Row row = sheet.getRow(0);

		Object[][] data = new Object[rowCount][row.getLastCellNum()];

		for (int i = 0; i < rowCount; i++) {
			row = sheet.getRow(i + 1);
			System.out.println("Cell Count:" + row.getLastCellNum());
			for (int j = 0; j < row.getLastCellNum(); j++) {

				data[i][j] = row.getCell(j).toString();

			}
		}

		return data;
	}

	public static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
	}
}
