package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class T03_FormFillingTest extends TestBase {
    @Test
    public void test01(){
        // go to facebook.com
        driver.get("https://www.facebook.com");
        // accept cookies
        driver.findElement(By.xpath("//button[@title='Nur erforderliche Cookies erlauben']")).click();
        // click the create new account button
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // fill relevant fields with values from faker library
        WebElement firstnameKutusu=driver.findElement(By.name("firstname"));

        String mailAdresi=faker.internet().emailAddress();

        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("01")
                .sendKeys(Keys.TAB)
                .sendKeys("Jan.")
                .sendKeys(Keys.TAB)
                .sendKeys("1987")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();

        // press the register button
        WebElement signupButonu= driver.findElement(By.name("websubmit"));
        signupButonu.click();
        // test that you are not registered

        ReusableMethods.bekle(20);
        WebElement hataMesaji=driver.findElement(By.xpath("//span[text()='Wir benötigen noch weitere Informationen']"));

        Assert.assertTrue(hataMesaji.isDisplayed());



    }
}
