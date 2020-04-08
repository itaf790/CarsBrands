package com.app.carsbrands;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.StringTokenizer;

public class activity_listdata extends AppCompatActivity {
    TextView listdata;
    ImageView imageView;
    int counter=0;
    int position=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);

        final String result[] = getResources().getStringArray(R.array.car_array);


        Button previous = (Button) findViewById(R.id.previous);
        Button next = (Button) findViewById(R.id.next);

        next.setTag(position);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listdata.setText(result[counter]);
                if (counter<result.length-1){
                    counter++;
                }
                else {counter =0;}
            }});
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listdata.setText(result[counter]);
                if (counter<result.length-1){
                    counter--;
                }
                else {counter=0;}


            }
        });

        listdata = findViewById(R.id.listdata);
        imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
        listdata.setText(receivedName);
        imageView.setImageResource(receivedImage);


        try {
            String name = "",year = "",color = "",milage = "",price = "";
            JSONObject objName = null;
            StringTokenizer st = new StringTokenizer("");
            for (int position=0; position<result.length; position++) {
                JSONObject json = (JSONObject) new JSONTokener(result[position]).nextValue();
                name = (String) json.getString("name");
                year = json.get("year").toString();
                color = (String) json.getString("color");
                milage = json.get("milage").toString();
                price = json.get("price").toString();

                TextView tv = (TextView) findViewById(R.id.listdata);
                tv.setText("name :" + "   " + name + "\n"
                        + "year :" + "    " + year + "\n"
                        + "color :" + "     " + color + "\n"
                        + "milage :" + "     " + milage + "\n"
                        + "price :" + "     " + price);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //enable back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //getting back to listview
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}