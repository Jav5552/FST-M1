import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver =new FirefoxDriver();
        driver.get("https://v1.training-support.net");

        System.out.println("Title of the page: "+driver.getTitle());

        driver.findElement(By.id("about-link")).click();

        System.out.println("Title of the new page: "+driver.getTitle());

        driver.quit();

    }
}
