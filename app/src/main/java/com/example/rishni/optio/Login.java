package com.example.rishni.optio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rishni.optio.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }



    public void loginClicked(View view)
    {
        EditText username_edt=(EditText)findViewById(R.id.username_et);
        String username=username_edt.getText().toString();

        EditText pwd_edt=(EditText)findViewById(R.id.pwd_et);
        String password=pwd_edt.getText().toString();

        toastMessage("username is "+username);
        toastMessage("pwd is "+password);

        if (view.getId()==R.id.login_btn)
        {

            Intent i= new Intent(this,MainActivity.class);
            startActivity(i);
        }

    }


    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
