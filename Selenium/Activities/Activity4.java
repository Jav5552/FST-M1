import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.SQLOutput;

public class Activity4 {

    public static void main(String[] args){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Title of the page :"+driver.getTitle());

        String textThirdHeader=driver.findElement(By.xpath("//h3[text()='Third header']")).getText();
        System.out.println("Text of 3rd header is "+textThirdHeader);

        String colorFifthHeader=driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println("Color of the fifthHeader :"+colorFifthHeader);

        String classOfViolet=driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("Class property of Violet button: "+classOfViolet);

        String textOfGreyButton=driver.findElement(By.className("grey")).getText();
        System.out.println("Text of Grey button :"+textOfGreyButton);

        driver.close();





    }


}
