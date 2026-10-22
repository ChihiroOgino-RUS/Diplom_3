package constants;

public class UrlConstants {
    public static final String BASE_URL = "https://qa-stellarburgers.education-services.ru";

    // Страницы сайта
    public static final String MAIN_PAGE = BASE_URL;
    public static final String REGISTER_PAGE = BASE_URL + "/register";
    public static final String LOGIN_PAGE = BASE_URL + "/login";
    public static final String FORGOT_PASSWORD_PAGE = BASE_URL + "/forgot-password";

    // Эндпоинты API
    public static final String USER_REGISTER_URL = BASE_URL + "/api/auth/register";
    public static final String USER_DELETE_URL = BASE_URL + "/api/auth/user";

    private UrlConstants() {
    }
}
