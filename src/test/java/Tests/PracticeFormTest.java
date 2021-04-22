package Tests;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void TestAutomat() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        // Forms Menu
        WebElement FormsMenuWeb = driver.findElement(By.xpath("//div[@class='category-cards']/div[2]"));
        FormsMenuWeb.click();
        // Practice Forms
        WebElement PracticeFormSubmenuWeb = driver.findElement(By.xpath("//div[@class='accordion']//div[@class='element-list collapse show']//li"));
        PracticeFormSubmenuWeb.click();
        // add First Name
        WebElement FirstNameWeb = driver.findElement(By.id("firstName"));
        String FirstNameValue = "Moldovan";
        FirstNameWeb.sendKeys(FirstNameValue);
        // add Last Name
        WebElement LastNameWeb = driver.findElement(By.id("lastName"));
        String LastNameValue = "Ioan";
        LastNameWeb.sendKeys(LastNameValue);
        // add Email
        WebElement EmailWeb = driver.findElement(By.id("userEmail"));
        String EmailValue = "moldovan.ioan@gmail.com";
        EmailWeb.sendKeys(EmailValue);
        // mark Gender
        WebElement GenderCheckBoxWeb = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        GenderCheckBoxWeb.click(); //clicks on the check box
        // add Mobile (10 Digits)
        WebElement MobileNumberWeb = driver.findElement(By.id("userNumber"));
        String MobileNumberValue = "0734522346";
        MobileNumberWeb.sendKeys(MobileNumberValue);
        // add Date of Birth
        WebElement DateOfBirthWeb = driver.findElement(By.id("dateOfBirthInput"));
        DateOfBirthWeb.click();
        // add select Month
        WebElement MonthOfBirthWeb = driver.findElement(By.className("react-datepicker__month-select"));
        Select MonthSelect = new Select(MonthOfBirthWeb);
        MonthSelect.selectByVisibleText("February");
        // add select Year
        WebElement YearOfBirthWeb = driver.findElement(By.className("react-datepicker__year-select"));
        Select YearSelect = new Select(YearOfBirthWeb);
        YearSelect.selectByVisibleText("1964");


//        List< WebElement > DaysOptionsListWeb = driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));
//        for (int index = 0; index < DaysOptionsListWeb.size(); index++) {
//            String CurrentValue = DaysOptionsListWeb.get(index).getAttribute("aria-label");

        List< WebElement > DaysOptionsListWeb = driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));
        for (WebElement webElement : DaysOptionsListWeb) {
            String CurrentValue = webElement.getAttribute("aria-label");


//        WebElement DayOfBirthWeb = driver.findElement(By.name("react-datepicker__day react-datepicker__day--016 react-datepicker__day--selected react-datepicker__day--weekend"));
//        Select DaySelect = new Select(DayOfBirthWeb);
//        DaySelect.selectByVisibleText("16");
//        DateOfBirthWeb.click();                       NOT WORK!


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



        // another simple wey to print in box, with next line!
//        driver.findElement(By.id("currentAddress"))
//                .sendKeys(" Str. Mircea Eliade, nr. 15A \n Cluj-Napoca \n Romania");

        // validation not work
//        String ExpectCurrentAddressValue=" Str. Mircea Eliade, nr. 15A \n Cluj-Napoca \n Romania";
//        Assert.assertEquals(ExpectCurrentAddressValue, CurrentAddressWeb.getText());
//        System.out.println(" the line test for Current Address passed successfully");


//        WebElement StateWeb=driver.findElement(By.id("state"));
//        StateWeb.click();

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



        // or....not work!!
        // Thread.sleep(5000);

        driver.quit();

// close fot the current tabs, quit close all tabs!


    }
}