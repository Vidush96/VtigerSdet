package com.vtigercrm.objectrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page 
{
	@FindBy(linkText = "Organizations")
	private WebElement Orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactlink;
	
	public Home_Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrglink() {
		return Orglink;
	}

	public WebElement getContactlink() {
		return Contactlink;
	}
	
}
