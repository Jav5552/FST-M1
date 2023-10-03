import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        driver.findElement(By.id("prompt")).click();
        Thread.sleep(2000);

       Alert alertWindow=driver.switchTo().alert();
        System.out.println( alertWindow.getText());
        alertWindow.sendKeys("Awesome");
        Thread.sleep(2000);
        alertWindow.accept();

    }
}
