package com.example.fastfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void expand_pizza(View view) {
        Intent pizza = new Intent();
        pizza.setClass(getApplicationContext(),PizzaActivity.class);
        pizza.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(pizza);
    }

    public void expand_burger(View view) {
        Intent burger = new Intent();
        burger.setClass(getApplicationContext(),BurgerActivity.class);
        burger.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(burger);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav:
                Intent intFav = new Intent();
                intFav.setClass(getApplicationContext(), FavouriteActivity.class);
                intFav.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intFav);
                break;
            case R.id.info:
                Uri uri = Uri.parse("geo:0,0?q= PizzaLab,Варна");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);
                break;
            case R.id.car:
                Intent intcar = new Intent();
                intcar.setClass(getApplicationContext(), CarActivity.class);
                intcar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intcar);
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}