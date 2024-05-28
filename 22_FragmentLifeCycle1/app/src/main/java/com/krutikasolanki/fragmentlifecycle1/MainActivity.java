package com.krutikasolanki.fragmentlifecycle1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.nio.file.ClosedFileSystemException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btnNext;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Activity");

        btnNext = findViewById(R.id.btnNext);
        container = findViewById(R.id.container);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.add(R.id.container, FirstFragment.class, null);
                fragmentTransaction.commit();
            }
        });

        onBackPressedDispatcher.addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Fragment fragment = fragmentManager.findFragmentById(R.id.container);
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.commit();
                } else {
                    finish();
                }
                Log.d(TAG, "handleOnBackPressed: ");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: Activity");
    }
}