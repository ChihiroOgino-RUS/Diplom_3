package constants;

/**
 * Конфигурация драйверов: все значения вынесены сюда,
 * чтобы настраивать браузеры и ожидания в одном месте.
 */
public class DriverConfig {

    /** Значение системного свойства -Dbrowser для Google Chrome */
    public static final String BROWSER_CHROME = "chrome";

    /** Значение системного свойства -Dbrowser для Яндекс Браузера */
    public static final String BROWSER_YANDEX = "yandex";

    /** Имя системного свойства, в котором передаётся браузер */
    public static final String BROWSER_PROPERTY = "browser";

    /** Путь к исполняемому файлу Яндекс Браузера на этой машине */
    public static final String YANDEX_BINARY =
            "C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe";

    /** Неявное ожидание при поиске элементов, секунд */
    public static final int IMPLICIT_WAIT_SECONDS = 5;

    private DriverConfig() {
    }
}

