package com.krutikasolanki.handlerthreadclass;

import android.os.Handler;
import android.os.HandlerThread;

public class DemoHandlerThread extends HandlerThread {
    private Handler handler;

    public DemoHandlerThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        handler = new MessageHandler();
    }

    public Handler getHandler() {
        return handler;
    }
}
