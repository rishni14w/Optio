package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SocialRelationshipProblems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_relationship_problems);
    }

    public void clicked_yes__SRP_S1_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_SRP_S1)
        {
            TextView radio_yes_SRP_S1_Q1=findViewById(R.id.reason_SRP_S1_Q1_tv);
            TextView reason_1_SRP_S1_Q1=findViewById(R.id.Reason_1_SRP_S1_Q1_checkBox);
            TextView reason_2_SRP_S1_Q1=findViewById(R.id.Reason_2_SRP_S1_Q1_checkBox);
            TextView reason_3_SRP_S1_Q1=findViewById(R.id.Reason_3_SRP_S1_Q1_checkBox);
            TextView reason_4_SRP_S1_Q1=findViewById(R.id.Reason_4_SRP_S1_Q1_checkBox);
            radio_yes_SRP_S1_Q1.setVisibility(View.VISIBLE);
            reason_1_SRP_S1_Q1.setVisibility(View.VISIBLE);
            reason_2_SRP_S1_Q1.setVisibility(View.VISIBLE);
            reason_3_SRP_S1_Q1.setVisibility(View.VISIBLE);
            reason_4_SRP_S1_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__SRP_S1_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_SRP_S1)
        {
            TextView radio_yes_SRP_S1_Q1=findViewById(R.id.reason_SRP_S1_Q1_tv);
            TextView reason_1_SRP_S1_Q1=findViewById(R.id.Reason_1_SRP_S1_Q1_checkBox);
            TextView reason_2_SRP_S1_Q1=findViewById(R.id.Reason_2_SRP_S1_Q1_checkBox);
            TextView reason_3_SRP_S1_Q1=findViewById(R.id.Reason_3_SRP_S1_Q1_checkBox);
            TextView reason_4_SRP_S1_Q1=findViewById(R.id.Reason_4_SRP_S1_Q1_checkBox);
            radio_yes_SRP_S1_Q1.setVisibility(View.GONE);
            reason_1_SRP_S1_Q1.setVisibility(View.GONE);
            reason_2_SRP_S1_Q1.setVisibility(View.GONE);
            reason_3_SRP_S1_Q1.setVisibility(View.GONE);
            reason_4_SRP_S1_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__SRP_S1_Q2(View view)
    {
        if(view.getId()==R.id.radioButton1_Q2_SRP_S1)
        {
            TextView radio_yes_SRP_S1_Q2=findViewById(R.id.reason_SRP_S1_Q2_tv);
            TextView reason_1_SRP_S1_Q2=findViewById(R.id.Reason_1_SRP_S1_Q2_checkBox);
            TextView reason_2_SRP_S1_Q2=findViewById(R.id.Reason_2_SRP_S1_Q2_checkBox);
            TextView reason_3_SRP_S1_Q2=findViewById(R.id.Reason_3_SRP_S1_Q2_checkBox);
            TextView reason_4_SRP_S1_Q2=findViewById(R.id.Reason_4_SRP_S1_Q2_checkBox);
            radio_yes_SRP_S1_Q2.setVisibility(View.VISIBLE);
            reason_1_SRP_S1_Q2.setVisibility(View.VISIBLE);
            reason_2_SRP_S1_Q2.setVisibility(View.VISIBLE);
            reason_3_SRP_S1_Q2.setVisibility(View.VISIBLE);
            reason_4_SRP_S1_Q2.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__SRP_S1_Q2(View view)
    {
        if(view.getId()==R.id.radioButton2_Q2_SRP_S1)
        {
            TextView radio_yes_SRP_S1_Q2=findViewById(R.id.reason_SRP_S1_Q2_tv);
            TextView reason_1_SRP_S1_Q2=findViewById(R.id.Reason_1_SRP_S1_Q2_checkBox);
            TextView reason_2_SRP_S1_Q2=findViewById(R.id.Reason_2_SRP_S1_Q2_checkBox);
            TextView reason_3_SRP_S1_Q2=findViewById(R.id.Reason_3_SRP_S1_Q2_checkBox);
            TextView reason_4_SRP_S1_Q2=findViewById(R.id.Reason_4_SRP_S1_Q2_checkBox);
            radio_yes_SRP_S1_Q2.setVisibility(View.GONE);
            reason_1_SRP_S1_Q2.setVisibility(View.GONE);
            reason_2_SRP_S1_Q2.setVisibility(View.GONE);
            reason_3_SRP_S1_Q2.setVisibility(View.GONE);
            reason_4_SRP_S1_Q2.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__SRP_S1_Q3(View view)
    {
        if(view.getId()==R.id.radioButton1_Q3_SRP_S1)
        {
            TextView radio_yes_SRP_S1_Q3=findViewById(R.id.reason_SRP_S1_Q3_tv);
            TextView reason_1_SRP_S1_Q3=findViewById(R.id.Reason_1_SRP_S1_Q3_checkBox);
            TextView reason_2_SRP_S1_Q3=findViewById(R.id.Reason_2_SRP_S1_Q3_checkBox);
            TextView reason_3_SRP_S1_Q3=findViewById(R.id.Reason_3_SRP_S1_Q3_checkBox);
            radio_yes_SRP_S1_Q3.setVisibility(View.VISIBLE);
            reason_1_SRP_S1_Q3.setVisibility(View.VISIBLE);
            reason_2_SRP_S1_Q3.setVisibility(View.VISIBLE);
            reason_3_SRP_S1_Q3.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__SRP_S1_Q3(View view)
    {
        if(view.getId()==R.id.radioButton2_Q3_SRP_S1)
        {
            TextView radio_yes_SRP_S1_Q3=findViewById(R.id.reason_SRP_S1_Q3_tv);
            TextView reason_1_SRP_S1_Q3=findViewById(R.id.Reason_1_SRP_S1_Q3_checkBox);
            TextView reason_2_SRP_S1_Q3=findViewById(R.id.Reason_2_SRP_S1_Q3_checkBox);
            TextView reason_3_SRP_S1_Q3=findViewById(R.id.Reason_3_SRP_S1_Q3_checkBox);
            radio_yes_SRP_S1_Q3.setVisibility(View.GONE);
            reason_1_SRP_S1_Q3.setVisibility(View.GONE);
            reason_2_SRP_S1_Q3.setVisibility(View.GONE);
            reason_3_SRP_S1_Q3.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__SRP_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_SRP_S2)
        {
            TextView radio_yes_SRP_S2_Q1=findViewById(R.id.reason_SRP_S2_Q1_tv);
            TextView reason_1_SRP_S2_Q1=findViewById(R.id.Reason_1_SRP_S2_Q1_checkBox);
            TextView reason_2_SRP_S2_Q1=findViewById(R.id.Reason_2_SRP_S2_Q1_checkBox);
            TextView reason_3_SRP_S2_Q1=findViewById(R.id.Reason_3_SRP_S2_Q1_checkBox);
            TextView reason_4_SRP_S2_Q1=findViewById(R.id.Reason_4_SRP_S2_Q1_checkBox);
            TextView reason_5_SRP_S2_Q1=findViewById(R.id.Reason_5_SRP_S2_Q1_checkBox);
            TextView reason_6_SRP_S2_Q1=findViewById(R.id.Reason_6_SRP_S2_Q1_checkBox);
            radio_yes_SRP_S2_Q1.setVisibility(View.VISIBLE);
            reason_1_SRP_S2_Q1.setVisibility(View.VISIBLE);
            reason_2_SRP_S2_Q1.setVisibility(View.VISIBLE);
            reason_3_SRP_S2_Q1.setVisibility(View.VISIBLE);
            reason_4_SRP_S2_Q1.setVisibility(View.VISIBLE);
            reason_5_SRP_S2_Q1.setVisibility(View.VISIBLE);
            reason_6_SRP_S2_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__SRP_S2_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_SRP_S2)
        {
            TextView radio_yes_SRP_S2_Q1=findViewById(R.id.reason_SRP_S2_Q1_tv);
            TextView reason_1_SRP_S2_Q1=findViewById(R.id.Reason_1_SRP_S2_Q1_checkBox);
            TextView reason_2_SRP_S2_Q1=findViewById(R.id.Reason_2_SRP_S2_Q1_checkBox);
            TextView reason_3_SRP_S2_Q1=findViewById(R.id.Reason_3_SRP_S2_Q1_checkBox);
            TextView reason_4_SRP_S2_Q1=findViewById(R.id.Reason_4_SRP_S2_Q1_checkBox);
            TextView reason_5_SRP_S2_Q1=findViewById(R.id.Reason_5_SRP_S2_Q1_checkBox);
            TextView reason_6_SRP_S2_Q1=findViewById(R.id.Reason_6_SRP_S2_Q1_checkBox);
            radio_yes_SRP_S2_Q1.setVisibility(View.GONE);
            reason_1_SRP_S2_Q1.setVisibility(View.GONE);
            reason_2_SRP_S2_Q1.setVisibility(View.GONE);
            reason_3_SRP_S2_Q1.setVisibility(View.GONE);
            reason_4_SRP_S2_Q1.setVisibility(View.GONE);
            reason_5_SRP_S2_Q1.setVisibility(View.GONE);
            reason_6_SRP_S2_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__SRP_S3_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_SRP_S3)
        {
            TextView radio_yes_SRP_S3_Q1=findViewById(R.id.reason_SRP_S3_Q1_tv);
            TextView reason_1_SRP_S3_Q1=findViewById(R.id.Reason_1_SRP_S3_Q1_checkBox);
            TextView reason_2_SRP_S3_Q1=findViewById(R.id.Reason_2_SRP_S3_Q1_checkBox);
            TextView reason_3_SRP_S3_Q1=findViewById(R.id.Reason_3_SRP_S3_Q1_checkBox);
            radio_yes_SRP_S3_Q1.setVisibility(View.VISIBLE);
            reason_1_SRP_S3_Q1.setVisibility(View.VISIBLE);
            reason_2_SRP_S3_Q1.setVisibility(View.VISIBLE);
            reason_3_SRP_S3_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__SRP_S3_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_SRP_S3)
        {
            TextView radio_yes_SRP_S3_Q1=findViewById(R.id.reason_SRP_S3_Q1_tv);
            TextView reason_1_SRP_S3_Q1=findViewById(R.id.Reason_1_SRP_S3_Q1_checkBox);
            TextView reason_2_SRP_S3_Q1=findViewById(R.id.Reason_2_SRP_S3_Q1_checkBox);
            TextView reason_3_SRP_S3_Q1=findViewById(R.id.Reason_3_SRP_S3_Q1_checkBox);
            radio_yes_SRP_S3_Q1.setVisibility(View.GONE);
            reason_1_SRP_S3_Q1.setVisibility(View.GONE);
            reason_2_SRP_S3_Q1.setVisibility(View.GONE);
            reason_3_SRP_S3_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__SRP_S4_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_SRP_S4)
        {
            TextView radio_yes_SRP_S4_Q1=findViewById(R.id.reason_SRP_S4_Q1_tv);
            TextView reason_1_SRP_S4_Q1=findViewById(R.id.Reason_1_SRP_S4_Q1_checkBox);
            TextView reason_2_SRP_S4_Q1=findViewById(R.id.Reason_2_SRP_S4_Q1_checkBox);
            TextView reason_3_SRP_S4_Q1=findViewById(R.id.Reason_3_SRP_S4_Q1_checkBox);
            TextView reason_4_SRP_S4_Q1=findViewById(R.id.Reason_4_SRP_S4_Q1_checkBox);
            TextView reason_5_SRP_S4_Q1=findViewById(R.id.Reason_5_SRP_S4_Q1_checkBox);
            radio_yes_SRP_S4_Q1.setVisibility(View.VISIBLE);
            reason_1_SRP_S4_Q1.setVisibility(View.VISIBLE);
            reason_2_SRP_S4_Q1.setVisibility(View.VISIBLE);
            reason_3_SRP_S4_Q1.setVisibility(View.VISIBLE);
            reason_4_SRP_S4_Q1.setVisibility(View.VISIBLE);
            reason_5_SRP_S4_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__SRP_S4_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_SRP_S4)
        {
            TextView radio_yes_SRP_S4_Q1=findViewById(R.id.reason_SRP_S4_Q1_tv);
            TextView reason_1_SRP_S4_Q1=findViewById(R.id.Reason_1_SRP_S4_Q1_checkBox);
            TextView reason_2_SRP_S4_Q1=findViewById(R.id.Reason_2_SRP_S4_Q1_checkBox);
            TextView reason_3_SRP_S4_Q1=findViewById(R.id.Reason_3_SRP_S4_Q1_checkBox);
            TextView reason_4_SRP_S4_Q1=findViewById(R.id.Reason_4_SRP_S4_Q1_checkBox);
            TextView reason_5_SRP_S4_Q1=findViewById(R.id.Reason_5_SRP_S4_Q1_checkBox);
            radio_yes_SRP_S4_Q1.setVisibility(View.GONE);
            reason_1_SRP_S4_Q1.setVisibility(View.GONE);
            reason_2_SRP_S4_Q1.setVisibility(View.GONE);
            reason_3_SRP_S4_Q1.setVisibility(View.GONE);
            reason_4_SRP_S4_Q1.setVisibility(View.GONE);
            reason_5_SRP_S4_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__SRP_S5_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_SRP_S5)
        {
            TextView radio_yes_SRP_S5_Q1=findViewById(R.id.reason_SRP_S5_Q1_tv);
            TextView reason_1_SRP_S5_Q1=findViewById(R.id.Reason_1_SRP_S5_Q1_checkBox);
            TextView reason_2_SRP_S5_Q1=findViewById(R.id.Reason_2_SRP_S5_Q1_checkBox);
            TextView reason_3_SRP_S5_Q1=findViewById(R.id.Reason_3_SRP_S5_Q1_checkBox);
            radio_yes_SRP_S5_Q1.setVisibility(View.VISIBLE);
            reason_1_SRP_S5_Q1.setVisibility(View.VISIBLE);
            reason_2_SRP_S5_Q1.setVisibility(View.VISIBLE);
            reason_3_SRP_S5_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__SRP_S5_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_SRP_S5)
        {
            TextView radio_yes_SRP_S5_Q1=findViewById(R.id.reason_SRP_S5_Q1_tv);
            TextView reason_1_SRP_S5_Q1=findViewById(R.id.Reason_1_SRP_S5_Q1_checkBox);
            TextView reason_2_SRP_S5_Q1=findViewById(R.id.Reason_2_SRP_S5_Q1_checkBox);
            TextView reason_3_SRP_S5_Q1=findViewById(R.id.Reason_3_SRP_S5_Q1_checkBox);
            radio_yes_SRP_S5_Q1.setVisibility(View.GONE);
            reason_1_SRP_S5_Q1.setVisibility(View.GONE);
            reason_2_SRP_S5_Q1.setVisibility(View.GONE);
            reason_3_SRP_S5_Q1.setVisibility(View.GONE);
        }
    }
}
