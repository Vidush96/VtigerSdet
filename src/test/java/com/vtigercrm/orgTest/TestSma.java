package com.vtigercrm.orgTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;

public class TestSma extends Base_Class
{
	@Test
	public void test()
	{
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//td[@class='searchUIName small']/..//select"));
		for (WebElement we : ele) 
		{
			if(we.getText().contains("Organization Name"))
			{
				System.out.println(we.getText());
				we.click();
			break;
			}
		}
	}
}
