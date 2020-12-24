package com.vtigercrm.objectrepositoryLib;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Organizations_Page 
{
	WebDriver driver;
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorg;
	
	@FindBy(name = "search_text")
	private WebElement searchtextbox;
	
	@FindBy(name = "search_field")
	private WebElement searchbyfield;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submit_search;
	
	@FindBy(xpath = "//span[contains(.,'No Organization Found !')]")
	private WebElement noOrgfound;
	
	public Organizations_Page(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateorg() {
		return createorg;
	}
	
	public WebElement getSearchtextbox() {
		return searchtextbox;
	}

	public WebElement getSearchbyfield() {
		return searchbyfield;
	}

	public WebElement getSubmit_search() {
		return submit_search;
	}
	
	public WebElement getNoOrgfound() {
		return noOrgfound;
	}
	
	public void search_click(String searchbox, String searchIn)
	{
		searchtextbox.sendKeys(searchbox);
		 List<WebElement> searchfield = driver.findElements(By.xpath("bas_searchfield"));
		for (WebElement we : searchfield) 
		{
			if(we.getText().equals(searchIn))
				we.click();
		}
	}
	
}
