package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	LandingPage landingPage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intitalize();
		LandingPage lp = new LandingPage();
		lp.goToLoginPage();
		loginPage = new LoginPage();
	}
	//hello
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void logginInTest()
	{
			loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
			Assert.assertTrue(false);
	}

}
