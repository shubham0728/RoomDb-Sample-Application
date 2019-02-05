package com.ss.roomdbsampleapp.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ss.roomdbsampleapp.R;
import com.ss.roomdbsampleapp.model.NotesEntity;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

	private Activity mAct;
	private List<NotesEntity> mNotes;

	/**
	 * Constructor.
	 *
	 * @param _act
	 * @param notes
	 */
	public NotesAdapter(Activity _act, List<NotesEntity> notes) {
		super();
		this.mAct = _act;
		this.mNotes = notes;

	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_adapter, null);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		NotesEntity notes = mNotes.get(position);
		holder.mTV_Name.setText(notes.getName());
		holder.mTV_Number.setText(notes.getPhone_number());
		holder.mTV_Email.setText(notes.getEmail());
	}

	@Override
	public int getItemCount() {
		return mNotes.size();
	}


	public class ViewHolder extends RecyclerView.ViewHolder {
		private TextView mTV_Name;
		private TextView mTV_Number;
		private TextView mTV_Email;

		public ViewHolder(View itemView) {
			super(itemView);

			mTV_Name = itemView.findViewById(R.id.txt_name);
			mTV_Number = itemView.findViewById(R.id.txt_number);
			mTV_Email = itemView.findViewById(R.id.txt_email);

		}
	}

}
