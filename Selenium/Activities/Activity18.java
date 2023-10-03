import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity18
{

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver =new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println(driver.getTitle());
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='multi-select']"));

        Select select=new Select(dropdown);

        select.selectByVisibleText("Javascript");
        for(int i=4;i<=6;i++){

            select.selectByIndex(i);
        }
        select.selectByValue("node");

        select.deselectByIndex(5);
        driver.close();


    }
}
