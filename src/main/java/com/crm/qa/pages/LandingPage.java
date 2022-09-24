package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LandingPage extends TestBase{

	TestUtil util;

	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "LOG IN")
	WebElement linkForLogin;
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public LoginPage goToLoginPage()
	{
		util = new TestUtil();
		//util.webElementToBeClickable(linkForLogin);
		linkForLogin.click();
		return new LoginPage();
	}

}
