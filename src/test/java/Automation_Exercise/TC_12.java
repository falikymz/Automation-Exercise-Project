package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_12 extends TestBase {
    //Launch browser
    @Test
    public void test01() {
        //1-Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //2-Verify that home page is visible successfully
        String expectedHomePageUrl = "https://automationexercise.com/";
        String actualHomePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedHomePageUrl,actualHomePageUrl);
        //3-Click 'Products' button
        WebElement productsButton = driver.findElement(By.xpath("//*[@href='/products']"));
        productsButton.click();
    }
}
