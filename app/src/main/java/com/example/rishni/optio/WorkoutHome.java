package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutHome extends AppCompatActivity implements View.OnClickListener {

    Button workoutBtn;
    Button trainingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_home);
        workoutBtn = (Button)findViewById(R.id.workoutBtn);
        workoutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.workoutBtn:
                Intent intent = new Intent(WorkoutHome.this,WorkOutOptions.class);
                startActivity(intent);
                break;

        }
    }
}
