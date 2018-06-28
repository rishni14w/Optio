package com.example.rishni.optio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rishni.optio.model.Vaccination;

import java.util.List;

public class CustomAdapter_Vaccination extends BaseAdapter {
    private Context mContext;
    private List<Vaccination> lstVaccination;

    public CustomAdapter_Vaccination(Context mContext, List<Vaccination> lstVaccination) {
        this.mContext = mContext;
        this.lstVaccination = lstVaccination;
    }

    @Override
    public int getCount() {
        return lstVaccination.size();
    }

    @Override
    public Object getItem(int position) {
        return lstVaccination.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.vaccination_row,null);

        TextView txtName=(TextView)view.findViewById(R.id.txt_vaccinationName);
        txtName.setText(lstVaccination.get(position).getName());

        //TextView txtCause=(TextView)view.findViewById(R.id.txt_vaccinationCause);
        //txtCause.setText(lstVaccination.get(position).getCause());

        TextView txtDate=(TextView)view.findViewById(R.id.txt_vaccinationDate);
        txtDate.setText(lstVaccination.get(position).getDate());

        return view;
    }
}
