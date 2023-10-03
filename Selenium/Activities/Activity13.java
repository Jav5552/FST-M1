import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver =new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println(driver.getTitle());

        List<WebElement> totalRows=    driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));

        System.out.println("Total rows "+ totalRows.size());

        List<WebElement> totalCols=    driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));

        System.out.println("Total Coulmns "+ totalCols.size());
        
        List<WebElement> thirdRowData=driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));

        for (WebElement celldata: thirdRowData) {
            System.out.println(celldata.getText());
                    }

        WebElement strcellData = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println(strcellData.getText());

        driver.close();
    }
}
