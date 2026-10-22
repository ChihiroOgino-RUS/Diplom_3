package pageObjects;

import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;

    // кнопка «Войти в аккаунт» на главной
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // кнопка «Личный кабинет» в шапке
    private final By personalAccountButton = By.xpath("//a[@href='/account']");

    // кнопка «Оформить заказ» — видна только авторизованному (признак входа)
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");

    // табы конструктора
    private final By bunsTab = By.xpath("//span[text()='Булки']/parent::div");      // «Булки»
    private final By saucesTab = By.xpath("//span[text()='Соусы']/parent::div");    // «Соусы»
    private final By fillingsTab = By.xpath("//span[text()='Начинки']/parent::div");  // «Начинки»

    // активный таб конструктора — класс tab_tab_type_current
    private final By activeTab = By.xpath("//div[contains(@class,'tab_tab_type_current')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get(UrlConstants.MAIN_PAGE);
    }

    @Step("Клик по кнопке «Войти в аккаунт»")
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    @Step("Клик по кнопке «Личный кабинет»")
    public LoginPage clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
        // без авторизации сайт сам перенаправляет на форму входа
        return new LoginPage(driver);
    }

    @Step("Клик по табу «Булки»")
    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Клик по табу «Соусы»")
    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    @Step("Клик по табу «Начинки»")
    public void clickFillingsTab() {
        driver.findElement(fillingsTab).click();
    }

    public boolean isBunsSectionActive() {
        return waitForActiveTabText("Булки");
    }

    public boolean isSaucesSectionActive() {
        return waitForActiveTabText("Соусы");
    }

    public boolean isFillingsSectionActive() {
        return waitForActiveTabText("Начинки");
    }

    // ждём, пока у активного таба не появится нужный текст:
    // пока условие возвращает null — until() продолжает опрос
    private boolean waitForActiveTabText(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement active = wait.until(d -> {
            WebElement tab = d.findElement(activeTab);
            return tab.getText().contains(expectedText) ? tab : null;
        });
        return active != null;
    }

    public boolean isOrderButtonVisible() {
        List<WebElement> buttons = driver.findElements(orderButton);
        return !buttons.isEmpty() && buttons.get(0).isDisplayed();
    }
}

