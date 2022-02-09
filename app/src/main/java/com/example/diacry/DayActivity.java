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
            int check = 1;
            @Override
            public void onClick(View view) {
                    if (check == 1) {
                        tear1.setBackgroundResource(R.drawable.tear_buttons_pressed);
                        check = 0;
                        tear2.setClickable(false);
                        tear3.setClickable(false);
                    } else {
                        tear1.setBackgroundResource(R.drawable.tear_button);
                        check = 1;
                        tear2.setClickable(true);
                        tear3.setClickable(true);
                    }
                // pazymet burbuliuka calendoriuj
                // idet i duombaze
            }
        });
        tear2.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    tear2.setBackgroundResource(R.drawable.tear_buttons_pressed);
                    check = 0;
                    tear1.setClickable(false);
                    tear3.setClickable(false);
                } else {
                    tear2.setBackgroundResource(R.drawable.tear_button);
                    check = 1;
                    tear1.setClickable(true);
                    tear3.setClickable(true);
                }
            }
        });
        tear3.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    tear3.setBackgroundResource(R.drawable.tear_buttons_pressed);
                    check = 0;
                    tear1.setClickable(false);
                    tear2.setClickable(false);
                } else {
                    tear3.setBackgroundResource(R.drawable.tear_button);
                    check = 1;
                    tear1.setClickable(true);
                    tear2.setClickable(true);
                }
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
               params.setMargins(60,0,60,0);
               tv.setLayoutParams(params);
               tv.setTextSize(22);
               tv.setTextColor(Color.parseColor("#000000"));
               linearLayout.addView(tv);
           }
       });


    }
}