package com.phptravels.qa.admintc;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.adminpages.AdminHomePage;
import com.phptravels.qa.adminpages.AdminHotelPage;
import com.phptravels.qa.adminpages.AdminLoginPage;
import com.phptravels.qa.base.TestBase;

public class AdminHomePageTest extends TestBase {
	AdminLoginPage AdminLoginPage;
	AdminHomePage AdminHomePage;
	AdminHotelPage AdminHotelPage;
	String url = "https://www.phptravels.net/api/admin";
	

	public AdminHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization(url);
		AdminLoginPage = new AdminLoginPage();
		AdminHomePage = AdminLoginPage.loginAdmin(prop.getProperty("username"), prop.getProperty("password"));
		

	}

	@Test(priority = 1, enabled = false)
	public void validateMenu() {
		Assert.assertEquals(AdminHomePage.validateMenu(), true);
	}

	@Test(priority = 2)
	public void clickHotelPage() {
		AdminHotelPage = AdminHomePage.clickHotelPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
