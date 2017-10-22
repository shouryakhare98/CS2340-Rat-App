package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;
import com.example.shouryakhare.cs2340_rat_app.Model.RatSighting;
import com.example.shouryakhare.cs2340_rat_app.Model.SimpleModel;
import com.example.shouryakhare.cs2340_rat_app.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle bundle = getIntent().getExtras();
        final int from = bundle.getInt("fromYear");
        final int till = bundle.getInt("tillYear");

        final SimpleModel model = SimpleModel.INSTANCE;
        model.reset();
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        mRootRef.child("rat_data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    RatSighting temp = child.getValue(RatSighting.class);
                    model.addItem(temp);
                }
                DatabaseHandshake.readFile(getApplicationContext());

                for (RatSighting sighting : model.getItems()) {

                    String date = sighting.getCreatedDate();
                    date = date.split(" ")[0];
                    date = date.split("/")[2];
                    int year = Integer.parseInt(date);

                    if (year >= from && year <= till) {
                        LatLng position = new LatLng(sighting.getLatitude(), sighting.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(position).title(sighting.getUniqueKey()
                                + " " + sighting.getIncidentAddress()));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
