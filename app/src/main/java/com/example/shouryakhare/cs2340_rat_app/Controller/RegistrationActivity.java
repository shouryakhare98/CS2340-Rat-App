package com.example.shouryakhare.cs2340_rat_app.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.shouryakhare.cs2340_rat_app.Model.User;
import com.example.shouryakhare.cs2340_rat_app.R;

/**
 * Created by Josh on 10/1/2017.
 */

public class RegistrationActivity extends AppCompatActivity {

    private User user;

    private Button cancel;
    private Button register;
    private TextView usernameTextView;
    private TextView passwordTextView;
    private CheckBox adminBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        register = (Button) findViewById(R.id.registration_confirmButton);
        cancel = (Button) findViewById(R.id.registration_cancelButton);
        usernameTextView = (TextView) findViewById(R.id.register_usernameTextField);
        passwordTextView = (TextView) findViewById(R.id.register_passwordTextField);
        adminBox = (CheckBox) findViewById(R.id.register_adminButton);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User(usernameTextView.getText().toString(), passwordTextView.getText().toString(), adminBox.isChecked());

                Intent registerIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(cancelIntent);
            }
        });

    }
}
