package com.qa.core;

public class UiSelector {

	private String locator = "new UiSelector()";

	public UiSelector resourceId(String value) {
		//locator += ".resourceId("+"\\" + value + "\\"+")";
		locator += ".resourceId(\"" + value + "\")";
		return this;
	}

	public UiSelector text(String value) {
		locator += ".text(\"" + value + "\")";
		return this;
	}

	public UiSelector xPath(String xPath) {
		locator = xPath;
		return this;
	}

	public UiObject makeUiObject() {
		return new UiObject(locator);
	}
}
