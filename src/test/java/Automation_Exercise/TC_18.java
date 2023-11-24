package Automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC_18 extends TestBase {

        // 1. Launch browser
        // 1. Tarayıcıyı başlatın
        // 2. Navigate to url 'http://automationexercise.com'
        // 2. 'http://automationexercise.com' url'sine gidin



        @Test
        public void categoriesTest () {

            // 3. Verify that categories are visible on left side bar
            // 3. Kategorilerin sol taraftaki çubukta göründüğünü doğrulayın
            getUrl();
            scroll();
            WebElement categories = driver.findElement(By.xpath("//div[@id='accordian']"));
            Assert.assertTrue(categories.isDisplayed());
            //extentTest.pass("Kategorilerin göründüğünü doğrulandi");
        }

        @Test
        public void womenMenu () {
            // 4. Click on 'Women' category
            // 4. 'Kadınlar' kategorisine tıklayın
            getUrl();
            scroll();
            WebElement women = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]"));
            women.click();
            waitForSecond(2);
            //extentTest.pass("Women menü calisti");
        }

        @Test
        public void topsMenu () {

            // 5. Click on any category link under 'Women' category, for example: Dress
            // 5. 'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
            getUrl();
            scroll();
            WebElement women = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]"));
            women.click();
            waitForSecond(2);
            WebElement tops = driver.findElement(By.xpath("//a[.='Tops ']"));
            tops.click();
           //extentTest.pass("Tops menüsü calisti");
        }

    @Test
    public void womenTopsProductsTextTest() {
        // 6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        // 6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - EN IYI ÜRÜNLER' metnini onaylayın
        getUrl();
        scroll();
        WebElement women = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]"));
        women.click();
        waitForSecond(2);
        WebElement tops = driver.findElement(By.xpath("//a[.='Tops ']"));
        tops.click();
        String text = driver.findElement(By.xpath
                ("//h2 [@class='title text-center']")).getText();
        System.out.println("text = " + text);
        Assert.assertTrue(text.contains("WOMEN - TOPS PRODUCTS"));
        //extentTest.pass("WOMEN - TOPS PRODUCTS görüntülendigi onaylandi");


    }

    @Test
    public void menMenu() {
        // 7. On left side bar, click on any sub-category link of 'Men' category
        // 7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısını tıklayın
        getUrl();
        scroll();
        WebElement men = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]"));
        men.click();
        waitForSecond(2);
        WebElement jeans = driver.findElement(By.xpath("//a[.='Jeans ']"));
        jeans.click();
       // extentTest.pass("Men menü calisti");
    }

    @Test
    public void categoriPageTest() {

        // 8. Verify that user is navigated to that category page
        // 8. Kullanıcının bu kategori sayfasına yönlendirildiğini doğrulayın
        getUrl();
        scroll();
        WebElement men = driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]"));
        men.click();
        waitForSecond(2);
        WebElement jeans = driver.findElement(By.xpath("//a[.='Jeans ']"));
        jeans.click();
        WebElement menJeans = driver.findElement(By.xpath("//li[.='Men > Jeans']"));
        Assert.assertTrue(menJeans.isDisplayed());
        //extentTest.pass("Kullanici kategori sayfasina yönlendirildi");

    }


}
