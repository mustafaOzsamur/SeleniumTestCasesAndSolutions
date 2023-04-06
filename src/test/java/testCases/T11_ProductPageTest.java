package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class T11_ProductPageTest extends TestBase {
    @Test
    public void test01(){
 //       . Launch browser
 //       2. Navigate to url 'http://automationexercise.com'
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

 //       6. The products list is visible
        WebElement theProductsListelementi= driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(theProductsListelementi.isDisplayed());
 //       7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]")).click();
 //       8. User is landed to product detail page
        String expectedUrunDetayUrl="https://automationexercise.com/product_details/1";
        String actualUrunDetayUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrunDetayUrl,actualUrunDetayUrl);
 //       9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

        WebElement urunDetailElementi= driver.findElement(By.xpath("//span[text()='Rs. 500']"));
        Assert.assertTrue(urunDetailElementi.isDisplayed());

    }
}
