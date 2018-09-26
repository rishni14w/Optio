package com.example.rishni.optio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.rishni.optio.model.InputSuggestion;

import java.util.List;

public class CustomAdapter_Recommendation extends BaseAdapter {
    private Context mContext;
    private List<InputSuggestion> lstInput;
    String[] suggestionArr;

    public CustomAdapter_Recommendation(Context mContext, List<InputSuggestion> lstInput) {
        this.mContext = mContext;
        this.lstInput = lstInput;
    }
    @Override
    public int getCount() {
        return lstInput.size();
    }

    @Override
    public Object getItem(int position) {
        return lstInput.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.recommend_row,null);

        TextView txtInput=(TextView)view.findViewById(R.id.inputted_concern_tv);
        txtInput.setText(lstInput.get(position).getInput());

        //TextView txtSuggestion=(TextView)view.findViewById(R.id.suggestions_tv);
        //ListView lstSuggestion=(ListView)view.findViewById(R.id.lstView_suggestion);
        //String[] suggestionArr= (String[]) lstInput.get(position).getSuggestion().toArray();
        /**for(String suggestion : suggestionArr)
        {
            txtSuggestion.setText(suggestion);
        } **/
        /**for (int i=0; i<suggestionArr.length;i++)
        {
            lstInput.append(suggestionArr[i]);
        } **/

        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,suggestionArr);
        //lstSuggestion.setAdapter(adapter);

        return view;

    }
}


/**
 public class CustomAdapter_Recommendation extends BaseExpandableListAdapter {
 private Context mContext;
 private List<InputSuggestion> lstRecommend;
 ExpandableListView _list;

 public CustomAdapter_Recommendation(Context mContext, ExpandableListView list) {
 this.mContext = mContext;
 this._list = list;
 }


 public int getCount() {
 return lstRecommend.size();
 }


 public Object getItem(int position) {
 return lstRecommend.get(position);
 }


 public long getItemId(int position) {
 return position;
 }
 /**
 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
 LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 View view=inflater.inflate(R.layout.recommend_row,null);

 /**TextView txtInput=(TextView)view.findViewById(R.id.inputted_concern_tv);
 txtInput.setText(lstRecommend.get(position).getInput());

 CustomAdapter_Recommendation adapter=new CustomAdapter_Recommendation(getApplicationContext(),inputsuggestions);//create adapter
 lstView.setAdapter(adapter);;

 return view;
 }
 **/
//
/**
public Object getChild(int groupPosition, int childPosition) {
    return null;
}

    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            System.out.println("---getChildView --convertView == null");
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.suggestion_child_row, null);
        }
        TextView suggestion = (TextView) convertView.findViewById(R.id.suggestions_tv);
        suggestion.setText((lstRecommend.get(groupPosition).getSuggestion(childPosition)));

        return convertView;
    }


    public int getChildrenCount(int groupPosition) {
        return lstRecommend.get(groupPosition).getSuggestion().size();
    }

    public Object getGroup(int groupPosition) {
        return null;
    }

    public int getGroupCount() {
        return 0; //
    }

    public long getGroupId(int groupPosition) {
        return 0;
    }

    // Return a group view. You can load your custom layout here.
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,ViewGroup parent) {
        System.out.println("---getGroupView --");
        String group = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_input_row, null);
        }

        //TextView tv = (TextView) convertView.findViewById(R.id.tvGroup);
        // tv.setText(group);
        TextView tvGroupInput= (TextView) convertView.findViewById(R.id.input_tv);
        _list.expandGroup(groupPosition);  //used to Expand the child list automatically at the time of displaying
        return convertView;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
**/