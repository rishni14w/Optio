package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClicked(View view)
    {
        if (view.getId()==R.id.login_btn)
        {
            Intent i= new Intent(this,MainActivity.class);
            startActivity(i);
        }

    }
}
