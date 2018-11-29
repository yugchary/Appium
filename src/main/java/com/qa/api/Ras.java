package com.qa.api;

import com.qa.pages.HomePage;

public class Ras implements Application{
	
	public HomePage home = new HomePage();
	
	@Override
	public void forceStop() {
		Android.adb.forceStopApp(packageID());		
	}

	@Override
	public void clearData() {
		Android.adb.clearAppsData(packageID());		
	}

	@Override
	public Object open() {
		// TODO Auto-generated method stub
		Android.adb.openAppsActivity(packageID(), activityID());
		return null;
	}

	@Override
	public String packageID() {
		// TODO Auto-generated method stub
		return "com.example.ras";
	}

	@Override
	public String activityID() {
		// TODO Auto-generated method stub		
		return "com.example.com.mas_aa_sample.FullscreenActivity";
	}

}
