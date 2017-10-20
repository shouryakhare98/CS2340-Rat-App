package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;
import com.example.shouryakhare.cs2340_rat_app.Model.RatSighting;
import com.example.shouryakhare.cs2340_rat_app.Model.SimpleModel;
import com.example.shouryakhare.cs2340_rat_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Activity to show list view of all rat sightings.
 */
public class LoginSuccessfulActivity extends AppCompatActivity {
    public static String TAG = "MY_APP";

    private Button home;
    private Button reportSighting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successful);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.loginSuccessful_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final TextAdapter textAdapter = new TextAdapter();
        recyclerView.setAdapter(textAdapter);

        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        mRootRef.child("rat_data").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                SimpleModel model = SimpleModel.INSTANCE;
                model.reset();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    RatSighting temp = child.getValue(RatSighting.class);
                    model.addItem(temp);
                }
                readFile();
                textAdapter.setItems(model.getItems());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        home = (Button) findViewById(R.id.loginSuccessful_logoutButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(LoginSuccessfulActivity.this,
                        NewLoginSuccessfulActivity.class);
                startActivity(homeIntent);
            }
        });

        reportSighting = (Button) findViewById(R.id.loginSuccessful_addReportButton);
        reportSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reportSightingIntent = new Intent(LoginSuccessfulActivity.this, ReportSightingActivity.class);
                startActivity(reportSightingIntent);
            }
        });
    }

    /*
     * Read the CSV file and store in SimpleModel class
     */
    public void readFile() {
        SimpleModel model = SimpleModel.INSTANCE;

        try {
            InputStream is = getResources().openRawResource(R.raw.rat_sightings);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                long id = Long.parseLong(tokens[0]);
                long zip = Long.parseLong(tokens[8]);

                double longitude = Double.parseDouble(tokens[tokens.length - 3]);
                double latitude = Double.parseDouble(tokens[tokens.length - 4]);

                model.addItem(new RatSighting(id, tokens[1], tokens[7], zip, tokens[9], tokens[16],
                        tokens[23], longitude, latitude));
            }
            br.close();
        } catch (Exception e) {
            Log.e(LoginSuccessfulActivity.TAG, "error reading assets", e);
        }
    }
}
