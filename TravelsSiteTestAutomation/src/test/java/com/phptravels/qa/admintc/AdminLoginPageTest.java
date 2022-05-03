package com.phptravels.qa.admintc;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.phptravels.qa.adminpages.AdminHomePage;
import com.phptravels.qa.adminpages.AdminLoginPage;
import com.phptravels.qa.base.TestBase;

@Listeners(com.phptravles.qa.TestUtil.ListenerTest.class)
public class AdminLoginPageTest extends TestBase {
	AdminLoginPage AdminLoginPage;
	AdminHomePage AdminHomePage;
	String url = "https://www.phptravels.net/api/admin";

	public AdminLoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization(url);
		AdminLoginPage = new AdminLoginPage();

	}

	@Test(priority = 1)
	public void validateAdminLoginPage() {
		Assert.assertEquals(AdminLoginPage.validateTitle(), "Administator Login");
	}

	@Test(priority = 2)
	public void loginAdmin() {
		AdminHomePage = AdminLoginPage.loginAdmin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
