package com.example.rishni.optio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewProfile extends AppCompatActivity {

    TextView currentWeight;
    TextView currentHeight;
    TextView name;
    TextView playedSince;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        currentWeight = (TextView)findViewById(R.id.textViewCWeight);
        currentHeight = (TextView)findViewById(R.id.textViewCHeight);
        name = (TextView)findViewById(R.id.textViewAthleteName);
        playedSince = (TextView)findViewById(R.id.textViewMemberSince);
        currentHeight.setText(preferences.getString("AthleteHeight",null));
        name.setText(preferences.getString("AthleteName",null));
        playedSince.setText(preferences.getString("AthletePlayedSince",null));
        currentWeight.setText(preferences.getString("AthleteWeight",null));
    }
}
