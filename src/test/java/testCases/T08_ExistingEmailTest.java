package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T08_ExistingEmailTest extends TestBase {
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
   //    5. Verify 'New User Signup!' is visible
        WebElement newUserSignupYaziElementi= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupYaziElementi.isDisplayed());
   //    6. Enter name and already registered email address
        WebElement nameKutuElementi= driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        actions.click(nameKutuElementi).sendKeys("mustafa").sendKeys(Keys.TAB).sendKeys("mustafa@mustafa.com").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
   //    7. Click 'Signup' button
   //    8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExistYaziElementi= driver.findElement(By.xpath("//*[@style='color: red;']"));
        Assert.assertTrue(alreadyExistYaziElementi.isDisplayed());
    }

}
