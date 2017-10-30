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
    private Button graphView;
    private Button listView;
    private Button logout;
    private Button reportSighting;

    private EditText fromYearMap;
    private EditText tillYearMap;
    private TextView incorrectYearsMap;

    private EditText fromYearGraph;
    private EditText tillYearGraph;
    private TextView incorrectYearsGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login_successful);

        mapView = (Button) findViewById(R.id.mainMenu_mapViewButton);
        graphView = (Button) findViewById(R.id.mainMenu_graphViewButton);
        listView = (Button) findViewById(R.id.mainMenu_listViewButton);
        logout = (Button) findViewById(R.id.mainMenu_logoutButton);
        reportSighting = (Button) findViewById(R.id.mainMenu_reportSightingButton);

        fromYearMap = (EditText) findViewById(R.id.mainMenu_fromYearEditText);
        tillYearMap = (EditText) findViewById(R.id.mainMenu_tillYearEditText);
        incorrectYearsMap = (TextView) findViewById(R.id.mainMenu_incorrectYearTextView);
        incorrectYearsMap.setVisibility(View.INVISIBLE);

        fromYearGraph = (EditText) findViewById(R.id.mainMenu_fromYearGraphEditText);
        tillYearGraph = (EditText) findViewById(R.id.mainMenu_tillYearGraphEditText);
        incorrectYearsGraph = (TextView) findViewById(R.id.mainMenu_incorrectDetailsTextView2);
        incorrectYearsGraph.setVisibility(View.INVISIBLE);

        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int from = Integer.parseInt(fromYearMap.getText().toString().trim());
                    int till = Integer.parseInt(tillYearMap.getText().toString().trim());
                    Intent mapViewIntent = new Intent(NewLoginSuccessfulActivity.this,
                            MapsActivity.class);
                    mapViewIntent.putExtra("fromYear", from);
                    mapViewIntent.putExtra("tillYear", till);
                    incorrectYearsMap.setVisibility(View.INVISIBLE);
                    incorrectYearsGraph.setVisibility(View.INVISIBLE);
                    startActivity(mapViewIntent);

                } catch (NumberFormatException e) {
                    incorrectYearsMap.setVisibility(View.VISIBLE);
                }
            }
        });

        graphView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int from = Integer.parseInt(fromYearGraph.getText().toString().trim());
                    int till = Integer.parseInt(tillYearGraph.getText().toString().trim());
                    Intent mapViewIntent = new Intent(NewLoginSuccessfulActivity.this,
                            GraphViewActivity.class);
                    mapViewIntent.putExtra("fromYear", from);
                    mapViewIntent.putExtra("tillYear", till);
                    incorrectYearsGraph.setVisibility(View.INVISIBLE);
                    incorrectYearsMap.setVisibility(View.INVISIBLE);
                    startActivity(mapViewIntent);

                } catch (NumberFormatException e) {
                    incorrectYearsGraph.setVisibility(View.VISIBLE);
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
