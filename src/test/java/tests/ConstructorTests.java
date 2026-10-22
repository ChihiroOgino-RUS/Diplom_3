package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObjects.MainPage;

import static org.junit.Assert.assertTrue;

@DisplayName("Раздел «Конструктор»")
public class ConstructorTests extends BaseTest {

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Клик по табу «Булки» делает раздел активным")
    public void bunsSectionActiveTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesTab();    // ушли с «Булок»
        mainPage.clickBunsTab();      // вернулись — это настоящий переход
        assertTrue("Раздел «Булки» должен быть активным", mainPage.isBunsSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Клик по табу «Соусы» делает раздел активным")
    public void saucesSectionActiveTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesTab();
        assertTrue("Раздел «Соусы» должен быть активным", mainPage.isSaucesSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Клик по табу «Начинки» делает раздел активным")
    public void fillingsSectionActiveTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsTab();
        assertTrue("Раздел «Начинки» должен быть активным", mainPage.isFillingsSectionActive());
    }
}
