package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertsTest {


    public WebDriver driver;

    @Test
    public void TestAutomat() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        /*
        https://www.browserstack.com/guide/understanding-selenium-timeouts
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait implicit vegheaza peste tot daca se intrerupe rularea!
        */
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        int seconds = 2;// define the seconds and write the desired number of seconds

        /*
         Alerts Menu
         Four SubMenu Buttons
         For clarification => https://www.toolsqa.com/selenium-webdriver/alerts-in-selenium/
        */

        WebElement AlertsMenuWeb=driver.findElement(By.xpath("//div[@class='category-cards']/div[3]"));
        AlertsMenuWeb.click();
        WebElement AlertsWeb=driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul[1]/li[2]"));
        AlertsWeb.click();
        WebElement AlertsTitleWeb=driver.findElement(By.xpath("//div[@class='main-header']"));
        String ExpectedAlertsPage="Alerts";
        String ActualAlertsPage=AlertsTitleWeb.getText(); //metoda cu  return
        Assert.assertEquals("The wanted page was displayed",ExpectedAlertsPage,ActualAlertsPage);
        System.out.println(ExpectedAlertsPage);


        WebElement Button1Web=driver.findElement(By.id("alertButton"));
        Button1Web.click();
        // wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}
        //new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();


        WebElement Button2Web=driver.findElement(By.id("timerAlertButton"));
        Button2Web.click();
        // wait explicit - vegheaza exact in punctul in care am nevoie
        new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        // Thread.sleep(10000); // ingreunez testele automate, nu e un bun best-practice
        // wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}
        driver.switchTo().alert().accept();


        WebElement Button3Web=driver.findElement(By.id("confirmButton"));
        Button3Web.click();
        // wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}
        // we can either accept or dismiss the alert box using Alert.accept(); or Alert.dismiss(); method.
        driver.switchTo().alert().accept();
        WebElement MessageButton3Web=driver.findElement(By.id("confirmResult"));
        String ExpectedMessage="You selected Ok";
        String ActualMessage=MessageButton3Web.getText();
        Assert.assertEquals("The wanted page was displayed",ExpectedMessage,ActualMessage);
        System.out.println(ExpectedMessage);

        WebElement Button4Web=driver.findElement(By.id("promtButton"));
        Button4Web.click();
        // new WebDriverWait(driver,10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("*Dinu Mihaila*");
        // wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}
        driver.switchTo().alert().accept();


        WebElement MessageButton4Web=driver.findElement(By.id("promptResult"));
        String ExpectedMessage1="You entered *Dinu Mihaila*";
        String ActualMessage1=MessageButton4Web.getText();
        Assert.assertEquals("The wanted page was displayed",ExpectedMessage1,ActualMessage1);
        System.out.println(ExpectedMessage1);

        // wait for ... seconds
        try {TimeUnit.SECONDS.sleep(seconds);} catch (InterruptedException e) {e.printStackTrace();}


        driver.close();



    }
}
