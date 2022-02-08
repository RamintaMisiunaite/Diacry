package com.example.diacry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DayActivity extends AppCompatActivity {

    ImageButton tear1, tear2,tear3;
    Button addBt;
    TextView notesTv;
    EditText notesEt;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        tear1 = findViewById(R.id.tear1);
        tear2 = findViewById(R.id.tear2);
        tear3 = findViewById(R.id.tear3);
        notesEt = findViewById(R.id.notesEt);
        addBt = findViewById(R.id.addBt);
        linearLayout = findViewById(R.id.llMain);
        ArrayList<String> list = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);

        tear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tear1.setBackgroundResource(R.drawable.tear_buttons_pressed);
                // pazymet burbuliuka calendoriuj
                // idet i duombaze
            }
        });
        tear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tear2.setBackgroundResource(R.drawable.tear_buttons_pressed);
            }
        });
        tear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tear3.setBackgroundResource(R.drawable.tear_buttons_pressed);
            }
        });

       addBt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               TextView tv = new TextView(getApplicationContext());
               tv.setText(notesEt.getText().toString().trim() + "\n");
               LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                       LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.MATCH_PARENT
               );
               params.setMargins(20,0,20,0);
               tv.setLayoutParams(params);
               tv.setTextSize(22);
               tv.setTextColor(Color.parseColor("#000000"));
               linearLayout.addView(tv);
           }
       });


    }
}