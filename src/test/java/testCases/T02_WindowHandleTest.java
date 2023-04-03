package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class T02_WindowHandleTest extends TestBase {
    //● Go to https://the-internet.herokuapp.com/windows.
    //● Verify that the text on the page is “Opening a new window”.
    //● Verify that the page title is “The Internet”.
    //● Click the Click Here button.
    //● Verify that the title of the new window that opens is “New Window”.
    //● Verify that the text on the page is “New Window”.
    //● After returning to the previous window
    // Verify that the page title is "The Internet".

    @Test
    public void test01(){


        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD= driver.getWindowHandle();
        String expectedilkSayfaYazi="Opening a new window";
        String actualIlkSayfaYazi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedilkSayfaYazi,actualIlkSayfaYazi);

        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.linkText("Click Here")).click();
        ReusableMethods.bekle(3);

        Set<String> tumSayfaWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWHD:tumSayfaWHD) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }

        }

        driver.switchTo().window(ikinciSayfaWHD);
        expectedTitle="New Window";
        actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        String expectedIkinciSayfaText="New Window";
        String actualIkinciSayfatext=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedIkinciSayfaText,actualIkinciSayfatext);


        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        ReusableMethods.bekle(3);

    }
}
