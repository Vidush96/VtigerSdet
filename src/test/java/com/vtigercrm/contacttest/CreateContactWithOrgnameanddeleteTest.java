package com.vtigercrm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;

/**
 * @author hp
 *
 */
public class CreateContactWithOrgnameanddeleteTest extends Base_Class
{
	@Test
	public void createContactWithOrgnameanddeletetest()throws Throwable
	{
		
		/*Get data from test data*/
		String orgname = elb.getExcelData("contact",4 , 2)+"_"+wdu.getRandomnumber();
		String orgtype = elb.getExcelData("contact", 4, 3);
		String orgindus = elb.getExcelData("contact", 4, 4);
		String contactlname = elb.getExcelData("contact", 4,5)+"_"+wdu.getRandomnumber();
		String mainpagetitle = elb.getExcelData("contact", 4, 9);
		String lookuppagetitle = elb.getExcelData("contact",4 , 8);
		String IN = elb.getExcelData("contact", 4, 6);
		String orgIN = elb.getExcelData("contact", 4, 7);
		
		/*navigate to org page*/
		driver.findElement(By.linkText("Organizations")).click();
		
		/*navigate to create org page*/
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/*create org and verify*/
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement eleorgtype = driver.findElement(By.name("accounttype"));
		wdu.select(eleorgtype, orgtype);
		WebElement eleorgindus = driver.findElement(By.name("industry"));
		wdu.select(eleorgindus, orgindus);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String actualorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actualorgname.contains(orgname));
		
		/*navigate to contacts*/
		driver.findElement(By.linkText("Contacts")).click();
		
		/*navigate to create contact*/
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		/*create contact and verify*/
		driver.findElement(By.name("lastname")).sendKeys(contactlname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		/*select org in look up window*/
		wdu.switchtowindow(driver, lookuppagetitle);
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgname)).click();
		wdu.switchtowindow(driver, mainpagetitle);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actconname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actconname.contains(contactlname));
		
		/*navigate to contact page*/
		driver.findElement(By.linkText("Contacts")).click();
		
		/*Search for contact*/
		driver.findElement(By.name("search_text")).sendKeys(contactlname);
		WebElement eleseachIn = driver.findElement(By.name("search_field"));
		wdu.select(eleseachIn, IN);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		/*delete contact*/
		driver.findElement(By.linkText(contactlname)).click();
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		wdu.alertOk(driver);
		/*verify Contact deleted*/
		driver.findElement(By.name("search_text")).sendKeys(contactlname);
		wdu.select(eleseachIn, IN);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement msg = driver.findElement(By.xpath("//span[contains(.,'No Contact Found !')]"));
		Assert.assertTrue(msg.isDisplayed());
		
		/*Navigate to org page and verify org is present*/
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement eleseachorgIn = driver.findElement(By.name("search_field"));
		wdu.select(eleseachorgIn, orgIN);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement actorgnme = driver.findElement(By.linkText(orgname));
		Assert.assertTrue(actorgnme.getText().contains(orgname));
		/*Delete org*/
		driver.findElement(By.linkText(orgname)).click();
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		wdu.alertOk(driver);
		Assert.assertTrue(msg.isDisplayed());
		
		/*Navigate to org page and verify org is deleted*/
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		wdu.select(eleseachorgIn, orgIN);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Assert.assertTrue(actorgnme.getText().contains(orgname));
		Assert.assertTrue(msg.isDisplayed());
	}
}
