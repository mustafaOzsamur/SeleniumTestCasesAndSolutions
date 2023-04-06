package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class T12_SearchProductTest extends TestBase {
    @Test
    public void test01() {
        //   2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //       3. Verify that home page is visible successfully
        WebElement homaPageLogoElementi= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homaPageLogoElementi.isDisplayed());
        //       4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        ReusableMethods.bekle(3);

        //       5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsElementi= driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertTrue(allProductsElementi.isDisplayed());

        //     6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("TSHIRTS"+ Keys.TAB+Keys.ENTER);
        //     7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProductsElementi= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(searchedProductsElementi.isDisplayed());
        //     8. Verify all the products related to search are visible
        WebElement allTheProductsElementi=driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(allTheProductsElementi.isDisplayed());

        List<WebElement> tumUrunler=driver.findElements(By.xpath("//div[@class='features_items']"));
        for (WebElement eachElemet:tumUrunler) {
            System.out.println(eachElemet.getText()+" ,");
            System.out.println(tumUrunler.size());

        }

    }
}