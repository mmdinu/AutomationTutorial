package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

        WebElement PracticeFormSubmenuWeb=driver.findElement(By.xpath("//div[@class='accordion']//div[@class='element-list collapse show']//li"));
        PracticeFormSubmenuWeb.click();

        WebElement FirstNameWeb=driver.findElement(By.id("firstName"));
        String FirstNameValue="Pop";
        FirstNameWeb.sendKeys(FirstNameValue);

        WebElement LastNameWeb=driver.findElement(By.id("lastName"));
        String LastNameValue="Ioan";
        LastNameWeb.sendKeys(LastNameValue);

        WebElement EmailWeb=driver.findElement(By.id("userEmail"));
        String EmailValue="pop.ioan@gmail.com";
        EmailWeb.sendKeys(EmailValue);

        WebElement GenderCheckBoxWeb = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        GenderCheckBoxWeb.click(); //clicks on the check box

        WebElement MobileNumberWeb=driver.findElement(By.id("userNumber"));
        String MobileNumberValue="0734522346";
        MobileNumberWeb.sendKeys(MobileNumberValue);

        WebElement DateOfBirthWeb=driver.findElement(By.id("dateOfBirthInput"));
        DateOfBirthWeb.click();

        WebElement MonthOfBirthWeb=driver.findElement(By.className("react-datepicker__month-select"));
        Select MonthSelect = new Select(MonthOfBirthWeb);
        MonthSelect.selectByVisibleText("February");

        WebElement YearOfBirthWeb=driver.findElement(By.className("react-datepicker__year-select"));
        Select YearSelect = new Select(YearOfBirthWeb);
        YearSelect.selectByVisibleText("1964");

        List<WebElement>  DaysOptionsListWeb=driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));
        for (int index = 0; index<DaysOptionsListWeb.size(); index++){
            String CurrentValue=DaysOptionsListWeb.get(index).getAttribute("aria-label");

            if (CurrentValue.contains("February") & CurrentValue.contains("16")){
                DaysOptionsListWeb.get(index).click();
                break;

            }

        }

        WebElement SubjectsWeb=driver.findElement(By.id("subjectsInput"));
        String SubjectsValue="Arts";
        SubjectsWeb.sendKeys(SubjectsValue);
        SubjectsWeb.sendKeys(Keys.ENTER);

        WebElement MusicBoxWeb=driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
        MusicBoxWeb.click();

        WebElement UploadPictureWeb=driver.findElement(By.id("uploadPicture"));
        UploadPictureWeb.sendKeys("C:\\Automation\\Cautare atribut cu val unica.JPG");


    }
}