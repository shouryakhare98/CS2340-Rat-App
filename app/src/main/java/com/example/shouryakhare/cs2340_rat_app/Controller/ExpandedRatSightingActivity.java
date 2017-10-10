package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.Model.RatSighting;
import com.example.shouryakhare.cs2340_rat_app.R;

public class ExpandedRatSightingActivity extends AppCompatActivity {

    private TextView heading;
    private TextView date;
    private TextView locationType;
    private TextView zip;
    private TextView address;
    private TextView city;
    private TextView borough;
    private TextView latitude;
    private TextView longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_rat_sighting);

        heading = (TextView) findViewById(R.id.expanded_Heading);
        date = (TextView) findViewById(R.id.expanded_dateTextView);
        locationType = (TextView) findViewById(R.id.expanded_locationTextView);
        zip = (TextView) findViewById(R.id.expanded_zipTextView);
        address = (TextView) findViewById(R.id.expanded_addressTextView);
        city = (TextView) findViewById(R.id.expanded_cityTextView);
        borough = (TextView) findViewById(R.id.expanded_boroughTextView);
        latitude = (TextView) findViewById(R.id.expanded_latitudeTextView);
        longitude = (TextView) findViewById(R.id.expanded_longitudeTextView);

        RatSighting ratSighting = (RatSighting) getIntent().getSerializableExtra("RatSighting");

        heading.setText("Rat Sighting #" + ratSighting.getUniqueKey());
        date.setText(ratSighting.getCreatedDate());
        locationType.setText(ratSighting.getLocationType());
        zip.setText(Long.toString(ratSighting.getIncidentZip()));
        address.setText(ratSighting.getIncidentAddress());
        city.setText(ratSighting.getCity());
        borough.setText(ratSighting.getBorough());
        latitude.setText(Double.toString(ratSighting.getLatitude()));
        longitude.setText(Double.toString(ratSighting.getLongitude()));
    }
}
