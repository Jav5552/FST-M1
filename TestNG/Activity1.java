import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;
@BeforeClass
public void setup(){


    WebDriverManager.firefoxdriver().setup();

    driver=new FirefoxDriver();
    driver.get("https://v1.training-support.net.");
}

@Test
public void activity1(){

    String titlePage=driver.getTitle();

    System.out.println("Title of the page: " +titlePage);

    Assert.assertEquals("Training Support",titlePage);

    driver.findElement(By.id("about-link")).click();

    String newTitlePage=driver.getTitle();

    Assert.assertEquals("About Training Support",newTitlePage);



}
@AfterClass
        public void teardown(){

    driver.quit();


}











    }


