package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shouryakhare.cs2340_rat_app.Model.RatSighting;
import com.example.shouryakhare.cs2340_rat_app.Model.SimpleModel;
import com.example.shouryakhare.cs2340_rat_app.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LoginSuccessfulActivity extends AppCompatActivity {
    public static String TAG = "MY_APP";

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successful);

        readFile();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.loginSuccessful_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextAdapter textAdapter = new TextAdapter();
        recyclerView.setAdapter(textAdapter);

        SimpleModel model = SimpleModel.INSTANCE;
        textAdapter.setItems(model.getItems());

        logout = (Button) findViewById(R.id.loginSuccessful_logoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(LoginSuccessfulActivity.this, MainActivity.class);
                startActivity(logoutIntent);
            }
        });
    }

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
