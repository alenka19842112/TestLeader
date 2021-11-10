package pages.yandex;

import constans.IConstance;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class YandexHomePage extends BasePage implements IConstance {
    public static final By HEADER_LOGO_LOCATOR = By.xpath("//*[@class='home-logo home-arrow__logo']");
    public static final By USER_NAME_LOCATOR = By.xpath("//*[@class='username desk-notif-card__user-name']");

    public YandexHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * open Page "https://yandex.by/"
     */
    @Step("Open Yandex Home page")
    public YandexHomePage openPage() {
        log.info("Open Yandex Home page, URL:" + YANDEX_BASE_URL);
        openHomePage(YANDEX_BASE_URL);
        waitForPageOpened(HEADER_LOGO_LOCATOR);
        return this;
    }

    /**
     * get user name
     *
     * @return text user name
     */
    public String getUserName() {
        return driver.findElement(USER_NAME_LOCATOR).getText();
    }
}
