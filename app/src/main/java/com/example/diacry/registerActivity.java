package com.example.diacry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    EditText usernameEt, emailEt, pswEt, conf_pswEt;
    String usernameHolder, emailHolder, pswHolder;
    Button submit;

//    public static Intent getStartIntent(Context context){
//        Intent intent = new Intent(context, registerActivity.class);
//        return intent;
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        usernameEt = findViewById(R.id.usernameEt);
        emailEt = findViewById(R.id.emailEt);
        pswEt = findViewById(R.id.pswEt);
        conf_pswEt = findViewById(R.id.pswConfEt);
        submit = findViewById(R.id.submitBt);

        DAOUser dao = new DAOUser();

        submit.setOnClickListener(v -> {

            usernameHolder = usernameEt.getText().toString();
            emailHolder = emailEt.getText().toString();
            pswHolder = pswEt.getText().toString();

            if(checkFields(usernameEt, emailEt,pswEt, conf_pswEt)){
                User user = new User(usernameHolder, emailHolder,pswHolder);
                dao.add(user).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "User is inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                });
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
}

