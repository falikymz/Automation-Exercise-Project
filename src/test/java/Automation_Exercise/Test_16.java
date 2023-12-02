package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_16 extends TestBase {

    @Test
    public void test16() {



        registerTestBase();//TestBase Classındaki bu method ile önce register olunmalı.


//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        // Verify that home page is visible successfully

        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());





        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();



//        5. Fill email, password and click 'Login' button

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(getEmaill(), Keys.TAB);

        driver.findElement(By.name("password")).sendKeys(getPassword());

        driver.findElement(By.xpath("//button[.='Login']")).click();

//        6. Verify 'Logged in as username' at top
        String actualGetText=  driver.findElement(By.xpath("//li[10]")).getText();
        String expectedText="Logged in as "+getFirstName()+getLastName();
        Assert.assertEquals(expectedText,actualGetText);

        Actions actions1=new Actions(driver);


        for (int i = 0; i <1 ; i++) {

            actions1.sendKeys(Keys.PAGE_DOWN).perform();

        }

        Faker faker=new Faker();
//        7. Add products to cart
        int index=faker.number().numberBetween(1,4);

        actions1.scrollToElement(driver.findElement(By.xpath("(//h2[.='Rs. 400'])[1]"))).perform();

        WebElement myChoose= driver.findElement(By.xpath("(//a[@data-product-id='"+index+"'])[1]"));

        actions1.scrollToElement(driver.findElement(By.xpath("(//h2[.='Rs. 400'])[1]"))).perform();
        myChoose.click();


        JavascriptExecutor js= (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click",myChoose);

        WebElement contiue=driver.findElement(By.xpath("//button[.='Continue Shopping']"));
        js.executeScript("arguments[0].click()",contiue);
        //  8. Click 'Cart' button


        Actions actions=new Actions(driver);

        actions.sendKeys(Keys.UP).perform();
        WebElement cartButton= driver.findElement(By.xpath("//a[@href='/view_cart']"));

        js.executeScript("arguments[0].click()",cartButton);




//        9. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("(//table//tr//td[2])[1]")).isDisplayed());


//        10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();

//        11. Verify Address Details and Review Your Order

        //(//li[@class='address_address1 address_address2'])[1]

        String ortakAdresDelivery=driver.findElement(By.id("address_delivery")).getText().substring(21);
        String ortakAdresShipp=driver.findElement(By.id("address_invoice")).getText().substring(20);

        Assert.assertEquals(ortakAdresShipp,ortakAdresDelivery);

//        12. Enter description in comment text area and click 'Place Order'
        WebElement webElementPlaceOrder=driver.findElement(By.xpath("//a[@href='/payment']"));

        actions.scrollToElement(webElementPlaceOrder).perform();
        driver.findElement(By.name("message")).sendKeys("Acil kargolayabilir misiniz?");
        webElementPlaceOrder.click();

//        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys(faker.name().fullName(),Keys.TAB);
        driver.findElement(By.name("card_number")).sendKeys("1234567891234567",Keys.TAB);
        driver.findElement(By.name("cvc")).sendKeys(""+faker.number().numberBetween(100,999),Keys.TAB);
        driver.findElement(By.name("expiry_month")).sendKeys(faker.number().numberBetween(1,12)+"",Keys.TAB);

        driver.findElement(By.name("expiry_year")).sendKeys(faker.number().numberBetween(1950,2035)+"",Keys.TAB);

//        14. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

//        15. Verify success message 'Your order has been placed successfully!'

        String alertMessage=driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).getText();
        String expectedTextAlert="'Your order has been placed successfully!'";
        //Assert.assertEquals(expectedTextAlert,alertMessage);
//        16. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String deletedMessage= driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        Assert.assertEquals("ACCOUNT DELETED!",deletedMessage);
        driver.findElement(By.xpath("//a[.='Continue']")).click();






    }


}
