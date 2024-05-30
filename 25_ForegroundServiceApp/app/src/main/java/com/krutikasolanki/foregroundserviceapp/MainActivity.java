package com.krutikasolanki.foregroundserviceapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Intent foregroundIntent;
    Button startService, stopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = findViewById(R.id.startService);
        stopService = findViewById(R.id.stopService);
        startService.setOnClickListener(onClickListener);
        stopService.setOnClickListener(onClickListener);

        foregroundIntent = new Intent(MainActivity.this, ForegroundService.class);

        reqPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.startService) {
                startForegroundService(foregroundIntent);
            } else if (view.getId() == R.id.stopService) {
                stopService(foregroundIntent);
            } else {
                Log.d("MainActivity", "onClick: No action set");
            }
        }
    };

    private ActivityResultLauncher<String> reqPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
        if (isGranted) {
            // Permission is granted. Continue the action or workflow in your app.
        }
    });
}