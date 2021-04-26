package com.sabrina.toolkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
Button calendar,calculator,notepad,qrcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    calendar= findViewById(R.id.caleButton);
    calculator=findViewById(R.id.calcButton);
    notepad=findViewById(R.id.noteButton);
        qrcode=findViewById(R.id.qrButton);
    calendar.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            {
                Intent intent = new Intent(MainActivity.this, CalendarMainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    });

    calculator.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                {
                    Intent intent = new Intent(MainActivity.this, calculatorMainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    notepad.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                {
                    Intent intent = new Intent(MainActivity.this, NoteMainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        qrcode.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                {
                    Intent intent = new Intent(MainActivity.this, QrMainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });    }
}
