package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishni.optio.model.Injury;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Injury_detail extends AppCompatActivity {
    String ServerURL = "https://murmuring-cove-69371.herokuapp.com/injury";

    String id_received;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.injury_detail_Title);
        setContentView(R.layout.activity_injury_detail);

        type= getIntent().getExtras().getString("type");
        ((TextView)findViewById(R.id.injury_type_txt_detail)).setText(type);

        String date= getIntent().getExtras().getString("date");
        ((TextView)findViewById(R.id.date_of_injury_txt_detail)).setText(date);

        String recovery= getIntent().getExtras().getString("recovery");
        ((TextView)findViewById(R.id.recovery_duration_txt_detail)).setText(recovery);

        String details= getIntent().getExtras().getString("details");
        ((TextView)findViewById(R.id.details_txt_detail)).setText(details);

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
            //new DeleteData(type).execute(db.getAddressSingle_Injury(oid));
            new DeleteData().execute();
        }
        if(item.getItemId()==R.id.edit)
        {
            TextView type_value=((TextView)findViewById(R.id.injury_type_txt_detail));
            String type_value_s=type_value.getText().toString();

            TextView date_value=((TextView)findViewById(R.id.date_of_injury_txt_detail));
            String date_value_s=date_value.getText().toString();

            TextView recovery_value=((TextView)findViewById(R.id.recovery_duration_txt_detail));
            String recovery_value_s=recovery_value.getText().toString();

            TextView detail_value=((TextView)findViewById(R.id.details_txt_detail));
            String detail_value_s=detail_value.getText().toString();

            Intent intent=new Intent(Injury_detail.this,InjuryEdit.class);

            intent.putExtra("type_d",type_value_s);
            intent.putExtra("date_d",date_value_s);
            intent.putExtra("recovery_d",recovery_value_s);
            intent.putExtra("details_d",detail_value_s);
            intent.putExtra("oid",id_received);

            startActivity(intent);

        }
        else
        {
            Intent intent=new Intent(this,Injury_View.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    //function to delete injury
    /**class DeleteData extends AsyncTask<String,String,String>
    {
        String injury_type;

        public DeleteData(String injury_type) {
            this.injury_type = injury_type;
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
            String json="{\"type\":\""+injury_type+"\"}";
            hh.DeleteHTTPData(urlString,json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Intent intent=new Intent(Injury_detail.this,Injury_View.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }**/

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
            Intent intent = new Intent(Injury_detail.this, Injury_View.class);
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
