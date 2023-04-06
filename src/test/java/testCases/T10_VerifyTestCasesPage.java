package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class T10_VerifyTestCasesPage extends TestBase {
    @Test
    public void test01(){
  //     1. Launch browser
  //     2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
  //     3. Verify that home page is visible successfully
        WebElement homaPageLogoElementi= driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homaPageLogoElementi.isDisplayed());
  //     4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//i[@class='fa fa-list'])[1]")).click();
        ReusableMethods.bekle(3);
  //     5. Verify user is navigated to test cases page successfully
        String expectedUrl="https://automationexercise.com/test_cases";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
