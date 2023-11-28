package atomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;


public class TC_18 extends TestBase {

    @Test
    public void categoriesTest () {
        rapor("chrome", "TC18 Test Raporu");
        extentTest=extentReports.createTest
                ("Automation Exercise","View Category Products");
        // 1. Launch browser
        // 1. Tarayıcıyı başlatın
        // 2. Navigate to url 'http://automationexercise.com'
        // 2. 'http://automationexercise.com' url'sine gidin

        // 3. Verify that categories are visible on left side bar
        // 3. Kategorilerin sol taraftaki çubukta göründüğünü doğrulayın
            driver.get("http://automationexercise.com");
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            WebElement categories = driver.findElement(By.xpath("//div[@id='accordian']"));
            Assert.assertTrue(categories.isDisplayed());
            extentTest.info("Kategorilerin göründüğü doğrulandi");

            // 4. Click on 'Women' category
            // 4. 'Kadınlar' kategorisine tıklayın

            WebElement women = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]"));
            women.click();
            waitForSecond(2);
            extentTest.info("Women menü calisti");


            // 5. Click on any category link under 'Women' category, for example: Dress
            // 5. 'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
            WebElement tops = driver.findElement(By.xpath("//a[.='Tops ']"));
            tops.click();
            extentTest.info("Tops menüsü calisti");


        // 6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        // 6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - EN IYI ÜRÜNLER' metnini onaylayın
        String text = driver.findElement(By.xpath
                ("//h2 [@class='title text-center']")).getText();
        System.out.println("text = " + text);
        Assert.assertTrue(text.contains("WOMEN - TOPS PRODUCTS"));
        extentTest.pass("WOMEN - TOPS PRODUCTS görüntülendigi onaylandi");


        // 7. On left side bar, click on any sub-category link of 'Men' category
        // 7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısını tıklayın

        WebElement men = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]"));
        men.click();
        waitForSecond(2);
        extentTest.pass("Men menü calisti");


        // 8. Verify that user is navigated to that category page
        // 8. Kullanıcının bu kategori sayfasına yönlendirildiğini doğrulayın

        WebElement jeans = driver.findElement(By.xpath("//a[.='Jeans ']"));
        jeans.click();
        String menJeansText = driver.findElement(By.xpath("//h2[.='Men - Jeans Products']")).getText();
        Assert.assertTrue(menJeansText.contains("MEN - JEANS PRODUCTS"));
        extentTest.pass("Kullanici kategori sayfasina yönlendirildi");

    }


}
