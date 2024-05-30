package com.krutikasolanki.foregroundserviceapp;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * Foreground service must show a notification <br>
 * Service will keep running even if the {@link MainActivity} is destroyed <br>
 * This Service can be stopped from the System explicitly<br>
 * <br>
 * We has to define permission for Foreground service in Manifest file
 */
public class ForegroundService extends Service {
    MediaPlayer mediaPlayer;
    Notification notification;
    public static final String CHANNEL_ID = "101";

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.sherlock_holmes);
        mediaPlayer.setLooping(true);
        createNotification();
        createNotificationChannel();
    }

    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(101, notification);
        mediaPlayer.start();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void createNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE);

        @SuppressLint({"NewApi", "LocalSuppress"})
        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("Music")
                .setContentText("Music is playing..")
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
                .setColorized(true)
                .setOngoing(true)
                .setSmallIcon(R.drawable.ic_launcher_background);

        notification = builder.build();
    }

    public void createNotificationChannel() {
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID, "Music is playing", NotificationManager.IMPORTANCE_DEFAULT);
            getSystemService(NotificationManager.class).createNotificationChannel(channel);

        }
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}