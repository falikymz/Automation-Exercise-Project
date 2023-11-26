package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_10 extends TestBase {

    @Test
    public void Test() {

        //1. Launch browser
        rapor("browser","automationexercise");
        extentTest=extentReports.createTest("Test Case 10: Verify Subscription in home page","Test10");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Kullanıcı automationexercise sayfasına gider.");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        extentTest.info("Verify that home page is visible successfully.");
        extentTest.pass("Test Pass");

        //4. Scroll down to footer  //5. Verify text 'SUBSCRIPTION'
        String actualSubcribeText = driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
        Assert.assertEquals("SUBSCRIPTION",actualSubcribeText);
        extentTest.info("Scroll down to footer  //6. Verify text 'SUBSCRIPTION'.");
        extentTest.pass("Test Pass");

        //6. Enter email address in input and click arrow button
        Faker faker =new Faker();
        WebElement subscribeEmailBox = driver.findElement(By.id("susbscribe_email"));
        subscribeEmailBox.sendKeys(faker.internet().emailAddress(),Keys.ENTER);
        extentTest.info("Enter email address in input and click arrow button.");


        //7. Verify success message 'You have been successfully subscribed!' is visible
        String actualSubscribeSuccessMessage = driver.findElement(By.xpath("//*[@class='alert-success alert']")).getText();
        Assert.assertEquals("You have been successfully subscribed!",actualSubscribeSuccessMessage);
        extentTest.info("Verify success message 'You have been successfully subscribed!' is visible.");
        extentTest.pass("Test Pass");

    }
}
