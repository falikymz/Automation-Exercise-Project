package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
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
        String actualHomePageButtonColor = driver.findElement(By.xpath("//a[text()=' Products']")).getAttribute("style");
        String expectedHomePageButtonColor ="color: orange;";
        Assert.assertEquals(expectedHomePageButtonColor,actualHomePageButtonColor);
        extentTest.info("//3.Verify that home page is visible successfully");
        extentTest.pass("Test Pass");

        //5. Enter product name in search input and click search button

       // 6. Verify 'SEARCHED PRODUCTS' is visible

        //7. Verify all the products related to search are visible

        //8. Add those products to cart

        //9. Click 'Cart' button and verify that products are visible in cart

       // 10. Click 'Signup / Login' button and submit login details

       // 11. Again, go to Cart page

        //12. Verify that those products are visible in cart after login as well


        extentTest=extentReports.createTest("Automation Exercise","Test Case 20");



    }
}
