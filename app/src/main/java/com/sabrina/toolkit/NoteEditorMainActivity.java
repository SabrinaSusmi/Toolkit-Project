package com.sabrina.toolkit;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;

public class NoteEditorMainActivity extends AppCompatActivity {

    Calendar calander;
    SimpleDateFormat simpledateformat;
    String Date;

    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor_main);
        calander = Calendar.getInstance();
        simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date = simpledateformat.format(calander.getTime());

        EditText editText = findViewById(R.id.noteEditor);
        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if(noteId != -1){

            editText.setText(NoteMainActivity.notes.get(noteId));
            textView.setText(Date);
        }else {

            NoteMainActivity.notes.add("");
            textView.setText(Date);
            noteId = NoteMainActivity.notes.size()-1;
            NoteMainActivity.arrayAdapter.notifyDataSetChanged();

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                NoteMainActivity.notes.set(noteId,String.valueOf(charSequence));
                NoteMainActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.sabrina.toolkit", MODE_PRIVATE);

                HashSet<String> set = new HashSet(NoteMainActivity.notes);

                sharedPreferences.edit().putStringSet("notes", set).apply();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}