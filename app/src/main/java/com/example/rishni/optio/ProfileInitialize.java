package com.example.rishni.optio;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

//Important: This activity is meant to serve as the initial profile page where the athlete is suppose to enter his details
//on registration. Any details that is meant to be entered only once should go here.
//Any details that change such as weight etc should go on a different activity to preserve clarity.
public class ProfileInitialize extends AppCompatActivity {

    String ServerURL = "http://10.0.2.2:8080/athleteInit";
    EditText name;
    EditText nic;
    EditText dob;
    EditText joinedDate;
    EditText trainerId;
    Button btnSave;
    String p_name;
    String p_nic;
    String p_dob;
    String p_joinedDate;
    String p_trainerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_initialize);
        name = (EditText)findViewById(R.id.editTextName);
        nic = (EditText)findViewById(R.id.editTextNIC);
        dob = (EditText)findViewById(R.id.editTextDOB);
        joinedDate = (EditText)findViewById(R.id.editTextJDate);
        trainerId = (EditText)findViewById(R.id.editTextTID);
        btnSave = (Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_name = name.getText().toString();
                p_dob = dob.getText().toString();
                p_nic = nic.getText().toString();
                p_joinedDate = joinedDate.getText().toString();
                p_trainerId = trainerId.getText().toString();
                new SendData().execute();


            }
        });
    }
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
                jsonParam.put("name",p_name);
                jsonParam.put("nic",p_nic);
                jsonParam.put("joinedDate",p_joinedDate);
                jsonParam.put("dob",p_dob);
                jsonParam.put("trainerID",p_trainerId);

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
