package Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {

    AndroidDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();

	URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void addContact() {

        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
       wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text='First name']")
        ));
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='First name']"
        )).sendKeys("Test");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Last name']"
        )).sendKeys("Automation");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Phone']"
        )).sendKeys("123456789");
        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));

        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contactName, "Test Automation");
    }


    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}