package Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
	//Set desired capabilites
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

 	//Set appium address

        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);


        driver.get("https://www.trainig-support.net");
	
	wait = new WebDriverWait(driver, 10);
    }

    // Test method
    @Test
    public void getTheTitleOfPage() {

    	   	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		// launch and open url in chrome browser
		driver.get("https://www.training-support.net/");
		String title=driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		System.out.println(title);
		// Click about us link
		driver.findElementByXPath("//android.view.View[@content-desc='About Us']").click();
        	String newtitle =driver
                .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")
                .getText();
 
        System.out.println("Title on new page: " + newtitle);
    }



    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}