package com.krutikasolanki.multithreading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView textView;
    private static volatile boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.startButton);
        Button stopButton = findViewById(R.id.stopButton);
        textView = findViewById(R.id.textView);

        startButton.setOnClickListener(v -> startThread());
        stopButton.setOnClickListener(v -> stopThread());
    }

    private void stopThread() {
        flag=true;
    }

    private void startThread() {
        flag=false;
        MyRunnable myRunnable=new MyRunnable();
        new Thread(myRunnable).start();
    }
    public class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                Log.d(TAG, "run: StartThread " + i);
                if(flag)
                    return;
                if(i==5){
                    Handler handler=new Handler(Looper.getMainLooper());
                    handler.post((Runnable) ()->{
                        textView.setText("50% ");
                    });
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

