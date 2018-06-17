package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PreCompetition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_competition);
        setTitle(R.string.precompetition_Title);
    }

    public void clicked_yes__PC_S2_Q1(View view)
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
    }

}
