package com.example.mina.scheduleserviceandroid.broadcast_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.mina.scheduleserviceandroid.services.ScheduleService;

/**
 * this broadcast reciever will be called continuosly at specific interval
 */

public class AlarmReciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent background = new Intent(context, ScheduleService.class);
        context.startService(background);

    }
}