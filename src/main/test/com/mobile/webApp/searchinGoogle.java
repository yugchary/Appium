package com.mobile.webApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.core.MyLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class searchinGoogle {

	AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();

	@BeforeClass
	public void setUP() throws MalformedURLException {

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		
		//cap.se
		
		//cap.setCapability("platformName", "Android");
		
		//cap.setCapability("platformVersion", "9");

		//cap.setCapability("avd", "PixelAnd9");
		
		//cap.setCapability("avd", "And7");
		
		cap.setCapability("avd", "And71");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void SampleTest() {

		Assert.assertNotNull(driver.getContext());

		System.out.println("Hello");
		System.out.println(driver.toString());
		
		System.out.println("test1");
		
		MyLogger.log.setLevel(Level.INFO);
		MyLogger.log.debug("Test Debug");
		MyLogger.log.info("Test info");
		MyLogger.log.warn("Test warn");
		MyLogger.log.fatal("Test fatal");

		// Click on DELETE/CLR button to clear result text box before running test.
		//driver.findElements(By.xpath("//android.widget.Button")).get(0).click();

		driver.get("https://www.google.co.in/");
		
		//driver.findElement(By.xpath("//input[@id='q']")).sendKeys("test");
		
		//driver.findElementByName("btnK");
		
		//driver.findElementByClassName("android.widget.EditText").sendKeys("test");
		
		driver.findElementByCssSelector("input.gLFyf").sendKeys("test");
		
		driver.findElementByCssSelector("button[aria-label='Google Search']").click();
		
		
		
		//driver.findElement(By.xpath("//*[@class='android.widget.EditText' and @index=0]")).sendKeys("test");
		
		//driver.findElement(By.xpath("//*[@name='lastname' and @id='lastname']")).sendKeys("yug.id");
		
		
		//driver.findElementByClassName("android.widget.Button").click();
		

		

	}
}
