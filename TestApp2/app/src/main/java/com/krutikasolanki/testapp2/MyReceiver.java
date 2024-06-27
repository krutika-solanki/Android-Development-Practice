package com.krutikasolanki.testapp2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.krutika.BROADCAST1")){
            Log.d(TAG, "Broadcast Received For EveryDay 9AM");
        } else if(intent.getAction().equals("com.krutika.BROADCAST2")){
            Log.d(TAG, "Broadcast Received For Every 30 Minutes");
        } else if(intent.getAction().equals("com.krutika.BROADCAST3")){
            Log.d(TAG, "Broadcast Received For Every Second");
        } else {
            Log.d(TAG, "Unvalid Action");
        }
    }
}