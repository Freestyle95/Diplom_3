package org.example.models;

import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String name;
    private String email;
    private String password;

    @Step("Generate random user")
    public static User generateRandomUser() {
        return User.builder()
                .name(String.format("%s %s", RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(8)))
                .email(String.format("%s@example.com", RandomStringUtils.randomAlphanumeric(8)))
                .password(RandomStringUtils.randomAlphanumeric(10))
                .build();
    }
}
