package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_LogoutUserTest extends TestBase {
    @Test
    public void test01(){
   //    1. Launch browser
   //    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
   //    3. Verify that home page is visible successfully
        WebElement homaPageLogoElementi= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homaPageLogoElementi.isDisplayed());
   //    4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
   //    5. Verify 'Login to your account' is visible
        WebElement yaziElementi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(yaziElementi.isDisplayed());
   //    6. Enter correct email address and password
        WebElement mailAdresKutusu= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        actions
                .click(mailAdresKutusu).sendKeys("mustafa@mustafa.com").sendKeys(Keys.TAB)
                .sendKeys("mustafa").sendKeys(Keys.TAB)
                //      7. Click 'login' button
                .sendKeys(Keys.ENTER).perform();

   //    8. Verify that 'Logged in as username' is visible
        WebElement userNameElementi=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(userNameElementi.isDisplayed());

   //    9. Click 'Logout' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();
   //    10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);

        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
