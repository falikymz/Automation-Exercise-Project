package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_09 extends TestBase {


    @Test
    public void TestCase09() {
        rapor("Chrome","Automation Exercise Test","TC_09");
        extentTest=extentReports.createTest("Automation Exercise","Test Case 09");

        //1. Launch browser(1. Tarayıcıyı başlatın)
        extentTest.info("Tarayıcı başlatıldı");

        //2. Navigate to url 'http://automationexercise.com'(2. 'http://automationexercise.com' URL'sine gidin)
        driver.get("http://automationexercise.com");
        extentTest.info("'http://automationexercise.com' sitesine gidildi");

        //3.Verify that home page is visible successfully(3. Ana sayfanın başarıyla göründüğünü doğrulayın)
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
        extentTest.info("Ana sayfanın başarılı bir şekilde göründüğü doğrulandı");


        //4.Click on 'Products' button(4. 'Ürünler' düğmesine tıklayın)
        driver.findElement(By.xpath("(//a[@href='/products'])")).click();
        extentTest.info("Ürünler düğmesine tıklandı");

        // 5. Verify user is navigated to ALL PRODUCTS page successfully(5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın)
        String  actualAllProductsButton=driver.findElement(By.xpath("(//h2[@class='title text-center'])")).getText();
        String expectedAllProductsButton="ALL PRODUCTS";
        Assert.assertEquals(expectedAllProductsButton,actualAllProductsButton);
        extentTest.info("Kullanıcının 'TÜM ÜRÜNLER' sayfasına başarıyla yönlendirildiği doğrulandı");


        // 6. Enter product name in search input and click search button(6. Arama girişine ürün adını girin ve ara butonuna tıklayın)
        driver.findElement(By.id("search_product")).sendKeys("Green Side Placket Detail T-Shirt");
        driver.findElement(By.id("submit_search")).click();
        extentTest.info("Arama girişine ürün adı girildi ve ara butonuna tıklandı");


        Actions actions = new Actions(driver);
        WebElement kids = driver.findElement(By.xpath("(//*[@href='/brand_products/Allen Solly Junior'])"));
        actions.scrollToElement(kids).perform();

        //7. Verify 'SEARCHED PRODUCTS' is visible(7. 'ARALANAN ÜRÜNLER'in görünür olduğunu doğrulayın)
        WebElement seachedProducts = driver.findElement(By.xpath("(//*[@src='/get_product_picture/29'])"));
        Assert.assertTrue(seachedProducts.isDisplayed());
        extentTest.info("'ARALANAN ÜRÜNLER'in görünür olduğu doğrulandı");

        //8. Verify all the products related to search are visible(8. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın)
        String  actualAllSearchedProducts=driver.findElement(By.xpath("(//*[@class='title text-center'])")).getText();
        String expectedAllSearchedProducts="SEARCHED PRODUCTS";
        Assert.assertEquals(expectedAllSearchedProducts,actualAllSearchedProducts);
        extentTest.info("Aramayla ilgili tüm ürünlerin görünür olduğu doğrulandı");
        extentTest.pass("TEST BAŞARILI OLDU");

        extentReports.flush();
        driver.quit();
    }
}