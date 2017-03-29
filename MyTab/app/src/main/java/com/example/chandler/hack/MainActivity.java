package com.example.chandler.hack;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by adampaquette on 3/15/17.
 */

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.wine_button);
        b2 = (Button)findViewById(R.id.beer_button);
        b3 = (Button)findViewById(R.id.mixed_button);
        b4 = (Button)findViewById(R.id.all_button);
        b5 = (Button)findViewById(R.id.about_button);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
