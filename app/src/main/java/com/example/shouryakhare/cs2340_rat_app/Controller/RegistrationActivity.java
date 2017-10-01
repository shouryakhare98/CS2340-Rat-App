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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Josh on 10/1/2017.
 */

public class RegistrationActivity extends AppCompatActivity {

    private User user;

    private Button cancel;
    private Button register;
    private TextView usernameTextView;
    private TextView passwordTextView;
    private TextView fullNameTextView;
    private CheckBox adminBox;

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        register = (Button) findViewById(R.id.registration_confirmButton);
        cancel = (Button) findViewById(R.id.registration_cancelButton);
        fullNameTextView = (TextView) findViewById(R.id.register_fullNameTextField);
        usernameTextView = (TextView) findViewById(R.id.register_usernameTextField);
        passwordTextView = (TextView) findViewById(R.id.register_passwordTextField);
        adminBox = (CheckBox) findViewById(R.id.register_adminButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User(fullNameTextView.getText().toString(), usernameTextView.getText().toString(),
                        passwordTextView.getText().toString(), adminBox.isChecked());

                mRootRef.child("users").child(String.valueOf(user.getId())).setValue(user);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(cancelIntent);
            }
        });

        /*
        Hides keyboard if a touched outside TextField.
         */
        findViewById(R.id.registrationLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }
}
