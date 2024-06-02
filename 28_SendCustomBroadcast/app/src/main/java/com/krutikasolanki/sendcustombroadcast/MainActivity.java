package com.krutikasolanki.sendcustombroadcast;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity.this";
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sendText;
                if (!editText.getText().toString().equals("")) {
                    sendText = editText.getText().toString();
                } else {
                    sendText = "My Null";
                }

                Intent intent = new Intent("com.krutikasolanki.sendcustombroadcast.ACTION_CUSTOM");
                intent.putExtra("com.krutikasolanki.sendcustombroadcast.EXTRA_VALUE", sendText);

                // Normal Broadcast : Without any permissions
//                sendBroadcast(intent);

                // Protected Broadcast : With permissions
                sendBroadcast(intent, Manifest.permission.INTERNET);

                Log.d(TAG, "onClick: Broadcast sent");
            }
        });
    }
}