package org.example.models;

import lombok.Data;

@Data
public class AuthorizationData {

    public static final String ACCESS_TOKEN = "accessToken";
    public static final String REFRESH_TOKEN = "refreshToken";
    private String accessToken;
    private String refreshToken;
    private User user;
}