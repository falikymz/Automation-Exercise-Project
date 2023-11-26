package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC_26 extends TestBase {

    @Test
    public void test1() {

        //Lunch Browser
        driver.get("https://www.google.com");
        //Navigate to url
        driver.navigate().to("http://automationexercise.com");
        //Verify that home page is visible successfully
        String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Home']")).getAttribute("style");
        String expectedHomePageButtonColor ="color: orange;";
        waitForSecond(3);
        Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);

        //Scroll down page to bottom
        waitForSecond(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        waitForSecond(3);

       // Verify 'SUBSCRIPTION' is visible

        driver.navigate().refresh();
        String subscription= driver.findElement(By.xpath("//*[.='Subscription']")).getText().toUpperCase();
        Assert.assertEquals("SUBSCRIPTION",subscription);
         waitForSecond(3);
        //Scroll UP page to bottom
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();

        //Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers'
        // text is visible on screen

        waitForSecond(5);
        WebElement fullFledged= driver.findElement(By.xpath("(//h2[.='Full-Fledged practice website for Automation Engineers'])[1]"));
        actions.sendKeys(Keys.UP).perform();

        actions.scrollToElement(fullFledged);
//         String xp =fullFledged.getText();
//        Assert.assertEquals(xp,fullFledged);




    }
}
