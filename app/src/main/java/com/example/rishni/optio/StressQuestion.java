package com.example.rishni.optio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rishni.optio.model.Injury;
import com.example.rishni.optio.model.InputSuggestion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StressQuestion extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/getSuggestion";
    String ServerURL2 = "https://murmuring-cove-69371.herokuapp.com/inputSuggestion";
    private EditText user_question;
    private String user_question_string;
    Validation validation=new Validation();

    List<InputSuggestion> suggestions=new ArrayList<InputSuggestion>();

    String date;
    String nic;
    String response;

    int responseCode;

    static String stream=null;

    private ArrayList<String> stream_Arr;
    JSONArray jsonArray_stream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_question);
        user_question=findViewById(R.id.user_q);

        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("AthletePref",0);
        nic=sharedPref.getString("AthleteNic","");


    }

    public void recommend_clicked(View view)
    {
        if (view.getId()==R.id.recommend_btn)
        {
            user_question_string=user_question.getText().toString();

            Date currentTime= Calendar.getInstance().getTime();
            date=currentTime.toString();

            Boolean result=validation.isEmpty(user_question_string);
            if(result.equals(false))
            {
                new SendData().execute();
                new GetData().execute();
                new PutData().execute();
            }
            else
            {
                AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("please enter your concern").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
                dialog.show();
            }
            Intent i= new Intent(this,Recommendation.class);
            startActivity(i);
        }

    }

    //post question details
    public class SendData extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            doPost();
            return null;
        }

        protected void doPost() {
            try {
                URL url = new URL(ServerURL2);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.connect();

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("nic", nic);
                jsonParam.put("input", user_question_string);


                try {
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    os.writeBytes(jsonParam.toString());

                    os.flush();
                    os.close();

                    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                    StringBuilder sb = new StringBuilder();
                    for (int c; (c = in.read()) >= 0;)
                        sb.append((char)c);
                    response = sb.toString();

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
            toastMessage("Successfully sent");


            //Intent intent = new Intent(StressQuestion.this, Recommendation.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //startActivity(intent);
            //finish();
        }
    }



    public class GetData extends AsyncTask<Void,Void,Void> {

        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected Void doInBackground(Void... voids) {
            ServerURL = ServerURL+"/"+user_question_string;
            doGet();
            return null;
        }
        protected void doGet()
        {
            try
            {
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                //check the connection status
                if(conn.getResponseCode()==200)
                {
                    //if response code=200 - HTTP.OK
                    InputStream in=new BufferedInputStream(conn.getInputStream());

                    //read the BufferedInputStream
                    BufferedReader r=new BufferedReader(new InputStreamReader(in));
                    StringBuilder sb=new StringBuilder();

                    String line;
                    while ((line=r.readLine())!=null)
                    {
                        sb.append(line);
                    }
                    stream=sb.toString();
                    conn.disconnect();
                }

                else
                {

                }

                //Gson gson=new Gson();
                //Type listType=new TypeToken<List<InputSuggestion>>(){}.getType();
                //suggestions=gson.fromJson(stream,listType);//parse to list
                stream=stream.replace("[","");
                stream=stream.replace("\"","");
                String[] stream_str=stream.split(",");
                stream_Arr=new ArrayList<String>(Arrays.asList(stream_str));
                jsonArray_stream=new JSONArray(stream_Arr);



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        protected void onPostExecute(Void voids) {
            super.onPostExecute(voids);
            //CustomAdapter adapter=new CustomAdapter(getApplicationContext(),injurys);//create adapter
            //lstView.setAdapter(adapter); //set adapter to listview
            //mProgressBar.setVisibility(View.GONE);
        }
    }

    class PutData extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            ServerURL = ServerURL2+"/"+response;
            doPut();
            return null;
        }

        protected void doPut() {
            try {
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("PUT");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.connect();

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("nic", nic);
                jsonParam.put("input", user_question_string);
                jsonParam.put("suggestion", jsonArray_stream);

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
            toastMessage("Successfully updated");
            //Intent intent = new Intent(InjuryEdit.this, Injury_View.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //startActivity(intent);
            //finish();
        }
    }
    /**public class SendDataToInputSuggestion extends AsyncTask {

    @Override protected Object doInBackground(Object[] objects) {
    doPostToInputSuggestion();
    return null;
    }

    protected void doPostToInputSuggestion() {
    try {
    URL url = new URL(ServerURL2);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setRequestProperty("Accept", "application/json");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.connect();

    JSONObject jsonParam = new JSONObject();
    jsonParam.put("nic", nic);
    jsonParam.put("input", user_question_string);
    jsonParam.put("suggestion", jsonArray_stream);

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

    responseCode = conn.getResponseCode();
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
    if (responseCode == 200) {
    toastMessage("Successfully saved");
    } else {
    toastMessage("Unsuccessfull");
    }

    //Intent intent = new Intent(Competition.this, StressAndHealth.class);
    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    //startActivity(intent);
    //finish();
    }
    }**/

    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
