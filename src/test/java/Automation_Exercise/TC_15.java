package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TC_15 extends TestBase {

    Faker faker = new Faker();

    @Test
    public void testCase_15() {
        rapor("Chrome","Automation Exercise ","TC_15","Rumeysa Aslan");
        extentTest=extentReports.createTest("Test Case 15: Place Order: Register before Checkout", "Test steps");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com/");
        extentTest.info("Kullanıcı Automation Exercise anasayfasına gider.");

        //3. Verify that home page is visible successfully

        WebElement homeButton = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(homeButton.isDisplayed());

        extentTest.pass("Anasayfanın başarıyla görüntülendiği doğrulandı");

        //4. Click 'Signup / Login' button
        WebElement signupLogin = driver.findElement(By.xpath("//a[@href='/login']"));
        jsClick(signupLogin);

        extentTest.info("Kayıt ol/Giriş yap butonuna tıklandı");

        //5. Fill all details in Signup and create account
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String address = faker.address().fullAddress();
        String zipcode = faker.address().zipCode();
        String mobileNumber = faker.phoneNumber().phoneNumber();

        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(faker.name().firstName());

        WebElement emailInput = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailInput.sendKeys(email);

        WebElement signup = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        jsClick(signup);

        WebElement gender = driver.findElement(By.xpath("//label[@for='id_gender2']"));
        jsClick(gender);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(password,Keys.TAB);

        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectGun = new Select(day);
        selectGun.selectByVisibleText("21");

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectAy = new Select(month);
        selectAy.selectByVisibleText("November");

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYil = new Select(year);
        selectYil.selectByVisibleText("2020");

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstNameInput.sendKeys(firstName,Keys.TAB);

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastNameInput.sendKeys(lastName,Keys.TAB);

        WebElement addressInput = driver.findElement(By.xpath("//input[@id='address1']"));
        addressInput.sendKeys(address,Keys.TAB);

        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("Canada");

        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("Alberta", Keys.TAB);

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("Edmonton", Keys.TAB);

        WebElement zipcodeInput = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipcodeInput.sendKeys(zipcode,Keys.TAB);

        WebElement mobileNumberInput = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumberInput.sendKeys(mobileNumber,Keys.TAB);
        waitForSecond(5);

        WebElement createAccount = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]"));
        jsClick(createAccount);

       extentTest.info("Kayıt ol bölümündeki tüm ayrıntılar dolduruldu ve hesap oluşturuldu");


        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        String expectedAccountCreated = "ACCOUNT CREATED!";
        String actualAccountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();

        Assert.assertEquals(expectedAccountCreated,actualAccountCreated);
        extentTest.pass("Hesap Oluşturuldu! seçeneği doğrulandı");

        WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        jsClick(continueButton);
        extentTest.info("Devam butonuna tıklandı");

        //7.  Verify ' Logged in as username' at top
        WebElement logged = driver.findElement(By.xpath("(//a)[11]"));

        Assert.assertTrue(logged.isDisplayed());
        extentTest.pass("Kullanıcı adı olarak oturum açıldı seçeneği doğrulandı");


        //8.   Add products to cart
        WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
        jsClick(productsButton);

        WebElement viewProduct = driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]"));
        jsClick(viewProduct);

        WebElement addToCard = driver.findElement(By.xpath("//button[@class='btn btn-default cart']"));
        jsClick(addToCard);

        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
        jsClick(continueShoppingButton);

        extentTest.info("Ürün sepete eklendi");


        //9. Click 'Cart' button

        WebElement cartButton = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        jsClick(cartButton);
        extentTest.info("Sepet butonuna tıklandı");


        //10. Verify that cart page is displayed
        WebElement shoppingCartText = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(shoppingCartText.isDisplayed());
        extentTest.pass("Sepet sayfasının görüntülendiği doğrulandı");


        //11. Click Proceed To Checkout
        WebElement proceedToCheckout = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        jsClick(proceedToCheckout);
        extentTest.info("Ödeme işlemine devam et butonuna tıklandı");


        //12. Verify Address Details and Review Your Order
        String actualFirstNameLastName = driver.findElement(By.xpath("//li[@class='address_firstname address_lastname']")).getText();
        String expectedFirstNameLastName = "Mrs. "+firstName+" "+lastName;

        Assert.assertEquals(expectedFirstNameLastName,actualFirstNameLastName);


        String actualAdress = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[2]")).getText();
        String expectedAdress = ""+address;

        Assert.assertEquals(expectedAdress,actualAdress);


        String actualStateCityZipcode = driver.findElement(By.xpath("//li[@class='address_city address_state_name address_postcode']")).getText();
        String expectedStateCityZipcode = "Edmonton Alberta " +zipcode;

        Assert.assertEquals(expectedStateCityZipcode,actualStateCityZipcode);


        String actualCountry = driver.findElement(By.xpath("//li[@class='address_country_name']")).getText();
        String expectedCountry = "Canada";

        Assert.assertEquals(expectedCountry,actualCountry);


        String actualMobileNumber = driver.findElement(By.xpath("//li[@class='address_phone']")).getText();
        String expectedMobileNumber = mobileNumber;

        Assert.assertEquals(expectedMobileNumber,actualMobileNumber);

        extentTest.pass("Adres ayrıntıları doğrulandı");


        //13. Enter description in comment text area and click 'Place Order'
        WebElement descriptionText = driver.findElement(By.xpath("//textarea[@class='form-control']"));
        descriptionText.sendKeys(faker.lorem().characters());


        WebElement placeOrder = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        jsClick(placeOrder);
        waitForSecond(2);
        extentTest.info("Yorum metni alanına açıklama girildi ve sipariş ver butonuna tıklandı");

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOfCard = driver.findElement(By.xpath("//input[@name='name_on_card']"));
        nameOfCard.sendKeys(faker.name().fullName(),Keys.TAB);


        WebElement cardNumber = driver.findElement(By.xpath("//input[@class='form-control card-number']"));
        cardNumber.sendKeys(faker.finance().creditCard(),Keys.TAB);


        WebElement cvc = driver.findElement(By.xpath("//input[@name='cvc']"));
        cvc.sendKeys(faker.number().digits(3),Keys.TAB);

        WebElement expirationMonth = driver.findElement(By.xpath("//input[@name='expiry_month']"));
        Date fakerTarihMonth = faker.date().future(365, TimeUnit.DAYS);
        SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");
        String formattedFakerTarih = dateFormatMonth.format(fakerTarihMonth);
        expirationMonth.sendKeys(formattedFakerTarih,Keys.TAB);


        WebElement expirationYear = driver.findElement(By.xpath("//input[@name='expiry_year']"));
        Date fakerTarihYear = faker.date().future(365,TimeUnit.DAYS);
        SimpleDateFormat dateFormatYear = new SimpleDateFormat("yyyy");
        String formattedFakerTarihh = dateFormatYear.format(fakerTarihYear);
        expirationYear.sendKeys(formattedFakerTarihh,Keys.TAB);

        extentTest.info("Ödeme ayrıntıları girildi");

        //15. Click 'Pay and Confirm Order' button

        WebElement playAndConfirmOrderButton =driver.findElement(By.xpath("//button[@id='submit']"));
        jsClick(playAndConfirmOrderButton);

        extentTest.info("Öde ve Siparişi onayla butonuna tıklandı");


        //16. Verify  message 'Congratulations! Your order has been confirmed!'

        String expectedMessage = "Congratulations! Your order has been confirmed!";
        WebElement actualMessage = driver.findElement(By.xpath("//p[@style='font-size: 20px; font-family: garamond;']"));

        Assert.assertEquals(expectedMessage,actualMessage.getText());

        //17. Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]"));
        jsClick(deleteAccountButton);
        extentTest.info("Hesabı sil butonuna tıklandı");


        //18.  Verify 'ACCOUNT DELETED!' and click 'Continue' button

        String expectedAccountDeleted = "ACCOUNT DELETED!";
        String actualAccuontDeleted = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();

        Assert.assertEquals(expectedAccountDeleted,actualAccuontDeleted);

        extentTest.pass("Hesap Silindi! seçeneği doğrulandı");

        WebElement continueButtonn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        jsClick(continueButtonn);
        extentTest.info("Devam butonuna tıklandı");

        extentReports.flush();


    }
}
