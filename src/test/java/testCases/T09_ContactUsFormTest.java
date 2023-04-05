package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class T09_ContactUsFormTest extends TestBase {
    @Test
    public void test01(){
   //     Launch browser
  //     2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
  //     3. Verify that home page is visible successfully
        WebElement homaPageLogoElementi= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homaPageLogoElementi.isDisplayed());
  //     4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();
  //     5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchYaziElementi= driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouchYaziElementi.isDisplayed());
        System.out.println(getInTouchYaziElementi.getText());
  //     6. Enter name, email, subject and message
        WebElement nameKutusu= driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));

        actions.click(nameKutusu).sendKeys("mustafa")
                .sendKeys(Keys.TAB).sendKeys("mustafa@mustafa.com")
                .sendKeys(Keys.TAB).sendKeys("satin alinan urun")
                .sendKeys(Keys.TAB).sendKeys("urununuz cok kötü iade etmek istiyorum")
                .sendKeys(Keys.TAB).perform();
  //     7. Upload file
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\merhabaJava.txt";
        WebElement uploadElementi= driver.findElement(By.name("upload_file"));
        uploadElementi.sendKeys(dosyaYolu);
  //     8. Click 'Submit' button
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();
  //     9. Click OK button
        driver.switchTo().alert().accept();
  //     10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement sayfaYaziElementi= driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        Assert.assertTrue(sayfaYaziElementi.isDisplayed());
  //     11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
        ReusableMethods.bekle(5);
        String expectedUrl="https://automationexercise.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
