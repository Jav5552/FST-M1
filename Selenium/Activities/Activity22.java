import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class Activity22 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);

        
        driver.get("https://www.v1.training-support.net/selenium/popups");
        System.out.println("Home page title: " + driver.getTitle());

    
        WebElement button = driver.findElement(By.className("orange"));
        builder.moveToElement(button).build().perform();
        String tooltipMessage = button.getAttribute("data-tooltip");
        System.out.println(tooltipMessage);


        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        
        WebElement Objusername = driver.findElement(By.id("username"));
        WebElement Objpassword = driver.findElement(By.id("password"));

        Objusername.sendKeys("admin");
        Objpassword.sendKeys("password");
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);

       
        driver.quit();
    }
}
