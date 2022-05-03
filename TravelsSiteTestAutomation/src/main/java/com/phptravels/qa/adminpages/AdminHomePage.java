package com.phptravels.qa.adminpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class AdminHomePage extends TestBase {

	// PageOR
	@FindBy(xpath = "//button[@id='drawerToggle']")
	WebElement drawerButton;

	@FindBy(xpath = "//a[@aria-controls='hotelsmodule']")
	WebElement hotelsmodule1;

	@FindBy(xpath = "//a[@data-bs-target='#Hotels']")
	WebElement hotelsmodule2;

	@FindBy(xpath = "//div[@id='Hotels']//a[contains(text(),'Hotels')]")
	WebElement hotelsmodule3;

	// Init Objects
	public AdminHomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean validateMenu() {
		return drawerButton.isDisplayed();

	}

	public AdminHotelPage clickHotelPage() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(hotelsmodule1));

		hotelsmodule1.click();
//		wait.until(ExpectedConditions.elementToBeClickable(hotelsmodule2));
		hotelsmodule2.click();
//		wait.until(ExpectedConditions.elementToBeClickable(hotelsmodule3));
		hotelsmodule3.click();
		return new AdminHotelPage();

	}

}