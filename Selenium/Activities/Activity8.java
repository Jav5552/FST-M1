import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

       
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page: " + driver.getTitle());


        WebElement Objcheckbox = driver.findElement(By.id("toggleCheckbox"));
        Objcheckbox.click();
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(Objcheckbox.isDisplayed());
     
        Objcheckbox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(Objcheckbox.isDisplayed());

	driver.close();
    }
}
