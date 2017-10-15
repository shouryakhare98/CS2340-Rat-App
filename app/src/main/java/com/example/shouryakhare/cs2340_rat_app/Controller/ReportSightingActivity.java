package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;
import com.example.shouryakhare.cs2340_rat_app.R;

public class ReportSightingActivity extends AppCompatActivity {

    private TextView locationType;
    private TextView address;
    private TextView zip;
    private TextView city;
    private TextView borough;
    private TextView latitude;
    private TextView longitude;
    private TextView incorrectDetails;

    private Button submit;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_sighting);

        locationType = (TextView) findViewById(R.id.reportSighting_locationTypeEditText);
        address = (TextView) findViewById(R.id.reportSighting_addressEditText);
        city = (TextView) findViewById(R.id.reportSighting_cityEditText);
        zip = (TextView) findViewById(R.id.reportSighting_zipEditText);
        borough = (TextView) findViewById(R.id.reportSighting_boroughEditText);
        latitude = (TextView) findViewById(R.id.reportSighting_latitudeEditText);
        longitude = (TextView) findViewById(R.id.reportSighting_longitudeEditText);
        incorrectDetails = (TextView) findViewById(R.id.reportSighting_incorrectDetailsTextView);
        incorrectDetails.setVisibility(View.INVISIBLE);

        submit = (Button) findViewById(R.id.reportSighting_submitButton);
        cancel = (Button) findViewById(R.id.reportSighting_cancelButton);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent(ReportSightingActivity.this,
                        LoginSuccessfulActivity.class);
                startActivity(cancelIntent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitPressed();
            }
        });

        /*
        Hides keyboard if touched outside TextField.
         */
        findViewById(R.id.reportLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });

        /*
        Hides keyboard if touched outside TextField.
         */
        findViewById(R.id.constraintLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }

    public void onSubmitPressed() {
        String locationType = this.locationType.getText().toString().trim();
        String address = this.address.getText().toString().trim();
        String zip = this.zip.getText().toString().trim();
        String city = this.city.getText().toString().trim();
        String borough = this.borough.getText().toString().trim();
        String latitude = this.latitude.getText().toString().trim();
        String longitude = this.longitude.getText().toString().trim();

        if (!DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude,
                longitude)) {
            incorrectDetails.setVisibility(View.VISIBLE);
        } else {
            Intent doneIntent = new Intent(ReportSightingActivity.this,
                    LoginSuccessfulActivity.class);
            startActivity(doneIntent);
        }
    }
}
