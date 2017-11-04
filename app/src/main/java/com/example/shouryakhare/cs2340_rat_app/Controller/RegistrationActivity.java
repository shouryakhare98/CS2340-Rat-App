package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;
import com.example.shouryakhare.cs2340_rat_app.R;

/**
 * Created by Josh on 10/1/2017.
 * Activity to register a user into the database.
 */

public class RegistrationActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private TextView passwordTextView;
    private TextView fullNameTextView;
    private TextView incorrectDetails;
    private CheckBox adminBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button cancel;
        Button register;
        register = (Button) findViewById(R.id.registration_confirmButton);
        cancel = (Button) findViewById(R.id.registration_cancelButton);
        fullNameTextView = (TextView) findViewById(R.id.register_fullNameTextField);
        usernameTextView = (TextView) findViewById(R.id.register_usernameTextField);
        passwordTextView = (TextView) findViewById(R.id.register_passwordTextField);
        incorrectDetails = (TextView) findViewById(R.id.register_incorrectDetailsTextView);
        adminBox = (CheckBox) findViewById(R.id.register_adminButton);

        incorrectDetails.setVisibility(View.INVISIBLE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!DatabaseHandshake.registerUser(usernameTextView.getText().toString(),
                        passwordTextView.getText().toString(),
                        fullNameTextView.getText().toString(),
                        adminBox.isChecked())) {
                    incorrectDetails.setVisibility(View.VISIBLE);
                } else {
                    Intent loginIntent = new Intent(RegistrationActivity.this,
                            LoginSuccessfulActivity.class);
                    startActivity(loginIntent);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent(RegistrationActivity.this,
                        MainActivity.class);
                startActivity(cancelIntent);
            }
        });
    }
}
