package com.example.fastfoodapp;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

/**
 *
 */
public class OnHandleWork extends JobIntentService {

    /**
     *
     */
    public OnHandleWork() {
        super();
    }

    /**
     *
     * @param context
     * @param intent
     */
    public static void enqueueWork(Context context, Intent intent){

        enqueueWork(context,OnHandleWork.class,3, intent);
    }

    /**
     *
     * @param intent
     */
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        int count = intent.getIntExtra("count",10);

        for(int i=0; i<count; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
