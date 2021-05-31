package com.example.grocers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.grocers.Fragments.GoOutFragment;
import com.example.grocers.Fragments.GoldFragment;
import com.example.grocers.Fragments.OrdersFragment;
import com.example.grocers.Fragments.VideosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        frameLayout = findViewById(R.id.frameLayout);

        //default fragment for home activity
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new OrdersFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.orders:
                            selectedFragment = new OrdersFragment();
                            break;

                        case R.id.goldMember:
                            selectedFragment = new GoldFragment();
                            break;

                        case R.id.goOut:
                            selectedFragment = new GoOutFragment();
                            break;

                        case R.id.video:
                            selectedFragment = new VideosFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedFragment).commit();
                    return true;
                }
            };
}