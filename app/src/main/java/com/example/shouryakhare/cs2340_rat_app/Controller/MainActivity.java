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

public class MainActivity extends AppCompatActivity {

    /*
    User class object.
     */
    private User user;

    /*
    Widgets needed to get user info.
     */
    private TextView usernameTextView;
    private TextView passwordTextView;
    private TextView incorrectDetailsTextView;
    private Button loginButton;
    private Button registerButton;

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
        loginButton = (Button) findViewById(R.id.mainActivity_loginButton);
        registerButton = (Button) findViewById(R.id.mainActivity_registerButton);

        incorrectDetailsTextView.setVisibility(View.INVISIBLE);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                user = new User(usernameTextView.getText().toString(), passwordTextView.getText().toString());

                if (!user.getUsername().trim().isEmpty() && !user.getPassword().isEmpty()) {
                    if (user.getUsername().equals("user") && user.getPassword().equals("pass")) {
                        Intent loginIntent = new Intent(MainActivity.this,
                                LoginSuccessfulActivity.class);
                        startActivity(loginIntent);
                    } else {
                        incorrectDetailsTextView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

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
