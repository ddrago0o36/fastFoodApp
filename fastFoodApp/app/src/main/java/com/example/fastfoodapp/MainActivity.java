package com.example.fastfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fastfoodapp.R;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view) {
        Intent i = new Intent();
        i.setClass(getApplicationContext(), MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(i);
    }
    public void Register(View view){
        Intent i = new Intent();
        i.setClass(getApplicationContext(), com.example.fastfoodapp.RegisterActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(i);
    }
}