package com.krutikasolanki.testapp3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String name;
        if (intent.getAction().equals("com.krutika.ACTION1")) {
//            name = intent.getStringExtra("name");
//            Log.d(TAG, "Intent1 Received " + name);
            Log.d(TAG, "Alarm is Triggerd for 30 min");
        } else if (intent.getAction().equals("com.krutika.ACTION2")) {
            int num = intent.getIntExtra("RollNo", 1);
            Log.d(TAG, "Intent 2 Received " + num);
        } else if (intent.getAction().equals("com.krutika.ACTION3")) {
            Log.d(TAG, "Intent 3 Received ");
        } else {
            Log.d(TAG, "Action not matched");
        }

        MySingltonClass.getInstance(context).edit().putString("Name", "KrutikaSolanki").apply();
        MySingltonClass.getInstance(context).edit().putInt("SerialNo",2).apply();
    }
}