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
import android.widget.TextView;
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

public class VaccinationEdit extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/vaccination";

    String id_received;
    String name;
    String updateName;
    String updateCause;
    String updateDate;
    String nic;

    private EditText editText_Name_edit;
    private EditText editText_Cause_edit;
    private EditText editText_Date_edit;

    Calendar calendar=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datep;

    Validation validation=new Validation();
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


        id_received= getIntent().getExtras().getString("oid");

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

        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("AthletePref",0);
        nic=sharedPref.getString("AthleteNic","");
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
            updateName=editText_Name_edit.getText().toString();
            updateCause=editText_Cause_edit.getText().toString();
            updateDate=editText_Date_edit.getText().toString();

            Boolean result=validation.isEmpty(updateName,updateCause,updateDate);
            if(result.equals(false))
            {
                new PutData().execute();
            }
            else
            {
                AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("Cannot keep fields empty").setPositiveButton("OK", new DialogInterface.OnClickListener() {
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

   class PutData extends AsyncTask{

       @Override
       protected Object doInBackground(Object[] objects) {
           ServerURL = ServerURL+"/"+id_received;
           doPut();
           return null;
       }

       protected void doPut()
       {
           try{
               URL url = new URL(ServerURL);
               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("PUT");
               conn.setRequestProperty("Content-Type", "application/json");
               conn.setRequestProperty("Accept","application/json");
               conn.setDoOutput(true);
               conn.setDoInput(true);
               conn.connect();

               JSONObject jsonParam = new JSONObject();
               jsonParam.put("nic",nic);
               jsonParam.put("name",updateName);
               jsonParam.put("cause",updateCause);
               jsonParam.put("date",updateDate);

               conn.getOutputStream();
               try
               {
                   DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                   os.writeBytes(jsonParam.toString());

                   os.flush();
                   os.close();
               }catch (MalformedURLException e) {
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
           toastMessage("Successfully updated");
           Intent intent = new Intent(VaccinationEdit.this, Vaccination_View.class);
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
