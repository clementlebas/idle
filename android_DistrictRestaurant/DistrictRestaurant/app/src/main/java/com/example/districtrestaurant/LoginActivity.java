package com.example.districtrestaurant;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText login;
    EditText pwd;
    String userlog;
    String userpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button resultat;
        resultat = (Button) findViewById(R.id.loginButton);

        login = (EditText) findViewById (R.id.login);
        pwd = (EditText) findViewById (R.id.password);

        resultat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                userlog = login.getText().toString();
                userpwd = pwd.getText().toString();
                Log.v("Login", userlog);
                Log.v("Pwd", userpwd);

                if(!userlog.equals("clement")) {
                    Toast toast = Toast.makeText(v.getContext(), "User incorrect", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user", userlog);
                    bundle.putString("pwd", userpwd);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}
