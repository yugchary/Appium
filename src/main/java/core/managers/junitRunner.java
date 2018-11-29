package core.managers;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;


import com.qa.core.MyLogger;
import com.qa.core.Reporter;
import com.qa.managers.DriverManager;
import com.qa.managers.TestManager;
import com.qa.tests.TestPrimer;

public class junitRunner {

	public static void main(String[] args) throws MalformedURLException, ParserConfigurationException {
		// TODO Auto-generated method stub
				
		System.out.println("test1");
		
		MyLogger.log.setLevel(Level.INFO);
		MyLogger.log.debug("Test Debug");
		MyLogger.log.info("Test info");
		MyLogger.log.warn("Test warn");
		MyLogger.log.fatal("Test fatal");
		String xmlLocation = "C:\\Users\\akkyu01\\Documents\\result_" + new Date().getTime()+ ".xml";
		TestManager.setReporter(new Reporter(new File(xmlLocation)));
	    
		
		try {
			
			//DriverManager.startServer();
			DriverManager.CreateDriver();
			JUnitCore.runClasses(TestPrimer.class);
			MyLogger.log.fatal("In block");
			
		
			
			
		}finally {
			DriverManager.killDriver();
		}

	}

}
