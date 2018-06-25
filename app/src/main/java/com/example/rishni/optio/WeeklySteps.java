package com.example.rishni.optio;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WeeklySteps extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView maximumSteps;
    TextView thisWeek;
    private LineChart lineChart;
    private LineData lineData;
    int[] valArr = new int[7];
    int maximum;
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

        valArr[0]=400;
        valArr[1]=429;
        valArr[2]=345;
        valArr[3]=158;
        valArr[4]=500;
        valArr[5]=400;
        valArr[6]=390;

        //Collections.min(Arrays.asList(valArr));
        maximum = maxValue(valArr);

        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        cal.add(Calendar.DATE, -7);
        Date sevenDaysAgo = cal.getTime();
        String WeekBefore= dateFormat.format(sevenDaysAgo);
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
       // System.out.println("Date = "+ cal.getTime());

        thisWeek = (TextView)findViewById(R.id.textViewWeek);
        maximumSteps = (TextView)findViewById(R.id.textViewMostActiveValue);

        thisWeek.setText(WeekBefore+" to "+formattedDate);
        maximumSteps.setText("Friday");

        lineChart = (com.github.mikephil.charting.charts.LineChart) findViewById(R.id.lineChart);

        lineData = new LineData(getXValues(),getLineDataValue());
        lineChart.setData(lineData);

    }
//TODO : Once the database is working replace the lables with the last seven days
    private ArrayList<String> getXValues() {
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("Mon");
        xValues.add("Tue");
        xValues.add("Wed");
        xValues.add("Thur");
        xValues.add("Fri");
        xValues.add("Sat");
        xValues.add("Sun");
        return xValues;
    }
    //TODO : Get the data from the database and set it to the y axis values
    private List<ILineDataSet> getLineDataValue() {
        ArrayList<ILineDataSet> lineDataSets = null;
        ArrayList<Entry> entryArrayList = new ArrayList<>();

        Entry e1 = new Entry(valArr[0],0);
        Entry e2 = new Entry(valArr[1],1);
        Entry e3 = new Entry(valArr[2],2);
        Entry e4 = new Entry(valArr[3],3);
        Entry e5 = new Entry(valArr[4],4);
        Entry e6 = new Entry(valArr[5],5);
        Entry e7 = new Entry(valArr[6],6);
        entryArrayList.add(e1);
        entryArrayList.add(e2);
        entryArrayList.add(e3);
        entryArrayList.add(e4);
        entryArrayList.add(e5);
        entryArrayList.add(e6);
        entryArrayList.add(e7);
        LineDataSet lineDataSet = new LineDataSet(entryArrayList,"Steps");
        lineDataSets = new ArrayList<>();
        lineDataSets.add(lineDataSet);
        return lineDataSets;
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
    public int maxValue(int array[]){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return Collections.max(list);

    }
}
