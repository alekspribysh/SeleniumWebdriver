import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by SONY on 21.01.2015.
 */
public class Message {


    Data data = new Data();
    WebElement a;
    WebElement b;


    public void getMessage(WebDriver driver) {
        driver.findElement(By.xpath(".//*[@id='l_msg']/a/span[2]")).click();
        driver.findElement(By.xpath(".//*[@id='im_write_btn']")).click();
        driver.findElement(By.xpath(".//*[@id='imw_dd']/div[2]")).click();
        driver.findElement(By.id("imw_dd")).click();
        driver.findElement(By.id("wddi7340057_imw_dd")).click();
        driver.findElement(By.xpath(".//*[@id='imw_editable']")).sendKeys("Это Selenium, можешь удалять эти сообщения");
        driver.findElement(By.xpath(".//*[@id='im_rc_em_D83DDE0A']/img")).click();
        driver.findElement(By.xpath(".//*[@id='imw_send']")).click();

    }

    public void deleteMessage(WebDriver driver) {
        driver.findElement(By.xpath(".//*[@id='l_msg']/a/span[2]")).click();
        a = driver.findElement(By.xpath(".//*[@id='im_filter']"));
        a.sendKeys(data.nameMessage);
        a.sendKeys(Keys.ENTER);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        driver.findElement(By.className("im_msg_text"));
        int x = 0;
        while (b.) {
            if (b.getText().contains("Это Selenium, можешь удалять эти сообщения")) {
                b.click();
                driver.findElement(By.xpath(".//*[@id='im_log_controls']/button[4]")).click();
                System.out.println("MMMM");
                x++;
            } else {
                b = driver.findElement(By.className("im_msg_text"));
                System.out.println("FIIIGGG");
                x++;
            }
        }

    }

    public WebElement essage(WebDriver driver) {
        WebElement p = (WebElement) driver.findElements(By.className("im_msg_text"));
        return p;
    }

}


