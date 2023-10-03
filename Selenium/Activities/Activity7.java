import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver =new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());
        Actions builder=new Actions(driver);

        WebElement eleFootball=driver.findElement(By.id("draggable"));
        WebElement eleDropArea=driver.findElement(By.id("droppable"));

        builder.clickAndHold(eleFootball).moveToElement(eleDropArea).pause(1000).release().build().perform();
        WebElement eleDropArea2=driver.findElement(By.id("dropzone2"));
        builder.dragAndDrop(eleDropArea,eleDropArea2).build().perform();

        driver.close();



    }
}
