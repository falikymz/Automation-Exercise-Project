package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_14 extends TestBase {
    @Test
    public void testCase14() {

        rapor("Chrome","Automation Exercise Test Case 11");
        extentTest=extentReports.createTest("Automation Exercise","Test Case 14");

        //1. Launch browser
        extentTest.info(" launch chrome browser");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url 'http://automationexercise.com'");

        //3. Verify that home page is visible successfully
        String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Home']")).getAttribute("style");
        String expectedHomePageButtonColor ="color: orange;";
        Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);
        extentTest.info("//3.Verify that home page is visible successfully");
        extentTest.pass("Test Pass");

        //4. Add products to cart
        Actions actions =new Actions(driver);
        WebElement product1 =driver.findElement(By.xpath("(//div[@class='col-sm-4'])[2]"));
        actions.moveToElement(product1).perform();
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        WebElement product2 =driver.findElement(By.xpath("(//div[@class='col-sm-4'])[3]"));
        actions.moveToElement(product2).perform();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        extentTest.info("Add products to cart");



        //5. Click 'Cart' button
        extentTest.info("Click 'Cart' button");
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        //6. Verify that cart page is displayed
        String actualCartPageButtonColor = driver.findElement(By.xpath("//a[text()=' Cart']")).getAttribute("style");
        String expectedCartPageButtonColor ="color: orange;";
        Assert.assertEquals(expectedCartPageButtonColor,actualCartPageButtonColor);
        extentTest.info("//3.Verify that Cart page is visible successfully");
        extentTest.pass("Test Pass");


        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        extentTest.info("Click Proceed To Checkout");


        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
        extentTest.info("Click 'Register / Login' button");


        //9. Fill all details in Signup and create account
        Faker faker = new Faker();
       WebElement nameSignUp= driver.findElement(By.xpath("//input[@name='name']"));
       nameSignUp.sendKeys(faker.name().fullName(), Keys.TAB,faker.internet().emailAddress(),Keys.ENTER);
        extentTest.info("Fill all details in Signup and create account");


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        extentTest.info("");


        //11. Verify ' Logged in as username' at top
        extentTest.info("");


        //12.Click 'Cart' button
        extentTest.info("");


        //13. Click 'Proceed To Checkout' button
        extentTest.info("");


        //14. Verify Address Details and Review Your Order
        extentTest.info("");


        //15. Enter description in comment text area and click 'Place Order'
        extentTest.info("");


        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        extentTest.info("");


        //17. Click 'Pay and Confirm Order' button
        extentTest.info("");


        //18. Verify success message 'Your order has been placed successfully!'
        extentTest.info("");


        //19. Click 'Delete Account' button
        extentTest.info("");


        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        extentTest.info("");


    }


}
