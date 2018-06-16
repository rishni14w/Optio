package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Competition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);
        setTitle(R.string.competition_Title);
    }

    public void clicked_yes__CS1_Q1(View view)
    {
        if(view.getId()==R.id.radioButton1_Q1_CS1)
        {
            TextView radio_yes_CS1_Q1=findViewById(R.id.reason_CS1_Q1_tv);
            TextView reason_1_CS1_Q1=findViewById(R.id.Reason_1_CS1_Q1_checkBox);
            TextView reason_2_CS1_Q1=findViewById(R.id.Reason_2_CS1_Q1_checkBox);
            radio_yes_CS1_Q1.setVisibility(View.VISIBLE);
            reason_1_CS1_Q1.setVisibility(View.VISIBLE);
            reason_2_CS1_Q1.setVisibility(View.VISIBLE);
        }
    }

    public void clicked_no__CS1_Q1(View view)
    {
        if(view.getId()==R.id.radioButton2_Q1_CS1)
        {
            TextView radio_yes_CS1_Q1=findViewById(R.id.reason_CS1_Q1_tv);
            TextView reason_1_CS1_Q1=findViewById(R.id.Reason_1_CS1_Q1_checkBox);
            TextView reason_2_CS1_Q1=findViewById(R.id.Reason_2_CS1_Q1_checkBox);
            radio_yes_CS1_Q1.setVisibility(View.GONE);
            reason_1_CS1_Q1.setVisibility(View.GONE);
            reason_2_CS1_Q1.setVisibility(View.GONE);
        }
    }

    public void clicked_yes__CS2_Q3(View view)
    {
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
    }

    public void clicked_no__CS2_Q3(View view)
    {
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
    }

    public void clicked_yes__CS3_Q1(View view)
    {
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
    }

    public void clicked_no__CS3_Q1(View view)
    {
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
    }

    public void clicked_yes__CS3_Q2(View view)
    {
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
    }

    public void clicked_no__CS3_Q2(View view)
    {
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
    }

    public void clicked_yes__CS3_Q3(View view)
    {
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
    }

    public void clicked_no__CS3_Q3(View view)
    {
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
    }
}
