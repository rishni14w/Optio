package com.example.rishni.optio;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WeeklySteps extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    String ServerURL = "http://10.0.2.2:8080/steps";
    TextView maximumSteps;
    TextView thisWeek;
    private LineChart lineChart;
    private LineData lineData;
    int[] valArr = new int[7];
    String WeekBefore;
    String nic;
    Date sevenDaysAgo;
    int maximum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_steps);
        Button buttonDate = findViewById(R.id.buttonPickDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker(view);
            }
        });

        valArr[0]=400;
        valArr[1]=429;
        valArr[2]=345;
        valArr[3]=158;
        valArr[4]=500;
        valArr[5]=400;
        valArr[6]=390;
        readNic();

        //Collections.min(Arrays.asList(valArr));
        maximum = maxValue(valArr);

        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        cal.add(Calendar.DATE, -7);
        sevenDaysAgo = cal.getTime();
        WeekBefore= dateFormat.format(sevenDaysAgo);
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);

        new WeeklyStepsAsyncTasK().execute();
       // System.out.println("Date = "+ cal.getTime());

        thisWeek = (TextView)findViewById(R.id.textViewWeek);
        maximumSteps = (TextView)findViewById(R.id.textViewMostActiveValue);

        thisWeek.setText(WeekBefore+" to "+formattedDate);
        maximumSteps.setText("Friday");

        lineChart = (com.github.mikephil.charting.charts.LineChart) findViewById(R.id.lineChart);

        lineData = new LineData(getXValues(),getLineDataValue());
        lineChart.setData(lineData);

    }
    private void readNic(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        if(preferences.contains("AthleteNic")){
            nic = preferences.getString("AthleteNic",null);
        }else{
            nic = "958013587V";
        }
    }
//TODO : Once the database is working replace the lables with the last seven days
    private ArrayList<String> getXValues() {
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("Mon");
        xValues.add("Tue");
        xValues.add("Wed");
        xValues.add("Thur");
        xValues.add("Fri");
        xValues.add("Sat");
        xValues.add("Sun");
        return xValues;
    }
    //TODO : Get the data from the database and set it to the y axis values
    private List<ILineDataSet> getLineDataValue() {
        ArrayList<ILineDataSet> lineDataSets = null;
        ArrayList<Entry> entryArrayList = new ArrayList<>();

        Entry e1 = new Entry(valArr[0],0);
        Entry e2 = new Entry(valArr[1],1);
        Entry e3 = new Entry(valArr[2],2);
        Entry e4 = new Entry(valArr[3],3);
        Entry e5 = new Entry(valArr[4],4);
        Entry e6 = new Entry(valArr[5],5);
        Entry e7 = new Entry(valArr[6],6);
        entryArrayList.add(e1);
        entryArrayList.add(e2);
        entryArrayList.add(e3);
        entryArrayList.add(e4);
        entryArrayList.add(e5);
        entryArrayList.add(e6);
        entryArrayList.add(e7);
        LineDataSet lineDataSet = new LineDataSet(entryArrayList,"Steps");
        lineDataSets = new ArrayList<>();
        lineDataSets.add(lineDataSet);
        return lineDataSets;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = new GregorianCalendar(i,i1,i2);
        setDate(calendar);
    }
    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        //Toast.makeText(this,"Selected Date: "+dateFormat.format(calendar.getTime()),Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,ExerciseSteps.class);
        String datePicked = dateFormat.format(calendar.getTime());
        i.putExtra("Picked_Date",datePicked);
        startActivity(i);
    }
    public void datePicker(View view){

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getFragmentManager(),"datePicker");
    }
    public int maxValue(int array[]){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return Collections.max(list);

    }

    private class WeeklyStepsAsyncTasK extends AsyncTask <Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            WeekBefore = simpleDateFormat.format(sevenDaysAgo);
            ServerURL = ServerURL+"/"+nic+"/"+WeekBefore;

            doGet();
            Log.d("WeeklySteps",ServerURL);
            return null;
        }
        protected void doGet(){

            try {
                 //TODO: Append Athlete's nic and the date of  7 days ago to the URL
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept","application/json");
                if(conn.getResponseCode()==200){
                    Log.d("WeeklySteps","response code 200");
                }else{
                    Log.e("WeeklySteps",conn.getResponseMessage());
                }
                InputStream responseBody = conn.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody,"UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);
                jsonReader.beginArray();
                //jsonReader.nextName();
                jsonReader.beginObject();
                while (jsonReader.hasNext()){
                    String name = jsonReader.nextName();
                    Log.d("WeeklySteps",name); // id nic count date
                    jsonReader.skipValue();
                }

                jsonReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
