package com.vtigercrm.genericutils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author hp
 *
 */
public class FileLib 
{
	/**
	 * used to get data from property file based on key
	 * @param key
	 * @return property value based on Key
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testData/Commondata.properties");
		Properties pojt = new Properties();
		pojt.load(fis);
		String proValue = pojt.getProperty(key);
		
		return proValue;
	}
}
