package com.example.fastfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_login);
    }

    public void Login_To_main(View view) {
        //check if user exists
        //if true then run the intent

        DBHandler handler = new DBHandler(LoginActivity.this);
        EditText obj_name = findViewById(R.id.idEdtUsername);
        String name =  obj_name.getText().toString();

        EditText obj_pass = findViewById(R.id.idEdtPassword);
        String password = obj_pass.getText().toString();

        if (handler.checkusers(name, password)) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(i);
        }
        else {
            Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }

    }
    public void Register(View view){
        Intent i = new Intent();
        i.setClass(getApplicationContext(), com.example.fastfoodapp.RegisterActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(i);
    }
}