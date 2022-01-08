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
import android.widget.Toast;

import java.util.ArrayList;

public class PizzaActivity extends AppCompatActivity {

    private final ArrayList<String> fav_pizza = new ArrayList<>();
    String pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        registerForContextMenu(findViewById(R.id.pizza1));
        registerForContextMenu(findViewById(R.id.pizza2));
        registerForContextMenu(findViewById(R.id.pizza3));
        registerForContextMenu(findViewById(R.id.tvp1));
        registerForContextMenu(findViewById(R.id.tvp2));
        registerForContextMenu(findViewById(R.id.tvp3));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.fav:
                Intent intFav = new Intent();
                intFav.putExtra("fv",fav_pizza);
                intFav.setClass(getApplicationContext(),FavouriteActivity.class);
                intFav.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intFav);
                break;
            case R.id.info:
                Uri uri = Uri.parse("geo:0,0?q= PizzaLab,Варна");
                Intent intent1 = new Intent(Intent.ACTION_VIEW,uri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);
                break;
            case R.id.car:
                Intent intcar = new Intent();
                intcar.setClass(getApplicationContext(),CarActivity.class);
                intcar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intcar);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);

        switch (v.getId()){
            case R.id.pizza1:
                pizza = "Пица Маргарита";
                break;
            case R.id.pizza2:
                pizza = "Пица Прошуто";
                break;
            case R.id.pizza3:
                pizza = "Пица Пеперони";
                break;
            default:
                Toast.makeText(getApplicationContext(),"Не е избрана опция",Toast.LENGTH_SHORT).show();
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.favourite:
                String p = pizza;
                fav_pizza.add(p);
                Toast.makeText(getApplicationContext(),pizza +"e добавен в любими",Toast.LENGTH_LONG).show();
                break;
            case R.id.card:
                Toast.makeText(getApplicationContext(),pizza +"е добавен в количка",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}