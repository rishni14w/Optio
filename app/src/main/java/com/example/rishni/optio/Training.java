package com.example.rishni.optio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Training extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, String> listDataChild;
    String nic;
    String ServerURL = "http://10.0.2.2:8080/";
    ArrayList<String> exercisesList;
    HashMap<String,String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        nic = preferences.getString("AthleteNic",null);
        exercisesList = new ArrayList<>();
        expandableListView = (ExpandableListView) findViewById(R.id.lvExpTr);
        new ServerTask().execute();
    }
    private void prepareListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, String>();
        String gymAdvanced[] = {"axle deadlift","front barbell squat","hang snatch","hanging leg raise",
                "hyperextensions","incline pushup","jerk balance","gym press","jerk dip squat","jefferson squats",
                "kettlebell rest","good morning","gorilla chin crunch","hang clean","hack squat","flutter kicks"};
        String otherList[]={"frog hops ","foot smr","hip circles","adductor-groin","ankle circles","arm circles",
                "ankle on the knee","back flies","band pull aparts","elbow circles","elbows to back","external rotation",
                "front cone hops","hurdle hops","jogging-light","jogging-medium"};
        if(map.size()>0){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                listDataHeader.add(key);
                listDataChild.put(value,value);
            }
        }
        else{
            for(int i=0;i<5;i++){
                listDataHeader.add(gymAdvanced[i]);
                listDataChild.put(gymAdvanced[i],"youtube link");
            }
        }
    }

    class ServerTask extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {

            if(nic.isEmpty()||nic==null||nic.equalsIgnoreCase("")){
                nic = "958013587V";
            }
            doGet();

            return null;
        }
        protected void doGet(){
            System.out.println("Workouts, this doGet method was called");
            //TODO:Change to actual IP addresses once the semantic server is hosted.
            try {
                ServerURL = "http://10.0.2.2:8080/exercise/"+nic;
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept","application/json");

                if(conn.getResponseCode()==200){
                    System.out.println("Workouts, if statement reached");
                    Log.d("Workouts","response code 200");
                }else{
                    Log.e("Workouts",conn.getResponseMessage());
                }
                InputStream responseBody = conn.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody,"UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);
                BufferedReader bR = new BufferedReader(  responseBodyReader);
                String line = "";

                StringBuilder responseStrBuilder = new StringBuilder();
                while((line =  bR.readLine()) != null){

                    responseStrBuilder.append(line);
                }
                //inputStream.close();

                JSONObject result= new JSONObject(responseStrBuilder.toString());
                try {
                    Iterator<String> iterator = result.keys();
                    map = new HashMap<>();
                    while (iterator.hasNext()) {
                        String key = iterator.next();
                        String value = result.getString(key);

                           map.put(key, value);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                jsonReader.close();

                runOnUiThread(()->{
                    prepareListData();

                    listAdapter = new ExpandableListAdapter(getApplicationContext(), listDataHeader, listDataChild);

                    // setting list adapter
                    expandableListView.setAdapter(listAdapter);
                    // Listview on child click listener
                    expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v,
                                                    int groupPosition, int childPosition, long id) {
                            String videoName =listDataChild.get(childPosition) ;

                            //https://www.youtube.com/results?search_query=
                            //This opens up youtube app or youtube website when user clicks on the workout
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(videoName)));
                /*Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)), Toast.LENGTH_SHORT)
                        .show();*/
                            return false;
                        }
                    });
                });
                //prepareListData();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
