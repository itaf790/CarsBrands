package com.app.carsbrands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.StringTokenizer;

public class activity_listdata extends AppCompatActivity {
    TextView listdata;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);


        Integer pics[] = {R.drawable.mercedes,R.drawable.ferrari,R.drawable.audi,R.drawable.lamp,R.drawable.ford,
                R.drawable.volk,R.drawable.bm,R.drawable.jeep,R.drawable.honda,R.drawable.chev};
        String result[] = getResources().getStringArray(R.array.car_array);
        try {
            String name = "",year = "",color = "",milage = "",price = "";
            JSONObject objName = null;
            StringTokenizer st = new StringTokenizer("");
            for (int i=0; i<result.length; i++) {
                JSONObject json = (JSONObject) new JSONTokener(result[i]).nextValue();
                name = (String) json.getString("name");
                year = json.get("year").toString();
                color = (String) json.getString("color");
                milage = json.get("milage").toString();
                price = json.get("price").toString();
            }

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(pics[0]);
                TextView tv = (TextView) findViewById(R.id.listdata);
                tv.setText("car name :" + "   " + name + "\n"
                        + "year :" + "    " + year + "\n"
                        + "color :" + "     " + color + "\n"
                        + "milage :" + "     " + milage + "\n"
                        + "price :" + "     " + price);

        } catch (JSONException e) {
            e.printStackTrace();
        }
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