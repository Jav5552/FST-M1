import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();

        driver.get(" https://v1.training-support.net/selenium/javascript-alerts");

        System.out.println(driver.getTitle());
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert=driver.switchTo().alert();

        System.out.println(confirmAlert.getText());
        Thread.sleep(2000);
        confirmAlert.accept();

        driver.findElement(By.id("confirm")).click();
        Thread.sleep(2000);
        confirmAlert.dismiss();
        driver.close();

    }
}
