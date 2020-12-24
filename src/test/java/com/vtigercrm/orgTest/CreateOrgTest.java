package com.vtigercrm.orgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtigercrm.genericutils.Base_Class;
import com.vtigercrm.objectrepositoryLib.Create_Org_Page;
import com.vtigercrm.objectrepositoryLib.Home_Page;
import com.vtigercrm.objectrepositoryLib.Organization_Info_Page;
import com.vtigercrm.objectrepositoryLib.Organizations_Page;

/**
 * @author hp
 *
 */
//@Listeners(com.vtigercrm.genericutils.ListImp.class)
public class CreateOrgTest extends Base_Class {
	@Test
	public void createOrgTest() throws Throwable {
		/* Get data from test data */
		String orgname = elb.getExcelData("org", 1, 2) + "_" + wdu.getRandomnumber();
		String orgtype = elb.getExcelData("org", 1, 3);
		String orgindus = elb.getExcelData("org", 1, 4);
		String orgIN = elb.getExcelData("contact", 4, 7);

		/* navigate to org page */
		Home_Page hp = new Home_Page(driver);
		hp.getOrglink().click();

		/* navigate to create org page */
		Organizations_Page op = new Organizations_Page(driver);
		op.search_click(orgname, orgIN);
		/*
		 * op.getCreateorg().click();
		 * 
		 * create org Create_Org_Page cop =new Create_Org_Page(driver);
		 * cop.createorg(orgname); verify org created Organization_Info_Page oip = new
		 * Organization_Info_Page(driver); String actualorgname =
		 * oip.getHeadername().getText();
		 * Assert.assertTrue(actualorgname.contains(orgname));
		 */
	}
}
