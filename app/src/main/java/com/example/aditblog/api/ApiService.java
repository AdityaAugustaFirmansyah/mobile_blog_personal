package com.example.aditblog.api;

import com.example.aditblog.login.ModelLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("login/user")
    Call<ModelLogin>login(@Field("email")String email,@Field("Password")String password);
}
