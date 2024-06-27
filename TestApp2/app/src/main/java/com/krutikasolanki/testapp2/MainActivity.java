package com.krutikasolanki.testapp2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

// 1. Trigger broadcast at everyday 9 AM
// 2. Trigger broadcast at every 10 minutes
// 3. Trigger broadcast at every second

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    MyReceiver myReceiver;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.krutika.CUSTOM_ACTION");
        intentFilter.addAction("com.krutika.BROADCAST1");
        intentFilter.addAction("com.krutika.BROADCAST2");
        intentFilter.addAction("com.krutika.BROADCAST3");
        registerReceiver(myReceiver, intentFilter, RECEIVER_EXPORTED);

        alarmManager = getSystemService(AlarmManager.class);

        Log.d(TAG, "onCreate: ");
        broadcastForEverySec();
    }

    public void broadcastForEveryDay9AM() {
        Intent intent = new Intent("com.krutika.BROADCAST1");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_IMMUTABLE);

        // Calendar instance to get current time
        Calendar calendar = Calendar.getInstance();

        // Set the time to 9 AM
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        long triggerAtMillis = calendar.getTimeInMillis();      // Set trigger time of 9 AM

        // If current time is past 9 AM, set the alarm for 9 AM the next day
        if (System.currentTimeMillis() > triggerAtMillis) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            triggerAtMillis = calendar.getTimeInMillis();
        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, AlarmManager.INTERVAL_DAY, pendingIntent);
    }


    public void broadcastFor30Min() {
        Intent intent = new Intent("com.krutika.BROADCAST2");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_IMMUTABLE);

        long intervalMillis = AlarmManager.INTERVAL_HALF_HOUR;
        long triggerAtMillis = System.currentTimeMillis();
        Log.d(TAG, "broadcastFor30Min: " + triggerAtMillis);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis, pendingIntent);
    }

    public void broadcastForEverySec() {
        Handler handler = new Handler();
        Intent intent = new Intent();
        intent.setAction("com.krutika.BROADCAST3");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendBroadcast(intent);
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}