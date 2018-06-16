package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PersonalLifeConcern extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_life_concern);
        setTitle(R.string.personal_Title);
    }

    public void clicked_yes__PLC_S1_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_PLC_S1)
        {

        }
    }

    public void clicked_no__PLC_S11_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_PLC_S1)
        {

        }
    }

    public void clicked_yes__PLC_S1_Q2(View view)
    {
        if(view.getId()==R.id.radioButton1_Q2_PLC_S1)
        {
            TextView radio_yes_PLC_S1_Q2=findViewById(R.id.reason_PLC_S1_Q2_tv);
            TextView reason_1_PLC_S1_Q2=findViewById(R.id.Reason_1_PLC_S1_Q2_checkBox);
            TextView reason_2_PLC_S1_Q2=findViewById(R.id.Reason_2_PLC_S1_Q2_checkBox);
            TextView reason_3_PLC_S1_Q2=findViewById(R.id.Reason_3_PLC_S1_Q2_checkBox);
            radio_yes_PLC_S1_Q2.setVisibility(View.VISIBLE);
            reason_1_PLC_S1_Q2.setVisibility(View.VISIBLE);
            reason_2_PLC_S1_Q2.setVisibility(View.VISIBLE);
            reason_3_PLC_S1_Q2.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PLC_S1_Q2(View view)
    {
        if(view.getId()==R.id.radioButton2_Q2_PLC_S1)
        {
            TextView radio_yes_PLC_S1_Q2=findViewById(R.id.reason_PLC_S1_Q2_tv);
            TextView reason_1_PLC_S1_Q2=findViewById(R.id.Reason_1_PLC_S1_Q2_checkBox);
            TextView reason_2_PLC_S1_Q2=findViewById(R.id.Reason_2_PLC_S1_Q2_checkBox);
            TextView reason_3_PLC_S1_Q2=findViewById(R.id.Reason_3_PLC_S1_Q2_checkBox);
            radio_yes_PLC_S1_Q2.setVisibility(View.GONE);
            reason_1_PLC_S1_Q2.setVisibility(View.GONE);
            reason_2_PLC_S1_Q2.setVisibility(View.GONE);
            reason_3_PLC_S1_Q2.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__PLC_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_PLC_S2)
        {
            TextView radio_yes_PLC_S2_Q1=findViewById(R.id.reason_PLC_S2_Q1_tv);
            TextView reason_1_PLC_S2_Q1=findViewById(R.id.Reason_1_PLC_S2_Q1_checkBox);
            TextView reason_2_PLC_S2_Q1=findViewById(R.id.Reason_2_PLC_S2_Q1_checkBox);
            radio_yes_PLC_S2_Q1.setVisibility(View.VISIBLE);
            reason_1_PLC_S2_Q1.setVisibility(View.VISIBLE);
            reason_2_PLC_S2_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PLC_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_PLC_S2)
        {
            TextView radio_yes_PLC_S2_Q1=findViewById(R.id.reason_PLC_S2_Q1_tv);
            TextView reason_1_PLC_S2_Q1=findViewById(R.id.Reason_1_PLC_S2_Q1_checkBox);
            TextView reason_2_PLC_S2_Q1=findViewById(R.id.Reason_2_PLC_S2_Q1_checkBox);
            radio_yes_PLC_S2_Q1.setVisibility(View.GONE);
            reason_1_PLC_S2_Q1.setVisibility(View.GONE);
            reason_2_PLC_S2_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__PLC_S3_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_PLC_S3)
        {
            TextView radio_yes_PLC_S3_Q1=findViewById(R.id.reason_PLC_S3_Q1_tv);
            TextView reason_1_PLC_S3_Q1=findViewById(R.id.Reason_1_PLC_S3_Q1_checkBox);
            TextView reason_2_PLC_S3_Q1=findViewById(R.id.Reason_2_PLC_S3_Q1_checkBox);
            radio_yes_PLC_S3_Q1.setVisibility(View.VISIBLE);
            reason_1_PLC_S3_Q1.setVisibility(View.VISIBLE);
            reason_2_PLC_S3_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PLC_S3_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_PLC_S3)
        {
            TextView radio_yes_PLC_S3_Q1=findViewById(R.id.reason_PLC_S3_Q1_tv);
            TextView reason_1_PLC_S3_Q1=findViewById(R.id.Reason_1_PLC_S3_Q1_checkBox);
            TextView reason_2_PLC_S3_Q1=findViewById(R.id.Reason_2_PLC_S3_Q1_checkBox);
            radio_yes_PLC_S3_Q1.setVisibility(View.GONE);
            reason_1_PLC_S3_Q1.setVisibility(View.GONE);
            reason_2_PLC_S3_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__PLC_S3_Q2(View view)
    {
        if(view.getId()==R.id.radioButton1_Q2_PLC_S3)
        {
            TextView radio_yes_PLC_S2_Q2=findViewById(R.id.reason_PLC_S3_Q2_tv);
            TextView reason_1_PLC_S2_Q2=findViewById(R.id.Reason_1_PLC_S3_Q2_checkBox);
            TextView reason_2_PLC_S2_Q2=findViewById(R.id.Reason_2_PLC_S3_Q2_checkBox);
            TextView reason_3_PLC_S2_Q2=findViewById(R.id.Reason_3_PLC_S3_Q2_checkBox);
            radio_yes_PLC_S2_Q2.setVisibility(View.VISIBLE);
            reason_1_PLC_S2_Q2.setVisibility(View.VISIBLE);
            reason_2_PLC_S2_Q2.setVisibility(View.VISIBLE);
            reason_3_PLC_S2_Q2.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PLC_S3_Q2(View view)
    {
        if(view.getId()==R.id.radioButton2_Q2_PLC_S3)
        {
            TextView radio_yes_PLC_S2_Q2=findViewById(R.id.reason_PLC_S3_Q2_tv);
            TextView reason_1_PLC_S2_Q2=findViewById(R.id.Reason_1_PLC_S3_Q2_checkBox);
            TextView reason_2_PLC_S2_Q2=findViewById(R.id.Reason_2_PLC_S3_Q2_checkBox);
            TextView reason_3_PLC_S2_Q2=findViewById(R.id.Reason_3_PLC_S3_Q2_checkBox);
            radio_yes_PLC_S2_Q2.setVisibility(View.GONE);
            reason_1_PLC_S2_Q2.setVisibility(View.GONE);
            reason_2_PLC_S2_Q2.setVisibility(View.GONE);
            reason_3_PLC_S2_Q2.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__PLC_S4_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_PLC_S4)
        {
            TextView radio_yes_PLC_S4_Q1=findViewById(R.id.reason_PLC_S4_Q1_tv);
            TextView reason_1_PLC_S4_Q1=findViewById(R.id.Reason_1_PLC_S4_Q1_checkBox);
            TextView reason_2_PLC_S4_Q1=findViewById(R.id.Reason_2_PLC_S4_Q1_checkBox);
            TextView reason_3_PLC_S4_Q1=findViewById(R.id.Reason_3_PLC_S4_Q1_checkBox);
            radio_yes_PLC_S4_Q1.setVisibility(View.VISIBLE);
            reason_1_PLC_S4_Q1.setVisibility(View.VISIBLE);
            reason_2_PLC_S4_Q1.setVisibility(View.VISIBLE);
            reason_3_PLC_S4_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PLC_S4_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_PLC_S4)
        {
            TextView radio_yes_PLC_S4_Q1=findViewById(R.id.reason_PLC_S4_Q1_tv);
            TextView reason_1_PLC_S4_Q1=findViewById(R.id.Reason_1_PLC_S4_Q1_checkBox);
            TextView reason_2_PLC_S4_Q1=findViewById(R.id.Reason_2_PLC_S4_Q1_checkBox);
            TextView reason_3_PLC_S4_Q1=findViewById(R.id.Reason_3_PLC_S4_Q1_checkBox);
            radio_yes_PLC_S4_Q1.setVisibility(View.GONE);
            reason_1_PLC_S4_Q1.setVisibility(View.GONE);
            reason_2_PLC_S4_Q1.setVisibility(View.GONE);
            reason_3_PLC_S4_Q1.setVisibility(View.GONE);
        }
    }


}
