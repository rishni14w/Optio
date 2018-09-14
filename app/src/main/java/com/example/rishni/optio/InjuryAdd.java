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

public class InjuryAdd extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/injury";
    private EditText editText_Type;
    private EditText editText_Date;
    private EditText editText_Recovery;
    private EditText editText_Details;


    Calendar calendar=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;

    Validation validation=new Validation();

    String nic;
    String newType;
    String newDate;
    String newRecovery;
    String newDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.injuryAdd_Title);
        setContentView(R.layout.activity_injury_add);

        editText_Type=findViewById(R.id.injury_type_txt);
        editText_Date=findViewById(R.id.date_of_injury_txt);
        editText_Recovery=findViewById(R.id.recovery_duration_txt);
        editText_Details=findViewById(R.id.details_txt);

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
                new DatePickerDialog(InjuryAdd.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
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
            newType=editText_Type.getText().toString();
            newDate=editText_Date.getText().toString();
            newRecovery=editText_Recovery.getText().toString();
            newDetails=editText_Details.getText().toString();

            Boolean result=validation.isEmpty(newType,newDate);
            if(result.equals(false))
            {
                new SendData().execute();
            }
            else
            {
                AlertDialog dialog=new AlertDialog.Builder(this).setTitle("Error").setMessage("Both injury type and date of injury are required").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
                dialog.show();
            }

        }
        else
        {
            Intent intent=new Intent(this,Injury_View.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    //post injury details
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
                jsonParam.put("type", newType);
                jsonParam.put("date", newDate);
                jsonParam.put("recovery", newRecovery);
                jsonParam.put("details", newDetails);


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
            Intent intent = new Intent(InjuryAdd.this, Injury_View.class);
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
