package sample;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;
import com.vtigercrm.objectrepositoryLib.Create_Org_Page;

public class Sample extends Base_Class
{
	@Test
	public void test1()
	{
		Create_Org_Page corg = new Create_Org_Page(driver);
		corg.createorg("Test Yantra");
	}
}
