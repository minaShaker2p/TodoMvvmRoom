package com.sample.mina.todomvvmroomsample.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.sample.mina.todomvvmroomsample.database.AppDatabase;
import com.sample.mina.todomvvmroomsample.database.NoteEntity;
import com.sample.mina.todomvvmroomsample.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Mina Alfy on 8/29/2018.
 */

public class AppRepository {
    private static AppRepository ourInstance = null;
    public LiveData<List<NoteEntity>> mNotes;
    private AppDatabase mAppDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new AppRepository(context);
        return ourInstance;
    }

    private AppRepository(Context context) {
        mAppDatabase = AppDatabase.getInstance(context);
        mNotes = getAllNotes();
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.noteDAO().InsertNotesList(SampleData.getNotes());
            }
        });
    }

    private LiveData<List<NoteEntity>> getAllNotes() {
        return mAppDatabase.noteDAO().getAllNotes();
    }

    public void deleteAllNotes() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.noteDAO().deleteALlNotes();
            }
        });
    }

    public NoteEntity getNoteById(int noteId) {
        return mAppDatabase.noteDAO().getNoteById(noteId);

    }

    public void insertNote(final NoteEntity noteEntity) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.noteDAO().InsertNote(noteEntity);
            }
        });
    }

    public void deleteNote(final NoteEntity noteEntity) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mAppDatabase.noteDAO().deleteNote(noteEntity);
            }
        });
    }
}
