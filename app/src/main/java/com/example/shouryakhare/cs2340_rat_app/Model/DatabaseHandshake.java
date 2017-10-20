package com.example.shouryakhare.cs2340_rat_app.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public static boolean addSighting(String locationType, String address, String zip, String city,
                                   String borough, String latitude, String longitude) {
        if (locationType.isEmpty() || address.isEmpty() || zip.isEmpty() || city.isEmpty()
                || borough.isEmpty() || latitude.isEmpty() || longitude.isEmpty()) {
            return false;
        }

        double latitudeNum;
        double longitudeNum;

        try {
            latitudeNum = Double.parseDouble(latitude);
            longitudeNum = Double.parseDouble(longitude);
        } catch (NumberFormatException e) {
            return false;
        }

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a");
        String createdDate = format.format(Calendar.getInstance().getTime());

        RatSighting sighting = new RatSighting(RatSighting.uniqueId, createdDate, locationType,
                Long.parseLong(zip), address, city, borough, latitudeNum, longitudeNum);

        mRootRef.child("rat_data").child(mRootRef.push().getKey()).setValue(sighting);

        return true;
    }
}
