package com.vtigercrm.orgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;

/**
 * @author hp
 *
 */
public class CreateOrgAndDeleteOrgTest extends Base_Class
{
	@Test
	public void createOrgAndDeleteOrgTest() throws Throwable
	{
		/*Get data from test data*/
		String orgname = elb.getExcelData("org",4 , 2)+"_"+wdu.getRandomnumber();
		String orgtype = elb.getExcelData("org", 4, 3);
		String orgindus = elb.getExcelData("org", 4, 4);
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
		
		/*Navigate to org page and verify org is present*/
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement eleseachorgIn = driver.findElement(By.name("search_field"));
		wdu.select(eleseachorgIn, orgIN);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		WebElement actorgnme = driver.findElement(By.linkText(orgname));
		Assert.assertTrue(actorgnme.getText().contains(orgname));
		/*Delete org*/
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		driver.findElement(By.linkText("del")).click();
		wdu.alertOk(driver);
		WebElement msg = driver.findElement(By.xpath("//span[contains(.,'No Contact Found !')]"));
		Assert.assertTrue(msg.isDisplayed());
	}
}
