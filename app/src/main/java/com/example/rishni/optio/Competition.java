package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Competition extends AppCompatActivity {

    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/competition";

    String date;
    String nic;

    int responseCode;
    private RadioButton stroke_radio1,stroke_radio2,spectator_radio1,spectator_radio2,env_radio1,env_radio2,cold_radio1,cold_radio2,away_radio1,away_radio2;
    private String stroke,spectator,env,cold,away;

    private CheckBox stroke_reason1,stroke_reason2;
    private String stroke_reason1_s,stroke_reason2_s;


    private String difficulties_reason1_s,difficulties_reason2_s,difficulties_reason3_s,difficulties_reason4_s;


    private String gamePlan_reason1_s,gamePlan_reason2_s,gamePlan_reason3_s;


    private String score_reason1_s,score_reason2_s,score_reason3_s,score_reason4_s,score_reason5_s,score_reason6_s,score_reason7_s;


    private String opponent_reason1_s,opponent_reason2_s,opponent_reason3_s,opponent_reason4_s,opponent_reason5_s;


    private String referee_reason1_s,referee_reason2_s,referee_reason3_s,referee_reason4_s,referee_reason5_s;


    private String spectator_reason1_s,spectator_reason2_s,spectator_reason3_s,spectator_reason4_s;

    private CheckBox env_reason1,env_reason2,env_reason3,env_reason4,env_reason5,env_reason6,env_reason7,env_reason8;
    private String env_reason1_s,env_reason2_s,env_reason3_s,env_reason4_s,env_reason5_s,env_reason6_s,env_reason7_s,env_reason8_s;


    private String cold_reason1_s,cold_reason2_s,cold_reason3_s,cold_reason4_s;

    private CheckBox away_reason1,away_reason2,away_reason3,away_reason4;
    private String away_reason1_s,away_reason2_s,away_reason3_s,away_reason4_s;

    //arraylists
    private ArrayList<String> stroke_reason_Arr;
    private ArrayList<String> difficulties_Arr;
    private ArrayList<String> gamePlan_Arr;
    private ArrayList<String> score_Arr;
    private ArrayList<String> opponent_Arr;
    private ArrayList<String> referee_Arr;
    private ArrayList<String> spectator_reason_Arr;
    private ArrayList<String> env_reason_Arr;
    private ArrayList<String> cold_reason_Arr;
    private ArrayList<String> away_reason_Arr;

    //jsonArray
    JSONArray jsonArray_stroke_reason;
    JSONArray jsonArray_difficulties;
    JSONArray jsonArray_gamePlan;
    JSONArray jsonArray_score;
    JSONArray jsonArray_opponent;
    JSONArray jsonArray_referee;
    JSONArray jsonArray_spectator_reason;
    JSONArray jsonArray_env_reason;
    JSONArray jsonArray_cold_reason;
    JSONArray jsonArray_away_reason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);
        setTitle(R.string.competition_Title);

        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("AthletePref",0);
        nic=sharedPref.getString("AthleteNic","");

        //radio button
        stroke_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_CS1);
        stroke_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_CS1);

        spectator_radio1=(RadioButton)findViewById(R.id.radioButton1_Q3_CS2);
        spectator_radio2=(RadioButton)findViewById(R.id.radioButton2_Q3_CS2);

        env_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_CS3);
        env_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_CS3);

        cold_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_CS3);
        cold_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_CS3);

        away_radio1=(RadioButton)findViewById(R.id.radioButton1_Q3_CS3);
        away_radio2=(RadioButton)findViewById(R.id.radioButton2_Q3_CS3);


        stroke_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q1_CS1)
                {
                    TextView radio_yes_CS1_Q1=findViewById(R.id.reason_CS1_Q1_tv);
                    TextView reason_1_CS1_Q1=findViewById(R.id.Reason_1_CS1_Q1_checkBox);
                    TextView reason_2_CS1_Q1=findViewById(R.id.Reason_2_CS1_Q1_checkBox);
                    radio_yes_CS1_Q1.setVisibility(View.VISIBLE);
                    reason_1_CS1_Q1.setVisibility(View.VISIBLE);
                    reason_2_CS1_Q1.setVisibility(View.VISIBLE);
                }
                stroke=stroke_radio1.getText().toString();
            }
        });

        stroke_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q1_CS1)
                {
                    TextView radio_yes_CS1_Q1=findViewById(R.id.reason_CS1_Q1_tv);
                    TextView reason_1_CS1_Q1=findViewById(R.id.Reason_1_CS1_Q1_checkBox);
                    TextView reason_2_CS1_Q1=findViewById(R.id.Reason_2_CS1_Q1_checkBox);
                    radio_yes_CS1_Q1.setVisibility(View.GONE);
                    reason_1_CS1_Q1.setVisibility(View.GONE);
                    reason_2_CS1_Q1.setVisibility(View.GONE);
                }
                stroke=stroke_radio2.getText().toString();
            }
        });


        spectator_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q3_CS2)
                {
                    TextView radio_yes_CS2_Q3=findViewById(R.id.reason_CS2_Q3_tv);
                    TextView answer_1_CS2_Q3=findViewById(R.id.Answer_1_CS2_Q3_checkBox);
                    TextView answer_2_CS2_Q3=findViewById(R.id.Answer_2_CS2_Q3_checkBox);
                    TextView answer_3_CS2_Q3=findViewById(R.id.Answer_3_CS2_Q3_checkBox);
                    TextView answer_4_CS2_Q3=findViewById(R.id.Answer_4_CS2_Q3_checkBox);
                    radio_yes_CS2_Q3.setVisibility(View.VISIBLE);
                    answer_1_CS2_Q3.setVisibility(View.VISIBLE);
                    answer_2_CS2_Q3.setVisibility(View.VISIBLE);
                    answer_3_CS2_Q3.setVisibility(View.VISIBLE);
                    answer_4_CS2_Q3.setVisibility(View.VISIBLE);
                }
                spectator=spectator_radio1.getText().toString();
            }
        });

        spectator_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q3_CS2)
                {
                    TextView radio_yes_CS2_Q3=findViewById(R.id.reason_CS2_Q3_tv);
                    TextView answer_1_CS2_Q3=findViewById(R.id.Answer_1_CS2_Q3_checkBox);
                    TextView answer_2_CS2_Q3=findViewById(R.id.Answer_2_CS2_Q3_checkBox);
                    TextView answer_3_CS2_Q3=findViewById(R.id.Answer_3_CS2_Q3_checkBox);
                    TextView answer_4_CS2_Q3=findViewById(R.id.Answer_4_CS2_Q3_checkBox);
                    radio_yes_CS2_Q3.setVisibility(View.GONE);
                    answer_1_CS2_Q3.setVisibility(View.GONE);
                    answer_2_CS2_Q3.setVisibility(View.GONE);
                    answer_3_CS2_Q3.setVisibility(View.GONE);
                    answer_4_CS2_Q3.setVisibility(View.GONE);
                }
                spectator=spectator_radio2.getText().toString();
            }
        });

        env_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q1_CS3)
                {
                    TextView radio_yes_CS3_Q1=findViewById(R.id.reason_CS3_Q1_tv);
                    TextView answer_1_CS3_Q1=findViewById(R.id.Answer_1_CS3_Q1_checkBox);
                    TextView answer_2_CS3_Q1=findViewById(R.id.Answer_2_CS3_Q1_checkBox);
                    TextView answer_3_CS3_Q1=findViewById(R.id.Answer_3_CS3_Q1_checkBox);
                    TextView answer_4_CS3_Q1=findViewById(R.id.Answer_4_CS3_Q1_checkBox);
                    TextView answer_5_CS3_Q1=findViewById(R.id.Answer_5_CS3_Q1_checkBox);
                    TextView answer_6_CS3_Q1=findViewById(R.id.Answer_6_CS3_Q1_checkBox);
                    TextView answer_7_CS3_Q1=findViewById(R.id.Answer_7_CS3_Q1_checkBox);
                    TextView answer_8_CS3_Q1=findViewById(R.id.Answer_8_CS3_Q1_checkBox);
                    radio_yes_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_1_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_2_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_3_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_4_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_5_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_6_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_7_CS3_Q1.setVisibility(View.VISIBLE);
                    answer_8_CS3_Q1.setVisibility(View.VISIBLE);
                }
                env=env_radio1.getText().toString();
            }
        });

        env_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q1_CS3)
                {
                    TextView radio_yes_CS3_Q1=findViewById(R.id.reason_CS3_Q1_tv);
                    TextView answer_1_CS3_Q1=findViewById(R.id.Answer_1_CS3_Q1_checkBox);
                    TextView answer_2_CS3_Q1=findViewById(R.id.Answer_2_CS3_Q1_checkBox);
                    TextView answer_3_CS3_Q1=findViewById(R.id.Answer_3_CS3_Q1_checkBox);
                    TextView answer_4_CS3_Q1=findViewById(R.id.Answer_4_CS3_Q1_checkBox);
                    TextView answer_5_CS3_Q1=findViewById(R.id.Answer_5_CS3_Q1_checkBox);
                    TextView answer_6_CS3_Q1=findViewById(R.id.Answer_6_CS3_Q1_checkBox);
                    TextView answer_7_CS3_Q1=findViewById(R.id.Answer_7_CS3_Q1_checkBox);
                    TextView answer_8_CS3_Q1=findViewById(R.id.Answer_8_CS3_Q1_checkBox);
                    radio_yes_CS3_Q1.setVisibility(View.GONE);
                    answer_1_CS3_Q1.setVisibility(View.GONE);
                    answer_2_CS3_Q1.setVisibility(View.GONE);
                    answer_3_CS3_Q1.setVisibility(View.GONE);
                    answer_4_CS3_Q1.setVisibility(View.GONE);
                    answer_5_CS3_Q1.setVisibility(View.GONE);
                    answer_6_CS3_Q1.setVisibility(View.GONE);
                    answer_7_CS3_Q1.setVisibility(View.GONE);
                    answer_8_CS3_Q1.setVisibility(View.GONE);
                }
                env=env_radio2.getText().toString();
            }
        });

        cold_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q2_CS3)
                {
                    TextView radio_yes_CS3_Q2=findViewById(R.id.reason_CS3_Q2_tv);
                    TextView reason_1_CS3_Q2=findViewById(R.id.Reason_1_CS3_Q2_checkBox);
                    TextView reason_2_CS3_Q2=findViewById(R.id.Reason_2_CS3_Q2_checkBox);
                    TextView reason_3_CS3_Q2=findViewById(R.id.Reason_3_CS3_Q2_checkBox);
                    TextView reason_4_CS3_Q2=findViewById(R.id.Reason_4_CS3_Q2_checkBox);
                    radio_yes_CS3_Q2.setVisibility(View.VISIBLE);
                    reason_1_CS3_Q2.setVisibility(View.VISIBLE);
                    reason_2_CS3_Q2.setVisibility(View.VISIBLE);
                    reason_3_CS3_Q2.setVisibility(View.VISIBLE);
                    reason_4_CS3_Q2.setVisibility(View.VISIBLE);
                }
                cold=cold_radio1.getText().toString();
            }
        });

        cold_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q2_CS3)
                {
                    TextView radio_yes_CS3_Q2=findViewById(R.id.reason_CS3_Q2_tv);
                    TextView reason_1_CS3_Q2=findViewById(R.id.Reason_1_CS3_Q2_checkBox);
                    TextView reason_2_CS3_Q2=findViewById(R.id.Reason_2_CS3_Q2_checkBox);
                    TextView reason_3_CS3_Q2=findViewById(R.id.Reason_3_CS3_Q2_checkBox);
                    TextView reason_4_CS3_Q2=findViewById(R.id.Reason_4_CS3_Q2_checkBox);
                    radio_yes_CS3_Q2.setVisibility(View.GONE);
                    reason_1_CS3_Q2.setVisibility(View.GONE);
                    reason_2_CS3_Q2.setVisibility(View.GONE);
                    reason_3_CS3_Q2.setVisibility(View.GONE);
                    reason_4_CS3_Q2.setVisibility(View.GONE);
                }
                cold=cold_radio2.getText().toString();
            }
        });

        away_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q3_CS3)
                {
                    TextView radio_yes_CS3_Q3=findViewById(R.id.reason_CS3_Q3_tv);
                    TextView reason_1_CS3_Q3=findViewById(R.id.Reason_1_CS3_Q3_checkBox);
                    TextView reason_2_CS3_Q3=findViewById(R.id.Reason_2_CS3_Q3_checkBox);
                    TextView reason_3_CS3_Q3=findViewById(R.id.Reason_3_CS3_Q3_checkBox);
                    TextView reason_4_CS3_Q3=findViewById(R.id.Reason_4_CS3_Q3_checkBox);
                    radio_yes_CS3_Q3.setVisibility(View.VISIBLE);
                    reason_1_CS3_Q3.setVisibility(View.VISIBLE);
                    reason_2_CS3_Q3.setVisibility(View.VISIBLE);
                    reason_3_CS3_Q3.setVisibility(View.VISIBLE);
                    reason_4_CS3_Q3.setVisibility(View.VISIBLE);
                }
                away=away_radio1.getText().toString();
            }
        });

        away_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q3_CS3)
                {
                    TextView radio_yes_CS3_Q3=findViewById(R.id.reason_CS3_Q3_tv);
                    TextView reason_1_CS3_Q3=findViewById(R.id.Reason_1_CS3_Q3_checkBox);
                    TextView reason_2_CS3_Q3=findViewById(R.id.Reason_2_CS3_Q3_checkBox);
                    TextView reason_3_CS3_Q3=findViewById(R.id.Reason_3_CS3_Q3_checkBox);
                    TextView reason_4_CS3_Q3=findViewById(R.id.Reason_4_CS3_Q3_checkBox);
                    radio_yes_CS3_Q3.setVisibility(View.GONE);
                    reason_1_CS3_Q3.setVisibility(View.GONE);
                    reason_2_CS3_Q3.setVisibility(View.GONE);
                    reason_3_CS3_Q3.setVisibility(View.GONE);
                    reason_4_CS3_Q3.setVisibility(View.GONE);
                }
                away=away_radio2.getText().toString();
            }
        });

        //checkbox
        //stroke
        stroke_reason1=(CheckBox)findViewById(R.id.Reason_1_CS1_Q1_checkBox);
        stroke_reason2=(CheckBox)findViewById(R.id.Reason_2_CS1_Q1_checkBox);

        stroke_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stroke_reason1.isChecked())
                {
                    stroke_reason1_s=stroke_reason1.getText().toString();
                }
                else
                {
                    stroke_reason1_s=null;
                }

            }
        });

        stroke_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stroke_reason2.isChecked())
                {
                    stroke_reason2_s=stroke_reason2.getText().toString();
                }
                else
                {
                    stroke_reason2_s=null;
                }

            }
        });

        //env
        env_reason1=(CheckBox)findViewById(R.id.Answer_1_CS3_Q1_checkBox);
        env_reason2=(CheckBox)findViewById(R.id.Answer_2_CS3_Q1_checkBox);
        env_reason3=(CheckBox)findViewById(R.id.Answer_3_CS3_Q1_checkBox);
        env_reason4=(CheckBox)findViewById(R.id.Answer_4_CS3_Q1_checkBox);
        env_reason5=(CheckBox)findViewById(R.id.Answer_5_CS3_Q1_checkBox);
        env_reason6=(CheckBox)findViewById(R.id.Answer_6_CS3_Q1_checkBox);
        env_reason7=(CheckBox)findViewById(R.id.Answer_7_CS3_Q1_checkBox);
        env_reason8=(CheckBox)findViewById(R.id.Answer_8_CS3_Q1_checkBox);

        env_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason1.isChecked())
                {
                    env_reason1_s=env_reason1.getText().toString();
                }
                else
                {
                    env_reason1_s=null;
                }

            }
        });

        env_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason2.isChecked())
                {
                    env_reason2_s=env_reason2.getText().toString();
                }
                else
                {
                    env_reason2_s=null;
                }

            }
        });

        env_reason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason3.isChecked())
                {
                    env_reason3_s=env_reason3.getText().toString();
                }
                else
                {
                    env_reason3_s=null;
                }

            }
        });

        env_reason4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason4.isChecked())
                {
                    env_reason4_s=env_reason4.getText().toString();
                }
                else
                {
                    env_reason4_s=null;
                }

            }
        });

        env_reason5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason5.isChecked())
                {
                    env_reason5_s=env_reason5.getText().toString();
                }
                else
                {
                    env_reason5_s=null;
                }

            }
        });

        env_reason6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason6.isChecked())
                {
                    env_reason6_s=env_reason6.getText().toString();
                }
                else
                {
                    env_reason6_s=null;
                }

            }
        });

        env_reason7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason7.isChecked())
                {
                    env_reason7_s=env_reason7.getText().toString();
                }
                else
                {
                    env_reason7_s=null;
                }

            }
        });

        env_reason8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(env_reason8.isChecked())
                {
                    env_reason8_s=env_reason8.getText().toString();
                }
                else
                {
                    env_reason8_s=null;
                }

            }
        });

        //away
        away_reason1=(CheckBox)findViewById(R.id.Reason_1_CS3_Q3_checkBox);
        away_reason2=(CheckBox)findViewById(R.id.Reason_2_CS3_Q3_checkBox);
        away_reason3=(CheckBox)findViewById(R.id.Reason_3_CS3_Q3_checkBox);
        away_reason4=(CheckBox)findViewById(R.id.Reason_4_CS3_Q3_checkBox);

        away_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(away_reason1.isChecked())
                {
                    away_reason1_s=away_reason1.getText().toString();
                }
                else
                {
                    away_reason1_s=null;
                }

            }
        });

        away_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(away_reason2.isChecked())
                {
                    away_reason2_s=away_reason2.getText().toString();
                }
                else
                {
                    away_reason2_s=null;
                }

            }
        });

        away_reason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(away_reason3.isChecked())
                {
                    away_reason3_s=away_reason3.getText().toString();
                }
                else
                {
                    away_reason3_s=null;
                }

            }
        });

        away_reason4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(away_reason4.isChecked())
                {
                    away_reason4_s=away_reason4.getText().toString();
                }
                else
                {
                    away_reason4_s=null;
                }

            }
        });

    }

    //difficulties checkbox
    public void noneClicked_CS1_Q2(View view)
    {
        if(view.getId()==R.id.Answer_4_CS1_Q2_checkBox) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS1_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS1_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS1_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS1_Q2_checkBox);
            if(chk4.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                difficulties_reason4_s=chk4.getText().toString();

                difficulties_reason1_s=null;
                difficulties_reason2_s=null;
                difficulties_reason3_s=null;
            }

        }

    }

    public void checkboxClicked_CS1_Q2(View view)
    {
        if((view.getId()==R.id.Answer_1_CS1_Q2_checkBox)||(view.getId()==R.id.Answer_2_CS1_Q2_checkBox)||(view.getId()==R.id.Answer_3_CS1_Q2_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS1_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS1_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS1_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS1_Q2_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked())
            {
                chk4.setChecked(false);
                difficulties_reason4_s=null;
                if(chk1.isChecked())
                {
                    difficulties_reason1_s=chk1.getText().toString();
                }
                if(chk2.isChecked())
                {
                    difficulties_reason2_s=chk2.getText().toString();
                }
                if(chk3.isChecked())
                {
                    difficulties_reason3_s=chk3.getText().toString();
                }

                if(!chk1.isChecked())
                {
                    difficulties_reason1_s=null;
                }
                if(!chk2.isChecked())
                {
                    difficulties_reason2_s=null;
                }
                if(!chk3.isChecked())
                {
                    difficulties_reason3_s=null;
                }
            }
        }

    }

    //gameplan checkbox
    public void noneClicked_CS1_Q3(View view)
    {
        if(view.getId()==R.id.Answer_3_CS1_Q3_checkBox) {
            CheckBox chk1,chk2,chk3;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS1_Q3_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS1_Q3_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS1_Q3_checkBox);
            if(chk3.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                gamePlan_reason3_s=chk3.getText().toString();
                gamePlan_reason1_s=null;
                gamePlan_reason2_s=null;
            }

        }

    }

    public void checkboxClicked_CS1_Q3(View view)
    {
        if((view.getId()==R.id.Answer_1_CS1_Q3_checkBox)||(view.getId()==R.id.Answer_2_CS1_Q3_checkBox)||(view.getId()==R.id.Answer_3_CS1_Q3_checkBox)) {
            CheckBox chk1,chk2,chk3;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS1_Q3_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS1_Q3_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS1_Q3_checkBox);

            if(chk1.isChecked()||chk2.isChecked())
            {
                chk3.setChecked(false);
                gamePlan_reason3_s=null;
                if(chk1.isChecked())
                {
                    gamePlan_reason1_s=chk1.getText().toString();
                }
                if(chk2.isChecked())
                {
                    gamePlan_reason2_s=chk2.getText().toString();
                }


                if(!chk1.isChecked())
                {
                    gamePlan_reason1_s=null;
                }
                if(!chk2.isChecked())
                {
                    gamePlan_reason2_s=null;
                }
            }
        }

    }

    //game score checkbox
    public void noneClicked_CS1_Q4(View view)
    {
        if(view.getId()==R.id.Answer_7_CS1_Q4_checkBox) {
            CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS1_Q4_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS1_Q4_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS1_Q4_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS1_Q4_checkBox);
            chk5=(CheckBox)findViewById(R.id.Answer_5_CS1_Q4_checkBox);
            chk6=(CheckBox)findViewById(R.id.Answer_6_CS1_Q4_checkBox);
            chk7=(CheckBox)findViewById(R.id.Answer_7_CS1_Q4_checkBox);
            if(chk7.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                score_reason7_s=chk7.getText().toString();
                score_reason1_s=null;
                score_reason2_s=null;
                score_reason3_s=null;
                score_reason4_s=null;
                score_reason5_s=null;
                score_reason6_s=null;
            }

        }

    }

    public void checkboxClicked_CS1_Q4(View view)
    {
        if((view.getId()==R.id.Answer_1_CS1_Q4_checkBox)||(view.getId()==R.id.Answer_2_CS1_Q4_checkBox)||(view.getId()==R.id.Answer_3_CS1_Q4_checkBox)||(view.getId()==R.id.Answer_4_CS1_Q4_checkBox)||(view.getId()==R.id.Answer_5_CS1_Q4_checkBox)||(view.getId()==R.id.Answer_6_CS1_Q4_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS1_Q4_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS1_Q4_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS1_Q4_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS1_Q4_checkBox);
            chk5=(CheckBox)findViewById(R.id.Answer_5_CS1_Q4_checkBox);
            chk6=(CheckBox)findViewById(R.id.Answer_6_CS1_Q4_checkBox);
            chk7=(CheckBox)findViewById(R.id.Answer_7_CS1_Q4_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked()||chk4.isChecked()||chk5.isChecked()||chk6.isChecked())
            {
                chk7.setChecked(false);
                score_reason7_s=null;
                if(chk1.isChecked())
                {
                    score_reason1_s=chk1.getText().toString();
                }
                if(chk2.isChecked())
                {
                    score_reason2_s=chk2.getText().toString();
                }
                if(chk3.isChecked())
                {
                    score_reason3_s=chk3.getText().toString();
                }
                if(chk4.isChecked())
                {
                    score_reason4_s=chk4.getText().toString();
                }
                if(chk5.isChecked())
                {
                    score_reason5_s=chk5.getText().toString();
                }
                if(chk6.isChecked())
                {
                    score_reason6_s=chk6.getText().toString();
                }


                if(!chk1.isChecked())
                {
                    score_reason1_s=null;
                }
                if(!chk2.isChecked())
                {
                    score_reason2_s=null;
                }
                if(!chk3.isChecked())
                {
                    score_reason3_s=null;
                }
                if(!chk4.isChecked())
                {
                    score_reason4_s=null;
                }
                if(!chk5.isChecked())
                {
                    score_reason5_s=null;
                }
                if(!chk6.isChecked())
                {
                    score_reason6_s=null;
                }
            }
        }

    }

    //opponent
    public void noneClicked_CS2_Q1(View view)
    {
        if(view.getId()==R.id.Answer_5_CS2_Q1_checkBox) {
            CheckBox chk1,chk2,chk3,chk4,chk5;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS2_Q1_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS2_Q1_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS2_Q1_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS2_Q1_checkBox);
            chk5=(CheckBox)findViewById(R.id.Answer_5_CS2_Q1_checkBox);

            if(chk5.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                opponent_reason5_s=chk5.getText().toString();
                opponent_reason1_s=null;
                opponent_reason2_s=null;
                opponent_reason3_s=null;
                opponent_reason4_s=null;
            }

        }

    }

    public void checkboxClicked_CS2_Q1(View view)
    {
        if((view.getId()==R.id.Answer_1_CS2_Q1_checkBox)||(view.getId()==R.id.Answer_2_CS2_Q1_checkBox)||(view.getId()==R.id.Answer_3_CS2_Q1_checkBox)||(view.getId()==R.id.Answer_4_CS2_Q1_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4,chk5;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS2_Q1_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS2_Q1_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS2_Q1_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS2_Q1_checkBox);
            chk5=(CheckBox)findViewById(R.id.Answer_5_CS2_Q1_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked()||chk4.isChecked())
            {
                chk5.setChecked(false);
                opponent_reason5_s=null;
                if(chk1.isChecked())
                {
                    opponent_reason1_s=chk1.getText().toString();
                }
                if(chk2.isChecked())
                {
                    opponent_reason2_s=chk2.getText().toString();
                }
                if(chk3.isChecked())
                {
                    opponent_reason3_s=chk3.getText().toString();
                }
                if(chk4.isChecked())
                {
                    opponent_reason4_s=chk4.getText().toString();
                }


                if(!chk1.isChecked())
                {
                    opponent_reason1_s=null;
                }
                if(!chk2.isChecked())
                {
                    opponent_reason2_s=null;
                }
                if(!chk3.isChecked())
                {
                    opponent_reason3_s=null;
                }
                if(!chk4.isChecked())
                {
                    opponent_reason4_s=null;
                }
            }
        }

    }


    //referee checkbox
    public void noneClicked_CS2_Q2(View view)
    {
        if(view.getId()==R.id.Answer_5_CS2_Q2_checkBox) {
            CheckBox chk1,chk2,chk3,chk4,chk5;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS2_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS2_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS2_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS2_Q2_checkBox);
            chk5=(CheckBox)findViewById(R.id.Answer_5_CS2_Q2_checkBox);
            if(chk5.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                referee_reason5_s=chk5.getText().toString();
                referee_reason1_s=null;
                referee_reason2_s=null;
                referee_reason3_s=null;
                referee_reason4_s=null;
            }
        }
    }

    public void checkboxClicked_CS2_Q2(View view)
    {
        if((view.getId()==R.id.Answer_1_CS2_Q2_checkBox)||(view.getId()==R.id.Answer_2_CS2_Q2_checkBox)||(view.getId()==R.id.Answer_3_CS2_Q2_checkBox)||(view.getId()==R.id.Answer_4_CS2_Q2_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4,chk5;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS2_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS2_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS2_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS2_Q2_checkBox);
            chk5=(CheckBox)findViewById(R.id.Answer_5_CS2_Q2_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked()||chk4.isChecked()||chk5.isChecked())
            {
                chk5.setChecked(false);
                referee_reason5_s=null;
                if(chk1.isChecked())
                {
                    referee_reason1_s=chk1.getText().toString();
                }
                if(chk2.isChecked())
                {
                    referee_reason2_s=chk2.getText().toString();
                }
                if(chk3.isChecked())
                {
                    referee_reason3_s=chk3.getText().toString();
                }
                if(chk4.isChecked())
                {
                    referee_reason4_s=chk4.getText().toString();
                }


                if(!chk1.isChecked())
                {
                    referee_reason1_s=null;
                }
                if(!chk2.isChecked())
                {
                    referee_reason2_s=null;
                }
                if(!chk3.isChecked())
                {
                    referee_reason3_s=null;
                }
                if(!chk4.isChecked())
                {
                    referee_reason4_s=null;
                }
            }
        }
    }

    //spectator
    public void noneClicked_CS2_Q3(View view)
    {
        if(view.getId()==R.id.Answer_4_CS2_Q3_checkBox) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS2_Q3_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS2_Q3_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS2_Q3_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS2_Q3_checkBox);
            if(chk4.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                spectator_reason4_s=chk4.getText().toString();
                spectator_reason1_s=null;
                spectator_reason2_s=null;
                spectator_reason3_s=null;
            }
        }
    }

    public void checkboxClicked_CS2_Q3(View view)
    {
        if((view.getId()==R.id.Answer_1_CS2_Q3_checkBox)||(view.getId()==R.id.Answer_2_CS2_Q3_checkBox)||(view.getId()==R.id.Answer_3_CS2_Q3_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_CS2_Q3_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_CS2_Q3_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_CS2_Q3_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_CS2_Q3_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked())
            {
                chk4.setChecked(false);
                spectator_reason4_s=null;
                if(chk1.isChecked())
                {
                    spectator_reason1_s=chk1.getText().toString();
                }
                if(chk2.isChecked())
                {
                    spectator_reason2_s=chk2.getText().toString();
                }
                if(chk3.isChecked())
                {
                    spectator_reason3_s=chk3.getText().toString();
                }


                if(!chk1.isChecked())
                {
                    spectator_reason1_s=null;
                }
                if(!chk2.isChecked())
                {
                    spectator_reason2_s=null;
                }
                if(!chk3.isChecked())
                {
                    spectator_reason3_s=null;
                }
            }
        }
    }

    //cold checkbox
    public void noneClicked_CS3_Q2(View view)
    {
        if(view.getId()==R.id.Reason_4_CS3_Q2_checkBox) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Reason_1_CS3_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Reason_2_CS3_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Reason_3_CS3_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Reason_4_CS3_Q2_checkBox);
            if(chk4.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                cold_reason4_s=chk4.getText().toString();
                cold_reason1_s=null;
                cold_reason2_s=null;
                cold_reason3_s=null;
            }
        }
    }

    public void checkboxClicked_CS3_Q2(View view)
    {
        if((view.getId()==R.id.Reason_1_CS3_Q2_checkBox)||(view.getId()==R.id.Reason_2_CS3_Q2_checkBox)||(view.getId()==R.id.Reason_3_CS3_Q2_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Reason_1_CS3_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Reason_2_CS3_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Reason_3_CS3_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Reason_4_CS3_Q2_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked())
            {
                chk4.setChecked(false);
                cold_reason4_s=null;
                if(chk1.isChecked())
                {
                    cold_reason1_s=chk1.getText().toString();
                }
                if(chk2.isChecked())
                {
                    cold_reason2_s=chk2.getText().toString();
                }
                if(chk3.isChecked())
                {
                    cold_reason3_s=chk3.getText().toString();
                }
                if(chk4.isChecked())
                {
                    cold_reason4_s=chk4.getText().toString();
                }


                if(!chk1.isChecked())
                {
                    cold_reason1_s=null;
                }
                if(!chk2.isChecked())
                {
                    cold_reason2_s=null;
                }
                if(!chk3.isChecked())
                {
                    cold_reason3_s=null;
                }
                if(!chk4.isChecked())
                {
                    cold_reason4_s=null;
                }
            }
        }
    }



    public void submit_competition(View view)
    {
        if (view.getId()==R.id.submit_competition_btn)
        {
            //adding values to stroke_reason_Arr
            stroke_reason_Arr=new ArrayList<String>();
            stroke_reason_Arr.add(stroke_reason1_s);
            stroke_reason_Arr.add(stroke_reason2_s);

            //adding values to difficulties_Arr
            difficulties_Arr=new ArrayList<String>();
            difficulties_Arr.add(difficulties_reason1_s);
            difficulties_Arr.add(difficulties_reason2_s);
            difficulties_Arr.add(difficulties_reason3_s);
            difficulties_Arr.add(difficulties_reason4_s);

            //adding values to gamePlan_Arr
            gamePlan_Arr=new ArrayList<String>();
            gamePlan_Arr.add(gamePlan_reason1_s);
            gamePlan_Arr.add(gamePlan_reason2_s);
            gamePlan_Arr.add(gamePlan_reason3_s);

            //adding values to score_Arr
            score_Arr=new ArrayList<String>();
            score_Arr.add(score_reason1_s);
            score_Arr.add(score_reason2_s);
            score_Arr.add(score_reason3_s);
            score_Arr.add(score_reason4_s);
            score_Arr.add(score_reason5_s);
            score_Arr.add(score_reason6_s);
            score_Arr.add(score_reason7_s);

            //adding values to opponent_Arr
            opponent_Arr=new ArrayList<String>();
            opponent_Arr.add(opponent_reason1_s);
            opponent_Arr.add(opponent_reason2_s);
            opponent_Arr.add(opponent_reason3_s);
            opponent_Arr.add(opponent_reason4_s);
            opponent_Arr.add(opponent_reason5_s);

            //adding values to referee_Arr
            referee_Arr=new ArrayList<String>();
            referee_Arr.add(referee_reason1_s);
            referee_Arr.add(referee_reason2_s);
            referee_Arr.add(referee_reason3_s);
            referee_Arr.add(referee_reason4_s);
            referee_Arr.add(referee_reason5_s);

            //adding values to spectator_reason_Arr
            spectator_reason_Arr=new ArrayList<String>();
            spectator_reason_Arr.add(spectator_reason1_s);
            spectator_reason_Arr.add(spectator_reason2_s);
            spectator_reason_Arr.add(spectator_reason3_s);
            spectator_reason_Arr.add(spectator_reason4_s);

            //adding values to env_reason_Arr
            env_reason_Arr=new ArrayList<String>();
            env_reason_Arr.add(env_reason1_s);
            env_reason_Arr.add(env_reason2_s);
            env_reason_Arr.add(env_reason3_s);
            env_reason_Arr.add(env_reason4_s);
            env_reason_Arr.add(env_reason5_s);
            env_reason_Arr.add(env_reason6_s);
            env_reason_Arr.add(env_reason7_s);
            env_reason_Arr.add(env_reason8_s);

            //adding values to cold_reason_Arr
            cold_reason_Arr=new ArrayList<String>();
            cold_reason_Arr.add(cold_reason1_s);
            cold_reason_Arr.add(cold_reason2_s);
            cold_reason_Arr.add(cold_reason3_s);
            cold_reason_Arr.add(cold_reason4_s);

            //adding values to away_reason_Arr
            away_reason_Arr=new ArrayList<String>();
            away_reason_Arr.add(away_reason1_s);
            away_reason_Arr.add(away_reason2_s);
            away_reason_Arr.add(away_reason3_s);
            away_reason_Arr.add(away_reason4_s);

            jsonArray_stroke_reason=new JSONArray(stroke_reason_Arr);
            jsonArray_difficulties=new JSONArray(difficulties_Arr);
            jsonArray_gamePlan=new JSONArray(gamePlan_Arr);
            jsonArray_score=new JSONArray(score_Arr);
            jsonArray_opponent=new JSONArray(opponent_Arr);
            jsonArray_referee=new JSONArray(referee_Arr);
            jsonArray_spectator_reason=new JSONArray(spectator_reason_Arr);
            jsonArray_env_reason=new JSONArray(env_reason_Arr);
            jsonArray_cold_reason=new JSONArray(cold_reason_Arr);
            jsonArray_away_reason=new JSONArray(away_reason_Arr);

            // new PostData(stroke,stroke_reason1_s,stroke_reason2_s,difficulties_reason1_s,difficulties_reason2_s,difficulties_reason3_s,difficulties_reason4_s,gamePlan_reason1_s,gamePlan_reason2_s,gamePlan_reason3_s,score_reason1_s,score_reason2_s,score_reason3_s,score_reason4_s,score_reason5_s,score_reason6_s,score_reason7_s,opponent_reason1_s,opponent_reason2_s,opponent_reason3_s,opponent_reason4_s,opponent_reason5_s,referee_reason1_s,referee_reason2_s,referee_reason3_s,referee_reason4_s,referee_reason5_s,spectator,spectator_reason1_s,spectator_reason2_s,spectator_reason3_s,spectator_reason4_s,env,env_reason1_s,env_reason2_s,env_reason3_s,env_reason4_s,env_reason5_s,env_reason6_s,env_reason7_s,env_reason8_s,cold,cold_reason1_s,cold_reason2_s,cold_reason3_s,cold_reason4_s,away,away_reason1_s,away_reason2_s,away_reason3_s,away_reason4_s).execute(db.getAddressAPI_Competition());
            Date currentTime= Calendar.getInstance().getTime();
            date=currentTime.toString();

            new SendData().execute();
        }

    }


    //function to add new competition
    /**class PostData extends AsyncTask<String,String,String> {
     private String Stroke,Stroke_reason1_s,Stroke_reason2_s,Difficulties_reason1_s,Difficulties_reason2_s,Difficulties_reason3_s,Difficulties_reason4_s;
     private String GamePlan_reason1_s,GamePlan_reason2_s,GamePlan_reason3_s,Score_reason1_s,Score_reason2_s;
     private String Score_reason3_s,Score_reason4_s,Score_reason5_s,Score_reason6_s,Score_reason7_s,Opponent_reason1_s;
     private String Opponent_reason2_s,Opponent_reason3_s,Opponent_reason4_s,Opponent_reason5_s,Referee_reason1_s;
     private String Referee_reason2_s,Referee_reason3_s,Referee_reason4_s,Referee_reason5_s,Spectator,Spectator_reason1_s;
     private String Spectator_reason2_s,Spectator_reason3_s,Spectator_reason4_s,Env,Env_reason1_s,Env_reason2_s,Env_reason3_s;
     private String Env_reason4_s,Env_reason5_s,Env_reason6_s,Env_reason7_s,Env_reason8_s,Cold,Cold_reason1_s,Cold_reason2_s;
     private String Cold_reason3_s,Cold_reason4_s,Away,Away_reason1_s,Away_reason2_s,Away_reason3_s,Away_reason4_s;

     public PostData(String stroke, String stroke_reason1_s, String stroke_reason2_s, String difficulties_reason1_s, String difficulties_reason2_s, String difficulties_reason3_s, String difficulties_reason4_s, String gamePlan_reason1_s, String gamePlan_reason2_s, String gamePlan_reason3_s, String score_reason1_s, String score_reason2_s, String score_reason3_s, String score_reason4_s, String score_reason5_s, String score_reason6_s, String score_reason7_s, String opponent_reason1_s, String opponent_reason2_s, String opponent_reason3_s, String opponent_reason4_s, String opponent_reason5_s, String referee_reason1_s, String referee_reason2_s, String referee_reason3_s, String referee_reason4_s, String referee_reason5_s, String spectator, String spectator_reason1_s, String spectator_reason2_s, String spectator_reason3_s, String spectator_reason4_s, String env, String env_reason1_s, String env_reason2_s, String env_reason3_s, String env_reason4_s, String env_reason5_s, String env_reason6_s, String env_reason7_s, String env_reason8_s, String cold, String cold_reason1_s, String cold_reason2_s, String cold_reason3_s, String cold_reason4_s, String away, String away_reason1_s, String away_reason2_s, String away_reason3_s, String away_reason4_s) {
     Stroke = stroke;
     Stroke_reason1_s = stroke_reason1_s;
     Stroke_reason2_s = stroke_reason2_s;
     Difficulties_reason1_s = difficulties_reason1_s;
     Difficulties_reason2_s = difficulties_reason2_s;
     Difficulties_reason3_s = difficulties_reason3_s;
     Difficulties_reason4_s = difficulties_reason4_s;
     GamePlan_reason1_s = gamePlan_reason1_s;
     GamePlan_reason2_s = gamePlan_reason2_s;
     GamePlan_reason3_s = gamePlan_reason3_s;
     Score_reason1_s = score_reason1_s;
     Score_reason2_s = score_reason2_s;
     Score_reason3_s = score_reason3_s;
     Score_reason4_s = score_reason4_s;
     Score_reason5_s = score_reason5_s;
     Score_reason6_s = score_reason6_s;
     Score_reason7_s = score_reason7_s;
     Opponent_reason1_s = opponent_reason1_s;
     Opponent_reason2_s = opponent_reason2_s;
     Opponent_reason3_s = opponent_reason3_s;
     Opponent_reason4_s = opponent_reason4_s;
     Opponent_reason5_s = opponent_reason5_s;
     Referee_reason1_s = referee_reason1_s;
     Referee_reason2_s = referee_reason2_s;
     Referee_reason3_s = referee_reason3_s;
     Referee_reason4_s = referee_reason4_s;
     Referee_reason5_s = referee_reason5_s;
     Spectator = spectator;
     Spectator_reason1_s = spectator_reason1_s;
     Spectator_reason2_s = spectator_reason2_s;
     Spectator_reason3_s = spectator_reason3_s;
     Spectator_reason4_s = spectator_reason4_s;
     Env = env;
     Env_reason1_s = env_reason1_s;
     Env_reason2_s = env_reason2_s;
     Env_reason3_s = env_reason3_s;
     Env_reason4_s = env_reason4_s;
     Env_reason5_s = env_reason5_s;
     Env_reason6_s = env_reason6_s;
     Env_reason7_s = env_reason7_s;
     Env_reason8_s = env_reason8_s;
     Cold = cold;
     Cold_reason1_s = cold_reason1_s;
     Cold_reason2_s = cold_reason2_s;
     Cold_reason3_s = cold_reason3_s;
     Cold_reason4_s = cold_reason4_s;
     Away = away;
     Away_reason1_s = away_reason1_s;
     Away_reason2_s = away_reason2_s;
     Away_reason3_s = away_reason3_s;
     Away_reason4_s = away_reason4_s;
     }

     @Override
     protected void onPreExecute() {
     super.onPreExecute();
     }

     @TargetApi(Build.VERSION_CODES.KITKAT)
     @RequiresApi(api = Build.VERSION_CODES.KITKAT)
     @Override
     protected String doInBackground(String... params) {
     //android.os.Debug.waitForDebugger();
     String urlString = params[0];
     HTTPDataHandler hh = new HTTPDataHandler();

     String json = "{\n";
     json += "\t\"stroke\":\"" + Stroke + "\",\n";
     json += "\t\"stroke_reason\": [\"" + Stroke_reason1_s + "\",\""+Stroke_reason2_s+"\"],\n";
     json += "\t\"difficulties\": [\"" + Difficulties_reason1_s + "\",\""+Difficulties_reason2_s+ "\",\""+Difficulties_reason3_s+ "\",\""+Difficulties_reason4_s+"\"],\n";
     json += "\t\"gamePlan\": [\"" + GamePlan_reason1_s + "\",\""+GamePlan_reason2_s+ "\",\""+GamePlan_reason3_s+ "\"],\n";
     json += "\t\"score\": [\"" + Score_reason1_s + "\",\""+Score_reason2_s+ "\",\""+Score_reason3_s+ "\",\""+Score_reason4_s+ "\",\""+Score_reason5_s+ "\",\""+Score_reason6_s+ "\",\""+Score_reason7_s+"\"],\n";
     json += "\t\"opponent\": [\"" + Opponent_reason1_s + "\",\""+Opponent_reason2_s+ "\",\""+Opponent_reason3_s+ "\",\""+Opponent_reason4_s+ "\",\""+Opponent_reason5_s+"\"],\n";
     json += "\t\"referee\": [\"" + Referee_reason1_s + "\",\""+Referee_reason2_s+ "\",\""+Referee_reason3_s+ "\",\""+Referee_reason4_s+ "\",\""+Referee_reason5_s+"\"],\n";
     json += "\t\"spectator\":\"" + Spectator + "\",\n";
     json += "\t\"spectator_reason\": [\"" + Spectator_reason1_s + "\",\""+Spectator_reason2_s+ "\",\""+Spectator_reason3_s+ "\",\""+Spectator_reason4_s+"\"],\n";
     json += "\t\"env\":\"" + Env + "\",\n";
     json += "\t\"env_reason\": [\"" + Env_reason1_s + "\",\""+Env_reason2_s+ "\",\""+Env_reason3_s+ "\",\""+Env_reason4_s+ "\",\""+Env_reason5_s+ "\",\""+Env_reason6_s+ "\",\""+Env_reason7_s+ "\",\""+Env_reason8_s+"\"],\n";
     json += "\t\"cold\":\"" + Cold + "\",\n";
     json += "\t\"cold_reason\": [\"" + Cold_reason1_s + "\",\""+Cold_reason2_s+ "\",\""+Cold_reason3_s+ "\",\""+Cold_reason4_s+"\"],\n";
     json += "\t\"away\":\"" + Away + "\",\n";
     json += "\t\"away_reason\": [\"" + Away_reason1_s + "\",\""+Away_reason2_s+ "\",\""+Away_reason3_s+ "\",\""+Away_reason4_s+"\"],\n";
     json += "}";
     hh.PostHTTPData(urlString, json);
     return "";
     }

     @Override
     protected void onPostExecute(String s) {
     super.onPostExecute(s);
     toastMessage("Successfully submitted");
     Intent intent = new Intent(Competition.this, questionnaire.class);
     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
     startActivity(intent);
     finish();
     }**/

    class SendData extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            doPost();
            return null;
        }

        protected void doPost()
        {
            try{
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.connect();

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("nic",nic);
                jsonParam.put("date",date);
                jsonParam.put("stroke",stroke);
                jsonParam.put("stroke_reason",jsonArray_stroke_reason);
                jsonParam.put("difficulties",jsonArray_difficulties);
                jsonParam.put("gamePlan",jsonArray_gamePlan);
                jsonParam.put("score",jsonArray_score);
                jsonParam.put("opponent",jsonArray_opponent);
                jsonParam.put("referee",jsonArray_referee);
                jsonParam.put("spectator",spectator);
                jsonParam.put("spectator_reason",jsonArray_spectator_reason);
                jsonParam.put("env",env);
                jsonParam.put("env_reason",jsonArray_env_reason);
                jsonParam.put("cold",cold);
                jsonParam.put("cold_reason",jsonArray_cold_reason);
                jsonParam.put("away",away);
                jsonParam.put("away_reason",jsonArray_away_reason);

                conn.getOutputStream();
                try
                {
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    os.writeBytes(jsonParam.toString());

                    os.flush();
                    os.close();
                }catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                Log.i("MSG" , conn.getResponseMessage());

                responseCode=conn.getResponseCode();
                conn.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        protected void onPostExecute(Object object) {
            super.onPostExecute(object);
            if(responseCode==200)
            {
                toastMessage("Successfully saved");
            }
            else {
                toastMessage("Unsuccessfull");
            }

            Intent intent = new Intent(Competition.this, StressAndHealth.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

    }

    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }



}
