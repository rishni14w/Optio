package com.example.rishni.optio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rishni.optio.model.Injury;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private List<Injury> lstInjury;

    public CustomAdapter(Context mContext, List<Injury> lstInjury) {
        this.mContext = mContext;
        this.lstInjury = lstInjury;
    }

    @Override
    public int getCount() {
        return lstInjury.size();
    }

    @Override
    public Object getItem(int position) {
        return lstInjury.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.injury_row,null);

        TextView txtType=(TextView)view.findViewById(R.id.txt_injuryType);
        txtType.setText(lstInjury.get(position).getType());

        TextView txtDate=(TextView)view.findViewById(R.id.txt_dateOfInjury);
        txtDate.setText(lstInjury.get(position).getDate());

        TextView txtRecovery=(TextView)view.findViewById(R.id.txt_recoveryDuration);
        txtRecovery.setText(lstInjury.get(position).getRecovery());

        //TextView txtDetail=(TextView)view.findViewById(R.id.txt_details);
        //txtDetail.setText(lstInjury.get(position).getDetails());

        return view;
    }
}
