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

public class Activity3 {

    AndroidDriver driver;


    @BeforeClass
    public void setUp() throws MalformedURLException {
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
  public void add() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("op_add").click();
	  driver.findElementById("digit_9").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"14");
	  }
  
  @Test
  public void subtract() {
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("op_sub").click();
	  driver.findElementById("digit_5").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"5");
	 
  }
  
  @Test
  public void mul() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("op_mul").click();
	  driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"500");
	 
  }
  
  @Test
  public void div() {
	  driver.findElementById("digit_5").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("op_div").click();
	  driver.findElementById("digit_2").click();
	  driver.findElementByAccessibilityId("equals").click();
	  String resultText= driver.findElementById("result").getText();
	  System.out.println(resultText);
	  
	  assertEquals(resultText,"25");
	 
  }



    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}