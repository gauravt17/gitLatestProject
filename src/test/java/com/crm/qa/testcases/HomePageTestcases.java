package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.qa.ExtentReportListener.ListenerAllure;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Listeners({ListenerAllure.class})
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
		driver.quit();
	}
	
	
	
	@Test(priority= 1, description = "Verifying HomePageTitle")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description...Verifying HomePageTitle")
	@Story("StoryName: To check home page title")
	public void verifyHomePageTitle()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","HOMEPAGE TITLE INCORRECT");
	}
	
	
	@Test(priority= 2)
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case Description...hovering on link bar")
	@Story("StoryName: To check home page title")
	public void hover()
	{
		homePage.hoveringOnLinkBar("JUST CHECKING");
		homePage.clickOnDeals();
	}
	
	
	@Test (priority= 3)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description...Verifying username")
	@Story("StoryName: To check home page title")
	public void verifyUser()
	{
		String username = homePage.getUsernameText();
		Assert.assertEquals(username, "Gaurav Tangri");
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Story("NEW STORY")
	@Test
	public void failing()
	{
		Assert.assertTrue(false);
	}
	

}
