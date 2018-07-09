package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Important: This activity is meant to serve as the initial profile page where the athlete is suppose to enter his details
//on registration. Any details that is meant to be entered only once should go here.
//Any details that change such as weight etc should go on a different activity to preserve clarity.
public class ProfileInitialize extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_initialize);
    }
}
