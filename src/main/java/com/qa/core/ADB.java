package com.qa.core;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.qa.managers.ServerManager;

public class ADB {

	private String ID;

	public ADB(String deviceID) {
		ID = deviceID;
	}

	public static String command(String command) {

		MyLogger.log.debug("Formatting ADB Commands:" + command);

		if (command.startsWith("adb"))
			command = command.replace("adb ", ServerManager.getANDROID_HOME() + "/platform-tools/adb ");
		else
			throw new RuntimeException("this is adb cmd mgr only");

		MyLogger.log.debug("Formatted ADB Commands:" + command);

		String output = ServerManager.runCommand(command);
		MyLogger.log.debug("Output of the command" + output);
		if (output == null)
			return "";
		else
			return output;

	}
	
	public void uninstallApp(String packageID){
        command("adb -s "+ID+" uninstall "+packageID);
    }

	public void clearAppsData(String packageID) {
		command("adb -s " + ID + " shell pm clear " + packageID);
	}

	public void forceStopApp(String packageID) {
		command("adb -s " + ID + " shell am force-stop " + packageID);
	}

	public static void killServer() {
		command("adb kill-server");
	}

	public static ArrayList getConnectedDevices() {
		ArrayList devices = new ArrayList();
		String output = command("adb devices");
		for (String line : output.split("\n")) {
			line = line.trim();
			if (line.endsWith("device"))
				devices.add(line.replace("device", "").trim());
		}
		return devices;
	}
	
	public ArrayList getInstalledPackages(){
        ArrayList packages = new ArrayList();
        String[] output = command("adb -s "+ID+" shell pm list packages").split("\n");
        for(String packageID : output) packages.add(packageID.replace("package:","").trim());
        return packages;
    }


	public void installApp() {

	}

	public void unInstallApp() {

	}

	public void pullFile() {

	}

	public void takeScreenshot() {

	}

	public void getAndroidVersoin() {

	}

	public void openAppsActivity(String packageID, String activityID) {
		command("adb -s " + ID
				+ " shell am start -c api.android.intent.category.LAUNCHER -a api.android.intent.action.MAIN -n "
				+ packageID + "/" + activityID);
	}

	@Test
	public void test() {
		System.out.println(command("adb devices"));
	}

}
