package com.zybooks.restaurantreservation;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int tableColorId;
    private int tableColor;
    private Button ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableColorId = R.color.green;
        tableColor = ContextCompat.getColor(this, R.color.green);

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

    public void onClick(View view) {
        ID = (Button)findViewById(view.getId());
        Intent intent = new Intent(this, Clicked.class);
        intent.putExtra(Clicked.EXTRA_COLOR, tableColorId);
        tableColorResultLauncher.launch(intent);
    }
    ActivityResultLauncher<Intent> tableColorResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()== Activity.RESULT_OK){
                        Intent data = result.getData();
                        if (data != null){
                            tableColorId = data.getIntExtra(Clicked.EXTRA_COLOR,R.color.green);
                            tableColor = ContextCompat.getColor(MainActivity.this, tableColorId);
                            setButtonColors();
                        }
                    }
                }
            });
    private void setButtonColors(){
        ID.setBackgroundColor(tableColor);
    }

    public void onHelpClick(View view) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

}