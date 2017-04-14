package com.example.chandler.hack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by adampaquette on 3/15/17.
 */

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5;
    public static final String BUTTON = "com.example.chandler.hack.Button";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.wine_button);
        b2 = (Button)findViewById(R.id.beer_button);
        b3 = (Button)findViewById(R.id.mixed_button);
        b4 = (Button)findViewById(R.id.all_button);
        b5 = (Button)findViewById(R.id.about_button);

        createDrinkFile();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra(BUTTON, b1.getId());
                startActivity(intent);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    public void createDrinkFile() {
        JSONObject obj = new JSONObject();

        JSONArray list = new JSONArray();
        try {
            obj.put("Wine", list);
            obj.put("Beer", list);
            obj.put("Mixed", list);
        }
        catch (org.json.JSONException e) {
            Log.d("JSON ERROR", e.getMessage());
        }

        try {
            FileWriter file = new FileWriter(getFilesDir().getPath() + "drinkList.json");

            file.write(obj.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("Drink JSON", obj.toString());
    }
}
