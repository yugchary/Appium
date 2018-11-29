package com.qa.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.api.Android;
import com.qa.api.Ras;
import com.qa.managers.TestManager;

public class Functionality extends TestManager {
	
	private static Ras ras = Android.app.ras;
	
	@BeforeClass
    public static void beforeClass(){
		//System.out.println("in beforeClass");
		//ras.clearData();
        ras.open();
    }
	
	@Test
	public void test3() {
		testInfo.id("test3").suite("Functionality").name("Register the New User");
		ras.home.tapRegister();
		ras.home.registerUser();
	}
	
	@AfterClass
    public static void AfterClass(){
		//System.out.println("in beforeClass");
		ras.clearData();
        //ras.open();
    }

}
