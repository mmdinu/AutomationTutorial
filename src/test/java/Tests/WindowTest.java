package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WindowTest {



    public WebDriver driver;

    @Test
    public void TestAutomat()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //wait implicit vegheaza peste tot
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        int seconds=3;

        //For clarification: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/

        WebElement AlertsFWMenuWeb = driver.findElement(By.xpath("//div[@class='category-cards']/div[3]"));
        AlertsFWMenuWeb.click();
        //wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}
        WebElement WindowWeb = driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul[1]/li[1]"));
        WindowWeb.click();


        WebElement NewTabWeb = driver.findElement(By.id("tabButton"));
        NewTabWeb.click();
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));
        //wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}


        WebElement TabMessage = driver.findElement(By.id("sampleHeading"));
        String ExpectedMessage="This is a sample page";
        String ActualMessage=TabMessage.getText();
        Assertions.assertEquals(ExpectedMessage,ActualMessage, "The wanted page was  displayed");
        System.out.println("The message one is: " + ExpectedMessage);
        driver.close();
        driver.switchTo().window(Tabs.get(0));
        System.out.println("The title of page one is: " + driver.getTitle());
        //wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}



        WebElement NewWindowWeb = driver.findElement(By.id("windowButton"));
        NewWindowWeb.click();
        ArrayList<String> Window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Window.get(1));
        //wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}


        WebElement WindowMessage = driver.findElement(By.id("sampleHeading"));
        String ExpectedMessage1="This is a sample page";
        String ActualMessage1=WindowMessage.getText();
        Assertions.assertEquals(ExpectedMessage1,ActualMessage1, "The wanted page was  displayed");
        System.out.println("The message two is :  - " + ExpectedMessage1);
        //wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}
        driver.close();
        driver.switchTo().window(Window.get(0));

        System.out.println("The title of page two is: " + driver.getTitle());

        driver.close();

    }


}
