package tests;

import constans.IConstanceTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class YandexLoginTest extends BaseTest implements IConstanceTest {
    @Test(description = "Login with correct data Test", priority = 1)
    public void inputOfCorrectDataTest() {
        yandexHomePage.openPage();
        yandexloginPage.login(System.getenv().getOrDefault("Email address", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("Password", PropertyReader.getProperty("password")));
        Assert.assertEquals(yandexHomePage.getUserName(), YANDEX_LOGIN);
    }
}
