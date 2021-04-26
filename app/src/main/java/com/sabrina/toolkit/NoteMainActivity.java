package com.sabrina.toolkit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import java.util.HashSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class NoteMainActivity extends AppCompatActivity {

    Calendar calander;
    SimpleDateFormat simpledateformat;
    String Date;

    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_main);
        calander = Calendar.getInstance();
        simpledateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date = simpledateformat.format(calander.getTime());

        ListView listView = findViewById(R.id.listing);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.sabrina.toolkit", MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);

        if(set == null){
            notes.add("Welcome to Notes!!!");
            notes.add(Date);
        }else {
            notes = new ArrayList(set);
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        //arrayAdapter = new ArrayAdapter(this, android.R.layout.list_content, );

        listView.setAdapter(arrayAdapter);


        //adds note
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), NoteEditorMainActivity.class);
                intent.putExtra("noteId", i); // the first variable.
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;

                new AlertDialog.Builder(NoteMainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                notes.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();

                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.sabrina.toolkit", MODE_PRIVATE);

                                HashSet<String> set = new HashSet(NoteMainActivity.notes);

                                sharedPreferences.edit().putStringSet("notes", set).apply();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();


                return true;
            }
        });


    }

    //button function.
    public void clickFunction(View view) {

        Intent intent = new Intent(getApplicationContext(), NoteEditorMainActivity.class);

        startActivity(intent);

    }


}

