package com.example.mina.scheduleserviceandroid.utils;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import com.example.mina.scheduleserviceandroid.R;
import com.example.mina.scheduleserviceandroid.WelcomeActivity;
import com.example.mina.scheduleserviceandroid.broadcast_reciever.AlarmReciever;


/**
 * Created by Mina-pc on 5/2/2017.
 */

public class AlarmMangerUtil {


    public static void setAlarm(Context context, long interval) {
        PendingIntent pendingIntent;
        AlarmManager manager;
        Intent alarmIntent = new Intent(context, AlarmReciever.class);
        pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
        manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);

    }

    public static void show(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // // Vibrate for 500 milliseconds
        v.vibrate(5000);

        Intent intent = new Intent(context, WelcomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        //
        // // Build notification
        // // Actions are just fake
        Notification notifiction = null;
        notifiction = new android.support.v4.app.NotificationCompat.Builder(
                context)
                .setContentTitle("Notification")
                .setContentText("Hello ,there is new Notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).build();

        // // hide the notification after its selected
        notifiction.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(1, notifiction);

    }
}
