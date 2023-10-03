package liveProject;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
public class Activity2 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {

  	//Set desired capabilites
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Emulator_Pixel");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        //set appium address

        URL serverURL=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverURL,options);
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @Test
    public void CreateGoggleKeep(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("new_note_button")));


        driver.findElement(AppiumBy.id("new_note_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Note one");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("description for Note");

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.AccessibilityId("Open navigation drawer")));
        driver.findElement(AppiumBy.accessibilityId("\t\n" +
                "Open navigation drawer")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("index_note_title")));
       String noteText= driver.findElement(AppiumBy.id("index_note_title")).getText();
        Assert.assertEquals("Note one",noteadded);
    }
}
