package com.phptravels.qa.admintc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestElement {

	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver;
//		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
//
//		driver.get("https://www.phptravels.net/api/admin");
//
//		driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
//		driver.findElement(By.name("password")).sendKeys("demoadmin");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//		Thread.sleep(10000);
//
//		driver.findElement(By.xpath("//a[@aria-controls='hotelsmodule']")).click();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)))
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-controls='hotelsmodule']")));
//		element.click();
		System.out.println("test");
		String TESTDATA_SHEET_PATH = "D:\\Sarath\\PracticePOM\\"
				+ "TravelsSiteTestAutomation\\src\\main\\java\\com\\phptravels\\qa\\testdata\\PHPTravelsAdminTestDate.xlsx";
		FileInputStream file = null;
		Workbook workbook = null;
		Sheet sheet = null;
		String fileExtensionName = TESTDATA_SHEET_PATH.substring(TESTDATA_SHEET_PATH.indexOf("."));
		System.out.println(fileExtensionName);

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
				System.out.println("inside .xlsx");

			} else if (fileExtensionName.equals(".xls")) {
				workbook = new HSSFWorkbook(file);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		sheet = workbook.getSheet("hotels");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println("rowCount:" + rowCount);

		Row row = sheet.getRow(0);
		Object[][] data = new Object[rowCount][row.getLastCellNum()];

		int a = data.length;
		System.out.println("a:" + a);

		for (int i = 0; i < rowCount; i++) {
			row = sheet.getRow(i + 1);
			System.out.println("Cell Count:" + row.getLastCellNum());
			for (int j = 0; j < row.getLastCellNum(); j++) {

				data[i][j] = row.getCell(j).toString();

			}
		}

	}

}

//@FindBy(xpath = "//a[@aria-controls='hotelsmodule']")
//WebElement hotelsmodule1;
//
//@FindBy(xpath = "//a[@data-bs-target='#Hotels']")
//WebElement hotelsmodule2;
//
//@FindBy(xpath = "//div[@id='Hotels']//a[contains(text(),'Hotels')]")
//WebElement hotelsmodule3;
//
