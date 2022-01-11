package com.example.fastfoodapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class CarActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);


        Intent intent = new Intent(this,OnHandleWork.class);
        intent.putExtra("count",20);
        OnHandleWork.enqueueWork(this, intent);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ntf(View view){

        Intent intent=new Intent(getApplicationContext(),FavouriteActivity.class);
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


//    /**
//     *
//     * @param view
//     */
//    public void btn (View view){
//        Intent intent1 = new Intent(this, OnHandleWork.class);
//        OnHandleWork work = new OnHandleWork();
//        work.onHandleWork(intent1);
//    }
}