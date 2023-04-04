package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T05_LoginTest extends TestBase {
    @Test
    public void test01(){

  //      1. Launch browser
 //  2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");
 //  3. Verify that home page is visible successfully
        WebElement anasayfaLogoElementi= driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(anasayfaLogoElementi.isDisplayed());
 //  4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
 //  5. Verify 'Login to your account' is visible
        WebElement hesabbilgisiElementi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(hesabbilgisiElementi.isDisplayed());
 //  6. Enter correct email address and password
        WebElement emailAdresKutusu= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        actions
                .click(emailAdresKutusu).sendKeys("mustafa@mustafa.com")
                .sendKeys(Keys.TAB)
                .sendKeys("mustafa")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

 //  7. Click 'login' button
 //  8. Verify that 'Logged in as username' is visible
        WebElement loggedElementi=driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(loggedElementi.isDisplayed());
 //  9. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
 //  10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deleteElementi= driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(deleteElementi.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();





    }
}
