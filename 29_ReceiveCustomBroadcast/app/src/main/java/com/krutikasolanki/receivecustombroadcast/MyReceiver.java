package com.krutikasolanki.receivecustombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private TextView textView;

    public MyReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == "com.krutikasolanki.sendcustombroadcast.ACTION_CUSTOM") {
            String receivedText = intent.getStringExtra("com.krutikasolanki.sendcustombroadcast.EXTRA_VALUE");
            if (!receivedText.equals("")) {
                textView.setText(receivedText);
            }
            Toast.makeText(context, "message changed", Toast.LENGTH_SHORT).show();
        }
    }
}
