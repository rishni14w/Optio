
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

import com.example.rishni.optio.model.Vaccination;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Vaccination_View extends AppCompatActivity {

    ListView lstView;
    ProgressBar mProgressBar;

    Vaccination vaccinationSelected=null;
    List<Vaccination> vaccinations=new ArrayList<Vaccination>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.vaccination_Title);
        setContentView(R.layout.activity_vaccination);

        lstView=(ListView)findViewById(R.id.lstView_vaccination);

        mProgressBar=(ProgressBar)findViewById(R.id.progressBar_vaccination);
        mProgressBar.setVisibility(View.GONE);

        //load data when app opened
        new GetData().execute(db.getAddressAPI_Vaccination());

        //select item from listview
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vaccinationSelected=vaccinations.get(position);
                String oid=vaccinationSelected.get_id().getOid();
                String name_select=vaccinationSelected.getName();
                String cause_select=vaccinationSelected.getCause();
                String date_select=vaccinationSelected.getDate();

                Intent intent=new Intent(Vaccination_View.this,Vaccination_detail.class);

                intent.putExtra("name",name_select);
                intent.putExtra("cause",cause_select);
                intent.putExtra("date",date_select);
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

            Intent intent=new Intent(this,VaccinationAdd.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.arrow)
        {

            Intent intent=new Intent(this,StressAndHealth.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
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
            Type listType=new TypeToken<List<Vaccination>>(){}.getType();
            vaccinations=gson.fromJson(s,listType);//parse to list
            CustomAdapter_Vaccination adapter=new CustomAdapter_Vaccination(getApplicationContext(),vaccinations);//create adapter
            lstView.setAdapter(adapter); //set adapter to listview
            mProgressBar.setVisibility(View.GONE);
        }
    }

}
