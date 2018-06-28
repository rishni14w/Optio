package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Vaccination_detail extends AppCompatActivity {
    String oid;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.vaccination_detail_Title);
        setContentView(R.layout.activity_vaccination_detail);

        name= getIntent().getExtras().getString("name");
        ((TextView)findViewById(R.id.vaccination_name_txt_detail)).setText(name);

        String cause= getIntent().getExtras().getString("cause");
        ((TextView)findViewById(R.id.vaccination_cause_txt_detail)).setText(cause);

        String date= getIntent().getExtras().getString("date");
        ((TextView)findViewById(R.id.date_given_txt_detail)).setText(date);

        oid= getIntent().getExtras().getString("oid");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_edit_delete,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.delete)
        {
            new DeleteData(name).execute(db.getAddressSingle_Vaccination(oid));

        }
        if(item.getItemId()==R.id.edit)
        {
            TextView name_value=((TextView)findViewById(R.id.vaccination_name_txt_detail));
            String name_value_s=name_value.getText().toString();

            TextView cause_value=((TextView)findViewById(R.id.vaccination_cause_txt_detail));
            String cause_value_s=cause_value.getText().toString();

            TextView date_value=((TextView)findViewById(R.id.date_given_txt_detail));
            String date_value_s=date_value.getText().toString();;

            Intent intent=new Intent(Vaccination_detail.this,VaccinationEdit.class);

            intent.putExtra("name_d",name_value_s);
            intent.putExtra("cause_d",cause_value_s);
            intent.putExtra("date_d",date_value_s);
            intent.putExtra("oid",oid);

            startActivity(intent);

        }
        else
        {
            Intent intent=new Intent(this,Vaccination_View.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    //function to delete injury
    class DeleteData extends AsyncTask<String,String,String>
    {
        String vaccination_name;

        public DeleteData(String vaccination_name) {
            this.vaccination_name = vaccination_name;
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
            String json="{\"name\":\""+vaccination_name+"\"}";
            hh.DeleteHTTPData(urlString,json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Intent intent=new Intent(Vaccination_detail.this,Vaccination_View.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }
}
