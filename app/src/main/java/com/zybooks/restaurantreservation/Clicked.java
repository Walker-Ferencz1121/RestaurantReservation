package com.zybooks.restaurantreservation;

import static android.R.layout.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

        //Back Button addition
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

        
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
                int colorId = intent.getIntExtra(EXTRA_COLOR, R.color.green);

                // Select the radio button matching the color ID
                int radioId = R.id.open;
                if (colorId == R.color.yellow) {
                    radioId = R.id.dirty;
                }
                else if (colorId == R.color.red) {
                    radioId = R.id.closed;
                }
                else if (colorId == R.color.blue) {
                    radioId = R.id.reserved;
                }

                RadioButton radio = findViewById(radioId);
                radio.setChecked(true);
            }

            public void onColorSelected(View view) {
                int colorId = R.color.green;
                if (view.getId() == R.id.dirty) {
                    colorId = R.color.yellow;
                }
                else if (view.getId() == R.id.closed) {
                    colorId = R.color.red;
                }
                else if (view.getId() == R.id.reserved) {
                    colorId = R.color.blue;
                }

                Intent intent = new Intent();
                intent.putExtra(EXTRA_COLOR, colorId);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}