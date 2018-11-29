package com.qa.pages;

import org.openqa.selenium.NoSuchElementException;

import com.qa.api.Activity;
import com.qa.api.Android;
import com.qa.core.MyLogger;
import com.qa.core.UiObject;
import com.qa.core.UiSelector;

public class HomePage implements Activity {
	public HomeUiObjects uiObject = new HomeUiObjects();

	public void tapRegister() {
		try {
			MyLogger.log.info("Tapping Register button");
			uiObject.register().tap();
		} catch (NoSuchElementException e) {
			throw new AssertionError("Cant tap the Register button, element absent or bloced");
		}
	}
	
	public void registerUser() {
		MyLogger.log.info("Registering new user");		
		UiObject test = new UiSelector().text("Register CA Auth ID").makeUiObject();
		test.tap();
		
	
	}

	@Override
	public HomePage waitToLoad() {
		// TODO Auto-generated method stub
		try {
			MyLogger.log.info("Waiting for the Register Activity");
			uiObject.register().waitToAppear(5);
			return Android.app.ras.home;
		} catch (AssertionError e) {
			throw new AssertionError("Register Activity fail to load");
		}
	}

}
