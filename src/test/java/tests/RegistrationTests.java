package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.UserModel;
import org.junit.Test;
import page.objects.RegisterPage;
import utils.TestDataGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Страница «Регистрация»")
public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя через UI")
    @Description("Проверяет регистрацию и редирект на страницу логина")
    public void registerValidUserTest() {
        UserModel user = TestDataGenerator.createUniqueUser();   // уникальный email

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        assertTrue("После успешной регистрации должен открыться вход", registerPage.isLoginPageOpened());
    }

    @Test
    @DisplayName("Регистрация с паролем короче 6 символов")
    @Description("Пароль из 5 символов не проходит валидацию")
    public void registerWithShortPasswordTest() {
        UserModel user = TestDataGenerator.createUniqueUser();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.register(user.getName(), user.getEmail(), "12345");

        assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
    }
}
