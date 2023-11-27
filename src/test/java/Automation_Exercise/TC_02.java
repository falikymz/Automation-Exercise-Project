package atomationExercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;


public class TC_02 extends TestBase {
    @Test
    public void homePageTest() {
        rapor("chrome", "TC02 Test Raporu");
        extentTest=extentReports.createTest
                ("Automation Exercise"," Login User with correct email and password");
        String email = "silver.syed@forkshape.com";
        String username = "silver";
        String password = "silver123";

        // 1. Launch browser
        // 1. Tarayıcıyı başlatın
        // 2. Navigate to url 'http://automationexercise.com'
        // 2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement homePageLogo = driver.findElement(By.xpath
                ("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePageLogo.isDisplayed());



        // 4. Click on 'Signup / Login' button
        // 4. 'Kaydol / Giriş' düğmesine tıklayın
        // 5. Verify 'Login to your account' is visible
        // 5. 'Hesabınıza giriş yapın' mesajının görünür olduğunu doğrulayın

        WebElement signupLogin = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signupLogin.click();
        waitForSecond(2);
        String loginToYourAccountText = driver.findElement(By.xpath
                ("//h2[.='Login to your account']")).getText();
        Assert.assertEquals("Login to your account", loginToYourAccountText);



        // 6. Enter correct email address and password
        // 6. Doğru e-posta adresini ve şifreyi girin
        // 7. Click 'login' button
        // 7. 'Giriş' düğmesine tıklayın
        // 8. Verify that 'Logged in as username' is visible
        // 8. 'Kullanıcı adı olarak oturum açtı' ifadesinin görünür olduğunu doğrulayın



        WebElement emailTextBox = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        emailTextBox.sendKeys(email,Keys.TAB,password,Keys.TAB,Keys.ENTER);
        waitForSecond(3);
        String loggedInAsUsernameText =driver.findElement
                        (By.xpath("//a [.=' Logged in as silver']"))
                .getText();
        Assert.assertEquals("Logged in as "+username , loggedInAsUsernameText);


        // 9. Click 'Delete Account' button
        // 9. 'Hesabı Sil' düğmesini tıklayın
        // 10. Verify that 'ACCOUNT DELETED!' is visible
        // 10. 'HESAP SİLİNDİ!' mesajının görünür olduğunu doğrulayın


        WebElement deleteAccount = driver.findElement
                (By.xpath(" //a[.=' Delete Account']"));
        deleteAccount.click();
        waitForSecond(2);
        String accountDeletedText = driver.findElement(By.xpath
                ("//h2[.='Account Deleted!']")).getText();
        Assert.assertEquals("ACCOUNT DELETED!", accountDeletedText);


        // email adresini yeniden gecerli email yapabilmek icin
        //silinen email ile tekrar kayit yapmak icin olusturuldu
        WebElement signUpLogin = driver.findElement(By.xpath("//a[.=' Signup / Login']"));
        signUpLogin.click();
        waitForSecond(2);


        WebElement nameTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        nameTextBox.sendKeys(username,Keys.TAB,email,Keys.TAB,Keys.ENTER);
        waitForSecond(2);

        WebElement titleMrs = driver.findElement(By.xpath("//input[@id='id_gender2']"));
        if (!titleMrs.isSelected()){
            titleMrs.click();
        }
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordTextBox.sendKeys(password);
        waitForSecond(2);

        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("1");
        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("January");
        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYears = new Select(year);
        selectYears.selectByVisibleText("2005");

        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys(faker.name().firstName(),Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.company().name(),Keys.TAB,faker.address().streetAddress(),Keys.TAB,faker.address().streetAddress());

        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United States");

        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys(faker.address().state(),Keys.TAB,faker.address().city(),Keys.TAB,
                faker.currency().code(),Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB,Keys.ENTER);




    }

}
