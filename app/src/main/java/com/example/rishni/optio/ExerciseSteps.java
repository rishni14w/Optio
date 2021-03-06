package com.example.rishni.optio;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import java.util.Calendar;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataSourcesResult;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ExerciseSteps extends AppCompatActivity implements OnDataPointListener,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    public static long staticTotal = -100;
    TextView datePicked;
    private static final int REQUEST_OAUTH = 1;
    private static final String AUTH_PENDING = "auth_state_pending";
    private boolean authInProgress = false;
    private GoogleApiClient mApiClient;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    TextView athleteName;
    TextView steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_steps);
        if(savedInstanceState!= null){
            authInProgress = savedInstanceState.getBoolean(AUTH_PENDING);

        }
        athleteName = (TextView)findViewById(R.id.textViewSName);
        setName();
        mApiClient = new GoogleApiClient.Builder(this)
                .addApi(Fitness.SENSORS_API)
                .addApi(Fitness.HISTORY_API)
                .addApi(Fitness.RECORDING_API)
                .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();


        Button weeklyStepsView = (Button)findViewById(R.id.buttonWeekView);
        datePicked = (TextView) findViewById(R.id.textViewSDate);
        weeklyStepsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), WeeklySteps.class);
                startActivity(i);
            }
        });
        Intent i = getIntent();
        if(i.hasExtra("Picked_Date")){

            String pDate = i.getStringExtra("Picked_Date");
            datePicked.setText(pDate);
        }else{
            showData();
        }
        steps = (TextView)findViewById(R.id.textViewSSteps);
        steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerifyDataTask dataTask = new VerifyDataTask();
                dataTask.execute();
            }
        });
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE,30);
        Intent intent = new Intent(this, AlarmReciever.class);
        intent.putExtra("key","value");

        intent.putExtra("Steps",total);
        intent.putExtra("Time",calendar.getTime().toString());
        intent.setAction("com.example.rishni.optio.ACTION");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
       // PendingIntent pendingIntent = PendingIntent.getService(this,0,intent,0);
        Date alarmTime = calendar.getTime();
        VerifyDataTask dataTask = new VerifyDataTask();
        dataTask.execute();
        Timer _timer = new Timer();
        _timer.schedule(new TimerTask() {
            @Override
            public void run() {
                callAsyncTask();
                Date currentTime = Calendar.getInstance().getTime();
                System.out.println(currentTime);
            }
        }, alarmTime ,TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));

       alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        long currentTime = System.currentTimeMillis();
        long oneMinute = 60 * 1000;
        /*alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                currentTime + oneMinute,
                oneMinute,
                pendingIntent);*/

    }
    private void showData(){
        Date currentDate = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String formattedDate = dateFormat.format(currentDate);
        datePicked.setText(formattedDate);

       // AlarmManager alarmManager =
    }
    private void setName(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        String sharedPrefAthleteName = preferences.getString("AthleteName",null);
        if(sharedPrefAthleteName!=null || !sharedPrefAthleteName.isEmpty()){
            athleteName.setText(sharedPrefAthleteName);
        }
        else {
            athleteName.setText("John Noname");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mApiClient.connect();
        MyGoogleApiClient_Singleton googleApiClient_singleton = MyGoogleApiClient_Singleton.getInstance(mApiClient);

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        DataSourcesRequest dataSourcesRequest = new DataSourcesRequest.Builder()
                .setDataTypes(DataType.TYPE_STEP_COUNT_CUMULATIVE)
                .setDataSourceTypes(DataSource.TYPE_DERIVED)
                .build();
        ResultCallback<DataSourcesResult> dataSourcesResultResultCallback = new ResultCallback<DataSourcesResult>() {
            @Override
            public void onResult(@NonNull DataSourcesResult dataSourcesResult) {
                for(DataSource dataSource: dataSourcesResult.getDataSources()){
                    if(DataType.TYPE_STEP_COUNT_CUMULATIVE.equals(dataSource.getDataType())){
                        registerFitnessDataListener(dataSource, DataType.TYPE_STEP_COUNT_CUMULATIVE);
                    }
                }
            }
        };
        Fitness.SensorsApi.findDataSources(mApiClient,dataSourcesRequest).setResultCallback(dataSourcesResultResultCallback);

    }

    public void registerFitnessDataListener(DataSource dataSource,DataType dataType){
        SensorRequest request = new SensorRequest.Builder()
                .setDataSource(dataSource)
                .setDataType(dataType)
                .setSamplingRate(3, TimeUnit.SECONDS)
                .build();
        Fitness.SensorsApi.add(mApiClient,request,this)
                .setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        if(status.isSuccess()){
                            Log.e("Google Fit","Sensor API successfully added");
                        }
                    }
                });
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        if(!authInProgress){
            try{
                authInProgress = true;
                connectionResult.startResolutionForResult(ExerciseSteps.this,REQUEST_OAUTH);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }

        }else{
            Log.e("Google Fit","authInProgress");
        }
    }

    @Override
    public void onDataPoint(DataPoint dataPoint) {
        //currently shows the realtime step count so comment it out in the future after testing
        /*for(final Field field:dataPoint.getDataType().getFields()){
            final Value value = dataPoint.getValue(field);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),"field "+field.getName()+" value "+value,Toast.LENGTH_SHORT).show();
                }
            });
        }*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_OAUTH){
            authInProgress =false;
            if(requestCode==RESULT_OK){
                if(!mApiClient.isConnecting()&& !mApiClient.isConnected()){
                    mApiClient.connect();
                }else if(resultCode==RESULT_CANCELED){
                    Log.e("Google Fit","RESULT_CANCELLED");
                }
            }else{
                Log.e("Google Fit","RESULT CODE not REQUEST AUTH");
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Fitness.SensorsApi.remove(mApiClient,this)
                .setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        if(status.isSuccess()){
                            mApiClient.disconnect();
                        }
                    }
                });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(AUTH_PENDING,authInProgress);
    }
    //ToDO : this is the actual method that retrieves the daily step count. if testing goes right modify this.
    long total = 0;
    private class VerifyDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            PendingResult<DailyTotalResult> result = Fitness.HistoryApi.readDailyTotal(mApiClient,DataType.TYPE_STEP_COUNT_DELTA);
            DailyTotalResult totalResult = result.await(30,TimeUnit.SECONDS);
            if(totalResult.getStatus().isSuccess()){
                DataSet totalSet = totalResult.getTotal();
                total = totalSet.isEmpty()?0:totalSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt();
                staticTotal = total;
            }else{
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getApplicationContext(),"Error in getting Daily steps",Toast.LENGTH_LONG).show();
                    }
                });
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),"Daily Steps "+total,Toast.LENGTH_SHORT).show();

                }
            });
            return null;
        }
    }
    public void callAsyncTask(){
        VerifyDataTask verifyDataTask = new VerifyDataTask();
        verifyDataTask.execute();
    }

}
