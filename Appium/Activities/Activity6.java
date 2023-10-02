package Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {

    AndroidDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

  	 //set appium address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // navigate to URL
        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }

    // Test method
    @Test
    public void chromeTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";


        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));

        List<WebElement> numberOfImages = driver.findElements(AppiumBy.className("android.widget.Image"));
    	System.out.println("Number of image shown currently: " + numberOfImages.size());
 	assertEquals(numberOfImages.size(), 4);
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"helen\")"));


        numberOfImages = driver.findElements(AppiumBy.className("android.widget.Image"));

 	System.out.println("Number of image shown currently: " + numberOfImages.size());

      assertEquals(numberOfImages.size(), 4);
    }



    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}