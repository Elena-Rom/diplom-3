package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class SwitchesPage {
    private final WebDriver webDriver;

    //Текст Профиль
    private final By profile = By.xpath("//a[text()='Профиль']");

    //Конструктор
    private final By constructor = By.xpath("//p[text()='Конструктор']");

    //Соберите бургер
    private final By burgerAdd = By.xpath("//h1[text()='Соберите бургер']");

    //Раздел "Соусы"
    private final By souse = By.xpath("//span[text()='Соусы']");
    //Раздел "Булки"
    private final By buns = By.xpath("//span[text()='Булки']");
    //Раздел "Начинки"
    private final By fillings = By.xpath("//span[text()='Начинки']");

    //Раздел "Булки", содержание
    private final By bunsAll = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Булки']");
    //Раздел "Соусы", содержание
    private final By souseAll = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Соусы']");
    //Раздел "Начинки"
    private final By fillingsAll = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Начинки']");

    @Step("Переход в конструктор")
    public SwitchesPage constructorClick(){
        webDriver.findElement(constructor).click();
        return this;
    }

    public boolean checkProfile(){
        if(webDriver.findElement(profile).isDisplayed()){
            return true;
        }return false;
    }
    public SwitchesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkBurgerAdd() throws InterruptedException {
        sleep(70);
//        new WebDriverWait(webDriver, 3)
//                .until(ExpectedConditions.visibilityOfElementLocated(burgerAdd));
        if(webDriver.findElement(burgerAdd).isDisplayed()){
            return true;
        }return false;
    }

    @Step("Переход в раздел Соусы")
    public SwitchesPage souseClick(){
        webDriver.findElement(souse).click();
        return this;
    }
    @Step("Переход в раздел Булки")
    public SwitchesPage bunsClick(){
        webDriver.findElement(buns).click();
        return this;
    }
    @Step("Переход в раздел Начинки")
    public SwitchesPage fillingsClick(){
        webDriver.findElement(fillings).click();
        return this;
    }
    public boolean checkBunsAll(){
        if(webDriver.findElement(bunsAll).isDisplayed()){
            return true;
        }return false;
    }
    public boolean checkFillingsAll(){
        if(webDriver.findElement(fillingsAll).isDisplayed()){
            return true;
        }return false;
    }
    public boolean checkSousesAll(){
        if(webDriver.findElement(souseAll).isDisplayed()){
            return true;
        }return false;
    }

}
