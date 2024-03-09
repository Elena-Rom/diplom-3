import api.UserClient;
import api.UserData;
import api.UserGenerator;
import browser.BrowserDriver;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import pom.LoginPage;
import pom.MainPage;

public class LoginTest {

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
    @DisplayName("Прверка входа со страницы регистрации")
    public void loginInPageRegistration() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        loginPage.loginInRegistrationOrPasswordClick();
        if(loginPage.checkFormLogin()){
            mainPage
                    .emailInput(user.getEmail())
                    .passwordInput(user.getPassword());
            loginPage.loginInClick();
        }
        Assert.assertTrue(loginPage.checkOrderButton());

    }

    @Test
    @DisplayName("Прверка входа через личный кабинет")
    public void loginInPageUserAccount() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        mainPage.personalAreaClick();
        if (loginPage.checkFormLogin()) {
            mainPage
                    .emailInput(user.getEmail())
                    .passwordInput(user.getPassword());
            loginPage.loginInClick();
        }
        Assert.assertTrue(loginPage.checkOrderButton());
    }

    @Test
    @DisplayName("Прверка входа через Восстановления пароля")
    public void loginInPageRestorePassword() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        mainPage.personalAreaClick();
        loginPage
                .RestorePasswordClick()
                .loginInRegistrationOrPasswordClick();
        if (loginPage.checkFormLogin()) {
            mainPage
                    .emailInput(user.getEmail())
                    .passwordInput(user.getPassword());
            loginPage.loginInClick();
        }
        Assert.assertTrue(loginPage.checkOrderButton());
    }

    @Test
    @DisplayName("Прверка входа c главной страницы")
    public void loginInPageGeneral() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        loginPage
                .generalImageClick()
                .loginInAccountClick();
        if (loginPage.checkFormLogin()) {
            mainPage
                    .emailInput(user.getEmail())
                    .passwordInput(user.getPassword());
            loginPage.loginInClick();
        }
        Assert.assertTrue(loginPage.checkOrderButton());
    }

    @Test
    @DisplayName("Проверка выхода")
    public void logout() {
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
        loginPage.logoutInClick();
        Assert.assertTrue(loginPage.checkFormLogin());
    }
}
