package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseHome extends AppCompatActivity implements View.OnClickListener {

    private Button profileBtn;
    private Button stepsBtn;
    private Button scheduleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_home);
    }

    private void initView(){
        profileBtn = (Button) findViewById(R.id.buttonProfile);
        stepsBtn = (Button) findViewById(R.id.buttonSteps);
        scheduleBtn = (Button) findViewById(R.id.buttonSchedule);

        profileBtn.setOnClickListener(this);
        stepsBtn.setOnClickListener(this);
        scheduleBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonProfile:{
                Intent i = new Intent(this,ViewProfile.class);
                startActivity(i);
                break;
            }
            case R.id.buttonSteps:{
                Intent i = new Intent(this,ExerciseSteps.class);
                startActivity(i);
                break;
            }
        }

    }
}
