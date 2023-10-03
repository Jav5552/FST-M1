package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity7 {

	WebDriver driver;

	  @BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/login-form");
	  }
	  
	  @DataProvider(name="Authentication")
	  public static Object[][] credentials(){
		  return new Object[][] {{"admin","password"}};
	  }
	  
	  @Test(dataProvider = "Authentication")
	  public void login(String Username,String Password) {
		  WebElement usernameField = driver.findElement(By.id("username"));
	      WebElement passwordField = driver.findElement(By.id("password"));
	      
	      usernameField.sendKeys(Username);
	      passwordField.sendKeys(Password);
	      
	      driver.findElement(By.cssSelector("button[type='submit']")).click();
	      
	      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	      Assert.assertEquals(loginMessage, "Welcome Back, admin");
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
}
