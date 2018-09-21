package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class WorkoutHome extends AppCompatActivity {

    Button workoutBtn;
    Button trainingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_home);
        workoutBtn = (Button)findViewById(R.id.workoutBtn);
        Intent intent = new Intent(WorkoutHome.this,WorkOutOptions.class);
        startActivity(intent);

    }
}
