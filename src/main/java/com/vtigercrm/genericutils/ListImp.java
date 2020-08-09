package com.vtigercrm.genericutils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author hp
 *
 */
public class ListImp implements ITestListener
{
	WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result)
	{
		Date d = new Date();
		String currentdate = d.toString().replace(" ", "_").replace(":","_");
		
		String testmethodnme = result.getMethod().getMethodName();
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		String dstFile = "./screenShot/"+testmethodnme+"_"+currentdate+".png";
		try {
			FileUtils.copyFile(srcFile, new File(dstFile));
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
