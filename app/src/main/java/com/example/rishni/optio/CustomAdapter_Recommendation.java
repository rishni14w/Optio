package com.example.rishni.optio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.rishni.optio.model.InputSuggestion;

import java.util.List;

public class CustomAdapter_Recommendation extends BaseAdapter {
    private Context mContext;
    private List<InputSuggestion> lstRecommend;

    public CustomAdapter_Recommendation(Context mContext, List<InputSuggestion> lstRecommend) {
        this.mContext = mContext;
        this.lstRecommend = lstRecommend;
    }

    @Override
    public int getCount() {
        return lstRecommend.size();
    }

    @Override
    public Object getItem(int position) {
        return lstRecommend.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.recommend_row,null);

        TextView txtType=(TextView)view.findViewById(R.id.txt_recommendation);
        txtType.setText(lstRecommend.get(position).getSuggestion());

        return view;
    }
}
