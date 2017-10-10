package com.example.shouryakhare.cs2340_rat_app.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by shouryakhare on 10/5/17.
 * Java class to link with Firebase database.
 */

public class DatabaseHandshake {

    private static DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    public static boolean registerUser(String username, String password, String fullName, boolean isAdmin) {

        if (!username.trim().isEmpty()
                && !password.trim().isEmpty()
                && !fullName.trim().isEmpty()) {
            User user = new User(fullName, username, password, isAdmin);

            mRootRef.child("users").child(mRootRef.push().getKey()).setValue(user);

            return true;
        }

        return false;
    }
}
