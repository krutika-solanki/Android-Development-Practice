package com.krutikasolanki.handlerthreadclass;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DemoHandlerThread handlerThread = new DemoHandlerThread("Handler Thread");
    private DemoRunnable runnable = new DemoRunnable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendMessageButton = findViewById(R.id.sendMessageButton);
        Button removeMessageButton = findViewById(R.id.removeMessageButton);
        Button sendRefRunnableButton = findViewById(R.id.sendRefRunnableButton);
        Button removeRefRunnableButton = findViewById(R.id.removeRefRunnableButton);
        Button sendRunnableButton = findViewById(R.id.sendRunnableButton);
        Button removeAllButton = findViewById(R.id.removeAllButton);

        sendMessageButton.setOnClickListener(this);
        sendRefRunnableButton.setOnClickListener(this);
        sendRunnableButton.setOnClickListener(this);

        removeMessageButton.setOnClickListener(this);
        removeRefRunnableButton.setOnClickListener(this);
        removeAllButton.setOnClickListener(this);

        handlerThread.start();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sendMessageButton) {
            Message message = Message.obtain();
            message.what = 1;
            message.arg1 = 11;
            message.arg2 = 22;
            message.obj = "String Object";
            handlerThread.getHandler().sendMessage(message);
        } else if (view.getId() == R.id.sendRunnableButton) {
            handlerThread.getHandler().post(new DemoRunnable());
        } else if (view.getId() == R.id.sendRefRunnableButton) {
            handlerThread.getHandler().post(runnable);
        } else if (view.getId() == R.id.removeMessageButton) {
            handlerThread.getHandler().removeMessages(1);
        } else if (view.getId() == R.id.removeRefRunnableButton) {
            handlerThread.getHandler().removeCallbacks(runnable);
        } else if (view.getId() == R.id.removeAllButton) {
            handlerThread.getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }
}