package core;

import constants.DriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver createDriver(String browser) {
        if (DriverConfig.BROWSER_YANDEX.equals(browser)) {
            // у Яндекс Браузера свой движок Chromium (не той версии, что у Chrome) —
            // поэтому для Яндекса явно указываем версию его движка
            WebDriverManager.chromedriver()
                    .browserVersion(DriverConfig.YANDEX_CHROMIUM_VERSION)
                    .setup();
        } else {
            // WebDriverManager сам скачивает chromedriver под версию Chrome
            // и прописывает webdriver.chrome.driver за нас
            WebDriverManager.chromedriver().setup();
        }

        ChromeOptions options = new ChromeOptions();
        // окно сразу максимальное — не зависеть от гонки при вызове maximize()
        options.addArguments("--start-maximized");
        // Яндекс Браузер работает на Chromium, поэтому драйвер тот же (chromedriver),
        // а сам браузер выбираем через путь к исполняемому файлу
        if (DriverConfig.BROWSER_YANDEX.equals(browser)) {
            options.setBinary(DriverConfig.YANDEX_BINARY);
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DriverConfig.IMPLICIT_WAIT_SECONDS));
        return driver;
    }
}
