package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StressAndHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
