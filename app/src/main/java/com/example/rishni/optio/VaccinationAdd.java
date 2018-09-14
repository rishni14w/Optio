package com.example.rishni.optio;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class VaccinationAdd extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/vaccination";

    private EditText editText_Name;
    private EditText editText_Cause;
    private EditText editText_Date;

    String nic;
    String newName;
    String newCause;
    String newDate;

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

        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("AthletePref",0);
        nic=sharedPref.getString("AthleteNic","");

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
            newName=editText_Name.getText().toString();
            newCause=editText_Cause.getText().toString();
            newDate=editText_Date.getText().toString();

            Boolean result=validation.isEmpty(newName,newCause,newDate);
            if(result.equals(false))
            {
                new SendData().execute();
            }
            else
            {
                AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("Cannot keep fields empty").setPositiveButton("OK",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

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

   //post vaccination details
   class SendData extends AsyncTask {

       @Override
       protected Object doInBackground(Object[] objects) {
           doPost();
           return null;
       }

       protected void doPost() {
           try {
               URL url = new URL(ServerURL);
               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("POST");
               conn.setRequestProperty("Content-Type", "application/json");
               conn.setRequestProperty("Accept", "application/json");
               conn.setDoOutput(true);
               conn.setDoInput(true);
               conn.connect();

               JSONObject jsonParam = new JSONObject();
               jsonParam.put("nic", nic);
               jsonParam.put("name", newName);
               jsonParam.put("cause", newCause);
               jsonParam.put("date", newDate);


               conn.getOutputStream();
               try {
                   DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                   os.writeBytes(jsonParam.toString());

                   os.flush();
                   os.close();
               } catch (MalformedURLException e) {
                   e.printStackTrace();
               } catch (ProtocolException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }

               Log.i("STATUS", String.valueOf(conn.getResponseCode()));
               Log.i("MSG" , conn.getResponseMessage());

               conn.disconnect();

           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (ProtocolException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }

       protected void onPostExecute(Object object) {
           super.onPostExecute(object);
           toastMessage("Successfully saved");
           Intent intent = new Intent(VaccinationAdd.this, Vaccination_View.class);
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
