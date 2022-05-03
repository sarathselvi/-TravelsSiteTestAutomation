package com.phptravels.qa.admintc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.adminpages.AdminAddHotelPage;
import com.phptravels.qa.adminpages.AdminHomePage;
import com.phptravels.qa.adminpages.AdminHotelPage;
import com.phptravels.qa.adminpages.AdminLoginPage;
import com.phptravels.qa.base.TestBase;

public class AdminHotelPageTest extends TestBase {
	AdminHotelPage AdminHotelPage;
	AdminLoginPage AdminLoginPage;
	AdminHomePage AdminHomePage;
	AdminAddHotelPage AdminAddHotelPage;
	String url = "https://www.phptravels.net/api/admin";
	

	public AdminHotelPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization(url);
		AdminLoginPage = new AdminLoginPage();
		AdminHomePage = AdminLoginPage.loginAdmin(prop.getProperty("username"), prop.getProperty("password"));
		AdminHotelPage = AdminHomePage.clickHotelPage();

	}

	@Test(priority = 1)
	public void addHotel() {

		AdminAddHotelPage = AdminHotelPage.addHotels();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
