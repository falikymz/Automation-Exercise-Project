package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TC_21 extends TestBase {

    @Test
    public void testCase21() {

        JavascriptExecutor js=(JavascriptExecutor)driver;
        rapor("Chrome","Automation Exercise");
            extentTest=extentReports.createTest("Automation Exercise","Test Case 11");

        //1. Launch browser
        driver.get("https://www.google.com");
        extentTest.info("1. Launch browser");


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("2. Navigate to url 'http://automationexercise.com'");


        //3. Click on 'Products' button
        WebElement products =driver.findElement(By.xpath("//a[text()=' Products']"));
        products.click();
        extentTest.info("Click on 'Products' button");


        //4. Verify user is navigated to ALL PRODUCTS page successfully
        products=driver.findElement(By.xpath("//a[text()=' Products']"));
        String actualData = products.getAttribute("style");
        Assert.assertEquals("color: orange;",actualData);
        extentTest.info("4. Verify user is navigated to ALL PRODUCTS page successfully");
        extentTest.pass("Test Pass");


        //5. Click on 'View Product' button
        WebElement product1 = driver.findElement(By.xpath("//a[text()='View Product']"));
        js.executeScript("arguments[0].click()",product1);

        extentTest.info("5. Click on 'View Product' button");


        //6. Verify 'Write Your Review' is visible
        WebElement reviewText =driver.findElement(By.xpath("//a[text()='Write Your Review']"));
        Assert.assertTrue(reviewText.isDisplayed());
        extentTest.info("6. Verify 'Write Your Review' is visible");
        extentTest.pass("Test Pass");



        //7. Enter name, email and review
        Faker faker = new Faker();

        WebElement nameBox =driver.findElement(By.xpath("//input[@id='name']"));
        nameBox.sendKeys(faker.name().firstName(), Keys.TAB,faker.internet().emailAddress());
        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='review']"));
        textArea.sendKeys(faker.lorem().paragraph(2));
        extentTest.info("7. Enter name, email and review");


        //8. Click 'Submit' button
        WebElement submitButton =driver.findElement(By.xpath("//button[@id='button-review']"));
        js.executeScript("arguments[0].click()",submitButton);
        extentTest.info("//8. Click 'Submit' button");


        //9. Verify success message 'Thank you for your review.'
        WebElement sendMessageText = driver.findElement(By.xpath("//span[text()='Thank you for your review.']"));
        Assert.assertTrue(sendMessageText.isDisplayed());
        extentTest.info("9. Verify success message 'Thank you for your review.'");
        extentTest.pass("Test Pass");


    }
}
