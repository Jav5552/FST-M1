import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class Activity16 {
    public static void main(String[] args) {
      
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Home page title: " + driver.getTitle());


        WebElement ObjuserName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement Objpassword = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement ObjconfirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        WebElement Objemail = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));

        
        ObjuserName.sendKeys("NewUser");
        Objpassword.sendKeys("Password");
        ObjconfirmPassword.sendKeys("Password");
        Objemail.sendKeys("real_email@xyz.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();

        String LoginConfirmation = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + LoginConfirmation);

        
        driver.quit();
    }
}
