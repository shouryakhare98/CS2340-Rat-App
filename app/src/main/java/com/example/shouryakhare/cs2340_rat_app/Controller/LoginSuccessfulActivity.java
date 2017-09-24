package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.shouryakhare.cs2340_rat_app.R;

public class LoginSuccessfulActivity extends AppCompatActivity {

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successful);

        logout = (Button) findViewById(R.id.loginSuccessful_logoutButton);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(LoginSuccessfulActivity.this, MainActivity.class);
                startActivity(logoutIntent);
            }
        });
    }

}
