package tests;

import constans.IConstanceTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest implements IConstanceTest {
    @Test(description = "Search data Test", priority = 1)
    public void SearchTest() {
        googleHomePage.openGooglePage()
                .googleSearchForText(GOOGLE_SEARCH_TEXT);
        Assert.assertTrue(googleSearchPage.isSearchResultsDisplayed(SEARCH_RESULT));
        Assert.assertTrue(googleSearchPage.getSearchResultsQty() > 10);
    }
}
