package com.qa.core;

import java.util.Date;

public class Timer {
	public long startStamp;
	
	public void start() {
		startStamp = getTimeStamp();
	}

	public static long getTimeStamp() {
		// TODO Auto-generated method stub
		return new Date().getTime();
	}
	
	public boolean expired(int seconds) {
		int diff = (int) ((getTimeStamp()-startStamp)/1000);
		//System.out.println("time diff" + diff);
		boolean x = diff > seconds;
		//System.out.println("time flag" + x);
		return x;
	}

}
