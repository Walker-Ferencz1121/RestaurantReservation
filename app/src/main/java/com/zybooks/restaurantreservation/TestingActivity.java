package com.zybooks.restaurantreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestingActivity extends AppCompatActivity {


    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        start = (Button) findViewById(R.id.continue_button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestingActivity.this, MainActivity.class));
            }
        });
    }

    public void onHelpClick(View view) {
        Intent intent = new Intent(this, TestingActivity.class);
        startActivity(intent);
    }




    public void onClick(View view){
        int numAttend;
        final int[] tableCount = {0};
        String pre = "TableB";
        String Mixed = pre + tableCount;

        Button MixedB = (Button) findViewById(R.id.TableB1);

        Button Remove = (Button) findViewById(R.id.RemoveButton);
        Button Add = (Button) findViewById(R.id.AddButton);


        Add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //showing element

                tableCount[0] += 1;

                MixedB.setVisibility(View.VISIBLE);

            }
        });

        Remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //hidding element

                tableCount[0] -= 1;
                MixedB.setVisibility(View.INVISIBLE);

            }
        });



    }





}