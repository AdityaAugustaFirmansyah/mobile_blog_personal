package com.example.aditblog.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aditblog.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements RegisterContract {

    @BindView(R.id.edt_name_register) EditText edtName;
    @BindView(R.id.edt_email_register) EditText edtEmail;
    @BindView(R.id.edt_password_register) EditText edtPassword;
    @BindView(R.id.edt_confirm_password_register) EditText edtConfirmPassword;
    @BindView(R.id.btn_register) Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confrimPassword = edtConfirmPassword.getText().toString();

                RegisterPresenter registerPresenter = new RegisterPresenter();
                registerPresenter.index(name,email,password,confrimPassword,RegisterActivity.this);
            }
        });
    }

    @Override
    public void showToken(String token) {
        Toast.makeText(RegisterActivity.this,token,Toast.LENGTH_SHORT).show();
    }
}
