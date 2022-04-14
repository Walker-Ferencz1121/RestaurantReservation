package com.zybooks.restaurantreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingActivity extends AppCompatActivity {

    //create buttons
    Button floor1;
    Button floor2;
    Button patio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        //initializes buttons with restaurant layout activities
        floor1 = (Button) findViewById(R.id.f1);
        floor2 = (Button) findViewById(R.id.f2);
        patio = (Button) findViewById(R.id.p1);

        //makes floor 1 button go to MainActivity
        floor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivity.this, MainActivity.class));
            }
        });

        //makes floor2Activity button go to floor2Activity activity
        floor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivity.this, floor2Activity.class));
            }
        });

        //makes patioActivity button go to patio activity
        patio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartingActivity.this, patioActivity.class));
            }
        });

        }



    public void onHelpClick(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}