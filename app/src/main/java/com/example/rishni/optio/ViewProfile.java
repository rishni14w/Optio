package com.example.rishni.optio;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.amazonaws.services.machinelearning.*;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.machinelearning.model.EntityStatus;
import com.amazonaws.services.machinelearning.model.GetMLModelRequest;
import com.amazonaws.services.machinelearning.model.GetMLModelResult;
import com.amazonaws.services.machinelearning.model.PredictRequest;
import com.amazonaws.services.machinelearning.model.PredictResult;
import com.amazonaws.services.machinelearning.model.RealtimeEndpointStatus;

import java.util.HashMap;

public class ViewProfile extends AppCompatActivity {

    TextView currentWeight;
    TextView currentHeight;
    TextView name;
    TextView playedSince;
    private static final String LOG_TAG = "viewProfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("AthletePref",0);
        currentWeight = (TextView)findViewById(R.id.textViewCWeight);
        currentHeight = (TextView)findViewById(R.id.textViewCHeight);
        name = (TextView)findViewById(R.id.textViewAthleteName);
        playedSince = (TextView)findViewById(R.id.textViewMemberSince);
        currentHeight.setText(preferences.getString("AthleteHeight",null));
        name.setText(preferences.getString("AthleteName",null));
        playedSince.setText(preferences.getString("AthleteJoinedDate",null));
        currentWeight.setText(preferences.getString("AthleteWeight",null));
        //TODO: Uncomment the line when the token is figured out
        //new BackgroundTask().execute();
        // Use a created model that has a created real-time endpoint


// Do something with the prediction
// ...
    }
    class BackgroundTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {

            // Initialize the Amazon Cognito credentials provider
            CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                    getApplicationContext(),
                    "us-east-1:7fd77521-4fcb-44e0-b81b-cf41269dd5e0", // Identity pool ID
                    Regions.US_EAST_1 // Region
            );
            AmazonMachineLearningClient client = new AmazonMachineLearningClient(credentialsProvider);
            String mlModelId = "ml-4mpwEAck5FN";

            // Call GetMLModel to get the realtime endpoint URL
            GetMLModelRequest getMLModelRequest = new GetMLModelRequest();
            getMLModelRequest.setMLModelId(mlModelId);
            GetMLModelResult mlModelResult = client.getMLModel(getMLModelRequest);

            // Validate that the ML model is completed
            if (!mlModelResult.getStatus().equals(EntityStatus.COMPLETED.toString())) {
                System.out.println("ML Model is not completed: " + mlModelResult.getStatus());
              //  return;
            }

            // Validate that the realtime endpoint is ready
            if (!mlModelResult.getEndpointInfo().getEndpointStatus().equals(RealtimeEndpointStatus.READY.toString())){
                System.out.println("Realtime endpoint is not ready: " + mlModelResult.getEndpointInfo().getEndpointStatus());
                //return;
            }
            // Create a Predict request with your ML model ID and the appropriate Record mapping
            PredictRequest predictRequest  = new PredictRequest();
            predictRequest.setMLModelId(mlModelId);

            HashMap<String, String> record = new HashMap<String, String>();
            record.put("Sex", "0");
            record.put("Age","21");
            record.put("Height(cm)","158");


            predictRequest.setRecord(record);
            predictRequest.setPredictEndpoint(mlModelResult.getEndpointInfo().getEndpointUrl());

// Call Predict and print out your prediction
            PredictResult predictResult = client.predict(predictRequest);
            Log.d(LOG_TAG, predictResult.getPrediction().toString());
            return null;
        }
    }
}
