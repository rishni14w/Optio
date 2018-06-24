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
import android.widget.TextView;

public class InjuryEdit extends AppCompatActivity {
    String oid;
    String type;

    private EditText editText_Type_edit;
    private EditText editText_Date_edit;
    private EditText editText_Recovery_edit;
    private EditText editText_Details_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.injury_edit_Title);
        setContentView(R.layout.activity_injury_edit);

        type= getIntent().getExtras().getString("type_d");
        ((TextView)findViewById(R.id.injury_type_txt_edit)).setText(type);

        String date= getIntent().getExtras().getString("date_d");
        ((TextView)findViewById(R.id.date_of_injury_txt_edit)).setText(date);

        String recovery= getIntent().getExtras().getString("recovery_d");
        ((TextView)findViewById(R.id.recovery_duration_txt_edit)).setText(recovery);

        String details= getIntent().getExtras().getString("details_d");
        ((TextView)findViewById(R.id.details_txt_edit)).setText(details);

        oid= getIntent().getExtras().getString("oid");

        editText_Type_edit=findViewById(R.id.injury_type_txt_edit);
        editText_Date_edit=findViewById(R.id.date_of_injury_txt_edit);
        editText_Recovery_edit=findViewById(R.id.recovery_duration_txt_edit);
        editText_Details_edit=findViewById(R.id.details_txt_edit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_update,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.update)
        {
            String updateType=editText_Type_edit.getText().toString();
            String updateDate=editText_Date_edit.getText().toString();
            String updateRecovery=editText_Recovery_edit.getText().toString();
            String updateDetails=editText_Details_edit.getText().toString();

            new PutData(updateType,updateDate,updateRecovery,updateDetails).execute(db.getAddressSingle_Injury(oid));

        }

        else
        {
            Intent intent=new Intent(this,Injury_View.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    //function to edit user
    class PutData extends AsyncTask<String,String,String>
    {
        String type;
        String date;
        String recovery;
        String details;

        public PutData(String type, String date, String recovery, String details) {
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
            String urlString= params[0];
            HTTPDataHandler hh=new HTTPDataHandler();
            String json="{\n";
            json+="\t\"type\":\""+type+"\",\n";
            json+="\t\"date\":\""+date+"\",\n";
            json+="\t\"recovery\":\""+recovery+"\",\n";
            json+="\t\"details\":\""+details+"\",\n";
            json+="}";
            hh.PutHTTPData(urlString,json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Intent intent=new Intent(InjuryEdit.this,Injury_View.class);
            startActivity(intent);
        }
    }
}
