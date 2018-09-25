package com.example.rishni.optio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rishni.optio.model.ChildWorkout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkoutHome extends AppCompatActivity implements View.OnClickListener {

    Button workoutBtn;
    Button trainingBtn;
    int age = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_home);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        String athleteDob = preferences.getString("AthleteDob",null);
        Calendar cal = Calendar.getInstance();
        try {
            Date birth = new SimpleDateFormat("yyyy-mm-dd").parse(athleteDob);
            cal.setTime(birth);
            int birthYear = cal.get(Calendar.YEAR);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            age = currentYear - birthYear;

        }
        catch(ParseException e){
            e.printStackTrace();
        }
        workoutBtn = (Button)findViewById(R.id.workoutBtn);
        workoutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.workoutBtn:
                if(age>16){
                    Intent intent = new Intent(WorkoutHome.this,WorkOutOptions.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(WorkoutHome.this,ChildWorkout.class);
                    startActivity(intent);
                }
                break;

        }
    }
}
