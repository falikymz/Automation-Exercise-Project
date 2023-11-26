package Automation_Exercise;

import com.aventstack.extentreports.ExtentReports;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_04 extends TestBase {


    @Test
    public void test04() {

        rapor("chrome","Test04 Otomation Exercise Testi");
        extentTest=extentReports.createTest("Automation Exercise","Test Case 04");
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Kullanıcı Automation Exercise anasayfasına gider.");

        //Verify that home page is visible successfully
        WebElement automationWriting = driver.findElement(By.xpath("(//*[.='Automation'])[1]"));
        Assert.assertTrue(automationWriting.isDisplayed());
        extentTest.info("Anasayfanın başarıyla görüntülendiği doğrulanır");
        extentTest.pass("Anasayfanın başarıyla görüntülendiği doğrulandı");


        //Login butonuna basalım
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        extentTest.info("Login butonuna basılır ve loggin sayfasi görünür");

        WebElement loginToAccount = driver.findElement(By.xpath("//*[.='Login to your account']"));
        Assert.assertTrue(loginToAccount.isDisplayed());
        extentTest.info("Login sayfasina gidildilir ve loggin görülür");
        extentTest.pass("Login sayfasina gidildi ve loggin görüldü");

        //Enter correct email address and password
        WebElement mail = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        WebElement pass = driver.findElement(By.xpath("(//*[@name='password'])[1]"));
        WebElement loginBox = driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]"));
        mail.sendKeys("jordan.arjen@forkshape.com");
        pass.sendKeys("123456789");
        loginBox.submit();
        extentTest.info("E-mail adresi ve şifre girilir ve giriş işlemi yapılır");

        //Verify that 'Logged in as username' is visible
        WebElement LoggedIn = driver.findElement(By.xpath("//*[.='Furkan Can']"));
        extentTest.info("Giriş işleminin gerçekleştiğini doğrula");

        LoggedIn.isDisplayed();
        extentTest.pass("Giriş işlemi başarili bir sekilde yapildi");


        //Click 'Logout' button
        WebElement logOutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        extentTest.info("Logout butonuna tiklanir");

        jsClick(logOutButton);
        extentTest.info("Loout butonuna basari ile tiklanir");


        //Verify that user is navigated to login page
        WebElement afterLoggedOut = driver.findElement(By.xpath("//*[.='Login to your account']"));
       Assert.assertTrue(afterLoggedOut.isDisplayed());
        extentTest.info("Kullanıcının giriş sayfasına yönlendirilir");
        extentTest.pass("Kullanıcı giriş sayfasına başarili bir sekilde yönlendirildi");


        extentReports.flush();


    }
}
