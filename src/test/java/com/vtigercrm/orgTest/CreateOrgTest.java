package com.vtigercrm.orgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;

/**
 * @author hp
 *
 */
//@Listeners(com.vtigercrm.genericutils.ListImp.class)
public class CreateOrgTest extends Base_Class
{
	@Test
	public void createOrgTest() throws Throwable
	{
		/*Get data from test data*/
		String orgname = elb.getExcelData("org",1 , 2)+"_"+wdu.getRandomnumber();
		String orgtype = elb.getExcelData("org", 1, 3);
		String orgindus = elb.getExcelData("org", 1, 4);
		
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
	}
}
