package com.example.grocers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.grocers.Adapters.PlateAdapter;
import com.example.grocers.Models.PlateModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PlateModel> plateModelList;
    private PlateAdapter plateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        recyclerView = findViewById(R.id.recyclerView);
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
    }

    private void autoScroll() {
    final int speedScroll = 0;
    final Handler handler = new Handler();
    final Runnable runnable= new Runnable() {
        int count = 0;
        @Override
        public void run() {

            if (count==plateAdapter.getItemCount()){
                count=0;
            }
            if (count<plateAdapter.getItemCount()){
                recyclerView.smoothScrollToPosition(++count);
                handler.postDelayed(this,speedScroll);
            }

        }
    };
    handler.postDelayed(runnable,speedScroll);
    }



}