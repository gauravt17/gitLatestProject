package com.qa.ExtentReportListener;

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
		WebDriver driver;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			saveScreenshot(driver);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
		
		
	  }

	


