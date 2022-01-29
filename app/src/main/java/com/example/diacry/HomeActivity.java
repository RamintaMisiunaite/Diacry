package com.example.diacry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottom_menu = findViewById(R.id.bottom_navigation);
        bottom_menu.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,
                new calanderFragment()).commit();   // kodel sviecia pirmas menu choice sviecia
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.tipsFragment:
                        selectedFragment = new tipsFragment();
                        break;
                    case R.id.calanderFragment:
                        selectedFragment = new calanderFragment();
                        break;
                    case R.id.statsFragment:
                        selectedFragment = new statsFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,
                        selectedFragment).commit();

                return true;
            }
        };
}