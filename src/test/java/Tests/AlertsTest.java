package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AlertsTest {


    public WebDriver driver;
    private WebElement ElementsMenuWeb;

    @Test
    public void TestAutomat() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        /*
         Alerts Menu
        Buttons SubMenu
        */

        WebElement AlertsFWMenuWeb = driver.findElement(By.xpath("//div[@class='category-cards']/div[3]"));
        AlertsFWMenuWeb.click();

        WebElement MainHeaderWeb = driver.findElement(By.xpath("//div[@class='main-header']"));
        String ExpectedElementsPage = "Alerts";
        String ActualElementsPage = MainHeaderWeb.getText(); //metoda cu  return
        assertEquals("The wanted page was not found/displayed", ExpectedElementsPage, ActualElementsPage);

        WebElement Button1Web=



    }
}
