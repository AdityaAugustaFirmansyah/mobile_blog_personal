package com.example.aditblog.api;

import retrofit2.Retrofit;

public class ApiClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8000/api/")
            .build();

    public ApiService apiService = retrofit.create(ApiService.class);
}
