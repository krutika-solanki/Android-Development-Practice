package com.krutikasolanki.handlerthreadclass;

import android.os.SystemClock;
import android.util.Log;

public class DemoRunnable implements Runnable {
    private static final String TAG = "RipalNakiya";

    @Override
    public void run() {
        Log.d(TAG, "Runnable Started.");
        for (int i = 1; i < 6; i++) {
            Log.d(TAG, "run: " + i);
            SystemClock.sleep(1000);
        }
        Log.d(TAG, "Runnable Stoped.");

    }
}
