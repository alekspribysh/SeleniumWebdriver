import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by SONY on 21.01.2015.
 */
public class TestCases {
    /**
     * Created by SONY on 15.01.2015.
     */
    //WebDriver driver;
   /* @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "d:\\Download\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }*/



    //WebDriver driver = new HtmlUnitDriver();
   // WebDriver driver = new SafariDriver();
    WebDriver driver = new FirefoxDriver();
    LogIn logIn = new LogIn();
    Search search = new Search();
    Photo photo = new Photo();
    Message message = new Message();


    @Test
    public void signIn() {

        logIn.getUrl(driver);
        logIn.getEmail(driver);
        logIn.getPassvord(driver);
        logIn.pushOk(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='myprofile']/span")).getText().contains("Моя Страница"));

            System.out.println("Test SignIn  passed");
        } catch (AssertionError e) {
            System.out.println("LogIn is not completed");
        }
        logIn.signOut(driver);
         driver.quit();
    }

    @Test
    public void searchField() throws IOException {
        logIn.sign(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logIn.getMainPage(driver);
        search.findSearch(driver);

        try {
            Assert.assertTrue(driver.getPageSource().contains("Василий Лангенбах"));
            System.out.println("Test Vasiliy  passed");
        } catch (AssertionError e) {
            System.out.println("LogIn is not completed");
        }


    }

    @Test
    public void photo() throws IOException {
        logIn.sign(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        photo.getPhotoPage(driver);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("e:\\foto\\screenshot1.png"));
        try {
            Assert.assertTrue(driver.getPageSource().contains("Nike Campus Running Trail"));
            System.out.println("Test Photo passed");
        } catch (AssertionError e) {
            System.out.println("LogIn is not completed");
        }


    }

    @Test
    public void message() {
        logIn.sign(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        message.getMessage(driver);
       // message.deleteMessage(driver);
    }


    @Test
    public void deMessage() {
        logIn.sign(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //message.deleteMessage(driver);
    }

    @Test

    public void Dice() {
        //  WebDriverWait wait = new WebDriverWait(driver, 40);
        driver.get("http://dice.com");
        driver.findElement(By.xpath(".//*[@id='Login_1']")).click();
        driver.findElement(By.xpath(".//*[@id='Email_1']")).sendKeys("alekspribysh@gmail.com");
        driver.findElement(By.xpath(".//*[@id='Password_1']")).sendKeys("barselona1985");
        driver.findElement(By.xpath(".//*[@id='LoginBtn_1']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='profile-view']/div[3]/form/div[1]/div/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='contactPhoneNumberInput']")).clear();
        WebElement e = driver.findElement(By.className("row"));
        int x = 0;
        while (x < 100) {
            if (e.getText().contains("Done")) {
                e.click();
                driver.findElement(By.xpath(".//*[@id='contactPhoneNumberInput']")).sendKeys("5039972926");
                break;
            } else {
                e = driver.findElement(By.className("row"));
                x++;
            }
        }
        driver.findElement(By.xpath(".//*[@id='profile-view']/div[3]/form/div[1]/div/div[2]/div[2]/div/div/button")).click();
    }


}


