package com.krutikasolanki.sharedpreferenceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
                Boolean check=preferences.getBoolean("flag",false);

                if(check){
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }else{
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
            }
        },2000);

    }
}