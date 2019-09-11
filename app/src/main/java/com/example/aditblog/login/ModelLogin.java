package com.example.aditblog.login;

import com.squareup.moshi.Json;

public class ModelLogin {
    @Json(name = "token")
    private String token;

    private String error;

    public ModelLogin(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getError() {
        return error;
    }
}
