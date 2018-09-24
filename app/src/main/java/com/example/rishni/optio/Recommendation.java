package com.example.rishni.optio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.rishni.optio.model.Injury;

import java.util.ArrayList;
import java.util.List;

public class Recommendation extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/injury";
    ListView lstView;
    ProgressBar mProgressBar;

    Injury injurySelected=null;
    List<Injury> injurys=new ArrayList<Injury>();

    String nic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.recommendation_Title);
        setContentView(R.layout.activity_recommendation);
    }
}
