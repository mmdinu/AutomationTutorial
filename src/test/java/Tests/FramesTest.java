package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FramesTest {

    public WebDriver driver;

    @Test
    public void TestAutomat() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //wait implicit vegheaza peste tot
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

//        int seconds = 2;// define the seconds and write the desired number of seconds

        // For clarification: https://www.toolsqa.com/selenium-webdriver/handle-iframes-in-selenium/

        WebElement AlertsFWMenuWeb = driver.findElement(By.xpath("//div[@class='category-cards']/div[3]"));
        AlertsFWMenuWeb.click();

        WebElement FramesWeb = driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul[1]/li[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FramesWeb); // cand nu se vede elem pe pag
        // Alta varianta - This  will scroll down the page by  1000 pixel vertical
        // js.executeScript("window.scrollBy(0,1000)");
        FramesWeb.click();

        driver.switchTo().frame("frame1");
        WebElement Frame1Message = driver.findElement(By.id("sampleHeading"));
        String ExpectedMessage="This is a sample page";
        String ActualMessage=Frame1Message.getText();
        Assert.assertEquals("The wanted page was  displayed",ExpectedMessage,ActualMessage);
        System.out.println(ExpectedMessage + " 1 ");
        // wait for ... seconds
//        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");
        WebElement Frame2Message = driver.findElement(By.id("sampleHeading"));
        String ExpectedMessage1="This is a sample page";
        String ActualMessage1=Frame2Message.getText();
        Assert.assertEquals("The wanted page was  displayed",ExpectedMessage1,ActualMessage1);
        System.out.println(ExpectedMessage1 + " 2 ");

        driver.switchTo().defaultContent();

        System.out.println(driver.getTitle());


        driver.close();






    }

}
