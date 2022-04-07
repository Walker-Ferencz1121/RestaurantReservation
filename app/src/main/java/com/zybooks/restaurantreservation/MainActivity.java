package com.zybooks.restaurantreservation;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int mLightOnColorId;
    private int mLightonColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLightOnColorId = R.color.open;
        mLightonColor = ContextCompat.getColor(this, R.color.open);

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, Clicked.class);
        startActivity(intent);
    }

    public void onChangeColorClick(View view) {
        Intent intent = new Intent(this, Clicked.class);
        intent.putExtra(Clicked.EXTRA_COLOR, mLightOnColorId);
        mColorResultLauncher.launch(intent);
    }
    ActivityResultLauncher<Intent> mColorResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()== Activity.RESULT_OK){
                        Intent data = result.getData();
                        if (data != null){
                            mLightOnColorId = data.getIntExtra(Clicked.EXTRA_COLOR,R.color.open);
                            mLightonColor = ContextCompat.getColor(MainActivity.this, mLightOnColorId);
                            setButtonColors();
                        }
                    }

                }
            });
    private void setButtonColors(){

    }
}