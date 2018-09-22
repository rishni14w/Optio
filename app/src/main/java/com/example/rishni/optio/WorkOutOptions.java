package com.example.rishni.optio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkOutOptions extends AppCompatActivity {
    boolean displayEquipment = false;
    RadioGroup placeGroup;
    RadioGroup complexityGroup;
    RadioButton normalComplexityRB;
    RadioButton advancedComplexityRB;
    TextView complexityRecomLbl;
    CheckBox equipmentCheckBox;
    RadioButton placeClicked;
    RadioButton homeRB;
    RadioButton GymRB;
    TextView equipmentLbl;
    TextView fitnessLbl;
    Button navigateToWorkout;
    int currentWeight;
    int currentYear;
    TextView calorieMsg;
    //Todo : Add gender to initial profile front and back
    String gender = "male";
    double caloriesPerMin = 0.0;
    int age = 0;
    //TODO: Change this to read from preference once ML end point is figured out
    int targetWeight = 60;
    double heartRate;
    int joinedYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_options);
        readPreference();
        initView();
        setLabels();
        placeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedButton = (RadioButton)radioGroup.findViewById(i);
                if(checkedButton.getText().toString().equalsIgnoreCase("At home")){
                    equipmentLbl.setVisibility(View.VISIBLE);
                    equipmentCheckBox.setVisibility(View.VISIBLE);
                }else{
                    equipmentLbl.setVisibility(View.INVISIBLE);
                    equipmentCheckBox.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    public void initView(){
        fitnessLbl = (TextView)findViewById(R.id.targetMsgLbl);
        navigateToWorkout = (Button)findViewById(R.id.getExerciseBtn);
        equipmentLbl = (TextView)findViewById(R.id.equipMentLabel);
        equipmentLbl.setVisibility(View.INVISIBLE);
        equipmentCheckBox = (CheckBox)findViewById(R.id.equipmentCheckBox);
        equipmentCheckBox.setVisibility(View.INVISIBLE);
        calorieMsg = (TextView)findViewById(R.id.calorieBurnMsgLbl);
        complexityRecomLbl = (TextView)findViewById(R.id.complexityRecomendationLbl);
        placeGroup = (RadioGroup)findViewById(R.id.radioGroupPlace);
        placeClicked = (RadioButton)placeGroup.findViewById(placeGroup.getCheckedRadioButtonId());


    }
    public void readPreference() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        String prefWeight = preferences.getString("AthleteWeight",null);
        String prefWeightArr[] = prefWeight.split(" ");
        Calendar cal = Calendar.getInstance();
        String athleteDob = preferences.getString("AthleteDob",null);
        String joinedDate =  preferences.getString("AthletePlayedSince",null);
        String jDArr[] = joinedDate.split("-");


        try {
            Date birth = new SimpleDateFormat("yyyy-mm-dd").parse(athleteDob);
            cal.setTime(birth);
            int birthYear = cal.get(Calendar.YEAR);
            currentYear = Calendar.getInstance().get(Calendar.YEAR);
            age = currentYear - birthYear;
            joinedYear = Integer.parseInt(jDArr[0]);
            System.out.println(joinedYear);

        }
        catch(ParseException e){
            e.printStackTrace();
        }
        currentWeight = Integer.parseInt(prefWeightArr[0]);
    }
    public void setLabels(){
        int lowerLimit = targetWeight - 5;
        int upperLimit = targetWeight + 5;
        if((currentWeight>=lowerLimit)&&(currentWeight<=upperLimit)){
            fitnessLbl.setText("You're on your Fitness target! Let's Keep it up!");

        }
        if(currentWeight<lowerLimit){
            fitnessLbl.setText("Let's work to gain some muscles!");
        }
        if(currentWeight>upperLimit){
            fitnessLbl.setText("Let's work to loose that weight!");
        }
        getCalories();
        double totalTime = 1500/caloriesPerMin;
        calorieMsg.setText("You will burn "+caloriesPerMin+", exercising for 1 hour");
        if((currentYear-joinedYear)>=2){
            complexityRecomLbl.setText("We recommend Normal or Advanced");
        }else{
            complexityRecomLbl.setText("We recommend Normal or Advanced");
        }

    }
    public void getCalories(){
        System.out.println("age "+age);
        heartRate = (220-age)*(0.7);

        System.out.println("heart "+heartRate);
        switch (gender){
            case "male":
                caloriesPerMin = ((((age*0.2017)-(currentWeight*0.09036)+ (heartRate * 0.6309)) -55.0969)*60/4.184);
                System.out.println("cpm "+caloriesPerMin);
                break;
            case "female" :
                caloriesPerMin = ((age*0.074)-(currentWeight*0.05741)+(heartRate*0.04472)-20.4022)*1/4.184;
                break;
            default:
                break;
        }
    }
}
