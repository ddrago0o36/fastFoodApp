package com.example.fastfoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    // creating variables for our edittext, button and db_handler
    private EditText userName, email, password, repPassword;
    private Button registerBTN;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // initializing all our variables.
        userName = findViewById(R.id.idEdtUsername);
        email = findViewById(R.id.idEdtEmail);
        password = findViewById(R.id.idEdtPassword);
        repPassword = findViewById(R.id.idEdtRepPassword);
        registerBTN = findViewById(R.id.idBtnAddUser);

        // creating a new db_handler class
        // and passing our context to it.
        dbHandler = new DBHandler(RegisterActivity.this);

        // below line is to add on click listener for our add course button.
        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String nameUser = userName.getText().toString();
                String emailUser = email.getText().toString();
                String passwordUser = password.getText().toString();
                String repPasswordUser = repPassword.getText().toString();

                // validating if the text fields are empty or not.
                if (nameUser.length() == 0 || emailUser.length() == 0 || passwordUser.length() == 0 || repPasswordUser.length() == 0 || !passwordUser.equals(repPasswordUser)) {
                    Toast.makeText(RegisterActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(nameUser, passwordUser, repPasswordUser, emailUser);

                // after adding the data we are displaying a toast message.
                Toast.makeText(RegisterActivity.this, "Register successfully", Toast.LENGTH_SHORT).show();
                userName.setText("");
                password.setText("");
                email.setText("");
                repPassword.setText("");

                //back to welcome page
                Intent i = new Intent();
                i.setClass(getApplicationContext(), LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }
        });


    }


}