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
        extentTest.info("Kullanıcı Automation Exercise anasayfasına gider.");

        //Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        extentTest.info("Product butonuna tıklanır");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //Verify that Brands are visible on left side bar
        WebElement brands = driver.findElement(By.xpath("(//h2)[2]"));
        Assert.assertTrue(brands.isDisplayed());
        extentTest.info("Brands butonu nun görüntülendiği doğrulanır");
        extentTest.pass("Brands butonu nun görüntülendiği doğrulandı");

        //Click on any brand name
        driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();
        extentTest.info("Herhangi bir Brands e tıklanır");

        //Verify that user is navigated to brand page and brand products are displayed
        WebElement poloBrand = driver.findElement(By.xpath("//*[@class='title text-center']"));
        WebElement HM = driver.findElement(By.xpath("//a[@href='/brand_products/H&M']"));
        Assert.assertTrue(poloBrand.isDisplayed());
        extentTest.info("Brands sayfasına gidilir ve sayfa görüntülenir");
        extentTest.pass("Brands sayfasına gidildi ve başarı ile görüntülendi");
        actions.scrollToElement(HM).perform();



        //On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[@href='/brand_products/H&M']")).click();
        extentTest.info("Başka bir Brands e başarılı bir şekilde tıklanır");

        //Verify that user is navigated to that brand page and can see products
        WebElement hmBrand = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(hmBrand.isDisplayed());
        extentTest.info("Başka bir Brands sayfasına gidilir");
        extentTest.pass("Başarılı bir şekilde başka bir Brands sayfasına gidildi");

        extentReports.flush();
    }
}
