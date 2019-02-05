package com.ss.roomdbsampleapp.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ss.roomdbsampleapp.model.NotesEntity;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface NotesDAO {

	@Insert(onConflict = REPLACE)
	void insertNotes(NotesEntity notesEntity);

	@Query("Select * from  Notes")
	LiveData<List<NotesEntity>> getAllNotes();

	@Query("Delete from NOTES")
	void deleteAll();
}
