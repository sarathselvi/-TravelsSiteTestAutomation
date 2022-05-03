package com.phptravels.qa.adminpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class AdminLoginPage extends TestBase {

	// Page Factory

	@FindBy(name = "email")
	WebElement emailid;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;

	// Initializing Page Objects

	public AdminLoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validateTitle() {
		return driver.getTitle();
	}

	public AdminHomePage loginAdmin(String email, String pass) {
		emailid.sendKeys(email);
		password.sendKeys(pass);
		submitbutton.click();

		return new AdminHomePage();

	}

}
