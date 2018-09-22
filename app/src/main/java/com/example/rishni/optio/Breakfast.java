package com.example.rishni.optio;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by Sewmi on 18/07/21.
 */

public class Breakfast extends Fragment{

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.breakfast,container,false);
        return rootView;
    }
}
