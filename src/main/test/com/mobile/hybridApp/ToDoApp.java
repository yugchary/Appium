package com.mobile.hybridApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import core.managers.UiSelector;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ToDoApp {

	AppiumDriver<WebElement> driver;
	AndroidDriver<MobileElement> driver1;
	
	DesiredCapabilities cap = new DesiredCapabilities();

	@BeforeClass
	public void setUP() throws MalformedURLException {

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		// cap.setCapability(MobileCapabilityType.APPLICATION_NAME,
		// "com.android.calculator2.Calculator");
		
		//cap.setCapability(app, value);
		
		

		cap.setCapability("appPackage", "io.ionic.starter");
		
		cap.setCapability("appActivity", "io.ionic.starter.MainActivity");

		// Set android appActivity desired capability. It is
		// com.android.calculator2.Calculator for calculator application.
		// Set your application's appPackage if you are using any other app.
	

		// cap.setCapability(MobileCapabilityType.APPLICATION_NAME, value);

		//cap.setCapability("avd", "NexusAnd9");
		
		//cap.setCapability("avd", "PixelAnd9");
		
		//cap.setCapability("avd", "And9");
		
		cap.setCapability("avd", "And71");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		
		driver1 = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void SampleTest() throws InterruptedException {

		Assert.assertNotNull(driver.getContext());

		System.out.println("Hello");
		System.out.println(driver.toString());

		// Click on DELETE/CLR button to clear result text box before running test.
		//driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
		
		//Thread.sleep(10000);
		
		driver.context("WEBVIEW_io.ionic.starter");
		
		//driver.findElementByName("add").click();
		
		//driver.findElement(By.xpath("//span/ion-icon[@name='add']")).click();
		
		//MobileElement topCharts = ((AndroidDriver<MobileElement>)driver1).findElementByAndroidUIAutomator("new UiSelector().text(\"3\")");
		
		
		
		
		//android.view.View[contains(@content-desc,'completed')] 
		//driver.findElement(By.xpath("//android.widget.Button[contains(@content-desc,'add')]")).click();
		
		
		
		Thread.sleep(10000);
		
		//driver.findElements(By.xpath("//android.widget.Button")).get(1).click();
		
		driver.findElement(By.xpath("//button/span/ion-icon[@name='add']")).click();
		
		

		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
}
