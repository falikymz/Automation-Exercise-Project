package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.TestBase;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TC_14 extends TestBase {
    @Test
    public void testCase14() {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        rapor("Chrome","Automation Exercise ","TC_14","Furkan Ali Kaymaz");
        extentTest=extentReports.createTest("Test Case 14: Place Order: Register while Checkout","Test Steps");

        //1. Launch browser
        extentTest.info(" launch chrome browser");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url 'http://automationexercise.com'");

        List<WebElement> elements = driver.findElements(By.xpath("//div[@title='Advertisement']"));
        for (WebElement w:elements) {
            js.executeScript("arguments[0].setAttribute('style','none')",w);
        }

        //3. Verify that home page is visible successfully
        String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Home']")).getAttribute("style");
        String expectedHomePageButtonColor ="color: orange;";
        Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);
        extentTest.info("//3.Verify that home page is visible successfully");
        extentTest.pass("Test Pass");

        //4. Add products to cart
        Actions actions =new Actions(driver);
        WebElement product1 =driver.findElement(By.xpath("(//div[@class='col-sm-4'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);",product1);
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        WebElement product2 =driver.findElement(By.xpath("(//div[@class='col-sm-4'])[3]"));
        actions.moveToElement(product2).perform();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        extentTest.info("Add products to cart");



        //5. Click 'Cart' button
        extentTest.info("Click 'Cart' button");
        WebElement cartButton=driver.findElement(By.xpath("//u[text()='View Cart']"));
        cartButton.click();

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
       String emailAddress =faker.internet().emailAddress();
       String fullName =faker.name().fullName();
       nameSignUp.sendKeys(fullName, Keys.TAB,emailAddress,Keys.ENTER);
        extentTest.info("Fill all details in Signup and create account");


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        //Gender Radio Button
        WebElement genderButton = driver.findElement(By.xpath("//*[@id='id_gender1']"));
        genderButton.click();

        //*Password Box
        WebElement pwdBox=driver.findElement(By.cssSelector("#password"));
        String pwd =faker.internet().password();
        pwdBox.sendKeys(pwd);

        // Locate to Dropdown Menu
        WebElement day =driver.findElement(By.xpath("//select[@id='days']"));
        WebElement month =driver.findElement(By.xpath("//select[@id='months']"));
        WebElement year =driver.findElement(By.xpath("//select[@id='years']"));

       day.sendKeys("11",Keys.ENTER);
       month.sendKeys("April",Keys.ENTER);
       year.sendKeys("2004",Keys.ENTER);

       //*Full Name Box
       WebElement firstName=driver.findElement(By.id("first_name"));
       firstName.sendKeys(faker.name().firstName(),Keys.TAB,faker.name().lastName());

       //*Adress Box
        WebElement adressBox =driver.findElement(By.id("address1"));
        String address =faker.address().fullAddress();
        adressBox.sendKeys(address);

        //*Country Box
        WebElement countryBox= driver.findElement(By.id("country"));
        countryBox.sendKeys("Canada");

        //*State Box
        WebElement stateBox = driver.findElement(By.xpath("//input[@id='state']"));
        stateBox.sendKeys(faker.address().state());

        //*City
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().cityName());

        //*Zipcode
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());

        //*Mobile Number
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());

        //Create Button
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).submit();

        WebElement creatSuccesfulMessage  = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertEquals("ACCOUNT CREATED!",creatSuccesfulMessage.getText());
        extentTest.info("Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        extentTest.pass("Test Pass");

        //11. Verify ' Logged in as username' at top

        //Continue Button
        WebElement continueButton=driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
        jsClick(continueButton);
        //!! wait reason google advertising ->manuel shut down
        waitForSecond(1);
        //Logged in as <data>

        String actualLoginText = driver.findElement(By.xpath("//b")).getText();
        Assert.assertEquals(fullName,actualLoginText);
        extentTest.info("Verify ' Logged in as username' at top");
        extentTest.pass("Test Pass");

        //12.Click 'Cart' button
        cartButton=driver.findElement(By.xpath("//a[text()=' Cart']"));
        jsClick(cartButton);
        extentTest.info("Click 'Cart' button");


        //13. Click 'Proceed To Checkout' button
        WebElement proceedToCheckButton=driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));
        jsClick(proceedToCheckButton);
        extentTest.info("Click 'Proceed To Checkout' button");


        //14. Verify Address Details and Review Your Order
        String actualDeliveryAdress= driver.findElement(By.xpath("//ul[@id='address_delivery']")).getText();
        Assert.assertTrue(actualDeliveryAdress.contains(address));
        extentTest.info("Verify Address Details and Review Your Order");
        extentTest.pass("Test Pass");

        //15. Enter description in comment text area and click 'Place Order'
        // Comment Box
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(faker.lorem().paragraph(1));

        //Place Order Button
        WebElement orderButton =driver.findElement(By.xpath("//a[text()='Place Order']"));
        jsClick(orderButton);
        extentTest.info("Enter description in comment text area and click 'Place Order'");


        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date

        //Name on Card
        driver.findElement(By.name("name_on_card")).sendKeys(fullName);

        //Card Number
        driver.findElement(By.name("card_number")).sendKeys(faker.finance().creditCard());


        //CVC
        driver.findElement(By.name("cvc")).sendKeys(faker.number().digits(3));


        //Expiration
        int randomMonthNumber=faker.number().numberBetween(1,13);
        String setMonthNumber=String.valueOf(randomMonthNumber);
        driver.findElement(By.name("expiry_month")).sendKeys(setMonthNumber);


        //Year
        int randomYearNumber=faker.number().numberBetween(1905,2023);
        String setYearNumber=String.valueOf(randomYearNumber);
        driver.findElement(By.name("expiry_year")).sendKeys(setYearNumber);

        extentTest.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date");


        //17. Click 'Pay and Confirm Order' button
        WebElement payConfirmButton =driver.findElement(By.id("submit"));
        jsClick(payConfirmButton);
        extentTest.info("Click 'Pay and Confirm Order' button");


        //18. Verify success message 'Congratulations! Your order has been confirmed!'
        WebElement verifyOrderText = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertEquals("Congratulations! Your order has been confirmed!",verifyOrderText.getText());
        extentTest.info("Verify success message 'Your order has been placed successfully!'");
        extentTest.pass("Test Pass");

        //19. Click 'Delete Account' button
        WebElement deleteAccButton=driver.findElement(By.xpath("//a[text()=' Delete Account']"));
        jsClick(deleteAccButton);
        extentTest.info("Click 'Delete Account' button");


        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String actualAccountDeleteText=driver.findElement(By.xpath("//b")).getText();
        Assert.assertEquals("ACCOUNT DELETED!",actualAccountDeleteText);
        extentTest.info("Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        extentTest.pass("Test Pass");

        extentReports.flush();

    }


}
