package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class questionnaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        setTitle(R.string.questionnaire_Title);
    }

    public void competitionClicked(View view)
    {
        if (view.getId()==R.id.competition_btn)
        {
            Intent i= new Intent(this,Competition.class);
            startActivity(i);
        }

    }

    public void personalConcernClicked(View view)
    {
        if (view.getId()==R.id.personal_btn)
        {
            Intent i= new Intent(this,PersonalLifeConcern.class);
            startActivity(i);
        }

    }

    public void illnessInjuryClicked(View view)
    {
        if (view.getId()==R.id.illness_btn)
        {
            Intent i= new Intent(this,IllnessAndInjuryConcern.class);
            startActivity(i);
        }

    }

    public void FailureIssueClicked(View view)
    {
        if (view.getId()==R.id.failure_btn)
        {
            Intent i= new Intent(this,FailureIssue.class);
            startActivity(i);
        }

    }

    public void psychologicalClicked(View view)
    {
        if (view.getId()==R.id.psychologial_btn)
        {
            Intent i= new Intent(this,PsychologicalDemands.class);
            startActivity(i);
        }

    }
}
