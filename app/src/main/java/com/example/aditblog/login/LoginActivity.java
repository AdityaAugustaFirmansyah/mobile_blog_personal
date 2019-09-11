package com.example.aditblog.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aditblog.R;
import com.example.aditblog.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginPresenterContract{

    @BindView(R.id.edt_email_login) EditText edtEmail;
    @BindView(R.id.edt_password_login) EditText edtPassword;
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.tv_to_register) Button btnToRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        final LoginPresenter loginPresenter = new LoginPresenter();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtEmail.getText().toString();
                final String password = edtPassword.getText().toString();
                loginPresenter.index(email,password,LoginActivity.this);
            }
        });

        btnToRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToken(String token) {
        Toast.makeText(LoginActivity.this,token,Toast.LENGTH_SHORT).show();
    }
}
