package com.example.mina.scheduleserviceandroid.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.mina.scheduleserviceandroid.utils.AlarmMangerUtil;

/**
 * Created by Mina-pc on 5/3/2017.
 */

public class ScheduleService extends IntentService {
    Context context;


    public ScheduleService() {
        super("ScheduleService");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // here we will do any thing in this background service
        context = getApplicationContext();
        AlarmMangerUtil.show(context);


    }
}
