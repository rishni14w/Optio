package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class VaccinationAdd extends AppCompatActivity {

    private EditText editText_Name;
    private EditText editText_Cause;
    private EditText editText_Date;

    //ProgressBar mProgressBar;

    Calendar calendar=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;

    Validation validation=new Validation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.vaccinationAdd_Title);
        setContentView(R.layout.activity_vaccination_add);

        editText_Name=findViewById(R.id.vaccination_name_txt);
        editText_Cause=findViewById(R.id.vaccination_cause_txt);
        editText_Date=findViewById(R.id.date_given_txt);

        //datepicker
        date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
        };

        editText_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(VaccinationAdd.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return true;
    }

    public void updateLabel()
    {
        String format="dd/MM/yyyy";
        SimpleDateFormat sdf=new SimpleDateFormat(format, Locale.US);
        editText_Date.setText(sdf.format(calendar.getTime()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.save)
        {
            String newName=editText_Name.getText().toString();
            String newCause=editText_Cause.getText().toString();
            String newDate=editText_Date.getText().toString();

            Boolean result=validation.isEmpty(newName,newCause,newDate);
            if(result.equals(false))
            {
                new PostData(newName,newCause,newDate).execute(db.getAddressAPI_Vaccination());
            }
            else
            {
                AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("Cannot keep fields empty").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Intent intent=new Intent(VaccinationAdd.this,Vaccination_View.class);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //startActivity(intent);
                        //finish();
                    }
                }).create();
                dialog.show();
            }


        }
        else
        {
            Intent intent=new Intent(this,Vaccination_View.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    //function to add new vaccination
    class PostData extends AsyncTask<String,String,String> {
        String name;
        String cause;
        String date;

        public PostData(String name, String cause, String date) {
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
            //android.os.Debug.waitForDebugger();
            String urlString = params[0];
            HTTPDataHandler hh = new HTTPDataHandler();

            String json = "{\n";
            json += "\t\"name\":\"" + name + "\",\n";
            json += "\t\"cause\":\"" + cause + "\",\n";
            json += "\t\"date\":\"" + date + "\",\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Intent intent = new Intent(VaccinationAdd.this, Vaccination_View.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }


}
