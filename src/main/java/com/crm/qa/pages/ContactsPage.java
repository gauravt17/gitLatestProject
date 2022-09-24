package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	Actions action = new Actions(driver);
	
	@FindBy(xpath="//div[@id='dashboard-toolbar'] //div[@class='ui header item mb5 light-black']")
	WebElement contactsText;
	
	@FindBy(id="top-header-menu")
	WebElement headerBar;
	
	@FindBy(linkText ="Create")
	WebElement createContact;
	
	@FindBy(css="input[name='first_name']")
	WebElement newContactFirstName;
	
	@FindBy(css="input[name='last_name']")
	WebElement newContactLastName;
	
	@FindBy(css=".ui.linkedin.button")
	WebElement saveButton;
	
	@FindBy(css="input[placeholder='Email address']")
	WebElement newContactEmailField;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getContactsText()
	{
		return contactsText.getText();
	}
	public void moveCursorToBar()
	{
		action.moveToElement(headerBar).build().perform();
	}
	
	public void enterNewContact(String fname, String lname,String email)
	{
		createContact.click();
		newContactFirstName.sendKeys(fname);
		newContactLastName.sendKeys(lname);
		newContactEmailField.sendKeys(email);
		saveButton.click();
		
	}
	
	public void getContact(String name)
	{
		List<WebElement> allTheRows = driver.findElements(By.xpath("//tbody/tr"));
		WebElement desiredElement;
		for(WebElement e : allTheRows)
		{
			List<WebElement> allTheTd = e.findElements(By.xpath("./td"));
			boolean flag = false;
			for(WebElement j : allTheTd)
			{
				String actual = j.getText();
				if(actual.equalsIgnoreCase(name))
				{
					desiredElement = j;
					desiredElement.findElement(By.xpath("./preceding-sibling::td")).click();
					flag=true;
					break;
				}
			}
			
			if(flag)
				break;
			
		}
	}
}
