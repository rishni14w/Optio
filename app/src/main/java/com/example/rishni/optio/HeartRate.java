package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

public class HeartRate extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/heartrate";
    private EditText editText_Before;
    private EditText editText_After;

    String newBefore;
    String newAfter;
    String date;
    String nic;

    Validation validation=new Validation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.heartrate_Title);
        setContentView(R.layout.activity_heart_rate);

        editText_Before=findViewById(R.id.heart_rate_before_txt);
        editText_After=findViewById(R.id.heart_rate_after_txt);

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
            newBefore=editText_Before.getText().toString();
            newAfter=editText_After.getText().toString();

            Boolean result=validation.isEmpty(newBefore,newAfter);
            if(result.equals(false))
            {
                Boolean result2=validation.heartrateRange(newBefore,newAfter);
                if(result2.equals(true))
                {
                    Date currentTime= Calendar.getInstance().getTime();
                    date=currentTime.toString();

                    //new PostData(newBefore,newAfter).execute(db.getAddressAPI_Heartrate());
                    new SendData().execute();
                }
                else
                {
                    AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("invalid heart rate").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
                    dialog.show();
                }

            }
            else
            {
                AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("Both before and after heart rates are required").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

    //function to add new heartrate
    /**class PostData extends AsyncTask<String,String,String> {
     String before;
     String after;

     public PostData(String before, String after) {
     this.before = before;
     this.after = after;
     }

     @Override
     protected void onPreExecute() {
     super.onPreExecute();
     }

     @TargetApi(Build.VERSION_CODES.KITKAT)
     @RequiresApi(api = Build.VERSION_CODES.KITKAT)
     @Override
     protected String doInBackground(String... params) {
     //android.os.Debug.waitForDebugger();
     String urlString = params[0];
     HTTPDataHandler hh = new HTTPDataHandler();

     String json = "{\n";
     json += "\t\"before\":\"" + before + "\",\n";
     json += "\t\"after\":\"" + after + "\",\n";
     json += "}";
     hh.PostHTTPData(urlString, json);
     return "";
     }

     @Override
     protected void onPostExecute(String s) {
     super.onPostExecute(s);
     toastMessage("Successfully saved");
     Intent intent = new Intent(HeartRate.this, StressAndHealth.class);
     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
     startActivity(intent);
     finish();
     }
     }**/

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
                jsonParam.put("nic", nic);
                jsonParam.put("date", date);
                jsonParam.put("before", newBefore);
                jsonParam.put("after", newAfter);

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
                Log.i("MSG", conn.getResponseMessage());

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
            Intent intent = new Intent(HeartRate.this, StressAndHealth.class);
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
