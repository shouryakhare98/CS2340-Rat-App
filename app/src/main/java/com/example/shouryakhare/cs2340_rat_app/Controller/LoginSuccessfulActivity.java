package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

/**
 * Activity to show list view of all rat sightings.
 */
public class LoginSuccessfulActivity extends AppCompatActivity {
    public static String TAG = "MY_APP";

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
                DatabaseHandshake.readFile(getApplicationContext());
                textAdapter.setItems(model.getItems());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Button home;
        home = (Button) findViewById(R.id.loginSuccessful_logoutButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(LoginSuccessfulActivity.this,
                        NewLoginSuccessfulActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
