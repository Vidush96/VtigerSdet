package sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;

public class Get_Lead_details extends Base_Class
{
	@Test
	public void getdetails()
	{
		driver.findElement(By.linkText("Leads")).click();
		String ele = driver.findElement(By.xpath("//td[.='Lead No']/../following-sibling::tr[2]")).getText();
		System.out.println(ele);
	}
}
