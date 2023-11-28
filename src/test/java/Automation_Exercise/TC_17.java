package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class TC_17 extends TestBase {
/*
Test Case 17: Remove Products From Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
*/

    @Test
    public void TestCase17() {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        rapor("Chrome", "Automation Exercise Test");
        extentTest = extentReports.createTest("Automation Exercise", "Test Case 17");

        //1. Launch browser(1. Tarayıcıyı başlatın)
        extentTest.info("Tarayıcı başlatıldı");

        //2. Navigate to url 'http://automationexercise.com'(2. 'http://automationexercise.com' URL'sine gidin)
        driver.get("http://automationexercise.com");
        extentTest.info("'http://automationexercise.com'sitesine gidildi");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@title='Advertisement']"));
        for (WebElement w:elements) {
            js.executeScript("arguments[0].setAttribute('style','none')",w);
        }



        //3.Verify that home page is visible successfully(3. Ana sayfanın başarıyla göründüğünü doğrulayın)
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
        extentTest.info("Ana sayfanın başarıyla göründüğü doğrulandı");


        Actions actions = new Actions(driver);
        WebElement kids = driver.findElement(By.xpath("(//*[@href='/brand_products/Allen Solly Junior'])"));
        actions.scrollToElement(kids).perform();


        //4. Add products to cart(4. Ürünleri sepete ekleyin)
        WebElement blueTop = driver.findElement(By.xpath("(//*[@src='/get_product_picture/1'])"));
        actions.moveToElement(blueTop).perform();
        driver.findElement(By.xpath("(//*[@data-product-id='1'])")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-success close-modal btn-block'])")).click();


        WebElement menTshirt = driver.findElement(By.xpath("(//*[@src='/get_product_picture/2'])"));
        actions.moveToElement(menTshirt).perform();
        driver.findElement(By.xpath("(//*[@data-product-id='2'])")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-success close-modal btn-block'])")).click();


        WebElement sleevelessDress = driver.findElement(By.xpath("(//*[@src='/get_product_picture/3'])"));
        actions.moveToElement(sleevelessDress).perform();
        driver.findElement(By.xpath("(//*[@data-product-id='3'])")).click();
        extentTest.info("Sepete üç ürün başarılı bir şekilde eklendi");


        //5. Click 'Cart' button(5. 'Sepet' düğmesine tıklayın)
        driver.findElement(By.xpath("(//a[@href='/view_cart'])")).click();
        extentTest.info("'Sepet' düğmesine tıklandı");

        //6. Verify that cart page is displayed(6. Sepet sayfasının görüntülendiğini doğrulayın)
        WebElement cartPage = driver.findElement(By.xpath("(//*[@class='active'])"));
        Assert.assertTrue(cartPage.isDisplayed());
        extentTest.info("Sepet sayfasının görüntülendiği doğrulandı");

        //7. Click 'X' button corresponding to particular product(7. Belirli bir ürüne karşılık gelen 'X' düğmesini tıklayın)
        driver.findElement(By.xpath("(//*[@class='cart_quantity_delete'])")).click();
        extentTest.info("Sepetten bir ürün silindi");

        //8. Verify that product is removed from the cart(8. Ürünün sepetten kaldırıldığını doğrulayın)
        WebElement cartQuantity = driver.findElement(By.className("disabled"));
        String actualQuantity = cartQuantity.getText();
        String expectedcart="1";
        Assert.assertEquals(expectedcart,actualQuantity);
        extentTest.info("Ürünün sepetten kaldırıldığı doğrulandı");
        extentTest.pass("TEST BAŞARILI OLDU");

        extentReports.flush();
        driver.quit();
    }
}