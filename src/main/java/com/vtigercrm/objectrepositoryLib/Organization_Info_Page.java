package com.vtigercrm.objectrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Info_Page 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headername;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deletebtn;
	
	public Organization_Info_Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeadername() 
	{
		return headername;
	}
}
