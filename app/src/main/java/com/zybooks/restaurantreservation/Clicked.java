package com.zybooks.restaurantreservation;

import static android.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.view.ViewGroup;
import android.view.View;

public class Clicked extends AppCompatActivity {

    private final static int HOURS = 12;

    private EditText mNumAttendEditText;
    private EditText nameEditText;
    private RadioGroup tableStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);

        mNumAttendEditText = findViewById(R.id.answer1);
        tableStatus = findViewById(R.id.status);
        nameEditText = findViewById(R.id.answer3);



        ;}

        
    public void onClick(View view){
        int numAttend;

        try {
            String numAttendStr = mNumAttendEditText.getText().toString();
            numAttend = Integer.parseInt(numAttendStr);
        }
        catch (NumberFormatException ex) {
            numAttend = 0;
        }



    }
}