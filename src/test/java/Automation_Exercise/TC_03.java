package Automation_Exercise;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
public class TC_03 extends TestBase {
    @Test
    public void Test() {
        //1. Launch browser
        rapor("browser","automationexercise","TC_03");
        extentTest=extentReports.createTest("Login User with incorrect email and password","Test03");
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Kullanıcı automationexercise sayfasına gider.");
        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        extentTest.info("Verify that home page is visible successfully.");
        extentTest.pass("Test Pass");
        //4. Click on 'Signup / Login' button
        WebElement singUpLogin = driver.findElement(By.xpath("//a[@href='/login']"));
        singUpLogin.click();
        extentTest.info("Click on 'Signup / Login' button.");
        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("(//h2['Login to your account'])[1]"));
        Assert.assertTrue(loginText.isDisplayed());
        extentTest.info("Verify 'Login to your account' is visible.");
        extentTest.pass("Test Pass");
        //6. Enter incorrect email address and password
        Faker faker = new Faker();
        WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys(faker.internet().emailAddress(), Keys.TAB,
                faker.internet().password());
        extentTest.info("Enter incorrect email address and password.");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        extentTest.info("Click 'login' button.");
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrect= driver.findElement(By.xpath("(//p['Your email or password is incorrect!'])[1]"));
        Assert.assertEquals("Your email or password is incorrect!",incorrect.getText());
        extentTest.info("Verify error 'Your email or password is incorrect!' is visible.");
        extentTest.pass("Test Pass");
        extentReports.flush();
    }
}