import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Activity11 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       driver.get("https://v1.training-support.net/selenium/dynamic-controls");
       System.out.println("Home page title: " + driver.getTitle());


        WebElement Objcheckbox = driver.findElement(By.name("toggled"));
        Objcheckbox.click();
        System.out.println("Checkbox is selected: " + Objcheckbox.isSelected());
        Objcheckbox.click();
        System.out.println("Checkbox is selected: " + Objcheckbox.isSelected());


        driver.quit();
    }
}
