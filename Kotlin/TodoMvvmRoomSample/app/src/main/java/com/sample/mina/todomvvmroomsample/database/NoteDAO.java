package com.sample.mina.todomvvmroomsample.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Mina Alfy on 8/27/2018.
 */
@Dao
public interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertNotesList(List<NoteEntity> notes);

    @Delete
    void deleteNote(NoteEntity noteEntity);

    @Query("Delete  from notes")
    int deleteALlNotes();

    @Query("Select * from notes where id=:id")
    NoteEntity getNoteById(int id);

    @Query("Select * from notes Order by  date DESC")
    LiveData<List<NoteEntity>> getAllNotes();

    @Query("Select COUNT(*) from notes")
    int getNotesCount();
}
