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
	
	@FindBy(className = "searchBox")
	private WebElement mainsearchbox;
	
	@FindBy(linkText = "Opportunities")
	private WebElement Opportunitieslink;
	
	public Home_Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}

	public WebElement getMainsearchbox() {
		return mainsearchbox;
	}

	public WebElement getOrglink() 
	{
		return Orglink;
	}

	public WebElement getContactlink() 
	{
		return Contactlink;
	}
	
}
