package com.phptravels.qa.customertc;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.customerpages.CustomerHomePage;
import com.phptravels.qa.customerpages.CustomerLoginPage;

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

	@Test(priority = 1)
	public void customerLoginTitleTest() {

		String title = CustomerLoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - PHPTRAVELS");

	}

	@Test(priority = 2)
	public void validateLoginCredentialsTest() {

		CustomerHomePage = CustomerLoginPage.validateLoginCredentials(prop.getProperty("customerusername"),
				prop.getProperty("customerpassword"));
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}
