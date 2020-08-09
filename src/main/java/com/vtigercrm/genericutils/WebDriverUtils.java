package com.vtigercrm.genericutils;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author hp
 *
 */
public class WebDriverUtils 
{
	/**
	 * Wait for all elements to load in DOM Document
	 * @param driver
	 */
	public void waitForToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/**
	 * Wait for specific element until it is visible
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver, int seconds,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Wait for page tutle to be available
	 * @param driver
	 * @param seconds
	 * @param title
	 */
	public void waitPageTitleVisibility(WebDriver driver, int seconds, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * Wait for any element
	 * @param driver
	 * @param expelement
	 * @return flag
	 * @throws InterruptedException
	 */
	public boolean waitForAnyElement(WebDriver driver, WebElement expelement) throws InterruptedException
	{
		boolean flag=false;
		int count=0;
		while(count<=30)
		{
			try
			{
				expelement.isDisplayed();
				flag=true;
				break;
			}
			catch (Throwable t) 
			{
				count++;
				Thread.sleep(1000);
			}
		}
		return flag;
	}
	
	/**
	 * Wait and click on element
	 * @param driver
	 * @param expelement
	 * @return
	 * @throws InterruptedException
	 */
	public boolean waitForClickElement(WebDriver driver, WebElement expelement) throws InterruptedException
	{
		boolean flag=false;
		int count=0;
		while(count<=30)
		{
			try
			{
				expelement.click();;
				flag=true;
				break;
			}
			catch (Throwable t) 
			{
				count++;
				Thread.sleep(1000);
			}
		}
		return flag;
	}
	
	/**
	 * Select value from dropdown based on visible text
	 * @param dropdwnelement
	 * @param text
	 */
	public void select(WebElement dropdwnelement,String text)
	{
		Select sle = new Select(dropdwnelement);
		sle.selectByVisibleText(text);
	}
	
	/**
	 * Select value from dropdown based on index
	 * @param dropdwnelement
	 * @param index
	 */
	public void select(WebElement dropdwnelement,int index)
	{
		Select sle = new Select(dropdwnelement);
		sle.selectByIndex(index);
	}
	
	/**
	 * Move to mouse to Specific Target element
	 * @param driver
	 * @param tarelement
	 */
	public void moveMouseToElement(WebDriver driver, WebElement tarelement)
	{
		Actions act = new Actions(driver);
		act.moveToElement(tarelement).perform();
	}
	
	/**
	 * Double Click on target element
	 * @param driver
	 * @param tarelement
	 */
	public void doubleclick(WebDriver driver,WebElement tarelement)
	{
		Actions act = new Actions(driver);
		act.doubleClick(tarelement).perform();
	}
	/**
	 * Rightclick on an element
	 * @param driver
	 * @param element
	 */
	public void rightClcik(WebDriver driver , WebElement element) {
   	 Actions act= new Actions(driver);
   	 act.contextClick(element).perform();
   			 
    }
	
	/**
	 * Switch to window based on pagetitle
	 * @param driver
	 * @param pageTitle
	 */
	public void switchtowindow(WebDriver driver, String pageTitle)
	{
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		while(it.hasNext())
		{
			String winID = it.next();
			driver.switchTo().window(winID);
			String currentpagetitle = driver.getTitle();
			if(currentpagetitle.contains(pageTitle))
				break;
		}
	}
	
	/**
	 * Click OK in Alert
	 * @param driver
	 */
	public void alertOk(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Click Cancel in Alert
	 * @param driver
	 */
	public void alertCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * Generates random numbers within 1000
	 * @return
	 */
	public int getRandomnumber()
	{
		Random ranojt= new Random();
		int no = ranojt.nextInt(1000);
		return no;
	}
	/**
	 * Switch to frame based on Name Or Id attribute
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * Switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * Switch to frame based on frame Element address
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
}
