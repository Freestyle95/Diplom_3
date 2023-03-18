package org.example.utils;

import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import org.example.ApiConfig;
import org.example.models.AuthorizationData;
import org.example.models.User;

import java.util.List;

import static com.codeborne.selenide.Selenide.localStorage;
import static io.restassured.RestAssured.given;

public class UserHelper extends ApiConfig {
    private final static String AUTH_PATH = "/auth";
    private final static String REGISTER_PATH = AUTH_PATH + "/register";
    private final static String LOGIN_PATH = AUTH_PATH + "/login";
    private final static String USER_PATH = AUTH_PATH + "/user";

    public AuthorizationData authorizationData = new AuthorizationData();

    @Step("Create user with API call")
    private UserHelper createUserWithApi() {
        this.authorizationData.setUser(User.generateRandomUser());
        given().spec(getSpecs()).body(authorizationData.getUser()).post(REGISTER_PATH).then().statusCode(HttpStatus.SC_OK);
        return this;
    }

    @Step("Login user with API call and get tokens")
    private UserHelper login() {
        AuthorizationData authorizationDataAfterLogin = given().spec(getSpecs()).body(User.builder().email(authorizationData.getUser().getEmail()).password(authorizationData.getUser().getPassword()).build()).post(LOGIN_PATH).then().statusCode(HttpStatus.SC_OK).extract().as(AuthorizationData.class);
        this.authorizationData.setAccessToken(authorizationDataAfterLogin.getAccessToken());
        this.authorizationData.setRefreshToken(authorizationDataAfterLogin.getRefreshToken());
        return this;
    }

    @Step("Set local storage auth data")
    public AuthorizationData setLocalStorageAuthData() {
        localStorage().setItem(AuthorizationData.ACCESS_TOKEN, authorizationData.getAccessToken());
        localStorage().setItem(AuthorizationData.REFRESH_TOKEN, authorizationData.getRefreshToken());
        return authorizationData;
    }

    @Step("Create and login with API")
    public AuthorizationData createAndLoginUser() {
        return createUserWithApi().login().authorizationData;
    }

    @Step("Create user")
    public AuthorizationData createUser() {
        return createUserWithApi().authorizationData;
    }

    @Step("Post-condition: delete created users")
    public void deleteUsersPostcondition(List<AuthorizationData> users) {
        for (AuthorizationData userAuthData : users) {
            try {
                given()
                        .spec(getSpecs())
                        .header("Authorization", userAuthData.getAccessToken())
                        .delete(USER_PATH)
                        .then()
                        .statusCode(HttpStatus.SC_ACCEPTED);
            } catch (Exception e) {
                System.out.printf("Неудачная попытка удалить пользователя %s%n", userAuthData.getUser());
            }
        }
    }
}
