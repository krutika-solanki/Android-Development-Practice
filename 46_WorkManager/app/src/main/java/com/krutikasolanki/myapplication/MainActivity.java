package com.krutikasolanki.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startButton, stopButton;
    private OneTimeWorkRequest oneTimeRequest1;
    private OneTimeWorkRequest oneTimeRequest2;
    private OneTimeWorkRequest oneTimeRequest3;
    private PeriodicWorkRequest periodicWorkRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker1.class,15,TimeUnit.MINUTES)
//                .setConstraints(constraints)
                .addTag("remainder")
                .build();

        oneTimeRequest1 = new OneTimeWorkRequest.Builder(MyWorker1.class)
                .addTag("worker1")
                .build();
//        oneTimeRequest2 = new OneTimeWorkRequest.Builder(MyWorker1.class).addTag("worker2").build();
//        oneTimeRequest3 = new OneTimeWorkRequest.Builder(MyWorker1.class).addTag("worker3").build();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.startButton) {
//            WorkManager.getInstance(this).beginWith(Arrays.asList(oneTimeRequest1, oneTimeRequest2)).then(oneTimeRequest3).enqueue();
            WorkManager.getInstance(this).enqueue(periodicWorkRequest);
        } else if (v.getId() == R.id.stopButton) {
            WorkManager.getInstance(this).cancelAllWorkByTag("worker2");
        }
    }
}



