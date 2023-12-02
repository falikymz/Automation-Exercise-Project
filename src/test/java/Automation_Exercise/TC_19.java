package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_19 extends TestBase {


    @Test
    public void test01() {


        rapor("chrome","Test19 Otomation Exercise Testi");
        extentTest=extentReports.createTest("Automation Exercise","Test Case 19");

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("User goes to Automation Exercise home page.");

        //Click on 'Products' button
       WebElement product = driver.findElement(By.xpath("//a[@href='/products']"));
       jsClick(product);
        extentTest.info("Click on 'Products' button");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //Verify that Brands are visible on left side bar
        WebElement brands = driver.findElement(By.xpath("(//h2)[2]"));
        Assert.assertTrue(brands.isDisplayed());
        extentTest.info("Verify that Brands are visible on left side bar");
        extentTest.pass("Test pass");

        //Click on any brand name
        WebElement poloButton =  driver.findElement(By.xpath("//a[@href='/brand_products/Polo']"));
        jsClick(poloButton);
        extentTest.info("Click on any brand name");

        //Verify that user is navigated to brand page and brand products are displayed
        WebElement poloBrand = driver.findElement(By.xpath("//*[@class='title text-center']"));
        WebElement scrollHM = driver.findElement(By.xpath("//a[@href='/brand_products/H&M']"));
        Assert.assertTrue(poloBrand.isDisplayed());
        extentTest.info("Verify that user is navigated to brand page and brand products are displayed");
        extentTest.pass("Test pass");
         actions.scrollToElement(scrollHM).perform();



        //On left side bar, click on any other brand link
       WebElement HMButton = driver.findElement(By.xpath("//a[@href='/brand_products/H&M']"));
       jsClick(HMButton);
       extentTest.info("On left side bar, click on any other brand link");

        //Verify that user is navigated to that brand page and can see products
        WebElement hmBrand = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(hmBrand.isDisplayed());
        extentTest.info("Verify that user is navigated to that brand page and can see products");
        extentTest.pass("Test pass");

        extentReports.flush();
    }
}
