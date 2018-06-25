package com.example.rishni.optio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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



        if (view.getId()==R.id.login_btn)
        {

            Intent i= new Intent(this,MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }

    }


    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
