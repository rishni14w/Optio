package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnExercise = findViewById(R.id.buttonExercise);
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,WeeklySteps.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }

    public void clickedstressandhealth(View view)
    {
        if (view.getId()==R.id.StressHealthbtn)
        {
            Intent i= new Intent(MainActivity.this,StressAndHealth.class);
            startActivity(i);
        }else if(view.getId()==R.id.buttonExercise){
            Intent i = new Intent(MainActivity.this,WeeklySteps.class);
            startActivity(i);
        }

    }
}
