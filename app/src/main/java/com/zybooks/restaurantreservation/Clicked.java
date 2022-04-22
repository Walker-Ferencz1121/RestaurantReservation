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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        int colorId = intent.getIntExtra(EXTRA_COLOR, R.color.green);

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



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
