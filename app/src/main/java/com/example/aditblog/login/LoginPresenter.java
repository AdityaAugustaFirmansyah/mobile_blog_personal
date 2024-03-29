package com.example.aditblog.login;

import android.util.Log;

import com.example.aditblog.api.ApiClient;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class LoginPresenter {
    void index(String email, String password, final LoginPresenterContract loginPresenterContract){

        ApiClient apiClient = new ApiClient();
        apiClient.apiService.login(email,password).enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(Call<ModelLogin> call, Response<ModelLogin> response) {
                if (response.isSuccessful()){
                    loginPresenterContract.showToken(response.body().getToken());
                }else {
                    Log.d("GAGAL", response.message());
                }
            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {
                Log.d("GAGAL", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
