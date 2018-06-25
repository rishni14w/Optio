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
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class BodyComposition extends AppCompatActivity {
    private EditText editText_weight;
    private EditText editText_waist;
    private EditText editText_hip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.bodycomposition_Title);
        setContentView(R.layout.activity_body_composition);

        editText_weight=findViewById(R.id.weight_txt);
        editText_waist=findViewById(R.id.waist_circumference_txt);
        editText_hip=findViewById(R.id.hip_circumference_txt);
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
            String newWeight=editText_weight.getText().toString();
            String newWaist=editText_waist.getText().toString();
            String newHip=editText_hip.getText().toString();

            Date currentTime= Calendar.getInstance().getTime();
            String date=currentTime.toString();
            //toastMessage("date = "+currentTime);
            new PostData(newWeight,newWaist,newHip,date).execute(db.getAddressAPI_BodyComposition());

        }
        else
        {
            Intent intent=new Intent(this,StressAndHealth.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    //function to add new user
    class PostData extends AsyncTask<String,String,String> {
        String weight;
        String waist;
        String hip;
        String date;

        public PostData(String weight, String waist, String hip, String date) {
            this.weight = weight;
            this.waist = waist;
            this.hip = hip;
            this.date = date;
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
            String urlString = params[0];
            HTTPDataHandler hh = new HTTPDataHandler();

            String json = "{\n";
            json += "\t\"weight\":\"" + weight + "\",\n";
            json += "\t\"waist\":\"" + waist + "\",\n";
            json += "\t\"hip\":\"" + hip + "\",\n";
            json += "\t\"date\":\"" + date + "\",\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            toastMessage("Successfully saved");
            Intent intent = new Intent(BodyComposition.this, StressAndHealth.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
