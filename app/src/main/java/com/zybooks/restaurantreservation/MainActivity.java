package com.zybooks.restaurantreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button table1;
    static int customer_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize table1 button
        table1 = (Button) findViewById(R.id.button1);

        table1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Initializing the popup menu and giving the reference as current context
                PopupMenu pm = new PopupMenu(MainActivity.this, table1);

                // Inflating popup menu from table_menu.xml
                pm.getMenuInflater().inflate(R.menu.table_menu, pm.getMenu());
                table1.setBackgroundColor(getResources().getColor(R.color.red));
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {


                        // Toast message on menu item clicked
                        Toast.makeText(MainActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                        return true;

                    }

                });


                // Showing the popup menu
                pm.show();
            }
        });

    }
}
