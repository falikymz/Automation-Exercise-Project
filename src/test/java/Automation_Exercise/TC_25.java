package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class TC_25 extends TestBase {

    @Test
    public void test1() {


        rapor("Chrome","Automation Exercise ","TC_25","Gulsen Tekeli");
        extentTest = extentReports.createTest("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality","Test Steps");
//Lunch Browser
        driver.get("https://www.google.com");
        extentTest.info("Launch browser");
        //Navigate to url
        driver.navigate().to("http://automationexercise.com");
        extentTest.info("Navigate to url http://automationexercise.com ");

        //Verify that home page is visible successfully
        String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Home']")).getAttribute("style");
        String expectedHomePageButtonColor ="color: orange;";
        waitForSecond(3);
        Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);
        extentTest.info("Verify that home page is visible successfully");

        JavascriptExecutor js=(JavascriptExecutor)driver;
        List<WebElement> elements = driver.findElements(By.xpath("//div[@title='Advertisement']"));
        for (WebElement w:elements) {
            js.executeScript("arguments[0].setAttribute('style','none')",w);
        }


        //Scroll down page to bottom
        waitForSecond(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        waitForSecond(3);
        extentTest.info("Scroll down page to bottom");

        // Verify 'SUBSCRIPTION' is visible

        driver.navigate().refresh();
        String subscription= driver.findElement(By.xpath("//*[.='Subscription']")).getText().toUpperCase();
        Assert.assertEquals("SUBSCRIPTION",subscription);
        waitForSecond(3);
        //Scroll UP page to bottom
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        extentTest.info("Verify 'SUBSCRIPTION' is visible");

        waitForSecond(2);

        //Click on arrow at bottom right side to move upward

        WebElement scrollUp= driver.findElement(By.cssSelector("#scrollUp"));

        scrollUp.click();
        waitForSecond(2);
        extentTest.info("Click on arrow at bottom right side to move upward");

        //Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        waitForSecond(2);

        List<WebElement> actual = driver.findElements(By.xpath(("//h2[.='Full-Fledged practice website for Automation Engineers']")));
        WebElement actual1 =actual.get(0);
        WebElement actual2 =actual.get(1);
        WebElement actual3 =actual.get(2);
        waitForSecond(2);

        Assert.assertTrue(actual1.isDisplayed()||actual2.isDisplayed()||actual3.isDisplayed());
        waitForSecond(2);

        // Assert.assertEquals("Full-Fledged practice website for Automation Engineers",actual);
        extentTest.info("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        extentTest.info("TEST PASSED");
        extentReports.flush();
    }
}
