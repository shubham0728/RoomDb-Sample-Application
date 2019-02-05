package com.ss.roomdbsampleapp.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ss.roomdbsampleapp.R;
import com.ss.roomdbsampleapp.adapter.NotesAdapter;
import com.ss.roomdbsampleapp.model.NotesEntity;
import com.ss.roomdbsampleapp.model.NotesViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * This activity displays list of notes added.
 */
public class MainActivity extends AppCompatActivity {

	private RecyclerView notesList;
	private Toolbar toolbar;
	private FloatingActionButton fab;
	private NotesViewModel model;
	private List<NotesEntity> notes = new ArrayList<>();
	private NotesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		model = ViewModelProviders.of(this).get(NotesViewModel.class);
		init();

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent in = new Intent(MainActivity.this, AddNotesActivity.class);
				startActivity(in);
			}
		});
	}

	/**
	 * Initialise all widgets.
	 * Observable user to listen any new insertions made.
	 */
	private void init() {
		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		fab = findViewById(R.id.fab);
		notesList = findViewById(R.id.note_list);
		notesList.setHasFixedSize(true);
		notesList.setLayoutManager(new LinearLayoutManager(this));

		model.getAllNotes().observe(this, new Observer<List<NotesEntity>>() {
			@Override
			public void onChanged(@Nullable List<NotesEntity> notesEntities) {
				notes.clear();
				notes.addAll(notesEntities);
				adapter = new NotesAdapter(MainActivity.this, notes);
				notesList.setAdapter(adapter);
				adapter.notifyDataSetChanged();
			}
		});
	}

}
