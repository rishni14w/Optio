package com.example.rishni.optio;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.result.DailyTotalResult;

import java.util.concurrent.TimeUnit;

/**
 * Created by Devni on 7/23/2018.
 */

public class StepService extends Service {
    GoogleApiClient mApiClient;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Log.d("ExerciseService","Service Started");
        mApiClient= MyGoogleApiClient_Singleton.getInstance(null).get_GoogleApiClient();
        getSteps(mApiClient);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    public void getSteps(GoogleApiClient mApiClient){
        VerifyDataTask verifyDataTask = new VerifyDataTask();
        verifyDataTask.execute();

    }
    long total = 0;
    private class VerifyDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            PendingResult<DailyTotalResult> result = Fitness.HistoryApi.readDailyTotal(mApiClient, DataType.TYPE_STEP_COUNT_DELTA);
            DailyTotalResult totalResult = result.await(30, TimeUnit.SECONDS);
            if (totalResult.getStatus().isSuccess()) {
                DataSet totalSet = totalResult.getTotal();
                total = totalSet.isEmpty() ? 0 : totalSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt();
                Log.d("ExerciseService", String.valueOf(total));

            } else {
                Log.d("ExerciseService", "Error getting step count");
            }
            return null;
        }
    }

    }
