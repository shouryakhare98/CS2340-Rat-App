package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.Model.RatSighting;
import com.example.shouryakhare.cs2340_rat_app.R;

/**
 * Activity to show all details about a rat sighting.
 */
public class ExpandedRatSightingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_rat_sighting);

        TextView heading;
        TextView date;
        TextView locationType;
        TextView zip;
        TextView address;
        TextView city;
        TextView borough;
        TextView latitude;
        TextView longitude;

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

        String headingText = "Rat Sighting #" + ratSighting.getUniqueKey();
        heading.setText(headingText);

        date.setText(ratSighting.getCreatedDate());

        locationType.setText(ratSighting.getLocationType());

        zip.setText(String.valueOf(ratSighting.getIncidentZip()));

        address.setText(ratSighting.getIncidentAddress());

        city.setText(ratSighting.getCity());

        borough.setText(ratSighting.getBorough());

        latitude.setText(String.valueOf(ratSighting.getLatitude()));

        longitude.setText(String.valueOf(ratSighting.getLongitude()));
    }
}
