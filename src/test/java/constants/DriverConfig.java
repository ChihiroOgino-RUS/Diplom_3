package constants;

// Конфигурация драйверов: все значения вынесены сюда, * чтобы настраивать браузеры и ожидания в одном месте.

public class DriverConfig {

    // Значение системного свойства -Dbrowser для Google Chrome
    public static final String BROWSER_CHROME = "chrome";

    // Значение системного свойства -Dbrowser для Яндекс Браузера
    public static final String BROWSER_YANDEX = "yandex";

    // Имя системного свойства, в котором передаётся браузер
    public static final String BROWSER_PROPERTY = "browser";

    // Путь к исполняемому файлу Яндекс Браузера на этой машине
    public static final String YANDEX_BINARY =
            "C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe";

    /** Версия движка Chromium в Яндекс Браузере (не совпадает с версией Chrome!).
     *  У Яндекса движок 150.0.7871.811, но в репозитории Chrome-for-Testing его нет —
     *  берём ближайшую опубликованную сборку 150.0.7871.124 (chromedriver проверяет
     *  только мажорную версию 150). Обновлять при обновлении браузера. */
    public static final String YANDEX_CHROMIUM_VERSION = "150.0.7871.124";

    // Неявное ожидание при поиске элементов
    public static final int IMPLICIT_WAIT_SECONDS = 5;
}

