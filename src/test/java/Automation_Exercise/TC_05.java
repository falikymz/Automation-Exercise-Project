package Automation_Exercise;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_05 extends TestBase {



    @Test
    public void testCase05() {
        Faker faker = new Faker();
        rapor("Chrome","Automation Exercise ","TC_05","Ibrahim Akar");
        extentTest= extentReports.createTest("Test Case 5: Register User with existing email","Test Steps");



        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Kullanıcı Automation Exercise sayfasına gider.");


        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        String actualHomeAttribute = home.getAttribute("style");
        String expectedHomeAttribute = "color: orange;";
        extentTest.pass("Anasayfa'nin görüntülendiği doğrulandı.");

        //4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("(//*[. =' Signup / Login'])[2]"));
        login.click();
        extentTest.info("Kullanıcı Signup / Login butonuna tıklar.");

        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("(//h2)[3]"));
        String expectedText = "New User Signup!";
        String actualText = newUser.getText();
        Assert.assertEquals(expectedText,actualText);
        extentTest.pass("New User Signup yazısının görüntülendiği doğrulandı.");

        //6. Enter name and already registered email address
        String name = faker.name().firstName();
        String email = "ibraka48@gmail.com";
        WebElement nameSection = driver.findElement(By.xpath("//input[@type='text']"));
        nameSection.sendKeys(name, Keys.TAB,email);
        extentTest.info("Kullanıcı isim ve daha önceden kayıtlı email bilgisini girer.");



        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        extentTest.info("Kullanıcı SignUp butonuna tıklar.");

        //8. Verify error 'Email Address already exist!' is visible
        WebElement errorMessage = driver.findElement(By.xpath("//p[@style='color: red;']"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Email Address already exist!";
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
        extentTest.pass("Kullanıcı email'in daha önceden kayıtlı olduğunu doğrular.");

        extentReports.flush();


    }
}
