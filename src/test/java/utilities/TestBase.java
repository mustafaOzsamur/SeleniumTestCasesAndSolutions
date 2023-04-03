package utilities;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected Faker faker;
    @Before
    public void setUp(){
        driver=new ChromeDriver();
        faker=new Faker();
        actions=new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.quit();
    }

}
