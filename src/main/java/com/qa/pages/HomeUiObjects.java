package com.qa.pages;

import com.qa.core.MyLogger;
import com.qa.core.UiObject;
import com.qa.core.UiSelector;

public class HomeUiObjects {
	
	private static UiObject 
		register,
		contactUs,
		branchesNearBy,
		atmsNearBy,
		Login,
		Logo;
	
	public UiObject register() {
		if(register == null) register = new UiSelector().text("Register").makeUiObject();
		return register;
	}
	
	public UiObject contactUs() {
		if(contactUs == null) contactUs = new UiSelector().text("Contact Us").makeUiObject();
		return contactUs;
	}
	
	public UiObject branchesNearBy() {
		if(branchesNearBy == null) branchesNearBy = new UiSelector().text("Branches NearBy").makeUiObject();
		return branchesNearBy;
	}
	
	public UiObject atmsNearBy() {
		if(atmsNearBy == null) atmsNearBy = new UiSelector().text("ATMs NearBy").makeUiObject();
		return atmsNearBy;
	}
	
	public UiObject Login() {
		if(Login == null) Login = new UiSelector().text("LOGIN").makeUiObject();
		return Login;
	}
	

	

}
