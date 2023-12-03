package Automation_Exercise;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_11 extends TestBase {

    @Test
    public void testCase11() {
        rapor("Chrome","Automation Exercise Test","TC_11");
        extentTest=extentReports.createTest("Automation Exercise","Test Case 11");

        //1. Launch browser
        extentTest.info("Launch browser");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url 'http://automationexercise.com'");

        //3.Verify that home page is visible successfully
       String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Home']")).getAttribute("style");
       String expectedHomePageButtonColor ="color: orange;";
       Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);
        extentTest.info("//3.Verify that home page is visible successfully");
        extentTest.pass("Test Pass");

        //4. Click 'Cart' button
       driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        extentTest.info("Click 'Cart' button");

        //5. Scroll down to footer  //6. Verify text 'SUBSCRIPTION'
        String actualSubcribeText = driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
        extentTest.info("Scroll down to footer  //6. Verify text 'SUBSCRIPTION'");
        Assert.assertEquals("SUBSCRIPTION",actualSubcribeText);
       extentTest.pass("Test Pass");


        //7. Enter email address in input and click arrow button
        Faker faker =new Faker();
        WebElement subscribeEmailBox = driver.findElement(By.id("susbscribe_email"));
        subscribeEmailBox.sendKeys(faker.internet().emailAddress(),Keys.ENTER);
        extentTest.info("Enter email address in input and click arrow button");


        //8. Verify success message 'You have been successfully subscribed!' is visible
        String actualSubscribeSuccessMessage = driver.findElement(By.xpath("//*[@class='alert-success alert']")).getText();
        Assert.assertEquals("You have been successfully subscribed!",actualSubscribeSuccessMessage);
        extentTest.info("Verify success message 'You have been successfully subscribed!' is visible");
        extentTest.pass("Test Pass");

        extentReports.flush();



    }
}
