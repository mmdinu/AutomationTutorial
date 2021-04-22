package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ButtonsTest {

    public WebDriver driver;

    @Test
    public void TestAutomat() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        /*
         Elements Menu
        Buttons SubMenu
        */

        WebElement ElementsMenuWeb = driver.findElement(By.xpath("//div[@class='category-cards']/div[1]"));
        ElementsMenuWeb.click();

        WebElement MainHeaderWeb = driver.findElement(By.xpath("//div[@class='main-header']"));
        String ExpectedElementsPage = "Elements";
        String ActualElementsPage = MainHeaderWeb.getText(); //metoda cu  return
        assertEquals("The wanted page was not found/displayed", ExpectedElementsPage, ActualElementsPage);

        // declaram pagina cu butoane
        WebElement ButtonsWeb = driver.findElement(By.id("item-4"));
        ButtonsWeb.click();
        
        // wait for 5 seconds - se afiseaza tabelul cu noul introdus
        int seconds = 3;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // declaram elementul Duble Click Me - actionam cu comanda de mouse
        WebElement DoubleClickMeWeb = driver.findElement(By.id("doubleClickBtn"));
        Actions Mouse = new Actions(driver);
        Mouse.doubleClick(DoubleClickMeWeb).perform();                
        //verificam/validam/printam elementul Duble Click Me Message
        WebElement DoubleClickMeMessageWeb = driver.findElement(By.id("doubleClickMessage"));
        String ExpectedMessage = "You have done a double click";
        System.out.println();
        System.out.println(ExpectedMessage);
        assertEquals(ExpectedMessage, DoubleClickMeMessageWeb.getText());
        
        // wait for 5 seconds - se afiseaza tabelul cu noul introdus
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // declaram elementul Right Click Me - actionam cu comanda de mouse
        WebElement RightClickMeWeb = driver.findElement(By.id("rightClickBtn"));
        Actions Mouse1 = new Actions(driver);
        Mouse1.contextClick(RightClickMeWeb).perform();
        //verificam/validam/printam elementul Right Click Me Message
        WebElement RightClickMeMessageWeb = driver.findElement(By.id("rightClickMessage"));
        String ExpectedMessage1 = "You have done a right click";
        System.out.println();
        System.out.println(ExpectedMessage1);
        assertEquals(ExpectedMessage1, RightClickMeMessageWeb.getText());

        // wait for 5 seconds - se afiseaza tabelul cu noul introdus
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // declaram elementul Click Me - actionam cu comanda de mouse
        WebElement ClickMeWeb = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div[3]/button"));
        Actions Mouse2 = new Actions(driver);
        Mouse2.click(ClickMeWeb).perform();
        //verificam/validam/printam elementul RightClickMeMessage
        WebElement DynamicMeMessageWeb = driver.findElement(By.id("dynamicClickMessage"));
        String ExpectedMessage2 = "You have done a dynamic click";
        System.out.println();
        System.out.println(ExpectedMessage2);
        assertEquals(ExpectedMessage2, DynamicMeMessageWeb.getText());

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();


    }



}
