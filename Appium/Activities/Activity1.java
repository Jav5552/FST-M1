package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity1 {

    WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {

        //Set desired capabilites
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        //set appium address

        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);


    }
    @Test
    public void calculatorTest(){
        //find digit 5 and tap
        WebElement digitFive=driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5"));
        digitFive.click();
        //find mul and tap
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        //find digit 5 and tap
        digitFive.click();
        //find equals and tap
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        //capture result
        String result=driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();

        //assertion

        assertEquals("25",result);

    }
    @AfterClass

    public void tearDown(){

        driver.quit();
    }

}
