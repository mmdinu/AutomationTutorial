package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesTest {

    public WebDriver driver;

    @Test
    public void TestAutomat() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        /*
         Elements Menu
        Text Box SubMenu
        */

        WebElement ElementsMenuWeb = driver.findElement(By.xpath("//div[@class='category-cards']/div[1]"));
        ElementsMenuWeb.click();

        WebElement MainHeaderWeb = driver.findElement(By.xpath("//div[@class='main-header']"));
        String ExpectedElementsPage = "Elements";
        String ActualElementsPage = MainHeaderWeb.getText(); //metoda cu  return
        Assert.assertEquals("The wanted page was not displayed", ExpectedElementsPage, ActualElementsPage);

        WebElement WebTablesSubmenuWeb=driver.findElement(By.id("item-3"));
        WebTablesSubmenuWeb.click();

        WebElement AddButtonWeb=driver.findElement(By.id("addNewRecordButton"));
        AddButtonWeb.click();

        WebElement FirstNameWeb=driver.findElement(By.id("firstName"));
        String FirstNameValue="Ioan";
        FirstNameWeb.sendKeys(FirstNameValue);


        WebElement LastNameWeb=driver.findElement(By.id("lastName"));
        String LastNameValue="Moldovan";
        LastNameWeb.sendKeys(LastNameValue);

        WebElement EmailWeb=driver.findElement(By.id("userEmail"));
        String EmailValue="moldovan.ioan@gmail.com";
        EmailWeb.sendKeys(EmailValue);

        WebElement AgeWeb=driver.findElement(By.id("age"));
        String AgeValue="57";
        AgeWeb.sendKeys(AgeValue);

        WebElement SalaryWeb=driver.findElement(By.id("salary"));
        String SalaryValue="6500";
        SalaryWeb.sendKeys(SalaryValue);

        WebElement DepartmentWeb=driver.findElement(By.id("department"));
        String DepartmentValue="QA Department";
        DepartmentWeb.sendKeys(DepartmentValue);

        WebElement SubmitButtonWeb=driver.findElement(By.id("submit"));
        SubmitButtonWeb.click();

        int seconds = 5;
        // wait for 5 seconds - se afiseaza tabelul cu noul introdus
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //validare rezultate dupa submit

        WebElement DisplayedFirstNameWeb = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]//div[1]/div[1]"));
        String ExpectedFirstName = "Ioan";
        Assert.assertEquals(ExpectedFirstName, DisplayedFirstNameWeb.getText());
        System.out.println("The result 'Ioan' is expected – the test passed successfully!");

        WebElement DisplayedLastNameWeb = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]//div[1]/div[2]"));
        String ExpectedLastName = "Moldovan";
        Assert.assertEquals(ExpectedLastName, DisplayedLastNameWeb.getText());
        System.out.println("The result 'Moldovan' is expected – the test passed successfully!");

        WebElement DisplayedAgeWeb = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]//div[1]/div[3]"));
        String ExpectedAge = "57";
        Assert.assertEquals(ExpectedAge, DisplayedAgeWeb.getText());
        System.out.println("The result '57' is expected – the test passed successfully!");

        WebElement DisplayedEmailWeb = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]//div[1]/div[4]"));
        String ExpectedEmail = "moldovan.ioan@gmail.com";
        Assert.assertEquals(ExpectedEmail, DisplayedEmailWeb.getText());
        System.out.println("The result 'moldovan.ioan@gmail.com' is expected – the test passed successfully!");

        WebElement DisplayedSalaryWeb = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]//div[1]/div[5]"));
        String ExpectedSalary = "6500";
        Assert.assertEquals(ExpectedSalary, DisplayedSalaryWeb.getText());
        System.out.println("The result '6500' is expected – the test passed successfully!");

        WebElement DisplayedDepartmentWeb = driver.findElement(By.xpath("//div[@class='rt-tr-group'][4]//div[1]/div[6]"));
        String ExpectedDepartment = "QA Department";
        Assert.assertEquals(ExpectedDepartment, DisplayedDepartmentWeb.getText());
        System.out.println("The result 'QA Department' is expected – the test passed successfully!");

        //verificam butonul edit, editam inregistrarea noastra 4
        WebElement EditButtonWeb=driver.findElement(By.id("edit-record-4"));
        EditButtonWeb.click();
        //ceem un nou element FristName1Valuecautam elementul din firstname,
        WebElement FirstName1Web=driver.findElement(By.id("firstName"));
        // stergem - clear - firstname "Ioan" , inlocuim ci "Andrei"
        FirstName1Web.clear();
        String FirstName1Value="Andrei";
        FirstName1Web.sendKeys(FirstName1Value);
        //validam cu submit, vedem modificarea
        WebElement Submit1ButtonWeb=driver.findElement(By.id("submit"));
        Submit1ButtonWeb.click();

        // wait for 5 seconds - se afiseaza tabelul cu firstname schimbat
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // am comentat elementul de la linia 4, la curs sa sters inregistrarea  4
//        WebElement DeleteButtonWeb=driver.findElement(By.id("delete-record-4"));
//        DeleteButtonWeb.click();

        //pentru a cauta noul element pe linia 4 "Andrei", la curs sa cautat "Alden"
        WebElement SearchWeb=driver.findElement(By.id("searchBox"));
        String SearchValue="Andrei";
        SearchWeb.sendKeys(SearchValue);
        SearchWeb.sendKeys(Keys.ENTER);
        // se afiseaza randul cu elementul "Andrei"

        // verificam numarul de randuri (de inregistrare)
        WebElement RowsWeb=driver.findElement(By.xpath("//select[@aria-label='rows per page']"));
        Select RowsSelect = new Select(RowsWeb);
        RowsSelect.selectByVisibleText("50 rows"); // ori by value (50)

        // validam numarul de randuri (de inregistrare) - folosim List!
        List<WebElement> DisplayedRowsWeb = driver.findElements(By.xpath("//div[@class='rt-tbody']/div"));
        int ExpectedRows = 50;
        Assert.assertEquals(ExpectedRows, DisplayedRowsWeb.size());
        System.out.println("The wanted rows (50) are displayed – the test passed successfully!");

        // wait for 5 seconds before closing the browser
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.quit();
    }


}
