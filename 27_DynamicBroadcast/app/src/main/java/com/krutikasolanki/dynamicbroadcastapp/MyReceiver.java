package com.krutikasolanki.dynamicbroadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            int isTurnedOn = Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0);
            String status = ((isTurnedOn == 1) ? "ON" : "OFF");
            Toast.makeText(context, "AIRPLANE MODE IS " + status, Toast.LENGTH_SHORT).show();
        }
    }
}
