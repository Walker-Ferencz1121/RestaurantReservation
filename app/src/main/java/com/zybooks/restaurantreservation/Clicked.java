package com.zybooks.restaurantreservation;

import static android.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.view.ViewGroup;
import android.view.View;

public class Clicked extends AppCompatActivity {

    public static final String EXTRA_COLOR = "com.zybooks.lightsout.color";

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


        class ColorActivity extends AppCompatActivity {


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_clicked);
                // Get the color ID from MainActivity
                Intent intent = getIntent();
                int colorId = intent.getIntExtra(EXTRA_COLOR, R.color.open);

                // Select the radio button matching the color ID
                int radioId = R.id.open;
                if (colorId == R.color.dirty) {
                    radioId = R.id.dirty;
                }
                else if (colorId == R.color.closed) {
                    radioId = R.id.closed;
                }
                else if (colorId == R.color.reserved) {
                    radioId = R.id.reserved;
                }

                RadioButton radio = findViewById(radioId);
                radio.setChecked(true);
            }

            public void onColorSelected(View view) {
                int colorId = R.color.open;
                if (view.getId() == R.id.dirty) {
                    colorId = R.color.dirty;
                }
                else if (view.getId() == R.id.closed) {
                    colorId = R.color.closed;
                }
                else if (view.getId() == R.id.reserved) {
                    colorId = R.color.reserved;
                }

                Intent intent = new Intent();
                intent.putExtra(EXTRA_COLOR, colorId);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}