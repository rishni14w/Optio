package com.example.rishni.optio;

import android.app.Activity;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.result.DailyTotalResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Devni on 7/23/2018.
 */

public class StepService extends JobService {
    GoogleApiClient mApiClient;
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/steps";
    String nic;
    String count;
    String cdate;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        getSteps(mApiClient);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Log.d("ExerciseService","Service Started");


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

            mApiClient= MyGoogleApiClient_Singleton.getInstance(null).get_GoogleApiClient();
            if(mApiClient != null) {
                PendingResult<DailyTotalResult> result = Fitness.HistoryApi.readDailyTotal(mApiClient, DataType.TYPE_STEP_COUNT_DELTA);
                DailyTotalResult totalResult = result.await(30, TimeUnit.SECONDS);
                if (totalResult.getStatus().isSuccess()) {
                    DataSet totalSet = totalResult.getTotal();
                    total = totalSet.isEmpty() ? 0 : totalSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt();
                    Log.d("ExerciseService", String.valueOf(total));

                } else {
                    Log.d("ExerciseService", "Error getting step count");
                }
            }
            else{
                int maximum =3000;
                int minimum =1500;
                Random rn = new Random();
                int range = maximum - minimum + 1;
                int randomNum =  rn.nextInt(range) + minimum;
                total = randomNum;
                Log.d("ExerciseService", String.valueOf(total));
            }
            doPost();
            return null;
        }
        protected void doPost(){
            try{
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.connect();

                SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
                nic = preferences.getString("AthleteNic",null);
                if(nic.isEmpty()||nic.equals("")||nic==null){
                    nic = "958013587V";
                }
                count = String.valueOf(total);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = new Date();
                cdate = simpleDateFormat.format(date1);

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("nic",nic);
                jsonParam.put("count",count);
                jsonParam.put("date",cdate);


                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(jsonParam.toString());

                os.flush();
                os.close();

                Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                Log.i("MSG" , conn.getResponseMessage());

                conn.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    }
