package com.qa.api;

public interface Application {

	void forceStop();
	void clearData();
	Object open();
	String packageID();
	String activityID();
}
