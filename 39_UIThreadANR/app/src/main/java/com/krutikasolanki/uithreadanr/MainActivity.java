package com.krutikasolanki.uithreadanr;

import static com.krutikasolanki.uithreadanr.R.id.stopbtn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button startbtn;
    Button stopbtn;
    private boolean mstoploop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.d(TAG, "Main Thread " + Thread.currentThread().getId());

        startbtn = findViewById(R.id.startbtn);
        stopbtn = findViewById(R.id.stopbtn);

        startbtn.setOnClickListener(this);
        stopbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.startbtn) {
            mstoploop = true;
            while (mstoploop) {
                Log.d(TAG, "Thread is in while loop " + Thread.currentThread().getId());
            }
        } else if (view.getId() == R.id.stopbtn) {
            mstoploop = false;
        }
    }
}
