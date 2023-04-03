package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class T04_RegisterUserTest extends TestBase {
    @Test
    public void test01() {


//    1. Launch browser
//     2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//
//     3. Verify that home page is visible successfully
        WebElement anaSayfaResimElementi=driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(anaSayfaResimElementi.isDisplayed());

//     4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
//     5. Verify 'New User Signup!' is visible
        WebElement YeniKullaniciYazielementi= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(YeniKullaniciYazielementi.isDisplayed());
//    6. Enter name and email address
        WebElement isimKutusuElementi= driver.findElement(By.xpath("//input[@name='name']"));
        actions.click(isimKutusuElementi)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)

//    7. Click 'Signup' button
                .sendKeys(Keys.ENTER).perform();

//    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement hesabbilgilerielementi= driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(hesabbilgilerielementi.isDisplayed());
//    9. Fill details: Title, Name, Email, Password, Date of birth
//    10. Select checkbox 'Sign up for our newsletter!'
//     11. Select checkbox 'Receive special offers from our partners!'
//      12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//    13. Click 'Create Account button'
        WebElement mrButtonelementi= driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions
                .click(mrButtonelementi)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1987").perform();

             driver.findElement(By.xpath("//input[@id='newsletter']")).click();
             driver.findElement(By.id("optin")).click();
             actions
                     .sendKeys(Keys.TAB)
                     .sendKeys(faker.name().firstName())
                     .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                     .sendKeys(Keys.TAB).sendKeys("kendim")
                     .sendKeys(Keys.TAB).sendKeys("B.Strasse 96")
                     .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("United States")
                     .sendKeys(Keys.TAB).sendKeys("Teksas")
                     .sendKeys(Keys.TAB).sendKeys("Dallas")
                     .sendKeys(Keys.TAB).sendKeys("05100")
                     .sendKeys(Keys.TAB).sendKeys("41778569985")
                     .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();




//     14. Verify that 'ACCOUNT CREATED!' is visible
            WebElement hesapOlusturulduElementi=driver.findElement(By.xpath("//b[text()='Account Created!']"));
            Assert.assertTrue(hesapOlusturulduElementi.isDisplayed());
//    15. Click 'Continue' button
            driver.findElement(By.xpath("//a[text()='Continue']")).click();

        ReusableMethods.bekle(3);
 //     driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();

//    16. Verify that 'Logged in as username' is visible
        WebElement loggedElementi=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(loggedElementi.isDisplayed());

//    17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();

//    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleteElementi= driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(deleteElementi.isDisplayed());
        driver.findElement(By.xpath("//a[text()='Continue']")).click();


    }
}