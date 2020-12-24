package com.brainyquote.authors;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetAllAuthors_Clickonspecific 
{
	@Test
	public void GetAllAuthors()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.brainyquote.com/authors");
		List<WebElement> authors = driver.findElements(By.xpath("//span[@class='authorContentName']"));
		for (WebElement we : authors) 
		{
			if(we.getText().equals("Abraham Lincoln"))
			{
				System.out.println(we.getText());
			}
		}
		driver.quit();
	}
}

