package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {
    protected WebDriver driver;
    protected   ExtentReports extentReports;//raporlamayi baslatir

    protected   ExtentHtmlReporter extentHtmlReporter;//html formatinda rapor olusuturur

    protected   ExtentTest extentTest; // Test adimlarina bilgi ekler


    public void rapor(String browser,String reportName){
        /*
        1- ExtentReport classindan raporlamayi baslatmasi icin bir object olusturmaliyiz
        2- ExtentHtmlReporter class indan raporlari html formatinda olusturmasi icin bir object olusturmaliyiz
        3- EXtentTest Classindan test adimlarina bilgi ekleyebilmek icin bir object olustururuz
         */

        //bu object i raporlari olusturmak ve yonetmek icin kullanacacğız
        extentReports=new ExtentReports();

        //Oncelikle olusturmak istedigimiz html reprotu projemizde nerede saklamak istiyorsak bir dosya yolu olusturmaliyiz
        //cunku bu pathi kullanarak bir tane html report olusturacağız
        //bunun icinde ExtentHtmlReporter classindan bir object olusturmaliyiz

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentReports a Html raporlayiciyi ekler, bu raporun html formatinda olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);


        //Html raporunun belge basligini ayarlar, bu baslik sekme uzerinde görünür
        extentHtmlReporter.config().setDocumentTitle("Automation Exercise Test Project");

        //Raporun adini ayarladik, Bu raporda gorunecek olan genel baslik
        extentHtmlReporter.config().setReportName(reportName);

        //Bu html raporunda görmek isteyebileceğimiz herhangi bir bilgiyi asagidaki formatta ekleyebilirz
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser",browser);
        extentReports.setSystemInfo("Test Automation Engineer","QA-03 Team");
    }




    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

   //  @After
   //  public void tearDown() throws Exception {
   //      driver.quit();
   //  }

    //Select Visible Text DropDown
    public void selectVisible (WebElement ddm,String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //Select index DropDown
    public void selectIndex(WebElement ddm,int index){
        Select select =new Select(ddm);
        select.selectByIndex(index);
    }

    //Select value  DropDown
    public void selectValue (WebElement ddm,String option){
        Select select =new Select(ddm);
        select.selectByValue(option);
    }

    //Hard Wait
    public void waitForSecond(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Window Handles
    public void window(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    public void frameIndex(int index) {
        driver.switchTo().frame(index);
    }


    //screenshot
    public void screenShot(){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss").format(LocalDateTime.now());
        String folderPath ="src/test/java/screenShots/"+date+"screenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;

        try {
            Files.write(Paths.get(folderPath),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // webelement screenshot
    public void screenshotOfWebElement(WebElement webElement){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss").format(LocalDateTime.now());
        String folderPath ="src/test/java/screenShots/"+date+"webelementSS.png";
        TakesScreenshot ts = (TakesScreenshot) driver;

        try {
            Files.write(Paths.get(folderPath),webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //JSexecutor click method

    public void jsClick(WebElement webElement){

        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",webElement);
        }
    }

    //Create Account
    public void createAccount(String email ,String pwd){
        Faker faker =new Faker();

        //go to url
        driver.get("https://www.automationexercise.com/");

        //click signup/login button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        // Name Value
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().fullName());

        //Email Value
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);

        //signup button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //Gender Radio Button
        WebElement genderButton = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        genderButton.click();

        //*Password Box
        WebElement pwdBox=driver.findElement(By.cssSelector("#password"));
        pwdBox.sendKeys(pwd);

        // Locate to Dropdown Menu
        WebElement day =driver.findElement(By.xpath("//select[@id='days']"));
        WebElement month =driver.findElement(By.xpath("//select[@id='months']"));
        WebElement year =driver.findElement(By.xpath("//select[@id='years']"));

        day.sendKeys("11",Keys.ENTER);
        month.sendKeys("April",Keys.ENTER);
        year.sendKeys("2004",Keys.ENTER);

        //*Full Name Box
        WebElement firstName=driver.findElement(By.id("first_name"));
        firstName.sendKeys(faker.name().firstName(),Keys.TAB,faker.name().lastName());

        //*Adress Box
        WebElement adressBox =driver.findElement(By.id("address1"));
        String address =faker.address().fullAddress();
        adressBox.sendKeys(address);

        //*Country Box
        WebElement countryBox= driver.findElement(By.id("country"));
        countryBox.sendKeys("Canada");

        //*State Box
        WebElement stateBox = driver.findElement(By.xpath("//input[@id='state']"));
        stateBox.sendKeys(faker.address().state());

        //*City
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().cityName());

        //*Zipcode
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());

        //*Mobile Number
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());

        //Create Button
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).submit();

    }



}
