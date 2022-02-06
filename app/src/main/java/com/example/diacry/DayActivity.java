package com.example.diacry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class DayActivity extends AppCompatActivity {

    ImageButton tear1, tear2,tear3;
    Button addBt;
    ListView listView;
    EditText notesEt;
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
        listView = findViewById(R.id.listView);
        notesEt = findViewById(R.id.notesEt);
        addBt = findViewById(R.id.addBt);
        ArrayList<String> list = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

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
                tear1.setBackgroundResource(R.drawable.tear_buttons_pressed);
            }
        });
        tear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tear1.setBackgroundResource(R.drawable.tear_buttons_pressed);
            }
        });

        notesEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBt.setVisibility(View.VISIBLE);
                addBt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String note = notesEt.getText().toString().trim();
                        list.add(note);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}