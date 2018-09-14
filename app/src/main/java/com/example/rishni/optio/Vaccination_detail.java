package com.example.rishni.optio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Vaccination_detail extends AppCompatActivity {

    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/vaccination";

    String id_received;
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

        id_received= getIntent().getExtras().getString("oid");

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
            //new DeleteData(name).execute(db.getAddressSingle_Vaccination(oid));
            new DeleteData().execute();

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
            intent.putExtra("oid",id_received);

            startActivity(intent);

        }
        else
        {
            Intent intent=new Intent(this,Vaccination_View.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    class DeleteData extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            ServerURL = ServerURL+"/"+id_received;
            doDelete();
            return null;
        }

        protected void doDelete()
        {
            try{
                URL url = new URL(ServerURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("DELETE");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.connect();

                conn.getOutputStream();
                try
                {
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());

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
            }
        }

        protected void onPostExecute(Object object) {
            super.onPostExecute(object);
            toastMessage("Successfully deleted");
            Intent intent = new Intent(Vaccination_detail.this, Vaccination_View.class);
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
