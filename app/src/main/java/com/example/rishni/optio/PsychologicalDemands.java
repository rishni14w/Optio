package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PsychologicalDemands extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychological_demands);
        setTitle(R.string.psychological_Title);
    }

    public void clicked_yes__PD_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_PD_S2)
        {
            TextView radio_yes_PD_S2_Q1=findViewById(R.id.reason_PD_S2_Q1_tv);
            TextView reason_1_PD_S2_Q1=findViewById(R.id.Reason_1_PD_S2_Q1_checkBox);
            TextView reason_2_PD_S2_Q1=findViewById(R.id.Reason_2_PD_S2_Q1_checkBox);
            TextView reason_3_PD_S2_Q1=findViewById(R.id.Reason_3_PD_S2_Q1_checkBox);
            TextView reason_4_PD_S2_Q1=findViewById(R.id.Reason_4_PD_S2_Q1_checkBox);
            TextView reason_5_PD_S2_Q1=findViewById(R.id.Reason_5_PD_S2_Q1_checkBox);
            TextView reason_6_PD_S2_Q1=findViewById(R.id.Reason_6_PD_S2_Q1_checkBox);
            TextView reason_7_PD_S2_Q1=findViewById(R.id.Reason_7_PD_S2_Q1_checkBox);
            TextView reason_8_PD_S2_Q1=findViewById(R.id.Reason_8_PD_S2_Q1_checkBox);
            TextView reason_9_PD_S2_Q1=findViewById(R.id.Reason_9_PD_S2_Q1_checkBox);
            TextView reason_10_PD_S2_Q1=findViewById(R.id.Reason_10_PD_S2_Q1_checkBox);
            TextView reason_11_PD_S2_Q1=findViewById(R.id.Reason_11_PD_S2_Q1_checkBox);
            TextView reason_12_PD_S2_Q1=findViewById(R.id.Reason_12_PD_S2_Q1_checkBox);
            radio_yes_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_1_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_2_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_3_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_4_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_5_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_6_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_7_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_8_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_9_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_10_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_11_PD_S2_Q1.setVisibility(View.VISIBLE);
            reason_12_PD_S2_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__PD_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_PD_S2)
        {
            TextView radio_yes_PD_S2_Q1=findViewById(R.id.reason_PD_S2_Q1_tv);
            TextView reason_1_PD_S2_Q1=findViewById(R.id.Reason_1_PD_S2_Q1_checkBox);
            TextView reason_2_PD_S2_Q1=findViewById(R.id.Reason_2_PD_S2_Q1_checkBox);
            TextView reason_3_PD_S2_Q1=findViewById(R.id.Reason_3_PD_S2_Q1_checkBox);
            TextView reason_4_PD_S2_Q1=findViewById(R.id.Reason_4_PD_S2_Q1_checkBox);
            TextView reason_5_PD_S2_Q1=findViewById(R.id.Reason_5_PD_S2_Q1_checkBox);
            TextView reason_6_PD_S2_Q1=findViewById(R.id.Reason_6_PD_S2_Q1_checkBox);
            TextView reason_7_PD_S2_Q1=findViewById(R.id.Reason_7_PD_S2_Q1_checkBox);
            TextView reason_8_PD_S2_Q1=findViewById(R.id.Reason_8_PD_S2_Q1_checkBox);
            TextView reason_9_PD_S2_Q1=findViewById(R.id.Reason_9_PD_S2_Q1_checkBox);
            TextView reason_10_PD_S2_Q1=findViewById(R.id.Reason_10_PD_S2_Q1_checkBox);
            TextView reason_11_PD_S2_Q1=findViewById(R.id.Reason_11_PD_S2_Q1_checkBox);
            TextView reason_12_PD_S2_Q1=findViewById(R.id.Reason_12_PD_S2_Q1_checkBox);
            radio_yes_PD_S2_Q1.setVisibility(View.GONE);
            reason_1_PD_S2_Q1.setVisibility(View.GONE);
            reason_2_PD_S2_Q1.setVisibility(View.GONE);
            reason_3_PD_S2_Q1.setVisibility(View.GONE);
            reason_4_PD_S2_Q1.setVisibility(View.GONE);
            reason_5_PD_S2_Q1.setVisibility(View.GONE);
            reason_6_PD_S2_Q1.setVisibility(View.GONE);
            reason_7_PD_S2_Q1.setVisibility(View.GONE);
            reason_8_PD_S2_Q1.setVisibility(View.GONE);
            reason_9_PD_S2_Q1.setVisibility(View.GONE);
            reason_10_PD_S2_Q1.setVisibility(View.GONE);
            reason_11_PD_S2_Q1.setVisibility(View.GONE);
            reason_12_PD_S2_Q1.setVisibility(View.GONE);
        }
    }
}
