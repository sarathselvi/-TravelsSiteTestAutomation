package com.phptravels.qa.customertc;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravels.qa.base.TestBase;
import com.phptravels.qa.customerpages.CustomerAddFundsPage;
import com.phptravels.qa.customerpages.CustomerHomePage;
import com.phptravels.qa.customerpages.CustomerLoginPage;

public class CustomerHomePageTest extends TestBase {
	CustomerLoginPage CustomerLoginPage;
	CustomerHomePage CustomerHomePage;
	CustomerAddFundsPage CustomerAddFundsPage;
	String url = "https://www.phptravels.net/login";

	public CustomerHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization(url);
		CustomerLoginPage = new CustomerLoginPage();
		CustomerHomePage = CustomerLoginPage.validateLoginCredentials(prop.getProperty("customerusername"),
				prop.getProperty("customerpassword"));

	}

	@Test(priority = 1)
	public void validateCustomerHomePageTitle() {

		String CustomerHomePageTitle = CustomerHomePage.validateCustomerHomePageTitle();
		Assert.assertEquals(CustomerHomePageTitle, "Dashboard - PHPTRAVELS", "Home Page Title Not Matched");

	}

	@Test(priority = 2)
	public void validateCustomerHomePageWelcomeMsg() {
		String welcomeMsg = CustomerHomePage.validateCustomerHomePageWelcomeMsg();
		Assert.assertEquals(welcomeMsg, "", "Welcome Back Message Not Displayed Correctly");

	}

	@Test(priority = 3)
	public void clickOnAddFundsPage() {
		CustomerAddFundsPage = CustomerHomePage.clickOnAddFundsPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
