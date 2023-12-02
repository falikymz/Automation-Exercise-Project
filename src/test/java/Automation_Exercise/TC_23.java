package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TC_23 extends TestBase {

    Faker faker = new Faker();
    @Test
    public void testCase_23() {
        rapor("chrome","Automation Exercise Testi");
        extentTest=extentReports.createTest("Verify address details in checkout page", "Test steps");

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://www.automationexercise.com/");
        extentTest.info("Kullanıcı Automation Exercise anasayfasına gider.");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement homeButton = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(homeButton.isDisplayed());
        extentTest.pass("Anasayfanın başarıyla görüntülendiği doğrulandı");

        //4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        WebElement signupLogin = driver.findElement(By.xpath("//a[@href='/login']"));
        jsClick(signupLogin);
        extentTest.info("Kayıt ol/Giriş yap butonuna tıklandı");

        //5. Kayıt ol bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun

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
        passwordInput.sendKeys(password, Keys.TAB);

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


        //6. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın ve 'Devam' düğmesini tıklayın

        String expectedAccountCreated = "ACCOUNT CREATED!";
        String actualAccountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();

        Assert.assertEquals(expectedAccountCreated,actualAccountCreated);
        extentTest.pass("Hesap Oluşturuldu! seçeneği doğrulandı");

        WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        jsClick(continueButton);
        extentTest.info("Devam butonuna tıklandı");


        //7. Üstteki 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        WebElement logged = driver.findElement(By.xpath("(//a)[11]"));

        Assert.assertTrue(logged.isDisplayed());
        extentTest.pass("Kullanıcı adı olarak oturum açıldı seçeneği doğrulandı");

        //8. Ürünleri sepete ekleyin

        WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
        jsClick(productsButton);

        WebElement viewProduct = driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]"));
        jsClick(viewProduct);

        WebElement addToCard = driver.findElement(By.xpath("//button[@class='btn btn-default cart']"));
        jsClick(addToCard);

        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
        jsClick(continueShoppingButton);
        extentTest.info("Ürün sepete eklendi");



        //9. 'Sepet' düğmesine tıklayın

        WebElement cartButton = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        jsClick(cartButton);

        extentTest.info("Sepet butonuna tıklandı");

        //10. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement shoppingCartText = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(shoppingCartText.isDisplayed());

        extentTest.pass("Sepet sayfasının görüntülendiği doğrulandı");

        //11. Ödeme İşlemine Devam Et'e tıklayın

        WebElement proceedToCheckout = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        jsClick(proceedToCheckout);

        extentTest.info("Ödeme işlemine devam et butonuna tıklandı");

        //12. Teslimat adresinin hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın
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

        extentTest.pass("Teslimat Adres ayrıntıları doğrulandı");



        //13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın
        String actualFirstNameLastNameBA=driver.findElement(By.xpath("(//li[@class='address_firstname address_lastname'])[2]")).getText();
        String expectedFirstNameLastNameBA = "Mrs. "+firstName+" "+lastName;

        Assert.assertEquals(expectedFirstNameLastNameBA,actualFirstNameLastNameBA);

        String actualAdressBA = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[5]")).getText();
        String expectedAdressBA = ""+address;

        Assert.assertEquals(expectedAdressBA,actualAdressBA);

        String actualStateCityZipcodeBA = driver.findElement(By.xpath("(//li[@class='address_city address_state_name address_postcode'])[2]")).getText();
        String expectedStateCityZipcodeBA = "Edmonton Alberta " +zipcode;

        Assert.assertEquals(expectedStateCityZipcodeBA,actualStateCityZipcodeBA);

        String actualCountryBA = driver.findElement(By.xpath("(//li[@class='address_country_name'])[2]")).getText();
        String expectedCountryBA = "Canada";

        Assert.assertEquals(expectedCountryBA,actualCountryBA);


        String actualMobileNumberBA = driver.findElement(By.xpath("(//li[@class='address_phone'])[2]")).getText();
        String expectedMobileNumberBA = mobileNumber;

        Assert.assertEquals(expectedMobileNumberBA,actualMobileNumberBA);

        extentTest.pass("Fatura Adres ayrıntıları doğrulandı");



        //14. 'Hesabı Sil' düğmesine tıklayın

        WebElement deleteAccountButton = driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]"));
        jsClick(deleteAccountButton);

        extentTest.info("Hesabı sil butonuna tıklandı");

        //15. 'HESAP SİLİNDİ!' seçeneğini doğrulayın ve 'Devam' düğmesini tıklayın

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
