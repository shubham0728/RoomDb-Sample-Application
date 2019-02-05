package com.ss.roomdbsampleapp.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.ss.roomdbsampleapp.repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

	private LiveData<List<NotesEntity>> allNotes;

	private NotesRepository notesRepository;

	public NotesViewModel(@NonNull Application application) {
		super(application);
		notesRepository = new NotesRepository(application);
		allNotes = notesRepository.getAllNotes();
	}

	/**
	 * Returns list of all notes added.
	 * LiveData helps in notifying active observers about updates.
	 *
	 * @return allNotes
	 */
	public LiveData<List<NotesEntity>> getAllNotes() {
		return allNotes;
	}


	public void insertNotes(NotesEntity notesEntity) {
		notesRepository.insert(notesEntity);
	}

	public void deleteAll() {
		notesRepository.deleteAll();
	}


}
