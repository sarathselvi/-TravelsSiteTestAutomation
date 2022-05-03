package com.phptravels.qa.customerpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

import io.qameta.allure.Step;

public class CustomerLoginPage extends TestBase {

	// Page Factory - OR:

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
	WebElement loginBtn;

	// Initializing Page Objects:
	public CustomerLoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	@Step("Getting Login  Page Title")
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("Login with username {0} and password{1}")
	public CustomerHomePage validateLoginCredentials(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new CustomerHomePage();

	}

}
