package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
public class Activity10 {
	WebDriver driver;
	Actions action = new Actions(driver);
 
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/sliders");
  }
  
  @Test
  public void middleValue() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  slider.click();
	  
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Mid value: " + volumeLevel);
      Assert.assertEquals(volumeLevel, "50");
  }
  
  @Test
  public void maxValue() {
	  WebElement slider = driver.findElement(By.id("slider"));

      action.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
      
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Max value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "100");
  }
  
  @Test
  public void minValue() {
	  WebElement slider = driver.findElement(By.id("slider"));

      action.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
      
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Min value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "0");
  }
  
  @Test
  public void thirtyPer() {
	  WebElement slider = driver.findElement(By.id("slider"));

      action.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
      
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Min value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "30");
  }
  
  @Test
  public void eightyPer() {
	  WebElement slider = driver.findElement(By.id("slider"));

      action.clickAndHold(slider).moveByOffset(45, 0).release().build().perform();
      
      String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
      Reporter.log("Min value: " + volumeLevel);
      
      Assert.assertEquals(volumeLevel, "80");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
