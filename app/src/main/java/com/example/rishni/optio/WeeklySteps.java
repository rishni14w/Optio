package com.example.rishni.optio;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WeeklySteps extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_steps);
        Button buttonDate = findViewById(R.id.buttonPickDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker(view);
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = new GregorianCalendar(i,i1,i2);
        setDate(calendar);
    }
    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        //Toast.makeText(this,"Selected Date: "+dateFormat.format(calendar.getTime()),Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,ExerciseSteps.class);
        String datePicked = dateFormat.format(calendar.getTime());
        i.putExtra("Picked_Date",datePicked);
        startActivity(i);
    }
    public void datePicker(View view){

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getFragmentManager(),"datePicker");
    }
}
