package com.qa.ExtentReportListener;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Attachment;

public class ListenerAllure implements ITestListener{
	
	@Attachment(value="Page screenshot" , type="image/png")
	public byte[] saveScreenshot(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = TestBase.getDriver();
		saveScreenshot(driver);
		
	  }

	

}
