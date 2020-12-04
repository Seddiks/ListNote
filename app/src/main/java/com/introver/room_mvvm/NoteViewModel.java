package com.introver.room_mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    private LiveData<List<Note>> getAllNotes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        getAllNotes = noteRepository.getAllNotes();
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }
    public void update(Note note){
        noteRepository.update(note);
    }
    public void delete(Note note){
        noteRepository.delete(note);
    }
    public void deleteAllNotes(){
        noteRepository.deleteAllNotes();
    }
    public LiveData<List<Note>> getAllNotes(){
        return getAllNotes;
    }

    public static class MyViewModelFactory implements ViewModelProvider.Factory {
        private Application mApplication;


        public MyViewModelFactory(Application application) {
            mApplication = application;

        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new NoteViewModel(mApplication);
        }
    }
}
