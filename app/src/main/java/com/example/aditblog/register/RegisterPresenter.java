package com.example.aditblog.register;

import android.util.Log;

import com.example.aditblog.api.ApiClient;
import com.example.aditblog.login.ModelLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {
    void index(String name, String email, String password, String passwordConf, final RegisterContract registerContract){
        ApiClient apiClient = new ApiClient();
        apiClient.apiService.register(name, email, password, passwordConf).enqueue(new Callback<ModelLogin>() {
            @Override
            public void onResponse(Call<ModelLogin> call, Response<ModelLogin> response) {
                if (response.isSuccessful()){
                    registerContract.showToken(response.body().getToken());
                }else {
                    Log.d("ERROR",response.message());
                }
            }

            @Override
            public void onFailure(Call<ModelLogin> call, Throwable t) {
                Log.d("ERROR",t.getMessage());
            }
        });
    }
}
