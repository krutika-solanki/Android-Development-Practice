package com.krutikasolanki.myapplication;



import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.Random;

public class MyWorker1 extends Worker {
    private static final String TAG = "WorkerClass";
    private final int MIN = 0;
    private final int MAX = 100;
    private int mRandomNumber;
    private boolean mIsRandomGenOn;

    public MyWorker1(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        mIsRandomGenOn = true;
    }

    private void startRandomNumberGenerator() {
        int i = 0;
        while (i < 5) {
            try {
                Thread.sleep(1000);
                if (mIsRandomGenOn) {
                    mRandomNumber = new Random().nextInt(MAX) + MIN;
                    Log.d(TAG, "Thread ID: " + Thread.currentThread().getId() + " RandomNumber: " + mRandomNumber);
                    i++;
                }
            } catch (InterruptedException e) {
                Log.d(TAG, "Thread Interrupted.");
            }
        }
    }

    @NonNull
    @Override
    public Result doWork() {
        startRandomNumberGenerator();
        return Result.success();
    }

    @Override
    public void onStopped() {
        super.onStopped();
        Log.d(TAG, "Worker1 is stopped");
    }
}