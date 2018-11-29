package com.qa.core;

import io.appium.java_client.service.local.flags.ServerArgument;

public enum Arg implements ServerArgument{
	
	TIMEOUT("--command-timeout"),
	LOG_LEVEL("--log-level");
	
	private final String arg;
	
	Arg(String arg){
		this.arg = arg;
	}

	@Override
	public String getArgument() {
		// TODO Auto-generated method stub
		return arg;
	}

}
