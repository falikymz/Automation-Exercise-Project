package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class TC_01 extends TestBase {
        Faker faker= new Faker();
    @Test
    public void test1() {
        //Lunch Browser
        driver.get("https://www.google.com");
        //Navigate to url
        driver.navigate().to("http://automationexercise.com");
        //Verify that home page is visible successfully
        String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Home']")).getAttribute("style");
        String expectedHomePageButtonColor ="color: orange;";
        Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);
        // Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //Verify 'New User Signup!' is visible
        driver.navigate().refresh();
        String newUserSignUp= driver.findElement(By.xpath("//*[.='New User Signup!']")).getText();
        Assert.assertEquals("New User Signup!",newUserSignUp);

        // Enter name and email address
        WebElement nameBox= driver.findElement(By.xpath("//input[@placeholder='Name']"));
        waitForSecond(1);
        String username= faker.name().fullName();
        nameBox.sendKeys(username);

        WebElement emailBox= driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        String useremail= faker.internet().emailAddress();
        waitForSecond(2);
        emailBox.sendKeys(useremail);


        //Click 'Signup' button

        waitForSecond(2);
        WebElement signUpButton= driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        signUpButton.click();
        waitForSecond(3);


        JavascriptExecutor js=(JavascriptExecutor)driver;
        List<WebElement> elements = driver.findElements(By.xpath("//div[@title='Advertisement']"));
        for (WebElement w:elements) {
            js.executeScript("arguments[0].setAttribute('style','none')",w);
        }


        //Verify that 'ENTER ACCOUNT INFORMATION' is visible

        //*[.='Enter Account Information']
        String enterAccInfo= driver.findElement(By.xpath("//*[.='Enter Account Information']")).getText().toUpperCase();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION",enterAccInfo);
        waitForSecond(1);

        //Fill details: Title, Name, Email, Password, Date of birth
         //radio button

//        WebElement mrs= driver.findElement(By.cssSelector("label[for='id_gender2']"));
//        if(! mrs.isSelected()){
//            mrs.click();
//        }
//        waitForSecond(2);

        //password
        WebElement passwordBox= driver.findElement(By.cssSelector("input[id='password']"));
        String password =faker.internet().password();
        passwordBox.sendKeys(password);
        waitForSecond(2);

        //date
        WebElement dateDropdown = driver.findElement(By.cssSelector("#days"));
        Select select = new Select(dateDropdown);
        dateDropdown.sendKeys("10");
        waitForSecond(2);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(3);

        //Month
        WebElement monthDropdown = driver.findElement(By.cssSelector("#months"));
        Select select2 = new Select(monthDropdown);
        monthDropdown.sendKeys("May");
        waitForSecond(2);

        //Year
        WebElement yearDropdown = driver.findElement(By.cssSelector("#years"));
        Select select3 = new Select(monthDropdown);
        yearDropdown.sendKeys("2000");
        waitForSecond(2);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(3);

        //Select checkbox 'Sign up for our newsletter!'

         WebElement newsletterCheckBox= driver.findElement(By.cssSelector("#newsletter"));

        //if(!newsletterCheckBox.isSelected()){
            newsletterCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(3);
       // }
        waitForSecond(4);
        //Select checkbox 'Receive special offers from our partners!'
        WebElement receiveCheckBox= driver.findElement(By.cssSelector("#optin"));

        waitForSecond(2);

       // if(! receiveCheckBox.isSelected()){
            receiveCheckBox.click();
        //}
        waitForSecond(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(3);

        //Firstname
        WebElement firstnameBox= driver.findElement(By.cssSelector("#first_name"));
        String name= faker.name().firstName();
        firstnameBox.sendKeys(name);
        waitForSecond(2);

        //Lastname
        WebElement lastnameBox= driver.findElement(By.cssSelector("#last_name"));
        String lastname= faker.name().lastName();
        lastnameBox.sendKeys(lastname);
        waitForSecond(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitForSecond(3);

        //Address
        WebElement adressBox1= driver.findElement(By.cssSelector("#address1"));
        String adress=faker.address().streetAddress();
        adressBox1.sendKeys(adress);
        waitForSecond(2);

        //Address2
        WebElement adressBox2= driver.findElement(By.cssSelector("#address2"));
        String adress2=faker.address().cityName();
        adressBox2.sendKeys(adress2);
        waitForSecond(2);


        //Country
        WebElement countryDropdown = driver.findElement(By.cssSelector("#country"));
        Select select4 = new Select(countryDropdown);
        countryDropdown.sendKeys("Canada");
        waitForSecond(2);

        //State
        WebElement stateBox= driver.findElement(By.cssSelector("#state"));
        stateBox.sendKeys("Ontario");
        waitForSecond(2);

        //City
        WebElement cityBox= driver.findElement(By.cssSelector("#city"));
        String city= faker.address().city();
        cityBox.sendKeys(city);
        waitForSecond(2);

        //Zipcode
        WebElement zipcodeBox= driver.findElement(By.cssSelector("#zipcode"));
        String zipcode= faker.address().zipCode();
        zipcodeBox.sendKeys(zipcode);
        waitForSecond(2);

        //Mobile Number
        WebElement phoneNumberBox= driver.findElement(By.cssSelector("#mobile_number"));
        String phoneNum= faker.address().zipCode();
        phoneNumberBox.sendKeys(phoneNum);
        waitForSecond(2);

        //Create Account
        WebElement createAccountButton= driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        createAccountButton.submit();
        waitForSecond(2);

        //Verify that 'ACCOUNT CREATED!' is visible
        WebElement result= driver.findElement(By.cssSelector("h2[class='title text-center'] b"));
        Assert.assertTrue(result.isDisplayed());
        waitForSecond(2);

        //Click 'Continue' button

        WebElement continueButton = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
        continueButton.click();
        //Verify that 'Logged in as username' is visible
         waitForSecond(2);
       String loggedAs= driver.findElement(By.cssSelector("li:nth-child(10)")).getText();

        Assert.assertTrue(" Logged in as ",(loggedAs).contains("Logged in as"));
        waitForSecond(1);


    }
}
