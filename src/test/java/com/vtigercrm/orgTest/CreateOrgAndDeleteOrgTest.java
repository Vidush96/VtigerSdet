package com.vtigercrm.orgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;
import com.vtigercrm.objectrepositoryLib.Common_Components;
import com.vtigercrm.objectrepositoryLib.Create_Org_Page;
import com.vtigercrm.objectrepositoryLib.Home_Page;
import com.vtigercrm.objectrepositoryLib.Organizations_Page;

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
		Home_Page hp = new Home_Page(driver);
		hp.getOrglink().click();
		
		/*navigate to create org page*/
		Organizations_Page Op = new Organizations_Page(driver);
		Op.getCreateorg().click();
		
		/*create org and verify*/
		Create_Org_Page cop = new Create_Org_Page(driver);
		Common_Components cc = new Common_Components(driver, orgname);
		cop.getOrgnameedit().sendKeys(orgname);
		cop.getOrgindus().sendKeys(orgindus);
		wdu.select(cop.getOrgtype(), orgtype);
		cop.getSavebtn();
		Assert.assertTrue(cc.getHeadername().getText().contains(orgname));
		
		/*Navigate to org page and verify org is present*/
		hp.getOrglink().click();
		cc.getSearchtextbox().sendKeys(orgname);
		wdu.select(cc.getSearchbyfield(), orgIN);
		cc.getSubmit_search();
		WebElement actorgnme = driver.findElement(By.linkText(orgname));
		Assert.assertTrue(actorgnme.getText().contains(orgname));
	}
}
