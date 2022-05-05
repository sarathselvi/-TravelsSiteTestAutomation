package com.phptravels.qa.admintc;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.phptravels.qa.adminpages.AdminHomePage;
import com.phptravels.qa.adminpages.AdminLoginPage;
import com.phptravels.qa.base.TestBase;

@Listeners(com.phptravels.qa.TestUtil.ListenerTest.class)
public class AdminLoginPageTest extends TestBase {
	AdminLoginPage AdminLoginPage;
	AdminHomePage AdminHomePage;
	String url = "https://www.phptravels.net/api/admin";
	Logger log = Logger.getLogger(AdminLoginPageTest.class);

	public AdminLoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization(url);
		AdminLoginPage = new AdminLoginPage();

	}

	@Test(priority = 1, retryAnalyzer = analyzer.RetryAnalyzer.class)
	public void validateAdminLoginPage() {
		Assert.assertEquals(AdminLoginPage.validateTitle(), "Administator Login");

	}

	@Test(priority = 2)
	public void loginAdmin() {
		AdminHomePage = AdminLoginPage.loginAdmin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("logging into Admin Page");
		log.warn("Warn:" + AdminHomePage);
		log.debug("Debug:" + AdminHomePage);
		log.fatal("fatal" + AdminHomePage);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
