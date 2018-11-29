package com.qa.core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.qa.api.Android;





public class UiObject {

	private String locator;	


	UiObject(String locator) {
		this.locator = locator;
		//System.out.println(this.locator);
		MyLogger.log.debug("Created new UiObject: " + this.locator);
	}

	private boolean isXpath() {
		return !locator.contains("UiSelector");
	}

	public boolean exists() {
		
		try {
			WebElement element;
			if (isXpath())
				element = Android.driver.findElementByXPath(locator);
			else
				element = Android.driver.findElementByAndroidUIAutomator(locator);			
			return element.isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}
		
	}

	public boolean isChecked() {
		WebElement element;
		if (isXpath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("checked").equals("true");
	}

	public String getResourceId() {
		WebElement element;
		if (isXpath())
			element = Android.driver.findElementByXPath(locator);
		else
			element = Android.driver.findElementByAndroidUIAutomator(locator);
		return element.getAttribute("resourceId");
	}
	
	public UiObject tap() {
		if (isXpath())	Android.driver.findElementByXPath(locator).click();
		else{
			//((AndroidDriver<WebElement>)driver).findElementByAndroidUIAutomator(locator).click();
			//topCharts = ((AndroidDriver<WebElement>)driver).findElementByAndroidUIAutomator(locator);
			//topCharts.click();
			Android.driver.findElementByAndroidUIAutomator(locator).click();
		}
		return this;
	}
	
	public UiObject typeText(String value) {
		if (isXpath())	Android.driver.findElementByXPath(locator).sendKeys(value);
		else	Android.driver.findElementByAndroidUIAutomator(locator).sendKeys(value);
		return this;
	}
	
	public UiObject waitToAppear(int seconds) {
		Timer timer = new Timer();
		timer.start();
		while(!timer.expired(seconds)) {
			//System.out.println("timer"+timer);
			if (exists()) { 
				//System.out.println("exists"+exists());
				break;}
			if(timer.expired(seconds) && !exists()) throw new AssertionError("Element " +locator+" failed to appear wihtin "+seconds+"seconds");}
		return this;
	}
	
	public UiObject waitToDisappear(int seconds){
		Timer timer = new Timer();
		timer.start();
		while(!timer.expired(seconds)) { if (!exists()) break;
		if(timer.expired(seconds) && exists()) throw new AssertionError("Element " +locator+" failed to disappear wihtin "+seconds+"seconds");}
		return this;
	}

}
