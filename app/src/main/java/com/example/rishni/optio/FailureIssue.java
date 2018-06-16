package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FailureIssue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure_issue);
        setTitle(R.string.failure_Title);
    }

    public void clicked_yes__FI_S1_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_FI_S1)
        {
            TextView radio_yes_FI_S1_Q1=findViewById(R.id.reason_FI_S1_Q1_tv);
            TextView reason_1_FI_S1_Q1=findViewById(R.id.Reason_1_FI_S1_Q1_checkBox);
            TextView reason_2_FI_S1_Q1=findViewById(R.id.Reason_2_FI_S1_Q1_checkBox);
            TextView reason_3_FI_S1_Q1=findViewById(R.id.Reason_3_FI_S1_Q1_checkBox);
            TextView reason_4_FI_S1_Q1=findViewById(R.id.Reason_4_FI_S1_Q1_checkBox);
            TextView reason_5_FI_S1_Q1=findViewById(R.id.Reason_5_FI_S1_Q1_checkBox);
            TextView reason_6_FI_S1_Q1=findViewById(R.id.Reason_6_FI_S1_Q1_checkBox);
            TextView reason_7_FI_S1_Q1=findViewById(R.id.Reason_7_FI_S1_Q1_checkBox);
            TextView reason_8_FI_S1_Q1=findViewById(R.id.Reason_8_FI_S1_Q1_checkBox);
            TextView reason_9_FI_S1_Q1=findViewById(R.id.Reason_9_FI_S1_Q1_checkBox);
            radio_yes_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_1_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_2_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_3_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_4_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_5_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_6_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_7_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_8_FI_S1_Q1.setVisibility(View.VISIBLE);
            reason_9_FI_S1_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__FI_S1_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_FI_S1)
        {
            TextView radio_yes_FI_S1_Q1=findViewById(R.id.reason_FI_S1_Q1_tv);
            TextView reason_1_FI_S1_Q1=findViewById(R.id.Reason_1_FI_S1_Q1_checkBox);
            TextView reason_2_FI_S1_Q1=findViewById(R.id.Reason_2_FI_S1_Q1_checkBox);
            TextView reason_3_FI_S1_Q1=findViewById(R.id.Reason_3_FI_S1_Q1_checkBox);
            TextView reason_4_FI_S1_Q1=findViewById(R.id.Reason_4_FI_S1_Q1_checkBox);
            TextView reason_5_FI_S1_Q1=findViewById(R.id.Reason_5_FI_S1_Q1_checkBox);
            TextView reason_6_FI_S1_Q1=findViewById(R.id.Reason_6_FI_S1_Q1_checkBox);
            TextView reason_7_FI_S1_Q1=findViewById(R.id.Reason_7_FI_S1_Q1_checkBox);
            TextView reason_8_FI_S1_Q1=findViewById(R.id.Reason_8_FI_S1_Q1_checkBox);
            TextView reason_9_FI_S1_Q1=findViewById(R.id.Reason_9_FI_S1_Q1_checkBox);
            radio_yes_FI_S1_Q1.setVisibility(View.GONE);
            reason_1_FI_S1_Q1.setVisibility(View.GONE);
            reason_2_FI_S1_Q1.setVisibility(View.GONE);
            reason_3_FI_S1_Q1.setVisibility(View.GONE);
            reason_4_FI_S1_Q1.setVisibility(View.GONE);
            reason_5_FI_S1_Q1.setVisibility(View.GONE);
            reason_6_FI_S1_Q1.setVisibility(View.GONE);
            reason_7_FI_S1_Q1.setVisibility(View.GONE);
            reason_8_FI_S1_Q1.setVisibility(View.GONE);
            reason_9_FI_S1_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__FI_S1_Q2(View view)
    {
        if(view.getId()==R.id.radioButton1_Q2_FI_S1)
        {
            TextView radio_yes_FI_S1_Q2=findViewById(R.id.reason_FI_S1_Q2_tv);
            TextView reason_1_FI_S1_Q2=findViewById(R.id.Reason_1_FI_S1_Q2_checkBox);
            TextView reason_2_FI_S1_Q2=findViewById(R.id.Reason_2_FI_S1_Q2_checkBox);
            TextView reason_3_FI_S1_Q2=findViewById(R.id.Reason_3_FI_S1_Q2_checkBox);
            TextView reason_4_FI_S1_Q2=findViewById(R.id.Reason_4_FI_S1_Q2_checkBox);
            radio_yes_FI_S1_Q2.setVisibility(View.VISIBLE);
            reason_1_FI_S1_Q2.setVisibility(View.VISIBLE);
            reason_2_FI_S1_Q2.setVisibility(View.VISIBLE);
            reason_3_FI_S1_Q2.setVisibility(View.VISIBLE);
            reason_4_FI_S1_Q2.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__FI_S1_Q2(View view)
    {
        if(view.getId()==R.id.radioButton2_Q2_FI_S1)
        {
            TextView radio_yes_FI_S1_Q2=findViewById(R.id.reason_FI_S1_Q2_tv);
            TextView reason_1_FI_S1_Q2=findViewById(R.id.Reason_1_FI_S1_Q2_checkBox);
            TextView reason_2_FI_S1_Q2=findViewById(R.id.Reason_2_FI_S1_Q2_checkBox);
            TextView reason_3_FI_S1_Q2=findViewById(R.id.Reason_3_FI_S1_Q2_checkBox);
            TextView reason_4_FI_S1_Q2=findViewById(R.id.Reason_4_FI_S1_Q2_checkBox);
            radio_yes_FI_S1_Q2.setVisibility(View.GONE);
            reason_1_FI_S1_Q2.setVisibility(View.GONE);
            reason_2_FI_S1_Q2.setVisibility(View.GONE);
            reason_3_FI_S1_Q2.setVisibility(View.GONE);
            reason_4_FI_S1_Q2.setVisibility(View.GONE);

        }
    }

    public void clicked_yes__FI_S1_Q3(View view)
    {
        if(view.getId()==R.id.radioButton1_Q3_FI_S1)
        {
            TextView radio_yes_FI_S1_Q3=findViewById(R.id.reason_FI_S1_Q3_tv);
            TextView reason_1_FI_S1_Q3=findViewById(R.id.Reason_1_FI_S1_Q3_checkBox);
            TextView reason_2_FI_S1_Q3=findViewById(R.id.Reason_2_FI_S1_Q3_checkBox);
            radio_yes_FI_S1_Q3.setVisibility(View.VISIBLE);
            reason_1_FI_S1_Q3.setVisibility(View.VISIBLE);
            reason_2_FI_S1_Q3.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__FI_S1_Q3(View view)
    {
        if(view.getId()==R.id.radioButton2_Q3_FI_S1)
        {
            TextView radio_yes_FI_S1_Q3=findViewById(R.id.reason_FI_S1_Q3_tv);
            TextView reason_1_FI_S1_Q3=findViewById(R.id.Reason_1_FI_S1_Q3_checkBox);
            TextView reason_2_FI_S1_Q3=findViewById(R.id.Reason_2_FI_S1_Q3_checkBox);
            radio_yes_FI_S1_Q3.setVisibility(View.GONE);
            reason_1_FI_S1_Q3.setVisibility(View.GONE);
            reason_2_FI_S1_Q3.setVisibility(View.GONE);

        }
    }

    public void clicked_yes__FI_S2_Q2(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_FI_S2)
        {
            TextView radio_yes_FI_S2_Q1=findViewById(R.id.reason_FI_S2_Q1_tv);
            TextView reason_1_FI_S2_Q1=findViewById(R.id.Reason_1_FI_S2_Q1_checkBox);
            TextView reason_2_FI_S2_Q1=findViewById(R.id.Reason_2_FI_S2_Q1_checkBox);
            TextView reason_3_FI_S2_Q1=findViewById(R.id.Reason_3_FI_S2_Q1_checkBox);
            radio_yes_FI_S2_Q1.setVisibility(View.VISIBLE);
            reason_1_FI_S2_Q1.setVisibility(View.VISIBLE);
            reason_2_FI_S2_Q1.setVisibility(View.VISIBLE);
            reason_3_FI_S2_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__FI_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q2_FI_S2)
        {
            TextView radio_yes_FI_S2_Q1=findViewById(R.id.reason_FI_S2_Q1_tv);
            TextView reason_1_FI_S2_Q1=findViewById(R.id.Reason_1_FI_S2_Q1_checkBox);
            TextView reason_2_FI_S2_Q1=findViewById(R.id.Reason_2_FI_S2_Q1_checkBox);
            TextView reason_3_FI_S2_Q1=findViewById(R.id.Reason_3_FI_S2_Q1_checkBox);
            radio_yes_FI_S2_Q1.setVisibility(View.GONE);
            reason_1_FI_S2_Q1.setVisibility(View.GONE);
            reason_2_FI_S2_Q1.setVisibility(View.GONE);
            reason_3_FI_S2_Q1.setVisibility(View.GONE);
        }
    }

}
