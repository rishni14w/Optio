package com.example.rishni.optio;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class Sleep extends AppCompatActivity {

    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/sleep";

    private EditText editText_Hour;
    private EditText editText_Min;

    String date;
    String nic;
    String duration;

    Validation validation=new Validation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sleep_Title);
        setContentView(R.layout.activity_sleep);

        editText_Hour=findViewById(R.id.digit_hr);
        editText_Min=findViewById(R.id.digit_min);

        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("AthletePref",0);
        nic=sharedPref.getString("AthleteNic","");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.save)
        {
            String newHour=editText_Hour.getText().toString();
            String newMin=editText_Min.getText().toString();

            Boolean result=validation.isEmpty(newHour,newMin);
            if(result.equals(false))
            {
                Boolean result2=validation.isGreaterthan(newHour,newMin);
                if(result2.equals(false))
                {
                    duration=newHour+"hr-"+newMin+"min";

                    Date currentTime= Calendar.getInstance().getTime();
                    date=currentTime.toString();

                    new SendData().execute();
                }
                else
                {
                    AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("Hours should be less than or equal to 24 and minutes should be less than or equal to 60").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
                    dialog.show();
                }

            }
            else
            {
                AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("Both hours and minutes are required").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
                dialog.show();
            }

        }
        else
        {
            Intent intent=new Intent(this,StressAndHealth.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    //post sleep details
    class SendData extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            doPost();
            return null;
        }

        protected void doPost() {
            try {
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.connect();

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("sleepDuration", duration);
                jsonParam.put("nic", nic);
                jsonParam.put("date", date);


                conn.getOutputStream();
                try {
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    os.writeBytes(jsonParam.toString());

                    os.flush();
                    os.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

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

        protected void onPostExecute(Object object) {
            super.onPostExecute(object);
            toastMessage("Successfully saved");
            Intent intent = new Intent(Sleep.this, StressAndHealth.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }


    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
