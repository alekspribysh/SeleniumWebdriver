import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by SONY on 21.01.2015.
 */
public class Search {


    Data data = new Data();

    public void findSearch(WebDriver driver) {
        WebElement a = driver.findElement(By.xpath(".//*[@id='ts_input']"));
        a.sendKeys(data.name);
        a.sendKeys(Keys.ENTER);

    }
}



