package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class InjuryAdd extends AppCompatActivity {

    private EditText editText_Type;
    private EditText editText_Date;
    private EditText editText_Recovery;
    private EditText editText_Details;

    //ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.injuryAdd_Title);
        setContentView(R.layout.activity_injury_add);

        editText_Type=findViewById(R.id.injury_type_txt);
        editText_Date=findViewById(R.id.date_of_injury_txt);
        editText_Recovery=findViewById(R.id.recovery_duration_txt);
        editText_Details=findViewById(R.id.details_txt);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.save)
        {
            String newType=editText_Type.getText().toString();
            String newDate=editText_Date.getText().toString();
            String newRecovery=editText_Recovery.getText().toString();
            String newDetails=editText_Details.getText().toString();

            new PostData(newType,newDate,newRecovery,newDetails).execute(db.getAddressAPI_Injury());

        }
        else
        {
            Intent intent=new Intent(this,Injury_View.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    //function to add new user
    class PostData extends AsyncTask<String,String,String>
    {
        String type;
        String date;
        String recovery;
        String details;

        public PostData(String type, String date, String recovery, String details) {
            this.type = type;
            this.date = date;
            this.recovery = recovery;
            this.details = details;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @TargetApi(Build.VERSION_CODES.KITKAT)
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... params) {
            //android.os.Debug.waitForDebugger();
            String urlString= params[0];
            HTTPDataHandler hh=new HTTPDataHandler();

            String json="{\n";
            json+="\t\"type\":\""+type+"\",\n";
            json+="\t\"date\":\""+date+"\",\n";
            json+="\t\"recovery\":\""+recovery+"\",\n";
            json+="\t\"details\":\""+details+"\",\n";
            json+="}";
            hh.PostHTTPData(urlString,json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Intent intent=new Intent(InjuryAdd.this,Injury_View.class);
            startActivity(intent);

        }
    }


}
