package com.krutikasolanki.activitylifecycle;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity.this";

    Button dialog_button, btnB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: A");

        dialog_button = findViewById(R.id.dialogButton);
        btnB = findViewById(R.id.activityButton);

        Intent intent = new Intent(this, SecondActivity.class);

        dialog_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        //finish();
    }

    private ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
        if (isGranted) {
            // Permission is granted. Continue the action or workflow in your
            // app.
        }
    });

    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: A");
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: A");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: A");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: A");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: A");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart: A");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG,"onRestoreInstanceState: A");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG,"onSaveInstanceState: A");
    }
}
