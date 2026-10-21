package pageObjects;

import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    // кнопка «Войти» на странице восстановления пароля
    private final By loginButton = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу восстановления пароля")
    public void open() {
        driver.get(UrlConstants.FORGOT_PASSWORD_PAGE);
    }

    @Step("Клик по кнопке «Войти»")
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
