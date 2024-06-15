package com.krutikasolanki.handlerthreadclass;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;

public class MessageHandler extends Handler {
    private static final String TAG = "RipalNakiya";
    public static final int EXAMPLE_TASK = 1;

    @Override
    public void handleMessage(@NonNull Message msg) {
        if (msg.what == EXAMPLE_TASK) {
            Log.d(TAG, "EXAMPLE_TASK:  arg1:" + msg.arg1 + " arg2:" + msg.arg2);
            for (int i = 1; i < 5; i++) {
                Log.d(TAG, "EXAMPLE TASK " + i);
                SystemClock.sleep(1000);
            }
            Log.d(TAG, "EXAMPLE_TASK -> executed.");
        }
    }
}
