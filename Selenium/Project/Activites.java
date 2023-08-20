import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activites {
    WebDriver driver;
    WebDriverWait wait;
@BeforeMethod
public void setUp(){

   // WebDriverManager.firefoxdriver().setup();
    driver=new FirefoxDriver();
    wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    driver.get("https://alchemy.hguy.co/crm/");
    driver.manage().window().maximize();

}

    //************Goal: Read the title of the website and verify the text********
@Test
public void verifyTitle() {
    String titlePage = driver.getTitle();
    Assert.assertEquals("SuiteCRM", titlePage);

    if ("SuiteCRM".equals(titlePage))
        {
            System.out.println(titlePage);
        System.out.println("Title matches with expected title text SuiteCRM ");
         }
    else {
        System.out.println(titlePage);
        System.out.println("Title is not matched with expected title text SuiteCRM ");

        }
}

    //**************Goal: Print the url of the header image to the console***********
@Test

    public void getURLofHeaderPage(){

    String URLofheaderImage=driver.findElement(By.xpath("//img[@alt='SuiteCRM']")).getAttribute("src");
    System.out.println("URL of the header page is: "+URLofheaderImage);

    }
    //*********Goal: Print the first copyright text in the footer to the console******************
@Test
public void getCopyrightText(){

    String copyrightText=driver.findElement(By.xpath("//a[@id='admin_options']")).getText();
    System.out.println("Copyright text is :"+copyrightText);
}

    //************Goal: Open the site and login with the credentials provided*******************
@Test
public void loginToCRMPage() {

    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("bigbutton")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Boolean visibleFlag = driver.findElement(By.xpath("//a[text()='Sales']")).isDisplayed();

    if (visibleFlag) {
        System.out.println("Login is successful");

    }
    else {
        System.out.println("Login is not successful");
    }

}

    //****************** Get the color of the navigation menu*************
@Test
public void getColorsOfMenu()  {
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("bigbutton")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    List<WebElement> collMenu= driver.findElements(By.xpath("//a[@class='dropdown-toggle grouptab']"));

    for (WebElement oMenu:collMenu) {
        System.out.println("Color of the navigation menu "+oMenu.getText()+":"+oMenu.getCssValue("color"));
    }
}
    //**********Goal: Make sure that the “Activities” menu item exists and is clickable***********
@Test
public void checkMenu()  {
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("bigbutton")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    boolean blnFlag=driver.findElement(By.xpath("//a[text()='Activities']")).isDisplayed();
    if(blnFlag){
        System.out.println("Activities element is present");

        boolean blnEnableFlag=driver.findElement(By.xpath("//a[text()='Activities'")).isEnabled();

        if (blnEnableFlag){

            System.out.println("Activities element is enabled or clickable");
        }
    }
}

//***********Goal: Reading a popup that contains additional information about the account/lead***********
@Test
public void readThePopUp() {
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("bigbutton")).click();
    //wait.until()
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sales']")));
    driver.findElement(By.xpath("//a[text()='Sales']")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[@id='grouptab_0']/following::a[text()='Leads'][1]")).click();
    //driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='oddListRowS1'][1]/td[10]/span[1]")));
    driver.findElement(By.xpath("//tr[@class='oddListRowS1'][1]/td[10]/span[1]")).click();
    driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    String leadNumber=driver.findElement(By.xpath("//b[text()='Mobile:']/following-sibling::span[1]")).getText();
    System.out.println("Lead phone number is :"+leadNumber);

}

//*******************Goal: Open the accounts page and print the contents of the table*************
@Test
public void printAccountPageContent() {
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("bigbutton")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sales']")));
    driver.findElement(By.xpath("//a[text()='Sales']")).click();
    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[@id='grouptab_0']/following::a[text()='Accounts'][1]")).click();
    WebElement element =driver.findElement(By.xpath("//form[@id='MassUpdate']"));
    wait.until(ExpectedConditions.visibilityOf(element));

    for(int oddRow=1;oddRow<=9;oddRow=oddRow+2){

       String accountName=driver.findElement(By.xpath("//form[@id='MassUpdate']/div[3]/table[1]/tbody[1]/tr["+oddRow+"]/td[3]/b[1]/a[1]")).getText();
        System.out.println("Account name of row "+oddRow+":"+accountName);
    }

}
//**************Goal: Open the leads page and print the usernames and full names from the table*************************
@Test

public void printTheLeadTableContent() {
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("bigbutton")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sales']")));
    driver.findElement(By.xpath("//a[text()='Sales']")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[@id='grouptab_0']/following::a[text()='Leads'][1]")).click();
    WebElement tableElement=driver.findElement(By.xpath("//form[@id='MassUpdate']"));
    wait.until(ExpectedConditions.visibilityOf(tableElement));

    for(int rownum=1;rownum<=10;rownum++) {
        String LeadName=driver.findElement(By.xpath("//form[@id='MassUpdate']/div[3]/table[1]/tbody[1]/tr["+rownum+"]/td[3]/b[1]/a[1]")).getText();
        String User=driver.findElement(By.xpath("//form[@id='MassUpdate']/div[3]/table[1]/tbody[1]/tr["+rownum+"]/td[8]/a[1]")).getText();

        System.out.println("Lead Name is :"+LeadName+" and user is "+User);
    }
}

@AfterMethod
public void teardown(){

    driver.quit();

}

}
