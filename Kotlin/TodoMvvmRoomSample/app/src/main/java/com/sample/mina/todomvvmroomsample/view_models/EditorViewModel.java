package com.sample.mina.todomvvmroomsample.view_models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.sample.mina.todomvvmroomsample.database.NoteEntity;
import com.sample.mina.todomvvmroomsample.repository.AppRepository;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Mina Alfy on 8/29/2018.
 */

public class EditorViewModel extends AndroidViewModel {
    public MutableLiveData<NoteEntity> mLiveNote = new MutableLiveData<>();
    private AppRepository mAppRepository;
    Executor executor = Executors.newSingleThreadExecutor();

    public EditorViewModel(@NonNull Application application) {
        super(application);
        mAppRepository = AppRepository.getInstance(this.getApplication());
    }

    public void loadNoteById(final int noteId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                NoteEntity noteEntity = mAppRepository.getNoteById(noteId);
                mLiveNote.postValue(noteEntity);
            }
        });
    }

    public void saveNote(@NotNull String noteText) {
        NoteEntity noteEntity = mLiveNote.getValue();
        if (noteEntity == null) {
            if(TextUtils.isEmpty(noteText))
            {
                return;
            }
            noteEntity=new NoteEntity(new Date(),noteText);

        } else {
            noteEntity.setText(noteText);
        }
        mAppRepository.insertNote(noteEntity);

    }

    public void deleteNote() {
        mAppRepository.deleteNote(mLiveNote.getValue());
    }
}
