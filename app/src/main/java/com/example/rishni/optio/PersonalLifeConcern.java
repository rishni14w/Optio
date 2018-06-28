package com.example.rishni.optio;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalLifeConcern extends AppCompatActivity {

    private RadioButton personal_radio1,personal_radio2,family_radio1,family_radio2,financial_radio1,financial_radio2,future_radio1,future_radio2,retire_radio1,retire_radio2,specific_radio1,specific_radio2;
    private String personal,family,financial,future,retire,specific;

    private CheckBox family_reason1,family_reason2,family_reason3;
    private String family_reason1_s,family_reason2_s,family_reason3_s;

    private CheckBox financial_reason1,financial_reason2;
    private String financial_reason1_s,financial_reason2_s;

    private CheckBox future_reason1,future_reason2;
    private String future_reason1_s,future_reason2_s;

    private CheckBox retire_reason1,retire_reason2,retire_reason3;
    private String retire_reason1_s,retire_reason2_s,retire_reason3_s;

    private CheckBox specific_reason1,specific_reason2,specific_reason3;
    private String specific_reason1_s,specific_reason2_s,specific_reason3_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_life_concern);
        setTitle(R.string.personal_Title);

        //radio button
        personal_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PLC_S1);
        personal_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PLC_S1);

        family_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_PLC_S1);
        family_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_PLC_S1);

        financial_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PLC_S2);
        financial_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PLC_S2);

        future_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PLC_S3);
        future_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PLC_S3);

        retire_radio1=(RadioButton)findViewById(R.id.radioButton1_Q2_PLC_S3);
        retire_radio2=(RadioButton)findViewById(R.id.radioButton2_Q2_PLC_S3);

        specific_radio1=(RadioButton)findViewById(R.id.radioButton1_Q1_PLC_S4);
        specific_radio2=(RadioButton)findViewById(R.id.radioButton2_Q1_PLC_S4);



        personal_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personal=personal_radio1.getText().toString();
            }
        });

        personal_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personal=personal_radio2.getText().toString();
            }
        });


        family_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q2_PLC_S1)
                {
                    TextView radio_yes_PLC_S1_Q2=findViewById(R.id.reason_PLC_S1_Q2_tv);
                    TextView reason_1_PLC_S1_Q2=findViewById(R.id.Reason_1_PLC_S1_Q2_checkBox);
                    TextView reason_2_PLC_S1_Q2=findViewById(R.id.Reason_2_PLC_S1_Q2_checkBox);
                    TextView reason_3_PLC_S1_Q2=findViewById(R.id.Reason_3_PLC_S1_Q2_checkBox);
                    radio_yes_PLC_S1_Q2.setVisibility(View.VISIBLE);
                    reason_1_PLC_S1_Q2.setVisibility(View.VISIBLE);
                    reason_2_PLC_S1_Q2.setVisibility(View.VISIBLE);
                    reason_3_PLC_S1_Q2.setVisibility(View.VISIBLE);
                }

                family=family_radio1.getText().toString();
            }
        });

        family_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q2_PLC_S1)
                {
                    TextView radio_yes_PLC_S1_Q2=findViewById(R.id.reason_PLC_S1_Q2_tv);
                    TextView reason_1_PLC_S1_Q2=findViewById(R.id.Reason_1_PLC_S1_Q2_checkBox);
                    TextView reason_2_PLC_S1_Q2=findViewById(R.id.Reason_2_PLC_S1_Q2_checkBox);
                    TextView reason_3_PLC_S1_Q2=findViewById(R.id.Reason_3_PLC_S1_Q2_checkBox);
                    radio_yes_PLC_S1_Q2.setVisibility(View.GONE);
                    reason_1_PLC_S1_Q2.setVisibility(View.GONE);
                    reason_2_PLC_S1_Q2.setVisibility(View.GONE);
                    reason_3_PLC_S1_Q2.setVisibility(View.GONE);
                }

                family=family_radio2.getText().toString();
            }
        });


        financial_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q1_PLC_S2)
                {
                    TextView radio_yes_PLC_S2_Q1=findViewById(R.id.reason_PLC_S2_Q1_tv);
                    TextView reason_1_PLC_S2_Q1=findViewById(R.id.Reason_1_PLC_S2_Q1_checkBox);
                    TextView reason_2_PLC_S2_Q1=findViewById(R.id.Reason_2_PLC_S2_Q1_checkBox);
                    radio_yes_PLC_S2_Q1.setVisibility(View.VISIBLE);
                    reason_1_PLC_S2_Q1.setVisibility(View.VISIBLE);
                    reason_2_PLC_S2_Q1.setVisibility(View.VISIBLE);
                }
                financial=financial_radio1.getText().toString();
            }
        });

        financial_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q1_PLC_S2)
                {
                    TextView radio_yes_PLC_S2_Q1=findViewById(R.id.reason_PLC_S2_Q1_tv);
                    TextView reason_1_PLC_S2_Q1=findViewById(R.id.Reason_1_PLC_S2_Q1_checkBox);
                    TextView reason_2_PLC_S2_Q1=findViewById(R.id.Reason_2_PLC_S2_Q1_checkBox);
                    radio_yes_PLC_S2_Q1.setVisibility(View.GONE);
                    reason_1_PLC_S2_Q1.setVisibility(View.GONE);
                    reason_2_PLC_S2_Q1.setVisibility(View.GONE);
                }
                financial=financial_radio2.getText().toString();
            }
        });


        future_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q1_PLC_S3)
                {
                    TextView radio_yes_PLC_S3_Q1=findViewById(R.id.reason_PLC_S3_Q1_tv);
                    TextView reason_1_PLC_S3_Q1=findViewById(R.id.Reason_1_PLC_S3_Q1_checkBox);
                    TextView reason_2_PLC_S3_Q1=findViewById(R.id.Reason_2_PLC_S3_Q1_checkBox);
                    radio_yes_PLC_S3_Q1.setVisibility(View.VISIBLE);
                    reason_1_PLC_S3_Q1.setVisibility(View.VISIBLE);
                    reason_2_PLC_S3_Q1.setVisibility(View.VISIBLE);
                }
                future=future_radio1.getText().toString();
            }
        });

        future_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q1_PLC_S3)
                {
                    TextView radio_yes_PLC_S3_Q1=findViewById(R.id.reason_PLC_S3_Q1_tv);
                    TextView reason_1_PLC_S3_Q1=findViewById(R.id.Reason_1_PLC_S3_Q1_checkBox);
                    TextView reason_2_PLC_S3_Q1=findViewById(R.id.Reason_2_PLC_S3_Q1_checkBox);
                    radio_yes_PLC_S3_Q1.setVisibility(View.GONE);
                    reason_1_PLC_S3_Q1.setVisibility(View.GONE);
                    reason_2_PLC_S3_Q1.setVisibility(View.GONE);
                }
                future=future_radio2.getText().toString();
            }
        });


        retire_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q2_PLC_S3)
                {
                    TextView radio_yes_PLC_S2_Q2=findViewById(R.id.reason_PLC_S3_Q2_tv);
                    TextView reason_1_PLC_S2_Q2=findViewById(R.id.Reason_1_PLC_S3_Q2_checkBox);
                    TextView reason_2_PLC_S2_Q2=findViewById(R.id.Reason_2_PLC_S3_Q2_checkBox);
                    TextView reason_3_PLC_S2_Q2=findViewById(R.id.Reason_3_PLC_S3_Q2_checkBox);
                    radio_yes_PLC_S2_Q2.setVisibility(View.VISIBLE);
                    reason_1_PLC_S2_Q2.setVisibility(View.VISIBLE);
                    reason_2_PLC_S2_Q2.setVisibility(View.VISIBLE);
                    reason_3_PLC_S2_Q2.setVisibility(View.VISIBLE);
                }
                retire=retire_radio1.getText().toString();
            }
        });

        retire_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q2_PLC_S3)
                {
                    TextView radio_yes_PLC_S2_Q2=findViewById(R.id.reason_PLC_S3_Q2_tv);
                    TextView reason_1_PLC_S2_Q2=findViewById(R.id.Reason_1_PLC_S3_Q2_checkBox);
                    TextView reason_2_PLC_S2_Q2=findViewById(R.id.Reason_2_PLC_S3_Q2_checkBox);
                    TextView reason_3_PLC_S2_Q2=findViewById(R.id.Reason_3_PLC_S3_Q2_checkBox);
                    radio_yes_PLC_S2_Q2.setVisibility(View.GONE);
                    reason_1_PLC_S2_Q2.setVisibility(View.GONE);
                    reason_2_PLC_S2_Q2.setVisibility(View.GONE);
                    reason_3_PLC_S2_Q2.setVisibility(View.GONE);
                }
                retire=retire_radio2.getText().toString();
            }
        });


        specific_radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton1_Q1_PLC_S4)
                {
                    TextView radio_yes_PLC_S4_Q1=findViewById(R.id.reason_PLC_S4_Q1_tv);
                    TextView reason_1_PLC_S4_Q1=findViewById(R.id.Reason_1_PLC_S4_Q1_checkBox);
                    TextView reason_2_PLC_S4_Q1=findViewById(R.id.Reason_2_PLC_S4_Q1_checkBox);
                    TextView reason_3_PLC_S4_Q1=findViewById(R.id.Reason_3_PLC_S4_Q1_checkBox);
                    radio_yes_PLC_S4_Q1.setVisibility(View.VISIBLE);
                    reason_1_PLC_S4_Q1.setVisibility(View.VISIBLE);
                    reason_2_PLC_S4_Q1.setVisibility(View.VISIBLE);
                    reason_3_PLC_S4_Q1.setVisibility(View.VISIBLE);
                }
                specific=specific_radio1.getText().toString();
            }
        });

        specific_radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.radioButton2_Q1_PLC_S4)
                {
                    TextView radio_yes_PLC_S4_Q1=findViewById(R.id.reason_PLC_S4_Q1_tv);
                    TextView reason_1_PLC_S4_Q1=findViewById(R.id.Reason_1_PLC_S4_Q1_checkBox);
                    TextView reason_2_PLC_S4_Q1=findViewById(R.id.Reason_2_PLC_S4_Q1_checkBox);
                    TextView reason_3_PLC_S4_Q1=findViewById(R.id.Reason_3_PLC_S4_Q1_checkBox);
                    radio_yes_PLC_S4_Q1.setVisibility(View.GONE);
                    reason_1_PLC_S4_Q1.setVisibility(View.GONE);
                    reason_2_PLC_S4_Q1.setVisibility(View.GONE);
                    reason_3_PLC_S4_Q1.setVisibility(View.GONE);
                }
                specific=specific_radio2.getText().toString();
            }
        });

        //checkbox
        //family
        family_reason1=(CheckBox)findViewById(R.id.Reason_1_PLC_S1_Q2_checkBox);
        family_reason2=(CheckBox)findViewById(R.id.Reason_2_PLC_S1_Q2_checkBox);
        family_reason3=(CheckBox)findViewById(R.id.Reason_3_PLC_S1_Q2_checkBox);

        family_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(family_reason1.isChecked())
                {
                    family_reason1_s=family_reason1.getText().toString();
                }
                else
                {
                    family_reason1_s=null;
                }

            }
        });

        family_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(family_reason2.isChecked())
                {
                    family_reason2_s=family_reason2.getText().toString();
                }
                else
                {
                    family_reason2_s=null;
                }

            }
        });

        family_reason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(family_reason3.isChecked())
                {
                    family_reason3_s=family_reason3.getText().toString();
                }
                else
                {
                    family_reason3_s=null;
                }

            }
        });

        //financial
        financial_reason1=(CheckBox)findViewById(R.id.Reason_1_PLC_S2_Q1_checkBox);
        financial_reason2=(CheckBox)findViewById(R.id.Reason_2_PLC_S2_Q1_checkBox);

        financial_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(financial_reason1.isChecked())
                {
                    financial_reason1_s=financial_reason1.getText().toString();
                }
                else
                {
                    financial_reason1_s=null;
                }

            }
        });

        financial_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(financial_reason2.isChecked())
                {
                    financial_reason2_s=financial_reason2.getText().toString();
                }
                else
                {
                    financial_reason2_s=null;
                }

            }
        });


        //future
        future_reason1=(CheckBox)findViewById(R.id.Reason_1_PLC_S3_Q1_checkBox);
        future_reason2=(CheckBox)findViewById(R.id.Reason_2_PLC_S3_Q1_checkBox);

        future_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(future_reason1.isChecked())
                {
                    future_reason1_s=future_reason1.getText().toString();
                }
                else
                {
                    future_reason1_s=null;
                }

            }
        });

        future_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(future_reason2.isChecked())
                {
                    future_reason2_s=future_reason2.getText().toString();
                }
                else
                {
                    future_reason2_s=null;
                }

            }
        });

        //retire
        retire_reason1=(CheckBox)findViewById(R.id.Reason_1_PLC_S3_Q2_checkBox);
        retire_reason2=(CheckBox)findViewById(R.id.Reason_2_PLC_S3_Q2_checkBox);
        retire_reason3=(CheckBox)findViewById(R.id.Reason_3_PLC_S3_Q2_checkBox);

        retire_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(retire_reason1.isChecked())
                {
                    retire_reason1_s=retire_reason1.getText().toString();
                }
                else
                {
                    retire_reason1_s=null;
                }

            }
        });

        retire_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(retire_reason2.isChecked())
                {
                    retire_reason2_s=retire_reason2.getText().toString();
                }
                else
                {
                    retire_reason2_s=null;
                }

            }
        });

        retire_reason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(retire_reason3.isChecked())
                {
                    retire_reason3_s=retire_reason3.getText().toString();
                }
                else
                {
                    retire_reason3_s=null;
                }

            }
        });

        //specific
        specific_reason1=(CheckBox)findViewById(R.id.Reason_1_PLC_S4_Q1_checkBox);
        specific_reason2=(CheckBox)findViewById(R.id.Reason_2_PLC_S4_Q1_checkBox);
        specific_reason3=(CheckBox)findViewById(R.id.Reason_3_PLC_S4_Q1_checkBox);

        specific_reason1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(specific_reason1.isChecked())
                {
                    specific_reason1_s=specific_reason1.getText().toString();
                }
                else
                {
                    specific_reason1_s=null;
                }

            }
        });

        specific_reason2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(specific_reason2.isChecked())
                {
                    specific_reason2_s=specific_reason2.getText().toString();
                }
                else
                {
                    specific_reason2_s=null;
                }

            }
        });

        specific_reason3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(specific_reason3.isChecked())
                {
                    specific_reason3_s=specific_reason3.getText().toString();
                }
                else
                {
                    specific_reason3_s=null;
                }

            }
        });


    }



    

    public void submit_personal(View view)
    {
        if (view.getId()==R.id.submit_personal_btn)
        {
            new PostData(personal,family,family_reason1_s,family_reason2_s,family_reason3_s,financial,financial_reason1_s,financial_reason2_s,future,future_reason1_s,future_reason2_s,retire,retire_reason1_s,retire_reason2_s,retire_reason3_s,specific,specific_reason1_s,specific_reason2_s,specific_reason3_s).execute(db.getAddressAPI_Personal());
        }

    }


    //function to add new personal
    class PostData extends AsyncTask<String,String,String> {
        private String Personal,Family,Family_reason1_s,Family_reason2_s,Family_reason3_s,Financial,Financial_reason1_s,Financial_reason2_s,Future,Future_reason1_s,Future_reason2_s,Retire,Retire_reason1_s,Retire_reason2_s,Retire_reason3_s,Specific,Specific_reason1_s,Specific_reason2_s,Specific_reason3_s;

        public PostData(String personal, String family, String family_reason1_s, String family_reason2_s, String family_reason3_s, String financial, String financial_reason1_s, String financial_reason2_s, String future, String future_reason1_s, String future_reason2_s, String retire, String retire_reason1_s, String retire_reason2_s, String retire_reason3_s, String specific, String specific_reason1_s, String specific_reason2_s, String specific_reason3_s) {
            Personal = personal;
            Family = family;
            Family_reason1_s = family_reason1_s;
            Family_reason2_s = family_reason2_s;
            Family_reason3_s = family_reason3_s;
            Financial = financial;
            Financial_reason1_s = financial_reason1_s;
            Financial_reason2_s = financial_reason2_s;
            Future = future;
            Future_reason1_s = future_reason1_s;
            Future_reason2_s = future_reason2_s;
            Retire = retire;
            Retire_reason1_s = retire_reason1_s;
            Retire_reason2_s = retire_reason2_s;
            Retire_reason3_s = retire_reason3_s;
            Specific = specific;
            Specific_reason1_s = specific_reason1_s;
            Specific_reason2_s = specific_reason2_s;
            Specific_reason3_s = specific_reason3_s;
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
            json += "\t\"personal\":\"" + Personal + "\",\n";
            json += "\t\"family\":\"" + Family + "\",\n";
            json += "\t\"family_reason\": [\"" + Family_reason1_s + "\",\""+Family_reason2_s+"\",\""+Family_reason3_s+"\"],\n";
            json += "\t\"financial\":\"" + Financial + "\",\n";
            json += "\t\"financial_reason\": [\"" + Financial_reason1_s + "\",\""+Financial_reason2_s+"\"],\n";
            json += "\t\"future\":\"" + Future + "\",\n";
            json += "\t\"future_reason\": [\"" + Future_reason1_s + "\",\""+Future_reason2_s+"\"],\n";
            json += "\t\"retire\":\"" + Retire + "\",\n";
            json += "\t\"retire_reason\": [\"" + Retire_reason1_s + "\",\""+Retire_reason2_s+"\",\""+Retire_reason3_s+"\"],\n";
            json += "\t\"specificPersonal\":\"" + Specific + "\",\n";
            json += "\t\"specificPersonal_reason\": [\"" + Specific_reason1_s + "\",\""+Specific_reason2_s+"\",\""+Specific_reason3_s+"\"],\n";
            json += "}";
            hh.PostHTTPData(urlString, json);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            toastMessage("Successfully submitted");
            Intent intent = new Intent(PersonalLifeConcern.this, questionnaire.class);
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
