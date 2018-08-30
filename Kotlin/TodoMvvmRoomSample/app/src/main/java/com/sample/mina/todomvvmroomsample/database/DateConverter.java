package com.sample.mina.todomvvmroomsample.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Mina Alfy on 8/28/2018.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timeStamp)
    {
        return timeStamp==null?null:new Date(timeStamp);
    }

    @TypeConverter
    public static Long toTimeStamp(Date date)
    {
        return date==null ?null :date.getTime();
    }
}
