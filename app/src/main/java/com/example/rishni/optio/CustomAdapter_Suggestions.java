package com.example.rishni.optio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rishni.optio.model.InputSuggestion;

import java.util.List;

public class CustomAdapter_Suggestions extends BaseAdapter {
    private Context mContext;
    private List<InputSuggestion> lstSuggestion;

    public CustomAdapter_Suggestions(Context mContext, List<InputSuggestion> lstSuggestion) {
        this.mContext = mContext;
        this.lstSuggestion = lstSuggestion;
    }


    @Override
    public int getCount() {
        return lstSuggestion.size();
    }

    @Override
    public Object getItem(int position) {
        return lstSuggestion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.recommend_row,null);

        //TextView txtSuggestion=(TextView)view.findViewById(R.id.suggestions_tv);
        //txtSuggestion.setText(lstSuggestion.get(position).getSuggestion().);

        return view;

    }
}
