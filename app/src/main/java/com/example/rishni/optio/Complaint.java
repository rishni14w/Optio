package com.example.rishni.optio;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint extends AppCompatActivity {

    String nic = "958013587V";
    Button complaintSubmit;
    EditText complaintET;
    String comment = "None";
    String cdate;
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/feedback";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        nic = preferences.getString("AthleteDob",null);
        if(nic.isEmpty()||nic.equalsIgnoreCase("")||nic==null){
            nic = "958013587V";
        }

        complaintET = (EditText)findViewById(R.id.complaintET);
        complaintSubmit = (Button)findViewById(R.id.complaintSubmit);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        cdate = simpleDateFormat.format(date1);
        complaintSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comment = complaintET.getText().toString();
                new SendData().execute();
            }
        });
    }
    class SendData extends AsyncTask {

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
                jsonParam.put("nic",nic);
                jsonParam.put("comment",comment);
                jsonParam.put("date",cdate);

                DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                os.writeBytes(jsonParam.toString());

                os.flush();
                os.close();

                Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                Log.i("MSG" , conn.getResponseMessage());
                runOnUiThread(() -> {
                    try {
                        Toast.makeText(getApplicationContext(),conn.getResponseMessage(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
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
