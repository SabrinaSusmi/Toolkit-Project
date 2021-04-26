package com.sabrina.toolkit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarMainActivity extends AppCompatActivity {
    private TextView textView;
    private DatePicker datePicker;
    private Button selectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_main);
        textView =  findViewById(R.id.textViewId);
        selectButton = findViewById(R.id.buttonId);
        datePicker = findViewById(R.id.DatePickerId);
        textView.setText(currentDate());
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(currentDate());
            }
        });
    }
    String currentDate(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current Date : ");
        stringBuilder.append(datePicker.getDayOfMonth()+"/");
        stringBuilder.append((datePicker.getMonth()+1)+"/");
        stringBuilder.append(datePicker.getYear());
        return stringBuilder.toString();

    }
}
