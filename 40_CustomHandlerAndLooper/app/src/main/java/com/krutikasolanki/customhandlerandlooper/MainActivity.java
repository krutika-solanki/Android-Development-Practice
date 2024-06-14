package com.krutikasolanki.customhandlerandlooper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity.this";
    private LooperThread looperThread=new LooperThread();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Main Thread ID: "+ Thread.currentThread().getId());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.startButton);
        Button taskAButton = findViewById(R.id.taskAButton);
        Button taskBButton = findViewById(R.id.taskBButton);
        Button stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(view -> onStartButton());
        taskAButton.setOnClickListener(view -> onTaskAButton());
        taskBButton.setOnClickListener(view -> onTaskBButton());
        stopButton.setOnClickListener(view -> onStopButton());
    }

    private void onTaskAButton() {

    /*    looperThread.handler.post((Runnable )()->{
            for (int i=1; i<6; i++){
                Log.d(TAG,"Task A is runnig: "+ i);
                SystemClock.sleep(1000);
            }
        });
        */

        Handler handler=new Handler(looperThread.looper);
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<6; i++){
                    Log.d(TAG,"Task A is runnig: "+ i);
                    SystemClock.sleep(1000);
                }
                Toast.makeText(MainActivity.this, "Task A completed.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void onStartButton() {
        looperThread.start();
        Toast.makeText(this, "Looper Started.", Toast.LENGTH_SHORT).show();
    }

    private void onTaskBButton() {
        Message message=Message.obtain();
        message.what=2;
        looperThread.handler.sendMessage(message);
        Toast.makeText(MainActivity.this, "Task B completed.", Toast.LENGTH_SHORT).show();
    }

    private void onStopButton() {
        looperThread.looper.quit();
        Toast.makeText(this, "Looper Stoped.", Toast.LENGTH_SHORT).show();
    }

}