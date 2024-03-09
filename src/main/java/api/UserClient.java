package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String USER_CREATE_URL = "api/auth/register";

    @Step("Создание пользователя")
    public Response createUser(UserData userData) {
        return (Response) given()
                .header("Content-type", "application/json")
                .and()
                .body(userData)
                .when()
                .post(USER_CREATE_URL)
                .then()
                .extract();
    }
}
