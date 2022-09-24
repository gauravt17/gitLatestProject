package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	public HomePage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="main-nav")
	WebElement linkBar;
	
	@FindBy(css="span[class='user-display']")
	WebElement usernameText;
	
	@FindBy(linkText = "Deals")
	WebElement dealsLink;
	
	@FindBy(linkText="Tasks")
	WebElement tasksLink;
	
	@FindBy(linkText="Contacts")
	WebElement contactsLink;
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public void hoveringOnLinkBar()
	{
		Actions action = new Actions(driver);
		action.moveToElement(linkBar).build().perform();;
		
	}
	
	public String getUsernameText()
	{
		return usernameText.getText();
	}
	
	public DealsPage clickOnDeals()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public ContactsPage clickOnContacts()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	

}
