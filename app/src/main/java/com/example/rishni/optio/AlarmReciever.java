package com.example.rishni.optio;

import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataSourcesResult;

import java.util.concurrent.TimeUnit;

/**
 * Created by Devni on 7/10/2018.
 */

public class AlarmReciever extends BroadcastReceiver {
    private GoogleApiClient mApiClient;
    private static final String TAG = AlarmReciever.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        if(intent.hasExtra("key")){
            Log.d(TAG, "hasExtra");

        }
        if(intent.hasExtra("Time")){
            Log.d(TAG,intent.getStringExtra("Time"));
        }
        if(intent.hasExtra("Steps")){
            Long tot= intent.getLongExtra("Steps",0);
            String t= String.valueOf(tot);
            Log.d(TAG,t);
        }
        Toast.makeText(context, "Alarm, Alarm, Alarm!", Toast.LENGTH_LONG).show(); // For example
        //Intent intent1 = new Intent(context, StepService.class);
        //ExerciseSteps exerciseSteps = new ExerciseSteps();

        //context.startService(intent1);
        ComponentName componentName = new ComponentName(context,StepService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, componentName)
                .setMinimumLatency(6000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
                //.setPersisted(true);
        JobScheduler jobScheduler =  (JobScheduler)context.getSystemService( Context.JOB_SCHEDULER_SERVICE );
        jobScheduler.schedule(builder.build());

    }


}
