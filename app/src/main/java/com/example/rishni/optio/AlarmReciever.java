package com.example.rishni.optio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Devni on 7/10/2018.
 */

public class AlarmReciever extends BroadcastReceiver {
    private static final String TAG = AlarmReciever.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        if(intent.hasExtra("key")){
            Log.d(TAG, "hasExtra");
        }
        Toast.makeText(context, "Alarm, Alarm, Alarm!", Toast.LENGTH_LONG).show(); // For example
    }
}
