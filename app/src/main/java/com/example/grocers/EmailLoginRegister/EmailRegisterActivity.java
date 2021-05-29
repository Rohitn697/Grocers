package com.example.grocers.EmailLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.grocers.R;

public class EmailRegisterActivity extends AppCompatActivity {
    private TextView alreadyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        alreadyAccount = findViewById(R.id.alreadyAccount);

        alreadyAccountOnclick();
    }

    private void alreadyAccountOnclick() {
        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmailRegisterActivity.this, EmailLoginActivity.class);
                startActivity(i);
                Animatoo.animateSlideRight(EmailRegisterActivity.this);
                finish();
            }
        });


    }
}