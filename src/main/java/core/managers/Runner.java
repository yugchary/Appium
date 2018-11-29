package core.managers;

import java.net.MalformedURLException;

import org.apache.log4j.Level;


import com.qa.api.Android;
import com.qa.core.MyLogger;
import com.qa.core.UiSelector;
import com.qa.managers.DriverManager;
import com.qa.tests.TestPrimer;

public class Runner {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
				
		System.out.println("test1");
		
		MyLogger.log.setLevel(Level.INFO);
		MyLogger.log.debug("Test Debug");
		MyLogger.log.info("Test info");
		MyLogger.log.warn("Test warn");
		MyLogger.log.fatal("Test fatal");
	    
		
		try {
			DriverManager.CreateDriver();
			Android.app.ras.home.tapRegister();
			Android.app.ras.home.registerUser();
			
			
		}finally {
			//DriverManager.killDriver();
		}

	}

}
