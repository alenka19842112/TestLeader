package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.google.GoogleHomePage;
import pages.google.GoogleSearchPage;
import pages.yandex.YandexLoginPage;
import pages.yandex.YandexHomePage;

import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTest {
    WebDriver driver;
    YandexLoginPage yandexloginPage;
    BasePage basePage;
    YandexHomePage yandexHomePage;
    GoogleHomePage googleHomePage;
    GoogleSearchPage googleSearchPage;

    /**
     * object initialization
     */
    public void init() {
        yandexloginPage = new YandexLoginPage(driver);
        basePage = new BasePage(driver);
        yandexHomePage = new YandexHomePage(driver);
        googleHomePage = new GoogleHomePage(driver);
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @BeforeMethod
    public void initTest() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.fatal("Fatal error: ChromeDriver is not found", e);
        }
        init();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}
