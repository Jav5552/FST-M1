import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println(driver.getTitle());

        List<WebElement> rowCount=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println(rowCount.size());

        List<WebElement> colCount=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println(colCount.size());

        String cellData=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText();

        System.out.println(cellData);

        driver.findElement(By.xpath("//th[text()='Name']")).click();

        cellData=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText();

        System.out.println(cellData);

        List<WebElement> footerData=driver.findElements(By.xpath("//tfoot/tr/th"));

        for (WebElement footercell: footerData
             ) {
            System.out.println(footercell.getText());

        }
        driver.close();
    }
}
