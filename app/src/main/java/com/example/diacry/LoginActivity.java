package com.example.diacry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText emailEt, pswEt;
    String email, psw;
    Button redirectToReg, submit, forgotPsw;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setTitle("Log In");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }


        emailEt = findViewById(R.id.emailEt);
        pswEt = findViewById(R.id.pswEt);
        submit = findViewById(R.id.submit_login);
        redirectToReg = findViewById(R.id.login_reg);
        forgotPsw = findViewById(R.id.forgot_psw);
        fAuth = FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailEt.getText().toString();
                psw = pswEt.getText().toString();
                if (TextUtils.isEmpty(email)){
                    emailEt.setError("Field is empty");
                    emailEt.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(psw)){
                    pswEt.setError("Field is empty");
                    pswEt.requestFocus();
                    return;
                }

                //authenticate the user
                fAuth.signInWithEmailAndPassword(email,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "logged in succesfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this, "Error "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        redirectToReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegActivity();
            }
        });

        forgotPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgotPsw();
            }
        });

    }

    public void openRegActivity(){
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
        finish();
    }

    public void openForgotPsw(){
        Intent intent = new Intent(this, ForgotPswActivity.class);
        startActivity(intent);
        finish();
    }
}