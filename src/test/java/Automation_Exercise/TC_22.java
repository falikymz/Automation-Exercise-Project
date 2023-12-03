package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_22 extends TestBase {

    @Test
    public void TestCase22() {

        rapor("Chrome","Automation Exercise ","TC_22","Muammer Ucar");
        extentTest=extentReports.createTest("Test Case 22: Add to cart from Recommended items","Test Steps");

        //1. Launch browser(1. Tarayıcıyı başlatın)
        extentTest.info("Tarayıcı başlatıldı.");

        //2. Navigate to url 'http://automationexercise.com'(2. 'http://automationexercise.com' URL'sine gidin)
        driver.get("http://automationexercise.com");
        extentTest.info("'http://automationexercise.com' sitesine gidildi.");

        //3. Scroll to bottom of page(3. Sayfanın en altına gidin)
        Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın en altına gidildi.");

        WebElement recommended = driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        actions.scrollToElement(recommended).perform();

        //4. Verify 'RECOMMENDED ITEMS' are visible(4. 'ÖNERİLEN ÖĞELER'in görünür olduğunu doğrulayın)

        WebElement recommendedItems=driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        Assert.assertTrue(recommendedItems.isDisplayed());
        extentTest.info("Önerilen Ögelerin görünür olduğu doğrulandı.");
        waitForSecond(5);

        //5. Click on 'Add To Cart' on Recommended product(5. Önerilen üründe 'Sepete Ekle'ye tıklayın)
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[3]")).click();
        extentTest.info("Önerilen üründe 'Sepete Ekle'ye tıklandı.");

        //6. Click on 'View Cart' button(6. 'Sepeti Görüntüle' düğmesine tıklayın)
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();
        extentTest.info("'Sepeti Görüntüle' düğmesine tıklandı.");

        //7. Verify that product is displayed in cart page(7. Ürünün sepet sayfasında görüntülendiğini doğrulayın)
        WebElement blueTop= driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        Assert.assertTrue(blueTop.isDisplayed());
        extentTest.info("Ürünün sepet sayfasında görüntülendiği doğrulandı.");
        extentTest.pass("TEST BAŞARILI OLDU");
        extentReports.flush();
        driver.quit();

    }
}
