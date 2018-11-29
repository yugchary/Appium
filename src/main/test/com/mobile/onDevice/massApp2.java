package com.mobile.onDevice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.qa.api.Android;
import com.qa.core.MyLogger;
import com.qa.core.UiObject;
import com.qa.core.UiSelector;
import com.qa.managers.DriverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class massApp2 {

	//AndroidDriver<WebElement> driver = null;
	AndroidDriver driver = null;
	

	@Ignore
	public void setUP1() throws MalformedURLException {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();


		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY322C3H2Q");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		// cap.setCapability(MobileCapabilityType.APPLICATION_NAME,
		// "com.android.calculator2.Calculator");

		cap.setCapability("platformName", "Android");

		cap.setCapability("appPackage", "com.example.ras");

		// Set android appActivity desired capability. It is
		// com.android.calculator2.Calculator for calculator application.
		// Set your application's appPackage if you are using any other app.
		cap.setCapability("appActivity", "com.example.com.mas_aa_sample.FullscreenActivity");

		// cap.setCapability(MobileCapabilityType.APPLICATION_NAME, value);

		// cap.setCapability("avd", "test3");
		cap.setCapability("avd", "And7");

		//driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

		Android.driver = driver;

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		MyLogger.log.setLevel(Level.DEBUG);
		

	}
	
	@BeforeTest
	public void setUP() throws MalformedURLException {
		
		//Android.driver = driver;
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		MyLogger.log.setLevel(Level.DEBUG);
		DriverManager.CreateDriver();
		//Android.adb.openAppsActivity("com.example.ras", "com.example.com.mas_aa_sample.FullscreenActivity");
		
	}

	@Test
	public void SampleTest() {

		try {

			//Assert.assertNotNull(driver.getContext());
			System.out.println("Hello");
			//System.out.println(driver.toString());		
			
			MyLogger.log.debug("Test Debug");
			MyLogger.log.info("Test info");
			MyLogger.log.warn("Test warn");
			MyLogger.log.fatal("Test fatal");

			

			//String locator = "new UiSelector().resourceId(\"com.example.ras:id/registertv\")";

			//Android.driver.findElementByAndroidUIAutomator(locator).click();

			UiObject register = new UiSelector().resourceId("com.example.ras:id/registertv").makeUiObject();	
			
			
						

			register.waitToAppear(30).tap();
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			if (driver != null)
				driver.quit();
		}

	}
}
