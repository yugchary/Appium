package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import com.qa.api.Android;
import com.qa.api.Ras;

import com.qa.managers.TestManager;

public class Navigation extends TestManager {
	
	private static Ras ras = Android.app.ras;
	
	@BeforeClass
    public static void beforeClass(){
		//System.out.println("in beforeClass");
		//ras.clearData();
        ras.open();
    }
	
	@Before
	public void before() {
		testInfo.suite("Navigation");
		//ras.home.tapRegister();
		//Android.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		
	}
	
	@Test
	public void test1() {
		testInfo.id("test1").name("Verify that Home Activity has all the elements");
		ras.home.uiObject.register().waitToAppear(10);
		Assert.assertTrue(ras.home.uiObject.register().exists());
		Assert.assertTrue(ras.home.uiObject.Login().exists());
		Assert.assertTrue(ras.home.uiObject.atmsNearBy().exists());
		Assert.assertTrue(ras.home.uiObject.branchesNearBy().exists());		
		Assert.assertTrue(ras.home.uiObject.contactUs().exists());	
	}
	
	@Test
	public void test2() {
		testInfo.id("test2").name("Verify that Registration Activity has all the elements");
	}
	
	
	@AfterClass
    public static void AfterClass(){
		//System.out.println("in beforeClass");
		ras.clearData();
        //ras.open();
    }

}
