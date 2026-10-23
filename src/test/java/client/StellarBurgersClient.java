package client;

import constants.UrlConstants;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.UserModel;

import static io.restassured.RestAssured.given;

public class StellarBurgersClient {
    @Step("Создание пользователя")
    public Response createUser(UserModel user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(UrlConstants.USER_REGISTER_URL);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String token) {
        return given()
                .header("Authorization", token)
                .when()
                .delete(UrlConstants.USER_DELETE_URL);
    }
}
