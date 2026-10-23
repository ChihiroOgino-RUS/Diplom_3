package page.objects;

import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // Поле Email
    private final By emailField = By.xpath("//input[@name='name' and @type='text']");

    // Поле Пароль
    private final By passwordField = By.xpath("//input[@name='Пароль' and @type='password']");

    // Кнопка "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу входа")
    public void open() {
        driver.get(UrlConstants.LOGIN_PAGE);
    }

    @Step("Заполняем поле Email: {email}")
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполняем поле пароля")
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке «Войти»")
    public MainPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

    @Step("Вход: email {email}")
    public MainPage login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        return clickLoginButton();
    }
}
