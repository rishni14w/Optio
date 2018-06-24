package com.example.rishni.optio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.rishni.optio.model.Id;
import com.example.rishni.optio.model.Injury;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Injury_View extends AppCompatActivity {

    ListView lstView;
    ProgressBar mProgressBar;

    Injury injurySelected=null;
    List<Injury> injurys=new ArrayList<Injury>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.injury_Title);
        setContentView(R.layout.activity_injury);

        lstView=(ListView)findViewById(R.id.lstView);

        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        //load data when app opened
        new GetData().execute(db.getAddressAPI_Injury());

        //select item from listview
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                injurySelected=injurys.get(position);
                String oid=injurySelected.get_id().getOid();
                String type_select=injurySelected.getType();
                String date_select=injurySelected.getDate();
                String recovery_select=injurySelected.getRecovery();
                String details_select=injurySelected.getDetails();

                Intent intent=new Intent(Injury_View.this,Injury_detail.class);

                intent.putExtra("type",type_select);
                intent.putExtra("date",date_select);
                intent.putExtra("recovery",recovery_select);
                intent.putExtra("details",details_select);
                intent.putExtra("oid",oid);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add)
        {

            Intent intent=new Intent(this,InjuryAdd.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    //function process data
    class GetData extends AsyncTask<String,Void,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... params) {
            //running process
            String stream=null;
            String urlString= params[0];

            HTTPDataHandler http=new HTTPDataHandler();
            stream=http.GetHTTPData(urlString);
            return stream;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //done process

            //use GSon to parse JSON to class
            Gson gson=new Gson();
            Type listType=new TypeToken<List<Injury>>(){}.getType();
            injurys=gson.fromJson(s,listType);//parse to list
            CustomAdapter adapter=new CustomAdapter(getApplicationContext(),injurys);//create adapter
            lstView.setAdapter(adapter); //set adapter to listview
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
