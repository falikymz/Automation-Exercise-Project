package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.security.Key;

public class TC_06 extends TestBase {


   /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully

    */

    @Test
    public void testCase06() {
        rapor("Chrome","Automation Exercise Test");
        extentTest=extentReports.createTest("Automation Exercise","Test Case 06");



        //1. Launch browser
        extentTest.info("Launch browser");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url 'http://automationexercise.com'");

        //3. Verify that home page is visible successfully

        String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Home']")).getAttribute("style");
        String expectedHomePageButtonColor ="color: orange;";
        Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);
        extentTest.info("Verify that home page is visible successfully");
        extentTest.pass("Test Pass");


        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
        extentTest.info("Click 'Contact Us' button ");

        //5. Verify 'GET IN TOUCH' is visible

        String actualGetInTouchMassege = driver.findElement(By.xpath("(//h2)[2]")).getText();
        Assert.assertEquals("GET IN TOUCH",actualGetInTouchMassege);
        extentTest.info("Verify 'GET IN TOUCH' is visible");
        extentTest.pass("Test Pass");

        //6. Enter name, email, subject and message

        Faker faker =new Faker();

        WebElement subscribeNameBox = driver.findElement(By.cssSelector("input[name='name']"));
        subscribeNameBox.sendKeys(faker.name().firstName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,
                faker.name().fullName(),Keys.TAB,
                faker.address().fullAddress(), Keys.TAB);
        extentTest.info("Enter name, email, subject and message");

        waitForSecond(4);



        //7. Upload file  //"C:\Users\ayseg\"
        //\OneDrive\Masaüstü\Batch189.txt
        WebElement chooseFile =driver.findElement(By.cssSelector("input[name='upload_file']"));

        String dynamicPath=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\upload file\\upload.png";
        chooseFile.sendKeys(dynamicPath);


        //8. Click 'Submit' button input[name='submit']

        driver.findElement(By.cssSelector("input[name='submit']")).submit();

        //9. Click OK button
        //there is not "OK" button
        driver.switchTo().alert().accept();


       //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        String actualSuccessMessage = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.",actualSuccessMessage);
        extentTest.info("Verify success message 'Success! Your details have been submitted successfully.' is visible.");
        extentTest.pass("Test Pass");

        extentReports.flush(); //col-sm-9 padding-right





        //11. Click 'Home' button and verify that landed to home page successfully

        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();










































    }
}

