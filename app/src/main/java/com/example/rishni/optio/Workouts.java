package com.example.rishni.optio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
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
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String videoName =listDataHeader.get(groupPosition) ;

                //https://www.youtube.com/results?search_query=
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
    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, String>();
        String gymAdvanced[] = {"axle deadlift","front barbell squat","hang snatch","hanging leg raise",
                "hyperextensions","incline pushup","jerk balance","gym press","jerk dip squat","jefferson squats",
                "kettlebell rest","good morning","gorilla chin crunch","hang clean","hack squat","flutter kicks"};
        String otherList[]={"frog hops ","foot smr","hip circles","adductor-groin","ankle circles","arm circles",
        "ankle on the knee","back flies","band pull aparts","elbow circles","elbows to back","external rotation",
                "front cone hops","hurdle hops","jogging-light","jogging-medium"};
        if((place.equalsIgnoreCase("gym"))&&(complexity.equalsIgnoreCase("advanced")))
        {
            for(int i=0;i<exCount;i++){
                listDataHeader.add(gymAdvanced[i]);
                listDataChild.put(gymAdvanced[i],"youtube link");
        }
        }else{
            for(int i=0;i<exCount;i++){
            listDataHeader.add(otherList[i]);
            listDataChild.put(otherList[i],"youtube link");
        }
    }

        //listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        //listDataChild.put(listDataHeader.get(1), nowShowing);
        //listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}