package com.krutikasolanki.intentservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MyIntentService.class);
            intent.setAction("com.ripalnakiya.INTENT_SERVICE");
            intent.putExtra("val1", 11);
            startService(intent);

//            AlarmManager alarmManager = getSystemService(AlarmManager.class);
//            PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this, 1, intent, PendingIntent.FLAG_IMMUTABLE);
//            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        });
    }
}