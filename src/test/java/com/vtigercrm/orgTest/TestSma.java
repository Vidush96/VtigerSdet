package com.vtigercrm.orgTest;

import org.testng.annotations.Test;

public class TestSma 
{
	@Test
	public void test()
	{
		System.out.println("step1");
		System.out.println("step2");
		mtd();
		System.out.println("step3");
		System.out.println("step4");
	}
	public void mtd()
	{
		System.out.println("mtdstep1");
		System.out.println("mtdstep2");
		System.out.println("mtdstep3");
	}
}
