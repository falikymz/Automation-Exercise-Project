package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import javax.security.auth.kerberos.KerberosKey;
import java.time.Duration;

public class TC_12 extends TestBase {
    //Launch browser
    @Test
    public void test01() {
        rapor("Chrome","ProductAddToCartTest","TC_12");
        extentTest = extentReports.createTest("Execise Add to Cart Test","Test Steps");
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        //1-Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("automationexercise web sitesine gidildi.");

        //2-Verify that home page is visible successfully
        String expectedHomePageUrl = "https://automationexercise.com/";
        String actualHomePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedHomePageUrl,actualHomePageUrl);
        extentTest.pass("Ana sayfa başarıyla görüntülendi.");


        //3-Click 'Products' button
        WebElement productsButton = driver.findElement(By.xpath("//*[@href='/products']"));
        productsButton.click();
        extentTest.info("Products butonuna tıklandı.");


        //4-Hover over first product and click 'Add to cart'
        WebElement firstProduct = driver.findElement(By.xpath("//*[@src='/get_product_picture/1']"));

        //For Step 9 Storing Product Expected Price
        String firstProductExpectedPrice = driver.findElement(By.xpath("(//*[.='Rs. 500'])[1]")).getText();

        actions.moveToElement(firstProduct).perform();
        WebElement addToCartFirstProduct = driver.findElement(By.xpath("(//*[@data-product-id='1'])[2]"));
        jsClick(addToCartFirstProduct);
        extentTest.info("İlk ürünün üzerinde bekleyince ortaya çıkan Add to cart butonuna tıklandı.");

        //5-Click 'Continue Shopping' button
        WebElement continueShoppingButton = driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        jsClick(continueShoppingButton);
        wait.until(ExpectedConditions.invisibilityOf(continueShoppingButton));


        //6-Hover over second product and click 'Add to cart'
        WebElement secondProduct = driver.findElement(By.xpath("//*[@src='/get_product_picture/2']"));

        //For Step 9 Storing Product Expected Price
        String secondProductExpectedPrice = driver.findElement(By.xpath("(//*[.='Rs. 400'])[1]")).getText();

        actions.moveToElement(secondProduct).perform();
        WebElement addToCartSecondProduct = driver.findElement(By.xpath("(//*[@data-product-id='2'])[2]"));
        jsClick(addToCartSecondProduct);
        extentTest.info("İkinci ürünün üzerinde bekleyince ortaya çıkan Add to cart butonuna tıklandı.");

        //7-Click 'View Cart' button
        WebElement viewCartButton = driver.findElement(By.xpath("//*[text()='View Cart']"));
        viewCartButton.click();
        extentTest.info("Wiev Cart butonuna tıklandı.");

        //8-Verify both products are added to Cart

        //first product
        WebElement firstProductVerify = driver.findElement(By.xpath("//*[@src='get_product_picture/1']"));
        Assert.assertTrue(firstProductVerify.isDisplayed());
        extentTest.pass("İlk ürünün Cart a eklendiği doğrulandı.");
        //second Product
        WebElement secondProductVerify = driver.findElement(By.xpath("//*[@src='get_product_picture/2']"));
        Assert.assertTrue(secondProductVerify.isDisplayed());
        extentTest.pass("İkinci ürünün Cart a eklendiği doğrulandı.");

        //9-Verify their prices, quantity and total price

        //Verify Prices

        //-Product 1
        String firstProductActualPrice = driver.findElement(By.xpath("//*[@id='product-1']//*[@*='cart_total_price']")).getText();
        Assert.assertEquals(firstProductExpectedPrice,firstProductActualPrice);
        extentTest.pass("İlk ürünün fiyatının ürünü cart a eklemeden önceki ürün fiyatıyla aynı olduğu doğrulandı.");
        //-Product 2
        String secondProductActualPrice = driver.findElement(By.xpath("//*[@id='product-2']//*[@*='cart_total_price']")).getText();
        Assert.assertEquals(secondProductExpectedPrice,secondProductActualPrice);
        extentTest.pass("İkinci ürünün fiyatının ürünü cart a eklemeden önceki ürün fiyatıyla aynı olduğu doğrulandı.");
        //Verify Quantities

        //-Product 1
        WebElement firstProductActualQuantity = driver.findElement(By.xpath("//*[@id='product-1']//*[@*='cart_quantity']"));
        Assert.assertEquals("1",firstProductActualQuantity.getText());
        extentTest.pass("Eklenen ilk ürün miktarının 1 olduğu doğrulandı doğrulandı.");
        //-Product 2
        WebElement secondProductActualQuantity = driver.findElement(By.xpath("//*[@id='product-2']//*[@*='cart_quantity']"));
        Assert.assertEquals("1",secondProductActualQuantity.getText());
        extentTest.pass("Eklenen ikinci ürün miktarının 1 olduğu doğrulandı doğrulandı.");
        //Verify Total Prices

        //-Product 1
        String firstProductActualTotalPrice = driver.findElement(By.xpath("//*[@id='product-1']//*[@*='cart_total_price']")).getText();
        Assert.assertEquals(firstProductActualPrice,firstProductActualTotalPrice);
        extentTest.pass("İlk ürünün toplam fiyatının beklenen toplam fiyatla aynı olduğu doğrulandı..");
        //Product 2
        String secondProductActualTotalPrice = driver.findElement(By.xpath("//*[@id='product-2']//*[@*='cart_total_price']")).getText();
        Assert.assertEquals(secondProductActualPrice,secondProductActualTotalPrice);
        extentTest.pass("İkinci ürünün toplam fiyatının beklenen toplam fiyatla aynı olduğu doğrulandı..");
        extentReports.flush();

    }
}
