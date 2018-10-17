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
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Workouts extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, String> listDataChild;
    String physical = "overweight";
    int exCount = 15;
    String complexity;
    String place;
    String nic;
    String ServerURL = "http://10.0.2.2/";
    ArrayList<String> exercisesList;
    boolean hasCreated = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        nic = preferences.getString("AthleteNic",null);
        exercisesList = new ArrayList<>();
        new ServerTask().execute();
        Intent intent = getIntent();
        complexity = intent.getStringExtra("complexity");
        place = intent.getStringExtra("place");
        physical = intent.getStringExtra("physique");
        if(physical.equalsIgnoreCase("overweight")){
            exCount = 15;
        }else{
            exCount = 10;
        }
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data

    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        //TODO: Change this to get the data from the server once the semantic web service is hosted
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, String>();
        String gymAdvanced[] = {"axle deadlift","front barbell squat","hang snatch","hanging leg raise",
                "hyperextensions","incline pushup","jerk balance","gym press","jerk dip squat","jefferson squats",
                "kettlebell rest","good morning","gorilla chin crunch","hang clean","hack squat","flutter kicks"};
        String otherList[]={"frog hops ","foot smr","hip circles","adductor-groin","ankle circles","arm circles",
        "ankle on the knee","back flies","band pull aparts","elbow circles","elbows to back","external rotation",
                "front cone hops","hurdle hops","jogging-light","jogging-medium"};
        if(exercisesList.size()>0){
            for (String temp : exercisesList) {
                listDataHeader.add(temp);
                listDataChild.put(temp,"Youtube Link");
            }
        }
        else{
            for(int i=0;i<exCount;i++){
                listDataHeader.add(gymAdvanced[i]);
                listDataChild.put(gymAdvanced[i],"youtube link");
            }
        }
        /*if((place.equalsIgnoreCase("gym"))&&(complexity.equalsIgnoreCase("advanced")))
        {
            for(int i=0;i<exCount;i++){
                listDataHeader.add(gymAdvanced[i]);
                listDataChild.put(gymAdvanced[i],"youtube link");
        }
        }else{
            for(int i=0;i<exCount;i++){
            listDataHeader.add(otherList[i]);
            listDataChild.put(otherList[i],"Search Now on Youtube");
        }
    }*/

        //listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        //listDataChild.put(listDataHeader.get(1), nowShowing);
        //listDataChild.put(listDataHeader.get(2), comingSoon);
    }
    class ServerTask extends AsyncTask{
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
            try {
                if(hasCreated == false){
                    ServerURL = "http://10.0.2.2/adultWorkout/"+nic;
                }else{
                    ServerURL ="http://10.0.2.2/adultWorkout/second/"+nic;
                }
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept","application/json");

                if(conn.getResponseCode()==200){
                    Log.d("Workouts","response code 200");
                }else{
                    Log.e("Workouts",conn.getResponseMessage());
                }
                InputStream responseBody = conn.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody,"UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);
                jsonReader.beginArray();
                //jsonReader.nextName();
                while(jsonReader.hasNext()){
                    exercisesList.add(jsonReader.nextString());
                }

                jsonReader.close();
                hasCreated = true;
                runOnUiThread(()->{
                    prepareListData();

                    listAdapter = new ExpandableListAdapter(getApplicationContext(), listDataHeader, listDataChild);

                    // setting list adapter
                    expListView.setAdapter(listAdapter);
                    // Listview on child click listener
                    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v,
                                                    int groupPosition, int childPosition, long id) {
                            String videoName =listDataHeader.get(groupPosition) ;

                            //https://www.youtube.com/results?search_query=
                            //This opens up youtube app or youtube website when user clicks on the workout
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query="+videoName)));
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