package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.R;

public class NewLoginSuccessfulActivity extends AppCompatActivity {

    private Button mapView;
    private Button listView;
    private Button logout;
    private Button reportSighting;
    private EditText fromYear;
    private EditText tillYear;
    private TextView incorrectYears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login_successful);

        mapView = (Button) findViewById(R.id.mainMenu_mapViewButton);
        listView = (Button) findViewById(R.id.mainMenu_listViewButton);
        logout = (Button) findViewById(R.id.mainMenu_logoutButton);
        reportSighting = (Button) findViewById(R.id.mainMenu_reportSightingButton);
        fromYear = (EditText) findViewById(R.id.mainMenu_fromYearEditText);
        tillYear = (EditText) findViewById(R.id.mainMenu_tillYearEditText);
        incorrectYears = (TextView) findViewById(R.id.mainMenu_incorrectYearTextView);

        incorrectYears.setVisibility(View.INVISIBLE);

        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int from = Integer.parseInt(fromYear.getText().toString().trim());
                    int till = Integer.parseInt(tillYear.getText().toString().trim());
                    Intent mapViewIntent = new Intent(NewLoginSuccessfulActivity.this,
                            MapsActivity.class);
                    mapViewIntent.putExtra("fromYear", from);
                    mapViewIntent.putExtra("tillYear", till);
                    startActivity(mapViewIntent);

                } catch (NumberFormatException e) {
                    incorrectYears.setVisibility(View.VISIBLE);
                }
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

        reportSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reportSightingIntent = new Intent(NewLoginSuccessfulActivity.this,
                        ReportSightingActivity.class);
                startActivity(reportSightingIntent);
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

         /*
        Hides keyboard if touched outside TextField.
         */
        findViewById(R.id.mainMenuLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }

}
