package com.qa.managers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import com.qa.api.Android;
import com.qa.core.ADB;
import com.qa.core.Arg;
import com.qa.core.MyLogger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class DriverManager {
	private static HashMap<String, URL> hosts;
	private static DriverService service;
	private static String nodeJS = "C:\\Program Files\\nodejs\\node.exe";
	//private static String AppiumJS = "C:\\Users\\akkyu01\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\lib\\appium.js";
	private static String appiumJS = "C:\\Users\\akkyu01\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	private static AppiumDriverLocalService service1;
	//private static String unlockPackage = "io.appium.unlock";
	private static String unlockPackage = "io.appium.settings";
	private static String deviceID;
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	private static DesiredCapabilities getCaps(String deviceID) {
		MyLogger.log.info("Creating driver caps for device: " + deviceID);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceID);
		caps.setCapability("platformName", "Android");
		//caps.setCapability("appPackage", "com.example.ras");
		//caps.setCapability("appActivity", "com.example.com.mas_aa_sample.FullscreenActivity");
		caps.setCapability("app", "C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Appium\\RAS2.5 APK\\settings_apk-debug.apk");
		caps.setCapability("avd", "NexusAnd7");
		return caps;
	}

	private static URL host(String deviceID) throws MalformedURLException {
		if (hosts == null) {
			hosts = new HashMap<>();
			hosts.put("emulator-5554", new URL("http://0.0.0.0:4723/wd/hub"));
		}
		return hosts.get(deviceID);
	}

	private static AppiumDriverLocalService createService1() throws NumberFormatException, MalformedURLException {
		service1 = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodeJS))
				.withAppiumJS(new File(appiumJS))
				.withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
				.usingPort(Integer.parseInt(host(deviceID).toString().split(":")[2].replace("/wd/hub", "")))
				.withArgument(Arg.LOG_LEVEL, "INFO"));
				
		
		//AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
				
		return service1;
		
	}
	
	 private static DriverService createService() throws MalformedURLException {
	        service = new AppiumServiceBuilder()
	                .usingDriverExecutable(new File(nodeJS))
	                .withAppiumJS(new File(appiumJS))
	                .withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
	                .usingPort(Integer.parseInt(host(deviceID).toString().split(":")[2].replace("/wd/hub","")))
	                .withArgument(Arg.TIMEOUT, "120")
	                .withArgument(Arg.LOG_LEVEL, "warn")
	                .build();
	        return service;
	    }
	
	public static void startServer() {
		//Set Capabilities
		AppiumDriverLocalService service;
		AppiumServiceBuilder builder;
		DesiredCapabilities cap;
		
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");
		
		//Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		
		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	private static ArrayList<String> getAvailableDevices() {
		MyLogger.log.info("Checking for available devices");
		ArrayList<String> avaiableDevices = new ArrayList<String>();
		ArrayList connectedDevices = ADB.getConnectedDevices();
		for (Object connectedDevice : connectedDevices) {
			String device = connectedDevice.toString();
			ArrayList apps = new ADB(device).getInstalledPackages();
			if (!apps.contains(unlockPackage))
				avaiableDevices.add(device);
			else
				MyLogger.log.info("Device: " + device + " has " + unlockPackage + " installed, assuming it is under testing");
		}
		if (avaiableDevices.size() == 0)
			throw new RuntimeException("Not a single device is available for testing at this time");
		return avaiableDevices;
	}

	public static void CreateDriver() throws MalformedURLException {
		//Android.adb = new ADB("emulator-5554");
		
		
		//Android.adb.uninstallApp(unlockPackage);
		ArrayList<String> devices = getAvailableDevices();
		
		for(String device : devices) {
			try {
				deviceID = device;
				MyLogger.log.info("Trying to create new Driver for device");
				createService().start();
				Android.driver = new AndroidDriver(host(device), getCaps(device));
				Android.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				Android.adb = new ADB(device);
			}catch(Exception e) {
				e.printStackTrace();
				//Ignore and try next device
			}
		}
		
		

	}

	public static void killDriver() {
		if (Android.driver != null) {
			MyLogger.log.info("Killing Android Driver");
			Android.driver.quit();
			Android.adb.uninstallApp(unlockPackage);			
			service.stop();
		} else
			MyLogger.log.info("Android Driver is not initialized, nothing to kill");
	}

}
