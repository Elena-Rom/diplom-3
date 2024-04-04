import api.UserClient;
import api.UserData;
import api.UserGenerator;
import browser.BrowserDriver;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.SwitchesPage;

public class SwitchesPageTest {
    @Rule
    public BrowserDriver browserRule = new BrowserDriver();
    private static final UserData user = UserGenerator.getRandomUser();
    static UserClient userClient;

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void before() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        RestAssured.baseURI = BASE_URL;
        userClient = new UserClient();
        userClient.createUser(user);
        mainPage
                .open()
                .personalAreaClick()
                .authorisationClick()
                .nameInput(user.getName())
                .emailInput(user.getEmail())
                .passwordInput(user.getPassword())
                .registrationClick();
    }

    @Test
    @DisplayName("Прверка перехода в личный кабинет")
    public void switchInUserAccount() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        SwitchesPage switchesPage = new SwitchesPage(browserRule.getWebDriver());
        mainPage.personalAreaClick();
        if (loginPage.checkFormLogin()) {
            mainPage
                    .emailInput(user.getEmail())
                    .passwordInput(user.getPassword());
            loginPage.loginInClick();
        }
        mainPage.personalAreaClick();
        Assert.assertTrue(switchesPage.checkProfile());
    }

    @Test
    @DisplayName("Прверка перехода в конструктор из личного кабинета")
    public void switchInConstructor() throws InterruptedException {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        SwitchesPage switchesPage = new SwitchesPage(browserRule.getWebDriver());
        mainPage.personalAreaClick();
        if (loginPage.checkFormLogin()) {
            mainPage
                    .emailInput(user.getEmail())
                    .passwordInput(user.getPassword());
            loginPage.loginInClick();
        }
        mainPage.personalAreaClick();
        switchesPage.constructorClick();
        Assert.assertTrue(switchesPage.checkBunsAll());
    }

    @Test
    @DisplayName("Прверка перехода на главную страницу из личного кабинета")
    public void switchInGeneralPage() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        mainPage.personalAreaClick();
        if (loginPage.checkFormLogin()) {
            mainPage
                    .emailInput(user.getEmail())
                    .passwordInput(user.getPassword());
            loginPage.loginInClick();
        }
        mainPage.personalAreaClick();
        loginPage.generalImageClick();
        Assert.assertTrue(loginPage.checkOrderButton());
    }

}
