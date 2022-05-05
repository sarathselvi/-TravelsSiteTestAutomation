package com.phptravels.qa.TestUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.phptravels.qa.adminpages.AdminLoginPage;
import com.phptravels.qa.base.TestBase;

public class ListenerTest extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Started:" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		TakesScreenshot t = (TakesScreenshot) AdminLoginPage.driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(srcFile, new File("./ScreenShot/Pass/" + result.getName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		TakesScreenshot t = (TakesScreenshot) AdminLoginPage.driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(srcFile, new File("./ScreenShot/Failure/" + result.getName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Skipped:" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
