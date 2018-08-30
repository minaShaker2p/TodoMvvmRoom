package com.sample.mina.todomvvmroomsample;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.sample.mina.todomvvmroomsample.database.AppDatabase;
import com.sample.mina.todomvvmroomsample.database.NoteDAO;
import com.sample.mina.todomvvmroomsample.database.NoteEntity;
import com.sample.mina.todomvvmroomsample.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Mina Alfy on 8/28/2018.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private AppDatabase mAppDatabase;
    private NoteDAO mNoteDAO;

    @Before
    public void createDB() {
        Context context = InstrumentationRegistry.getTargetContext();
        mAppDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mNoteDAO = mAppDatabase.noteDAO();
        Log.i(TAG, "createDB");
    }

    @After
    public void closeDB() {
        mAppDatabase.close();
        Log.i(TAG, "closeDB");
    }

    @Test
    public void createAndRetrieveNotes() {
        mNoteDAO.InsertNotesList(SampleData.getNotes());
        int count = mNoteDAO.getNotesCount();
        Log.i(TAG, "createAndRetrieve: count" + count);
        assertEquals(SampleData.getNotes().size(), count);
    }

    @Test
    public void compareStrings() {
        mNoteDAO.InsertNotesList(SampleData.getNotes());
        NoteEntity original = SampleData.getNotes().get(0);
        NoteEntity fromDB = mNoteDAO.getNoteById(1);
        assertEquals(1, fromDB.getId());
    }

}
