package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T06_LoginTestWithIncorrectEmailAndPassword extends TestBase {
    @Test
    public void test01(){
  //      1. Launch browser
  //      2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
  //      3. Verify that home page is visible successfully
        WebElement homaPageResimElementi= driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homaPageResimElementi.isDisplayed());
  //      4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
  //      5. Verify 'Login to your account' is visible
        WebElement yaziElementi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(yaziElementi.isDisplayed());
  //      6. Enter incorrect email address and password
        WebElement mailAdresKutusu= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        actions
                .click(mailAdresKutusu).sendKeys("ahmet@mustafa.com").sendKeys(Keys.TAB)
                .sendKeys("ahmet").sendKeys(Keys.TAB)
  //      7. Click 'login' button
                .sendKeys(Keys.ENTER).perform();
  //      8. Verify error 'Your email or password is incorrect!' is visible
        WebElement emailOrPasswordIncorrectYazisi=driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(emailOrPasswordIncorrectYazisi.isDisplayed());
    }
}
