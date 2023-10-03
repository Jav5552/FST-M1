import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity15 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver =new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//button[text()='Log in']/preceding::input[@placeholder='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[text()='Log in']/preceding::input[@placeholder='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String confrimMessage=driver.findElement(By.id("action-confirmation")).getText();


    }
}
