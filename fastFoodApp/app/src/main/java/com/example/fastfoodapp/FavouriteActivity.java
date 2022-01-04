package com.example.fastfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle info = getIntent().getBundleExtra("pizza");
        TextView textView = findViewById(R.id.favtv);
        //textView.setText(info);

        setContentView(R.layout.activity_favourite);
    }
}