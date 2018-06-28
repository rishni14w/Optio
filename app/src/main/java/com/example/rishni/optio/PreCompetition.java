package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PreCompetition extends AppCompatActivity {
    private RadioButton nervous_radio1,nervous_radio2;
    private RadioButton continuous_radio1,continuous_radio2;
    private RadioButton eve_radio1,eve_radio2,eve_radio3,eve_radio4;
    private RadioButton before_radio1,before_radio2,before_radio3,before_radio4;
    private RadioButton entering_radio1,entering_radio2,entering_radio3,entering_radio4;
    private RadioButton firstSet_radio1,firstSet_radio2,firstSet_radio3,firstSet_radio4;
    private RadioButton strongOpponent_radio1,strongOpponent_radio2;
    private RadioButton lower_rank_radio1,lower_rank_radio2;
    private RadioButton insecure_radio1,insecure_radio2;
    private RadioButton loosing_radio1,loosing_radio2;
    private RadioButton first_round_radio1,first_round_radio2;
    private RadioButton upcoming_radio1,upcoming_radio2;
    private RadioButton input_radio1,input_radio2;
    private RadioButton rude_radio1,rude_radio2;

    private String nervous,continuous,eve,before,entering,firstSet,strongOpponent,lower_rank,insecure,loosing,first_round,upcoming,input,rude;

    private CheckBox strongOpponent_reason1,strongOpponent_reason2,strongOpponent_reason3,strongOpponent_reason4,strongOpponent_reason5;
    private String strongOpponent_reason1_s,strongOpponent_reason2_s,strongOpponent_reason3_s,strongOpponent_reason4_s,strongOpponent_reason5_s;

    private CheckBox upcoming_reason1,upcoming_reason2,upcoming_reason3,upcoming_reason4,upcoming_reason5,upcoming_reason6,upcoming_reason7,upcoming_reason8;
    private String upcoming_reason1_s,upcoming_reason2_s,upcoming_reason3_s,upcoming_reason4_s,upcoming_reason5_s,upcoming_reason6_s,upcoming_reason7_s,upcoming_reason8_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_competition);
        setTitle(R.string.precompetition_Title);

        //radio button
        nervous_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PC_S1);
        nervous_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PC_S1);

        continuous_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_PC_S1);
        continuous_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_PC_S1);

        eve_radio1=(RadioButton)findViewById(R.id.radioButton1_Q3_PC_S1);
        eve_radio2=(RadioButton)findViewById(R.id.radioButton2_Q3_PC_S1);
        eve_radio3=(RadioButton)findViewById(R.id.radioButton3_Q3_PC_S1);
        eve_radio4=(RadioButton)findViewById(R.id.radioButton4_Q3_PC_S1);

        before_radio1=(RadioButton)findViewById(R.id.radioButton1_Q4_PC_S1);
        before_radio2=(RadioButton)findViewById(R.id.radioButton2_Q4_PC_S1);
        before_radio3=(RadioButton)findViewById(R.id.radioButton3_Q4_PC_S1);
        before_radio4=(RadioButton)findViewById(R.id.radioButton4_Q4_PC_S1);

        entering_radio1=(RadioButton)findViewById(R.id.radioButton1_Q5_PC_S1);
        entering_radio2=(RadioButton)findViewById(R.id.radioButton2_Q5_PC_S1);
        entering_radio3=(RadioButton)findViewById(R.id.radioButton3_Q5_PC_S1);
        entering_radio4=(RadioButton)findViewById(R.id.radioButton4_Q5_PC_S1);

        firstSet_radio1=(RadioButton)findViewById(R.id.radioButton1_Q6_PC_S1);
        firstSet_radio2=(RadioButton)findViewById(R.id.radioButton2_Q6_PC_S1);
        firstSet_radio3=(RadioButton)findViewById(R.id.radioButton3_Q6_PC_S1);
        firstSet_radio4=(RadioButton)findViewById(R.id.radioButton4_Q6_PC_S1);

        strongOpponent_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PC_S2);
        strongOpponent_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PC_S2);

        lower_rank_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_PC_S2);
        lower_rank_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_PC_S2);

        insecure_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2a_PC_S2);
        insecure_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2a_PC_S2);

        loosing_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PC_SS1);
        loosing_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PC_SS1);

        first_round_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_PC_SS1);
        first_round_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_PC_SS1);

        upcoming_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PC_SS2);
        upcoming_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PC_SS2);

        input_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PC_SS3);
        input_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PC_SS3);

        rude_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_PC_SS3);
        rude_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_PC_SS3);

        //nervous radio button
        nervous_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nervous=nervous_radio1.getText().toString();
            }
        });

        nervous_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nervous=nervous_radio2.getText().toString();
            }
        });

        //continuous radio button
        continuous_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continuous=continuous_radio1.getText().toString();
            }
        });

        continuous_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continuous=continuous_radio2.getText().toString();
            }
        });

        //eve radio button
        eve_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eve=eve_radio1.getText().toString();
            }
        });

        eve_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eve=eve_radio2.getText().toString();
            }
        });

        eve_radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eve=eve_radio3.getText().toString();
            }
        });

        eve_radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eve=eve_radio4.getText().toString();
            }
        });

        //before radio button
        before_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before=before_radio1.getText().toString();
            }
        });

        before_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before=before_radio2.getText().toString();
            }
        });

        before_radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before=before_radio3.getText().toString();
            }
        });

        before_radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                before=before_radio4.getText().toString();
            }
        });

        //entering radio button
        entering_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entering=entering_radio1.getText().toString();
            }
        });

        entering_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entering=entering_radio2.getText().toString();
            }
        });

        entering_radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entering=entering_radio3.getText().toString();
            }
        });

        entering_radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entering=entering_radio4.getText().toString();
            }
        });

        //firstSet radio button
        firstSet_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstSet=firstSet_radio1.getText().toString();
            }
        });

        firstSet_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstSet=firstSet_radio2.getText().toString();
            }
        });

        firstSet_radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstSet=firstSet_radio3.getText().toString();
            }
        });

        firstSet_radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstSet=firstSet_radio4.getText().toString();
            }
        });

        //strong opponent radio button
        strongOpponent_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q1_PC_S2)
                {
                    TextView radio_yes_PC_S2_Q1=findViewById(R.id.reason_PC_S2_Q1_tv);
                    TextView reason_1_PC_S2_Q1=findViewById(R.id.Reason_1_PC_S2_Q1_checkBox);
                    TextView reason_2_PC_S2_Q1=findViewById(R.id.Reason_2_PC_S2_Q1_checkBox);
                    TextView reason_3_PC_S2_Q1=findViewById(R.id.Reason_3_PC_S2_Q1_checkBox);
                    TextView reason_4_PC_S2_Q1=findViewById(R.id.Reason_4_PC_S2_Q1_checkBox);
                    TextView reason_5_PC_S2_Q1=findViewById(R.id.Reason_5_PC_S2_Q1_checkBox);
                    radio_yes_PC_S2_Q1.setVisibility(View.VISIBLE);
                    reason_1_PC_S2_Q1.setVisibility(View.VISIBLE);
                    reason_2_PC_S2_Q1.setVisibility(View.VISIBLE);
                    reason_3_PC_S2_Q1.setVisibility(View.VISIBLE);
                    reason_4_PC_S2_Q1.setVisibility(View.VISIBLE);
                    reason_5_PC_S2_Q1.setVisibility(View.VISIBLE);
                }
                strongOpponent=strongOpponent_radio1.getText().toString();
            }
        });

        strongOpponent_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q1_PC_S2)
                {

                    TextView radio_yes_PC_S2_Q1=findViewById(R.id.reason_PC_S2_Q1_tv);
                    TextView reason_1_PC_S2_Q1=findViewById(R.id.Reason_1_PC_S2_Q1_checkBox);
                    TextView reason_2_PC_S2_Q1=findViewById(R.id.Reason_2_PC_S2_Q1_checkBox);
                    TextView reason_3_PC_S2_Q1=findViewById(R.id.Reason_3_PC_S2_Q1_checkBox);
                    TextView reason_4_PC_S2_Q1=findViewById(R.id.Reason_4_PC_S2_Q1_checkBox);
                    TextView reason_5_PC_S2_Q1=findViewById(R.id.Reason_5_PC_S2_Q1_checkBox);
                    radio_yes_PC_S2_Q1.setVisibility(View.GONE);
                    reason_1_PC_S2_Q1.setVisibility(View.GONE);
                    reason_2_PC_S2_Q1.setVisibility(View.GONE);
                    reason_3_PC_S2_Q1.setVisibility(View.GONE);
                    reason_4_PC_S2_Q1.setVisibility(View.GONE);
                    reason_5_PC_S2_Q1.setVisibility(View.GONE);
                }
                strongOpponent=strongOpponent_radio2.getText().toString();
            }
        });

        //lower_rank radio button
        lower_rank_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lower_rank=lower_rank_radio1.getText().toString();
            }
        });

        lower_rank_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lower_rank=lower_rank_radio2.getText().toString();
            }
        });

        //insecure radio button
        insecure_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insecure=insecure_radio1.getText().toString();
            }
        });

        insecure_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insecure=insecure_radio2.getText().toString();
            }
        });

        //loosing radio button
        loosing_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loosing=loosing_radio1.getText().toString();
            }
        });

        loosing_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loosing=loosing_radio2.getText().toString();
            }
        });

        //first_round radio button
        first_round_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first_round=first_round_radio1.getText().toString();
            }
        });

        first_round_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first_round=first_round_radio2.getText().toString();
            }
        });

        //upcoming radio button
        upcoming_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q1_PC_SS2)
                {
                    TextView radio_yes_PC_SS2_Q1=findViewById(R.id.reason_PC_SS2_Q1_tv);
                    TextView reason_1_PC_SS2_Q1=findViewById(R.id.Reason_1_PC_SS2_Q1_checkBox);
                    TextView reason_2_PC_SS2_Q1=findViewById(R.id.Reason_2_PC_SS2_Q1_checkBox);
                    TextView reason_3_PC_SS2_Q1=findViewById(R.id.Reason_3_PC_SS2_Q1_checkBox);
                    TextView reason_4_PC_SS2_Q1=findViewById(R.id.Reason_4_PC_SS2_Q1_checkBox);
                    TextView reason_5_PC_SS2_Q1=findViewById(R.id.Reason_5_PC_SS2_Q1_checkBox);
                    TextView reason_6_PC_SS2_Q1=findViewById(R.id.Reason_6_PC_SS2_Q1_checkBox);
                    TextView reason_7_PC_SS2_Q1=findViewById(R.id.Reason_7_PC_SS2_Q1_checkBox);
                    TextView reason_8_PC_SS2_Q1=findViewById(R.id.Reason_8_PC_SS2_Q1_checkBox);
                    radio_yes_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_1_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_2_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_3_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_4_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_5_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_6_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_7_PC_SS2_Q1.setVisibility(View.VISIBLE);
                    reason_8_PC_SS2_Q1.setVisibility(View.VISIBLE);
                }
                upcoming=upcoming_radio1.getText().toString();
            }
        });

        upcoming_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q1_PC_SS2)
                {

                    TextView radio_yes_PC_SS2_Q1=findViewById(R.id.reason_PC_SS2_Q1_tv);
                    TextView reason_1_PC_SS2_Q1=findViewById(R.id.Reason_1_PC_SS2_Q1_checkBox);
                    TextView reason_2_PC_SS2_Q1=findViewById(R.id.Reason_2_PC_SS2_Q1_checkBox);
                    TextView reason_3_PC_SS2_Q1=findViewById(R.id.Reason_3_PC_SS2_Q1_checkBox);
                    TextView reason_4_PC_SS2_Q1=findViewById(R.id.Reason_4_PC_SS2_Q1_checkBox);
                    TextView reason_5_PC_SS2_Q1=findViewById(R.id.Reason_5_PC_SS2_Q1_checkBox);
                    TextView reason_6_PC_SS2_Q1=findViewById(R.id.Reason_6_PC_SS2_Q1_checkBox);
                    TextView reason_7_PC_SS2_Q1=findViewById(R.id.Reason_7_PC_SS2_Q1_checkBox);
                    TextView reason_8_PC_SS2_Q1=findViewById(R.id.Reason_8_PC_SS2_Q1_checkBox);
                    radio_yes_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_1_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_2_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_3_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_4_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_5_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_6_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_7_PC_SS2_Q1.setVisibility(View.GONE);
                    reason_8_PC_SS2_Q1.setVisibility(View.GONE);
                }
                upcoming=upcoming_radio2.getText().toString();
            }
        });

        //input radio button
        input_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input=input_radio1.getText().toString();
            }
        });

        input_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input=input_radio2.getText().toString();
            }
        });

        //rude radio button
        rude_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rude=rude_radio1.getText().toString();
            }
        });

        rude_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rude=rude_radio2.getText().toString();
            }
        });

        //strongOpponent checkbox
        strongOpponent_reason1=(CheckBox)findViewById(R.id.Reason_1_PC_S2_Q1_checkBox);
        strongOpponent_reason2=(CheckBox)findViewById(R.id.Reason_2_PC_S2_Q1_checkBox);
        strongOpponent_reason3=(CheckBox)findViewById(R.id.Reason_3_PC_S2_Q1_checkBox);
        strongOpponent_reason4=(CheckBox)findViewById(R.id.Reason_4_PC_S2_Q1_checkBox);
        strongOpponent_reason5=(CheckBox)findViewById(R.id.Reason_5_PC_S2_Q1_checkBox);

        strongOpponent_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strongOpponent_reason1.isChecked())
                {
                    strongOpponent_reason1_s=strongOpponent_reason1.getText().toString();
                }
                else
                {
                    strongOpponent_reason1_s=null;
                }

            }
        });

        strongOpponent_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strongOpponent_reason2.isChecked())
                {
                    strongOpponent_reason2_s=strongOpponent_reason2.getText().toString();
                }
                else
                {
                    strongOpponent_reason2_s=null;
                }

            }
        });

        strongOpponent_reason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strongOpponent_reason3.isChecked())
                {
                    strongOpponent_reason3_s=strongOpponent_reason3.getText().toString();
                }
                else
                {
                    strongOpponent_reason3_s=null;
                }

            }
        });

        strongOpponent_reason4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strongOpponent_reason4.isChecked())
                {
                    strongOpponent_reason4_s=strongOpponent_reason4.getText().toString();
                }
                else
                {
                    strongOpponent_reason4_s=null;
                }

            }
        });

        strongOpponent_reason5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strongOpponent_reason5.isChecked())
                {
                    strongOpponent_reason5_s=strongOpponent_reason5.getText().toString();
                }
                else
                {
                    strongOpponent_reason5_s=null;
                }

            }
        });

        //upcoming_reason checkbox
        upcoming_reason1=(CheckBox)findViewById(R.id.Reason_1_PC_SS2_Q1_checkBox);
        upcoming_reason2=(CheckBox)findViewById(R.id.Reason_2_PC_SS2_Q1_checkBox);
        upcoming_reason3=(CheckBox)findViewById(R.id.Reason_3_PC_SS2_Q1_checkBox);
        upcoming_reason4=(CheckBox)findViewById(R.id.Reason_4_PC_SS2_Q1_checkBox);
        upcoming_reason5=(CheckBox)findViewById(R.id.Reason_5_PC_SS2_Q1_checkBox);
        upcoming_reason6=(CheckBox)findViewById(R.id.Reason_6_PC_SS2_Q1_checkBox);
        upcoming_reason7=(CheckBox)findViewById(R.id.Reason_7_PC_SS2_Q1_checkBox);
        upcoming_reason8=(CheckBox)findViewById(R.id.Reason_8_PC_SS2_Q1_checkBox);

        upcoming_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason1.isChecked())
                {
                    upcoming_reason1_s=upcoming_reason1.getText().toString();
                }
                else
                {
                    upcoming_reason1_s=null;
                }

            }
        });

        upcoming_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason2.isChecked())
                {
                    upcoming_reason2_s=upcoming_reason2.getText().toString();
                }
                else
                {
                    upcoming_reason2_s=null;
                }

            }
        });

        upcoming_reason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason3.isChecked())
                {
                    upcoming_reason3_s=upcoming_reason3.getText().toString();
                }
                else
                {
                    upcoming_reason3_s=null;
                }

            }
        });

        upcoming_reason4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason4.isChecked())
                {
                    upcoming_reason4_s=upcoming_reason4.getText().toString();
                }
                else
                {
                    upcoming_reason4_s=null;
                }

            }
        });

        upcoming_reason5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason5.isChecked())
                {
                    upcoming_reason5_s=upcoming_reason5.getText().toString();
                }
                else
                {
                    upcoming_reason5_s=null;
                }

            }
        });

        upcoming_reason6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason6.isChecked())
                {
                    upcoming_reason6_s=upcoming_reason6.getText().toString();
                }
                else
                {
                    upcoming_reason6_s=null;
                }

            }
        });

        upcoming_reason7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason7.isChecked())
                {
                    upcoming_reason7_s=upcoming_reason7.getText().toString();
                }
                else
                {
                    upcoming_reason7_s=null;
                }

            }
        });

        upcoming_reason8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(upcoming_reason8.isChecked())
                {
                    upcoming_reason8_s=upcoming_reason8.getText().toString();
                }
                else
                {
                    upcoming_reason8_s=null;
                }

            }
        });


    }

    /**public void clicked_yes__PC_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_PC_S2)
        {
            TextView radio_yes_PC_S2_Q1=findViewById(R.id.reason_PC_S2_Q1_tv);
            TextView reason_1_PC_S2_Q1=findViewById(R.id.Reason_1_PC_S2_Q1_checkBox);
            TextView reason_2_PC_S2_Q1=findViewById(R.id.Reason_2_PC_S2_Q1_checkBox);
            TextView reason_3_PC_S2_Q1=findViewById(R.id.Reason_3_PC_S2_Q1_checkBox);
            TextView reason_4_PC_S2_Q1=findViewById(R.id.Reason_4_PC_S2_Q1_checkBox);
            TextView reason_5_PC_S2_Q1=findViewById(R.id.Reason_5_PC_S2_Q1_checkBox);
            radio_yes_PC_S2_Q1.setVisibility(View.VISIBLE);
            reason_1_PC_S2_Q1.setVisibility(View.VISIBLE);
            reason_2_PC_S2_Q1.setVisibility(View.VISIBLE);
            reason_3_PC_S2_Q1.setVisibility(View.VISIBLE);
            reason_4_PC_S2_Q1.setVisibility(View.VISIBLE);
            reason_5_PC_S2_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PC_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_PC_S2)
        {

            TextView radio_yes_PC_S2_Q1=findViewById(R.id.reason_PC_S2_Q1_tv);
            TextView reason_1_PC_S2_Q1=findViewById(R.id.Reason_1_PC_S2_Q1_checkBox);
            TextView reason_2_PC_S2_Q1=findViewById(R.id.Reason_2_PC_S2_Q1_checkBox);
            TextView reason_3_PC_S2_Q1=findViewById(R.id.Reason_3_PC_S2_Q1_checkBox);
            TextView reason_4_PC_S2_Q1=findViewById(R.id.Reason_4_PC_S2_Q1_checkBox);
            TextView reason_5_PC_S2_Q1=findViewById(R.id.Reason_5_PC_S2_Q1_checkBox);
            radio_yes_PC_S2_Q1.setVisibility(View.GONE);
            reason_1_PC_S2_Q1.setVisibility(View.GONE);
            reason_2_PC_S2_Q1.setVisibility(View.GONE);
            reason_3_PC_S2_Q1.setVisibility(View.GONE);
            reason_4_PC_S2_Q1.setVisibility(View.GONE);
            reason_5_PC_S2_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__PC_SS2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_PC_SS2)
        {
            TextView radio_yes_PC_SS2_Q1=findViewById(R.id.reason_PC_SS2_Q1_tv);
            TextView reason_1_PC_SS2_Q1=findViewById(R.id.Reason_1_PC_SS2_Q1_checkBox);
            TextView reason_2_PC_SS2_Q1=findViewById(R.id.Reason_2_PC_SS2_Q1_checkBox);
            TextView reason_3_PC_SS2_Q1=findViewById(R.id.Reason_3_PC_SS2_Q1_checkBox);
            TextView reason_4_PC_SS2_Q1=findViewById(R.id.Reason_4_PC_SS2_Q1_checkBox);
            TextView reason_5_PC_SS2_Q1=findViewById(R.id.Reason_5_PC_SS2_Q1_checkBox);
            TextView reason_6_PC_SS2_Q1=findViewById(R.id.Reason_6_PC_SS2_Q1_checkBox);
            TextView reason_7_PC_SS2_Q1=findViewById(R.id.Reason_7_PC_SS2_Q1_checkBox);
            TextView reason_8_PC_SS2_Q1=findViewById(R.id.Reason_8_PC_SS2_Q1_checkBox);
            radio_yes_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_1_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_2_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_3_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_4_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_5_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_6_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_7_PC_SS2_Q1.setVisibility(View.VISIBLE);
            reason_8_PC_SS2_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PC_SS2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_PC_SS2)
        {

            TextView radio_yes_PC_SS2_Q1=findViewById(R.id.reason_PC_SS2_Q1_tv);
            TextView reason_1_PC_SS2_Q1=findViewById(R.id.Reason_1_PC_SS2_Q1_checkBox);
            TextView reason_2_PC_SS2_Q1=findViewById(R.id.Reason_2_PC_SS2_Q1_checkBox);
            TextView reason_3_PC_SS2_Q1=findViewById(R.id.Reason_3_PC_SS2_Q1_checkBox);
            TextView reason_4_PC_SS2_Q1=findViewById(R.id.Reason_4_PC_SS2_Q1_checkBox);
            TextView reason_5_PC_SS2_Q1=findViewById(R.id.Reason_5_PC_SS2_Q1_checkBox);
            TextView reason_6_PC_SS2_Q1=findViewById(R.id.Reason_6_PC_SS2_Q1_checkBox);
            TextView reason_7_PC_SS2_Q1=findViewById(R.id.Reason_7_PC_SS2_Q1_checkBox);
            TextView reason_8_PC_SS2_Q1=findViewById(R.id.Reason_8_PC_SS2_Q1_checkBox);
            radio_yes_PC_SS2_Q1.setVisibility(View.GONE);
            reason_1_PC_SS2_Q1.setVisibility(View.GONE);
            reason_2_PC_SS2_Q1.setVisibility(View.GONE);
            reason_3_PC_SS2_Q1.setVisibility(View.GONE);
            reason_4_PC_SS2_Q1.setVisibility(View.GONE);
            reason_5_PC_SS2_Q1.setVisibility(View.GONE);
            reason_6_PC_SS2_Q1.setVisibility(View.GONE);
            reason_7_PC_SS2_Q1.setVisibility(View.GONE);
            reason_8_PC_SS2_Q1.setVisibility(View.GONE);
        }
    }**/

    public void submit_precompetition(View view)
    {
        if (view.getId()==R.id.submit_precompetition_btn)
        {
            new PostData(nervous,continuous,eve,before,entering,firstSet,strongOpponent,strongOpponent_reason1_s,strongOpponent_reason2_s,strongOpponent_reason3_s,strongOpponent_reason4_s,strongOpponent_reason5_s,lower_rank,insecure,loosing,first_round,upcoming,upcoming_reason1_s,upcoming_reason2_s,upcoming_reason3_s,upcoming_reason4_s,upcoming_reason5_s,upcoming_reason6_s,upcoming_reason7_s,upcoming_reason8_s,input,rude).execute(db.getAddressAPI_PreCompetition());
        }
    }

    //function to add new personal
    class PostData extends AsyncTask<String,String,String> {
        private String Nervous,Continuous,Eve,Before,Entering,FirstSet,StrongOpponent,StrongOpponent_reason1_s;
        private String StrongOpponent_reason2_s,StrongOpponent_reason3_s,StrongOpponent_reason4_s,StrongOpponent_reason5_s;
        private String Lower_rank,Insecure,Loosing,First_round,Upcoming,Upcoming_reason1_s,Upcoming_reason2_s,Upcoming_reason3_s;
        private String Upcoming_reason4_s,Upcoming_reason5_s,Upcoming_reason6_s,Upcoming_reason7_s,Upcoming_reason8_s,Input,Rude;

        public PostData(String nervous, String continuous, String eve, String before, String entering, String firstSet, String strongOpponent, String strongOpponent_reason1_s, String strongOpponent_reason2_s, String strongOpponent_reason3_s, String strongOpponent_reason4_s, String strongOpponent_reason5_s, String lower_rank, String insecure, String loosing, String first_round, String upcoming, String upcoming_reason1_s, String upcoming_reason2_s, String upcoming_reason3_s, String upcoming_reason4_s, String upcoming_reason5_s, String upcoming_reason6_s, String upcoming_reason7_s, String upcoming_reason8_s, String input, String rude) {
            Nervous = nervous;
            Continuous = continuous;
            Eve = eve;
            Before = before;
            Entering = entering;
            FirstSet = firstSet;
            StrongOpponent = strongOpponent;
            StrongOpponent_reason1_s = strongOpponent_reason1_s;
            StrongOpponent_reason2_s = strongOpponent_reason2_s;
            StrongOpponent_reason3_s = strongOpponent_reason3_s;
            StrongOpponent_reason4_s = strongOpponent_reason4_s;
            StrongOpponent_reason5_s = strongOpponent_reason5_s;
            Lower_rank = lower_rank;
            Insecure = insecure;
            Loosing = loosing;
            First_round = first_round;
            Upcoming = upcoming;
            Upcoming_reason1_s = upcoming_reason1_s;
            Upcoming_reason2_s = upcoming_reason2_s;
            Upcoming_reason3_s = upcoming_reason3_s;
            Upcoming_reason4_s = upcoming_reason4_s;
            Upcoming_reason5_s = upcoming_reason5_s;
            Upcoming_reason6_s = upcoming_reason6_s;
            Upcoming_reason7_s = upcoming_reason7_s;
            Upcoming_reason8_s = upcoming_reason8_s;
            Input = input;
            Rude = rude;
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
            json += "\t\"nervous\":\"" + Nervous + "\",\n";
            json += "\t\"continuous\":\"" + Continuous + "\",\n";
            json += "\t\"eve\":\"" + Eve + "\",\n";
            json += "\t\"before\":\"" + Before + "\",\n";
            json += "\t\"entering\":\"" + Entering + "\",\n";
            json += "\t\"firstSet\":\"" + FirstSet + "\",\n";
            json += "\t\"strongOpponent\":\"" + StrongOpponent + "\",\n";
            json += "\t\"strongOpponent_reason\": [\"" + StrongOpponent_reason1_s + "\",\""+StrongOpponent_reason2_s+ "\",\""+StrongOpponent_reason3_s+ "\",\""+StrongOpponent_reason4_s+ "\",\""+StrongOpponent_reason5_s+"\"],\n";
            json += "\t\"lower_rank\":\"" + Lower_rank + "\",\n";
            json += "\t\"insecure\":\"" + Insecure + "\",\n";
            json += "\t\"loosing\":\"" + Loosing + "\",\n";
            json += "\t\"first_round\":\"" + First_round + "\",\n";
            json += "\t\"upcoming\":\"" + Upcoming + "\",\n";
            json += "\t\"upcoming_reason\": [\"" + Upcoming_reason1_s + "\",\""+Upcoming_reason2_s+ "\",\""+Upcoming_reason3_s+ "\",\""+Upcoming_reason4_s+ "\",\""+Upcoming_reason5_s+ "\",\""+Upcoming_reason6_s+ "\",\""+Upcoming_reason7_s+ "\",\""+Upcoming_reason8_s+"\"],\n";
            json += "\t\"input\":\"" + Input + "\",\n";
            json += "\t\"rude\":\"" + Rude + "\",\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            toastMessage("Successfully submitted");
            Intent intent = new Intent(PreCompetition.this, questionnaire.class);
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
