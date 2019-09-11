package com.example.aditblog.api;

import com.example.aditblog.login.ModelLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user/login")
    Call<ModelLogin>login(@Field("email")String email,@Field("password")String password);

    @FormUrlEncoded
    @POST("user/register")
    Call<ModelLogin>register(@Field("name")String name,@Field("email")String email,@Field("password")String password,
                             @Field("password_confirmation")String password_confirm);
}
