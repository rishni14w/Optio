package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class WorkOutOptions extends AppCompatActivity {
    boolean displayEquipment = false;
    RadioGroup placeGroup;
    RadioGroup complexityGroup;
    RadioButton normalComplexityRB;
    RadioButton advancedComplexityRB;
    TextView complexityRecomLbl;
    CheckBox equipmentCheckBox;
    RadioButton homeRB;
    RadioButton GymRB;
    TextView equipmentLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_options);
        equipmentLbl = (TextView)findViewById(R.id.equipMentLabel);
        equipmentLbl.setVisibility(View.INVISIBLE);
        equipmentCheckBox = (CheckBox)findViewById(R.id.equipmentCheckBox);
        equipmentCheckBox.setVisibility(View.INVISIBLE);

    }
}
