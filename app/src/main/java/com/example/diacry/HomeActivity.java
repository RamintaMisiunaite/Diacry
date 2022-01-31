package com.example.diacry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.nav_view);
        context = getApplicationContext();

        BottomNavigationView bottom_menu = findViewById(R.id.bottom_navigation);
        bottom_menu.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,
                new calanderFragment()).commit();   // kodel sviecia pirmas menu choice sviecia

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView.setNavigationItemSelectedListener(drawerListener);

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // reaguoja i drawer menu mygtuko paspaudimus
    private NavigationView.OnNavigationItemSelectedListener drawerListener =
            new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.drawer_1:
                    Toast.makeText(context, "option1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.drawer_2:
                    Toast.makeText(context, "option2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.drawer_3:
                    Toast.makeText(context, "option3", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        }
    };
}