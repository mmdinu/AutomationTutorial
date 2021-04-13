    package Tests;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

    import java.util.concurrent.TimeUnit;

    import static java.lang.System.*;

        public class ElementsTextBoxTest {
        public WebDriver driver;

// selenium trebuie legat de o variabila - WebDriver - iar numele - driver -

        @Test
        public void TestAutomat() {
// o metoda...
        setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement ElementsMenuWeb=driver.findElement(By.xpath("//div[@class='category-cards']/div[1]"));
        ElementsMenuWeb.click();
// vezi imaginea atribut valoare unica "//div[@class='category-cards']/div[1]"!

// validari in testul de automation
        WebElement MainHeaderWeb=driver.findElement(By.xpath("//div[@class='main-header']"));
        String ExpectedElementsPage="Elements";
        String ActualElementsPage=MainHeaderWeb.getText(); //metoda cu return
        Assert.assertEquals("!! The wanted page was not displayed!! ",ExpectedElementsPage,ActualElementsPage);

        WebElement TextBoxSubmenuWeb=driver.findElement(By.id("item-0"));
        TextBoxSubmenuWeb.click();

// valoare unica a elementului  "item-0"
// interactionezi cu elementele, orice element cautat declarat, poate sa fie gasit si ulterior apicat!

        WebElement TextBoxWeb=driver.findElement(By.xpath("//div[@class='main-header']"));
        String ExpectedTextBoxPage="Text Box";
        String ActualTextBoxPage=TextBoxWeb.getText(); //metoda cu return - cum a declarat developerul
        Assert.assertEquals("!!The wanted page was not displayed!!",ExpectedTextBoxPage,ActualTextBoxPage);

        WebElement FullNameWeb=driver.findElement(By.id("userName"));
        String FullNameValue = "Pop Ioan";
        FullNameWeb.sendKeys(FullNameValue);

        WebElement EmailWeb=driver.findElement(By.id("userEmail"));
        String EmailValue="Pop.Ioan@gmail.com";
        EmailWeb.sendKeys(EmailValue);

        WebElement CurrentAddressWeb=driver.findElement(By.id("currentAddress"));
        String CurrentAddressValue="Strada Eminescu, nr. 15";
        CurrentAddressWeb.sendKeys(CurrentAddressValue);

        WebElement PermanentAddressWeb=driver.findElement(By.id("permanentAddress"));
        String PermanentAddressValue="Strada Eminescu, nr. 15";
        PermanentAddressWeb.sendKeys(PermanentAddressValue);

        WebElement SubmitButtonWeb=driver.findElement(By.id("submit"));
        SubmitButtonWeb.click();

        /*
         TEMA:
         1. dupa submit apar datele introduse intr-un tabel
         2. validam fiecare valoare introdusa acolo cu assert
         3. facem un test pentru CheckBox
        */

        // 1.
        out.println("TEMA 1");

        out.println ("Numele este: " + FullNameValue);
        out.println ("Adresa de email este: " + EmailValue);
        out.println ("Adresa curenta este: " + CurrentAddressValue);
        out.println ("Adresa permanenta este:" + PermanentAddressValue);
        out.println ();
        out.println ("!dif we had done something wrong in the test, we would not have printed the above information!");

        //2.
        out.println("TEMA 2");

        WebElement NameBoxWeb = driver.findElement ( By.xpath ("//p[@id='name']"));
        String ExpectedElementName = ("p");
        String ActualElementsName = NameBoxWeb.getTagName ();
        Assert.assertEquals ( "!! the wanted text not displayed", ExpectedElementName, ActualElementsName);

        WebElement EmailBoxWeb = driver.findElement ( By.xpath ("//p[@id='email']"));
        String ExpectedElementEmail = ("p");
        String ActualElementsEmail = EmailBoxWeb.getTagName ();
        Assert.assertEquals ( "!! the wanted text not displayed", ExpectedElementEmail, ActualElementsEmail);

        WebElement CurrentAddressBoxWeb = driver.findElement (By.xpath ("//p[@id='currentAddress']"));
        String ExpectElementCurrentAddressBox = ("p");
        String ActualElementCurrentAddressBox = CurrentAddressBoxWeb.getTagName ();
        Assert.assertEquals ( "!! the wanted text not displayed", ExpectElementCurrentAddressBox, ActualElementCurrentAddressBox );

        WebElement PermanentAddressBoxWeb = driver.findElement (By.xpath ("//p[@id='permanentAddress']"));
        String ExpectElementPermanentAddressBox = ("p");
        String ActualElementPermanentAddressBox = PermanentAddressBoxWeb.getTagName ();
        Assert.assertEquals ( "!! the wanted text not displayed", ExpectElementPermanentAddressBox, ActualElementPermanentAddressBox );


        // 3.
        out.println("TEMA 3");

        WebElement TextCheckBoxWeb=driver.findElement(By.id("item-1"));
        TextCheckBoxWeb.click();

// with expand full button
        WebElement ExpandButtonWeb = driver.findElement(By.xpath ("//button[@class='rct-option rct-option-expand-all']"));
        ExpandButtonWeb.click();
        // deselect button/ remain wonted
        WebElement HomeButtonWeb = driver.findElement(By.xpath("//label[@for='tree-node-home']"));
        HomeButtonWeb.click();

// hard to explain with 1 to 1 match; testing: rct-icon rct-icon-check; rct-option rct-option-expand-all ; id=tree-node-home; //input[@id='tree-node-home']; rct-icon rct-icon-check

        WebElement NotesButtonWeb = driver.findElement (By.xpath("//label[@for='tree-node-notes']"));
        NotesButtonWeb.click ();

        WebElement ReactButtonWeb = driver.findElement (By.xpath("//label[@for='tree-node-react']"));
        ReactButtonWeb.click ();

        WebElement VeuButtonWeb = driver.findElement (By.xpath("//label[@for='tree-node-veu']"));
        VeuButtonWeb.click ();

        WebElement PublicButtonWeb = driver.findElement (By.xpath("//label[@for='tree-node-public']"));
        PublicButtonWeb.click ();

        WebElement GeneralButtonWeb = driver.findElement (By.xpath("//label[@for='tree-node-general']"));
        GeneralButtonWeb.click ();

// WebElement WordFileButtonWeb = driver.findElement (By.xpath("//label[@for='tree-node-wordFile']")); WordFileButtonWeb.click ();

        WebElement ExcelFileButtonWeb = driver.findElement (By.xpath("//label[@for='tree-node-excelFile']"));
        ExcelFileButtonWeb.click ();

        out.println ();
        out.println ( """
                You have selected :
                       commands
                       angular
                       private
                       classified
                       wordFile
                """ );
// wait fot the 7 seconds before collapse

        int milliseconds = 7000;

        try { TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement CollapseButtonWeb = driver.findElement(By.xpath ("//button[@class='rct-option rct-option-collapse-all']"));
        CollapseButtonWeb.click();




// wait for 7 seconds before closing the browser

        try { TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

        driver.quit();

// close fot the current tabs, quit close all tabs!


    }
}
