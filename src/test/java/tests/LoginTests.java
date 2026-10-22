package tests;

import client.StellarBurgersClient;
import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.UserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.MainPage;
import pageObjects.RegisterPage;
import utils.TestDataGenerator;

import static org.junit.Assert.assertTrue;

@DisplayName("Вход")
public class LoginTests extends BaseTest {

    private final StellarBurgersClient client = new StellarBurgersClient();
    private UserModel user;
    private String accessToken;

    @Before
    public void createUser() {
        // пользователь создаётся через API до теста
        user = TestDataGenerator.createUniqueUser();
        Response response = client.createUser(user);
        accessToken = response.path("accessToken");
    }

    @After
    public void deleteUser() {
        // удаляем пользователя после теста
        if (accessToken != null) {
            client.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Кнопка «Войти в аккаунт» на главной ведёт на форму входа")
    public void loginViaMainPageButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        MainPage afterLogin = mainPage.clickLoginButton()
                .login(user.getEmail(), user.getPassword());
        assertTrue("Кнопка «Оформить заказ» должна появиться после входа",
                afterLogin.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Кнопка «Личный кабинет» без авторизации ведёт на форму входа")
    public void loginViaPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        MainPage afterLogin = mainPage.clickPersonalAccountButton()
                .login(user.getEmail(), user.getPassword());
        assertTrue("Кнопка «Оформить заказ» должна появиться после входа",
                afterLogin.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Кнопка «Войти» внизу формы регистрации ведёт на форму входа")
    public void loginViaRegisterFormTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        MainPage afterLogin = registerPage.clickLoginButton()
                .login(user.getEmail(), user.getPassword());
        assertTrue("Кнопка «Оформить заказ» должна появиться после входа",
                afterLogin.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Кнопка «Войти» на странице восстановления пароля ведёт на форму входа")
    public void loginViaForgotPasswordFormTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        MainPage afterLogin = forgotPasswordPage.clickLoginButton()
                .login(user.getEmail(), user.getPassword());
        assertTrue("Кнопка «Оформить заказ» должна появиться после входа",
                afterLogin.isOrderButtonVisible());
    }
}

