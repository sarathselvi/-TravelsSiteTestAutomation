package com.phptravels.qa.customerpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class CustomerHomePage extends TestBase {
	// Page Factory - OR:

	@FindBy(xpath = "//h4[@class=\"author__title\"]")
	WebElement customername;

	@FindBy(xpath = "//span[@class=\"author__meta\"]")
	WebElement welcomemsg;

	@FindBy(xpath = "//a[@class=\" waves-effect\"][contains(text(),'Add Funds')]")
	WebElement addfunds;

	// Initializing Page Objects:
	public CustomerHomePage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public String validateCustomerHomePageTitle() {
		return driver.getTitle();
	}

	public String validateCustomerHomePageWelcomeMsg() {
		return welcomemsg.getText();
	}

	public CustomerAddFundsPage clickOnAddFundsPage() {
		addfunds.click();
		return new CustomerAddFundsPage();

	}

}
