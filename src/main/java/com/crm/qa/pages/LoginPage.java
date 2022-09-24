package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Login")
	WebElement linkForLogin;
	
	@FindBy(name="email")
	WebElement emailField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(css=".submit.button")
	WebElement loginButton;
	
	public HomePage signIn(String username, String password)
	{
		emailField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new HomePage();
	}
	

}
