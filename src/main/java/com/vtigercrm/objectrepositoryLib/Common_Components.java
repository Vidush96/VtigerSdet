package com.vtigercrm.objectrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Common_Components 
{
	
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headername;
	
	@FindBy(name = "search_text")
	private WebElement searchtextbox;
	
	@FindBy(name = "search_field")
	private WebElement searchbyfield;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submit_search;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deletebtninfo;
	
	
	public Common_Components(WebDriver driver, String name)
	{
		PageFactory.initElements(driver, this);
	}

	

	public WebElement getHeadername() {
		return headername;
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

	public WebElement getDeletebtninfo() {
		return deletebtninfo;
	}
	
	
}
