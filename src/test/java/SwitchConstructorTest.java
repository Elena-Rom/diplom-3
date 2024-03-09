import browser.BrowserDriver;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import pom.SwitchesPage;

public class SwitchConstructorTest {
    @Rule
    public BrowserDriver browserRule = new BrowserDriver();

    @Test
    @DisplayName("Прверка перехода в раздел Соусы")
    public void switchInSouses() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        SwitchesPage switchesPage = new SwitchesPage(browserRule.getWebDriver());
        mainPage
                .open();
        switchesPage.souseClick();
        Assert.assertTrue(switchesPage.checkSousesAll());
    }
    @Test
    @DisplayName("Прверка перехода в раздел Начинки")
    public void switchInFillings() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        SwitchesPage switchesPage = new SwitchesPage(browserRule.getWebDriver());
        mainPage
                .open();
        switchesPage.fillingsClick();
        Assert.assertTrue(switchesPage.checkFillingsAll());
    }

    @Test
    @DisplayName("Прверка перехода в раздел Булки")
    public void switchInBuns() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        SwitchesPage switchesPage = new SwitchesPage(browserRule.getWebDriver());
        mainPage
                .open();
        switchesPage
                .fillingsClick()
                .bunsClick();
        Assert.assertTrue(switchesPage.checkBunsAll());
    }
}
