package com.sample.mina.todomvvmroomsample.utilities;

import com.sample.mina.todomvvmroomsample.database.NoteEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Mina Alfy on 8/15/2018.
 */

public class SampleData {
    private static String SAMPLE_TEXT_1 = "hi mina";
    private static String SAMPLE_TEXT_2 = "hi mina \n hello hello";
    private static String SAMPLE_TEXT_3 = "hi mina down vote It could be a \"false\" error about the style: check if you the setOnClickListener writed for the correct activity where you have this issue. Maybe you've writed the listener for this button to the wrong activity. You can easily test it by comment temporarely the code about setOnClickListener and re-launching the build..";

    private static Date getDate(int diff) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(calendar.MILLISECOND, diff);
        return calendar.getTime();
    }
    public static List<NoteEntity> getNotes()
    {
        NoteEntity noteEntity1=new NoteEntity(getDate(0),SAMPLE_TEXT_1);
        NoteEntity noteEntity2=new NoteEntity(getDate(-1),SAMPLE_TEXT_2);
        NoteEntity noteEntity3=new NoteEntity(getDate(-2),SAMPLE_TEXT_3);
        List<NoteEntity> noteEntityList=new ArrayList<>();
        noteEntityList.add(noteEntity1);
        noteEntityList.add(noteEntity2);
        noteEntityList.add(noteEntity3);
        return noteEntityList;


    }
}
