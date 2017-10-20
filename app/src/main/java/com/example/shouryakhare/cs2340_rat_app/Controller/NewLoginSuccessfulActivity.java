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

public class NewLoginSuccessfulActivity extends AppCompatActivity {

    private Button mapView;
    private Button listView;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login_successful);

        mapView = (Button) findViewById(R.id.mainMenu_mapViewButton);
        listView = (Button) findViewById(R.id.mainMenu_listViewButton);
        logout = (Button) findViewById(R.id.mainMenu_logoutButton);

        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listViewIntent = new Intent(NewLoginSuccessfulActivity.this,
                        LoginSuccessfulActivity.class);
                startActivity(listViewIntent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(NewLoginSuccessfulActivity.this,
                        MainActivity.class);
                startActivity(logoutIntent);
            }
        });
    }

}
