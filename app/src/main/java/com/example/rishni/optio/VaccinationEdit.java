package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class VaccinationEdit extends AppCompatActivity {

    String oid;
    String name;

    private EditText editText_Name_edit;
    private EditText editText_Cause_edit;
    private EditText editText_Date_edit;

    Calendar calendar=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.vaccination_edit_Title);
        setContentView(R.layout.activity_vaccination_edit);

        name= getIntent().getExtras().getString("name_d");
        ((TextView)findViewById(R.id.vaccination_name_txt_edit)).setText(name);

        String cause= getIntent().getExtras().getString("cause_d");
        ((TextView)findViewById(R.id.vaccination_cause_txt_edit)).setText(cause);

        String date= getIntent().getExtras().getString("date_d");
        ((TextView)findViewById(R.id.date_given_txt_edit)).setText(date);


        oid= getIntent().getExtras().getString("oid");

        editText_Name_edit=findViewById(R.id.vaccination_name_txt_edit);
        editText_Cause_edit=findViewById(R.id.vaccination_cause_txt_edit);
        editText_Date_edit=findViewById(R.id.date_given_txt_edit);

        //datepicker
        datep=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
        };

        editText_Date_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(VaccinationEdit.this,datep,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_update,menu);
        return true;
    }

    public void updateLabel()
    {
        String format="dd/MM/yyyy";
        SimpleDateFormat sdf=new SimpleDateFormat(format, Locale.US);
        editText_Date_edit.setText(sdf.format(calendar.getTime()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.update)
        {
            String updateName=editText_Name_edit.getText().toString();
            String updateCause=editText_Cause_edit.getText().toString();
            String updateDate=editText_Date_edit.getText().toString();

            new PutData(updateName,updateCause,updateDate).execute(db.getAddressSingle_Vaccination(oid));

        }

        else
        {
            Intent intent=new Intent(this,Vaccination_View.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }


    //function to edit vaccination
    class PutData extends AsyncTask<String,String,String>
    {
        String name;
        String cause;
        String date;

        public PutData(String name, String cause, String date) {
            this.name = name;
            this.cause = cause;
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
            String urlString= params[0];
            HTTPDataHandler hh=new HTTPDataHandler();
            String json="{\n";
            json+="\t\"name\":\""+name+"\",\n";
            json+="\t\"cause\":\""+cause+"\",\n";
            json+="\t\"date\":\""+date+"\",\n";
            json+="}";
            hh.PutHTTPData(urlString,json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Intent intent=new Intent(VaccinationEdit.this,Vaccination_View.class);
            startActivity(intent);
        }
    }

}
