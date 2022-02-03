package com.example.diacry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {

    TextInputEditText usernameEt, emailEt, pswEt, conf_pswEt;
    String usernameHolder, emailHolder, pswHolder;
    Button submit, redirectToLogin;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setTitle("Register");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }



        usernameEt = findViewById(R.id.usernameEt);
        emailEt = findViewById(R.id.emailEt);
        pswEt = findViewById(R.id.pswEt);
        conf_pswEt = findViewById(R.id.pswConfEt);
        submit = findViewById(R.id.submitBt);
        redirectToLogin = findViewById(R.id.reg_login);
        fAuth = FirebaseAuth.getInstance();

        DAOUser dao = new DAOUser();

        if(fAuth.getCurrentUser() != null){

            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            finish();
        }


        submit.setOnClickListener(v -> {

            usernameHolder = usernameEt.getText().toString().trim();
            emailHolder = emailEt.getText().toString().trim();
            pswHolder = pswEt.getText().toString().trim();


            // register user in firebase
            fAuth.createUserWithEmailAndPassword(emailHolder, pswHolder).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        if(checkFields(usernameEt, emailEt,pswEt, conf_pswEt))
                        {
                            User user = new User(usernameHolder, emailHolder,pswHolder);
                            dao.add(user).addOnSuccessListener(suc -> {
                                Toast.makeText(registerActivity.this, "User is inserted", Toast.LENGTH_SHORT).show();
                            }).addOnFailureListener(er -> {
                                Toast.makeText(registerActivity.this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }
                    }
                    else
                    {
                        Toast.makeText(registerActivity.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        });

        redirectToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });


    }

    private boolean checkFields(EditText username,EditText email, EditText password, EditText confPsw){
        if (TextUtils.isEmpty(username.getText().toString())){
            usernameEt.setError("Field is empty");
            usernameEt.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(email.getText().toString())){
            emailEt.setError("Field is empty");
            emailEt.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(password.getText().toString())){
            pswEt.setError("Field is empty");
            pswEt.requestFocus();
            return false;
        }
        if (password.length() < 6){
            pswEt.setError("Password must be at least 6 characters");
            pswEt.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(confPsw.getText().toString())) {
            conf_pswEt.setError("Field empty");
            conf_pswEt.requestFocus();
            return false;
        } else if (!TextUtils.equals(password.getText().toString(), confPsw.getText().toString())) {
            conf_pswEt.setError("Passwords don't match");
            conf_pswEt.requestFocus();
            return false;
        }
        return true;
    }

    public void openLoginPage(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

