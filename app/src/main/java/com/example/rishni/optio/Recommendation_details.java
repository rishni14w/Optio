package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Recommendation_details extends AppCompatActivity {
    String id_received;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Suggestions");
        setContentView(R.layout.activity_recommendation_details);

        String input= getIntent().getExtras().getString("input");
        ((TextView)findViewById(R.id.suggestion_1_detail)).setText(input);

        String suggestions= getIntent().getExtras().getString("suggestion");

        //for (int i=0;i<=(suggestions.length-1);i++)
        //{
            //if(i==0)
            //{
        ((TextView)findViewById(R.id.suggestion_1_detail)).setText(suggestions);
            //}
           // else if()
       // }




        id_received= getIntent().getExtras().getString("oid");
    }
}
