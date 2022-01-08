package com.example.fastfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {


    private ListView lv;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_favourite);

        lv = (ListView) findViewById(R.id.list_view_id);


        Bundle info = getIntent().getExtras();
        ArrayList<String> arrayList =  info.getStringArrayList("fv");

        for(String s:arrayList){
            String [] tmp = s.split(";");
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList);

        lv.setAdapter(arrayAdapter);
    }
}


//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Bundle info = getIntent().getExtras();
//        ArrayList<String> asd =  info.getStringArrayList("fv");
//
//        for(String s:asd){
//            String [] tmp = s.split(";");
//            Log.d("asd",tmp[1]);
//        }
//
//        TextView textView = findViewById(R.id.fav);
//        //textView.setText(info);
//
//        setContentView(R.layout.activity_favourite);
//    }


