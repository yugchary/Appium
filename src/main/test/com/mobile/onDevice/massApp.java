package com.mobile.onDevice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api.Android;
import com.qa.core.UiObject;
import com.qa.core.UiSelector;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class massApp {

	AppiumDriver<WebElement> driver;
	AndroidDriver<MobileElement> driver1;
	DesiredCapabilities cap = new DesiredCapabilities();
	WebElement topCharts;

	@BeforeClass
	public void setUP() throws MalformedURLException {

		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY322C3H2Q");
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

		//cap.setCapability("avd", "test3");
		cap.setCapability("avd", "And7");


		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		//driver1 = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void SampleTest() {

		Assert.assertNotNull(driver.getContext());

		System.out.println("Hello");
		System.out.println(driver.toString());

		driver.findElementById("registertv").click();
		
		//MobileElement topCharts = ((AndroidDriver<MobileElement>)driver1).findElementByAndroidUIAutomator("new UiSelector().text(\"3\")");
		
		String locator = "new UiSelector().resourceId(\"com.example.ras:id/registertv\")";		
		//Android.driver.findElementByAndroidUIAutomator(locator).click();
		
		topCharts = ((AndroidDriver<WebElement>)driver).findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.example.ras:id/registertv\")");
		
		//topCharts = ((AndroidDriver<WebElement>)driver).findElementByAndroidUIAutomator(locator);
		
		
		//MobileElement topCharts = ((AndroidDriver<MobileElement>)driver1).findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.example.ras:id/registertv\")");
		
		topCharts.click();
		
		UiObject register = new UiSelector().resourceId("com.example.ras:id/registertv").makeUiObject();
		
		UiObject x = register.tap();
		
		
		

		

	}
}
