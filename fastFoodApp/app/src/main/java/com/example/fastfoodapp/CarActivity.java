package com.example.fastfoodapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class CarActivity extends AppCompatActivity {
    public ArrayList<String> array = new ArrayList<>();
    private ListView lv;
    final static String arraylistkey = "burger";
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.activity_car);


//        Intent intent = new Intent(this,OnHandleWork.class);
//        intent.putExtra("count",20);
//        OnHandleWork.enqueueWork(this, intent);
        lv =findViewById(R.id.lv);
        Bundle info = getIntent().getExtras();
        array =  info.getStringArrayList("brg");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                array);

        lv.setAdapter(arrayAdapter);
//        if (savedInstanceState != null) {
//            // Restore value of members from saved state
//            array =  savedInstanceState.getStringArrayList(arraylistkey);
//        }

        SharedPreferences preferences = getSharedPreferences("appfs", MODE_PRIVATE);
        SharedPreferences.Editor prefs_edit = preferences.edit();

        for (String element : array) {
            byte[] s = element.getBytes(StandardCharsets.UTF_8);
            String ss = Arrays.toString(s);
        }



        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ntf(View view){

        Intent intent=new Intent(getApplicationContext(),OrderAcitvity.class);
        String CHANNEL_ID="DD";
        NotificationChannel notificationChannel= new NotificationChannel(CHANNEL_ID,"name",NotificationManager.IMPORTANCE_LOW);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        Notification notification=new Notification.Builder(getApplicationContext(),CHANNEL_ID)
                .setContentText("Благодарим, че избрахте MANDJA fast food. Поръчката Ви се приготвя")
                .setContentTitle("MANDJA")
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.sym_action_chat,"Order",pendingIntent)
                .setChannelId(CHANNEL_ID)
                .setSmallIcon(android.R.drawable.sym_action_chat)
                .build();

        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        notificationManager.notify(1,notification);
    }




    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArrayList(arraylistkey,array);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        array =  savedInstanceState.getStringArrayList(arraylistkey);
        super.onRestoreInstanceState(savedInstanceState);
    }
}