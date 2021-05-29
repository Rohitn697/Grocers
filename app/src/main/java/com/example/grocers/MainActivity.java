package com.example.grocers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.grocers.Adapters.PlateAdapter;
import com.example.grocers.EmailLoginRegister.EmailLoginActivity;
import com.example.grocers.Models.PlateModel;
import com.example.grocers.PhoneLoginRegister.PhoneLoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PlateModel> plateModelList;
    private PlateAdapter plateAdapter;
    private LinearLayout phoneLinearLayout,emailLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        recyclerView = findViewById(R.id.recyclerView);
        phoneLinearLayout = findViewById(R.id.phoneLinearLayout);
        emailLinearLayout = findViewById(R.id.emailLinearLayout);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);

        plateModelList = new ArrayList<>();
        plateModelList.add(new PlateModel(R.drawable.one));
        plateModelList.add(new PlateModel(R.drawable.two));
        plateModelList.add(new PlateModel(R.drawable.three));
        plateModelList.add(new PlateModel(R.drawable.one));
        plateModelList.add(new PlateModel(R.drawable.two));
        plateModelList.add(new PlateModel(R.drawable.three));
        plateModelList.add(new PlateModel(R.drawable.one));

        plateAdapter = new PlateAdapter(plateModelList,this);
        recyclerView.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();

        autoScroll();
        emailOnClick();
        loginWithPhoneOnClick();

    }

    private void loginWithPhoneOnClick() {
        phoneLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PhoneLoginActivity.class);
                startActivity(i);
                Animatoo.animateCard(MainActivity.this);
            }
        });
    }

    public void emailOnClick(){
        emailLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EmailLoginActivity.class);
                startActivity(i);
                Animatoo.animateCard(MainActivity.this);
            }
        });
    }



    public void autoScroll() {
    final int speedScroll = 0;
    final Handler handler = new Handler();
    final Runnable runnable= new Runnable() {
        int count = 0;
        @Override
        public void run() {

            if (count==plateAdapter.getItemCount())
                count=0;

            if (count<plateAdapter.getItemCount()){
                recyclerView.smoothScrollToPosition(++count);
                handler.postDelayed(this,speedScroll);
            }
        }
    };
    handler.postDelayed(runnable,speedScroll);
    }


}