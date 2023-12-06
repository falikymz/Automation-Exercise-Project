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

        rapor("Chrome","Automation Exercise ","TC_04","Kadir Furkan Kilic");
        extentTest=extentReports.createTest("Test Case 4: Logout User","Test Steps");
        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("User goes to Automation Exercise home page.");

        //Verify that home page is visible successfully
        WebElement automationWriting = driver.findElement(By.xpath("(//*[.='Automation'])[1]"));
        Assert.assertTrue(automationWriting.isDisplayed());
        extentTest.info("Verify that home page is visible successfully");
        extentTest.pass("Test Pass");


        //Click on the login button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        extentTest.info("Click on the login button");

        WebElement loginToAccount = driver.findElement(By.xpath("//*[.='Login to your account']"));
        Assert.assertTrue(loginToAccount.isDisplayed());
        extentTest.info("Go to the login page");
        extentTest.pass("Test pass");

        //Enter correct email address and password
        WebElement mail = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        WebElement pass = driver.findElement(By.xpath("(//*[@name='password'])[1]"));
        WebElement loginBox = driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]"));
        mail.sendKeys("jordan.arjen@forkshape.com");
        pass.sendKeys("123456789");
        loginBox.submit();
        extentTest.info("Enter correct email address and password");

        //Verify that 'Logged in as username' is visible
        WebElement LoggedIn = driver.findElement(By.xpath("//*[.='Furkan Can']"));
       Assert.assertTrue(LoggedIn.isDisplayed());
       extentTest.pass("Verify that 'Logged in as username' is visible");
        extentTest.pass("Test pass");


        //Click 'Logout' button
        WebElement logOutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
        jsClick(logOutButton);
        extentTest.info("Click on the Logout button");


        //Verify that user is navigated to login page
        WebElement afterLoggedOut = driver.findElement(By.xpath("//*[.='Login to your account']"));
         Assert.assertTrue(afterLoggedOut.isDisplayed());
        extentTest.info("Verify that user is navigated to login page");
        extentTest.pass("Test pass");


        extentReports.flush();


    }
}
