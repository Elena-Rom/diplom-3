import api.UserClient;
import api.UserData;
import api.UserGenerator;
import browser.BrowserDriver;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;

public class AuthorisationTest {

    private static final UserData user = UserGenerator.getRandomUser();

    static UserClient userClient;

    @Rule
    public BrowserDriver browserRule = new BrowserDriver();
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void beforeClass() {
        RestAssured.baseURI = BASE_URL;
        userClient = new UserClient();
        userClient.createUser(user);
    }


    @Test
    @DisplayName("Прверка Успешной регистрации")
    public void authorisationTrue(){
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage
                .open()
                .personalAreaClick()
                .authorisationClick()
                .nameInput(user.getName())
                .emailInput(user.getEmail())
                .passwordInput(user.getPassword())
                .registrationClick();
        Assert.assertTrue(mainPage.checkFormLogin());

    }
    @Test
    @DisplayName("Прверка не успешной регистрации, короткий пароль")
    public void authorisationFalse(){
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        mainPage
                .open()
                .personalAreaClick()
                .authorisationClick()
                .nameInput(user.getName())
                .emailInput(user.getEmail())
                .passwordInput(RandomStringUtils.randomAlphanumeric(5))
                .registrationClick();
        Assert.assertTrue(mainPage.checkNotCorrectPassword());
    }

}
