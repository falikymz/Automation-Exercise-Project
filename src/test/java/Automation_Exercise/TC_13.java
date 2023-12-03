package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_13 extends TestBase {
    @Test
    public void testCase13() {
        rapor("Chrome","AutomationExerciseTest","13");
        extentTest= extentReports.createTest("Automation Exercise Negative Test ","Test Steps");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Kullanıcı Automation Exercise sayfasına gider.");

        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        String actualHomeAttribute = home.getAttribute("style");
        String expectedHomeAttribute = "color: orange;";

        Assert.assertEquals(expectedHomeAttribute,actualHomeAttribute);
        extentTest.pass("Anasayfa'nin görüntülendiği doğrulandı.");

        //4. Click 'View Product' for any product on home page
        Actions actions = new Actions(driver);
        WebElement product = driver.findElement(By.xpath("(//*[@style='color: brown;'])[1]"));
        actions.scrollToElement(product).perform();
        product.click();
        extentTest.info("Kullanıcı View Product butonuna tıklar.");

        //5. Verify product detail is opened
        String expectedUrl = "https://automationexercise.com/product_details/1";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        extentTest.pass("View Product sayfasının görüntülendiği doğrulandı.");

        //6. Increase quantity to 4
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.sendKeys(Keys.DELETE); // Deleted default quantity
        quantity.sendKeys("4");
        extentTest.info("Kullanıcı ürün miktarını 4 olarak belirler.");

        //7. Click 'Add to cart' button

        //Class name is unique but space will cause to taking wrong result that is why I took with Xpath.
        WebElement addToCart = driver.findElement(By.xpath("//*[@class ='btn btn-default cart']"));
        addToCart.click();
        extentTest.info("Kullanıcı Add to cart butonuna tıklar.");

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u")).click();
        extentTest.info("Kullanıcı View Cart butonuna tıklar.");

        //9. Verify that product is displayed in cart page with exact quantity
        WebElement cartQuantity = driver.findElement(By.className("disabled"));

        String actualQuantity = cartQuantity.getText();
        String expectedQuantity = "4";

        Assert.assertEquals(expectedQuantity,actualQuantity);
        extentTest.pass("Ürün miktarının 4 olarak görüntülendiği doğrulandı.");


        extentReports.flush();
    }
}
