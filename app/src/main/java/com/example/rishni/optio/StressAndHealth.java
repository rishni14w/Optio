package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StressAndHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.stressHealth_Title);
        setContentView(R.layout.activity_stress_and_health);
    }

    public void questionnaireClicked(View view)
    {
        if (view.getId()==R.id.questionnaire_btn)
        {
            Intent i= new Intent(this,questionnaire.class);
            startActivity(i);
        }

    }

    public void recommendation_clicked(View view)
    {
        if (view.getId()==R.id.recommendation_btn)
        {
            Intent i= new Intent(this,Recommendation.class);
            startActivity(i);
        }

    }

    public void injury_clicked(View view)
    {
        if (view.getId()==R.id.injury_btn)
        {
            Intent i= new Intent(this,Injury_View.class);
            startActivity(i);
        }

    }

    public void vaccination_clicked(View view)
    {
        if (view.getId()==R.id.vaccination_btn)
        {
            Intent i= new Intent(this,Vaccination_View.class);
            startActivity(i);
        }

    }

    public void heartRate_clicked(View view)
    {
        if (view.getId()==R.id.heartrate_btn)
        {
            Intent i= new Intent(this,HeartRate.class);
            startActivity(i);
        }

    }

    public void bodycomposition_clicked(View view)
    {
        if (view.getId()==R.id.bodycomposition_btn)
        {
            Intent i= new Intent(this,BodyComposition_View.class);
            startActivity(i);
        }

    }

    public void sleep_clicked(View view)
    {
        if (view.getId()==R.id.sleep_btn)
        {
            Intent i= new Intent(this,Sleep.class);
            startActivity(i);
        }

    }
}
