package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class IllnessAndInjuryConcern extends AppCompatActivity {

    private RadioButton sick_radio1,sick_radio2,injured_radio1,injured_radio2,injured_again_radio1,injured_again_radio2,pain_radio1,pain_radio2,partner_injury_radio1,partner_injury_radio2,nightmare_radio1,nightmare_radio2,flashback_radio1,flashback_radio2;

    private String sick,injured,injured_again,pain,partner_injury,nightmare,flashback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness_and_injury_concern);
        setTitle(R.string.illness_Title);

        sick_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_IIC);
        sick_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_IIC);

        injured_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_IIC);
        injured_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_IIC);

        injured_again_radio1=(RadioButton)findViewById(R.id.radioButton1_Q3_IIC);
        injured_again_radio2=(RadioButton)findViewById(R.id.radioButton2_Q3_IIC);

        pain_radio1=(RadioButton)findViewById(R.id.radioButton1_Q4_IIC);
        pain_radio2=(RadioButton)findViewById(R.id.radioButton2_Q4_IIC);

        partner_injury_radio1=(RadioButton)findViewById(R.id.radioButton1_Q5_IIC);
        partner_injury_radio2=(RadioButton)findViewById(R.id.radioButton2_Q5_IIC);

        nightmare_radio1=(RadioButton)findViewById(R.id.radioButton1_Q6_IIC);
        nightmare_radio2=(RadioButton)findViewById(R.id.radioButton2_Q6_IIC);

        flashback_radio1=(RadioButton)findViewById(R.id.radioButton1_Q7_IIC);
        flashback_radio2=(RadioButton)findViewById(R.id.radioButton2_Q7_IIC);

        sick_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sick=sick_radio1.getText().toString();
            }
        });

        sick_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sick=sick_radio2.getText().toString();
            }
        });


        injured_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                injured=injured_radio1.getText().toString();
            }
        });

        injured_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                injured=injured_radio2.getText().toString();
            }
        });


        injured_again_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                injured_again=injured_again_radio1.getText().toString();
            }
        });

        injured_again_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                injured_again=injured_again_radio2.getText().toString();
            }
        });


        pain_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pain=pain_radio1.getText().toString();
            }
        });

        pain_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pain=pain_radio2.getText().toString();
            }
        });


        partner_injury_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                partner_injury=partner_injury_radio1.getText().toString();
            }
        });

        partner_injury_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                partner_injury=partner_injury_radio2.getText().toString();
            }
        });


        nightmare_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nightmare=nightmare_radio1.getText().toString();
            }
        });

        nightmare_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nightmare=nightmare_radio2.getText().toString();
            }
        });


        flashback_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashback=flashback_radio1.getText().toString();
            }
        });

        flashback_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashback=flashback_radio2.getText().toString();
            }
        });
    }

    public void submit_illness_injury(View view)
    {
        if (view.getId()==R.id.submit_illness_injury_btn)
        {
            new PostData(sick,injured,injured_again,pain,partner_injury,nightmare,flashback).execute(db.getAddressAPI_IllnessInjury());
        }

    }

    //function to add new vaccination
    class PostData extends AsyncTask<String,String,String> {
        private String Sick,Injured,Injured_again,Pain,Partner_injury,Nightmare,Flashback;

        public PostData(String sick, String injured, String injured_again, String pain, String partner_injury, String nightmare, String flashback) {
            Sick = sick;
            Injured = injured;
            Injured_again = injured_again;
            Pain = pain;
            Partner_injury = partner_injury;
            Nightmare = nightmare;
            Flashback = flashback;
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
            json += "\t\"sick\":\"" + Sick + "\",\n";
            json += "\t\"injured\":\"" + Injured + "\",\n";
            json += "\t\"injuredAgain\":\"" + Injured_again + "\",\n";
            json += "\t\"partner_in_pain\":\"" + Pain + "\",\n";
            json += "\t\"partner_injury\":\"" + Partner_injury + "\",\n";
            json += "\t\"nightmare\":\"" + Nightmare + "\",\n";
            json += "\t\"flashback\":\"" + Flashback + "\",\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            toastMessage("Successfully submitted");
            Intent intent = new Intent(IllnessAndInjuryConcern.this, questionnaire.class);
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
