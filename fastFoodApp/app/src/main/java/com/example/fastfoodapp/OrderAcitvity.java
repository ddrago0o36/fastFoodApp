package com.example.fastfoodapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class OrderAcitvity extends AppCompatActivity {

    private static final String FORMAT = "%02d:%02d:%02d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_acitvity);

        /**
         * Create a new countDownTimer
         *
         */
        TextView text1=(TextView)findViewById(R.id.textView1);

        new CountDownTimer(0000020000, 1000) { // adjust the milli seconds here

            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            public void onTick(long millisUntilFinished) {

                text1.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onFinish() {
                Toast.makeText(OrderAcitvity.this, "Поръчката Ви е готова!", Toast.LENGTH_SHORT).show();

                String CHANNEL_ID="DD";
                NotificationChannel notificationChannel= new NotificationChannel(CHANNEL_ID,"name",NotificationManager.IMPORTANCE_LOW);
                Notification notification=new Notification.Builder(getApplicationContext(),CHANNEL_ID)
                        .setContentText("Поръчката Ви пътува към вас! ")
                        .setContentTitle("MANDJA fast-food")
                        .setChannelId(CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.sym_action_chat)
                        .build();

                NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.notify(1,notification);


                //text1.setText("Поръчката Ви е готова!");
            }
        }.start();
    }
}