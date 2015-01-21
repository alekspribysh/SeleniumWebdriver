import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by SONY on 21.01.2015.
 */
public class Photo {


    public void getPhotoPage(WebDriver driver) {
        driver.findElement(By.xpath(".//*[@id='l_ph']/a")).click();
        driver.findElement(By.xpath(".//*[@id='album14314981_194415160']/div/a/div[2]/div[1]/div[1]")).click();
        driver.findElement(By.xpath(".//*[@id='photo_row14314981_326722299']/a[1]/img")).click();
    }


}

