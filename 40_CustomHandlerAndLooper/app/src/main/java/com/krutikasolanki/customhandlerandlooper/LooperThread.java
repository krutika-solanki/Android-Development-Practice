package com.krutikasolanki.customhandlerandlooper;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 *   Handler handler=new handler()        ->will handle only runnable objects
 *   Handler handler=new messageHandler() ->will handle message objects,we are using our custom handler
 */

public class LooperThread extends Thread{
    private static final String TAG = "LooperThread.this";
    public Handler handler;
    public Looper looper;
    @Override
    public void run() {
        Log.d(TAG, "Start of looper thread loop");
        Looper.prepare();

        looper=Looper.myLooper();

        // This handler will also handle the Runnable objects,message objects. since it contains implementation of Posting Runnables by Default
        handler=new MessageHandler();

        Looper.loop();
        Log.d(TAG, "End of looper thread loop");
    }
}
