import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Activity5 {

    public static void main(String[] args) {


        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title of the page: "+ driver.getTitle());

        Actions builder= new Actions(driver);

        //Left Click
        builder.click().pause(500).build().perform();
        String OutPut=driver.findElement(By.className("active")).getText();
        System.out.println("number after left click "+ OutPut);
        //Double Click
        builder.doubleClick().pause(500).build().perform();
        OutPut=driver.findElement(By.className("active")).getText();
        System.out.println("Number after double click:" +OutPut);
        //Right click
        builder.contextClick().pause(500).build().perform();
        OutPut=driver.findElement(By.className("active")).getText();
        System.out.println("Number afer right click :"+OutPut);

        driver.close();


    }
}
