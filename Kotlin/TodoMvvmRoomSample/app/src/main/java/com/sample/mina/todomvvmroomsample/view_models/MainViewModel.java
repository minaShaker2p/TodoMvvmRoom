package com.sample.mina.todomvvmroomsample.view_models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sample.mina.todomvvmroomsample.database.NoteEntity;
import com.sample.mina.todomvvmroomsample.repository.AppRepository;

import java.util.List;

/**
 * Created by Mina Alfy on 8/29/2018.
 */

public class MainViewModel extends AndroidViewModel {
    public LiveData<List<NoteEntity>> mNotes;
    private AppRepository appRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        appRepository = AppRepository.getInstance(application.getApplicationContext());
        mNotes = appRepository.mNotes;
    }

    public void addSampleData() {
        appRepository.addSampleData();

    }

    public void deleteAllNotes() {
        appRepository.deleteAllNotes();
    }
}
