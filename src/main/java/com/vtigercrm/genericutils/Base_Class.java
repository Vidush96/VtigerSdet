package com.vtigercrm.genericutils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
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
public class Base_Class implements ITestListener
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
	/*@BeforeClass
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
	}*/
	@Parameters("port")
	@BeforeTest
	public void configBT(String port) throws MalformedURLException
	{
		switch (port) 
		{
		case "5555":
			String node_URL = "http://192.168.225.133:4444/wd/hub";
			System.out.println("Chrome Browser initiated");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setVersion("84.0.4147.135");
			capabilities.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(node_URL), capabilities);
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;

		default:
			break;
		}
	}
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
	@AfterTest
	public void configAT()
	{
		driver.quit();
	}
	/*@AfterClass
	public void configAC()
	{
		//Close the browser
		driver.quit();
	}*/
	@AfterSuite
	public void configAS()
	{
		/*Disconnect from db*/
	}
}
