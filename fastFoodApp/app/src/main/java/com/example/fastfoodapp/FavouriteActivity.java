package com.example.fastfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 *
 */
public class FavouriteActivity extends AppCompatActivity {

    public ArrayList<String> array = new ArrayList<>();
    private ListView lv;

    /**
     *
     * @param saveInstanceState
     */
    public void onCreate(Bundle saveInstanceState) {

        setContentView(R.layout.activity_favourite);

        lv = (ListView) findViewById(R.id.list_view_id);

        Bundle info = getIntent().getExtras();
        array =  info.getStringArrayList("fv");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                array);

        lv.setAdapter(arrayAdapter);
        super.onCreate(saveInstanceState);
    }

    /**
     *
     * @param outstate
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outstate) {
        outstate.putStringArrayList("fv",array);
        super.onSaveInstanceState(outstate);
    }

    /**
     * Restore UI state from the savedInstanceState.
     * This bundle has also been passed to onCreate.
     * @param savedInstanceState
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       String a = savedInstanceState.getString("fv");

    }
}


