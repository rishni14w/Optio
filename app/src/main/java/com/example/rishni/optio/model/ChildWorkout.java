package com.example.rishni.optio.model;

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

import com.example.rishni.optio.ExpandableListAdapter;
import com.example.rishni.optio.KidExpandableList;
import com.example.rishni.optio.R;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChildWorkout extends AppCompatActivity {

    String ServerURL = "http://10.0.2.2:8080/";
    KidExpandableList listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, String> listDataChild;
    HashMap<String, String> listVideoUrl;
    String nic;
    boolean hasCreated = false;
    ArrayList<String> exercisesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_workout);
        expListView = (ExpandableListView) findViewById(R.id.lvCExp);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        nic = preferences.getString("AthleteNic",null);
        exercisesList = new ArrayList<>();
        new ChildServer().execute();
    }
    private void prepareListData() {
        
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, String>();
        listVideoUrl = new HashMap<String, String>();
        String exerciseName[] = {"Just Dance 4 Kids - Let it go","Just Dance 4 Kids - Gummy Bear","Just Dance 4 Kids - Skip to my lou",
                "Rising Releve","Aerobic Exercise For Kids","Dance choreography for kid's fitness","Just Dance 4 Kids - Hockey Pockey",
                "Just Dance 4 Kids - Pirate"};
        listVideoUrl.put("Just Dance 4 Kids - Let it go","v=TczCbjuux5M");
        listVideoUrl.put("Just Dance 4 Kids - Gummy Bear","v=OkfzyMy47GI");
        listVideoUrl.put("Just Dance 4 Kids - Skip to my lou","v=ssac7sfUOgM");
        listVideoUrl.put("Rising Releve","v=Ux-SQLLZYeU");
        listVideoUrl.put("Aerobic Exercise For Kids","v=hcGDk8S41X4");
        listVideoUrl.put("Dance choreography for kid's fitness","v=L_A_HjHZxfI");
        listVideoUrl.put("Just Dance 4 Kids - Hockey Pockey","v=L_A_HjHZxfI");
        listVideoUrl.put("Just Dance 4 Kids - Pirate","v=oe_HDfdmnaM");

        if(exercisesList.size()>0){
            for (String temp : exercisesList) {
                listDataHeader.add(temp);
                listDataChild.put(temp,"Youtube Link");
            }
        }else{
            for(int i=0;i<exerciseName.length;i++) {
                listDataHeader.add(exerciseName[i]);
                listDataChild.put(exerciseName[i], "Watch Now");
            }
        }

       //listVideoUrl;



        //listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        //listDataChild.put(listDataHeader.get(1), nowShowing);
        //listDataChild.put(listDataHeader.get(2), comingSoon);
    }
    class ChildServer extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {


            if(nic.isEmpty()||nic==null||nic.equalsIgnoreCase("")){
                nic = "090000001V";
            }
            doGet();

            return null;
        }
        protected void doGet(){
            System.out.println("Workouts, this doGet method was called");
            //TODO:Change to actual IP addresses once the semantic server is hosted.
            try {
                if(hasCreated == false){
                    ServerURL = "http://10.0.2.2:8080/kidworkout/create/"+nic;
                }else{
                    ServerURL ="http://10.0.2.2:8080/kidworkout/"+nic;
                }
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
                jsonReader.beginArray();
                //jsonReader.nextName();
                while(jsonReader.hasNext()){
                    exercisesList.add(jsonReader.nextString());
                }

                jsonReader.close();
                hasCreated = true;
                runOnUiThread(()->{
                    prepareListData();


                    listAdapter = new KidExpandableList(getApplicationContext(), listDataHeader, listDataChild);

                    // setting list adapter
                    expListView.setAdapter(listAdapter);
                    // Listview on child click listener
                    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v,
                                                    int groupPosition, int childPosition, long id) {
                            String videoName =listDataHeader.get(groupPosition) ;
                            String videoId = listVideoUrl.get(videoName);


                            //https://www.youtube.com/results?search_query=
                            //This opens up youtube app or youtube website when user clicks on the workout
                            if(videoId==null||videoId.isEmpty()||videoId.equalsIgnoreCase("")){
                                 //https://www.youtube.com/results?search_query=
                                //This opens up youtube app or youtube website when user clicks on the workout
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query="+videoName)));
                            }else {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?" + videoId)));
                            }
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
