package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class TC_24 extends TestBase {


    @Test
    public void test01() {
        rapor("chrome","Test24 Otomation Exercise Testi","TC_24");
        extentTest=extentReports.createTest("Automation Exercise","Test Case 24");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("User goes to Automation Exercise home page.");

        //3. Verify that home page is visible successfully
        WebElement automationWriting = driver.findElement(By.xpath("(//*[.='Automation'])[1]"));
       Assert.assertTrue(automationWriting.isDisplayed());
        extentTest.info("Verify that home page is visible successfully");
        extentTest.pass("Test pass");

        WebElement scroll = driver.findElement(By.xpath("//*[@href='/brand_products/Biba']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(scroll).perform();

        //4. Add products to cart
        WebElement addToCard = driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"));
        jsClick(addToCard);
        extentTest.info("Add products to cart");

        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();


        //5. Click 'Cart' button
        WebElement cart = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]"));
        actions.scrollToElement(cart).perform();
        jsClick(cart);
        extentTest.info("Click 'Cart' button");

        //6. Verify that cart page is displayed and click Proceed To Checkout
        WebElement verifiedCardPage = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
        Assert.assertTrue(verifiedCardPage.isDisplayed());
        jsClick(verifiedCardPage);
        extentTest.info("Verify that cart page is displayed and click Proceed To Checkout");
        extentTest.pass("Test pass");


        //8. Click 'Register / Login' button
        WebElement registerLogin = driver.findElement(By.xpath("(//u)[1]"));
        jsClick(registerLogin);
        extentTest.info("Click 'Register / Login' button");



        //9. Fill all details in Signup and create account
        Faker faker = new Faker();
        String name = faker.name().fullName();
        WebElement nameBox = driver.findElement(By.xpath("//*[@name='name'][1]"));
        nameBox.sendKeys(name);
        extentTest.info("Fill all details in Signup and create account");


        // Fill details: Title, Name, Email, Password, Date of birth
        String email = faker.internet().emailAddress();
        WebElement emailBox = driver.findElement(By.xpath("(//*[@name='email'])[2]"));
        emailBox.sendKeys(email);
        extentTest.info("Fill details: Title, Name, Email, Password, Date of birth");



        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();



        String actualVerify = driver.findElement(By.xpath("//h2")).getText();
        String acceptedVerify = "ENTER ACCOUNT INFORMATION";

        Assert.assertEquals(actualVerify,acceptedVerify);



        driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();


        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String verfiedName = faker.name().fullName();


        WebElement name2 = driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));

        name2.sendKeys(verfiedName,Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,
                faker.internet().password());


        WebElement day = driver.findElement(By.xpath("//*[@name='days']"));
        Select select = new Select(day);
        select.selectByVisibleText("5");



        WebElement mount = driver.findElement(By.xpath("//*[@id='months']"));
        Select select1 = new Select(mount);
        select1.selectByVisibleText("May");


        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("1996");



        WebElement signBox = driver.findElement(By.xpath("//*[@name='newsletter']"));
        signBox.click();



        WebElement reciveBox = driver.findElement(By.xpath("//*[@name='optin']"));
        reciveBox.click();


        waitForSecond(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String name3 = faker.name().fullName();

        WebElement fillAll = driver.findElement(By.xpath("//*[@id='first_name']"));
        fillAll.sendKeys(name3,Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,faker.company().name(),Keys.TAB,faker.address().streetAddress());

        waitForSecond(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String address = faker.address().fullAddress();
        WebElement fillAll2 = driver.findElement(By.xpath("//*[@name='address2']"));

        fillAll2.sendKeys(address,Keys.TAB,faker.address().secondaryAddress());

        WebElement city = driver.findElement(By.xpath("//*[@name='country']"));
        city.click();
        city.sendKeys("5");
        city.click();

        String state2 = faker.address().state();
        WebElement state = driver.findElement(By.xpath("(//*[@class='form-control'])[13]"));

        WebElement adress = driver.findElement(By.xpath("(//*[@class='form-control'])[10]"));
        waitForSecond(1);
        actions.moveToElement(adress);
        waitForSecond(1);
        actions.sendKeys(Keys.PAGE_DOWN);

        state.sendKeys(state2,Keys.TAB,
                faker.address().city(),
                Keys.TAB,faker.address().secondaryAddress(),
                Keys.TAB, faker.phoneNumber().cellPhone(),
                Keys.TAB, Keys.ENTER);

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actualCreatedSuccess = driver.findElement(By.xpath("//b")).getText();
        String acceptedCreatedSucces = "ACCOUNT CREATED!";
        Assert.assertEquals(actualCreatedSuccess,acceptedCreatedSucces);
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        extentTest.info("Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        extentTest.pass("Test pass");



        //11. Verify ' Logged in as username' at top
        WebElement loggedIn = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(loggedIn.isEnabled());
        extentTest.info("Verify ' Logged in as username' at top");
        extentTest.pass("Test pass");


        //12.Click 'Cart' button
        WebElement cart1 = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]"));
        jsClick(cart1);
        extentTest.info("Click 'Cart' button");



        //13. Click 'Proceed To Checkout' button
        WebElement addToCard1 = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
        jsClick(addToCard1);
        extentTest.info("Click 'Proceed To Checkout' button");



        //14. Verify Address Details and Review Your Order
        WebElement verifiyAdress = driver.findElement(By.xpath("(//*[@class='heading'])[1]"));
        Assert.assertTrue(verifiyAdress.isDisplayed());
        WebElement rewOrder = driver.findElement(By.xpath("(//*[@class='heading'])[2]"));
        Assert.assertTrue(rewOrder.isDisplayed());
        extentTest.info("Verify Address Details and Review Your Order");
        extentTest.pass("Test pass");


        //15. Enter description in comment text area and click 'Place Order'
        WebElement textArea = driver.findElement(By.xpath("//*[@class='form-control']"));
        textArea.sendKeys("The fabric of the product is beautiful.");
        waitForSecond(1);
        WebElement placeOrder = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
        jsClick(placeOrder);
        extentTest.info("Enter description in comment text area and click 'Place Order'");

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cardname = driver.findElement(By.xpath("//*[@class='form-control']"));
        WebElement carNumber = driver.findElement(By.name("card_number"));

        wait.until(ExpectedConditions.elementToBeClickable(carNumber));

         cardname.sendKeys(faker.name().firstName(),Keys.TAB,faker.finance().creditCard(),Keys.TAB,
                 "123",Keys.TAB,"26",Keys.TAB,"2070");
         extentTest.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date");

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[@class='form-control btn btn-primary submit-button']")).click();
        extentTest.info("Click 'Pay and Confirm Order' button");


        //18. Verify success message 'Your order has been placed successfully!'
        String succesMassage = driver.findElement(By.xpath("//*[.='Congratulations! Your order has been confirmed!']")).getText();
        Assert.assertNotEquals("Your order has been placed successfully!",succesMassage);
        extentTest.info("Verify success message 'Your order has been placed successfully!'");
        extentTest.pass("Test pass");


        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.

        String userHome = System.getProperty("user.home");
        String folderPath="\\Downloads\\invoice.txt";
        String dynamicPath =userHome+folderPath;

          try {
           Files.delete(Paths.get(dynamicPath));
           System.out.println("File deleted");
          } catch (IOException e) {
           System.out.println("The specified file could not be deleted. !!!!");
          }

         driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
         waitForSecond(3);
        Assert.assertTrue(Files.exists(Paths.get(dynamicPath)));

        extentTest.info("Click 'Download Invoice' button and verify invoice is downloaded successfully.");
        extentTest.pass("Test pass");


        //20. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        extentTest.info("Click 'Continue' button");


        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        extentTest.info("Click 'Delete Account' button");


        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deletedAccount = driver.findElement(By.xpath("(//*[.='Account Deleted!'])[1]"));
        Assert.assertTrue(deletedAccount.isDisplayed());
        extentTest.info("Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        extentTest.pass("Test pass");

        extentReports.flush();

    }
}
