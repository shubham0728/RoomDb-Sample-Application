package com.ss.roomdbsampleapp.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ss.roomdbsampleapp.R;
import com.ss.roomdbsampleapp.model.NotesEntity;
import com.ss.roomdbsampleapp.model.NotesViewModel;

/**
 * Data insertion activity
 */
public class AddNotesActivity extends AppCompatActivity {

	private EditText mET_Name;
	private EditText mET_Number;
	private EditText mET_Email;
	private TextView mTV_Done;
	private ImageView mIV_Cross;

	private NotesViewModel model;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_note);
		model = ViewModelProviders.of(this).get(NotesViewModel.class);
		init();

		mIV_Cross.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		mTV_Done.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				validateData();
			}
		});
	}

	/**
	 * Initialise all widgets.
	 */
	private void init() {
		mET_Name = findViewById(R.id.et_name);
		mET_Email = findViewById(R.id.et_mobile);
		mET_Number = findViewById(R.id.et_email);

		mTV_Done = findViewById(R.id.btn_done);
		mIV_Cross = findViewById(R.id.btn_close);
	}

	/**
	 * Validate data entered.
	 * Insert in local db.
	 */
	private void validateData() {
		String name = mET_Name.getText().toString().trim();
		String number = mET_Number.getText().toString().trim();
		String email = mET_Email.getText().toString().trim();

		if (name.length() == 0)
			mET_Name.setError("Name cannot be empty.");
		else if (number.length() == 0)
			mET_Number.setError("Number cannot be empty.");
		else if (email.length() == 0)
			mET_Email.setError("Email canot be empty.");
		else {
			NotesEntity notes = new NotesEntity();
			notes.setName(name);
			notes.setEmail(email);
			notes.setPhone_number(number);
			model.insertNotes(notes);
			moveToMainActivity();
		}
	}


	private void moveToMainActivity() {
		finish();
	}
}
