package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil util = new TestUtil();;
	
	@BeforeMethod()
	public void setUp()
	{
		intitalize();
		LandingPage lp = new LandingPage();
		lp.goToLoginPage();
		loginPage = new LoginPage();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContacts();
		contactsPage.moveCursorToBar();
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(priority= 1)
	public void contactLinkTest()
	{
		Assert.assertEquals(contactsPage.getContactsText(),"Contacts");
		
	}
	@Test(priority = 2)
	public void selectingContactByName()
	{
		contactsPage.getContact("Saurav Tangri");
	}
	
	@Test(priority = 3)
	public void selectingContactMultipleNames()
	{
		contactsPage.getContact("Saurav Tangri");
		contactsPage.getContact("Gaurav Tangri");
	}
	
	@Test(dataProvider="getData")
	public void enterVariousEntries(String fname,String lname,String address)
	{
		contactsPage.enterNewContact(fname, lname, address);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return util.getDataValues("ContactsData");
	}

}
