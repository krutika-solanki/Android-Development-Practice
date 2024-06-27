package com.krutikasolanki.testapp3;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    MyReceiver myReceiver;
    Button getData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getData = findViewById(R.id.getData);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.krutika.ACTION1");
        intentFilter.addAction("com.krutika.ACTION2");
        intentFilter.addAction("com.krutika.ACTION3");

        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, intentFilter, RECEIVER_EXPORTED);

        Intent intent = new Intent("com.krutika.ACTION1");
        intent.putExtra("name", "krutika");

        Intent intent1 = new Intent("com.krutika.ACTION2");
        intent1.putExtra("RollNo", 6);

        Intent intent2 = new Intent("com.krutika.ACTION3");

//        sendBroadcast(intent);
//        sendBroadcast(intent1);
        sendBroadcast(intent2);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = MySingltonClass.getInstance(getApplicationContext()).getString("Name", "unknown");
                int srNo = MySingltonClass.getInstance(getApplicationContext()).getInt("SerialNo", 0);
                Log.d(TAG, "SharedPreference data 1 " + name);
                Log.d(TAG, "SharedPreference data 2 " + srNo);
            }
        });

    }

    public void sendBroadcastAtEvery30Min() {
        Intent intent = new Intent("com.krutika.ACTION1");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = getSystemService(AlarmManager.class);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_HALF_HOUR, pendingIntent);
    }

}