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

public class Sleep extends AppCompatActivity {

    private EditText editText_Hour;
    private EditText editText_Min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sleep_Title);
        setContentView(R.layout.activity_sleep);

        editText_Hour=findViewById(R.id.digit_hr);
        editText_Min=findViewById(R.id.digit_min);
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
            String newHour=editText_Hour.getText().toString();
            String newMin=editText_Min.getText().toString();
            String duration=newHour+" hr and "+newMin+" min";

            new PostData(duration).execute(db.getAddressAPI_Sleep());

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
        String duration;

        public PostData(String duration) {
            this.duration = duration;
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
            json += "\t\"duration\":\"" + duration + "\",\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            toastMessage("Successfully saved");
            Intent intent = new Intent(Sleep.this, StressAndHealth.class);
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
