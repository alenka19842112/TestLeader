package pages.google;

import constans.IConstance;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class GoogleSearchPage extends GoogleHomePage implements IConstance {
    public static final String SEARCH_RESULT_LOCATOR = "//a//*[contains(text(),'%s')]";
    public static final By HEADER_LOCATOR = By.xpath("//*[@class='logo']");
    public static final By SEARCH_COUNT_LOCATOR = By.id("result-stats");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * is Search results displayed
     *
     * @return true
     */
    public boolean isSearchResultsDisplayed(String searchResult) {
        waitForPageOpened(HEADER_LOCATOR);
        return driver.findElement(By.xpath(String.format(SEARCH_RESULT_LOCATOR, searchResult))).isDisplayed();
    }

    /**
     * Search number of products found
     *
     * @return count
     */
    public int getSearchResultsQty() {
        waitForPageOpened(HEADER_LOCATOR);
        log.info("Line with the number of products found. Locator: " + SEARCH_COUNT_LOCATOR);
        String search = driver.findElement(SEARCH_COUNT_LOCATOR).getText();
        int positionOfBracket = search.indexOf("(");
        search = search.substring(0, positionOfBracket);
        int count = Integer.parseInt(search.replaceAll("[^0-9]", ""));
        log.info("Number of products found = " + count);
        return count;
    }
}
