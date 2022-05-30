package com.sherlyeka.reminderapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Broadcast extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "reminder")
                .setSmallIcon(R.mipmap.logo_reminder_dua)
                .setContentTitle("Waktunya Sholat Dhuhur")
                .setContentText("Sholato Cok")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(200, builder.build());
    }
}
