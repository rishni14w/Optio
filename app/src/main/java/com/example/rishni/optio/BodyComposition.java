package com.example.rishni.optio;

import android.annotation.TargetApi;
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

public class BodyComposition extends AppCompatActivity {
    String ServerURL = "http://10.0.2.2:8080/bodycomposition";

    private EditText editText_weight;
    private EditText editText_waist;
    private EditText editText_hip;

    String newWeight;
    String newWaist;
    String newHip;
    String date;
    String nic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.bodycomposition_Title);
        setContentView(R.layout.activity_body_composition);

        editText_weight=findViewById(R.id.weight_txt);
        editText_waist=findViewById(R.id.waist_circumference_txt);
        editText_hip=findViewById(R.id.hip_circumference_txt);

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
            newWeight=editText_weight.getText().toString();
            newWaist=editText_waist.getText().toString();
            newHip=editText_hip.getText().toString();

            Date currentTime= Calendar.getInstance().getTime();
            date=currentTime.toString();
            //toastMessage("date = "+currentTime);
            //new PostData(newWeight,newWaist,newHip,date).execute(db.getAddressAPI_BodyComposition());
            toastMessage("nic= "+nic);
            new SendData().execute();

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

    //function to add new user
    /**class PostData extends AsyncTask<String,String,String> {
        String weight;
        String waist;
        String hip;
        String date;

        public PostData(String weight, String waist, String hip, String date) {
            this.weight = weight;
            this.waist = waist;
            this.hip = hip;
            this.date = date;
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
            json += "\t\"weight\":\"" + weight + "\",\n";
            json += "\t\"waist\":\"" + waist + "\",\n";
            json += "\t\"hip\":\"" + hip + "\",\n";
            json += "\t\"date\":\"" + date + "\",\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            toastMessage("Successfully saved");
            Intent intent = new Intent(BodyComposition.this, StressAndHealth.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }**/

    class SendData extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
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

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("weight",newWeight);
                jsonParam.put("waist",newWaist);
                jsonParam.put("hip",newHip);
                jsonParam.put("date",date);
                jsonParam.put("nic",nic);

                toastMessage("nic= "+nic+" ,wieght="+newWeight+" ,waist="+newWaist+" ,hip="+newHip);
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

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            toastMessage("Successfully saved");
            Intent intent = new Intent(BodyComposition.this, StressAndHealth.class);
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
