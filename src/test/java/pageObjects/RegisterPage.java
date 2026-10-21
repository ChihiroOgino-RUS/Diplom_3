package pageObjects;

import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;

    // Поле «Имя» — у «Имя» и «Email» одинаковый name="name", поэтому по подписи
    private final By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");

    // Поле «Email»
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");

    // Поле «Пароль»
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");

    // Кнопка «Зарегистрироваться»
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");

    // Кнопка «Войти» внизу формы
    private final By loginButton = By.xpath("//a[text()='Войти']");

    // текст ошибки под паролем — «Некорректный пароль»
    private final By passwordError = By.xpath("//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get(UrlConstants.REGISTER_PAGE);
    }

    @Step("Заполнить имя: {name}")
    public void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнить email: {email}")
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнить пароль")
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Регистрация: {name}, {email}")
    public void register(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
    }

    @Step("Клик по кнопке «Войти»")
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }
}
