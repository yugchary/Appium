package com.mobile.nativeApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calc {

	AppiumDriver<WebElement> driver;
	AndroidDriver<MobileElement> driver1;
	DesiredCapabilities cap = new DesiredCapabilities();

	@BeforeClass
	public void setUP() throws MalformedURLException {

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		// cap.setCapability(MobileCapabilityType.APPLICATION_NAME,
		// "com.android.calculator2.Calculator");
		
		//cap.setCapability("platformName", "Android");
		
		//cap.setCapability("platformVersion", "7");

		cap.setCapability("appPackage", "com.android.calculator2");

		// Set android appActivity desired capability. It is
		// com.android.calculator2.Calculator for calculator application.
		// Set your application's appPackage if you are using any other app.
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");

		// cap.setCapability(MobileCapabilityType.APPLICATION_NAME, value);	

		//cap.setCapability("avd", "test3");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		//driver1 = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);

	}

	@Test
	public void SampleTest() {

		//Assert.assertNotNull(driver.getContext());

		System.out.println("Hello");
		//System.out.println(driver.toString());

		// Click on DELETE/CLR button to clear result text box before running test.
		//driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
		
		//driver.findElementByXPath("//android.widget.Button[3]").click();
		
		//driver.findElement(By.xpath("//*[@text='3']")).click();
		
		//FindsByAndroidUIAutomator
		
		//MobileElement topCharts = ((AndroidDriver<MobileElement>)driver1).findElementByAndroidUIAutomator("new UiSelector().text(\"3\")");
		
		//topCharts.click();
		
		
		
		
		//driver.findElement(By.xpath("//*[@text='6' and @index=5]")).click();
		
		
		
		///android.widget.GridLayout[1]/android.widget.Button[3]

		// Click on number 7 button.
		driver.findElement(By.id("digit_7")).click();
		
		//driver.findElementByName("7").click();
		//driver.findElement(By.name("7")).click();
		driver.findElementByAccessibilityId("plus").click();
		//driver.findElement(By.id("op_add")).click();
		driver.findElementByAccessibilityId("plus").click();
		
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("eq")).click();
		//driver.findElement(By.name("=")).click();
		
		String result = driver.findElementByClassName("android.widget.EditText").getText();
		
		if (result.contains("12"))
			System.out.println("it correct");
		else
			System.out.println("not correct");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
