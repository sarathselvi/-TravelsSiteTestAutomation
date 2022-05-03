package com.phptravels.qa.adminpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravels.qa.base.TestBase;

public class AdminHotelPage extends TestBase {

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addhotels;

	public AdminHotelPage() {

		PageFactory.initElements(driver, this);

	}

	// Actions

	public AdminAddHotelPage addHotels() {
		addhotels.click();

		return new AdminAddHotelPage();

	}

}