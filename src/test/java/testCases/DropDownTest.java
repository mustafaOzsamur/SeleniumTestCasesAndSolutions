package testCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;




public class DropDownTest {
    protected WebDriver driver;
    Select select;
    @Before
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01()  {

        WebElement dropdownWebElemnti = driver.findElement(By.xpath("//select[@style='display: block; top: 2.5px;']"));
        select = new Select(dropdownWebElemnti);
        List<WebElement> dropDownOptionElementleri = select.getOptions();
        int actualOptionSayisi = dropDownOptionElementleri.size();
        System.out.println(actualOptionSayisi);
        int expectedOptionSayisi = 28;
        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);
    }
    @Test
    public void test02() throws InterruptedException {
        WebElement dropdownWebElemnti = driver.findElement(By.xpath("//select[@style='display: block; top: 2.5px;']"));
        select = new Select(dropdownWebElemnti);
        select.selectByVisibleText("Bücher");
        Thread.sleep(3000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr=sonucYazisi.getText();
        System.out.println(sonucYazisiStr);
        String[] sonucYazisiArr=sonucYazisiStr.split(" ");
        String sonucAdediStr=sonucYazisiArr[4];
        sonucAdediStr=sonucAdediStr.replaceAll("\\D","");
        int sonucAdediInt=Integer.parseInt(sonucAdediStr);
        System.out.println(sonucAdediInt);

        String actualSonucYazisi=sonucYazisiStr;
        String expectedKelime="Java";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }
}
