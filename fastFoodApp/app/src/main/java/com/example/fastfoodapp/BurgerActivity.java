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

/**
 *
 */
public class BurgerActivity extends AppCompatActivity {

    private final ArrayList<String> fav_burger = new ArrayList<>();
    String burger;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        registerForContextMenu(findViewById(R.id.burger1));
        registerForContextMenu(findViewById(R.id.burger2));
        registerForContextMenu(findViewById(R.id.burger3));
        registerForContextMenu(findViewById(R.id.tvp1));
        registerForContextMenu(findViewById(R.id.tvp2));
        registerForContextMenu(findViewById(R.id.tvp3));

    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav:
                Intent intFav = new Intent();
                intFav.putExtra("fv", fav_burger);
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

    /**
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);

        switch (v.getId()) {
            case R.id.burger1:
                burger = "Телешки бургер";
                break;
            case R.id.burger2:
                burger = "Чийз-бургер";
                break;
            case R.id.burger3:
                burger = "Пилешки бургер";
                break;
            default:
                Toast.makeText(getApplicationContext(), "Не е избрана опция", Toast.LENGTH_SHORT).show();

                super.onCreateContextMenu(menu, v, menuInfo);
        }
    }

    /**
     *
     * @param item
     * @return
     */
        @Override
        public boolean onContextItemSelected (@NonNull MenuItem item){
            switch (item.getItemId()) {
                case R.id.favourite:
                    String p = burger;
                    fav_burger.add(p);
                    Toast.makeText(getApplicationContext(), burger + " e добавен в любими", Toast.LENGTH_LONG).show();
                    break;
                case R.id.card:
                    Toast.makeText(getApplicationContext(), burger + " е добавен в количка", Toast.LENGTH_LONG).show();
                    break;
            }
            return true;
        }
    }
