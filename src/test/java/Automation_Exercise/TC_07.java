package Automation_Exercise;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static junit.framework.TestSuite.createTest;

public class TC_07 extends TestBase {
    @Test
    public void test1() {

        // 1. Launch browser

        driver.get("https://www.google.com");
        rapor("Chrome","Automation Exercise ","TC_07","Orhan Kaynar");
        extentTest=extentReports.createTest("Test Case 7: Verify Test Cases Page", "Test Steps");


        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info(" Navigate to url");

        // 3. Verify that home page is visible successfully

        WebElement logoPage= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoPage.isDisplayed());
        extentTest.info("Verify that home page is visible successfully");

        // 4. Click on 'Test Cases' button

        driver.findElement(By.xpath("//button[@type='button'][1]")).click();
        extentTest.info("Click on 'Test Cases' button");

        // 5. Verify user is navigated to test cases page successfully

        WebElement testCasesPage=driver.findElement(By.xpath("//b"));
        Assert.assertTrue(testCasesPage.isDisplayed());
        waitForSecond(2);
        extentTest.info("Verify user is navigated to test cases page successfully");
        extentTest.pass("Test Pass");
        extentReports.flush();
    }

}
