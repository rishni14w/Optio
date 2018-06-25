package com.example.rishni.optio;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class ExerciseSteps extends AppCompatActivity {

    TextView datePicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_steps);
        Button weeklyStepsView = (Button)findViewById(R.id.buttonWeekView);
        datePicked = (TextView) findViewById(R.id.textViewSDate);
        weeklyStepsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), WeeklySteps.class);
                startActivity(i);
            }
        });
        Intent i = getIntent();
        if(i.hasExtra("Picked_Date")){

            String pDate = i.getStringExtra("Picked_Date");
            datePicked.setText(pDate);
        }else{
            showData();
        }
    }
    private void showData(){
        Date currentDate = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String formattedDate = dateFormat.format(currentDate);
        datePicked.setText(formattedDate);
    }
}
