package Automation_Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_20 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
     */


    @Test
    public void testCase20() {
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String eMail=faker.internet().emailAddress();
        String password=faker.internet().password();
        createAccount(eMail,password,name);

        rapor("Chrome","Automation Exercise ","TC_20","Aysegul Temel");
        extentTest=extentReports.createTest("Test Case 20: Search Products and Verify Cart After Login","Test Steps");

        //1. Launch browser
        extentTest.info("Launch browser");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url 'http://automationexercise.com'");

        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        extentTest.info("Click 'Pruducts' button ");

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        String actualPrdcButtonStyle = driver.findElement(By.xpath("//div[@class='features_items']")).getAttribute("style");
        String expectedPrdcButtonStyle ="height: auto !important;";
        Assert.assertEquals(expectedPrdcButtonStyle,actualPrdcButtonStyle);
        extentTest.info("Verify user is navigated to ALL PRODUCTS page successfully");
        extentTest.pass("Test Pass");

        //5. Enter product name in search input and click search button
        WebElement searchPrdct =driver.findElement(By.id("search_product"));
        searchPrdct.sendKeys("dress", Keys.TAB,Keys.ENTER);


        // 6. Verify 'SEARCHED PRODUCTS' is visible
        String actualSearchedProducts = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        Assert.assertEquals("SEARCHED PRODUCTS",actualSearchedProducts);
        extentTest.info("Verified 'SEARCHED PRODUCTS' is visible");
        extentTest.pass("Test Pass");

        //7. Verify all the products related to search are visible
        WebElement actualSearchedList = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(actualSearchedList.isDisplayed());
        extentTest.info("Verify user is navigated to ALL PRODUCTS page successfully");
        extentTest.pass("Test Pass");

        //8. Add those products to cart
        WebElement addToCart =driver.findElement(By.xpath("(//a[@data-product-id='3'])[2]"));
        jsClick(addToCart);


        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        WebElement actualPrdctsInCart=driver.findElement(By.xpath("//img[@src='get_product_picture/3']"));
        Assert.assertTrue(actualPrdctsInCart.isDisplayed());
        extentTest.info("Verified that products are visible in cart");
        extentTest.pass("Test Passed");

        // 10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        WebElement userName=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement userPassword=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        userName.sendKeys(eMail);
        userPassword.sendKeys(password,Keys.ENTER);

        // 11. Again, go to Cart page
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //12. Verify that those products are visible in cart after login as well
        WebElement loginWithCart=driver.findElement(By.xpath("//img[@src='get_product_picture/3']"));
        Assert.assertTrue(loginWithCart.isDisplayed());
        extentTest.info("Verified that products are visible in cart");
        extentTest.pass("Test Passed");

        extentReports.flush();
    }
}