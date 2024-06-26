package com.krutikasolanki.testapp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        int result = 0;

        if (intent.getAction().equals("com.krutika.ADDITION")) {
            result = num1 + num2;
            Log.d(TAG, "Addition: " + result);
        } else if (intent.getAction().equals("com.krutika.SUBTRACTION")) {
            result = num1 - num2;
            Log.d(TAG, "Subtraction: " + result);
        } else if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            Log.d(TAG, "onReceive: Connectivity changed");
        } else if (intent.getAction().equals("com.krutika.INTENT_PRIME")) {
            boolean isPrime = PrimeNumber.checkForPrime(num1);
            Log.d(TAG, "onReceive: isPrime: " + isPrime);
        } else {
            Log.d(TAG, "onReceive: No Action Match");
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences("Result", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("ans", result).apply();
    }
}