package HomeWorkAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {

    public WebDriver driver;

    @Test
    public void TestAutomat() {

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();


        /*Locate by ID Attribute
          URL - http://www.demoqa.com/automation-practice-form
         */

        driver.get("https://www.demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Popa");
        driver.findElement(By.id("lastName")).sendKeys("Vlad");
        driver.findElement(By.id("userEmail")).sendKeys("popa.vlad@yahoo.com");
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0734221882");
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement DateOfBirthWeb = driver.findElement(By.id("dateOfBirthInput"));
        DateOfBirthWeb.click();
        WebElement MonthOfBirthWeb = driver.findElement(By.className("react-datepicker__month-select"));
        Select MonthSelect = new Select(MonthOfBirthWeb);
        MonthSelect.selectByVisibleText("February");
        WebElement YearOfBirthWeb = driver.findElement(By.className("react-datepicker__year-select"));
        Select YearSelect = new Select(YearOfBirthWeb);
        YearSelect.selectByVisibleText("1964");
        List< WebElement > DaysOptionsListWeb = driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));
        for (WebElement webElement : DaysOptionsListWeb) {
            String CurrentValue = webElement.getAttribute("aria-label");
            if (CurrentValue.contains("February") & CurrentValue.contains("16")) {
                webElement.click();
                break;

            }
        }
        WebElement SubjectsWeb = driver.findElement(By.id("subjectsInput"));
        String SubjectsValue = "Computer Science";
        SubjectsWeb.sendKeys(SubjectsValue);
        SubjectsWeb.sendKeys(Keys.ENTER);

        WebElement MusicBoxWeb = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));//input[@id='hobbies-checkbox-3']
        MusicBoxWeb.click();

        WebElement UploadPictureWeb = driver.findElement(By.id("uploadPicture"));
        UploadPictureWeb.sendKeys("C:\\Automation\\Picture for demoqaWeb.JPG");


        // use newline(\n) and tab(\t) characters in WebElement with String or sendkeys!
        WebElement CurrentAddressWeb = driver.findElement(By.id("currentAddress"));
        String CurrentAddressValue=" Str. Mircea Eliade, nr. 15A \n Cluj-Napoca \n Romania";
        CurrentAddressWeb.sendKeys(CurrentAddressValue);
        CurrentAddressWeb.sendKeys(Keys.TAB);

        /*
 another simple wey to print in box, with next line!
        driver.findElement(By.id("currentAddress"))
                .sendKeys(" Str. Mircea Eliade, nr. 15A \n Cluj-Napoca \n Romania");
 validation not work
        String ExpectCurrentAddressValue=" Str. Mircea Eliade, nr. 15A \n Cluj-Napoca \n Romania";
        Assert.assertEquals(ExpectCurrentAddressValue, CurrentAddressWeb.getText());
        System.out.println(" the line test for Current Address passed successfully");
        WebElement StateWeb=driver.findElement(By.id("state"));
        StateWeb.click();
*/


        WebElement StateWeb=driver.findElement(By.id("react-select-3-input"));
        String StateValue="Haryana";
        StateWeb.sendKeys(StateValue);
        StateWeb.sendKeys(Keys.ENTER);
        StateWeb.sendKeys(Keys.TAB);

        WebElement CityWeb=driver.findElement(By.id("react-select-4-input"));
        String CityValue="Karnal";
        CityWeb.sendKeys(CityValue);
        CityWeb.sendKeys(Keys.ENTER);
        StateWeb.sendKeys(Keys.TAB);



//        driver.findElement(By.className(" css-1uccc91-singleValue")).sendKeys("Haryana");


        // submit form!
        WebElement SubmitWeb = driver.findElement(By.id("submit"));
        SubmitWeb.sendKeys(Keys.ENTER);

        // wait for 5 seconds before closing the browser
        int milliseconds = 5000;
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement CloseWeb=driver.findElement(By.id("closeLargeModal"));
        CloseWeb.click();


            // wait for 5 seconds before closing the browser
            try {
                TimeUnit.MILLISECONDS.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        /*
           Locate by Name attribute
           URL - http://www.demoqa.com/automation-practice-form
         */

            driver.get("https://www.demoqa.com/automation-practice-form");
            driver.findElement(By.name("gender"));

        /*
           Locate by className attribute
           URL - http://www.demoqa.com/automation-practice-form
         */

            driver.get("https://www.demoqa.com/automation-practice-form");
            driver.findElement(By.className("practice-form-wrapper"));

        /*
           Locate by linkText and ParticalLinkText attribute
           URL - http://www.demoqa.com/links
         */

            driver.get("https://www.demoqa.com/links");
            //linkText
            driver.findElement(By.linkText("Home"));
            //partialLinkText
            driver.findElement(By.partialLinkText("Ho"));

        /*
           Locate by tagName attribute
           URL - http://www.demoqa.com/links
         */

            driver.get("https://www.demoqa.com/links");
            List< WebElement > list = driver.findElements(By.tagName("a"));


        /*
           Locate by cssSelector attribute
           URL - http://www.demoqa.com/text-box
         */

            driver.get("https://www.demoqa.com/text-box");
            driver.findElement(By.cssSelector("input[id= ‘userName’]"));


        /*
           Locate by xpath attribute
           URL - http://www.demoqa.com/text-box
         */

            driver.get("https://www.demoqa.com/text-box");
            driver.findElement(By.xpath("//input[@id='userName']"));

            driver.close();


        }
}