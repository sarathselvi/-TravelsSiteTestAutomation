package com.phptravels.qa.admintc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.phptravels.qa.adminpages.AdminAddHotelPage;
import com.phptravels.qa.adminpages.AdminHomePage;
import com.phptravels.qa.adminpages.AdminHotelPage;
import com.phptravels.qa.adminpages.AdminLoginPage;
import com.phptravels.qa.base.TestBase;
import com.phptravles.qa.util.TestUtil;

public class AdminAddHotelPageTest extends TestBase {
	String sheetName = "hotels";
	AdminHotelPage AdminHotelPage;
	AdminLoginPage AdminLoginPage;
	AdminHomePage AdminHomePage;
	AdminAddHotelPage AdminAddHotelPage;
	String url = "https://www.phptravels.net/api/admin";

	public AdminAddHotelPageTest() {

		super();
	}

	@BeforeMethod
	public void beforeMethod() {

		initialization(url);
		AdminLoginPage = new AdminLoginPage();
		AdminHomePage = AdminLoginPage.loginAdmin(prop.getProperty("username"), prop.getProperty("password"));
		AdminHotelPage = AdminHomePage.clickHotelPage();
		AdminAddHotelPage = AdminHotelPage.addHotels();

	}

	@DataProvider
	public Object[][] getTestData() {

		Object data[][] = TestUtil.getTestData(sheetName);

		return data;

	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void enterHotelDetails(String hotelName, String hotelDesc) throws InterruptedException {

		AdminAddHotelPage.enterHotelDetails(hotelName, hotelDesc);
		System.out.println("Hotel Name: " + hotelName + " ; Hotel Desc: " + hotelDesc);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
