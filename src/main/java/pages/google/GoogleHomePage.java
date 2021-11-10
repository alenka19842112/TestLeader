package pages.google;

import constans.IConstance;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class GoogleHomePage extends BasePage implements IConstance {

    public static final By SEARCH_LOCATOR = By.xpath("//*[@class='gLFyf gsfi']");
    public static final By HEADER_LOGO_LOCATOR = By.xpath("//*[@class='lnXdpd']");

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * open Page "https://www.google.com/"
     */
    @Step("Open Google Home page")
    public GoogleHomePage openGooglePage() {
        log.info("Open Google Home page, URL:" + GOOGLE_BASE_URL);
        openHomePage(GOOGLE_BASE_URL);
        waitForPageOpened(HEADER_LOGO_LOCATOR);
        return this;
    }
    /**
     * search input and click 'Search' button
     *
     * @param text String
     * @return Google Search Page
     */
    @Step("Search {text} in input and click 'Search' button")
    public GoogleSearchPage googleSearchForText(String text) {
        log.info(String.format("Input search text: '%s' in Search field.", text));
        driver.findElement(SEARCH_LOCATOR).sendKeys(text);
        driver.findElement(SEARCH_LOCATOR).sendKeys(Keys.RETURN);
        return new GoogleSearchPage(driver);
    }
}
