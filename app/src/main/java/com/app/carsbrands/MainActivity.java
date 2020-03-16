package com.app.carsbrands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] carNames = {  "Mercedes-Benz","Ferrari","Audi","Lamborghini","Ford",
                             " Volkswagen","BMW","Jeep","Honda","Chevrolet"};
    int[] carLogo = {R.drawable.merlo,R.drawable.felo,R.drawable.audilo,R.drawable.lalo,R.drawable.fordlo,
                         R.drawable.volo,R.drawable.bmlo,R.drawable.jeeplo,R.drawable.holo,R.drawable.chevlo};

    int[] carImages = {R.drawable.mercedes,R.drawable.ferrari,R.drawable.audi,R.drawable.lamp,R.drawable.ford,
            R.drawable.volk,R.drawable.bm,R.drawable.jeep,R.drawable.honda,R.drawable.chev};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //////////////////////////////////






//////////////////////////////////////////////////////////////////////////////////////
        //finding listview
        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(getApplicationContext(),carNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),activity_listdata.class);
                intent.putExtra("name",carNames[i]);
                intent.putExtra("image",carImages[i]);
                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return carImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        /////////////////////////////////


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            //getting view in row_data
            TextView name = view1.findViewById(R.id.carsname);
            ImageView image = view1.findViewById(R.id.carlogo);

            name.setText(carNames[i]);
            image.setImageResource(carLogo[i]);
            return view1;
        }
    }
    /////////////////////////////////////////////////////////////////////






}
