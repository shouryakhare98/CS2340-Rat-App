package com.example.shouryakhare.cs2340_rat_app.Model;

import android.content.Context;
import android.util.Log;

import com.example.shouryakhare.cs2340_rat_app.Controller.LoginSuccessfulActivity;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by shouryakhare on 10/5/17.
 * Java class to link with Firebase database and read CSV file.
 */
public class DatabaseHandshake {

    private static DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private static RatSighting sighting;

    /**
     * Method to register a user and add to database.
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @param fullName The full name of the user.
     * @param isAdmin Whether user is admin or not.
     * @return Whether user was added or not.
     */
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

    /**
     * Method to add a sighting to the database.
     * @param locationType Location type of sighting.
     * @param address Address of sighting.
     * @param zip Zip of sighting.
     * @param city City of sighting.
     * @param borough Borough of sighting.
     * @param latitude Latitude of sighting.
     * @param longitude Longitude of sighting.
     * @return Whether sighting was added or not.
     */
    public static boolean addSighting(final String locationType, final String address, final String zip,
                                      final String city, final String borough, String latitude,
                                      String longitude) {
        if (locationType.isEmpty() || address.isEmpty() || zip.isEmpty() || city.isEmpty()
                || borough.isEmpty() || latitude.isEmpty() || longitude.isEmpty()) {
            return false;
        }

        final double latitudeNum;
        final double longitudeNum;

        try {
            latitudeNum = Double.parseDouble(latitude);
            longitudeNum = Double.parseDouble(longitude);
        } catch (NumberFormatException e) {
            return false;
        }

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a");
        final String createdDate = format.format(Calendar.getInstance().getTime());

        final SimpleModel model = SimpleModel.INSTANCE;
        final boolean[] done = {true};

        mRootRef.child("rat_data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int counter = 0;
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    counter++;
                    model.addItem(child.getValue(RatSighting.class));
                }

                sighting = new RatSighting(32000000, createdDate, locationType,
                        Long.parseLong(zip), address, city, borough, latitudeNum, longitudeNum);

                if (counter != 0) {
                    sighting.setUniqueKey(model.getItems().get(counter - 1).getUniqueKey() + 1);
                }

                if (done[0]) {
                    done[0] = false;
                    mRootRef.child("rat_data").child(mRootRef.push().getKey()).setValue(sighting);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return true;
    }

    /**
     * Method to read CSV file with rat data.
     * @param context The context of the activity calling the method (used to open raw file)
     */
    public static void readFile(Context context) {
        SimpleModel model = SimpleModel.INSTANCE;

        try {
            InputStream is = context.getResources().openRawResource(R.raw.rat_sightings);
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
