package com.vtigercrm.objectrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Org_Page 
{
	@FindBy(name = "accountname")
	private WebElement Orgnameedit;
	
	@FindBy(name = "accounttype")
	private WebElement orgtype;
	
	@FindBy(name = "industry")
	private WebElement orgindus;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public Create_Org_Page(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgnameedit() {
		return Orgnameedit;
	}
	public WebElement getOrgtype() {
		return orgtype;
	}
	public WebElement getOrgindus() {
		return orgindus;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createorg(String orgname)
	{
		Orgnameedit.sendKeys(orgname);
		savebtn.click();
	}
	
}
