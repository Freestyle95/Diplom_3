package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.pages.BasePage;

public class ApiConfig {
    public static final String BASE_URL = BasePage.BASE_URL + "api";

    protected RequestSpecification getSpecs() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}