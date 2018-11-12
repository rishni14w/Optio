package com.example.rishni.optio.model;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

//import com.example.rishni.optio.CustomizeMealPlans;
//import com.example.rishni.optio.MealPlans;
import com.example.rishni.optio.CustomizeMealPlans;
import com.example.rishni.optio.MealPlans;
import com.example.rishni.optio.R;
import com.loopj.android.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

//import static com.example.rishni.optio.R.anim.cursor_move_normal;

public class DietHome extends AppCompatActivity {
    public TextView age, feet, inches, pounds, result_txt, Check_result, calorie;
    public String IDNumber ="937030045V";
    public String saveddata ="";
    public JSONObject jsono;
    private Button btn, rest_btn, diet_btn, junk_button, statics_btn, cross_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_diet_home);


        calorie = (TextView) findViewById(R.id.cal_final);

        new JSONAsyncTask().execute();
        new Final().execute();
//        JSONAsyncTask newJsonAsyncTask = new JSONAsyncTask();

// menu button  Start here////

        btn = (Button)findViewById(R.id.menu_button);
        rest_btn  = (Button)findViewById(R.id.Rest_btn);
        rest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(DietHome.this,GenerateDietPlan.class));
            }
        });

        diet_btn = (Button)findViewById(R.id.Diet_btn);
        diet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(ResultActivity.this,DietPlanActivity.class));
                //startActivity(new Intent(activity_generate_diet.this,GenerateDietPlan.class));
                startActivity(new Intent(DietHome.this,MealPlans.class));
//                Intent i= new Intent(DietHome.this,GenerateDietPlan.class);
//                startActivity(i);
            }
        });

        junk_button =(Button)findViewById(R.id.junkbutton);
        junk_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //       startActivity(new Intent(DietHome.this,ExercisesActivity.class));
                startActivity(new Intent(DietHome.this, CustomizeMealPlans.class));
            }
        });
        statics_btn = (Button)findViewById(R.id.Static_btn);
        statics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      startActivity(new Intent(DietHome.this,CaloriesActivity.class));
            }
        });
        cross_btn =(Button)findViewById(R.id.cross_btn);
    }
    public void btnClicked(View view) {
        btn.setVisibility(View.INVISIBLE);
        btn.startAnimation(buttonClick);


        rest_btn.setVisibility(View.VISIBLE);
        rest_btn.animate().alpha(1.0f).setDuration(400);

        diet_btn.setVisibility(View.VISIBLE);
        diet_btn.animate().alpha(1.0f).setDuration(400);

        junk_button.setVisibility(View.VISIBLE);
        junk_button.animate().alpha(1.0f).setDuration(400);

        statics_btn.setVisibility(View.VISIBLE);
        statics_btn.animate().alpha(1.0f).setDuration(400);

        cross_btn.setVisibility(View.VISIBLE);
        cross_btn.startAnimation(buttonClick);


    }
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    public void btn2Clicked(View view) {
        btn.setVisibility(View.VISIBLE);
        btn.startAnimation(buttonClick);

        rest_btn.setVisibility(View.INVISIBLE);
        rest_btn.animate().alpha(0.0f).setDuration(400);

        diet_btn.setVisibility(View.INVISIBLE);
        diet_btn.animate().alpha(0.0f).setDuration(400);

        junk_button.setVisibility(View.INVISIBLE);
        junk_button.animate().alpha(0.0f).setDuration(400);

        statics_btn.setVisibility(View.INVISIBLE);
        statics_btn.animate().alpha(0.0f).setDuration(400);

        cross_btn.setVisibility(View.INVISIBLE);
        cross_btn.startAnimation(buttonClick);

    }
    // menu button  End here////

    private class Final extends AsyncTask<String, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        public Void doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet("https://murmuring-cove-69371.herokuapp.com/calorie/"+IDNumber);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    jsono = new JSONObject(data);

                    if(jsono != null){
                        Log.e("CalaryDataFinal",jsono.toString());
                        Log.e("cal",jsono.getString("totalCalorie"));
                    }
                    return null;

                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {

                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void voids) {
            super.onPostExecute(voids);
            findViewById(R.id.cal_final).setVisibility(View.VISIBLE);
            try {
                calorie.setText(jsono.getString("totalCalorie"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

//    protected String doInBackground(String... strings) {
//
//        String response = "";
//        Context context = getApplicationContext();
//        CharSequence text = "Hello toast!";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//
//
//        response = ServiceHandler.findJSONFromUrl("https://murmuring-cove-69371.herokuapp.com/getAthlete/937030045V");
//        String data = response;
//        return response;
//    }


    }

    public class REST extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            HttpURLConnection urlConnection=null;
            String json = null;
            // The Username & Password

            // -----------------------

            try {
                HttpResponse response;
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("nic", "937030045V");
                json = jsonObject.toString();
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("https://murmuring-cove-69371.herokuapp.com/calorie/");
                httpPost.setEntity(new StringEntity(json, "UTF-8"));
                httpPost.setHeader("Content-Type", "application/json");
                httpPost.setHeader("Accept-Encoding", "application/json");
                httpPost.setHeader("Accept-Language", "en-US");
                response = httpClient.execute(httpPost);
                String sresponse = response.getEntity().toString();
                // Log.e("QueingSystem", sresponse);
                Log.e("RESTDone", EntityUtils.toString(response.getEntity()));
                //new Final().execute();

            }
            catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());

            } finally {
                /* nothing to do here */
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (result != null) {
                // do something
            } else {
                // error occured
            }
        }
    }



    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        public Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet("https://murmuring-cove-69371.herokuapp.com/getAthlete/"+IDNumber);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONObject jsono = new JSONObject(data);

                    if(jsono != null){
                        Log.e("JSONAsyncTaskDone",jsono.toString());
                        saveddata =jsono.toString();
                        new REST().execute();
                    }
                    return true;

                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {

                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {

        }

//    protected String doInBackground(String... strings) {
//
//        String response = "";
//        Context context = getApplicationContext();
//        CharSequence text = "Hello toast!";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//
//
//        response = ServiceHandler.findJSONFromUrl("https://murmuring-cove-69371.herokuapp.com/getAthlete/937030045V");
//        String data = response;
//        return response;
//    }


    }


}



