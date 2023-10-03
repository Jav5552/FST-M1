package TestNG;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;
	  @Test
	  public void testCase() {
		  String title = driver.getTitle();
		  System.out.println("Title of the page is "+ title);
	  }
	  
	  @Test(groups = {"HeaderTests"})
	  public void headerTest1() {
		  WebElement thirdHeader = driver.findElement(By.id("third-header"));
		  Assert.assertEquals(thirdHeader.getText(), "Third header");
	  }
	  
	  @Test(groups = {"HeaderTests"})
	  public void headerTest2() {	  
		  WebElement fifthHeader = driver.findElement(By.cssSelector(".ui.green.header"));
		  Assert.assertEquals(fifthHeader.getCssValue("color"), "rgb(33, 186, 69)");
	  }
	  
	  @Test(groups = {"ButtonTests"})
	  public void buttonTest1() {
		  WebElement oliveBtn = driver.findElement(By.xpath("//button[contains(@class,'olive')]"));
		  Assert.assertEquals(oliveBtn.getText(), "Olive");
	  }
	  
	  @Test(groups = {"ButtonTests"})
	  public void buttonTest2() {
		  WebElement brownBtn = driver.findElement(By.cssSelector("button.brown"));
	      Assert.assertEquals(brownBtn.getCssValue("color"), "rgb(255, 255, 255)");
	  }
	  
	  @BeforeClass(alwaysRun = true)
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("https://www.training-support.net/selenium/target-practice");
	  }

	  @AfterClass(alwaysRun = true)
	  public void afterClass() {
		  driver.close();
	  }

	}
