import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileTestClass {
	
	static WebDriver driver;

	public static void main(String[] args)  	 {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "test");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "6.0.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.android.calculator2");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        try {
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        System.out.println("Hello");
        System.out.println(driver.toString());
        
        // Click on DELETE/CLR button to clear result text box before running test.
        //driver.findElements(By.xpath("//android.widget.Button")).get(0).click();

        // Click on number 2 button.
        driver.findElement(By.id("digit_7")).click();
		driver.findElement(By.id("op_add")).click();;
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("eq")).click();

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}

}
