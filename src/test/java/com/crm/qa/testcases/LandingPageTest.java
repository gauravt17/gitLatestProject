package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;

public class LandingPageTest extends TestBase{
	
	LandingPage landingPage;
	
	public LandingPageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setUp()
	{
		intitalize();
		landingPage = new LandingPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test
	public void verifyTitle()
	{
		String title = landingPage.validateTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management");
	}

}
