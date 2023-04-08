import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ADeneme extends TestBase {

    @Test
    public void test01(){
driver.get("https://www.gonser.ch/");
driver.findElement(By.xpath("(//a[@class='nav-link topbar-area'])[1]")).click();


WebElement mailKutusu=driver.findElement(By.xpath("(//div[@class='input-unit'])[1]"));
actions.click(mailKutusu)
        .sendKeys("mustafaozsamur22@gmail.com"+Keys.TAB)
        .sendKeys("Lina2020m").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }

}
