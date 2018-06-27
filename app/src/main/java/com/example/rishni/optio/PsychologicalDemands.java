package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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


    public void noneClicked_PD_S1_Q1(View view)
    {
        if(view.getId()==R.id.Answer_4_PD_S1_Q1_checkBox) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_PD_S1_Q1_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_PD_S1_Q1_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_PD_S1_Q1_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_PD_S1_Q1_checkBox);
            if(chk4.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
            }
        }
    }

    public void checkboxClicked_PD_S1_Q1(View view)
    {
        if((view.getId()==R.id.Answer_1_PD_S1_Q1_checkBox)||(view.getId()==R.id.Answer_2_PD_S1_Q1_checkBox)||(view.getId()==R.id.Answer_3_PD_S1_Q1_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_PD_S1_Q1_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_PD_S1_Q1_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_PD_S1_Q1_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_PD_S1_Q1_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked())
            {
                chk4.setChecked(false);
            }
        }
    }


    public void noneClicked_PD_S1_Q2(View view)
    {
        if(view.getId()==R.id.Answer_4_PD_S1_Q2_checkBox) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_PD_S1_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_PD_S1_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_PD_S1_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_PD_S1_Q2_checkBox);
            if(chk4.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
            }
        }
    }

    public void checkboxClicked_PD_S1_Q2(View view)
    {
        if((view.getId()==R.id.Answer_1_PD_S1_Q2_checkBox)||(view.getId()==R.id.Answer_2_PD_S1_Q2_checkBox)||(view.getId()==R.id.Answer_3_PD_S1_Q2_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4;
            chk1=(CheckBox)findViewById(R.id.Answer_1_PD_S1_Q2_checkBox);
            chk2=(CheckBox)findViewById(R.id.Answer_2_PD_S1_Q2_checkBox);
            chk3=(CheckBox)findViewById(R.id.Answer_3_PD_S1_Q2_checkBox);
            chk4=(CheckBox)findViewById(R.id.Answer_4_PD_S1_Q2_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked())
            {
                chk4.setChecked(false);
            }
        }
    }


    public void noneClicked_PD_S2_Q1(View view)
    {
        if(view.getId()==R.id.Reason_12_PD_S2_Q1_checkBox) {
            CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,chk11,chk12;
            chk1=(CheckBox)findViewById(R.id.Reason_1_PD_S2_Q1_checkBox);
            chk2=(CheckBox)findViewById(R.id.Reason_2_PD_S2_Q1_checkBox);
            chk3=(CheckBox)findViewById(R.id.Reason_3_PD_S2_Q1_checkBox);
            chk4=(CheckBox)findViewById(R.id.Reason_4_PD_S2_Q1_checkBox);
            chk5=(CheckBox)findViewById(R.id.Reason_5_PD_S2_Q1_checkBox);
            chk6=(CheckBox)findViewById(R.id.Reason_6_PD_S2_Q1_checkBox);
            chk7=(CheckBox)findViewById(R.id.Reason_7_PD_S2_Q1_checkBox);
            chk8=(CheckBox)findViewById(R.id.Reason_8_PD_S2_Q1_checkBox);
            chk9=(CheckBox)findViewById(R.id.Reason_9_PD_S2_Q1_checkBox);
            chk10=(CheckBox)findViewById(R.id.Reason_10_PD_S2_Q1_checkBox);
            chk11=(CheckBox)findViewById(R.id.Reason_11_PD_S2_Q1_checkBox);
            chk12=(CheckBox)findViewById(R.id.Reason_12_PD_S2_Q1_checkBox);
            if(chk12.isChecked())
            {
                chk1.setChecked(false);
                chk2.setChecked(false);
                chk3.setChecked(false);
                chk4.setChecked(false);
                chk5.setChecked(false);
                chk6.setChecked(false);
                chk7.setChecked(false);
                chk8.setChecked(false);
                chk9.setChecked(false);
                chk10.setChecked(false);
                chk11.setChecked(false);
            }
        }
    }

    public void checkboxClicked_PD_S2_Q1(View view)
    {
        if((view.getId()==R.id.Reason_1_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_2_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_3_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_4_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_5_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_6_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_7_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_8_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_9_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_10_PD_S2_Q1_checkBox)||(view.getId()==R.id.Reason_11_PD_S2_Q1_checkBox)) {
            CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,chk11,chk12;
            chk1=(CheckBox)findViewById(R.id.Reason_1_PD_S2_Q1_checkBox);
            chk2=(CheckBox)findViewById(R.id.Reason_2_PD_S2_Q1_checkBox);
            chk3=(CheckBox)findViewById(R.id.Reason_3_PD_S2_Q1_checkBox);
            chk4=(CheckBox)findViewById(R.id.Reason_4_PD_S2_Q1_checkBox);
            chk5=(CheckBox)findViewById(R.id.Reason_5_PD_S2_Q1_checkBox);
            chk6=(CheckBox)findViewById(R.id.Reason_6_PD_S2_Q1_checkBox);
            chk7=(CheckBox)findViewById(R.id.Reason_7_PD_S2_Q1_checkBox);
            chk8=(CheckBox)findViewById(R.id.Reason_8_PD_S2_Q1_checkBox);
            chk9=(CheckBox)findViewById(R.id.Reason_9_PD_S2_Q1_checkBox);
            chk10=(CheckBox)findViewById(R.id.Reason_10_PD_S2_Q1_checkBox);
            chk11=(CheckBox)findViewById(R.id.Reason_11_PD_S2_Q1_checkBox);
            chk12=(CheckBox)findViewById(R.id.Reason_12_PD_S2_Q1_checkBox);

            if(chk1.isChecked()||chk2.isChecked()||chk3.isChecked()||chk4.isChecked()||chk5.isChecked()||chk6.isChecked()||chk7.isChecked()||chk8.isChecked()||chk9.isChecked()||chk10.isChecked()||chk11.isChecked())
            {
                chk12.setChecked(false);
            }
        }
    }
}
