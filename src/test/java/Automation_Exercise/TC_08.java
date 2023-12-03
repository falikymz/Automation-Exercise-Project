package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class TC_08 extends TestBase {
    @Test
    public void test01() {

        rapor("chrome", "TC08 Test Raporu","TC_08");
        extentTest=extentReports.createTest
                ("Automation Exercise","Verify All Products and product detail page");

        // 1. Tarayıcıyı başlatın
        //1.Launch browser

        // 2. 'http://automationexercise.com' url'sine gidin
        //2. Navigate to url 'http://automationexercise.com'

        // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
        // 3. Verify that home page is visible successfully

            driver.get("http://automationexercise.com");
            WebElement homePageLogo = driver.findElement(By.xpath
                    ("//img[@src='/static/images/home/logo.png']"));
            Assert.assertTrue(homePageLogo.isDisplayed());
            extentTest.info("Ana sayfanın başarıyla göründüğünü doğrulandi");


        // 4. 'Ürünler' düğmesine tıklayın
        // 4.Click on 'Products' button
        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement produckt = driver.findElement
                (By.xpath("//a[@href='/products']"));
        produckt.click();
        waitForSecond(2);
        String allProductText = driver.findElement
                (By.xpath("//h2[@class='title text-center']")).getText();
        Assert.assertEquals("ALL PRODUCTS",allProductText);
        extentTest.info("Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulandi");


        // 6. Ürün listesi görülebilir
        //6. The products list is visible
        WebElement productList = driver.findElement(By.xpath
                ("//div[@class='col-sm-9 padding-right']"));
        Assert.assertTrue(productList.isDisplayed());
        extentTest.info("Ürün listesi görüntülendi");



        // 7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        //7.Click on 'View Product' of first product
        // 8. Kullanıcı ürün detay sayfasına yönlendirilir
        //8.User is landed to product detail page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement erstProdukt = driver.findElement
                (By.xpath("//a[@href='/product_details/1']"));
        jsClick(erstProdukt);
        String productDetailUrl = driver.getCurrentUrl();
        Assert.assertTrue(productDetailUrl.contains("product_details"));
        extentTest.info("Kullanıcı ürün detay sayfasına yönlendirildi");



        // 9. Ayrıntı ayrıntılarının görünür olduğunu doğrulayın:
        // ürün adı, kategori, fiyat, stok durumu, durum, marka
        //9.Verify that detail detail is visible:
        // product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath
                ("//h2[.='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        extentTest.info("product name görünür oldugu dogrulandi");



        WebElement productCategory = driver.findElement
                (By.xpath("//p[.='Category: Women > Tops']"));
        Assert.assertTrue(productCategory.isDisplayed());
        extentTest.info("Product Category görünür oldugu dogrulandi");



        WebElement productPreis = driver.findElement
                (By.xpath("//span[.='Rs. 500']"));
        Assert.assertTrue(productPreis.isDisplayed());
        extentTest.info("Product Preis görünür oldugu dogrulandi");




        WebElement productAvailability = driver.findElement
                (By.xpath("//b[.='Availability:']"));
        Assert.assertTrue(productAvailability.isDisplayed());
        extentTest.info("Product Avalability görünür oldugu dogrulandi");




        WebElement productCondition = driver.findElement
                (By.xpath("//b[.='Condition:']"));
        Assert.assertTrue(productCondition.isDisplayed());
        extentTest.info("productCondition görünür oldugu dogrulandi");



        WebElement productBrand = driver.findElement
                (By.xpath("//b[.='Brand:']"));
        Assert.assertTrue(productBrand.isDisplayed());
        extentTest.info("productBrand görünür oldugu dogrulandi");

     extentReports.flush();
    }
}

