package com.example.rishni.optio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.rishni.optio.model.Injury;
import com.example.rishni.optio.model.InputSuggestion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recommendation extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/inputSuggestion";
    ListView lstView;
    ProgressBar mProgressBar;

    //public ExpandableListView listView;
    //public ExpandableListAdapter listAdapter;
    //public List<String> listDataHeader;
    //public HashMap<String,List<String>> listHash;

    InputSuggestion inputsuggestionSelected=null;
    List<InputSuggestion> inputsuggestions=new ArrayList<InputSuggestion>();

    String nic;
    public static String stream=null;

    //private List<InputSuggestion> lstInput;
    //public String[] suggestionArr;

    //public String input;
    //public String[] inputArr;

    //public String recommend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.recommendation_Title);
        setContentView(R.layout.activity_recommendation);

        lstView=(ListView)findViewById(R.id.lstView);


        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        //elstView.setGroupIndicator(null);

        //elstView.setGroupIndicator(null);
        //elstView.setChildIndicator(null);
        //elstView.setChildDivider(getResources().getDrawable(R.color.colorAccent));
        //elstView.setDivider(getResources().getDrawable(R.color.colorPrimary));
        //elstView.setDividerHeight(2);

        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("AthletePref",0);
        nic=sharedPref.getString("AthleteNic","");

        //load data when app opened
        new GetData().execute();

        //listView=(ExpandableListView)this.findViewById(R.id.expandableListView_elst);

        //initData();

        //listAdapter=new ExpandableListAddapter_Recommend(this,this.listDataHeader,this.listHash);
        //listView.setAdapter(listAdapter);

        //select item from listview
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                inputsuggestionSelected=inputsuggestions.get(position);
                String oid=inputsuggestionSelected.getId();
                String input_select=inputsuggestionSelected.getInput();
                //String[] suggestion_select= (String[]) inputsuggestionSelected.getSuggestion().toArray();
                List suggestion_select= inputsuggestionSelected.getSuggestion();

                Intent intent=new Intent(Recommendation.this,Recommendation_details.class);

                intent.putExtra("input",input_select);
                intent.putExtra("suggestion", String.valueOf(suggestion_select));
                intent.putExtra("oid",oid);
                startActivity(intent);

            }
        });
    }


    private class GetData extends AsyncTask<Void,Void,Void> {

        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);

        }
        @Override
        protected Void doInBackground(Void... voids) {
            ServerURL = ServerURL+"/"+nic;
            doGet();

            return null;
        }
        protected void doGet()
        {
            try
            {
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                //check the connection status
                if(conn.getResponseCode()==200)
                {
                    //if response code=200 - HTTP.OK
                    InputStream in=new BufferedInputStream(conn.getInputStream());

                    //read the BufferedInputStream
                    BufferedReader r=new BufferedReader(new InputStreamReader(in));
                    StringBuilder sb=new StringBuilder();
                    String line;
                    while ((line=r.readLine())!=null)
                    {
                        sb.append(line);
                    }
                    stream=sb.toString();
                    conn.disconnect();
                }

                else
                {

                }

                Gson gson=new Gson();
                Type listType=new TypeToken<List<InputSuggestion>>(){}.getType();
                inputsuggestions=gson.fromJson(stream,listType);//parse to list



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        protected void onPostExecute(Void voids) {
            super.onPostExecute(voids);
               CustomAdapter_Recommendation adapter=new CustomAdapter_Recommendation(getApplicationContext(),inputsuggestions);//create adapter
               lstView.setAdapter(adapter); //set adapter to listview

           // elstView.setAdapter(new CustomAdapter_Recommendation(getApplicationContext(),elstView));

            //ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,suggestionArr);
            mProgressBar.setVisibility(View.GONE);
        }
    }
/**
    public void initData()
    {
        this.listDataHeader = new ArrayList<String>();
        this.listHash = new HashMap<String,List<String>>();
       /** for (int i=0;i<(inputsuggestions.size()-1);i++)
        {
            input = inputsuggestions.get(i).getInput();
            listDataHeader.add(input);

            /**List<String> a= new ArrayList<>();
            for (int j=0;j<((inputsuggestions.get(i).getSuggestion().size())-1);j++)
            {
                recommend=inputsuggestions.get(i).getSuggestion().get(j).toString();

                a.add(recommend);
            }
            listHash.put(listDataHeader.get(i),a);

        //}

        listDataHeader.add("b");
        listDataHeader.add("c");
        listDataHeader.add("d");
        listDataHeader.add("e");
        listDataHeader.add("f");
        listDataHeader.add("g");
        listDataHeader.add("h");
        listDataHeader.add("i");
        List<String> b=new ArrayList<>();
        b.add("b1");
        b.add("b2");

        List<String> c=new ArrayList<>();
        c.add("c1");
        c.add("c2");

        List<String> d=new ArrayList<>();
        d.add("d1");
        d.add("d2");
        d.add("d3");
        d.add("d4");

        List<String> e=new ArrayList<>();
        e.add("e1");
        e.add("e2");

        List<String> f=new ArrayList<>();
        f.add("f1");
        f.add("f2");

        List<String> g=new ArrayList<>();
        g.add("g1");
        g.add("g2");
        g.add("g3");
        g.add("g4");

        List<String> h=new ArrayList<>();
        h.add("h1");
        h.add("h2");

        List<String> i=new ArrayList<>();
        i.add("i1");
        i.add("i2");
        i.add("i3");
        i.add("i4");

        this.listHash.put(this.listDataHeader.get(0),b);
        this.listHash.put(this.listDataHeader.get(1),c);
        this.listHash.put(this.listDataHeader.get(2),d);
        this.listHash.put(this.listDataHeader.get(3),e);
        this.listHash.put(this.listDataHeader.get(4),f);
        this.listHash.put(this.listDataHeader.get(5),g);
        this.listHash.put(this.listDataHeader.get(6),h);
        this.listHash.put(this.listDataHeader.get(7),i);


        //CustomAdapter_Recommendation cr=new CustomAdapter_Recommendation(getApplicationContext(),inputsuggestions);//create adapter
        //suggestionArr=cr.suggestionArr;

        //listDataHeader.add();
    } **/
}
