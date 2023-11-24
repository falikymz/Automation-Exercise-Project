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
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        String actualHomeAttribute = home.getAttribute("style");
        String expectedHomeAttribute = "color: orange;";

        Assert.assertEquals(expectedHomeAttribute,actualHomeAttribute);

        //4. Click 'View Product' for any product on home page
        Actions actions = new Actions(driver);
        WebElement product = driver.findElement(By.xpath("(//*[@style='color: brown;'])[1]"));
        actions.scrollToElement(product).perform();
        product.click();

        //5. Verify product detail is opened
        String expectedUrl = "https://automationexercise.com/product_details/1";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //6. Increase quantity to 4
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.sendKeys(Keys.DELETE); // Deleted default quantity
        quantity.sendKeys("4");

        //7. Click 'Add to cart' button

        //Class name is unique but space will cause to taking wrong result that is why I took with Xpath.
        WebElement addToCart = driver.findElement(By.xpath("//*[@class ='btn btn-default cart']"));
        addToCart.click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        WebElement cartQuantity = driver.findElement(By.className("disabled"));

        String actualQuantity = cartQuantity.getText();
        String expectedQuantity = "4";

        Assert.assertEquals(expectedQuantity,actualQuantity);
    }
}
