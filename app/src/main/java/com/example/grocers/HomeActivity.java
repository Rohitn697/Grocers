package com.example.grocers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.orders:
                            Toast.makeText(HomeActivity.this, "orders", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.goldMember:
                            Toast.makeText(HomeActivity.this, "goldMemberTest", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.goOut:
                            Toast.makeText(HomeActivity.this, "goOutTest", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.video:
                            Toast.makeText(HomeActivity.this, "videoTest", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                }
            };
}