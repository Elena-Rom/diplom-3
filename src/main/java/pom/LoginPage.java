package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage{
    private final WebDriver webDriver;

    //Форма логина
    private final By loginForm = By.xpath("//form[@class= 'Auth_form__3qKeq mb-20']");

    //Вход со страницы регистрации и со страницы восстановления пароля
    private final By loginInButtonRegAndPass = By.xpath("//a[@class='Auth_link__1fOlj']");

    //Вход с главной страницы
    private final By loginInAccount = By.xpath("//button[text()='Войти в аккаунт']");

    //Кнопка Войти
    private final By loginButton = By.xpath("//button[text()='Войти']");

    //Кнопка Восстановить пароль
    private final By RestorePassword = By.xpath("//a[text()='Восстановить пароль']");

    //Кнопка "Оформить заказ"
    private final By OrderButton = By.xpath("//button[text()='Оформить заказ']");
    //Кнопка "Выйти"
    private final By logoutButton = By.xpath("//button[text()='Выход']");

    //Переход на главный экран
    private final By generalImage = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public LoginPage loginInAccountClick(){
        webDriver.findElement(loginInAccount).click();
        return this;
    }

    @Step("Нажатие на кнопку 'Войти'")
    public LoginPage loginInClick(){
        webDriver.findElement(loginButton).click();
        return this;
    }
    @Step("Нажатие на кнопку 'Выйти'")
    public LoginPage logoutInClick(){
        webDriver.findElement(logoutButton).click();
        return this;
    }

    @Step("Перейти на форму входа со страницы регистрации и со страницы восстановления пароля")
    public LoginPage loginInRegistrationOrPasswordClick(){
        webDriver.findElement(loginInButtonRegAndPass).click();
        return this;
    }

    @Step("Нажатие на кнопку 'Восстановить пароль'")
    public LoginPage RestorePasswordClick(){
        webDriver.findElement(RestorePassword).click();
        return this;
    }

    @Step("Переход на главный экран")
    public LoginPage generalImageClick(){
        webDriver.findElement(generalImage).click();
        return this;
    }

    public boolean checkFormLogin(){
        if(webDriver.findElement(loginForm).isDisplayed()){
            return true;
        }return false;
    }

    public boolean checkOrderButton(){
        if(webDriver.findElement(OrderButton).isDisplayed()){
            return true;
        }return false;
    }
    public boolean checkLogoutButton(){
        if(webDriver.findElement(loginButton).isDisplayed()){
            return true;
        }return false;
    }
}
