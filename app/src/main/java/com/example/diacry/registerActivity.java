package com.example.diacry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    EditText username, email, psw, conf_psw;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = findViewById(R.id.usernameEt);
        email = findViewById(R.id.emailEt);
        psw = findViewById(R.id.pswEt);
        conf_psw = findViewById(R.id.pswConfEt);
        submit = findViewById(R.id.submitBt);

        DAOUser dao = new DAOUser();

        submit.setOnClickListener(v -> {
            User user = new User(username.getText().toString(), email.getText().toString(),
                    psw.getText().toString());
            dao.add(user).addOnSuccessListener(suc -> {
                Toast.makeText(this, "User is inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }
}
