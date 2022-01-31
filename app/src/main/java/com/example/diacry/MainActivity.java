package com.example.diacry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button home, day, register, login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = findViewById(R.id.registerBt);
        login = findViewById(R.id.loginBt);
        home = findViewById(R.id.homebt);
        day = findViewById(R.id.daybt);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterActivity();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDayActivity();
            }
        });
    }

    public void openHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
    public void openDayActivity(){
        Intent intent = new Intent(this, DayActivity.class);
        startActivity(intent);
        finish();
    }
    public void openRegisterActivity(){
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
        finish();
    }



}