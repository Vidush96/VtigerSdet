package com.brainyquote.authors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetTagsOrQuotesOf_Specific_Author 
{
	@Test
	public void getTagsOrQuotesOf_Specific_Author()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.brainyquote.com/authors");
		List<WebElement> authors = driver.findElements(By.xpath("//span[@class='authorContentName']"));
		for (WebElement we : authors) 
		{
			if(we.getText().equals("Abraham Lincoln"))
			{
				System.out.println(we.getText());
				we.click();
				 List<WebElement> tags = driver.findElements(By.xpath("//a[@class='qkw-btn btn btn-xs oncl_list_kc']"));
				 for (WebElement wetgs : tags) 
				 {
					 if(wetgs.getText().equals("You"))
					 {
						 wetgs.click();
					 }
				 }
			}
		}
		driver.quit();
	}
}
