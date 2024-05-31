package com.krutikasolanki.backgroundserviceapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Background Service need not to show a notification <br>
 * Service will keep running even if the {@link MainActivity} is stopped <br>
 * This Service will be stopped if the {@link MainActivity} is destroyed<br>
 */

public class MainActivity extends AppCompatActivity {
    Button startService;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService=findViewById(R.id.startService);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent=new Intent(MainActivity.this,BackgroundService.class);
                startService(serviceIntent);
            }
        });
    }
}