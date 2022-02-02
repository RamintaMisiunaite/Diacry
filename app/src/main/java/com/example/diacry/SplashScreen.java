package com.example.diacry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){

            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            finish();
        }else{
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

    }
}