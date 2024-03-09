package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver webDriver;

    private final By personalArea = By.xpath("//p[text()='Личный Кабинет']");
    private final By autorisation = By.xpath ("//a[text()='Зарегистрироваться']");
    private final By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By buttonRegistration = By.xpath("//button[text()='Зарегистрироваться']");
    private final By formLogin = By.xpath("//form[@class='Auth_form__3qKeq mb-20']");
    private final By noCorrectPassword = By.xpath("//p[text()='Некорректный пароль']");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Открытие браузера")
    public MainPage open() {
        webDriver.get(URL);
        return this;
    }
    @Step("Нажатие на кнопку 'Личный кабинет'")
    public MainPage personalAreaClick(){
        webDriver.findElement(personalArea).click();
        return this;
    }
    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public MainPage authorisationClick(){
        webDriver.findElement(autorisation).click();
        return this;
    }
    @Step("Ввод в поле 'Имя'")
    public MainPage nameInput(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
        return this;
    }
    @Step("Ввод в поле 'Email'")
    public MainPage emailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
        return this;
    }
    @Step("Ввод в поле 'Пароль'")
    public MainPage passwordInput(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step("Нажатие на кнопку 'Регистрация'")
    public MainPage registrationClick(){
        webDriver.findElement(buttonRegistration).click();
        return this;
    }

    public boolean checkFormLogin(){
        if(webDriver.findElement(formLogin).isDisplayed()){
            return true;
        }return false;
    }

    public boolean checkNotCorrectPassword(){
        if(webDriver.findElement(noCorrectPassword).isDisplayed()){
            return true;
        }return false;
    }


}
