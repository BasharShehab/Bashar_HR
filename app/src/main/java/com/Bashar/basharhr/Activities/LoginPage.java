package com.Bashar.basharhr.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Bashar.basharhr.R;
import com.Bashar.basharhr.SQLiteDatabase.MySQLiteDatabase;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
    Button register, login;
    EditText username, password;
    private boolean doubleBackToExitPressedOnce;
    private MySQLiteDatabase sqLiteHelper;
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        login = findViewById(R.id.login);
        register = findViewById(R.id.HR_register);
        username = findViewById(R.id.HR_userName);
        password = findViewById(R.id.HR_password);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        user = username.getText().toString().trim();
        pass = password.getText().toString().trim();

        sqLiteHelper = new MySQLiteDatabase(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.login:
                try {
                    if (sqLiteHelper.checkLogin(username.getText().toString(),  password.getText().toString()) ) {
                        Intent loggingIn = new Intent(LoginPage.this, MainPage.class);
                        startActivity(loggingIn);
                    } else {
                        Toast.makeText(this, "Wrong Username/password!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    break;
            case R.id.HR_register:
                try {
                    Intent registering = new Intent(LoginPage.this, RegisterPage.class);
                    startActivity(registering);
                    break;
                }
                catch (Exception e){
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finishAffinity();
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
