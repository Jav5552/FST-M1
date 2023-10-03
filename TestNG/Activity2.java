import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setup(){


        WebDriverManager.firefoxdriver().setup();

        driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test

    public void getTitle()
    {
        String titlePage= driver.getTitle();

        Assert.assertEquals("Target Practice",titlePage);

    }

    @Test

    public void findElement(){

        String colorOfButton=driver.findElement(By.xpath("//button[text()='Black']")).getCssValue("color");

        Assert.assertEquals("Blue",colorOfButton);
    }

    @Test(enabled = false)

    public void skipMethod(){
        System.out.println("Skipe this method");

    }
}
