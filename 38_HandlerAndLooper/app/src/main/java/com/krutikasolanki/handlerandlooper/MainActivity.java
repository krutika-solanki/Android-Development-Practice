package com.krutikasolanki.handlerandlooper;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity.this";
    TextView txtView;
    Button startbtn, stopbtn;
    private boolean mstoploop;
    int count = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Main Thread " + Thread.currentThread().getId());

        txtView = findViewById(R.id.txtView);
        startbtn = findViewById(R.id.startbtn);
        stopbtn = findViewById(R.id.stopbtn);

        handler = new Handler(getApplicationContext().getMainLooper());

        startbtn.setOnClickListener(this);
        stopbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.startbtn) {
            mstoploop = true;
            new Thread((Runnable) () -> {
                while (mstoploop) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Log.d(TAG, "Thread is in while loop " + Thread.currentThread().getId() + " " + count);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            txtView.setText(" " + count);
                            count++;
                        }
                    });
                }
            }).start();
        } else if (view.getId() == R.id.stopbtn) {
            mstoploop = false;
        }
    }
}