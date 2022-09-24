package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTestcases extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil util;
	
	@BeforeMethod()
	public void setUp()
	{
		intitalize();
		LandingPage lp = new LandingPage();
		lp.goToLoginPage();
		loginPage = new LoginPage();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod()
	public void tearDown()
	{
		//driver.quit();
	}
	
	
	@Test(priority= 1)
	public void verifyHomePageTitle()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","HOMEPAGE TITLE INCORRECT");
	}
	@Test(priority= 2)
	public void hover()
	{
		homePage.hoveringOnLinkBar();
		homePage.clickOnDeals();
	}
	
	@Test (priority= 3)
	public void verifyUser()
	{
		String username = homePage.getUsernameText();
		Assert.assertEquals(username, "Gaurav Tangri");
	}
	

}
