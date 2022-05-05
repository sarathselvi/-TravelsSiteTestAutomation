package com.phptravels.qa.customertc;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.customerpages.CustomerHomePage;
import com.phptravels.qa.customerpages.CustomerLoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.phptravels.qa.TestUtil.AllureReportListener.class)
public class CustomerLoginTest extends TestBase {
	String url = "https://www.phptravels.net/login";
	CustomerLoginPage CustomerLoginPage;
	CustomerHomePage CustomerHomePage;

	public CustomerLoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization(url);
		CustomerLoginPage = new CustomerLoginPage();

	}

	@Test(priority = 1, description = "verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Allure:verifying login page title test")
	@Story("StoryAllure:verifying login page title test")
	public void customerLoginTitleTest() {

		String title = CustomerLoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - PHPTRAVELSS");

	}

	@Test(priority = 2, description = " login page check credentials test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Allure:login page check credentials test")
	@Story("StoryAllure:login page check credentials test")
	public void validateLoginCredentialsTest() {

		CustomerHomePage = CustomerLoginPage.validateLoginCredentials(prop.getProperty("customerusername"),
				prop.getProperty("customerpassword"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
