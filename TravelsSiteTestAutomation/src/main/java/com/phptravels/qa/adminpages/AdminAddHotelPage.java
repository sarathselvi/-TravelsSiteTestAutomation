package com.phptravels.qa.adminpages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.phptravels.qa.base.TestBase;

public class AdminAddHotelPage extends TestBase {

	@FindBy(xpath = "//button[@title='Show satellite imagery']")
	WebElement satelliteButton;

	@FindBy(name = "hotelname")
	WebElement hotelname;

	@FindBy(xpath = "//span[@class='select2-chosen']")
	WebElement locationField;

	@FindBy(xpath = "//div[@class='select2-search']/input")
	WebElement locationText;

	@FindBy(xpath = "//span[@class='select2-match' and contains(text(),'Madurai')]")
	WebElement locationDropDown;

	@FindBy(id = "add")
	WebElement addButton;

	public AdminAddHotelPage() {

		PageFactory.initElements(driver, this);
	}

	public void satelliteButtonClick() {

		Actions action = new Actions(driver);
		action.moveToElement(satelliteButton).build().perform();

		satelliteButton.click();

	}

	public void enterHotelDetails(String hoteName, String hotelDesc) throws InterruptedException {
		hotelname.sendKeys(hoteName);
		Thread.sleep(3000);

		driver.switchTo().frame(0);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementsByTagName('p')[0].innerHTML ='" + hotelDesc + "'");

		driver.switchTo().defaultContent();

		Actions action = new Actions(driver);
		// Thread.sleep(2000);
		action.moveToElement(locationField).build().perform();
		// Thread.sleep(2000);
		action.click(locationField).build().perform();
		// Thread.sleep(2000);
		locationText.sendKeys("Madurai");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(locationDropDown));
		locationDropDown.click();
		// Thread.sleep(2000);

		js.executeScript("arguments[0].click();", addButton);
	}

}
