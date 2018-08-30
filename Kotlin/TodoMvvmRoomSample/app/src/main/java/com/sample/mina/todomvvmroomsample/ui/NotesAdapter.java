package com.sample.mina.todomvvmroomsample.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.mina.todomvvmroomsample.EditorActivity;
import com.sample.mina.todomvvmroomsample.R;
import com.sample.mina.todomvvmroomsample.database.NoteEntity;
import com.sample.mina.todomvvmroomsample.utilities.Constants;

import java.util.List;

/**
 * Created by Mina Alfy on 8/16/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private final List<NoteEntity> mNotes;
    private final Context mContext;

    public NotesAdapter(List<NoteEntity> mNotes, Context mContext) {
        this.mNotes = mNotes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_todo_list, viewGroup, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int i) {
        final NoteEntity noteEntity = mNotes.get(noteViewHolder.getAdapterPosition());
        noteViewHolder.tvNoteText.setText(noteEntity.getText());
        noteViewHolder.mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, EditorActivity.class);
                intent.putExtra(Constants.NOTE_ID_EXTRA,noteEntity.getId());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvNoteText;
        FloatingActionButton  mFab;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNoteText = itemView.findViewById(R.id.note_text);
            mFab=itemView.findViewById(R.id.item_fab);
        }
    }
}
