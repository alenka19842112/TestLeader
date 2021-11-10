package pages.yandex;

import constans.IConstance;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class YandexLoginPage extends YandexHomePage implements IConstance {

    public static final By SIGN_IN_LOCATOR = By.xpath("//*[@class='home-link desk-notif-card__login-new-item desk-notif-card__login-new-item_enter home-link_black_yes home-link_hover_inherit']");
    public static final By EMAIL_INPUT_LOCATOR = By.xpath("//*[@class='Textinput-Control']");
    public static final By SIGN_IN_BUTTON = By.id("passp:sign-in");
    public static final By PASSWORD_INPUT_LOCATOR = By.id("passp-field-passwd");

    public YandexLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * login in site
     *
     * @param email    enter email address
     * @param password enter password
     * @return YandexAccountPage
     */
    @Step("Click 'Sign In' button and fill in {email} and {password} in Login field")
    public YandexHomePage login(String email, String password) {
        log.info("click Sign In button on the home page. Locator: " + SIGN_IN_LOCATOR);
        driver.findElement(SIGN_IN_LOCATOR).click();
        waitForPageOpened(SIGN_IN_BUTTON);
        log.info(String.format("fill in Email address: '%s' in Login field.", email));
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(email);
        log.info("click Sign in button. Locator:" + SIGN_IN_BUTTON);
        driver.findElement(SIGN_IN_BUTTON).click();
        waitForPageOpened(SIGN_IN_BUTTON);
        log.info(String.format("fill in password: '%s' in Login field.", password));
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        log.info("click Sign in button. Locator:" + SIGN_IN_BUTTON);
        driver.findElement(SIGN_IN_BUTTON).click();
        waitForPageOpened(HEADER_LOGO_LOCATOR);
        return new YandexHomePage(driver);
    }
}
