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

public class HeartRate extends AppCompatActivity {
    private EditText editText_Before;
    private EditText editText_After;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.heartrate_Title);
        setContentView(R.layout.activity_heart_rate);

        editText_Before=findViewById(R.id.heart_rate_before_txt);
        editText_After=findViewById(R.id.heart_rate_after_txt);
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
            String newBefore=editText_Before.getText().toString();
            String newAfter=editText_After.getText().toString();

            new PostData(newBefore,newAfter).execute(db.getAddressAPI_Heartrate());

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

<<<<<<< HEAD
    //function to add new heartrate
    /**class PostData extends AsyncTask<String,String,String> {
     String before;
     String after;

     public PostData(String before, String after) {
     this.before = before;
     this.after = after;
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
     json += "\t\"before\":\"" + before + "\",\n";
     json += "\t\"after\":\"" + after + "\",\n";
     json += "}";
     hh.PostHTTPData(urlString, json);
     return "";
     }

     @Override
     protected void onPostExecute(String s) {
     super.onPostExecute(s);
     toastMessage("Successfully saved");
     Intent intent = new Intent(HeartRate.this, StressAndHealth.class);
     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
     startActivity(intent);
     finish();
     }
     }**/

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
                jsonParam.put("date", date);
                jsonParam.put("before", newBefore);
                jsonParam.put("after", newAfter);

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
                Log.i("MSG", conn.getResponseMessage());

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
=======
    //function to add new user
    class PostData extends AsyncTask<String,String,String> {
        String before;
        String after;

        public PostData(String before, String after) {
            this.before = before;
            this.after = after;
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
            json += "\t\"before\":\"" + before + "\",\n";
            json += "\t\"after\":\"" + after + "\",\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
>>>>>>> 8c663238c12b171f34e850120dbd6f8a52a90673
            toastMessage("Successfully saved");
            Intent intent = new Intent(HeartRate.this, StressAndHealth.class);
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
