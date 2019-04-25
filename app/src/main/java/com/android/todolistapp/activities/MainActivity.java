package com.android.todolistapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.todolistapp.R;

public class MainActivity extends AppCompatActivity {

    Button buttonLogin;
    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin=(Button)findViewById(R.id.button_Login);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        String user=editTextEmail.getText().toString();
        String password=editTextPassword.getText().toString().trim();


        if(user.equals("esiles") && password.equals("123456")){
            Intent loinIntent= new Intent(MainActivity.this, HomeActivity.class);
            startActivity(loinIntent);
            Toast.makeText(this,"username and password matched!",Toast.LENGTH_LONG).show();
        }
        else if(user.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Email address can not be empty!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else if(password.length()<6){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Password can not be less than six character!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else{
            Toast.makeText(this,"username and Password not matched!",Toast.LENGTH_LONG).show();
        }
    }
}
