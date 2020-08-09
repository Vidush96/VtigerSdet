package com.vtigercrm.objectrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigercrm.genericutils.FileLib;

public class Vtiger_Login_Page 
{
	@FindBy(name = "user_name")
	private WebElement username;
	
	@FindBy(name = "user_password")
	private WebElement password;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;
	
	public Vtiger_Login_Page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void Login_to_App() throws Throwable
	{
		FileLib flb = new FileLib();
		String unme = flb.getPropertyKeyValue("crm_username");
		String pwd = flb.getPropertyKeyValue("crm_password");
		getUsername().sendKeys(unme);
		getPassword().sendKeys(pwd);
		getLoginbtn().click();
	}
}
