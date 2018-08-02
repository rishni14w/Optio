package com.example.rishni.optio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class BodyComposition_View extends AppCompatActivity {

    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/bodycomposition";
    private TextView textView_weight;
    private TextView textView_waist;
    private TextView textView_hip;
    private TextView textView_height;
    private TextView textView_activitylevel;

    String Weight;
    String Waist;
    String Hip;
    String Height;
    String ActivityLevel;
    String date;
    String nic;
    String id;

    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.bodycomposition_Title);
        setContentView(R.layout.activity_body_composition__view);

        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        textView_weight=findViewById(R.id.weight_tv);
        textView_waist=findViewById(R.id.waist_circumference_tv);
        textView_hip=findViewById(R.id.hip_circumference_tv);
        textView_height=findViewById(R.id.height_tv);
        textView_activitylevel=findViewById(R.id.activitylevel_tv);

        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("AthletePref",0);
        nic=sharedPref.getString("AthleteNic","");

        findViewById(R.id.weight).setVisibility(View.INVISIBLE);
        findViewById(R.id.kg).setVisibility(View.INVISIBLE);
        findViewById(R.id.waist_circumference).setVisibility(View.INVISIBLE);
        findViewById(R.id.inches1).setVisibility(View.INVISIBLE);
        findViewById(R.id.hip_circumference).setVisibility(View.INVISIBLE);
        findViewById(R.id.inches2).setVisibility(View.INVISIBLE);
        findViewById(R.id.height).setVisibility(View.INVISIBLE);
        findViewById(R.id.cm).setVisibility(View.INVISIBLE);
        findViewById(R.id.activitylevel).setVisibility(View.INVISIBLE);
        new GetData().execute();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_edit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.edit)
        {
            Intent intent= new Intent(this,BodyComposition.class);

            intent.putExtra("id",id);
            intent.putExtra("nic",nic);
            intent.putExtra("date",date);
            intent.putExtra("weight",Weight);
            intent.putExtra("waist",Waist);
            intent.putExtra("hip",Hip);
            intent.putExtra("height",Height);
            intent.putExtra("activitylevel",ActivityLevel);
            startActivity(intent);


        }
        else
        {
            Intent intent=new Intent(this,BodyComposition_View.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetData extends AsyncTask<Void,Void,Void> {

        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);

        }
        @Override
        protected Void doInBackground(Void... voids) {
            ServerURL = ServerURL+"/"+nic;
            doGet();
            return null;
        }
        protected void doGet()
        {
            try
            {
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept","application/json");

                InputStream responseBody = conn.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody,"UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);
                //jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()){
                    String idName = jsonReader.nextName();
                    id = jsonReader.nextString();
                    String nicName = jsonReader.nextName();
                    String nicString = jsonReader.nextString();
                    String dateName = jsonReader.nextName();
                    date = jsonReader.nextString();
                    String WeightName = jsonReader.nextName();
                    Weight = jsonReader.nextString();
                    String WaistName = jsonReader.nextName();
                    Waist = jsonReader.nextString();
                    String HipName = jsonReader.nextName();
                    Hip = jsonReader.nextString();
                    String HeighttName = jsonReader.nextName();
                    Height = jsonReader.nextString();
                    String ActivityLevelName = jsonReader.nextName();
                    ActivityLevel = jsonReader.nextString();

                    //jsonReader.skipValue();
                }

                jsonReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        protected void onPostExecute(Void voids) {
            super.onPostExecute(voids);
            findViewById(R.id.weight).setVisibility(View.VISIBLE);
            findViewById(R.id.kg).setVisibility(View.VISIBLE);
            findViewById(R.id.waist_circumference).setVisibility(View.VISIBLE);
            findViewById(R.id.inches1).setVisibility(View.VISIBLE);
            findViewById(R.id.hip_circumference).setVisibility(View.VISIBLE);
            findViewById(R.id.inches2).setVisibility(View.VISIBLE);
            findViewById(R.id.height).setVisibility(View.VISIBLE);
            findViewById(R.id.cm).setVisibility(View.VISIBLE);
            findViewById(R.id.activitylevel).setVisibility(View.VISIBLE);

            textView_weight.setText(Weight);
            textView_waist.setText(Waist);
            textView_hip.setText(Hip);
            textView_height.setText(Height);
            textView_activitylevel.setText(ActivityLevel);

            mProgressBar.setVisibility(View.GONE);
        }
    }

}
