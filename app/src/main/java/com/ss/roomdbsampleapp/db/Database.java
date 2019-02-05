package com.ss.roomdbsampleapp.db;


import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ss.roomdbsampleapp.dao.NotesDAO;
import com.ss.roomdbsampleapp.model.NotesEntity;


@android.arch.persistence.room.Database(entities = {NotesEntity.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

	public abstract NotesDAO notesDao();

	private static Database INSTANCE;

	public static final String DATABASE_NAME = "database";

	public static Database getDatabase(final Context context) {
		if (INSTANCE == null) {
			synchronized (Database.class) {
				if (INSTANCE == null) {
					INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
							Database.class, DATABASE_NAME)
							// Wipes and rebuilds instead of migrating if no Migration object.
							// Migration is not part of this codelab.
							.fallbackToDestructiveMigration()
							//allows queries to execute on main thread
							.allowMainThreadQueries()
							//.addCallback(sRoomDatabaseCallback)
							.build();

				}
			}
		}
		return INSTANCE;
	}
}
