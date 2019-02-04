package com.ss.roomdbsampleapp.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class NotesRepository {

	private NotesDAO notesDAO;

	private LiveData<List<NotesEntity>> allNotes;

	private Database appDatabase;

	public NotesRepository(Context context) {
		appDatabase = Database.getDatabase(context);
		notesDAO = appDatabase.notesDao();
		allNotes = notesDAO.getAllNotes();
	}

	public LiveData<List<NotesEntity>> getAllNotes() {
		return allNotes;
	}


	public void deleteAll() {
		if (notesDAO != null) {
			notesDAO.deleteAll();
		}
	}

	public void insert(NotesEntity notesEntity) {
		new InsertCustAsyncTask(notesDAO).execute(notesEntity);
	}

	private static class InsertCustAsyncTask extends AsyncTask<NotesEntity, Void, Boolean> {

		NotesDAO notesDAO;

		public InsertCustAsyncTask(NotesDAO notesDAO) {
			this.notesDAO = notesDAO;
		}

		@Override
		protected Boolean doInBackground(NotesEntity... notesEntities) {
			try {
				notesDAO.insertNotes(notesEntities[0]);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			//   return null;
		}

		@Override
		protected void onPostExecute(Boolean aBoolean) {
			super.onPostExecute(aBoolean);
		}

	}
}

