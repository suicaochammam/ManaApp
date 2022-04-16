package com.example.manaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button login, register;
    EditText username, password, passwordConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        username = (EditText) findViewById(R.id.edtText_usernameRegist);
        password = (EditText) findViewById(R.id.edtText_passwordRegist);
        passwordConf = (EditText) findViewById(R.id.edtText_passwordConfRegist);
        login = (Button) findViewById(R.id.btn_loginRegist);
        register = (Button) findViewById(R.id.btn_registerRegist);

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String srtUsername = username.getText().toString();
                String srtPassword = password.getText().toString();
                String srtPasswordConf = passwordConf.getText().toString();
                if (srtPassword.equals(srtPasswordConf)) {
                    Boolean danhSach = db.insertUser(srtUsername, srtPassword);
                    if (danhSach == true) {
                        Toast.makeText(getApplicationContext(), "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Đăng ký không thành công!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Mật khẩu không khớp!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}