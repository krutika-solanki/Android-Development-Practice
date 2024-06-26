package com.krutikasolanki.testapp1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.krutika.ADDITION");
        intentFilter.addAction("com.krutika.SUBTRACTION");
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction("com.krutika.INTENT_PRIME");
        registerReceiver(myReceiver, intentFilter, RECEIVER_EXPORTED);

        boolean flag = true;

        Intent intent = new Intent();
        intent.putExtra("num1", 10);
        intent.putExtra("num2", 15);

        if (flag) {
            intent.setAction("com.krutika.ADDITION");
        } else {
            intent.setAction("com.krutika.SUBTRACTION");
        }
        sendBroadcast(intent);

        SharedPreferences sharedPreferences = getSharedPreferences("Result", MODE_PRIVATE);
        int ans = sharedPreferences.getInt("ans", 0);
        Log.d("MyReceiver", "SharedPreference Value: " + ans);

        Intent intentPrime = new Intent();
        intentPrime.setAction("com.krutika.INTENT_PRIME");
        intentPrime.putExtra("num1", 11);

//        sendBroadcast(intentPrime);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}