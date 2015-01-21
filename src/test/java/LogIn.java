import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by SONY on 21.01.2015.
 */
public class LogIn {


    Data data = new Data();

    public void getUrl(WebDriver driver) {

        driver.get(data.url);
    }

    public void getUrlLogin(WebDriver driver) {

        driver.get(data.urlLogIn);
    }


    public void getEmail(WebDriver driver) {
        driver.findElement(By.xpath(".//*[@id='quick_email']")).sendKeys(data.login);
    }

    public void getPassvord(WebDriver driver) {
        driver.findElement(By.xpath(".//*[@id='quick_pass']")).sendKeys(data.parol);

    }

    public void pushOk(WebDriver driver) {
        driver.findElement(By.xpath(".//*[@id='quick_login_button']")).click();

    }

    public void signOut(WebDriver driver) {

        driver.findElement(By.xpath(".//*[@id='logout_link']")).click();
    }

    public void getMainPage(WebDriver driver) {
        driver.findElement(By.xpath(".//*[@id='myprofile']/span")).click();
    }


    public void sign(WebDriver driver) {
        getUrl(driver);
        getEmail(driver);
        getPassvord(driver);
        pushOk(driver);
    }


}

