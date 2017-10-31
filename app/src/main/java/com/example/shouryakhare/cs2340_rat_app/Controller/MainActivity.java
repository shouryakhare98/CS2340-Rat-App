package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.Model.User;
import com.example.shouryakhare.cs2340_rat_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Main Activity with the login screen and register button.
 */
public class MainActivity extends AppCompatActivity {

    /*
    Widgets needed to get user info.
     */
    private TextView usernameTextView;
    private TextView passwordTextView;
    private TextView incorrectDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Grab widgets from view.
         */
        usernameTextView = (TextView) findViewById(R.id.mainActivity_usernameTextField);
        passwordTextView = (TextView) findViewById(R.id.mainActivity_passwordTextField);
        incorrectDetailsTextView = (TextView) findViewById(R.id.mainActivity_incorrectDetails);

        Button loginButton;
        Button registerButton;
        loginButton = (Button) findViewById(R.id.mainActivity_loginButton);
        registerButton = (Button) findViewById(R.id.mainActivity_registerButton);

        incorrectDetailsTextView.setVisibility(View.INVISIBLE);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference();
                databaseReference.child("users").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        boolean correct = false;

                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            User tempUser = child.getValue(User.class);
                            String usernameEntered = usernameTextView.getText().toString();
                            String passwordEntered = passwordTextView.getText().toString();

                            if (tempUser != null
                                    && usernameEntered.equals(tempUser.getUsername())
                                    && passwordEntered.equals(tempUser.getPassword())) {
                                incorrectDetailsTextView.setVisibility(View.INVISIBLE);
                                Intent loginIntent = new Intent(MainActivity.this,
                                        NewLoginSuccessfulActivity.class);
                                startActivity(loginIntent);
                                correct = true;
                            }
                        }

                        if (!correct) { incorrectDetailsTextView.setVisibility(View.VISIBLE); }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(registerIntent);

            }
        });

        /*
        Hides keyboard if touched outside TextField.
         */
        findViewById(R.id.rootLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }
}
