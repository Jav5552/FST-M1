import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
        public static void main(String[] args) {
            
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           
            driver.get("https://v1.training-support.net/selenium/ajax");
            driver.findElement(By.cssSelector("button.violet")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
            String text = driver.findElement(By.tagName("h1")).getText();
            System.out.println(text);

            WebElement headerEle = driver.findElement(By.tagName("h3"));
            System.out.println(headerEle.getText());

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
            String HeaderText = driver.findElement(By.tagName("h3")).getText();
            System.out.println(HeaderText);


            driver.quit();
        }
}
