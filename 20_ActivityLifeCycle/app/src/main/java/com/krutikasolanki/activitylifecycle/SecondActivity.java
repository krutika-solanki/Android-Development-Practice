package com.krutikasolanki.activitylifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity.this";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG,"onCreate: B");
    }
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart: B");
    }
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume: B");
    }
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause: B");
    }
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop: B");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy: B");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart: B");
    }
}