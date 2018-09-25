package com.example.rishni.optio.model;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.rishni.optio.ExpandableListAdapter;
import com.example.rishni.optio.KidExpandableList;
import com.example.rishni.optio.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChildWorkout extends AppCompatActivity {

    KidExpandableList listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, String> listDataChild;
    HashMap<String, String> listVideoUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_workout);
        expListView = (ExpandableListView) findViewById(R.id.lvCExp);
        prepareListData();

        listAdapter = new KidExpandableList(this, listDataHeader, listDataChild);

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
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?"+videoId)));
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
    private void prepareListData() {
        //TODO: Change this to get the data from the server once the semantic web service is hosted
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

        for(int i=0;i<exerciseName.length;i++) {
            listDataHeader.add(exerciseName[i]);
            listDataChild.put(exerciseName[i], "Watch Now");
        }

       //listVideoUrl;



        //listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        //listDataChild.put(listDataHeader.get(1), nowShowing);
        //listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
