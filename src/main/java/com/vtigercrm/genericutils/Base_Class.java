package com.vtigercrm.genericutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtigercrm.objectrepositoryLib.Vtiger_Login_Page;


/**
 * @author hp
 *
 */
public class Base_Class 
{
	public FileLib flb =new FileLib();
	public ExcelLib elb = new ExcelLib();
	public WebDriverUtils wdu = new WebDriverUtils();
	public WebDriver driver;
	
	@BeforeSuite
	public void configBS()
	{
		/*Connect to db*/
	}
	@BeforeClass
	public void configBC() throws Throwable
	{
		String Browser = flb.getPropertyKeyValue("browser");
		switch (Browser) 
		{
		case "chrome":
			driver= new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;

		default:
			break;
		}
	}
	/*@Parameters("browser")
	@BeforeTest
	public void configBT(String browser)
	{
		switch (Browser) 
		{
		case "chrome":
			driver= new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;

		default:
			break;
		}
	}*/
	@BeforeMethod
	public void configBM() throws Throwable
	{
		String URL = flb.getPropertyKeyValue("url");
		
		/*Launch app*/
		wdu.waitForToLoad(driver);
		driver.get(URL);
		
		/*Login to app*/
		Vtiger_Login_Page LP = new Vtiger_Login_Page(driver);
		LP.Login_to_App();
		
	}
	@AfterMethod
	public void configAM()
	{
		/*signout*/
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wdu.moveMouseToElement(driver, wb);
		driver.findElement(By.linkText("Sign Out")).click();
	}
	/*@AfterTest
	public void configAT()
	{
		driver.quit();
	}*/
	@AfterClass
	public void configAC()
	{
		/*Close the browser*/
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		/*Disconnect from db*/
	}
}
