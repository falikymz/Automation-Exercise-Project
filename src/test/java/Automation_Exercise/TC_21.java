package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_21 extends TestBase {

    @Test
    public void testCase21() {
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
        String actualData = products.getAttribute("style");
        Assert.assertEquals("color: orange;",actualData);
        extentTest.info("4. Verify user is navigated to ALL PRODUCTS page successfully");
        extentTest.pass("Test Pass");


        //5. Click on 'View Product' button
        WebElement product1 = driver.findElement(By.xpath("//a[text()='View Product']"));
        product1.click();
        extentTest.info("5. Click on 'View Product' button");


        //6. Verify 'Write Your Review' is visible
        WebElement reviewText =driver.findElement(By.xpath("//a[text()='Write Your Review']"));
        Assert.assertTrue(reviewText.isDisplayed());
        extentTest.info("6. Verify 'Write Your Review' is visible");
        extentTest.pass("Test Pass");



        //7. Enter name, email and review
        Faker faker = new Faker();

        WebElement nameBox =driver.findElement(By.xpath("//input[@id='name']"));
        nameBox.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName());
        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='review']"));
        textArea.sendKeys(faker.lorem().paragraph(2));
        extentTest.info("7. Enter name, email and review");


        //8. Click 'Submit' button

        extentTest.info("");


        //9. Verify success message 'Thank you for your review.'
        extentTest.info("");


    }
}
